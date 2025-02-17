// 논리연산자, 비교연산자, 일치연산자의 결과값 true, false를 가지고
// 6. 조건문
//	어떤 조건에 따라서 이후에 실행이 달라지게 하는 문법

// if문 (Java와 같다)
/*
if (조건 A) {
	조건 A가 성립하면 해당 블록을 실행
} else if (조건 B) {
	조건 A가 아니고 조건 B가 성립하면 해당 블록을 실행
} ... {
	
} else {
	위의 조건들에 모두 해당하지 않는 나머지의 경우 해당 블록을 실행
}
*/

// sitch-case
//	case가 다양할 때, 보다 간결하게 나타낼 수 있다는 장점

/*
switch (변수) {
	case 값1:
		내용
	case 값2:
		내용
	...
	default:
		내용
}
*/

// 사과 : 100원
// 바나나 : 200원
// 키위 : 300원
// 멜론 : 500원
// 수박 : 500원
// 사고싶은 과일을 입력(prompt)해서 그 가격을 출력(alert)

let buy = prompt("사고 싶은 과일을 입력", "");
switch (buy) {
	case "사과":
		alert(`${buy } : 100원 입니다`);
		break;
	case "바나나":
		alert(`${buy } : 200원 입니다`);
		break;
	case "키위":
		alert(`${buy } : 300원 입니다`);
		break;
	case "멜론":
	case "수박":
		alert(`${buy } : 500원 입니다`);
		break;
	default:
		alert(`${buy }...? 그런거 없는데요 ?`);
		break;
		
}


