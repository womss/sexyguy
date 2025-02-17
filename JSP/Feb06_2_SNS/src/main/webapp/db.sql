create table feb06_sns(
	m_id varchar2(10 char) primary key,
	m_pw varchar2(12 char) not null,
	m_name varchar2(10 char) not null,
	m_phone varchar2(11 char) not null,
	m_birthday date not null,
	m_photo varchar2(200 char) not null
);

select * from feb06_sns;
drop table feb06_sns cascade constraint purge;

select * from FEB06_SNS where m_id = '' or '1'='1';
-- 1or'1'='1'

-------------------------------------------------------------
create table board(
	b_no number(3) primary key,
	b_writer varchar2(10 char) not null,
	b_when date not null,
	b_text varchar2(200 char) not null,
	constraint fk_board foreign key(b_writer)
		references feb06_sns(m_id)
		on delete cascade
);
create sequence board_seq;

select * from board;

drop table board cascade constraint purge;
drop sequence board_seq;














