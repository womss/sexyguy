// 변수 왜 만드나요 ? : 데이터를 저장하려고 => Memory상의 공간에!
//		변수 : 데이터를 저장하는 공간

// 객체 왜 만드나요 ? : 실생활스러운 변수(속성)를 만들어서
//					알아보기 편하게!
//		=> static 없는 method 가지고 오려고

public class Calculator {
	// 멤버 변수가 필요없다라고 판단 => 저장할게 없음 /// 어차피 계산한번 하면 사라질 일회성이기 때문에
	//			=> 계산기 객체를 만들 필요가 없다
	//			=> static 메소드 기반///으로 만들면 해당 기능을 끌어올 수 있다
	
	public static void sum(int a, int b) {
		System.out.println(a+b);
	}
	
	public void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}
	
//	내가
//	int num1;
//	int num2;
//	
//	public void CalNum() {
//		System.out.println(num1+num2);
//	}
}
