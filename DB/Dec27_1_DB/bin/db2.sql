-- R(Read)
select [distinct] [컬럼명], [컬럼명 as 별칭 || 컬럼명 별칭],
	[연산자 사용], [통계함수], ...
	from [테이블명]
	where [조건식]
	group by [그룹 대상]
	having [함수 포함 조건]
	order by [정렬대상 ASC/DESC(오름차순/내림차순)]; -- 기본값은 ASC

-- where절 (조건식)
-- 전체 데이터 중 지정한 조건에 맞는 데이터를 찾아주는 문장
-- 조건식에 사용할 연산자 (비교 연산자)
--	=, !=, ^=, <>, >, <, >=, <=
-- 이 중에서 2, 3, 4번째는 '같지 않다'로 쓰이는 연산자
--	2, 4번째는 각각 표준화를 하려다보니 사용하게 되었고,
--	3번째의 경우에는 몇몇 DBMS과 차별화를 두기 위해 사용하게 되었음

-- 가격이 1800원인 과자의 전체 정보를 조회
select * from dec26_snack where s_price = 1800;
---------------------------------------------------------------------------
-- 모든 과자 이름, 가격 조회
select s_name, s_price from dec26_snack;
-- 모든 과자 이름(가격) 조회 (ex: 콘칩(2000원))
select s_name || '(' || s_price || '원)' "이름(가격)" from dec26_snack;
-- 2000원 이상의 과자 중 최소가격이 얼마인지
select min(s_price) from dec26_snack where s_price >= 2000;

-- 모든 과자의 평균가
select * from AVG s_price;
select AVG(s_price) from dual;
select AVG(s_price) from dec26_snack;
-- 과자의 이름과 가격의 30% 할인된 금액
select s_name, s_price * 0.7 from dec26_snack;

-- 3800원인 과자의 갯수는 몇 개 ?
select count(*) from dec26_snack where s_price = 3800;
 
-- 1700원인 과자의 이름, 회사 이름 조회
select s_name, s_maker from dec26_snack where s_price <= 3800;;
---------------------------------------------------------------------------

-- 모든 과자 이름, 가격, 유통기한 조회
select s_name, s_price, s_exp from dec26_snack;
select ''|| s_name ||'' "과자 이름", ''|| s_price ||'원' "가격", ''|| s_exp ||'' "가격" from dec26_snack;

-- 모든 과자 이름, 가격, 부가세 조회(가격의 10%)
select s_name, s_price, s_price / 10 from dec26_snack;
select s_name, s_price, ''|| s_price / 10 || '원' "부가세" from dec26_snack;

-- 모든 과자 이름, 가격, 판매가 조회(20% 할인)
select s_name, s_price, s_price * 0.8 from dec26_snack;
select s_name, s_price, ''|| s_price * 0.8 || '원' "판매가" from dec26_snack;

-- 3000원보다 큰 금액의 과자들의 평균가 조회
select avg(s_price) from dec26_snack where s_price > 3000;
select round(avg(s_price), 1) from dec26_snack where s_price > 3000; 반올림

-- 최고가, 최저가, 총 과자 종류 갯수 조회
select max(s_price), min(s_price), count(*) from dec26_snack;
select ''|| max(s_price) || '원' "최고가", ''|| min(s_price) || '원' "최저가", ''|| count(s_price) || '개' "과자 개수" from dec26_snack;

-- 허니버터칩의 가격 조회											@@ 여기부터 못했음 @@ where개념도 다시
select s_price  from dec26_snack where s_name = '허니버터칩'; 

-- 크라운 회사의 과자 가격 총합 조회
select sum(s_price) from dec26_snack where s_maker = '크라운'; 
-- 올해 안으로 먹어야 하는 과자 이름, 가격, 유통기한 조회
select s_name, s_price, s_exp from dec26_snack where s_exp < to_date('2025-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS');
-----------------------------------------------------------------------------------
-- 관계 연산자
-- NOT, AND, OR, BETWEEN, IN

-- 가격이 1000원 이상 3000원 이하인 과자의 전체내용 조회
-- AND		dec26_snack 중 가격이 1000이상 3000이하인것
select * from dec26_snack where s_price >= 1000 and s_price <=3000;
-- BETWEEN + AND
select * from dec26_snack where s_price between 1000 and 3000;

-- between은 이상/이하로 조건 범위를 정하기 때문에
-- 1000원 초과 3000원 미만인 과자를 조회할 때는 between 사용이 불가

-- 가격이 1000원, 2000원, 3000원인 과자의 전체 정보를 조회!
select * from dec26_snack where s_price = 1000 or s_price = 2000 or s_price = 3000;
-- 하지만 이후에 값을 계속 넣는다면? s_price = 1500 ,s_price = 2500, ... 불편한부분떄문에

-- IN연산자!
-- 위에 문장보다 완전 편해졌고, 효율적이에요!
-- 연속되지 않은 값들을 받아오고 싶을 때 => IN을 사용하자!!
select * from dec26_snack where s_price in (1000, 2000, 3000);

-- 이 결과에 반대되는 결과값을 받아오고 싶다면? => NOT 연산자!
--	그러면 이 NOT을 어디에 쓰는게 좋을까요 ?
select * from dec26_snack where s_price not in (1000, 2000, 3000);
--	=> IN 연산자 앞에 NOT 연산자 붙여서 사용하면 된다 ~
---------------------------------------------------------------------------------


-- 패턴 연산자
--	문자열을 포함하는 검색 : like '패턴' 의 형태
--	이 때 패턴에는 '%'를 넣는데 뭐가 들어갈지 모른다는 뜻 !
--		like '%ㅋ'	: ㅋ로 끝나는 것
--		like 'ㅋ%'	: ㅋ로 시작하는 것
--		like '%ㅋ%'	: ㅋ을 포함하는 것
--	그럼 like 대신 ( = 'ㅋ%') 는 안되나요 ?
--		=> 등호를 써서 식을 표현하면  패턴으로 인식하는 것이 아닌
--				'ㅋ%' 문자 그대로 인식해버림
--		=> 그래서 like로 'ㅋ%' 이런 패턴의 값을 찾아라 ~ 라고 표현해줌

-- '해'가 들어가는 회사에서 만든 과자의 이름 조회
select s_name from dec26_snack where s_maker like '%크%';
-- '해'가 들어가는 과자들 평균가 조회
select round (avg(s_price), 1) from dec26_snack where s_maker like '%크%';
-- 크라운 과자거나, 몽쉘 ~ 인거 이름, 제조사, 가격 조회
select s_name, s_maker, s_price from dec26_snack where s_maker like '크라운' or s_name like '빼빼로%';

-- 과자의 이름이 '새콤달콤'을 포함하거나 '몽쉘'을 포함하는
--		과자의 이름, 제조사, 가격 조회
select s_name, s_maker, s_price from dec26_snack where s_name like '%고래밥%' or s_name like '%초코파이%';

select s_name, s_maker, s_price from dec26_snack where s_name like in ('%고래밥%', '%몽쉘%');
-- like ~ in 구조는 아예 없다!

-- REGEXP_LIKE(컬럼명, 패턴1|패턴2|...)
--	정규식(REGEX)을 이용해서 문자를 찾는 방법인데
--	여러개의 패턴을 찾고 싶다면 |(파이프)를 넣어서 패턴을 추가!
--	패턴 앞에 ^를 넣으면 : 패턴값으로 시작하는 문자열 찾기
--	패턴 뒤에 $를 넣으면 : 패턴값으로 끝나는 문자열 찾기

-- 과자의 이름이 '새콤달콤'으로 시작하거나,
--		'이'로 끝나는 과자의 이름, 제조사, 가격 조회
select s_name, s_maker, s_price from dec26_snack where regexp_like(s_name, '^새콤달콤|이$');
----------------------------------------------------------------------------------------------
-- 집합 연산자
--	합집합
--		UNION : 중복되는 값을 제외하고 출력
select 1 id, '수학' subject, 90 score from dual union
select 1 id, '수학' subject, 90 score from dual union
select 1 id, '수학' subject, 90 score from dual;
--		UNION ALL : 중복되더라도 모두 출력
select 1 id, '수학' subject, 90 score from dual union all
select 1 id, '수학' subject, 90 score from dual union all
select 1 id, '수학' subject, 90 score from dual;

-- 교집합
--	INTERSECT : 두 테이블의 집합 중 공통되는 값 출력
select 1 id, '수학' subject, 90 score from dual union
select 2 id, '영어' subject, 90 score from dual intersect -- 왜 중간에 들어가는거지? 맨처음이나 맨 마지막에 들어가야하는거 아닌가? unioneh 그렇고
select 1 id, '수학' subject, 90 score from dual;

-- 차집합
--	MINUS : 첫번째 select문 중에서 두번째 select문에 없는 값을 출력 -- 이건 좀더 봐야할 듯
select 1 id, '수학' subject, 90 score from dual minus
select 1 id, '수학' subject, 80 score from dual minus
select 1 id, '수학' subject, 90 score from dual dual;
--------------------------------------------------------------------------------------
-- 과자 데이터 중에서 회사가 크라운이고
--	가격이 1000원 이하이거나 3000원 이상인 과자 전체정보를 조회
-- 연산자 우선순위 (왼쪽이 최우선순위)
--	괄호 > 비교 연산자 > NOT > AND > OR
select * from dec26_snack where s_maker = '크라운' and (s_price <= 1000 or s_price >= 3000);
--------------------------------------------------------------------------------------------
-- Group by : 그룹으로 묵어 연산해서 하나의 결과를 나타내는 것
-- 회사별 과자 평균가격, 최소가격, 최고가격
select avg(s_price), min(s_price), max(s_price) from dec26_snack; -- 전체값에 대한 평균 표기
select s_maker, round(avg(s_price),1), min(s_price), max(s_price) from dec26_snack group by s_maker; -- 회사별 평균 표기

-- Rollup 연산자
-- group by rollup(그룹 대상)
-- 컬럼에 대한 소계(subtotal)을 만들어줌
-- group by 절의 컬럼 갯수가 n개라면,
--		rollup을 썼을 때는 n+1개

-- 회사 이름, 회사별 과자 총 가격 합계와 모든 과자들의 가격 합계
select s_maker, sum(s_price) from dec26_snack group by rollup(s_maker); -- 모든 과자들에 대한 서브토탈, 서브토탈은 NULL로 표기됨

-- => NULL에 대한 값을 뭔가로 나오게 하고 싶으면
--		DECODE(컬럼명, 조건, 조건에 맞는 결과값, 조건에 맞지 않을 때 결과값)
					-- ㄴ 딱 떨어
-- s_maker가 null값이면 '전체', 그게 아니면 s_maker값
select decode(s_maker, null, '전체', s_maker) s_maker, sum(s_price) from dec26_snack group by rollup(s_maker);
-- nvl2도 가능				@@ 다시 보기 @@
select nvl2(s_maker, s_maker, '전체') s_maker, sum(s_price) from dec26_snack group by rollup(s_maker);

-- decode 사용시 : 조건 자리에는 비교 연산자 (X), 산술 연산자 (O) 
--								ㄴ 범위 (X), 딱 떨어지는 값 (O)
----------------------------------------------------------------------------------------
-- Having : Group by 절에 의해 생성된 결과 중
--			원하는 조건에 부합하는 데이터만 찾고자 할 때 사용
--	Having과 Where 모두 조건을 이용해서 원하는 조건에 맞는
--		데이터만 산출한다는 공통점이 있음
--	Having : 그룹의 결과를 제한
--		vs
--	Where : 조건을 사용해서 전체 데이터에 대한 결과를 제한

-- 회사별 과자 평균 가격이 2000원 이상인 회사의
--		회사의 이름과 과자 평균가격을 조회
select ''||s_maker||''"회사명",''||round (avg(s_price),1)||'원' "평균가"
	from dec26_snack
	group by s_maker
	having avg(s_price) >= 2000;

-- Order by : 정렬! 기본값은 오름차순 ASC, 내림차순 정렬은 DESC
order by [정렬대상 ASC(생략가능) / DESC (오름차순 / 내림차순)]
-- where + group by + having + order by
-- 롯데 또는 해태(크라운) 회사의 과자 평균 가격이 1800원 이상일 때
--	각 회사의 평균 가격을 내림차순 정렬
-- 내가
select s_maker, avg(s_price)
	from dec26_snack
	where s_maker in '롯데', '크라운'				-- 괄호 안쳐서 안됐음
	group by s_maker
	having avg(s_price) >= 1800					-- 세미콜론 또 쳐서 안됐음
	order by avg(s_price) desc;
-- 강사님
select s_maker, avg(s_price)
	from dec26_snack
	where s_maker in ('롯데', '크라운')
	group by s_maker
	having avg(s_price) >= 1800
	order by avg(s_price) desc;





















