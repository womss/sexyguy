import java.util.Scanner;

public class CMain2_2 {
	
	// 숫자 하나를 입력
		// 입력받은 정수값이 5보다 크면 새로운 변수 y에
		// 정수 10을 담아서 출력
		// 입력받은 정수값이 3보다 크면 새로운 변수 y에
		// 정수 20을 담아서 출력
	
	public static int num() {
		Scanner k = new Scanner(System.in);
		System.out.println(" 정수 입력 : ");
		int n = k.nextInt();
		return n;
	}
	
	public static void name(int n) {
		int y = 0;
		if (n>5) {
			y = 10;
			System.out.println(y);
		}
		else if (n>3) {
			y = 20;
			System.out.println(y);
		}
		
	}
	
	
	public static void main(String[] args) {
		int n = num();
		name(n);
	}

}
