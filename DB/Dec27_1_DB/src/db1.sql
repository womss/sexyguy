-- 웹사이트에서 게시판에 대한 테이블과
--	이를 [참조하는] 게시판 댓글 테이블을 만들려고 함
-- 게시판 테이블에는 [작성자 / 게시판 글 내용 / 작성 시간]
-- 댓글 테이블에는 [작성자 / 댓글 내용 / 작성 시간]

-- 1. 테이블의 구조를 파악해서 게시판 테이블 만들기
create table board(
	b_no number(4) primary key,
	b_owner varchar2(10 char) not null,
	b_txt varchar2(200 char) not null,
	b_when date not null
);
create sequence board_seq;
-- 2. 테이블의 구조를 파악해서 댓글 테이블 만들기
--	[조건 : 참조 되는 테이블의 내용이 삭제되면 관련있는 댓글도 삭제]
create table board_reply(
	br_no number(4) primary key,
	br_b_no number(4) not null,	-- 소속된 글 번호 / 이걸로 board를 참조!
	br_owner varchar2(10 char) not null,
	br_txt varchar2(200 char) not null,
	br_when date not null,
	constraint fk_board_reply foreign key(br_b_no) 
	references board(b_no)
	on delete cascade
);
create sequence board_reply_seq; -- 자동으로 번호 메기게 시퀀스 생성
select * from board_reply;
-- 3. 게시판 테이블에는 값 2개 넣고 / 각 게시글마다 댓글 2개씩 넣기
--	[조건 : date관련해서 넣을 값은 현재 날짜/시간으로 통일]
insert into board values(board_seq.nextval, '박비버', '안녕하세요', sysdate);
insert into board values(board_seq.nextval, 'Beaver Kim', 'Hi', sysdate);
insert into board_reply values(board_reply_seq.nextval, 1, '최비버', '으악', sysdate);
insert into board_reply values(board_reply_seq.nextval, 2, '박비버', '으악', sysdate);
insert into board_reply values(board_reply_seq.nextval, 1, '오비버', '으악', sysdate);
insert into board_reply values(board_reply_seq.nextval, 2, '정비버', '으악', sysdate);
select * from board;
select * from board_reply;
-- 4. 특정 게시글 하나 지우면 댓글들도 지워지는지 확인
delete from board where b_no = 1;

drop table board cascade constraint purge;
drop table board_reply cascade constraint purge;
drop sequence board_seq;
drop sequence board_reply_seq;

--------------------------------------------------------------------------
create table noticeboard (
	n_man varchar2(10 char) not null,
	n_post varchar2(2000 char) primary key not null,
	n_time date not null
);
select * from noticeboard;
drop table noticeboard cascade constraint purge;
--create sequence noticeboard_seq;
insert into noticeboard values('이순신', '내일 1 vs all함', sysdate);
insert into noticeboard values('장발장', '내일 빵 훔쳐옴', sysdate);


create table comments (
	c_man varchar2(10 char) not null,
	c_detail varchar2(200 char) primary key not null,
	c_time date not null,
	constraint fk_comments foreign key(c_detail) 
	references noticeboard(n_post)
	on delete cascade
);
select * from comments;
drop table comments cascade constraint purge;
--create sequence comment_seq;
insert into comments values('ㅇㅇ', '안옴', sysdate);


















