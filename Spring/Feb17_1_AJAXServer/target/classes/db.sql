create table feb17_fruit(
	f_name varchar2(10 char) primary key,
	f_price number(5) not null
);

select * from feb17_fruit;
drop table feb17_fruit;
-- 값 5-6개 insert

insert into feb17_fruit values('사과', 1000);
insert into feb17_fruit values('참외', 5000);
insert into feb17_fruit values('수박', 12000);
insert into feb17_fruit values('메론', 8000);
insert into feb17_fruit values('배', 3000);








































