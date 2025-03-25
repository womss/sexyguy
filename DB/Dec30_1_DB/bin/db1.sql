-- 테이블에 데이터를 검색, 삽입, 수정, 삭제하는데 사용하는 문장인
-- 데이터 조작어(DML) 중에서 데이터를 넣게하는 명령어는 Insert와
-- 데이터를 검색 / 조회할 수 있는 명령어인 Select의 구조를 뜯어봤음

-- insert into [테이블명] values(값, 값, ...); 의 형태
-- insert를 하면서 primary key를 줄 수 없는 상황에
-- 강제적으로 고유 번호값을 만드는 방법으로 primary key를 줬었고
-- 그 고유한 번호값들을 만드는데 있어서 매번 하나하나 지정해줄 수 없으니
-- 번호값들을 찍어내는 공장!!!! Sequence라는 기능을 활용했음!
-- 테이블이랑 무관하고, 단점으로는 Insert에 실패하더라도,
--		Sequence의 값은 무조건 올라간다는 것!!!

-- 데이터를 검색할 수 있는 Select
-- select [distinct] [컬럼명], [컬럼명 as 별칭 || 컬럼명 별칭],		-- 다시보기
--		[연산자 사용], [통계함수], ...
--	from [테이블명]
--	where [조건식]
--	group by [그룹대상]
--	having [함수 포함 조건]
--	order by [정렬 대상 ASC/DESC];

-- distinct는 중복을 제거해주는 역할 !
-- 컬럼명에 별칭부여하는 방법 : AS를 붙이거나 or 띄어쓰기만 하거나
-- 연산자 시리즈 첫번째 산술연산자 (+, - , * , /),
--		바로 이어서 문자를 이어붙여주는 연산자 ' || '
-- DUAL 더미테이블을 이용해서 유용한 내장함수
--		(숫자함수, 문자함수, 날짜함수, 통계함수, NULL관련함수)
--	전체 데이터 중 조건에 맞는 데이터를 찾아주는 WHERE절(조건식)을 다루면서
--	연산자 시리즈 두번째 비교연산자 (=, !=, >, <, >=, <=)
--	연산자 시리즈 세번째 관계연산자
--		AND와 BETWEEN + AND의 차이! 
--		연속되지 않은 값들을 받아올 때 사용하는 IN, OR
--		그 반대되는 값을 받아올 때 사용하는 NOT연산자
--			이 때 NOT의 위치는 IN 앞에 위치 !!
--	연산자 네번째 패턴연산자 : 문자열을 포함하는 검색
--		like '%패턴%'의 형태 / like 대신에 = (등호)를 사용하면 안되는 이유!
--			=> 등호를 사용하면 패턴을 문자 그대로 인식해버리기 때문에!!
--	연산자 시리즈 마지막 집합연산자
--		UNION / UNION ALL (합집합)
--			: 중복되는 값을 제외하고 출력 / 중복되더라도 전부 출력
--		INTERSECT (교집합)
--			: 집합 중 공통되는 값 출력
--		MINUS (차집합)
--			: 앞에 있는 SELECT문 중에서 뒤에 있는 SELECT문에는 없는 값 출력
-- 연산자 끝내면서 연산자의 우선순위
--		괄호 > 비교연산자 > NOT > AND > OR

-- WHERE절 끝냈고,
-- 다음으로는 GROUP BY 절 : 그룹으로 묶어서 연산하여 하나의 결과를 나타내는 것!
--		Rollup 연산자 : 컬럼에 대한 소계(Subtotal)을 만들어줌
-- Having절 Where절
--		: Having절은 그룹에 결과를 제한
--		  Where절은 전체 데이터의 결과를 제한
-- 마지막으로 정렬을 해주는 Order By절
--		: 오름차순 ASC(기본값이라 명시 안해도 됨)
--		  내림차순 DESC 
-----------------------------------------------------------------------------------------
-- *** 서브쿼리 (SubQuery)
-- select문 안에 다시 select문을 사용하는 기술!
-- 하나의 SQL문 안에 다른 SQL문이 중첩된 질의문을 의미
-- 다른 테이블에서 가져온 데이터로 현재 테이블에 있는 정보를
--	찾거나 가공할 때 사용함
-- 보통 데이터가 대량일 떄 데이터를 모두 합쳐서 연산하는 JOIN보다
--	필요한 데이터만 찾아서 공급해주는 Subquery가 성능이 더 좋음

-- 주질의(main query, 외부질의)와 부속질의(subquery, 내부질의)로 구성됨
select s_name, s_price
	from dec26_snack
								where s_price < (
									select avg(s_price)			-- 얘네가
									from dec26_snack			-- 서브쿼리
								);
-- 평균가보다 가격이 낮은 과자의 이름과 가격 정보를 조회한 Query
								
-- 메인쿼리의 where절에서 서브쿼리의 결과와 비교할 때는
--		반 드 시 비교연산자를 사용해야 함!!!

-- 과자들 중 최고가 조회
-- 가장 비싼 과자 이름, 제조사, 가격
--- 첫번째 select와 두번째 select가 독립된 명령문으로 해석될 수 있어 문법적으로 잘못된 구조가 되어 오류!
--- 주의 *** : where절 이후 select문에서는 소괄호 넣고 시작! 그러지 않으면 80번줄에 해당
select s_name, s_maker, s_price
	from dec26_snack
	where s_price = (
		select max(s_price)
		from dec26_snack;
	);
-- 제일 싼 과자는 어디에서 만드나요 ?
select s_maker
	from dec26_snack
	where s_price = (
		select min(s_price)
		from dec26_snack
	);
-- 제일 싼 과자가 중복이라면 디스틴트
select distinck s_maker
	from dec26_snack
	where s_price = (
		select min(s_price)
		from dec26_snack
	);
-- 평균가보다 비싼 과자는 몇 종류 ?
select count(*)
	from dec26_snack
	where s_price > (
		select avg(s_price)
		from dec26_snack
	);
	
-- 유통기한이 가장 오래 남은 과자의 전체 정보
select * 
	from dec26_snack
	where s_exp = (
		select max(s_exp)
		from dec26_snack
	);
-------------------------------------------------------------------------
select max(s_price)||'원'"최고가 과자가격" from dec26_snack;
------------------------------
select ''|| s_name||''"최고가 과자", ''||s_maker||''"최고가 과자회사", ''||s_price||'' "과자 가격"
	from DEC26_SNACK
								where s_price = (
									select max(s_price)
									from dec26_snack
								);
----------------------------------------------------------------------------
select s_maker "최저가 회사"
	from dec26_snack
								where s_price = (
									select min(s_price)
									from dec26_snack
								);
----------------------------------------------------------------------------
select count(*)||'개' "평균가 이상"
	from dec26_snack
								where s_price > (
									group by s_name
									select avg(s_price)
									from dec26_snack
								);

--------------------------------------
-- 과자 회사 테이블을 만들건데,
--	회사 이름, 주소, 직원 수 값을 가지게끔
-- 테이블에 맞춰서 데이터 넣기!
-- 참조관계 고려 X

create table ssnack (
	ss_company varchar2(20 char) primary key,
	ss_location varchar2(10 char) not null,
	ss_people number(4) not null
	);
	
create sequence ssnack_seq;
drop table ssnack cascade constraint purge;
drop sequence ssnack_seq;
insert into ssnack values('오리온', '서울', 100);
insert into ssnack values('크라운', '부산', 200);
insert into ssnack values('롯데', '일본', 500);

select * from ssnack;

-- 직원 수 제일 적은 회사에서 만드는 과자이름, 가격 조회
-- (제일 적은 직원수의 회사가 복수일 경우)회사명이 해태거나, 롯데거나, ...
--	= 쓰면 단일값 이상의 결과를 내보낼 수가 없어서
--		' single-row ~~~ ' 발생
--		=> 관계연산자 < in > 사용
select s_name, s_price
	from dec26_snack
	where s_maker = (				-- 1연결고리
		select ss_company			-- 1연결고리 2연결고리
		from ssnack					-- 2연결고리
		where ss_people = (
			select min(ss_people)
			from ssnack
		)
	);
-- 제일 비싼 과자를 만드는 회사는 어디에 있는지 조회
-- 183
-- 부산에 있는 회사에서 만드는 과자의 평균가 조회				--??
select round(avg(s_price), 1)
	from dec26_snack
	where s_maker = (
		select ss_company
		from dec26_snack
		where ss_location = '부산'
	);
		
-- 평균가 이상의 과자를 만드는 회사의 이름, 위치 조회			--??
select ss_company, ss_location
	from dec26_snack
	where ss_company in (
		select s_maker
		from dec26_snack
		where s_price >= (
			select avg(s_price)
			from dec26_snack
		)
	);
----------------------------------------------------------

select ss_location "과자회사 위치"
	from ssnack
	where ss_company = (
		select s_maker
		from dec26_snack
		where s_price =(
			select max(s_price)
			from dec26_snack
		)
	);
--------------------------------------------------
select round(avg(s_price), 1) "평균가"
	from dec26_snack
	where s_maker = (
		select ss_company
		from ssnack
		where ss_location = ('부산')
	);
-------------------------------------------------
select ss_company "회사이름", ss_location "회사 위치"
	from ssnack
	where ss_company = (
		select s_maker
		from dec26_snack
		where s_price >= (
			select avg(s_price)
			from dec26_snack
		)
	);






















