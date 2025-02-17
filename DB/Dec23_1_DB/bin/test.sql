-- 테이블스페이스 : 이거 함부로 지우지 마세요 !!! 이거 => .DBF 

-- 테이블을 만들어보자!!
create table hot(
	컬럼명 자료형 [옵션], -- 옵션 : 필요하면 넣는 것 ! / [] 넣는거 아님
	컬럼명 자료형,

);

-- 자료형(데이터 타입)
-- 3가지의 타입으로 나눌 수 있음

-- 문자형 ( ex)문자형 자료형중에 char가 있다 )
--		char(용량)
--		무조건 그 용량대로 저장
--		용량이 비어있다면 띄어쓰기로 그 용량을 메꿈
--		처리 속도가 빠르다!
--		글자수가 정해져 있다면 char 활용 O
--			ex) 성별, 주민번호, 핸드폰번호, ...

--		varchar2(용량)
--		정해진 용량만큼 데이터를 안넣으면
--		그 용량을 조절해서 저장
--		주력으로 사용 !
--		용량을 조절하는만큼 처리속도가 느리다 !
--			ex) 이름, 주소, ...

-- 문자형 용량
--		varchar2(5) : 5 byte
--			영어, 숫자, 띄어쓰기는 1byte
--			한글 한글자는 3byte
--			글자수 계산하기가 애매...
--		varchar2(5 char) :
--			한글/영어 5글자 => 최대 15byte
--	=> 문자형 자료형을 쓸 때는 용량에 char를 넣어서 쓰자!

create table test(
	t_name varchar2(5)
);

create table test2(
	t_name varchar2(5 char)
);

-- 문자형의 값을 넣을 때는 작은따옴표 사용해서
insert into test values('가나다'); -- 용량초과로 인한 에러 발생 !
insert into test2 values('가나다'); -- 성공 !
drop table test cascade constraint purge;
drop table test2 cascade constraint purge;
































