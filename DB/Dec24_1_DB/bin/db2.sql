-- [옵션]
--	제약조건 (Constraint) 이라고 부름
--	데이터 무결성을 보장하기 위한 용도로 사용!
--	데이터 무결성 : 데이터베이스에 저장된 데이터의 일관성과 정확성을 지키는 것

--	1. 도메인 무결성 제약조건 // 정보처리 자격증 관련해서 당장 ㄴㄴ - 알아만두고 ㅇㅇ - 잘 알아놔야 
--		도메인 제약 (Domain Constraint)이라고도 하며,
--		테이블 내의 튜플들이 각 속성의 도메인에 지정된 값만 가져야한다 
--		데이터 타입(type), 널(null / not null) ★★★ 낫 널 중요 ★★★
--		기본값(default), 체크(check) 등을 활용해서 지정

--	2. 개체 무결성 제약조건
--		기본키 제약(Primary Key Constraint)라고도 함
--		개체(Entity) : 사람, 사물, 장소, 사건 등과 같이
--						독립적으로 존재하면서,
--						고유하게 식별이 가능한 단위 // 자바에서 객체와 같이 유사하다고 보면 된다
--		아무리 많은 개체가 있어도, 내가 원하는 '유일한' 개체를
--			발견할 수 있어야 한다!
--		테이블은 기본키를 지정하고, null값을 가져서는 안되며, // 비어있으면 안되며
--			테이블 내에 오직 하나의 값만 존재해야한다 라는 조건!

--	3. 참조 무결성 제약조건
--		외래키 제약(Foreign Key Constriant)이라고도 하며,
--		테이블 간의 참조 관계를 선언하는 제약조건
--		참조받는 테이블(Parent Table)의 값은
--			기본키(Primary Key)나 고유키(Unique Key)여야 하며,
--		참조하는 테이블 (Child Table)의 외래키(Foreign Key)가
--			연결이 됨
--		참조받는 테이블의 값 변경시,
--		참조 무결성 제약조건에 따라 참조하는 테이블의
--		값이 영향을 받거나 제한됨
----------------------------------------------------------------------------------------
-- 1. Not Null : NULL은 값이 비어있다는 뜻 !					★★★★★ 꼭 안고가야하는 것 ★★★★★
--			=> 0이나 띄어쓰기도 아닌 정말 값을 넣지 않은 상태
--			Null을 허용하지 않는다.
--			=> 필수적으로 입력해야 할 컬럼에 설정한다
--			=> 가장 많이 사용되는 제약 조건!
--				: 테이블을 만들 때 가급적 값이 들어가게 해줬으면 좋겠음! ***

-- 제약조건명을 따로 부여하지 않은 경우 (Oracle이 자동으로 부여)
create table example1 (
	col1 varchat2(10 char),
	col1 varchat2(10 char) not null
);

-- Constraint 키워드를 사용해서 제약 조건명을 따로 부여하는 경우 // 제약 조건명 : col_2notnull
create table example2 (
	col1 varchat2(10 char),
	col1 varchat2(10 char) constraint col_2notnull not null
);


-- 2. Unique : 단어 뜻 그대로 해당 컬럼에 들어가는 값이				★ 잊어도 됨 ★
--				전체 테이블에서 유일해야한다 라는 조건
--		Not Null과 함께 사용이 가능하지만,
--		Unique는 많이 사용되지는 않음 // 왜인지는 밑에서 설명
create table example3(
	col1 varchar2(10 char) unique,
	col1 varchar2(10 char) unique not null,
	col1 varchar2(10 char),
	constraint col3_unique unique(col3)
);
-- 3. Primary Key (기본 키) :								★★★★★ 꼭 안고가야하는 것 ★★★★★
--		NULL을 허용하지 않고 + 중복된 데이터를 허용하지 않음
--		(Not Null + Unique => Primary Key)
--		데이터의 특정 조건을 검색하거나 수정 등의 작업을 할 때
--			기본 키로 구분함
--		ID, 주민등록번호, 회원 번호, 글 번호 등이 기본키에 해당함
--		일반적으로 테이블은 1개의 기본키를 무조건 가졌으면 좋겠음! ***

create table example4(
	col1 varchar2(10 char) primary key,
	col2 varchar2(10 char) not null,
	col3 varchar2(10 char) not null
);

-- 여러 컬럼을 묶을 때 constraint 키워드를 사용
--		+ 하지만 PK는 가급적 하나였으면...!
create table example5(
	col1 varchar2(10 char),
	col2 varchar2(10 char),
	col3 varchar2(10 char),
	constraint PK_example5 primary key(col1, col2)
);

-- *** 진짜 어려움...
--	4. Foreign Key(외래 키) : 다른 테이블의 특정 컬럼을 조회해서		★★★★★ 꼭 안고가야하는 것 ★★★★★
--							동일한 데이터가 있는 경우에만 입력이 허용	★★하지만 어려워서 다시 보기★★
--		참조하는 테이블은 참조받는 테이블의 PK나 Unique로
--		지정된 컬럼만을 FK로 지정할 수 있음
--		외래키 설정을 위해서는 참조받는 컬럼이 먼저 생성되어야 하고,
--		외래키를 심을 테이블이 그 이후에 생성이 되어야 함!!!

-- 외래키를 심을 테이블의 형식
create table 테이블명(
	컬럼명1 자료형,
	컬럼명2 자료형,
	constraint FK제약조건명 foreign key(컬럼명2)
		references 대상테이블명(대상테이블의 기본키(OR 고유키) 컬럼명)
		on delete set null || on delete cascade
		-- 참조받는 테이블에서 행 부분을 지웠을 때
		-- 이 테이블에 연결되어 있는 행에 대해서 null값을 먹일지
		-- or 그 행도 같이 지울지에 대한 옵션
); 

create table example6(
	ex6_id varchar2(10 char) primary key
);

insert into example6 values('10');
insert into example6 values('20');
insert into example6 values('30');
select * from example6;

create table example7(
	ex7_id varchar2(10 char),
	constraint fk_ex7 foreign key(ex7_id) 
		references example6(ex6_id)
		on delete cascade
);
insert into example7 values('10');
insert into example7 values('20');
insert into example7 values('30');
insert into example7 values('40');
select * from example7;

-- ex6_id가 '10'인 컬럼을 지우면 어떻게 될까 ?
delete from example6 where ex6_id = '10';

-- 학과 테이블과 이것을 참조하는 학생 테이블을 만들어보자!
-- 학과 테이블 : 학과 코드(4자리 숫자), 학과 이름(10글자 이내)

-- 학생 테이블 : 학생 번호(3자리 숫자), 학생 이름(17글자 이내)
--				학생이 소속되어있는 학과의 코드
create table major(
	m_code number(4) primary key, -- 프라이머리 키 빼먹음
	m_name varchar2(10 char) not null	-- 낫 널 빼먹음
);
insert into major values(1001,'체육학과');
insert into major values(2001,'법학과');
select * from major;
drop table major cascade constraint purge;
-----------------------------------------------
create table student(
	s_no number(3) primary key,		
	s_name varchar2(17 char) not null,	
	s_m_code number(4) not null,		
	constraint fk_student foreign key(s_m_code) 
		references major(m_code)
		on delete cascade
);
insert into student values(101, '곽두팔', 1001);
insert into student values(102, '김춘삼', 2001);
insert into student values(103, '김비버', 1001);
insert into student values(104, '박비버', 2001);
-- 오류! major 테이블에는 3001 코드가 없기 때문!
insert into student values(105, '최비버', 3001);
select * from student;

delete from where m_code = 1001;
-- major 테이블에서 1001코드를 지우면,
--	dtudent 테이블에서 1001코드를 가지고 있던
--	모든 학생의 정보가 지워짐!
---------------------------------------------------
-- 5. Check														★그냥 넘기기★ 웹에서 방지 가능
--	: 데이터의 값의 범위나 조건을 설정해서 조건에 해당하는
--		데이터만 입력을 허용함
create table example8(
	col1 number(3) constraint ex8_check check (col1 between 1 and 9) 
);	-- 정수 세자리 (-999~999)까지  체크해서

insert into example8 values(10);
insert into example8 values(9);

-- 6. default : 아무런 데이터도 입력하지 않은 경우						★그냥 넘기기★ 웹에서 방지 가능
--				임의로 지정한 데이터가 자동으로 입력됨

create table example9(
 	col1 number(3) default 999
);

insert into example9 values(default);
insert into example9 values(null);
insert into example9 values(0);
insert into example9 values(11);
select * from example9;
