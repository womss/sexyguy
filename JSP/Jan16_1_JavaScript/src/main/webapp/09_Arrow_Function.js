// 9. 화살표 함수 (Arrow Function)

// 8번 파일에서 다뤘던 함수를 '함수 선언문'이라고 함
/*
	function sayHello() {
		console.log("Hello");
	}
	sayHello();
	
// '함수 표현식'
/*
	let sayHello = funtion() {
		console.log("Hello");
	}
	sayHello();
*/

// 문법에는 어떤 차이가 있을까 ?! => 답은 '호출하는 타이밍'
// 함수 선언문은 어디서든지 호출해서 사용할 수가 있음 O
sayHello();
function sayHello() {
	console.log("Hello");
}
// 어떻게 가능할까...?

// JS는 프로그램이 실행되기 전에 모든 '함수 선언문'을 찾아 모아서
// 메모리에 저장하고 있다가 필요할 때 내부적으로 끌어올려서 사용하는 것
//	저장이 되어있기 때문에 => 함수가 먼저 호출이 되어도 오류없이 잘 작동 O
// 실제적으로 코드가 끌어올려지는 것은 아니고,
//	실제 메모리상에도 변화는 없음
// 이것을 '호이스팅(Hoisting)' 이라고 함 ★★★★★

// '함수 표현식'은 코드에 도달하면 생성
// '그래서 뭘 쓰면 되나요?' => 뭐가 좋다기 보다는 그냥 편한거 쓰세요 ~
// 더 자유롭고 편하게 코딩하고 싶다? => 함수 선언문

// 화살표 함수
//	여지껏 봤던 함수들보다 더 간결하게 작성할 수 있는 함수
/////////////함수 선언문 -> 먼저 호출할 수 있음///함수 표현식 -> 화살표 함수
/*
	1.
		let add = function(num1, num2) {
		return num1 + num2;
	}

	2.
		let add = (num1, num2) => { // 1번의 펑션이 2번의 화살표
			return num1 + num2;
		}
	3. return을 생략 가능 O
		let add = (num1, num2) => {
			num1 + num2;
		}
	4. 반환할 코드가 한 줄이라면 => 중괄호 생략 가능 O
		let add = (num1, num2) => num1+ num2;
		console.log(add(3, 2)); // 불러올 때는 이렇게
		
	5. 파라미터가 하나라면...=> 파라미터가 들어갈 소괄호 생략 가능 O
		let sayHello2 = name => `Hello, ${name }`;
	
	6. 파라미터가 없는 함수라면 소괄호 생략 불가능!!
	let asdf = () => console.log('asdf');
*/

// Function vs Method
let human = {
	name: "김비버",
	walk: function() {
		console.log("뚜벅뚜벅");
	} // Method : 객체 프로퍼티(속성)로 할당 된 함수            이거 왜 안나옴
}
human.walk();
























