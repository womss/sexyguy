import java.util.Scanner;

public class OMain1 {
	public static void main(String[] args) {
		// 변수
		// 자료형 변수명 = 값;
		/// ex) int size = 5;
		// = (대입연산자)
		// A = B
		// 우항에 있는 것을 좌항에 넣어라.
		// 변수에 값을 넣을 때 사용
		
		// 사칙연산 (Scanner + 출력)
		// 숫자는 2개만 입력받음 (x,y)
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("x값 : ");
		int x = k.nextInt();
		System.out.print("y값 : ");
		int y = k.nextInt();
		
		System.out.printf("x값과 y값을 곱하면 = %d\n", x*y);
		System.out.printf("x값에서 y값을 나누면 = %d\n", x/y);
		System.out.printf("x값에서 y값을 뻬면 = %d\n", x-y);
		
		// 사칙연산 : 산술연산자
		int plus = x + y;
		int minus = x - y;
		int mul = x * y;
		int divide = x / y;
				
		
		System.out.printf("%d + %d = %d\n", x, y, plus);
		System.out.printf("%d - %d = %d\n", x, y, minus);
		System.out.printf("%d x %d = %d\n", x, y, mul);
		System.out.printf("%d / %d = %d\n", x, y, divide);
		// int / int = int (Java 한정)
		//		ex) 10 / 4 = 2 (o), 2.5(x)
		// double / int = double
		// int / double = double
		// double / double = double
		
		double divide2 = (double) x / y; // 형 변환
		System.out.println(divide2);
		
		// 나누기 후에 나머지 값 구할 때
		int remainder = x % y;
		System.out.println(remainder);
		
		// x = 10, y = 4
		System.out.printf("x는 %d\n", x); // 10
		System.out.printf("y는 %d\n", y); // 4
		x = y;
		System.out.printf("x는 %d\n", x); // 4
		System.out.printf("y는 %d\n", y); // 4
		System.out.println("-------------");
		
		// 대입연산자, 산술여난자를 활용
		// [ +=, -=, /=, %= ]
		// 한 글자 2byte => 한 글자라도 덜 쳐서 용량을 아끼기 위한 연산자
		
		x += 1;		// x = x + 1;
		System.out.println(x);
		x *= 1;		// x = x * 1;
		System.out.println(x);
		x /= 1;		// x = x / 1;
		System.out.println(x);
		x %= 1;		// x = x % 1;
		System.out.println(x);
		
		
		// 한번 더 줄이기
		// ++, --
		
		x++;	// x += 1; 	// x = x + 1;
		System.out.println(x);
		x--;	// x -= 1;	// x = x - 1;
		System.out.println(x);
		
		
		
		
		
		
		
		
		
		
	}
}
