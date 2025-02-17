import java.util.Random;

public class RMain1_1 {
	public static void main(String[] args) {
//		
//		
//		for (int i = 0; i < ; i++) {
//			
//		}
//		
//		
//		
//		Random r = new Random();
//		int rr = r.nextInt(10)+1;		// 랜덤한 숫자를 하나 뽑아서
//		for (int i = 0; i < 5; i++) {
////			System.out.printf("%d, %d\n", i, rr);		// 그 숫자 출력 기능을 5번 반복
//			System.out.println(rr);		// 그 숫자 출력 기능을 5번 반복
//		}// 0 = rr, 1= rr,  2 3 4
//		System.out.println("========================");
//		for (반복 횟수 지정) {
//			실행할 코드
//		}
		
		// ㅋ을 3번 출력하고 싶음
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("ㅋ\n",i);
		}
		System.out.println("========================");
		// 5부터 1까지 (정수들을 내림차순 출력
		for (int i = 5; i >=1; i--) {
			System.out.printf("%d easy\n", i);
		}
		System.out.println("========================");
		// 1, 3, 5, 7, ... ,21까지 출력
		for (int i = 1; i <=21; i+=2) {
			System.out.printf("%d jump\n", i);
		}
		System.out.println("========================");
		// 반복문이 5번 도는 동안에 1~10 사이의
		//	정수를 랜덤하게 뽑고 싶을 때 ?
		Random r = new Random();
		int a = r.nextInt(10)+1;
		for (int i = 0; i <5; i++) {
			System.out.printf("%d 2z~ \n",a ,i);
		}
		System.out.println("========================");
		// 1 + 2 + 3 + ... + 10 더한 값 출력						// 여기서 막힘 +=
		int a1 = 0;
		for (int i = 1; i <= 10; i++) {
			a1 += i;
			// a1(0)+1
			// a1(0)+2
			// a1(0)+3
			// a1(0)+4
			// a1(0)+5
			// a1(0)+6
			// a1(0)+7
			// a1(0)+8
			// a1(0)+9
			// a1(0)+10
			System.out.println(a1);
		}
		
		System.out.println("========================");
		// 팩토리얼 !
		// 7! => 7 * 6 * 5 * ... * 2 * 1 값 출력
		int rhq = 1;
		for (int i = 1; i <= 7; i++) {
			rhq *= i;
			System.out.println(rhq);
		}
		
		System.out.println("========================");
		// 1 ~ 50 까지 정수 중에
		// 3의 배수거나, 5의 배수인 정수들 다 더한 값 출력
		int q = 0;
		for (int i = 1; i <= 50; i+=1) {
			if (i % 3 == 0) {
				q += i;
			}else if (i % 5 == 0) {
				q += i;
			}
			//a
		}
		//b
		System.out.println(q);
	}
}
