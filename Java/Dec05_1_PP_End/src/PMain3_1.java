import java.util.Random;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class PMain3_1 {
	public static void main(String[] args) {
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
		
		Scanner k = new Scanner(System.in);
		Random r= new Random();
		int money = 10000;	// 기본 소지금
		int select = 0;		// 메뉴
		int win = 0,  lose = 0, draw = 0;	// 승, 패, 무
		int userDice1, userDice2, userDice3 = 0;	// 유저 주사위
		int comDice1, comDice2, comDice3 = 0;		// 컴퓨터 주사위
		String bettingChoice, reTryChoice = null;	// 배팅 / 재도전 선택
		// 배팅금액, 대출금액, 누적대출금액, 상환금액
		int bettingMoney, laon = 0, accumulatedLaon = 0, payBack = 0;
		int userSum, comSum = 0; // 유저 / 컴퓨터 주사위 합
		
	a : while (true) {
			System.out.println("====== 주사위 게임 ======");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. Beaver Laon");
			System.out.println("2. Pay Back");
			System.out.println("5. End Game");
			System.out.println("============================");
			System.out.println("선택 >");
			select = k.nextInt();																	/// 메뉴 입력하는 값
			System.out.println("============================");
			
			switch (select) {
			case 1:
				if (money <= 0) {	// 게임을 하려고 했는데 돈이 없는 경우
					System.out.println("소지금이 없습니다. Bye~");
					break;
				}
				
				while (true) {
					System.out.println("<< Game Start >>");
					userDice1 = r.nextInt(6)+1;
					userDice2 = r.nextInt(6)+1;
					userDice3 = r.nextInt(6)+1;
					comDice1 = r.nextInt(6)+1;
					comDice2 = r.nextInt(6)+1;
					comDice3 = r.nextInt(6)+1;
					
					System.out.println("1번째 주사위 값 : " + userDice1);
					System.out.println("2번째 주사위 값 : " + userDice2);
					System.out.println("3번째 주사위 값 : " + userDice3);
					
					userSum = userDice1 + userDice2 + userDice3;
					System.out.println("내 주사위 총 합 : " + userSum);
					
					System.out.print("배팅하시겠습니까 ? [ Y / N ]");
					bettingChoice = k.next();
					System.out.println("============================");
					
					if (bettingChoice.equals("y") || bettingChoice.equals("Y")) {
						System.out.println("얼마를 배팅하시겠습니까 ?");
						System.out.printf("현재 소지금 : %,d원\n", money);
						System.out.print("입력 : ");
						
						while (true) {
							bettingMoney = k.nextInt();
							System.out.println("============================");
							if (bettingMoney < 0) {	// 배팅금액기 - 인 경우
								System.out.println("돈이 어떻게 - ㅋㅋㅋㅋ");
								System.out.println("다시 입력하세요");
								System.out.println("얼마를 배팅하시겠습니까?");
								System.out.printf("현재 소지금 : %,d원\n", money);
								System.out.print("입력 : ");
								
							} else if (money < bettingMoney) {	// 소지금액 < 배팅금액인 경우
								System.out.println("금액이 부족합니다");
								System.out.println("다시 입력하세요");
								System.out.println("얼마를 배팅하시겠습니까?");
								System.out.printf("현재 소지금 : %,d원\n", money);
								System.out.print("입력 : ");
								continue;
							}
							break;
						}
						
						System.out.println("컴퓨터 1번째 주사위 값 : " + comDice1);
						System.out.println("컴퓨터 2번째 주사위 값 : " + comDice2);
						System.out.println("컴퓨터 3번째 주사위 값 : " + comDice3);
						System.out.println("============================");
						
						comSum = comDice1 + comDice2 + comDice3;
						System.out.println("컴퓨터 주사위 총 합 : " + comSum);
						System.out.println("============================");
						
						System.out.println("<< 결과 >>");
						if (userSum > comSum) {
							System.out.println("\t승리 !");
							System.out.printf("\t%,d원이 소지금에 추가되었습니다.\n", bettingMoney);
							money += bettingMoney;
							win++;
						} else if (userSum < comSum) {
							System.out.println("\t패배 !");
							System.out.printf("\t%,d원이 소지금에서 차감되었습니다.\n", bettingMoney);
							money -= bettingMoney;
							lose++;
							
							if (money <= 0) { // 소지금이 0원 밑으로 떨어지는 경우
								System.out.println("==========================");
								System.out.println("\t나 가 세 요 ~ ^_^");
								break;
							}
							
							
						} else {
							System.out.println("대충 비겼다는 내용");
							draw++;
						}
						System.out.println("===========================");
						
						System.out.println("한번 더 하시겠습니까 ? [ Y / N ]");
						reTryChoice = k.next();
						
						if (reTryChoice.equals("y") || reTryChoice.equals("Y")) {
							continue;
						} else { // y가 아닌거 입력하면 재시도 안하는걸로 간주
							break;
						}
					} else { // y가 아닌거 입력하면 재시도 안하는걸로 간주
						break;
					}
					
				}
				break;
			case 2:
				System.out.println("<< 당신의 견적 >>");
				System.out.printf("Win : %d회\n", win);
				System.out.printf("Draw : %d회\n", draw);
				System.out.printf("Lose : %d회\n", lose);
				System.out.printf("내 소지금 : %,d원\n", money);
				break;
			case 3:
				System.out.println(" 월 금리 57% 대출 OPEN ");
				System.out.println(" 못갚을시 어쩌구 ");
				System.out.println(" 빌릴 금액 : ");
				laon = k.nextInt();
				System.out.printf("%,d원 여기 있으니까 많이 따세요 사장님 ~ \n", laon);
				money += laon;
				accumulatedLaon += laon;
				System.out.printf("여태까지 총 %,d원 빌렸으니 알아두고 ~ \n", accumulatedLaon);
				break;
			case 4:
				System.out.println("아이고 사장님 ~");
				System.out.printf("%,d원 주시면 됩니다 ~ \n", accumulatedLaon);
				
				System.out.println("얼른 줘봐유 : ");
				payBack = k.nextInt();
				
				if (payBack > accumulatedLaon) {
					System.out.println(" 에이 ~ 사장님 나도 낭만이 있어 ~ 이건 않이지~");
					break;
				}
				money -= payBack;
				accumulatedLaon -= payBack;
				
				if (accumulatedLaon > 0) {
					System.out.printf("이제 %,d원 남으셨어요 사장님 ~ \n", accumulatedLaon);
					System.out.println("조금만 더 힘내시고 ~");
				} else if (accumulatedLaon == 0) {
					System.out.println("아이고 사장님 욕보셨네");
					System.out.println("조심히 가시고");
				}
				break;
			case 5:
				if (accumulatedLaon > 0) {
					System.out.println(" 돈은 갚고 가야지...");
					break;
				}
				System.out.println("게임을 종료합니다");
				System.out.println("=================");
				break a;
			default:
				System.out.println("잘못 입력하셨네요 ?");
				break;
			}
			
			}		
		}

}



























