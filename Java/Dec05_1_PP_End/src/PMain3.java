import java.util.Random;
import java.util.Scanner;

public class PMain3 {
	// 주사위 게임 (main함수만 사용 O)
	//	유저아 컴퓨터 각각 주사위 3개를 굴려서 그 합이 높은 숫자가
	//		나온쪽이 이기는 게임
	//	1번 메뉴 :
	//		유저와 컴퓨터는 각각 주사위 3개씩 굴릴 것
	//		유저는 굴린 주사위 값을 확인한 후 (주사위의 합까지)
	//		돈을 배팅할 수 있게 해서
	//		이기면 그 돈만큼 따고, 지면 잃게 됨
	//		소지금보다는 많이 배팅할 수 없고, 기본 소지금 10000원 시작
	//		한 판 끝나면 재도전 의사를 물을 것
	//		소지금 다 잃으면 메뉴로 돌아가기
	//	2번 메뉴 :
	//		전적확인 (승 / 무 / 패 / 소지금)
	//	3번 메뉴 :
	//		대출 기능
	//	4번 메뉴 :
	//		상환 기능
	//	5번 메뉴 :
	//		프로그램 종료
	
	public static int start() {
		System.out.println();
		System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
		System.out.println(" 주사위 게임에 오신걸 환영합니다");
		System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
		System.out.println();
		System.out.println("1. 게임 시작");
		System.out.println("2. 전적 확인");
		System.out.println("3. 대출"); // 이자?
		System.out.println("4. 대출 상환");
		System.out.println("5. 게임 종료");
		System.out.println("메뉴를 골라주세요 : ");
		Scanner k = new Scanner(System.in);
		int menu = k.nextInt();
	return menu;	
	}
	
	public static int userNumber(int menu, int roll) throws InterruptedException {
		int u = 0;
		int u1 = 0;
		switch (menu) {
		case 1:
			System.out.println();
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			System.out.println(" 주사위 게임을 시작합니다");
			System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
			
			Random r = new Random();
			
			
			for (int i = 0; i < roll; i++) {
				System.out.printf(" 사용자의 %d번째 주사위 숫자 : ", i + 1);
				u = r.nextInt(6)+1;
				System.out.printf("%d\n", u);
				u1 += u;
				Thread.sleep(1000);
				continue;
			}
			System.out.println();
			System.out.printf(" 사용자의 총 합 : %d\n", u1);
			System.out.println();
			Thread.sleep(1000);
		} return u1;
	}
	public static int bat(int seed) {
		
		System.out.printf("현재 시드머니 : %,d원", seed);
		System.out.println();
		Scanner k = new Scanner(System.in);
		System.out.println(" 얼마를 배팅하시겠습니까 ? :");
		int bat = k.nextInt();
		if ((bat > seed) || (bat <= 0)) {
			System.err.println(" 현재 소지금보다 많게 혹은 0원 밑으로는 배팅할 수 없습니다. ");
			bat(seed);
		}
		return bat;
	}
			
	public static int aiNumber(int roll, int u1) throws InterruptedException {
		int a = 0;
		int a1 = 0;
		Random r = new Random();
		for (int i = 0; i < roll; i++) {
				System.out.printf(" ai의 %d번째 주사위 숫자 : ", i + 1);
				a = r.nextInt(6)+1;
				System.out.printf("%d\n", a);
				a1 += a;
				Thread.sleep(1000);
			continue;
			}
			System.out.println();
		System.out.printf(" ai의 총 합 : %d\n", a1);
		return a1;
	}
	public static void match(int u1, int a1) {
		if (u1 > a1) {
			System.out.println(" 이겼습니다 ");
			
		}
		
	
		
			
}
	public static void activate() throws InterruptedException {
		int seed = 10000;
		int roll = 3;
		int menu = start();
		int u2 = userNumber(menu,roll);
		bat(seed);
		aiNumber(roll,u2);
}
	
	public static void main(String[] args) throws InterruptedException {
		activate();
		
	}
}

