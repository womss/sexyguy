-- 1. Oracle 서버에 다음 데이터를 표현할 수 있는
--	DB자료구조를 만드는 SQL문을 작성해주세요
create table jan03_computer (
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_os varchar2(20 char) not null,
	c_formatdate date not null,
	c_weight number(3, 2) not null,
	c_cpu varchar2(10 char) not null
);
select * from jan03_computer;
create sequence jan03_computer_seq;
------------------------------------------------------------------------
--2
	insert into jan03_computer values(jan03_computer_seq.nextval, '컴퓨터1',
		'Windows 10 Pro', to_date('2024-12-31', 'YYYY-MM-DD'), 5.12, 'i5-1234');
	insert into jan03_computer values(jan03_computer_seq.nextval, '컴퓨터2',
		'Windows 11 home', to_date('2025-01-02', 'YYYY-MM-DD'), 5.23, 'i7-5678');
	insert into jan03_computer values(jan03_computer_seq.nextval, '컴퓨터3',
		'Windows 10 pro', to_date('2025-01-01', 'YYYY-MM-DD'), 3.22, 'i7-1234');
-----------------------------------------------------------------------------------
--3
select min(c_formatdate), count(*) from jan03_computer;
--4
select c_name from jan03_computer;

select max(c_fomatdate) from jan03_computer
--진행방식
select c_name
	from jan03_computer
	where c_formatdate in (
		select max(c_formatdate)
		from jan03_computer
	);

--5
select * from jan03_computer order by c_weight -- 정렬먼저 해놓고

select *
	from(
		select rownum rn, c_no, c_name, c_os, c_formatdate, c_weight, c_cpu
			from (
				select *
				from jan03_computer
				order by c_weight
		)
	)
	where rn between 2 and 3;
--내가
create table com (
	c_name varchar2(10 char),
	c_system varchar2(20 char) not null,
	c_format date not null,
	c_weight number(4, 2) not null,
	c_cpu varchar2(10 char) not null
);
drop table com1;
select * from com;
--	- 컴퓨터이름 : 컴퓨터1
--	- 운영체제 : Windows 10 Pro
--	- 포맷날짜 : 2024-12-31
--	- 무게 : 5.12kg
--	- CPU : i5-1234
insert into com values('컴퓨터1', 'Windows 10 Pro', '2024-12-31', 5.12, 'i5-1234');
--	- 컴퓨터이름 : 컴퓨터2
--	- 운영체제 : Windows 11 home
--	- 포맷날짜 : 2025-01-02
--	- 무게 : 4.22kg
--	- CPU : i7-5678
insert into com values('컴퓨터2', 'Windows 11 home', '2025-01-02', 5.23, 'i7-5678');

-- 2. 1번에서 만든 테이블에, 데이터를 추가하는 SQL문을 작성해주세요
--	(1번 보기에 있는 데이터도 추가할 것 (총 3개의 데이터)
insert into com values('컴퓨터3', 'Windows 10 pro', '2025-01-01', 3.22, 'i7-1234');
--	- 컴퓨터이름 : 컴퓨터3
--	- 운영체제 : Windows 10 pro
--	- 포맷날짜 : 2025-01-01
--	- 무게 : 3.22kg
--	- CPU : i7-1234

-- 3. 포맷한지 가장 오래된 컴퓨터의 포맷 날짜와,
--	총 컴퓨터 수를 조회하는 SQL문을 작성해주세요
select c_format, count(*),
	from com
	where c_format in (
		select min(c_format)
		from com
		where count in (
			select c_name
		)
	);
--select c_name
--	from com
--	where c_format in (
--		select max(to date c_format)
--		from com
--	);


-- 4. 가장 최근에 포맷한 컴퓨터의 이름을 조회하는 SQL문을 작성해주세요

--select c_name
--	from com
--	where c_format in (
--		select max(to date c_format)
--		from com
--	);
	
-- 5. 2번째로 가벼운 컴퓨터 ~ 3번째로 가벼운 컴퓨터의
--	전체정보를 조회하는 SQL문을 작성해주세요



































