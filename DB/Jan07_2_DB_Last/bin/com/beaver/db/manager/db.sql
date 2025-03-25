-- 어떤 특정한 식당에 대한 테이블
-- 식당 지점(체인점 지역), 식당 주인, 좌석 수

-- 예약 테이블
-- 예약자 이름, 예약 시간/날짜, 예약자 전화번호, 예약 지점

-- 각 테이블당 데이터 2-3개씩
create table jan08_restaurant (
	r_location varchar2(10 char) primary key,
	r_owner varchar2(10 char) not null,
	r_seat number(3) not null
);
insert into jan08_restaurant values('강남', '홀길동', 100);
insert into jan08_restaurant values('검단', '최길동', 80);

select * from jan08_restaurant;
drop table market;
drop sequence jan08_restaurant_seq;
DROP TABLE jan08_restaurant CASCADE CONSTRAINTS;


select * from jan08_reservation;
create table jan08_reservation (
	r_no number(3) primary key,
	r_name varchar2(10 char) not null,
	r_time date not null,
	r_phonenum varchar2(20 char)not null,
	r_location varchar2(20 char) not null,
	constraint jan08_reservation foreign key(r_location)
		references jan08_restaurant(r_location)
		on delete cascade
);
select * from jan08_reservation;
create sequence jan08_reservation_seq;

insert into jan08_reservation values(jan08_reservation_seq.nextval, '김길동',
	to_date('2025-01-30 12:30',' YYYY-MM-DD HH24:mi'), '010-1234-5678', '강남');
insert into jan08_reservation values(jan08_reservation_seq.nextval, '이길동',
	to_date('2025-01-30 12:30',' YYYY-MM-DD HH24:mi'), '010-1234-5678', '강남');
insert into jan08_reservation values(jan08_reservation_seq.nextval, '이길동',
	to_date('2025-01-30 12:30',' YYYY-MM-DD HH24:mi'), '010-1234-5678', '검단');


-------------------------------------------------------------
-- 내가
create table market (
	-- 마켓넘버
	m_no number(3) primary key,
	-- 마켓이름
	m_name varchar2(10 char)not null,
	-- 마켓주인
	m_ceo varchar2(10 char)not null,
	-- 마켓좌석
	m_seat number(4) not null
);
create sequence market_seq;

insert into market values(market_seq.nextval, '쿠우쿠우', '쿠덕배', 80);
insert into market values(market_seq.nextval, '명륜진사갈비', '침착맨', 50);
insert into market values(market_seq.nextval, '메이찬', '메덕배', 30);
	
select * from market; -- 마켓테이블 보기
drop table market;
drop sequence market_seq;
DROP TABLE market CASCADE CONSTRAINTS;




create table booking (
	-- 예약 넘버
	b_no number(3) primary key,
	-- 예약자
	b_name varchar2(10 char) not null,
	-- 예약 날짜
	b_date date not null,
	-- 예약자 연락처
	b_phone varchar2(15 char)not null,
	-- 예약식당
	b_market number(3) not null,
	
	constraint fk_booking foreign key(b_market)
		references market(m_no)
		on delete cascade
);
create sequence booking_seq;

insert into booking values(booking_seq.nextval, '쿠팡맨',
	to_date('2025-01-20 12:30',' YYYY-MM-DD HH24:mi'), '01012345678', 1);
insert into booking values(booking_seq.nextval, '쏘영맘',
	to_date('2025-01-25 3:00',' YYYY-MM-DD HH24:mi'), '01023456789', 2);
insert into booking values(booking_seq.nextval, '메메메',
	to_date('2025-02-16 8:20',' YYYY-MM-DD HH24:mi'), '01098765432', 3);

select * from booking; -- 부킹테이블 보기
drop table booking;
drop sequence booking_seq;
DROP TABLE booking CASCADE CONSTRAINTS;

-- 동일한 사람이 같은 곳 여러번 예약 가능
-- 동일한 사람이 같은 곳 같은 시간대 예약 불가능
-- 다른 사람이 같은곳 같은 시간대 예약 불가능
-- 시트도 고려





















