--스마트폰에 대한 테이블을 생성
--
--스마트폰의 이름, 가격, 운영체제(OS), 화면 크기(인치, 소수점 두 번째 자리까지), 배터리 용량(mAh, 최대 10000), 출시일을 속성으로 가져야 함
--조건: 하나의 기본키(PK)를 가져야 하고, 모든 값은 채워넣어야 함
--스마트폰의 배터리 기술이 발전해서 최대 20000mAh까지 지원할 수 있게 됨.
create table phone (
	p_name varchar2(20 char) primary key not null,
	p_price number(7) not null,
	p_os varchar2(5 char) not null,
	p_inch number(4, 2) not null,
	p_battery number(5) constraint p_check check (p_battery between 0 and 10000)  not null,
	p_start date not null
);
select * from phone;
drop table phone cascade constraint;
--이때 배터리 컬럼의 용량을 변경하는 문장 작성
alter table phone modify p_battery number(8);
--스마트폰의 **카메라 화소(MP)**에 대한 컬럼을 추가하는 문장 작성
--단위: MP, 정수만 허용
--이 컬럼은 값이 반드시 입력되어야 함
alter table phone add p_mp number(8);
--스마트폰에서 화면 크기 대신 **화면 해상도(Resolution)**를 기록하고 싶음.
--화면 크기 컬럼의 이름을 해상도 컬럼명으로 변경
alter table phone rename column p_inch to p_resolution;
--스마트폰의 출시일 컬럼을 삭제하는 문장 작성
alter table phone drop column p_start; 
--스마트폰의 가격이 [500000 ~ 3000000] 사이의 값만 입력될 수 있도록 해당 컬럼을 변경하는 문장 작성
alter table phone r
--만든 테이블을 완전히 삭제하는 문장 작성