// static => 이걸 다루는거 자체가 고급
//			=> 적재적소에 다룰 수 있어야

// 콘솔창에 어떻게
class Number {
	static int num = 0; // static 멤버변수 : 객체들의 공통속성(공통적인 속성이다)
	int num2 = 0;
}
public class SMain3 {
	public static void main(String[] args) {
		Number Number1 = new Number();
		Number Number2 = new Number();
		Number1.num++; //1
		Number1.num2++;//?
		System.out.println(Number1.num);		// 1
		System.out.println(Number1.num2);		// 1
		System.out.println(Number2.num);		// 1
		System.out.println(Number2.num2);		// 1
		
		
	}
	
	
	
}
