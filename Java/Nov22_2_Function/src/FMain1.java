// 함수 (Function)
//		관련있는 기능(작업)들을 묶고
//		필요할때마다 불러서 (호풀해서) 사용이 가능 o



public class FMain1 {
	// public static 리턴타입 함수명(파라미터, 파라미터, ...) {
	// 		내용
	// 		return
	//	}
	
	//	리턴타입 : 반환될 값의 자료형
	//	합수 안에서는 식이 완성이 되고
	// 	main으로 번환할 결과값에 대한 자료형
	//	return이라는 것을 사용해서 반환을 할 것
	//	사용벅은 이따가...
	
	// 함수명 : 말 그대로 이 함수의 이름을 지정
	//	1. 숫자로 시작하먼 =>
	// 	2. 특수문자, 띄어쓰기 => 에러
	//	3. 자바문법(예약어) 사용 => 에러
	//		_로 시작해서 에러를 막는 방법도 있음
	//	Java의 문화)
	//	4. 함수명을 봐도 무슨 기능인지 알 수 있게
	//	5. 소문자로 시작
	//	6. 독성을 위해서
	//		뱀체 :abcd_efg_hijk
	//		낙타체 : abcEfgHijk
	//	7. 한글 x
	//	변수명 vs 함수명
	//	(명사)	(동사)
	
	// 파라미터 (인자, parameter)
	//	: 함수를 실행하는데 필요한 재료
	// 필요한 갯수만큼 사용하되, 자료형에 맞춰서 사용해야함
	
	
	
	public static void printMyThink() {
		System.out.println("해장국을 먹었다");
		System.out.println("왜냐하면");
		System.out.println("점심시간 이었고");
		System.out.println("배가 고팠기 때문에");
		
	
	}
	
	// 자기소개하는 함수 (이름, 핸드폰번호, 사는 곳 출력)
	public static void myself() {
		System.out.println("차성민");
		System.out.println("010-2323-2323");
		System.out.println("서울");
	}
	
	// 정수 두 개를 넣으면, 사칙연산 결과를 출력해주는 함수
	// 계산하는 함수
	// 계산을 하려면, 숫자가 필요
	// 파라미터(parameter) : 함수를 실행하는데 필요한 재료
	public static void calculate(int a, int b) {
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a /(double) b);
	}
	
	
	//	실행 시 JVM main을 자동으로 호출
	//	우리가 자동완성해서 사용한 이 main도 사실은 함수의 일종
	public static void main(String[] args) {
		printMyThink();
		// 지금 당장 생각하고 있는 내용을 출력
		
		
		myself();
		
		
		System.out.print("자기소개서 입니다\n정보를 입력해주세요.\n");
		System.out.print("이름 : ");
		// String na = ();
		
		System.out.println("________________________");
		calculate(10, 20); // 함수 호출
		
		
		
		
		
		
		
		
		
	}
}
