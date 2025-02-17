// 면접 질문...
// Call by Value, Call By Reference
// 어떻게 답이 도출되었는지 설명할 수 있어야...

// Call By Value : 변수의 '값'을 복사해서 함수의
//					파라미터 값으로 사용하는 것
// Call By Reference : 변수를 참조하는 주소값(번지값)을
//						파라미터로 전달하는 것

public class PMain4 {

	public static void test(int a, int[] b, int[] c) {
		System.out.println("b(green)" + b);			// b ??		o
		System.out.println("c(green)" + c);			// c ??		o
		System.out.println(a + "a(green)");			// 10 a		o
		System.out.println(b[0] + "b(green)");		// 10 b		o
		System.out.println(c[0] + "c(green)");		// 10 c		o
		System.out.println("--------------------");
		a = 100;	// 얘는 기본형이라 영향을 안주는데
		b[0] = 100; // main 함수에 영향을 줌 ( 참조형 )
					//	기본형과 참조형의 차이
					// 아래 처럼 새로 만들어낸건 (참조형이더라도) 영향을 안준다
		c = new int[] { 100, 200 };			// new 말 그대로 새로운 수를 만들어냄
		System.out.println("b(green)" + b);			// b ??		o	주소값
		System.out.println("c(green)" + c);			// c ??		o	주소값(달라짐)
		System.out.println(a + "a(green)");			// 100 a	o	100
		System.out.println(b[0] + "b(green)");		// 100 b	o	100
		System.out.println(c[0] + "c(green)");		// 100 c	o	100
		
	}
	//
	public static void main(String[] args) {
		int a = 10;
		int[] b = { 10, 20 };
		int[] c = { 10, 20 };
		System.out.println("b(red) " + b);			// b ??		o
		System.out.println("c(red) " + c);			// c ??		o
		System.out.println("===================");		
		test(a, b, c);
		System.out.println("===================");
		System.out.println(a + "a(red)");			// 10 a		o
		System.out.println(b[0] + "b(red)");		// 10 b		x
								// *** 값 변경에 영향을 받았음
		System.out.println(c[0] + "c(red)");		// 10 c		o
								// *** 값 변경에 영향을 받지 않았음
								// test함수의 변경된 c와는 다르기 떄문
		
	}
	
	
}


//파라미터를 넘길때 주소값이 같은게 확인 되는데
//	이게 Call by Reference지 라고 말하는 소수 의견
		
//Java에서 파라미터를 넘기는 과정에 직접적인 참조를 넘긴게 아닌,
//	주소 값을 복사해서 넘기기 떄문에 이것은 Call By Value다
//	라고 말하는 다수 의견		









