select * from jun02_franchise;
select * from jun02_ceo;
select * from jun02_menu;
-------------------------------------------------
--내가
select * from franchise;
select * from ceo;
select * from cf;
----------------------------------
-- 메뉴 전체의 이름, 가격
--		을 가격 오름차순 => 가격이 같다면 메뉴명을 가나다 역순 정렬
--	여러번 정렬하고 싶을 때 => order by 를 또 쓰는게 아니고 order by 컬럼명, 컬럼명 (ASC / DESC)
select m_name, m_price from jun02_menu
	order by m_price , m_name desc;

-- 전체 사장님을 이름, 생일 조회
select c_name, c_birthday from jun02_ceo;

-- 프랜차이즈 식당 몇 개 ?
select count(*) from jun02_franchise;

-- 메뉴 전체의 평균가 ?
select avg(m_price) from jun02_menu;
-----------------------------------------------------
--내가
select cf_menu, cf_price
	from cf
	where order by asc cf_price =(
		order by asc;
		cf_price	
);

---------------------------------------------------------------
---------------------------------------------------------------
-- 제일 비싼 메뉴의 이름, 가격
select m_name, m_price from jun02_menu
	where m_price in (
		select max(m_price)
		from jun02_menu
	);
-- 최연장자 사장님의 이름, 생일
select c_name , c_birthday from jun02_ceo
	where c_birthday in (
		select min(c_birthday)	
		from jun02_ceo
	);
-- 좌석 수 제일 적은 식당의 이름, 지점명, 좌석수
select f_name, f_location, f_seat from jun02_franchise
	where f_seat in(
		select min(f_seat)
		from jun02_franchise
	);
	
----------------------------------------------------------------
select cf_menu "최고가 메뉴", cf_price "가격" from cf
	where cf_price =(
		select max(cf_price)
		from cf
	);
	
select c_name "최연장자", c_birth "생년월일" from ceo
	where c_birth = (
		select min(c_birth)	
		from ceo
	);
	
select f_branch, f_seat from FRANCHISE
	where f_seat =(
		select min(f_seat)
		from FRANCHISE
	);
------------------------------------------------------------------
------------------------------------------------------------------
-- 홍콩반점 제주점 운영하는 사람의 이름, 생일
select c_name, c_birthday
	from jun02_ceo
	where c_no in (
		select f_ceo
			from jan02_franchise
			where f_name = '홍콩반점'
			and f_location = '제주'
	);

-- '짜장' 글자가 들어간 음식은 어디가면 먹을 수 있나요?
--		(파는 식당의 이름, 지점명)
select f_name, f_location
	from jun02_franchise
	where f_no in (
		select m_f_no 
		from jun02_menu
		where m_name like '%짜장%'
	);
	
-- 좌석 수 제일 많은 식당을 운영하는 사람의 모든 정보
select *
	from JUN02_ceo
	where c_no in (
		select f_ceo
		from JUN02_FRANCHISE
		where f_seat = (
			select max(f_seat)
			from JUN02_FRANCHISE
		)
	);
	
------------------------------------------------------------------
select c_name, c_birthday from jun02_ceo
	where c_no in(
		select f_ceo
		from jun02_franchise
		where f_location ='제주'
	);

select f_name, f_location from jun02_franchise
	where f_ceo in(
		select m_f_no
		from jun02_menu
		where m_name
		like '%짜장%'
	);
													-- where 뒤에 () 넣으면 안됐고 select 없이 바로 like '짜장%'
select * from jun02_ceo
	where c_no in(
		select f_ceo
		from jun02_franchise
		where f_seat in (
		select max(f_seat)
		from jun02_franchise
		)
	);
-----------------------------------------------------------------
-- 최연소 사장님네 가게에서 파는 메뉴의 이름, 가격 조회 // 삼중?
-- 강사님
select m_name, m_price
	from jun02_menu
	where m_f_no in (
		select f_no
		from jun02_franchise
		where f_ceo in (
			select c_no
			from jun02_ceo
			where c_birthday in (
				select max(c_birthday)
				from jun02_ceo
			)
		)
	);
-----------------------------------------------------------------	-- m_f_no 메뉴를 팔고있는 식당의 번호 // c_no사장님의 고유번호 // 지금은 되긴하지만 의미가 안맞음 // 식당번호와 식당을 연결 식당과 운영사장님번호 연결
-- 내가
select m_name, m_price from jun02_menu 
	where m_f_no in(
		select c_no
		from jun02_ceo
		where c_birthday in(
			select max(c_birthday)
			from jun02_ceo
		)
	);

-----------------------------------------------------------------
-- 최길동이 운영하는 가게의 모든 메뉴 이름, 가격, 사장님 생일 조회
select m_name, m_price, (
	select c_birthday
	from jun02_ceo
	where c_no in (
		select f_ceo
		from jun02_franchise
		where f_no = m_f_no
	)
) c_birthday
from jun02_menu
where m_f_no in (
	select f_no
	from jun02_franchise
	where f_ceo in (
		select c_no
		from jun02_ceo
		where c_name = '최길동'
	)
);
-- 다른 방법 // join
select m.m_name, m.m_price, c.c_birthday
	from jun02_menu m, jun02_franchise f, jun02_ceo c
	where m.m_f_no = f.f_no and f.f_ceo = c.c_no
		and c.c_name = '최길동';
	-------------------------------------
	select m_name, m_price, c_birthday
	from jun02_menu, jun02_ceo
	where m_f_no in (
	select f_no
	from jun02_franchise
	where f_ceo in (
		select c_no
		from jun02_ceo
		where c_name = '최길동'
	))
		and c_name = '최길동';	
		
-----------------------------------------------------------------
select m_name, m_price, c_birthday "사장님의 생일"
	from jun02_menu,jun02_ceo
	where m_f_no,c_name in(
		select m_f_no = 4,c_name = '최길동'
		from jun02_menu,jun02_ceo
	);
	
-----------------------------------------------------------------
-- 테이블 여러개를 'JOIN' 시킨다
--		: 테이블 여러개를 붙여서 RAM에 잠깐 넣어놓는...!
-----------------------------------------------------------------
-- 지금처럼 테이블을 붙여서 사용이 가능하지만,
--	테이블들이 합쳐지면서 나타낼 수 있는 모든 값들을 나타내기 때문에
select * from jun02_franchise, jun02_ceo;
--	조건식을 사용해야 함 !!!
select * from jun02_franchise, jun02_ceo where f_ceo = c_no;

-- 전체 식당 이름, 지점명, 사장님 이름, 사장님 생일
select f_name, f_location, c_name, c_birthday
	from jun02_franchise, jun02_ceo
	where f_ceo = c_no;
	
-- 전체 메뉴명, 가격, 식당 이름, 지점명
select m_name, m_price, f_name, f_location
	from jun02_menu, jun02_franchise
	where m_f_no = f_no;

-- 좌석수가 50석 이상인 식당의 메뉴명, 가격, 지점명, 좌석수
select m_name, m_price, f_location, f_seat
	from jun02_menu, jun02_franchise
	where m_f_no = f_no and f_seat >= 50;
	
-- 규모가 제일 큰 식당의 메뉴명, 가격, 식당이름, 지점명, 좌석수
select m_name, m_price, f_name, f_location, f_seat
	from jun02_menu, jun02_franchise
	where m_f_no = f_no
		and f_seat in (
			select max(f_seat)
			from jun02_franchise
		);
	
-- 최연장자 사장님의 전체 메뉴명, 가격, 식당이름, 사장님이름, 생일
--		을 메뉴명 가나다순 => 식당이름 가나다순
select m_name, m_price, f_name, c_name, c_birthday
	from jun02_menu, jun02_franchise, jun02_ceo
	where m_f_no = f_no and f_ceo = c_no
		and c_birthday = (
			select min(c_birthday)
			from jun02_ceo
		)
	order by m_name, f_name;
 -- 다시 보기@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 -- 중요@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
select f_name, f_location, c_name, c_birthday from jun02_franchise, jun02_ceo where f_name = c_name;
select m_name, m_price, f_name, f_location from jun02_menu, jun02_franchise; 

-----------------------------------------------------------------------------
-- ★★★★★중요★★★★★
select count(*) from jun02_menu;
-- 메뉴 데이터의 갯수를 나눠서 페이지별로 보여주고 싶음
-- 어떻게 처리해야 할까요 ?
-- 메뉴테이블에 m_no가 있음 (Primary key)
--		Sequence로 처리했음
--		그.런.데.말.입.니.다
--		sequence는 insert에 실패해도 올라감
--		메뉴 데이터 삭제도 가능
--	=> m_no가 정확히 1, 2, 3, 4, ...가 아님!
-- 그럼 어떤 방법이 있을까...?
-----------------------------------------------------------------------------
-- Rownum (가상필드) ★★★★★★★★★★★★★★★★★★★
--		select할 때마다 자동으로 부여됨
--		* 랑은 같이 사용할 수 없음
--		order by보다 먼저 부여
--		무조건 1번부터 조회해야함 !!

-- 메뉴 이름을 가나다 순으로 정렬해서 메뉴 전체 정보를 조회
-- select rownum, * from jun02_menu order by m_name;
select rownum, m_no, m_name, m_price, m_f_no
	from jun02_menu order by m_name;
	
-- 메뉴 이름을 가나다 순으로 정렬해서 menu 테이블의
--		rownum 1 ~ 3까지 전체 정보를 조회 하려고 할 때
select rownum, m_no, m_name, m_price, m_f_no
	from jun02_menu
	where rownum >=1 and rownum <= 3 -- 이렇게 하면
	--	order by전에 rownum이 생성되어서
	--	sequence를 먹인 m_no와 같게 나와버림
	--	우리가 의도한바는 이름순으로 먼저 정렬한 후에
	--	그 다음에 번호값(rownum)을 주기를 원했
	order by m_name;

select rownum, m_no, m_name, m_price, m_f_no
	from jun02_menu
	order by m_name
	where rownum >= 1 and rownum <= 3;
	-- 코드상 결과값이 나오게 하려면 위에 처럼 하고 싶은데
	-- 문법 오류!!!!

select rownum, m_no, m_name, m_price, m_f_no -- 2. rownum을 부여 // 정렬을 하고서
	from (
		select m_no, m_name, m_price, m_f_no 	-- 여기
		from jun02_menu order by m_name			-- 여기가 인라인 뷰
		-- 1. 이 부분을 테이블처럼 사용함 (데이터정렬 해놓고)
		-- Inline View라고 함 (인라인 뷰)
		-- subquery가 from절에서 사용하는 경우를 인라인 뷰라고 함
		-- 하나의 쿼리문 내에서 테이블처럼 사용함(테이블 대체 용도)
		-- 쿼리문 종료 후에 사라지는 임시적인 뷰!
		
		-- 뷰 (VIEW)
		-- 진짜 테이블이 아닌 가상의 테이블, 테이블처럼 취급
		-- 사용자에게 접근이 허용된 자료만을 제한적으로 보여주기
		--		위해서 사용
		-- 그럼 진짜 테이블 쓰면 되는데 왜 굳이 ?
		--	1. 무언가 숨기고 싶은 정보가 있다면,
		--		뷰를 생성할 때 해당 컬럼을 빼고 생성함으로써
		--		정보 보안에 좋다
		--	2. 기존 테이블의 구조가 변경되어도
		--		뷰의 구조를 변경하지 않아도 된다
	)
where rownum >= 1 and rownum <= 3;

-- 메뉴명 가나다순으로 정렬한 후 rownum 2 ~ 4까지 메뉴 전체 정보 조회
-- select을 겉에 한번 더 씌워주면 안에 있는
--	rownum이 숫자만 부여해놓고 효력을 잃어버림

select *
	from (
	select rownum rn, m_no, m_name, m_price, m_f_no
		from (
			select m_no, m_name, m_price, m_f_no
			from jun02_menu order by m_name
		)
)
where rn >= 2 and rn <= 4;

-- ~길동 이름을 가진 사장님네 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 개어렵네
--		메뉴명, 가격, 식당명, 지점명, 사장님이름	
--		가격 내림차순 => 메뉴명 가나다순 정렬 후
--		3 ~ 8번째까지
select *
	from (
		select rownum rn, m_name,m_price,f_name,f_location,c_name
			from (
				select m_name,m_price,f_name,f_location,c_name
					from jun02_menu, jun02_franchise, jun02_ceo
					where m_f_no = f_no and f_ceo = c_no
						and c_name like '%길동'
					order by m_price desc, m_name
			)	
	)
	where rn >= 3 and rn <= 8;
-------------------------------------------------------------------
-- 내가
select *
	from (
select m.m_name, m.m_price, f.f_name, f.f_location, c.c_name
	from jun02_menu m, jun02_franchise f, jun02_ceo c
	where m.m_f_no = f.f_no and f.f_ceo = c.c_no
		and c.c_name like '%길동'
		from (
			select m_name, m_price, f_name, f_location, c_name
			from jun02_menu order by m_price
		)
)
where rn >= 3 and rn <= 8;
-------------------------------------------------------------------
-------------------------------------------------------------------
-- 김씨 성을 가진 사장님네 메뉴명, 가격, 사장님 이름, 사장님 성별
--	가격 오름차순 정렬 후 => 2 ~ 3번만

-- 진짜 데이터
select m_name,m_price,c_name, c_gender
	from jun02_menu, jun02_franchise, jun02_ceo
	where m_f_no = f_no and f_ceo = c_no
---------------------------------------------------
select *
	from (
		select rownum rn, m_name,m_price, c_name, c_gender
			from (
				select m_name,m_price,c_name, c_gender
					from jun02_menu, jun02_ceo, jun02_franchise
					where m_f_no = f_no and c_no = f_ceo 
						and c_name like '김%'
					order by m_price
			)	
	)
	where rn >= 2 and rn <= 3;

--@@@@@@@@@@@@@@@@@@
--문제: jun02_menu 테이블에서 메뉴 이름과 가격을 조회하되,
--가격은 내림차순으로 정렬
--가격이 같다면 메뉴 이름은 오름차순으로 정렬하세요

--
--문제: 특정 조건으로 데이터 조회
--문제: jun02_ceo 테이블에서 생일이 1980년 이후인 사장님의 이름과 생일을 조회하세요.

	
--문제: 특정 조건에 대한 카운트
--문제: jun02_menu 테이블에서 가격이 10,000원 이상인 메뉴의 개수를 구하세요.


-- jun02_menu 테이블에서 모든 메뉴의 총 가격과 평균 가격을 각각 구하세요.


--문제: 그룹화된 데이터 조회
--문제: jun02_franchise 테이블에서 각 프랜차이즈를 관리하는 사장님(f_ceo)별로 프랜차이즈의 개수를 구하세요.

	
--문제6: jun02_menu 테이블에서 메뉴 가격의 최고값과 최저값을 조회하세요.

	
	
--문제7: jun02_menu와 jun02_franchise를 조인하여,
--프랜차이즈 번호가 3인 메뉴들의 이름과 가격을 조회하세요.
select m_name, m_price
	from jun02_menu
	where m_f_no =(
		select f_no
		from jun02_franchise
		where f_no = 3
	);
	
--문제8: jun02_ceo 테이블에서 사장님 이름이 최길동인 사람이 관리하는 메뉴의 이름과 가격을 조회하세요.
select m.m_name, m.m_price
	from jun02_menu m
	where m.m_f_no =(
		select f.f_no
		from jun02_ceo
		where c_name ='최길동'
	);
	
--문제9: jun02_menu 테이블에서 가장 비싼 3개의 메뉴를 이름과 가격과 함께 조회하세요.

--문제10: jun02_franchise 테이블에서 사장님별로 관리하는 프랜차이즈의 평균 개수를 구하세요.
--(힌트: GROUP BY와 AVG()를 사용하세요.)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	