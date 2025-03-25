-- 1. 노트북에 대한 테이블을 생성
-- 노트북의 이름, 가격, CPU, RAM(MB, 64MB가 최대라고 가정),
--	HDD(GB 단위), 보증 기간을 속성으로 갖게 하고 싶음
--	조건에 부합하는 테이블을 생성하는 문장
--		[하나의 기본키(PK)를 가져야하고, 모든 값은 채워넣어야 함)
create table dec26_notebook(
	n_name varchar2(20 char) primary key,
	n_price number(7) not null,
	n_cpu varchar2(10 char) not null,
	n_ram number(2) not null check (n_ram between 0 and 64), 
	n_hdd number(4) not null,
	n_warranty date not null
);
select * from dec26_notebook;
-- 2. 노트북의 사양이 좋아져서 128GB짜리 RAM을 사용하게 되었음
--		이 때 RAM 컬럼의 용량을 변경하는 문장 작성				// 128로 어떻게 바꾸지
alter table dec26_notebook modify n_ram number(3) check (n_ram between 0 and 128); --check 왼쪽에 낫널을 넣지 않아도 이미 넣었기 때문에 낫 널로 유지


-- 3. 노트북의 크기(인치)에 대한 컬럼을 추가하는 문장 작성
--		[단위 cm, 소수점 두번째자리까지 나타낼 것]
--		[이 컬럼은 빈 값으로 넣을 수 없음]
alter table dec26_notebook add n_inch number(4, 2) not null;

-- 4. 노트북에는 앞으로 HDD대신 SSD가 장착됨
--	HDD 컬럼의 이름을 SSD 컬럼명으로 변경하는 문장 작성
alter table dec26_notebook rename column n_hdd to n_ssd;

-- 5. 보증기간 컬럼을 삭제하는 문장 작성
alter table dec26_notebook drop column n_warranty;

-- 6. 노트북의 가격이 [800000 ~ 2300000] 사이의 값만 들어갈 수 있게끔
--		해당 컬럼을 변경하는 문장 작성
alter table dec26_notebook modify n_price number(7) check (n_price between 800000 and 2300000); 
--alter table dec26_notebook modify n_price number(7) constraint n_check check (n_price between 800000 and 2300000); -- 제약조건 추가 버전 



-- 7. 만든 테이블을 완전히 삭제하는 문장 작성
drop table dec26_notebook cascade constraint purge;
select * from dec26_notebook;
























