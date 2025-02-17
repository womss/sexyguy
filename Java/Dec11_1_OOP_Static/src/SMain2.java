// 계산기
//		정수 2개를 넣으면 그 합은 출력하는 기능
public class SMain2 {
	public static void main(String[] args) {
		Calculator c= new Calculator();
		c.sum(10, 20);				// static O
		c.sum(10, 20, 30);			// static X
		////////////////////////////////////
		Calculator.sum(30, 50);		// static O
				// d위에보다 메모리를 덜 쓰고 해결
		// Calculator.sum(30, 50, 80);	// static X
		
		// 같은 맥락으로 Java의 내장 클래스 중 하나인 Math
		// 이거 또한 객체를 만들지 않고 사용한 경우!
		System.out.println(Math.PI);
		System.out.println(Math.sqrt(10));
		
//		내가
//		Calculator c = new Calculator();
		
//		c.num1 = 10;
//		c.num2 = 20;
//		
//		c.CalNum();
		
	}
}
