-- 1. 노트북에 대한 테이블을 생성
-- 노트북의 이름, 가격, CPU, RAM(MB, 64MB가 최대라고 가정),
--	HDD(GB 단위), 보증 기간을 속성으로 갖게 하고 싶음
--	조건에 부합하는 테이블을 생성하는 문장
--		[하나의 기본키(PK)를 가져야하고, 모든 값은 채워넣어야 함)

create table laptop (
	l_name varchar2(10 char) not null,
	l_price number(7) not null,
	l_CPU varchar2(7 char) not null,
	l_RAM number(2) not null,
	l_HDD number(3) not null,
	l_Warranty varchar2(10char) primary key not null
);
insert into laptop values('그램2', 1300000, 'i7-1234', 64, 256, '2026-12-31');
select * from laptop;

-- 2. 노트북의 사양이 좋아져서 128GB짜리 RAM을 사용하게 되었음
--		이 때 RAM 컬럼의 용량을 변경하는 문장 작성				// 128로 어떻게 바꾸지
alter table laptop modify l_RAM number(3);
select * from laptop;
-- 3. 노트북의 크기(인치)에 대한 컬럼을 추가하는 문장 작성
--		[단위 cm, 소수점 두번째자리까지 나타낼 것]
--		[이 컬럼은 빈 값으로 넣을 수 없음]
alter table laptop add l_inch number(5, 2) default 0;
alter table laptop drop column l_inch;
select * from laptop;
-- 4. 노트북에는 앞으로 HDD대신 SSD가 장착됨
--	HDD 컬럼의 이름을 SSD 컬럼명으로 변경하는 문장 작성
alter table laptop rename column l_HDD to l_SSD;
select * from laptop;
-- 5. 보증기간 컬럼을 삭제하는 문장 작성
alter table laptop drop column l_Warranty;
select * from laptop;
-- 6. 노트북의 가격이 [800000 ~ 2300000] 사이의 값만 들어갈 수 있게끔
--		해당 컬럼을 변경하는 문장 작성
alter table laptop rename column l_price to l_price number(7) constraint ex8_check check (col1 between 800000 and 2300000) 
-- 7. 만든 테이블을 완전히 삭제하는 문장 작성












































