import java.util.Random;

public class RMain4_1 {
	public static void main(String[] args) {
		// 1 ~ 100까지의 정수 중에서 6의 배수만 더한 값을 출력
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 6 == 0) {
				sum += i;
				System.out.printf("현재 숫자 : %d\n",i);
				System.out.printf("현재 합 : %d\n", sum);
				System.out.println("=====================");
			}
		}
		System.out.println("총합 : "+sum);
		System.out.println("==============");
				// 4x + 5y = 60이 되는 해(정수)를 모두 구해서
				//	(x,y)의 형태로 출력
				// x, y는 둘 다 10 이하의 정수 (1 ~ 10)
		for (int x = 0; x <=10; x++) {
			for (int y = 1; y <= 10; y++) {
				if ((4 * x) + (5 * y) == 60) {
					System.out.printf("(%d,%d)", x, y);
				}
			}
		}
		
		// 1 ~ 10사이의 랜덤한 정수를 출력
		// 9가 나오면 반복문 종료
		System.out.println();
		Random r = new Random();
		int x = 0;
		for (int i = 0; true; i++) {
			x = r.nextInt(10)+1;
//			System.out.println(x);
			if (x == 9) {
				break;
			}
			System.out.println(x);
		}
		System.out.println("================");
		
		// 1 ~ n번째까지 더했을때 100이 넘어가면 반복문이 종료되게
		//	100을 안넘어가는 총 합은 몇인지 / n의 값은 몇인지 출력
		int sum1 = 0;
		int num1 = 0;
		while (sum1 <= 100) {
			num1++;
			sum1 += num1;
		}
		System.out.printf("n의 값 : %d\n", num1);
		System.out.printf("총 합 : %d\n", sum1);
		System.out.println("===================");
		// 1000이하의 정수 중에서
		// 가장 큰 15의 배수 출력
		int num2 = 1000;
		while (num2 % 15 > 0) {
			num2--;
			
		}
		System.out.printf("1000이하 정수 중에서 " + "가장 큰 15의 배수 : %d\n", num2);
		
		
	} 
		
		
		
		
}


