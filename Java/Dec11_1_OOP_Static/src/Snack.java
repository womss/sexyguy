
// 멤버 변수 : 객체의 속성 => (객체.속성 으로 표현) /// ex) s.name();
//				this : 이 객체를 뜻함 (생략 가능 O)

// 이 세상의 모든 과자를 김비버가 만든다고 하면?? // 제조한사람의 값을 고정하는게 낫다
//		이 때 사용하는게 *** static 멤버변수 !
//			- 객체가 없어도 쓸 수 있는 정보
//				=> 클래스명.xxx로 사용
//			- 객체들의 공통속성 ///을 담아낼때 사용, 이 세상의 모든 과자를 김비버가 만들었다(공통속성)
//				=> 객체를 여러개 찍어내도 static멤버변수는 하나만 !
//				=> 메모리를 절약 O
//			- Static 영역의 데이터는 프로그램의 시작부터
//				종료가 될 때까지 메모리에 남아있게 됨 /// 가비지컬렉션이랑 다른 기전 그건 해당뭐가 끝나면 사라짐
//			- 무분별하게 많이 사용하다보면 메모리가 부족해질 수 있음

// static final 멤버변수
//		수정불가! => 상수화 (값을 변경하지 않겠다!)
//		static final 자료형 변수명(대문자로 / 문화임) = 내용;

// static 메소드
//		객체가 없어도 사용 가능하다! => 메모리가 절약됨
//			static이 아닌 멤버변수는 static 메소드에 접근 불가능!!! /// ???
//객체 배열 문자열 힙
public class Snack { // 과자의 틀
	String SnackName; // 과자의 속성
	double Gram;
	int Price;
//	static String manufacturer = "김비버";
	static final String MANUFACTURER = "김비버";
	
	
	public void printInfo() {
		System.out.printf("이름 : %s\n", this.SnackName);
		System.out.printf("무게 : %.1fg\n", Gram);
		System.out.printf("가격 : %,d원\n", this.Price);
		System.out.printf("생산자 : %s\n", MANUFACTURER);
		System.out.println("======================");
	}
	
	public static void printTaste() {
		System.out.println(MANUFACTURER);
		// System.out.println(SnackName); // static이 아닌 멤버변수라서 에러 /// ???
		System.out.println("크 ~ JMT !");
		System.out.println("======================");
		
		
	}
//	public static void name(s1) {
//		
//		System.out.println(s1.Gram);
//	}
}
