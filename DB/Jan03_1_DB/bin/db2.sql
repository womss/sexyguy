-- 계층형 쿼리
-- 테이블에 계층형 데이터가 존재하는 경우 이걸을 조회하기 위한 쿼리
-- 계층형 데이터란, 동일 테이블에 계층적으로
--		상위데이터와 하위데이터가 포함된 데이터
-- 하드웨어를 예로..
--	중앙처리장치, 기억장치, 입출력장치의 상위데이터는 하드웨어다
--	입출력장치를 나눠서 입력장치, 출력장치의 상위데이터가 입출력장치

create table jan03_device(
	d_name varchar2(10 char) primary key,
	d_prior varchar2(10 char)
);

insert into jan03_device values('하드웨어', null);
insert into jan03_device values('중앙처리장치', '하드웨어');
insert into jan03_device values('기억장치', '하드웨어');
insert into jan03_device values('입출력장치', '하드웨어');
insert into jan03_device values('입력장치', '입출력장치');
insert into jan03_device values('출력장치', '입출력장치');

select * from jan03_device;

-- 계층형 쿼리의 형태
--	START WITH 조건		-- 계층 구조 전개 시작위치를 지정함
						-- 컬럼명 is null => 해당 컬럼에 null값이
						-- 들어있는 행을 시작위치로 설정
--	CONNECT BY [NOCYCLE] 조건
						-- connect by 절은 다음에 전개될
						-- 데이터를 지정하는데
						-- prior 하위데이터 = 상위데이터
						--	형태를 쓸 경우에는 순방향으로 전개
						-- prior 상위데이터 = 하위데이터 
						--	형태를 쓸 경우에는 역방향으로 전개
						-- NOCYCLE은 데이터를 전개하면서
						-- 	이미 나타난 데이터가 또 나오는걸 방지해줌
--	[ORDER SIBLINGS BY 컬럼] -- 동일 계층 사이에서 정렬을 해줌

-- select문
--		계층을 보기 위해 LEVEL이라는 것을 심어줌
select d_name, d_prior, LEVEL from jan03_device
	-- 이걸 통해 '하드웨어'행을 시작점으로 정함
	--	(null값이 들어있는 행부터 시작)
	start with d_prior is null -- 프라이어가 널값일때 실행하겠다
	-- 이 때 여기서 시작행인 '하드웨어'가 상위데이터가 되어
	--	다음 단계를 진행
	-- 하드웨어를 상위장치로 가지고 있는 cpu,ram,io는 레벨 2가 됨
	connect by prior d_name = d_prior;
--@@
select d_name, d_prior, LEVEL from jan03_device
	start with d_prior is null
	connect by prior d_name = d_prior;
--@@
	
	
-- 역방향 계층형 쿼리
select d_name, d_prior, LEVEL from jan03_device
	start with d_name = '입력장치' -- 시작점을 입력장치
	connect by prior d_prior = d_name;
						-- 역방향전개 (하위데이터 = 상위데이터)



































