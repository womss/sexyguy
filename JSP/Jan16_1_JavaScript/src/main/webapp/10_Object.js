// 10. 객체 (Object)

// 제가 키우는 강아지는 '마루', 5살
let dog = {
	name: "마루",
	age: 5,
}

// 객체는 중괄호 안에서 구성되며, key와 value로 구성된 프로퍼티(속성)
// 각각 쉼표로 구분하고, 마지막에는 쉼표가 없어도 되지만
// 나중에 수정할 것을 생각하면 쉼표 적어놓는 것도 괜찮음

// 접근
console.log(dog.name);
console.log(dog['age']);

// 객체에 뭔가 추가 하고 싶다면
dog.gender = "Male";
dog["furColor"] = "white";

// 삭제
delete dog.furcolor;
///////////////////////////////////////////////////////////////////////////
// 단축 프로퍼티
let name = "Beaver";
let age = 5;

let person = {
	name: name,
	age: age,
	gender: "Male",
} // 이 상태를 좀 더 줄이면...

let person2 = {
	name,
	age,
	gender: "Male",
}	// 이런 형태로 표현 가능 O
// (이 때, key와 value에서 받아올 변수의 이름이 같아야 함!!!!)

// 존재하지 않는 속성에 접근하면, 에러가 발생하는게 아닌 undefined값 나옴! 다른건 어디가 오류다 아는데 undefined는 한눈에 찾기 쉽지 않음

// 이 때, 'in' 연산자를 활용하면 내가 찾는 속성이 있는지 확인할 수 있음
console.log('birthday' in person);	// false
console.log('age' in person);		// true

for (let key in person) {
	console.log(key);
	console.log(person[key]);
}

// 함수로 객체 만들기
function makeObject(name, age) {
	return {
		name,
		age,
		hobby: "Game",
	}
}
let beaver = makeObject("Beaver", 5);
console.log(beaver); // f12 여기서 나오는 프로토 타입은 자바의 클래스같은




























