import java.util.Scanner;
// 재귀적 호출 ( recursive call)
//	함수 속에서 자기 자신(이 함수)을 또 호출 => 반복

// 함수를 부른다 : 상대적으로 속도가 느린 작업

// 반복문 : ex) 내일 배울'for'문으로 해결 가능하긴 하다

// 기업에서 테스트할 때 이런 알고리즘을 응용해서
//	문제를 출제하는 경우가 있음

public class FMain1 {

	// 등차 수열
	// 정수를 하나 넣으면 ex)5
	// 1 + 2 + 3 + 4 + 5		(넣은 숫자까지)
	// 다 더한 값을 구해주는 함수
	
	// add(1) = 1
//	private static int add(int x) {
//		
//		return x * (x+1) /2;
//			// 5 x (5+1) /2
//	}
	

	
	
	// 정수를 하나 넣으면 factorial값 구하는 함수
	// ex) 6! = 720
	
//	public static int fac(int f) {
//		int ff = (f==1) ? 1 : fac(f-1) * f;
//		return ff;
//		
//	}
//	
//	
//	public static void main(String[] args) {
//		System.out.println(add(5));
//		int f = 6;
//		System.out.println(fac(f));
//	}
//}
	// add(2) = 3	=> add(1) + 2 => 1 + 2
	// add(3) = 6	=> add(2) + 3 => add(1) + 2 + 3
	// 					=> 1 + 2 + 3
	
//	public static int add(int i) {
//		int a = (i == 1) ? 1 :  add(i-1) + i;
//								5-1 + 5 = add(4) + add(5)//처음 이해한 바로는 그냥 add(9)가 되어버리는거임
//		
//		return a;
//		
//				
//
//	}
//	public static void main(String[] args) {
//		int i = 5;
//		add (i);
//	
//		
//		System.out.println(i1);
//	}
	
	// 피보나치 수열
	// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
	// p1, p1, p(1+1), p(1+2), p(2+3), p(3+4), ... 
	// 정수를 하나 넣었을 때 정수에 해당하는 자리에 있는 값 구하기
	//강사님
//	public static int fibo(int x) {
//		int an = (x<3) ? 1 : (fibo(x-1)+fibo(x-2));
//		return an;
//	}
//	
//	public static void main(String[] args) {
//		System.out.println(fibo(7)); 					// 여기가 좀 다름
//	}
	// 내가 
//	private static int pi (int p) {
//		int pp = (p==1||p==2 ? 1 : pi(p-1)+pi(p-2));
//		return pp;
//	}
//		
//	public static void main(String[] args) {
//		int p = 8;
//		pi(p);
//		System.out.println(pi(p));
//		
//	}
//}
	
	
	// 정수 하나 집어넣어서 (양수)
		//	각 자릿수의 숫자를 더한 값을 구하기
		// ex) 12321 => 1 + 2 + 3 + 2 + 1 => 9
			// nnnnn
			// 1n, 2n ,3n ,4n ,5n
			// 1n + 2n + 3n + 4n + 5n
			//(n % 1000) +  
			//

	//강사님
	public static int digitSum(int x) {
		int num = (x<10) ? x : (x % 10 + digitSum(x / 10));
		return num;				
	}							
	// 내가
//public static int ty() {
//	System.out.println("정수 입력 : ");
//	Scanner k = new Scanner(System.in);
//	int number = k .nextInt();
//	return number;
//}
//public static void typl(int t) {
//	
//}


	public static void main(String[] args) {
//		int t = ty();
//	System.out.println(ty());
		System.out.println(digitSum(12321));
		
	}


	
}
