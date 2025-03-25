// 생성자 (Constructor)
//		객체가 만들어질때 뭔가 작업을 해야하는데
//		=> 생성자 만들기!
//		리턴이 아예 없고, 생성자는 메소드인데 메소드 명이 클래스명과 같은 메소드
//		생성자를 만들지 않으면
//			=> 자바 컴파일러가 기본 생성자를 알아서 자동으로 만들어버림
//		기본생성자를 만들고 내부를 건드리면...
//			=> 자바 컴파일러가 기본 생성자를 안만들어줌
//			=> 시스템이 자동으로 객체를 만들때가 있는데...
//				=> 기본 생성자를 씀 => 에러! ///위에서 언급했듯 내부를 건드리면 에러가 뜸
public class Shoes {
	
	String name;
	int size;
	int price;
	static final String BRAND = "NIKE";
	
	// 기본 생성자 (Ctrl + Space)
	public Shoes() {
		// TODO Auto-generated constructor stub
	}
	
	// 생성자 오버로딩 가능(Ctrl + Shift + Space) (오버로딩된 생성자 라고 부름 ///오버로딩이 뭐지
	
	public Shoes(String name, int size, int price) { // 이거 뭐임//// 여기로 들어가게 되고
		super(); // 생략 가능 O (지워도 무방) /// 그럼 왜 존재?
				 // Java 최상위 객체인 Object !!
		// name = name; // 요청파라미터명 = 요청파라미터명
						// => 멤버변수에 접근이 안됨
		this.name = name;
		this.size = size;
		this.price = price; //// 여기 오는 놈들은 싹다 소문자 시작
	}
	
	public void printJam() {
		System.out.printf("신발 모델명 : %s\n", name);
		System.out.printf("신발 사이즈 : %,dmm\n", size);
		System.out.printf("신발 가격 : %,d원\n", price);
		System.out.printf("신발 브랜드 : %s\n", BRAND);
		System.out.println("----------------------------");
	}
	
	public void test(String name) {
		// 멤버변수명 / 파라미터명 같다면 ?
		//	this. 붙이게 되면 무조건 멤버변수
		//	붙이지 않으면 가장 가까이에 있는것
		System.out.println(name);/// 얘는 파라미터의 네임값
		System.out.println(this.name); ///얘는 맨위의 네임값
	}


}
