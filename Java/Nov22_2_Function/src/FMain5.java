public class FMain5 {
	
	// 오버로딩(Overloading) ★★★★★ 고급 기술 ★★★★★
	//	ㄴ직관적인 설명을 해보자면 )함수명 같게, 파라미터를 다르게 하는 기술
	// 	호출할 때 어떤 값을 넣었느냐에 따라 함수가 호출되게 하는 기술
	
	// 같은 자료형을 써도, 파라미터의 갯수가 다르면 오버로딩 사용 가능
	// 파라미터의 갯수가 같아도, 다른 자료형을 사용하면 오버로딩 사용 가능
	
	
	
	
	
	
	// 정수 2개를 넣으면 그 합을 출력해주는 함수
	public static void printSum1(int a, int b) {
		System.out.println(a + b);
		
	}
	
	// 정수 3개를 넣으면 그 합을 출력해주는 함수
	public static void printSum2(int a, int b, int c) {
		System.out.println(a + b + c);
	}
	// 실수 3개를 넣으면 그 합을 출력해주는 함수
	public static void printSum3(double a, double b, double c) {
		System.out.println(a + b + c);
	}
	
	
	public static void main(String[] args) {
		printSum1(10,20);
		printSum2(10,20,30);
		printSum3(1.1, 2.2, 3.3);
		System.out.println("_______________");
		//파라미터를 이용하길 의도 ★★★★★★★
		
		// 사실 우리는 첫 날부터 이 오버로딩을 사용하고 있었다
		// System.out.println(); => 오버로딩의 대표적인 예시
	}
}
