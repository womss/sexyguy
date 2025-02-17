-- 배추, 3000g, 10000원, 홈플러스, 판교점, 1000평, 주차장 500석
-- 무, 500g, 5000원, 홈플러스, 강남점, 500평, 주차장 300석
-- 배추, 2000g, 5000원, 이마트, 서초점, 800평, 주차장 800석
----------------------------------------------------------------세분화 할 수 있을때까지 해보겠습니다
create table jan03_market (
	m_no number(3) primary key,
	m_name varchar2(10 char) not null,
	m_location varchar2(10 char) not null,
	m_land number(4) not null,
	m_parking number(4) not null
);
create sequence jan03_market_seq;

insert into jan03_market values(jan03_market_seq.nextval,
	'홈플러스', '판교점', 1000, 500);
insert into jan03_market values(jan03_market_seq.nextval,
	'홈플러스', '강남점', 500, 300);
insert into jan03_market values(jan03_market_seq.nextval,
	'이마트', '서초점', 800, 800);
	
select * from jan03_market;
drop table jan03_market;
drop sequence jan03_market_seq;
DROP TABLE jan03_market CASCADE CONSTRAINTS;

---------------------------------------------------------------------
create table jan03_product (
	p_no number(3) primary key,
	p_name varchar2(10 char) not null,
	p_weight number(4) not null,
	p_price number(5) not null,
	p_m_no number(3) not null,
	constraint fk_jan03_product foreign key(p_m_no)
		references jan03_market(m_no)
		on delete cascade
);
create sequence jan03_product_seq;
drop table jan03_product;
drop sequence jan03_product_seq;

insert into jan03_product values(jan03_market_seq.nextval, '배추',
	3000, 10000, 1);
insert into jan03_product values(jan03_market_seq.nextval, '무',
	500, 5000, 2);
insert into jan03_product values(jan03_market_seq.nextval, '배추',
	2000, 5000, 3);

select * from jan03_product;
-------------------------------------------------------
-- create table - DBA
-- drop table - DBA
-- create sequence - DBA
-- 계정 하나로 여러명 사용 가능 O (동시사용 가능)
-- 회사가면 개발자용 계정을 알려줌 => 위의 작업들 권한은 없을듯? 응애라
-------------------------------------------------------
-- 우리가 하는것
-- C - insert
--		sequence사용, 날짜 집어놓고, ...
-- R - select
--		거의 대부분의 시간을 할애함
-- U - update
update 테이블명
	set 컬럼명 = 값, 컬럼명 = 값, ...	-- 바꿀 내용
	where 조건;						--조건이 필요하다

-- 무를 공짜로
update jan03_product
	set p_price = 0
	where p_name = '무';
	
-- 배추를 김장용특대배추로 이름 수정
update jan03_product
	set p_name = '김장용특대배추'
	where p_name = '배추';
	
-- 모든 마트의 주차장 30% 줄이기
update jan03_market
	set m_parking = round(m_parking * 0.7, 1);
	
-- 홈플러스 판교점의 상품가격 10% 할인
update jan03_product
	set p_price = p_price * 0.9
	where p_m_no = (
		select m_no
		from jan03_market
		where m_name = '홈플러스' and m_location = '판교' --@@@@@@@@@@@@이거 1순위로 봐야함
	);

-- 제일 비싼 상품 10% 할인
update jan03_product
	set p_price = p_price * 0.9
	where p_price in(
		select max(p_price)
		from jan03_product
	);
------------------------------------------------------------------------
--내가
update jan03_product
	set p_price = 0
	where p_name = '무';
	
update jan03_product
	set p_name = '김장용특대배추'
	where p_m_no = 1
	
update jan03_market
	set m_parking = m_parking *  2.907;
	
update jan03_product
	set p_price = p_price * 0.9
	where p_m_no in (
		select m_no = 1
	);

update jan03_product
	set p_price = p_price * 0.9
	where max(p_price); in(
		select max(p_price)
	);




--내가
create table vage (
	v_no number(3) primary key,
	v_name varchar2(10 char) not null,
	v_gram number(6) not null,
	v_price number(6) not null,
	v_market varchar2(10 char) not null,
	v_location varchar2(10 char) not null,
	v_howp number(5) not null,
	v_parking number(4) not null
);
drop table vage cascade constraint purge;
drop table vage;
DROP SEQUENCE vage_seq;
select * from vage;
create sequence vage_seq;

insert into vage values(vage_seq.nextval, '배추', 3000, 10000, '홈플러스', '판교점', 1000, 500);
insert into vage values(vage_seq.nextval, '무', 500, 5000, '홈플러스', '강남점', 500, 300);
insert into vage values(vage_seq.nextval, '배추', 2000, 5000, '이마트', '서초점', 800, 800);
--------------------------------------------------------------------------------------
-- D - delete
delete from 테이블명
	where 조건식;
	
-- 무 삭제
-- 가장 좁은 매장의 상품 다 삭제
-- 내가
delete from jan03_product
	where p_name = '무';
	
delete from jan03_product
	where p_m_no in (
		select m_no
		from jan03_market
		where m_land = (
		select min(m_land)
		from jan03_market
		)
	);
-- 강사님
delete from jan03_product
	where p_m_no in (
		select m_no
		from jan03_market
			select m_land in(
			from jan03_market
		)
	);
--gpt
	DELETE FROM jan03_product
WHERE p_m_no IN (
    SELECT m_no
    FROM jan03_market
    WHERE m_land = (
        SELECT MIN(m_land)
        FROM jan03_market
    )
);
-----------------------------------------------------------------
-- 홈플러스 강남점이 폐점
delete from jan03_market
	where m_name = '홈플러스' and m_location = '강남';
-- 홈플러스 강남점이 없어지는데, 그 안에 있던 상품들은 어떻게 할지?
-- 그냥 두거나, / 같이 삭제 / 비워두거나...
-- 정답이 없어서... 나중에 프로젝트시 팀원들끼리 잘 상의해야!!!



























