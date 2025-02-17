-- 커피 테이블 // PK + 모든 컬럼값 채우도록 // 하는게 not null?
--	커피이름, 커피가격, 커피 칼로리, 제조날짜
create table dec26_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(5) not null,
	c_kcal number(3) not null,
	c_start date not null		-- 데이트 썼어야 함
);

insert into dec26_coffee values('아메리카노', 3000, 15, sysdate); -- sysdate 참고 // 이거 왜 안됨 // 주석은 실행시키고 넣는게 속편함
select * from dec26_coffee;

-- DDL에서 Create문을 다룰 수 있게 되었음!
--	비교적 쉬운 alter / drop / truncate

-- 데이터 타입 변경 / 컬럼의 크기(용량) 변경
alter table [테이블명] modify [컬럼명] [데이터타입(용량)];

-- 값이 있는 상태에서 기존과 다른 데이터타입으로 변경하면 에러!
alter table dec26_coffee modify c_name number(3); -- 다른 데이터타입 같은 용량
-- 값이 있는 상태에서 용량을 적게 변경하면 에러!
alter table dec26_coffee modify c_name varchar2(2 char); -- 같은 데이터타입 적은 용량 바꿨다가 안되는걸로 바꾸면?

-- 주의사항 : 데이터타입을 변경할 때는 해당 컬럼의 값을 모두 지워야만
--				변경이 가능함 => 그렇지 않으면 오류가 발생 ex)20, 22
--			컬럼의 용량을 줄일 경우, 해당 컬럼의 용량을 조회해서
--			변경할 용량보다 큰 값이 있는지 확인하고
--				=> 그 값을 변경 !

-- 컬럼명 변경
alter table [테이블명] rename column [기존 컬럼명] to [바꿀 컬럼명];
alter table dec26_coffee rename column c_name to c_name2;
select * from dec26_coffee;

-- 컬럼 추가
alter table [테이블명] add [컬럼명] [데이터타입(용량)] [제약조건(생략가능)];
-- 기존의 데이터가 없어야 not null 가능O
alter table dec26_coffee add c_taste varchar2(20char) not null; -- c_taste에 대한 값이 안들어가서(10번줄 참고) null이 들어가는데 마지막에 not null을 넣었기 때문에 상충해서 오류
alter table dec26_coffee add c_taste varchar2(20char);
select * from dec26_coffee;

-- 컬럼 삭제
alter table [테이블명] drop column [컬럼명];
alter table dec26_coffee drop column c_taste;
-------------------------------------------------------------------------------------
-- 테이블 내의 내용 지우기
truncate table [테이블명];
truncate table dec26_coffee;
-- 테이블에 있는 데이터를 삭제하지만, 테이블의 구조 자체는 삭제하지 않음
select * from dec26_coffee;

-- 테이블 삭제 시(table을 휴지통에 넣은 상황)
drop table [테이블명] cascade constraint; --외래키 제약 조건 걸려있을 경우 cascade constraint 붙이기
drop table dec26_coffee cascade constraint;
select * from dec26_coffee;

-- 휴지통에 있는 테이블을 복원
flashback table [테이블명] to before drop;-- 드랍하기 전으로 돌리겠다
flashback table dec26_coffee to before drop;
select * from dec26_coffee;

-- 휴지통 비우기
purge recyclebin;

-- 휴지통에 넣기 + 비우기 => 테이블 완전 삭제 (휴지통에 저장되지 않음)
drop table [테이블명] cascade constraint purge;
drop table dec26_coffee cascade constraint purge;
-----------------------------------------------------------------------------------
-- DDL : 사실상 신입한테 맡기지 않음!
--	경력있는 DBA들이 테이블을 만들어서 CRUD정도만 하게끔 할 것!














