create table feb06_member (
	id varchar2(10 char) primary key,
	pw varchar2(20 char) not null,
	name varchar2(20 char) not null,
	phone varchar2(14 char) not null,
	birth date not null,
	photo varchar2(14 char) not null
);

select * from feb06_member;
drop table feb06_member;

	INSERT INTO feb06_member VALUES('admin', 'admin0000', 'kim-admin', '010-0000-0000', TO_DATE('2025-02-06')); 


select to_date(20250207, 'YYYYMMDD') from dual;