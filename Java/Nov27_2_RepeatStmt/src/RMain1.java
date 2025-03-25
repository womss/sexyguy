import java.util.Iterator;
import java.util.Random;

public class RMain1 {
	public static void main(String[] args) {
		// ㅋ 출력
		// ㅋ 5번 출력
		// ㅋ 173456번 출력
		
		// 여태까지 했던 것 - 문과적인 요소...
		// 반복문 - 이과적 요소...! => 어려워요..!
		
		// 1. 어떤 작업을 173456번 반복(횟수)
		// 2. 작업 - 퇴실시간까지 반복(기한)
//		for (변수초기화; 조건식; 값의 증감) {
//			내용
//		}
//		for문의 원리
//		(1.변수초기화) (2. 조건식이 맞으면 (참)) (4. 값의증감)(5. 다시 조건 비교) (7. 값의 증감) (8. 조건 비교후 안맞으면(거짓))
//			(3. 내용 실행) (6. 내용 실행) (9. 반복문 종료)
		
		
		// ㅋ을 3번 출력하고 싶음
		for (int i = 0; i < 3; i++) { //i는 3보다 작을때까지
			System.out.printf("%d : ㅋ\n", i);
		}
		System.out.println("===============");
		
		
		
		
		
		
		
		// 5부터 1까지 (정수들을 내림차순 출력
		for (int i = 5; i > 0; i--) {
			System.out.printf("%d easy baby\n", i);
		}
		System.out.println("=======================");
		
		// 1, 3, 5, 7, ... ,21까지 출력
		for (int i = 1; i < 22; i++,i++) {
			System.out.printf("%d easy easy\n",i);
		}
		System.out.println("=======================");
		
		// 반복문이 5번 도는 동안에 1~10 사이의
		//	정수를 랜덤하게 뽑고 싶을 때 ?
		Random r = new Random();
		int rr = r.nextInt(10)+1;		// 랜덤한 숫자를 하나 뽑아서
		for (int i = 0; i < 5; i++) {
			System.out.println(rr);		// 그 숫자 출력 기능을 5번 반복
		// 0 = rr, 1= rr,  2 3 4
		}
		
		System.out.println("========================");
		
		// 반복문 안에서 변수를 새로 만드는것은 자제하는게 좋다
		// 반복문이 ㅏㄴ 번 돌때마다 변수를 생성함
		for (int i = 0; i < 5; i++) {
			int x2 = r.nextInt(10)+1;
			System.out.println(x2);
		}		
		System.out.println("========================");
		
		// 반복문 밖에서 변수 하나를 만들어서 가져다 쓰는것이
		//	조금 더 효율적
		int x3 = 0;
		for (int i = 0; i < 5; i++) {
			x3 = r.nextInt(10)+1;	// 변수를 '생성' (X)
									// 변수의 값만 '변경' (O)
			System.out.println(x3);
		}
		System.out.println("=========================");
		
		// 1 + 2 + 3 + ... + 10 더한 값 출력
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i ; // sum = sum + i;
		}
		System.out.println(sum);
		System.out.println("=========================");
		// 팩토리얼 !
		// 7! => 7 * 6 * 5 * ... * 2 * 1 값 출력
		int mul = 1;
		for (int i = 1; i <= 7; i++) {
			mul *= i;
		}
		System.out.println(mul);
		System.out.println("=========================");
		// 1 ~ 50 까지 정수 중에
		// 3의 배수거나, 5의 배수인 정수들 다 더한 값 출력
		int sum2 = 0;
		for (int i = 1; i <= 50; i+=1) {
			if (i % 3 == 0) {
				sum2 += i;
			}else if (i%5 ==0) {
				sum2 += i;
			}
//			if (i % 3 == 0 || i % 5 == 0) {
//				sum2 += i;}
			}
		System.out.println(sum2);
	}
}
			
	

		
		
	




















