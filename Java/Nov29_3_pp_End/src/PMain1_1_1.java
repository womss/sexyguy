import java.util.Scanner;

public class PMain1_1_1 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int num = 0;
		while (true) {
			System.out.println("숫자 입력(0) 입력하면 종료");
			num = k.nextInt();
		
			if (num == 0) {
				System.out.println("종료");
				break;
			}
			System.out.printf("[%d]의 약수는 : ", num);
			for (int i = 1; i < num; i++) {
				if (num % i == 0) {
					System.out.printf("%d ,", i);
				}
			}
			System.out.println(num);
		}
		
		
		
		
		
	}
}