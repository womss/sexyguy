-- 1. 음료테이블과 카페테이블을 만들기
-- 음료테이블 : 음료이름 / 가격 / 판매하는 카페의 이름
-- 카페테이블 : 카페이름 / 지역 / 좌석 수
--	[조건] : 각 테이블에서 음료 이름, 카페 이름은 고유한 값을 갖는다.
--			참조관계 고려 X

-- 2. 조건에 맞는 테이블을 생성 + 데이터 넣기
--	A카페는 서울에 위치하고, 좌석 100석,
--	(아메리카노, 2000원), (라떼, 3000원), (녹차, 2500원)을 판매
--	B카페는 제주에 위치하고, 좌석 80석,
--	(홍차, 2000원), (스무디, 3000원), (에스프레소, 4000원)을 판매

-- 3. 쿼리문 작성
--	전체 음료 기준 평균가보다 비싼 음료는 몇 종류 ?
--	제일 싼 음료를 파는 카페의 이름 ?
--	서울에 있는 카페에서 만드는 음료의 평균가 ?
--	좌석이 90석 이상인 카페에서 파는 음료의 이름 ?

select * from info where i_seat >= 90 -- 좌석이 90석이상인
	select c_name
	from info
	where i_seat >= 90
); -- 좌석이 90석이상인
--	전체 음료 기준 평균가 이하인 음료의 이름 ? -- 테이블 하나짜리
select c_menu from cafe
----- 음료의 이름
select avg(c_price) from cafe
----- 평균 가격
select c_menu
	from cafe
	where c_price <= ( -- 추가
		select avg(c_price)
		from cafe
	);
--	가장 비싼 음료를 파는 카페는 어디에 있는지 ?

-- a cafe
create table cafe(
	c_made varchar2(5 char) not null,				-- 만든 카페
	c_menu varchar2(10 char) primary key not null , -- 카페 메뉴
	c_price number(5) not null						-- 메뉴 가격
);
insert into cafe values('acafe', '아메리카노', 2000);
insert into cafe values('acafe', '라떼', 3000);
insert into cafe values('acafe', '녹차', 2500);
insert into cafe values('bcafe', '홍차', 2000);
insert into cafe values('bcafe', '스무디', 3000);
insert into cafe values('bcafe', '에스프레소', 4000);

select * from cafe;
select * from dec26_snack;
drop table cafe cascade constraint purge;

create table info(
	i_name varchar2(10 char) primary key,
	i_location varchar2(10 char) not null,
	i_seat number(3) not null
);
select * from info;

insert into info values('acafe', '서울', 100);
insert into info values('bcafe', '제주도', 80);
drop table info cascade constraint purge;
----------------------------------------------------------
--	전체 음료 기준 평균가보다 비싼 음료는 몇 종류 ?
select count(*)||'개' "평균이상 음료"
	from cafe
	where c_price > (
		select avg(c_price)
		from cafe
	);
------------------------------------------------------------
--	제일 싼 음료를 파는 카페의 이름 ? -- 왜 in이랑 밑밑에 프롬 카페가 붙는지
select i_name
	from info
	where i_name in ( -- 인포의 네임과 
		select c_made	-- 카페 메이드가 같다면
		from cafe
		where c_price = (
			select min(c_price)
			from cafe
		)	
	);
----------------------------------------------------------------
--	서울에 있는 카페에서 만드는 음료의 평균가 ? 
select round(avg(c_price), 1)
	from cafe
	where c_made in (
		select i_name
		from info
		where i_location = '서울'
	);
----------------------------------------------------------------
--	좌석이 90석 이상인 카페에서 파는 음료의 이름 ?
select c_menu
	from cafe
	where c_made in (
		select i_name
		from info
		where i_seat >= 90
	);
----------------------------------------------------------------
--	전체 음료 기준 평균가 이하인 음료의 이름 ?
select c_menu
	from cafe
	where c_price <= (
		select avg(c_price)
		from cafe
		);
----------------------------------------------------------------
--	가장 비싼 음료를 파는 카페는 어디에 있는지 ? -- 이거 안됨
select i_location
	from info
	where i_name = (
		select c_made
		from cafe
		where c_price = (
			select max(c_price)
			from cafe
		)
	);

------------------------------------------------------------














