-- 요식업 프랜차이즈 (참조관계 고려 X)

-- 홍콩반점 제주점은 홍길동이 운영하고 100석
-- 홍콩반점 종로점은 김길동이 운영하고 80석
-- 한신포차 강남점은 홍길동이 운영하고 150석
-- 부천포차 부천점은 최길동이 운영하고 130석
create table jun02_franchise(
	f_no number(3) primary key,
	f_name varchar2(10 char) not null,
	f_location varchar2(10 char) not null,
	f_ceo number(3) not null,					
	f_seat number(3) not null
);

drop table jun02_franchise cascade constraint purge;
drop sequence jun02_franchise_seq;
create sequence jun02_franchise_seq;

insert into jun02_franchise values(jun02_franchise_seq.nextval,
	'홍콩반점', '제주', 1, 100);
insert into jun02_franchise values(jun02_franchise_seq.nextval,
	'홍콩반점', '종로', 2, 80);
insert into jun02_franchise values(jun02_franchise_seq.nextval,
	'한신포차', '강남', 3, 150);
insert into jun02_franchise values(jun02_franchise_seq.nextval,
	'부천포차', '부천', 4, 130);
select * from jun02_franchise;
------------------------------------------------------------------------------------------------
-- CEO
-- 홍길동, 1990-03-01일생, 남자
-- 김길동, 1992-02-01일생, 여자
-- 홍길동, 1991-12-12일생, 여자
-- 최길동, 1989-09-01일생, 남자
create table jun02_ceo (
	c_no number(3) primary key,	
	c_name varchar2(4 char) not null,
	c_birthday date not null,
	c_gender char(2char) not null
);
drop table jun02_ceo cascade constraint purge;
drop sequence jun02_ceo_seq;
create sequence jun02_ceo_seq;

insert into jun02_ceo values(jun02_ceo_seq.nextval, '홍길동',
	to_date('1990-03-01', 'YYYY-MM-DD'), '남자');
insert into jun02_ceo values(jun02_ceo_seq.nextval, '김길동',
	to_date('1992-02-01', 'YYYY-MM-DD'), '여자');
insert into jun02_ceo values(jun02_ceo_seq.nextval, '홍길동',
	to_date('1991-12-12', 'YYYY-MM-DD'), '여자');
insert into jun02_ceo values(jun02_ceo_seq.nextval, '최길동',
	to_date('1989-09-01', 'YYYY-MM-DD'), '남자');
select * from jun02_ceo;

------------------------------------------------------------------------------------------------
-- 짜장면, 5000원, 홍콩반점 제주점(100명)에서 파는
-- 불닭발, 12000원, 한신포차 강남점(150명)에서 파는
--	... 매장당 메뉴 5개정도!
create table jun02_menu (
	m_no number(3) primary key,
	m_name varchar2(10 char) not null,
	m_price number(5) not null,
	m_f_no number(3) not null
);
drop table jun02_menu cascade constraint purge;
drop sequence jun02_menu_seq;
create sequence jun02_menu_seq;

insert into jun02_menu values(jun02_menu_seq.nextval,'짜장면', 5000, 1);
insert into jun02_menu values(jun02_menu_seq.nextval,'짜장밥', 5500, 1);
insert into jun02_menu values(jun02_menu_seq.nextval,'볶음밥', 7000, 1);
insert into jun02_menu values(jun02_menu_seq.nextval,'유산슬', 20000, 1);
insert into jun02_menu values(jun02_menu_seq.nextval,'멘보샤', 14000, 1);
insert into jun02_menu values(jun02_menu_seq.nextval,'짜장밥', 6000, 2);
insert into jun02_menu values(jun02_menu_seq.nextval,'짬뽕밥', 8000, 2);
insert into jun02_menu values(jun02_menu_seq.nextval,'차돌짬뽕', 10000, 2);
insert into jun02_menu values(jun02_menu_seq.nextval,'고추잡채', 17000, 2);
insert into jun02_menu values(jun02_menu_seq.nextval,'삼선짜장', 13000, 2);
insert into jun02_menu values(jun02_menu_seq.nextval,'불닭발', 12000, 3);
insert into jun02_menu values(jun02_menu_seq.nextval,'계란찜', 6000, 3);
insert into jun02_menu values(jun02_menu_seq.nextval,'모래집', 10000, 3);
insert into jun02_menu values(jun02_menu_seq.nextval,'문어발', 3000, 3);
insert into jun02_menu values(jun02_menu_seq.nextval,'해물떡볶이', 16000, 3);
insert into jun02_menu values(jun02_menu_seq.nextval,'제육볶음', 12000, 4);
insert into jun02_menu values(jun02_menu_seq.nextval,'어묵탕', 10000, 4);
insert into jun02_menu values(jun02_menu_seq.nextval,'콘치즈', 5000, 4);
insert into jun02_menu values(jun02_menu_seq.nextval,'오징어땅콩', 8000, 4);
insert into jun02_menu values(jun02_menu_seq.nextval,'한치', 9000, 4);

select * from jun02_menu;
-----------------------------------------------------------------------------------------------
--내가
create table franchise(
	f_branch varchar2(10 char) primary key,				-- 프렌차이즈 이름
	f_owner varchar2(5 char) not null,					-- 프렌차이즈 오너
	f_seat number(3) not null							-- 프렌차이즈 좌석
);

select * from franchise;
drop table franchise cascade constraint purge;

insert into franchise values('홍콩반점 제주점', '홍길동', 100);
insert into franchise values('홍콩반점 종로점', '김길동', 800);
insert into franchise values('한신포자 강남점', '홍길동', 150);
insert into franchise values('부천포차 부천점', '최길동', 130);

create table ceo (
	c_name varchar2(4 char) not null,					-- 점주 이름
	c_birth date primary key not null,					-- 점주 생년월일
	c_sex varchar2(2 char) not null						-- 점주 성별
);
select * from ceo;
drop table ceo cascade constraint purge;

insert into ceo values('홍길동', '1990-03-01', '남자');
insert into ceo values('김길동', '1992-02-01', '여자');
insert into ceo values('홍길동', '1991-12-12', '여자');
insert into ceo values('최길동', '1989-09-01', '남자');

create table cf (
	cf_no number primary key,
	cf_menu varchar2(10 char) not null,					-- 메뉴
	cf_price number(5) not null,						-- 가격
	cf_branch varchar2(10 char) not null				-- 매장 이름
);
select * from cf;
drop table cf cascade constraint purge;
drop sequence cf_seq;

create sequence cf_seq;
insert into cf values(cf_seq.nextval,'짜장면', 8000, '홍콩반점 제주점');
insert into cf values(cf_seq.nextval,'짬뽕', 8000, '홍콩반점 제주점');
insert into cf values(cf_seq.nextval,'탕수육', 21000, '홍콩반점 제주점');
insert into cf values(cf_seq.nextval,'볶음밥', 7500, '홍콩반점 제주점');
insert into cf values(cf_seq.nextval,'잡채밥', 8000, '홍콩반점 제주점');

insert into cf values(cf_seq.nextval,'불닭발', 12000, '한신포차 강남점');
insert into cf values(cf_seq.nextval,'콩나물국', 7000, '한신포차 강남점');
insert into cf values(cf_seq.nextval,'계란말이', 9000, '한신포차 강남점');
insert into cf values(cf_seq.nextval,'날치알주먹밥', 8000, '한신포차 강남점');
insert into cf values(cf_seq.nextval,'옛날통닭', 21000, '한신포차 강남점');

insert into cf values(cf_seq.nextval,'짜장면', 7000, '홍콩반점 종로점');
insert into cf values(cf_seq.nextval,'짬뽕', 8000, '홍콩반점 종로점');
insert into cf values(cf_seq.nextval,'탕수육', 21000, '홍콩반점 종로점');
insert into cf values(cf_seq.nextval,'깐풍기', 23000, '홍콩반점 종로점');
insert into cf values(cf_seq.nextval,'군만두', 5000, '홍콩반점 종로점');

insert into cf values(cf_seq.nextval,'부천국수', 7000, '부천포차 부천점');
insert into cf values(cf_seq.nextval,'부천지짐이', 9000, '부천포차 부천점');
insert into cf values(cf_seq.nextval,'부천통닭', 23000, '부천포차 부천점');
insert into cf values(cf_seq.nextval,'부천화채', 19000, '부천포차 부천점');
insert into cf values(cf_seq.nextval,'부천어묵탕', 25000, '부천포차 부천점');
-----------------------------------------------------------------------------
-- 각 가게의 대표메뉴중에서 가격이 가장 비싼 메뉴를 조회하되,
-- 점주의 이름과 생년월일도 함께 보여주세요 또한,
-- 특정 조건으로 여성 점주만을 필터링합니다
select cf_menu, ceo_name, cbirth















