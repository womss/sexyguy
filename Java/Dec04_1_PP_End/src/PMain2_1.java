import java.util.Random;
import java.util.Scanner;

public class PMain2_1 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Random r = new Random();
		int select = 0;	// 메뉴
		int uNum = 0;	// 유저가 낸거
		int cNum = 0;	// 컴퓨터가 낸거
		int win = 0;	// 승리
		int lose = 0;	// 패배
		
		a : while (true) {
			System.out.println(" === 베스킨 라빈스 31 게임 ===");
			System.out.println("\t1. Game Start");
			System.out.println("\t2. Game Score");
			System.out.println("\t3. End Game");
			System.out.print("선택 > ");
			select = k.nextInt();
			
			switch (select) {
			case 1:
				System.out.println(" Game Start !");
				int count = 0;
			b : while (true) {
					System.out.println("<< Your Turn >>");
					System.out.println("입력(1~3) : ");
					uNum = k.nextInt();
					if (uNum < 1 || uNum > 3) {
						System.out.println("잘못된 범위 !");
						continue;
					}
					for (int i = 0; i < uNum; i++) {
						count++;
						System.out.println((count) + "!");
						if (count == 31) {
							System.out.println("패배 !");
							lose++;
							break b;
						}
					}
					System.out.println("<< AI Turn >>");
					cNum = r.nextInt(3)+1;
					
					if (count == 27) {
						cNum = 3;
					} else if (count == 28) {
						cNum = 2;
					} else if (count == 28) {
						cNum = 1;
					}
					
					for (int i = 0; i < cNum; i++) {
						count ++;
						System.out.println((count) + "!");
						if (count == 31) {
							System.out.println("승리");
							win++;
							break b;
						}
					}
				}
				
				break;
			case 2:
				System.out.println("<< 전적 >>");
				System.out.println("\tWIN : " + win);
				System.out.println("\tLOSE : " + lose);
				break;
			case 3:
				System.out.println("종료합니다");
				break a;
			default:
				System.out.println("없는 메뉴입니다");
				break;
			}
			
		}
		
		
		
		
		
		
		
	}
	
}
