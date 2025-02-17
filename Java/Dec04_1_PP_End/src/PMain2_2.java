import java.util.Random;
import java.util.Scanner;

public class PMain2_2 {
	// 베스킨라빈스 31 게임 (main함수)
	// 유저 먼저 시작 (1~3 사이 정수
	// 프로그램 종료할 때까지 반복 + 전적 확인 메뉴
	
	public static void main(String[] args) throws InterruptedException {
		Scanner k = new Scanner(System.in);
		System.out.println("\t  BaskinRobbins 31 ");
		Thread.sleep(1000);
		System.out.println("\t    Game~ Start!");
		System.out.println();
		Thread.sleep(1000);
		System.out.println("\t  ΛΛΛΛΛΛΛΛΛΛΛΛΛΛΛ");
		System.out.println("\t     User Turn ");
		System.out.println("\t  VVVVVVVVVVVVVVV");
		Thread.sleep(500);
		System.out.println();

		System.out.println("1~3사이의 숫자를 입력하면");
		System.out.println("기존 숫자에 합산하는 방식으로");
		System.out.println("게임이 진행됩니다");
		Thread.sleep(1000);
		int count = 0;
	b : while (true) {
			System.out.println();
			System.out.println("\t  숫자를 입력해 주세요 : ");
			int userNumber = k.nextInt();
		a : if ((userNumber < 1) || (userNumber > 3)) {
				System.err.println("\t입력 숫자의 법위를 벗어났습니다");
				System.out.println();
				break ;
			}else if ((userNumber >= 1) || (userNumber <= 3)) {
				count += userNumber;
				System.out.println("\t   사용자가 입력한 숫자");
				System.out.println("\t         "+ userNumber);
				System.out.println();
			Thread.sleep(1000);
			System.out.println("\t     ΞΞΞΞΞΞΞΞ");
			System.out.println("\t      현재 숫자");
			System.out.println("\t        " + count);
			System.out.println("\t     ΞΞΞΞΞΞΞΞ");
			
			if (count >= 31) {
				Thread.sleep(1000);
				System.out.println("\t   ㅠ_ㅠ사용자 패배ㅠ_ㅠ");
				break;
			}
			}
		Random r = new Random();
		Thread.sleep(1000);
		System.out.println("\t  ΛΛΛΛΛΛΛΛΛΛΛΛΛΛΛ");
		System.out.println("\t     ai Turn");
		System.out.println("\t  VVVVVVVVVVVVVVV");
		Thread.sleep(1000);
		int aiNumber = r.nextInt(3)+1;
		count += aiNumber;
		System.out.println("\t   ai가 입력한 숫자");
		System.out.println("\t         " + aiNumber);
		Thread.sleep(1000);
		System.out.println("\t     ΞΞΞΞΞΞΞΞ");
		System.out.println("\t      현재 숫자");
		System.out.println("\t        " + count);
		System.out.println("\t     ΞΞΞΞΞΞΞΞ");
		
		if (count >= 31) {
			Thread.sleep(1000);
			System.out.println("\t\\^O^/사용자 승리\\^O^/");
			break;
		
		
		
	}
}
}
}
