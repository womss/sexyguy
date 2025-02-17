// function - class 밖에 만든 것 - x
//		(사실상 Java에는 function이라는 용어가 없음
// mrthod
//
//public static void printasdf() {
//	
//}

// method (member function (X) )
//		- class 속에 만든 것 (Class에 종속적인 함수라고 표현
//		- 여태까지 써온건 다 method였던거임


// Class : 객체를 찍언는 틀 (ex : 붕어빵 틀, 도장)
public class Bus {
	// 멤버변수 (Member Variable)
	//		- 속성 ( = attribute, field)
	//			≠ 전역변수 : 몇몇사람들은 멤버변수가 전역변수라고 하는데,
	//					Java에는 전역변수라는 개념이 없음
	//					전역변수는 C에서 유래되었고,
	//					함수의 외부에서 선언된 변수임
	//					그런데 Java에는 함수라는 것이 없으니
	//					전역변수가 존재할 수 없음
	//		- 객체의 데이터가 저장되는 공간
	//		- Class에 포함되는 변수 (Variable)
	
	// 버스번호
	// 버스의 차종
	// 버스회사
	// 버스의 운전사
	// 버스의 시작점
	int number;
	String what;
	String company;
	String driver;
	String startPoint;
	
	public void printInfo() {
		// this : 자기 자신을 말한다. (this. : 생략 가능 O)
		System.out.println(this.number);
		System.out.println(this.what);
		System.out.println(this.company);
		System.out.println(this.driver);
		System.out.println(startPoint);
	}
	
	// method(멤버 메소드)	- 액션, 프로그램상 필요한 기능
	//					- 객체의 동작에 해당하는 실행 블록
	public void go() {
		System.out.println("부릉부릉 ~ ");
	}
	
	
	
	
}












