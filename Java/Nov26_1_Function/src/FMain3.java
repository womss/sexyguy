import java.util.Scanner;

public class FMain3 {
	// 각각의 합수에 정수 2개를 입력받아서
	// 그 정수 2개를 더했을 때 짝수면 결과 리턴,
	//		아니면 값을 재입력
	
	public static int getX() {
		Scanner k = new Scanner(System.in);
		System.out.print(" x : ");
		int x = k.nextInt();
		return x;
	}
	
	
	public static int getY() {
		Scanner k = new Scanner(System.in);
		System.out.print(" y : ");
		int y = k.nextInt();
		return y;
	}
	
	// 덧셈을 계산해서 결과를 리턴할 함수
	private static int getResult(int x, int y) {
		int sum = x + y;
//		return (sum % 2 == 0) ? sum : getResult(x , y);
		// 원하는 값(홀수)이 들어오지 않으면
		// 	무한 루프가 돌아감  ★★★★★ 
		//	=> 처음 홀수를 입력한 값이 계속 계산됨
		return (sum % 2 == 0) ? sum : getResult(getX(), getY());
	}
	
	
	public static void main(String[] args) {
		int x = getX();
		int y = getY();
//		System.out.println(x);
//		System.out.println(y);
		int sum = getResult(x, y);
		System.out.println(sum);
		
	}
	
	
}
