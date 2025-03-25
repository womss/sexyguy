-- 엄청난 시행착오를 겪어서 => DB를 설치
-- CMD기반 sqlplus를 다뤄보면서 DBA들이 하는 업무를 살짝 맛봤음
--	(계정 생성, 권한 부여, tablespace)
-- 간단한 용어정리 (테이블 / 행 / 열 / 스키마 / 인스턴스 / 도메인)
-- SQL의 명령문 중 정의어(DDL)를 다루면서 데이블을 만들어봤고
-- 테이블 생성시 필요한 자료형(주력으로 사용하는 것만 정리↓)
--	문자형 : varchar2 / 숫자형 : number / 날짜 : date
--		문자형 varchar2에 용량 입력할 때는 char를 넣어서
--			글자 단위로 넣을 수 있게 하자!
--		숫자형 number에 용량을 입력할 때는
--			정밀도 / 범위 잘 조절해서 만들자!
--		날짜 date...는 곧 볼 것!!
-- 상당히 어려웠던 제약조건 !
--		not null, primary key, foreign key
-- 테이블의 구조를 수정하거나, 삭제해보면서 DDL 완료!
----------------------------------------------------------------------

-- 과자 테이블을 만들건데
-- 과자 이름, 회사, 가격 정보를 넣고 싶다
-- 테이블 하나에 PK 하나 있었으면...!

-- 초코파이
--	=> 회사 : 오리온 / 롯데
--	과자 이름 : 단일한 값이 될 수 없음 (PK X)
--	회사 이름 : 한 회사에서 1가지 종류의 과자만 만드는 것은 아님 (PK X)
--	가격 : 같은 가격의 과자가 있을 수도 있음 (PK X)
--	PK를 어디에...????
--	번호값을 만들어서 여기에 PK를 주는 것도 한 방법!
create table dec26_snack(
	s_no number(4) primary key,
	s_name varchar2(10 char) not null,
	s_maker varchar2(10 char) not null,
	s_price number(5) not null
);
-------------------------------------------------------------------
-- DML은 데이터 조작어(Data Manipulation Language)라고 하고, // 우리가 제일 많이 사용할 파트
-- 테이블에 데이터를 검색, 삽입, 수정, 삭제 하는데 사용되는 문장
-- select, insert, update, delete 등이 있고,
--	줄여서 CRUD (create read update delete) 라고 함
--		여기서의 C는 (create table 개념 아님 - X (DBA의 작업))
--		데이터를 만든다는 의미의  C (insert - O)
-- 형태는
insert into 테이블명(컬럼명, 컬럼명, ...) values(값, 값, ...); -- 나열한 컬럼명 대로 값을 넣으면 됨 

insert into dec26_snack(s_no, s_name, s_maker, s_price)
					values(1, '초코파이', '오리온', 5000);

-- 컬럼 순서 바꾸기 - ?! 됨 !!!
insert into dec26_snack(s_name, s_price, s_no, s_maker)
					values('새콤달콤', 700, 2, '롯데');
					
-- 컬럼에 값 안넣기 - ?! 에러 !, 왜 에러? - Not Null 때문에
-- 제약조건에 Not null이 없었다면, 값은 들어갔을 것이고,
-- 지정해주지 않은 컬럼에 대해서는 null값이 들어감
-- 그런데 가급적이면 값들이 다 들어가있었으면 좋겠음 ~
insert into dec26_snack(s_name, s_no) values('마이쮸', 3);

-- 42번줄 형태는 너무 김 / (컬럼명, 컬럼명, ...)안넣고 컬럼 순서대로 넣는 방법도 !
insert into 테이블명 values(값, 값, ...); -- 컬럼 생략하고 값을 바로 순서대로
insert into dec26_snack values(4, '엄마손파이', '롯데', 4000);
----------------------------------------------------------------------------
-- 테이블 지우고, 다시 생성해서 값 5개정도 넣어봅시다!
drop table dec26_snack cascade constraint purge;

insert into dec26_snack values(1, '초코파이', '롯데', 4000);
insert into dec26_snack values(2, '초코파이', '오리온', 4000);
insert into dec26_snack values(3, '스윙칩', '롯데', 2300);
insert into dec26_snack values(4, '치토스', '오리온', 1700);
insert into dec26_snack values(5, '자가비', '일본', 3000);
select * from dec26_snack;

-- 그런데... 지금이야 5개 넣어서 일일히 과자들 번호값을 주면 됐는데
--	과자의 종류가 엄청나게 많이 있죠
--	과자 데이터를 계속 넣다가 나중에 몇번인지 잊어버리면...?
--	데이터를 만들때마다 과자의 번호가 자동으로 계산이 되었으면 좋겠음 !

-- factory pattern! 공장화 시스템!
--	MYSQL : Autoincrement 옵션
--	현재 우리가 사용하고 있는 Oracle DB : Sequence라는 것이 있음
--	번호를 순서에 맞게 자동으로 생성해주는건데
--	테이블과는 무관하고, 단점으로는 insert에 실패해도
--		sequence 값은 무조건 올라감
--	그리고, 증가된 값을 다시 내릴 수 없음

-- sequence(table과는 무관한) 생성
create sequence 시퀀스명;		-- 간단한 시퀀스
-- 일반적으로 테이블명 뒤에 _seq를 붙여주는 문화가 있음
create sequence dec26_snack_seq; -- 시퀀스 붙인거 사용하기 전에 이거 한번 해야함 108번 줄처럼

-- 구체적인 시퀀스
create sequnce 시퀀스명
	increment by 1		-- 증가값 (1씩 증가)
	start with 1		-- 시작값
	minvalue 크기		-- 최소값 (기본값 1)
	maxvalue 크기		-- 최대값 (기본값 10^27 - 1)
	nocycle / cycle		-- 최대값에 도달하면 시작값부터 다시
						--	반복할지 말지 (기본값 nocycle)
	nocache / cache 크기	-- 시퀀스를 미리 만들어놓고 메모리에서
						--	가져다 쓸지말지 (기본값 cache 20)
	noorder / order;	-- 요청 순서대로 값을 생성할지 말지
						--		기본값 (nooder)

-- sequence 삭제
drop sequence 시퀀스명;

-- sequence 사용 : 시퀀스명.nextval

create sequence dec26_snack_seq;
insert into dec26_snack values(dec26_snack_seq.nextval, '초코파이', '롯데', 4000);
insert into dec26_snack values(dec26_snack_seq.nextval, '초코파이', '오리온', 4000);
insert into dec26_snack values(dec26_snack_seq.nextval, '스윙칩', '롯데', 2300);
insert into dec26_snack values(dec26_snack_seq.nextval, '치토스', '오리온', 170000000);
insert into dec26_snack values(dec26_snack_seq.nextval, '자가비', '일본', 3000);
select * from dec26_snack;

drop table dec26_snack cascade constraint purge;
drop sequence dec26_snack_seq;
-------------------------------------------------------------------------------------
create table dec26_snack(
	s_no number(4) primary key,
	s_name varchar2(10 char) not null,
	s_maker varchar2(10 char) not null,
	s_price number(5) not null,
	s_exp date not null
);
create sequence dec26_snack_seq;

select sysdate from dual;
insert into dec26_snack values(dec26_snack_seq.nextval, '새콤달콤 딸기맛', '크라운', 700, sysdate);

-- 특정시간 / 날짜 
--		내장함수 - to_date('값', '패턴')
--		패턴(대문자) - YYYY, MM, DD, AM/PM,
--					HH(12시간), HH24(추천), MI(분), SS(초)
insert into dec26_snack values(dec26_snack_seq.nextval, '새콤달콤 딸기맛', '크라운', 700,
										to_date('2024-12-28 14', 'YYYY-MM-DD HH24'));

-- 이제 값들을 막 넣어주세요
-- 회사 3-4개 제한 / 유통기한 자유롭게 / 과자이름 겹치게
insert into dec26_snack values(dec26_snack_seq.nextval, '허니버터 감자칩', '오리온', 2400,
										to_date('2025-02-28 14', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '빼빼로', '롯데', 1800,
										to_date('2025-04-17 18', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '빼빼로 아몬드', '롯데', 1800,
										to_date('2025-04-25 18', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '감자칩', '크라운', 1600,
										to_date('2025-06-27 21', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '초코파이', '롯데', 4000,
										to_date('2025-08-15 16', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '초코파이', '크라운', 3800,
										to_date('2025-07-20 18', 'YYYY-MM-DD HH24'));
--
insert into dec26_snack values(dec26_snack_seq.nextval, '오징어땅콩', '오리온', 1600,
										to_date('2025-07-15 15', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '바나나킥', '오리온', 1500,
										to_date('2025-07-21 10', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '신짱', '롯데', 1700,
										to_date('2025-05-06 16', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '썬칩', '크라운', 1400,
										to_date('2025-03-26 21', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '칸쵸', '크라운', 1200,
										to_date('2025-04-23 22', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '쿠크다스', '크라운', 2400,
										to_date('2025-02-12 16', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '콘칩', '크라운', 1800,
										to_date('2025-08-17 18', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '꽃게랑', '크라운', 1600,
										to_date('2025-07-16-15', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '자갈치', '오리온', 1800,
										to_date('2025-05-24 13', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '포스틱', '크라운', 2100,
										to_date('2025-02-19 10', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '고래밥', '크라운', 950,
										to_date('2025-04-27 16', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '오징어집', '오리온', 1300,
										to_date('2025-07-08 21', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '오!감자', '크라운', 1700,
										to_date('2025-06-16 22', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '초코송이', '오리온', 900,
										to_date('2025-05-26 14', 'YYYY-MM-DD HH24'));
insert into dec26_snack values(dec26_snack_seq.nextval, '땅콩강정', '롯데', 1200,
										to_date('2025-02-28 15', 'YYYY-MM-DD HH24'));
------------------------------------------------------------------------------------------------
-- R (Read) ★★★★★ 중요 ★★★★★
select [distinct] [컬럼명], [컬럼명 as 별칠 || 컬럼명 별칭],
	[연산자 사용], [통계함수], ...
	from [테이블명]
	where [조건식]
	group by [그룹대상]
	having [함수 포함 조건]
	order by [정렬대상 ASC | DESC (오름차순 | 내림차순)];
	-- 기본값은 오름차순 // 중간중간 빠져나가는 건 있지만 순서는 꼭 지켜야함
-- 의 형태!


-- 과자테이블 전체 조회
-- '*' : 테이블 내의 모든 컬럼을 가져온다
select * from dec26_snack;

-- distinct : 중복 제거
select s_maker from dec26_snack; -- 과자별로 회사가 나오는데
select distinct s_maker from dec26_snack; -- 중복 제거 + 한개씩만 나옴

-- 컬럼명 그대로 뽑아오고 싶은 컬럼명을 쓰면 되고
-- 별칭 같은 경우에는... select문 안에서 숫자 계산이 가능(+ - * /)
select s_price / 100 from dec26_snack;
-- 컬럼명 자체가 s_price로 나오지 않고 s_price/100으로 나옴
-- 실제 프로그래밍 언어와 연동하다보면 컬럼명을 이용해서
--	값을 불러오는 경우가 있는데,
-- 별칭이라는 것을 써서 헷갈림을 방지하는 용도로 사용

-- 그래서 s_price/100이 안나오게 하는 법
-- AS를 써서 하는 법
select s_price / 100 as s_price from dec26_snack;
-- 컬럼명을 띄어쓰기하고 바로 별칭쓰는 법 (선호v)
select s_price / 100 s_price from dec26_snack;

-- 연산자 (산술연산자)
-- Dual 테이블
--	1. 오라클 자체에서 제공해주는 더미테이블
--	2. 간단하게 함수를 이용해서 계산 결과값을 확인할 때 사용하는 테이블 // 일회성으로 결과만 보여주고 사라지는 테이블

-- 어떤 값이 나올까 ? / 13?() 4?() 에러?()
select 1 + '3' from dual;
-- 4 가 나옴 !
-- 대부분 다른 언어들 같은 경우에는 '문자 우선'으로 진행 '13'이라는 결과가 나옴
-- 오라클에서는 반대로 '숫자 우선'
-- 오라클 내에서는 연산자가 숫자만 연산해줌

select 1 + 'a' from dual; -- 에러 ! ('invalid number')

-- 문자를 이어주기 위한 연산자가 따로 있는데
--	바로 ' || ' (shift + \)
select 1 || 'a' from dual; -- = 1a
select 1 || '3' from dual; -- = 13





































