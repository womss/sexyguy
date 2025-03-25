-- < 쓸만한 내장 함수 >
--	1. 숫자 함수
--		- ABS(숫자) : 절대값 계산				ex)ABS(-4.5)
--		- ROUND(숫자, m) : 숫자 반올림, m은 반올림 기준 자릿수
--											ex) ROUND(5.36, 1)
--		- POWER(숫자, n) : 숫자의 n제곱 값을 계산
--											ex) POWER(2, 3)
--		- TRUNC(숫자, m) : 숫자의 m전째 자리까지 남기고 값을 버림
--											ex) TRUNC(123.456, 2)
--											ex) TRUNC(123.456, -1)
--											ex) TRUNC(123.456, 0)
--		- MOD(m, n) : 숫자 m을 n으로 나눈 나머지
--											ex) MOD(12,10)
--		- SQRT(숫자) : 숫자의 제곱근 값을 계산 (숫자는 양수 !)
--											ex) SQRT(9.0)
select ABS(-4.5) from dual; -- 4.5
select ROUND(5.36, 1) from dual; -- 5.4
select POWER(2, 3) from dual; -- 8
select TRUNC(123.456, 2) from dual; -- 123.45
select TRUNC(123.456, -1) from dual; -- 120
select TRUNC(123.456, 0) from dual; -- 123
select MOD(12,10) from dual; -- 2
select SQRT(9.0) from dual; -- 3
-------------------------------------------------------------------------------
-- 2. 문자 함수
--		- CONCAT(s1, s2) : 두 문자열을 연결
--								ex) CONCAT('ABCD', 'EFG')
--		- SUBSTR(s1, n, k) : 문자열의 n번째부터 k만큼의 길이을 반환
--								ex) SUBSTR('ABCDEFG', 3, 4)
--		- INSTR(s1, s2, n, k) : s1의 n번째부터 시작해서 찾고자 하는
--								s2가 k번째 나타내는 문자열의 위치를 반환
--								ex) INSTR('Hello', 'l', 1, 2)
--		- LPAD(s, n, c) : 문자열 s의 왼쪽부터 지정한 자릿수 n까지
--							지정한 문자 c로 채워줌
--								ex) LPAD('ABC', 5, '*')
--		- RPAD(s, n, c) : 문자열 s의 오른쪽부터 지정한 자릿수 n까지
--							지정한 문자 c로 채워줌
--								ex) RPAD('ABC', 5, '*')
--		- LTRIM(s1, s2) : 문자열 s1 기준으로 왼쪽에 있는
--							지정한 문자 s2 제거
--								ex)LTRIM('ABC*', '*')
--		- RTRIM(s1, s2) : 문자열 s1 기준으로 오른쪽에 있는
--							지정한 문자 s2 제거
--								ex)RTRIM('ABC*', '*')
--		- REPLACE(s1, s2, s3) : s1의 지정한 문자 s2를 문자 s3로 변경
--								ex) REPLACE('JACK and JUE', 'J', 'BL')
--		- LENGTH(s1) : 글자수를 세어주는 함수
--								ex) LENGTH('ㅋㅋㅋ')
--		- LENGTHB(s1) : 글자의 용량(바이트)을 세어주는 함수
--								ex) LENGTHB('ㅋㅋㅋ')
----------------------------------------------------------------------------------------
select CONCAT('ABCD', 'EFG') from dual; -- ABCDEFG
select SUBSTR('ABCDEFG', 3, 4) from dual; -- CDEF
select INSTR('Hello', 'l', 1, 2) from dual; -- 4
select LPAD('ABC', 5, '*') from dual; -- **ABC
select RPAD('ABC', 5, '*') from dual; -- ABC**
select LTRIM('ABC*', '*') from dual; -- ABC*
select RTRIM('ABC*', '*') from dual; -- ABC
select REPLACE('JACK and JUE', 'J', 'BL') from dual; -- BLACK and BLUE
select LENGTH('ㅋㅋㅋ') from dual; -- 3
select LENGTHB('ㅋㅋㅋ') from dual; -- 9
-----------------------------------------------------------------------------------------
-- 3. 날짜 / 시간 함수 
--		[날짜형식]
--		YYYY : 4자리 연도
--		YYY, YY, Y : 각각 4자리 연도의 마지막 3, 2, 1 자리
--		MM : 월
--		DD : 1달 중 날짜(일자)
--		DAY : 요일 (월요일 ~ 일요일)
--		DY : 요일 약자 (월 ~ 일)
---------------------------------
--		HH, HH12 : 12시간
--		AM or PM : 오전 or 오후
---------------------------------
--		HH24 : 24시간
--		MI : 분
--		SS : 초

--	- SYSDATE : 현재 시간 / 날짜를 반환
--	- TO_DATE(s1, datetime형식) : 문자열 s1 데이터를 날짜 데이터로 변환
select to_date('2024-12-31 오전 06:00', 'YYYY-MM-DD- PM HH:MI') from dual;
--	- TO_CHAR(date, datetime형식) : 날짜데이터를 문자형으로 변환
select to_char(sysdate, 'YYYY-MM-DD') from dual;
--	특정 날짜 값을 받아오고 싶다면 sysdate자리에
--		to_date함수를 넣으면 됨!
--	=> 반한되는 데이터 타입이 다르다!!!!
--	TO_DATE는 문자열을 날짜형으로 / TO_CHAR는 날짜형을 문자형으로

--	- ADD_MONTHS(date, 숫자) : 날짜에서 지정한 달만큼 더함
--								(1 : 다음달, -1 : 이전달)
select add_months(sysdate, -3) from dual;
--	- LAST DAY(date) : 그 달의 마지막 날을 반환
select last_day(sysdate) from dual;
----------------------------------------------------------------------------------
-- 실행 날짜 기준 연도 조회 (테이블 헤더에 '연도' / 컬럼에 '2024년')
select to_char(sysdate,'YYYY') || '년' 연도 from dual;		-- 연도는 넣었는데 년 넣기 개빡셌네
-- 실행 날짜 기준 월 조회 (테이블 헤더에 '월' / 컬럼에 '12월')
select to_char(sysdate,'MM') || '월' 월 from dual;
-- 실행 날짜 기준 일 조회 (테이블 헤더에 '일' / 컬럼에 '27일')
select to_char(sysdate,'DD') || '일' 일 from dual;
-- 실행 기준 시/분 조회 (테이블 헤더에 각각 '시', '분')
--					(컬럼에 각각 '?시', '?분' )
select to_char(sysdate,'HH24') || '시' 시,
	to_char(sysdate,'MI') || '분' 분 from dual;
-- 실행 기준 시간대가 오전인지 오후인지 조회
-- 별칭에 띄어쓰기, 특수문자가 들어가거나, 숫자로 시작하는 경우
--	별칭을 큰따옴표로 감싸주세요 !
select to_char(sysdate,'PM')"오전/오후" from dual;
-- 문자열 '2024-12-31 오전 07:23'을 문자열 '2024.12.31' 로 조회
select to_char(to_date('2024-12-31 오전 07:23', 'YYYY-MM-DD PM HH:MI'), 'YYYY.MM.DD') from dual;
select replace(substr('2024-12-31 오전 07:23' , 1, 10), '-', '.') from dual; -- 0이 아닌 1부터 시작! // 2024 - <- 작대기 바꾸기
-- 실행 기준 3달 전 마지막 날은 몇월 며칠인지 조회
-- 패턴이 아닌 고정문자열('월', '일')을 지정할 때는
--		고정문자열을 큰 따옴표로 묶어서 패턴이 아닌 문자열임을 알려줘야함
select to_char( 
	last_day(add_months(sysdate, -3)), 'MM-DD') from dual;
select to_char( 
	last_day(add_months(sysdate, -3)), 'MM"월" DD"일"') from dual;
----------------------------------------------------------------------------------
-- 4. 집계 / 분석 함수 - select 컬럼명 쪽이나, having 절에서 사용!
--		- AVG(컬럼명) : 평균 // 컬럼명을 집어넣으면 컬럼에 대한 평균값을 구함
--		- COUNT(컬럼명) : 검색되는 데이터 수
--		- MAX(컬럼명) : 최대값
--		- MIN(컬럼명) : 최소값
--		- SUM(컬럼명) : 총합
--		- RANK : 중복 순위만큼 다음 순위값을 증가시킴
--		- DENSE_RANK : 중복 순위가 존재해도 순차적으로 다음 순위값 표시
------------------------------------------------------------------------------------
-- 5. NULL 관련 함수
-- NULL : 미확인 값이나 아직 적용되지 않은 값
--			0이나 비어있는 공란도 아님

--	- NVL 함수 : NULL인 경우에만 지정된 값으로 대치하는 함수
--		NVL(값, NULL일때 대체값)
select nvl(null, 'B'), nvl('A', 'B') from dual;

--	- NVL2 함수 : NULL의 여부에 따라 지정한 값으로 대치하는 함수
--		NVL2(값, 값이 있을때 대치값, NULL일때 대치값)
select nvl2(null, 'A', 'B'), nvl2('c', 'A', 'B') from dual;





























































