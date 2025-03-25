import java.util.Scanner;
// 논리연산자
//		결과가 boolean (true / false)
//		>(초과), >=(이상), ==(같다), !=(같지않다). <(미만), <=(이하)


public class OMain3 {
	public static void main(String[] args) {
		// 놀이공원에서 놀이기구를 타도 되는지 판정해주는 프로그램
		// 키(cm), 나이를 입력받아서 출력

		Scanner k = new Scanner(System.in);
		
		System.out.print("키를 입력해 주세요 : ");
		double tall = k.nextDouble();
		System.out.print("나이를 입력해 주세요 : ");
		int y = k.nextInt();
		
		
		
		System.out.printf("저희 놀이공원에는 안전을 위해 키와 나이 제한이 있습니다\n"
				+ "키 : %.1fcm\n", tall);
		System.out.printf("나이 : %d살\n", y);
		
		// 나이가 10살이 넘는 사람만 탈 수 있음 넘으면 true
		boolean ride1 = (y>10);
		System.out.printf("ride1 탑승 가능 여부 : %b\n", ride1);
		// 나이가 5살 미만만 탈 수 있음
		boolean ride2 = (y<5);
		System.out.printf("ride2 탑승 가능 여부 : %b\n", ride2);
		// 나이가 20살만 탈 수 있음
		boolean ride3 = (y==20);
		System.out.printf("ride22 탑승 가능 여부 : %b\n", ride3);
		// 나이가 1살만 아니면 탈 수 있음
		boolean ride4 = (y!=1);
		System.out.printf("ride3 탑승 가능 여부 : %b\n", ride4);
		// 나이가 홀 수인 사람만 탈 수 있음 
		boolean ride5 = (y % 2 == 1); // 등호 뒤만 수정하려고 했던 고정관념 때문에 풀지 못함
		System.out.printf("ride4 탑승 가능 여부 : %b\n", ride5);
		System.out.println("------------------------------");
		
//		System.out.println("------------------------------");
//		System.out.printf("나이가 %d살 이셔서 : %b");
//		System.out.printf("나이가 %d살 이셔서 : %b");
//		System.out.printf("나이가 %d살 이셔서 : %b");
//		System.out.printf("나이가 %d살 이셔서 : %b");
		
		// o거짓 l참
		// AND
		// o	o	=>	o
		// o	l	=>	o
		// l	o	=>	o
		// l	l	=>	l
		
		//논리 게이트 ★★★
		
		// 업그레이드
		//		~고 (and)		: &&	///둘 다 참이어야지만 참 경우의수 4가지중 1개만 참
		//		~거나 (or)		: || (shift + \) ///둘 중 하나만 참이어도 참 경우의 수 4가지중 3가지 참
		//		NOT				: ! => 결과를 뒤집는 것
		//		XOR				: ^
		//			(eXclusive(배타적) OR)
		//				: 두 입력이 서로 다를 때
		//					'1' (참) 결과값을 출력
		
		//	A && B : A도 만족, B도 만족 => 최종 OK
		//			: 확률이 낮은 조건을 앞으로 배치 ★★★
		//	A || B : A가 만족하거나, B가 만족하거나, 둘 다 만족 => 최종 OK
		//			: 확률이 높은 조건을 앞으로 배치 ★★★
		
		
		
		//강사님
		// 나이가 3살이 넘고, 키가 2m가 넘어야 탈 수 있음
//		boolean ride6 = (tall>200 && y>3);
//		System.out.printf("ride6 탑승 가능 여부 : %b\n", ride6);
//		// 키가 1.9m가 넘거나, 나이가 50살 미만이어야 탈 수 있음
//		boolean ride7 = (y<50 || (tall>190);
//		System.out.printf("ride7 탑승 가능 여부 : %b\n", ride7);
//		// 10 < 나이 < 40 이면 탈 수 있음
//		boolean ride8 = (y<40 && y>10);
//		System.out.printf("ride8 탑승 가능 여부 : %b\n", ride8);
//		// 나이가 10살 이상이던지, 키가 1.5m이상이던지 하나만 만족해야 탈 수 있음
//		boolean ride9 = (y>10) ^ ((tall / 100) >= 1.5);
//		System.out.printf("ride9 탑승 가능 여부 : %b\n", ride9);
//		// ride9를 탈 수 있는 사람은 못타고, ride9를 탈 수 없는 사람만 탈 수 있음
//		boolean ride10 = !ride9;
//		System.out.printf("ride10 탑승 가능 여부 : %b\n", ride10);
		
		
		// 나이가 3살이 넘어야			키가 2m가 넘어야
		// 		95%						5%
		//	ㄴ 95%이상의 확률로 2번 검사해야하는데
		// 키가 2m가 넘어야				나이가 3살이 넘어야
		//		5%						95%
		//	ㄴ 95%의 확률로 1번만 검사를 해도 됨	
		
		//1.9m에 맞춰서 바꾸기
				
		boolean ride6 = (tall>200 && y>3);
		System.out.printf("ride6 탑승 가능 여부 : %b\n", ride6);
		boolean ride7 = (y<50 || (tall>190));
		System.out.printf("ride7 탑승 가능 여부 : %b\n", ride7);
		boolean ride8 = (y>10 && y<40);
		System.out.printf("ride8 탑승 가능 여부 : %b\n", ride8);
		boolean ride9 = (y>10 ^ tall>150);
		System.out.printf("ride9 탑승 가능 여부 : %b\n", ride9);
		boolean ride10 = !(y>10 ^ tall>150);
		System.out.printf("ride10 탑승 가능 여부 : %b\n", ride10);
		
		
		
		
		
		
		
		
		
	}
}
