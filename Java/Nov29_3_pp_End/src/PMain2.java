
public class PMain2 {
	
	// 정수 두 개를 넣으면 그 합을 출력하는 함수
	
	
	public static int x() {
		int x = 2;
		return x;
	}
	
	public static int y() {
		int y = 4;
		return y;
	}
	
	public static void pp(int x, int y) {
		int a = x+y;
		System.out.println(a);
	}
	
	// 정수 세 개를 넣으면 그 합을 출력하는 함수
	// *** 오버로딩 : 굳이 함수 이름을 다르게 할 필요 없음
	//			(본질이 같다면)
	//강사님
	private static void printSum(int a, int b, int c) {
		System.out.println(a + b + c);
	}
	
	public static void ppp(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	
	// 정수를 n개 넣으면 그 곱을 출력하는 함수
	//	(파라미터가 몇 개인지 모름...)						// 이거 모름
	//	함수 파라미터의 갯수 무제한으로 할 수 있음
	//		(자료형... 변수명)
	public static void printMul(int...n) {
		int mul = 1;
		// 함수 내에서 사용할 때는 배열처럼...
		for (int i = 0; i < n.length; i++) {
			mul *= n[i];
		}
		System.out.println(mul);
	}
	
	public static void main(String[] args) {
		int x = x();
		int y = y();
		pp(x,y);
		ppp(1,2,3);
//		printSum(10,20)
		printSum(10,20,30);
		printMul(1,2,3,4,5,6,7,8,9,10);
	}
	
	
	
	
}
