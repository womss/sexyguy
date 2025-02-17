-- 주석 !
-- DB를 사용하기 위해서 cmd에서 접근할 수 있지만,
-- SQL의 결과와 Query 검증 등을 위해서
-- 보통의 개발자들은 개발자 툴이라는 것을 사용함
-- DBeaver(디비버), MySQL - WorkBench, Oracle - SQL Developer
-- Eclipse로 먼저 사용해보고...

-- 용어 정리!!!
--	테이블(=릴레이션) : 데이터베이스에서 정보를 구분해서 저장하는 기본 단위
--					행과 열로 이루어진 데이터의 집합
--	행(Row) : 테이블을 구성하는 데이터들 중 가로 부분 (→)		// 행, 로우, 튜플, 레코드
--			 튜플(Tuple) 또는 레코드(Record)라고도 부름
--	열(Column) : 테이블을 구성하는 데이터들 중 세로 부분 (↓)		// 열, 컬럼, 필드, 속성
--				필드(Field) 또는 속성(Attribute)이라고도 부름
--	스키마(Schema) : 테이블의 기본 구조를 정의한 것
--				  쉽게 말하자면 제목 부분 (이름, 나이, 성별) // p_name, p_age, p_gender
--				  테이블의 헤더를 나타내며, 속성과 자료타입을 갖고 있음
--	인스턴스(Instance) : 테이블에 실제로 저장된 데이터의 값
--	도메인(Domain) : 속성이 가질 수 있는 값의 집합
--					특정 속성에서 사용할 데이터의 범위를 사용자가 정의
--					ex) p_name varchar2(10 char) 면
--					문자열을 최대 10글자까지 받겠다는 의미,
--					그 이상 넘어가면 값이 받아지지 않음
--					ex) p_age number(3) 이면,
--					정수를 3자리까지만 받겠다는 의미,
--					그 이상 넘어가면 값이 받아지지 않음

-- 한 줄 이지만, 가독성 때문에 줄을 바꿔놓은 상태!
-- 여러 줄을 실행하고 싶다면 : 
--		그 줄들을 다 드래그해서(덮어서) => alt + x
create table person_sexyguy(
	p_name varchar2(10 char),
	p_age number(3),
	p_gender varchar2(2 char)
);

-- 한 줄 실행 : 커서를 실행시킬 줄에 놓고 => alt + s
insert into PERSON_SEXYGUY values('홍길동', 10, '남');
insert into PERSON_SEXYGUY values('홍길동', 10, '남');
insert into PERSON_SEXYGUY values('김길동', 20, '여');
insert into PERSON_SEXYGUY values('최길동', 30, '남');
insert into PERSON_SEXYGUY values('최길동', 1000, '남'); -- 오류 !

select * from PERSON_SEXYGUY;

-- 테이블 구석시에 여러 조건들을 살펴야 하지만,
-- 지금 만든 테이블 상황상 '홍길동'은 같은 인물이라고 판단하고...
-- 중복값은 없애고 한번만 출력하고 싶음
select distinct * from PERSON_SEXYGUY; 
-- 이거 안됨 프롬값 빼먹음

-- 테이블 지우기
drop table person_sexyguy cascade constraint purge;

-- 테이블(릴레이션)의 특징
--	1. 속성은 단일 값만 가진다
--		각 속성의 값은 도메인에 정의된 값만 가지며,
--		그 값은 모두 단일한 값이어야 함
--		ex) p_age : 최대 3자리 정수로 된 값만 가지며,
--					그 값은 여러개가 아닌 단 하나의 값이어야 함
--	2. 속성은 서로 다른 이름을 가진다
--		=> 각 속성마다 p_name, p_age, p_gender라는 이름을 가지고 있음
--		=> 각 이름을 중복해서 만들지 않기!!
-- ex) 컬럼명 중복 오류!
create table test(
	t_no number(3),
	t_no varchar2(10 char)
);

--	3. 한 속성의 값은 모~~~~두 같은 도메인 값을 가진다
--		=> 1번이랑 같은 맥락으로 p_age : 최대 3자리 정수로 된 값을 가짐

--	4. 속성의 순서는 상관없다
--		속성의 순서가 달라도 테이블의 스키마는 같음
--	ex)
select * from PERSON_SEXYGUY; -- 섹시가이의 전체 내용을 가져 오겠다(이름, 나이, 성별)
select p_age, p_gender, p_name from person;
-- 순서만 바뀌었지 내용에는 변화가 없다!

--	5. 테이블 내의 중복된 튜플은 허용되지 않는다 ( ★ 제일 중요 ★)
--		홍길동에 대한 정보가 한 번 더 들어가면
--			동일인물인지 다른인물인지 알 수가 없음
--		즉, 모든 튜플에는 차별성이 있어야 !!
--			(생일을 추가한다거나, 핸드폰 번호를 추가한다거나, ...)
---------------------------------------------------------------
-- SQL 명령문의 종류! // 크게 3개 혹은 4개(트랜잭션 처리어 포함)

-- 데이터 정의어 (DDL / Data Definition Langguage)
--		: 테이블이나 관계의 구조를 생성하는데 사용하며,
--		Create, Alter, Drop, ... 등이 있음

-- 데이터 조작어 (DML / Data Manipulation Language) // 제일 많이 씀 ★★★
--		: 테이블에 데이터를 검색, 삽입, 수정, 삭제 하는 데 사용하며,
--			Select, Insertm Update, Delete 등이 있음
--			(줄여서 CRUD라고 함) Create(테이블을 생성한다는것과 달리 데이터를 생성한다는 뜻) / Read / Update / Delete
--			Select 문은 특별히 질의어(Query)라고도 함

-- 데이터 제어어 ( DCL / Data Control Language)
--		: 데이터베이스에 접근하고 데이터들을 사용하도록
--			권한을 주고, 회수하는데 사용하며, 
--			Grant, Revoke 등이 있음

-- 트랜잭션 처리어 (TCL / Transaction Control Language)
--		: DML에 의해서 조작된 결과를 '최소 작업 단위' (트랜잭션)
--		별로 제어하는데 사용하며,
--			Commit, Rollback, Savepoint 등이 있음

-- 그래서 SQL이라는 언어로 DB를 제어해볼건데
--		DB메이커가 달라도 SQL은 거의 비슷
--		대/소문자 구별하지 않음 => 다 대문자로 받아들임	// 소문자로 써도 왜 표기는 대문자로 되나 했는데 이런 이유
--		낙타체가 안통함(dogAge) => DOGAGE
--		뱀체로 표현 (dog_age)
--		데이터는 대소문자를 구별함
--			"a"와 "A"는 다름!!!!!
















