// 생성자 ///일종의 메소드
//		1. 클래스에 생성자가 하나도 없으면
//		자바 컴파일러가 생성자를 만들어줌
//		2. 하위클래스 객체를 만들면 (Pen)
//			상위클래스 기본생성자 (Product2)를 자동 호출
public class Pen extends Product2{
	String color;
	
	public Pen() {
		super("ddsa", 321);
		// TODO Auto-generated constructor stub
	}

	public Pen(String color) {
		super(); // 2. 를 명시해놓은것
				// (없어도 무방)
		this.color = color;
	}

	public Pen(String name, int price, String color) {
		super(color, price);	// 2. 발동 (x)
							// super(파라미터)를 가진 생성자를 생성시(본 메소드)
							// Product2(이름, 가격)
							// 슈퍼 메소드가 의미하는 녀석은 프러덕트의 //얘다
							// 얘를 가져온 순간 기본생성자가 생기지 않기 때문에 기본생성자를 사용할 수 없다
		this.color = color;
	}
	
	
	
	
}
