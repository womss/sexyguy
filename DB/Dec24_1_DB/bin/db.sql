create table hot(
	컬럼명 자료형 [옵션], -- 옵션 : 필요하면 넣는 것 ! / [] 넣는거 아님
	컬럼명 자료형,

);

-- 숫자형
--		NUMBER(P, S) : 십진수 기준
--			P : 정밀도 (Precision) / S : 범위 (Scale)
--			P는 소수점 기준 모든 유효숫자를 의미
--			만약 P에 명시한것 보다 큰 숫자값을 입력하게 되면 오류!
--			S가 양수면 소수점 이하, 음수면 소수점 이상(정수 부분)
--				의 유효숫자 자릿수를 나타냄
--			S에 명시한 숫자 이상의 값을 입력하면,
--				S에 명시한 숫자(자릿수)에서 반올림 처리함
--			P가 S보다 크면 S는 소수점 이하 유효숫자 자릿수를 나타냄
--			P : 숫자의 전체 자릿 수를 나타냄
--				소수점 포함 모든 자릿수를 의미
--			S : 소수점 위치를 기준으로 유효숫자의 자릿수
--				양수 : 소수점 이하 자릿 수
--				음수 : 소수점 이상의 자릿 수

--			값이 123.54인데
--			NUMBER(3)			=> 124
--								(S쪽은 명시하지 않아서 정수 3자리면 보여줌)
--								(소수점 이하 값을 버릴수는 없어서)
--								(소수점 첫째자리에서 반올림)
--			NUMBER(3, 2)		=> 오류 !?
--								(P가 3이고, 123.54는 유효숫자가 다섯자리)
--									여서 오류!,
--								요효숫자가 P보다 크면 오류가 발생 !) // ???
--			NUMBER(5, 2)		=> 123.54 // xxxxx 5자리에서 xxx.xx 소수점 두번째 전에서 반올림
--			NUMBER(7, 1)		=> 123.5 // xxxxxxx 7자리에서 xxxxxx.x소수점 첫번째 전에서 반올림
--			NUMBER(7, -1)		=> 120 // xxxxxxx 7자리에서 xxxxxxx 일의자리에서 반올림

--		FLOAT(P) : NUMBER의 하위타입 + 이진수 기준
create table testNum(
	t_num number(5),
	t_flo float(5)
);
insert into testNum values(12345, 12345);
select * from testNum;
drop table testNum cascade constraint purge;

-- float(5) 라고 하면, 5자리 10진수가 아닌 5자리 2진수(ex: 10110)을 의미
-- 부동 소수점 : 컴퓨터에서 실수를 표혀하는 방식
--	실수를 정확히 2진수로 표현하기 어려운 문제를 해결하기 위한 방식
--	부동소수점의 숫자의 저장 방식은 특정 비트 수로 제한되어 있고,
--	실제 저장되는 값은 제한된 비트 수에 따라 반올림처리가 됨
--	12345(10진수) = 11000000111001(2진수)

-- Float(5)에서는 5자리를 넘어가는 부분은 버림처리
--	5자리 2진수 중에서 가장 가까운 값은 11000000000000(2진수)

-- 11000000000000(2진수) = 12,288 (10진수)
-- 컴퓨터는 숫자를 아래와 같은 방식으로 저장함
--	부호(Sign) : 숫자가 양수인지 음수인지 나타냄
--	지수(Exponent) : 숫자의 크기를 결정
--	가수(Mantissa) : 유효숫자를 저장
--	컴퓨터가 부동소수점을 저장할 때, 가수의 비트 수가 제한되어서
--		유효숫자가 이 제한을 초과하면 가수의 일부를 잘라내거나 반올림함
--	12,288은 부동소수점에서 표현 가능한 숫자들 중에 12,000에
--		가장 가깝기 때문에 12,000이 저장 // 궁금한 사람들은 구글링

-- => 사실상 Oracle에서는 NUMBER형만 사용해도 됨
--		크기 설정에 있어서 P, S를 적절히 조절하면 됨!! *****
-------------------------------------------------------------------------차 형식에는 바차를 못넣나?
-- 날짜형
--		Date : 연도, 월, 일, 시, 분, 초까지 입력 가능
--		TimeStamp : 연도, 월, 일, 시, 분, 초, 밀리초까지 입력가능
-- => 주력은 Date !
-- java.util.Date / java.sql.Date => 자바에서 날짜 불러올때 / sql에서 날짜 불러올때 - 서로 호환이 잘됨














