import java.util.Random;

public class RMain4 {

	public static void main(String[] args) {
		// 1 ~ 100까지의 정수 중에서 6의 배수만 더한 값을 출력

		// 4x + 5y = 60이 되는 해(정수)를 모두 구해서
		// (x,y)의 형태로 출력
		// x, y는 둘 다 10 이하의 정수 (1 ~ 10)
//		int q = 0;
//		for (int i = 0; i <= 100; i += 1) {
//			if (i % 6 == 0) {
//				q += i;
//			}
//		}
//		System.out.println(q);
//		int x = 0;
//		int y1 = 0;
//
//		int a = 60;
//		for (int i = 0; i <= 60; i += 1) {
//			if (x % 4 == 0) {
//
//			}
//			if (y1 % 5 == 0) {
//
//			}
//
//		}
//
//		// 1 ~ 10사이의 랜덤한 정수를 출력
//		// 9가 나오면 반복문 종료
//
		Random r = new Random();
//		int ran = r.nextInt(10) + 1;
//		for (int e = 0; true; e++) {
//			if (ran == 9) {
//				break;
//			}
//		}

		// 반복 횟수가 명확 - for문(o)

		// 반복 조건 (if문의 반복조건)
		// while 문 : 조건을 먼저 검사
		// 조건이 true(참)인 동안에 계속 반복해서
		// 수행 부분을 실행시키는 반복문
		// 실행부분에서 조건을 false(거짓)으로 만들거나
		// break; 명령어로 반복문을 종료시킬 수 있음
		// 조건이 맞지 않으면 반복하던 작업을 중지

		// 반복 횟수를 정확히 알 수 없을 때,
		// 특별한 조건에서 멈춰야 하는 경우에 사용
		// while (조건식) {
		// 내용
		// }
		// 무한대로 반복하고 싶을 때 while (true) 사용
//		int y = r.nextInt(10) + 1; // 랜덤한 정수 하나 뽑기
//		while (y != 9) { // 9가 아니면 ( = 9가 나올때까지
//			System.out.println(y);
//			y = r.nextInt(10) + 1; // 다시 while으로 돌아가서
//									// 조건을 체크
//		}
//		System.out.println("==================");
//		
//		// do-while문 : 실행부터 하고 조건을 나중에 검사
//		//	한번은 반복이 보장O
//		//	(거의 안씀)
//		
//		int z = r.nextInt(10) + 1;
//		do {
//			System.out.println(z);
//			z = r.nextInt(10)+1;
//		} while (z !=9);
//		System.out.println("===============");
		
		// 1 + 2 + 3 + ... + 10 =?		=> 반복횟수가 정해진건 for문 사용이 좋다
		// 1 + 2 + 3 + ... + n <= 100	=> while문
		
		
		// 1 ~ n번째까지 더했을때 100이 넘어가면 반복문이 종료되게
		//	100을 안넘어가는 총 합은 몇인지 / n의 값은 몇인지 출력
		
		// 1000이하의 정수 중에서
		// 가장 큰 15의 배수 출력
		
		int sum = 0;
		for (int i = 0; true; i++) {
			sum += i;
			if (sum >= 100) {
				break;
			}
			System.out.println(sum);
//			System.out.println(i);
		}
		System.out.println(sum);
//		System.out.println(i);
		System.out.println("===============");
		int s = 0;
		for (int i = 1; i <= 1000; i+=15) {
			if (i % 15 == 0) {
				
				break;
			
			}
		}
		
	}
}














