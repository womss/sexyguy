create table feb12_student(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_nickname varchar2(10 char) not null
);
create sequence feb12_student_seq;

select * from feb12_student;

delete from feb12_student where s_no = 37;
//시퀀스 삭제
DROP SEQUENCE feb12_student_seq;
// 테이블 삭제
drop table feb12_student;
----------------------------------------------------------------// index와 db를 이어주기 위해선 자바가 하나 필요

create table feb12_test(
	s_subject varchar2(10 char) not null,
	s_date date not null
);

select * from feb12_test;

insert into feb12_test values ('영어', TO_DATE('20230203', 'YYYYMMDD'))

drop table feb12_test;
