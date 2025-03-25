-- JOIN
-- 하나의 명령(쿼리)문에 의해 여러 테이블에 저장된 데이터를
--		한번에 조회할 수 있는 기능
-- 마치 하나의 테이블인것처럼 보여줌

create table tb1 (name varchar2(10 char), age number(3));
create table tb2 (name varchar2(10 char), age number(3));

insert into tb1 values('김비버', 30);
insert into tb1 values('박비버', 35);
insert into tb1 values('최비버', 40);
insert into tb1 values('오비버', 40);

insert into tb2 values('김비버', 30);
insert into tb2 values('정비버', 50);
insert into tb2 values('이비버', 55);
---------------------------------------------------------------------------
-- cross join : 별도의 조건 없이 두 테이블간의 가능한
--				모든 결과를 조회 (모둔 경우의 수 ex:진짜정보,가짜정보)
select * from tb1, tb2;
select * from tb1 cross join tb2;
-- 사실상 안씀 ㅋㅋㅋ

--inner join : 조건에 해당하는 값만 나옴
select * from tb1 inner join tb2 on tb1.name = tb2.name;
select * from tb1 A, tb2 B where A.name = B.name;
select * from tb1 join tb2 using (name);
select * from tb1 natural join tb2; -- 자연조인
								-- 조건절 없이 양쪽에 같은 이름값을 가진
								-- 동일한 컬럼만을 조회
								
-- outer join : outer join을 사용하는 이유는
--				기준 테이블의 데이터가 모두 조회(누락 없이) 되고,
--				대상 테이블에 데이터가 있는 경우 해당 컬럼의 값을
--				가져오기 위해서!!
-- (+) 를 이용한 outer join : null이 출력되는 테이블의 컬럼 (+) 기호 추가! // 뭔말

-- left outer join : 왼쪽 테이블에 값이 있을 시 오른쪽 테이블이
--						조건에 맞지 않아도 나옴
--						(조건이 맞지 않으면 null로 메꿈)
--					Right보다는 Left를 더 많이 씀
--					(왼쪽 테이블을 기준으로 두는 경향 O)
select * from tb1 left outer join tb2 on tb1.name = tb2.name;
select * from tb1, tb2 where tb1.name = tb2.name (+);

-- right outer join : 오른쪽 테이블에 값이 있을 시 왼쪽 테이블이
--						조건에 맞지 않아도 나옴
--						(조건에 맞지 않으면 null로 메꿈)
select * from tb1 right outer join tb2 on tb1.name = tb2.name;
select * from tb1, tb2 where tb1.name (+)= tb2.name;

-- full outer join : 한쪽 테이블에 값이 있을 때,
--					다른쪽 테이블이 조건이 맞지 않아도 나옴
select * from tb1 full outer join tb2 on tb1.name = tb2.name 

-- self join *** 헷갈림
-- 하나의 테이블 내에 잇는 컬럼끼리 연결하는 조인이 필요한 경우

-- 한 웹사이트에 회원이 5명이 있고, 관리자가 2명이 있다
-- 회원의 이름은 각각 회원1 ~ 5, 관리자의 이름은 관리자1, 2
-- 회원의 ID는 각각 member1 ~ 5, 관리자의 ID는 manager1, 2
-- 회원 1 ~ 3번은 관리자 1이 관리 / 나머지 회원은 관리자 2가 관리
-- 하나의 테이블을 만들어서 표현! + 데이터 insert까지!
create table jan03_website (
	m_id varchar2(10 char) primary key,
	m_name varchar2(10 char) not null,
	m_manager varchar2(10 char)
);
insert into jan03_website values('member1', '회원1', 'manager1');
insert into jan03_website values('member2', '회원2', 'manager1');
insert into jan03_website values('member3', '회원3', 'manager1');
insert into jan03_website values('member4', '회원4', 'manager2');
insert into jan03_website values('member5', '회원5', 'manager2');
insert into jan03_website values('manager1', '관리자1', null);
insert into jan03_website values('manager2', '관리자2', null);

select * from jan03_website;

-- 각 관리자가 어떤 회원을 관리하는지 알고 싶음
--		관리자ID, 관리자 이름, 회원 ID
-- select 컬럼명
--	from 기준테이블 join 대상테이블 on 조건;
-- 내가
select m_id as 관리자 ID,
		m_name as 관리자 이름,
		m_id as 회원 ID
	from jan03_website w1, jan03_website w2
	where w1.m_id = w2.m_manager;
-------------------------------
-- 강사님
select A.m_id, A.m_name, B.m_id
	from jan03_website A join jan03_website B
	on A.m_id = B.m_manager
-- 강사님내가
select	A.m_id as 관리자 id,
		A.m_name,
		B.m_id
	from jan03_website A join jan03_website B
	on A.m_id = B.m_manager

	
	
-----------------------------------------------------------------------------------
--내가
create table web (name varchar2(10 char), id varchar2(10 char), member_num number(3), manager_num number(3));

drop table web;

insert into web values('회원1', 'member1',1,0);
insert into web values('회원2', 'member2',1,0);
insert into web values('회원3', 'member3',1,0);
insert into web values('회원4', 'member4',2,0);
insert into web values('회원5', 'member5',2,0);

insert into web values('관리자1', 'manager1',0,1);
insert into web values('관리자2', 'manager2',0,2);


--select * from manager;
--select * from member;
select * from web left outer join web on web.member_num = web.manager_num ; 


































