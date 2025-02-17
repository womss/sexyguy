// 5. 연산자

//	산술 연산자 : + - * / %

// 거듭제곱
// let num1 = 2 ** 3;
// alert(num1);

// 우선순위
//	(*, /) > (*, -)

// 연산자를 줄여서 쓰는것도 가능 O
let num1 = 10;
// num1 = num1 + 5;
num1 += 5;

// 증감 연산자
let num2 = 20;
// num2++;


// 후위 증감 연산자(num2++)
// 변수의 현재값을 사용하고(리절트에 집어놓고), 그 다음의 변수의 값을 증감시킴
// let result = num2++;
// document.write(result); // 20


// 전위 증감 연산자(++num2)
// 변수의 값을 먼저 증감시키고, 그 다음에 변수의 값을 사용
let result = ++num2;
document.write(result); // 21

// 비교연산자 (Java때와 같음!)
// < > <= >= == !=
document.write("------------<br>");
document.write((10 > 5) + "<br>");
document.write((10 == 5) + "<br>");
document.write((10 < 5) + "<br>");
document.write("------------<br>");

// "10"과 10이 같은지 확인해주세요!
document.write(("10" == 10) + "<br>"); // true (O)
//		=> 자동 형 변환 때문에 true
document.write(("10" === 10) + "<br>"); // false !!!
//		=> ===, !== : 일치연산자 / 자료형까지도 비교를 해줌

// 논리연산자
//	|| (OR)
//	여러개 중 하나라도 true면 true를 반환
//		=> 모든 값이 false일때만 false를 반환
//	=> 첫번째 true값을 발견하는 즉시 멈춤

// && (AND)
//	모든 값이 true여야 true를 반환
//		=> 하나라도 false가 나오면 false를 반환
//	=> 첫번째 false값을 발견하는 즉시 멈춤

// ! (NOT)
//	반대의 값을 반환
//	true => false / false => true





































