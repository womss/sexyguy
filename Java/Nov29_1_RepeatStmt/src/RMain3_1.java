import java.util.Scanner;

import javax.print.attribute.standard.PagesPerMinute;

public class RMain3_1 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int choice = 0;
		int money = 0;
		
		while (true) {
			System.out.println("=====================================");
			System.out.println("1. 예금 ㅣ 2. 출금 ㅣ 3. 잔고 확인 ㅣ 4. 종료");
			System.out.println("=====================================");
			System.out.print("선택> ");
			choice = k.nextInt();
			if (choice == 1) {
				System.out.print("예금액> ");
				int plusMoney = k.nextInt();
				// 이 값을 다른 메뉴에서도 사용할 일이 없기에
				//	변수를 만들었음
				// 변수를 반복문 안에서 선언하면
				//	해당 변수는 if문 안에서만 유효
				/// 1회성으로 사용할거라 내부에서 만들었다
				System.out.printf("\t%,d원을 예금합니다.\n", plusMoney);
				money += plusMoney;
			} else if (choice == 2) {
			  System.out.println("출금액> ");
			  int minusMoney = k.nextInt();
				if (money - minusMoney < 0) {
					System.out.println("\t...");
					System.out.println("\t잔고가 모자랍니다.");
					System.out.println("\t출금에 실패했습니다.");
					continue;
			}
			System.out.printf("\t%,d원을 출금합니다.\n", minusMoney);
			money -= minusMoney;
		}else if (choice == 3) {
			System.out.printf("\t%,d원이 남아있습니다.\n", money);
		}else if (choice == 4) {
			System.out.println("\t프로그램을 종료합니다.");
			System.out.println("----------------------------");
			break;
		}else {
			System.out.println("\t메뉴를 잘못 입력하셨습니다");
		}
		}}
		
		
		
	}
	
	

