--create table jan03_student(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_height number(4, 1) not null,
	s_class varchar2(10 char) not null
);
create sequence jan03_student_seq;

insert into jan03_student values(jan03_student_seq.nextval,	'asdf', 172.1, '1강의장');
insert into jan03_student values(jan03_student_seq.nextval,	'zxcv', 168.3, '2강의장');
insert into jan03_student values(jan03_student_seq.nextval,	'qwer', 175.1, '2강의장');
insert into jan03_student values(jan03_student_seq.nextval,	'tyui', 153.1, '3강의장');
insert into jan03_student values(jan03_student_seq.nextval,	'ghjk', 190.8, '1강의장');
insert into jan03_student values(jan03_student_seq.nextval,	'vbnm', 176.2, '3강의장');
insert into jan03_student values(jan03_student_seq.nextval,	'poiu', 185.3, '3강의장');
insert into jan03_student values(jan03_student_seq.nextval,	'lkjh', 175.1, '2강의장');
insert into jan03_student values(jan03_student_seq.nextval,	'mnbv', 153.1, '3강의장');
insert into jan03_student values(jan03_student_seq.nextval,	'erty', 183.1, '1강의장');
select * from jan03_student; 

-- Window함수
-- 행과 행 사이의 관계를 쉽게 정의하기 위해 만든 함수
-- 복잡한 프로그램을 하나의 문장으로 쉽게 해결할 수 있음
-- 대표적으로 집계함수, 순위 함수가 있음

-- window 함수의 구조
select 컬럼명, 컬럼명, 집계함수, ...
	OVER ( [PARTITION BY 컬럼] [ORDER BY 컬럼] [WINDOWING절])
	from 테이블명;
-- OVER() : ORDER BY, GROUP BY구문을 대체할 수 있는 함수
--	PARTITION BY : 컬럼을 기준으로 해서 그룹(파티션)을 나눈다
--	ORDER BY : OVER함수 내에서 정렬
--	WINDOWING : 행 기준의 범위를 정함
--		ROWS : 범위를 지정(행을 기준으로)
--		RANGE : 범위를 지정(행이 가지고 있는 값을 기준으로)
--		BETWEEN ~ AND : 시작과 끝 위치를 설정
--		UNBOUNDED PRECEDING : 시작위치가 첫번째 행
--		UNBOUNDED FOLLOWING : 마지막 위치가 마지막 행

-- RANK : 중복 순위만큼 다음 순위값을 증가시킴
select s_name, s_class, s_height,
	rank() over(order by s_height desc) height_rank,
	rank() over(partition by s_class order by s_height desc) in_class_rank
	from jan03_student;
-- DENSE_RANK : 중복 순위가 존재해도 순차적으로 다음 순위값을 표시함
select s_name, s_class, s_height,
	rank() cver(order by s_height desc) RANK,
	dense_rank() over(order by s_height desc) DENSE_RANK
	from jan03_student;
																			--@@ 위 안됨

-- FIRST_VALUE : 그룹(파티션)에서 가장 처음 나오는 값
select s_class, s_name, s_height,
	first_value(s_name) over(partition by s_class order by s_height desc
	-- 강의장별로 그룹을 지었고, 그 안에서 학생들의 키 내림차순 정렬
	rows between unbounded preceding and unbounded following)
	-- 그 그룹내의 처음부터 끝까지 행에는 (퍼스트 밸류) 처음 나오는 학생의 이름을 불러오겠다
from jan03_student;

-- LAST_VALUE : 그룹(파티션)에서 가장 마지막에 나오는 값
select s_class, s_name, s_height,
last_value(s_name) over(partition by s_class order by s_height desc
-- 강의장별로 그룹을 지었고, 그 안에서 학생들의 키 내림차순 정렬
rows between unbounded preceding and unbounded following)
-- 그 그룹내의 처음부터 끝까지 행에는 (퍼스트 밸류) 마지막 나오는 학생의 이름을 불러오겠다
from jan03_student;

-- LAG : 이전 행의 값을 가져옴
select s_class, s_name, s_height,
decode(lag(s_height) over (partition by s_class order by s_height), null, '-',
-- 이전 행의 s_height값을 가져올건데 강의장별로 그룹을 지었고,
--	키 오름차순으로 정렬, 만약 이전행이 없어서 null값이면 '-'으로 바꾸고	
lag(s_height) over(partition by s_class order by s_height)) LAG_HEIGHT
-- 이전 행의 키값이 있으면 그 값을 불러오겠다
from jan03_student;

-- LEAD : 다음 행의 값을 가져옴
select s_class, s_name, s_height,
decode(LEAD(s_height) over (partition by s_class order by s_height), null, '-',
-- 다음 행의 s_height값을 가져올건데 강의장별로 그룹을 지었고,
--	키 오름차순으로 정렬, 만약 다음행이 없어서 null값이면 '-'으로 바꾸고	
LEAD(s_height) over(partition by s_class order by s_height)) LEAD_HEIGHT
-- 다음 행의 키값이 있으면 그 값을 불러오겠다
from jan03_student;

-- NTILE : 결과를 사용자가 지정한 그룹 수로 나눠서 출력
-- 키 내림차순 기준으로 5개의 그룹으로 나누기
select s_class, s_name, s_height,
	ntile(5) over (order by s_height desc) N_TILE
	from jan03_student;






































