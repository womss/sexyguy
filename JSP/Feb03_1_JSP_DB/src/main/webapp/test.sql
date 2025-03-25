-- 사과 테이블 : 지역 / 색 / 맛 / 가격 / 소개	정보

-- 데이터 2 ~ 3개 정도 넣기

create table feb03_apple (
	a_location varchar2(10 char) primary key,
	a_color varchar2(10 char) not null,
	a_flavor varchar2(10 char) not null,
	a_price number(10) not null,
	a_info varchar2(100 char) not null
)
	
	insert into feb03_apple values('서울', '빨강', '단맛', 4000, '충주사과!!!!!');
	insert into feb03_apple values('강남', '초록', '쓴맛', 99999, '약사과!');
	select * from feb03_apple;

-- 가격 오름차순






















