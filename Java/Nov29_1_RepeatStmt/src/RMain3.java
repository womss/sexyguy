import java.util.Scanner;

public class RMain3 {
	// ATM기능을 하는 프로그램
	//	1을 고르면 입금 / 2를 고르면 출금
	//	3을 고르면 잔고 확인 / 4를 고르면 프로그램 종료
	//	돈 값은 입력 받을 것 (입금, 출금)
	//	main 함수에
	
		
	public static void main(String[] args) {
	
		Scanner k = new Scanner(System.in);
		
		int out = 0;
		int put = 0;
		int mo = 0;
		
		a : for (int i = 0; true; i++) {
			System.out.println("메뉴번호를 입력해 주세요 : \n1. 입금\n2. 출금\n3. 계좌 잔고 확인\n4. 업무 종료\n");
			int num = k.nextInt();
			if (num == 1) {
				System.out.println("얼마를 입금 하시겠습니까? : ");
				put = k.nextInt();
				mo += put;
			
			}else if (num == 2) {
				System.out.println("얼마를 출금 하시겠습니까? : ");
				out = k.nextInt();
				while (mo<out) {
					System.out.println("잔고가 부족합니다");
					System.out.println("얼마를 출금 하시겠습니까? : ");
					out = k.nextInt();
				}
				mo -= out;
				
			}else if (num == 3) {
				System.out.printf("해당 계좌의 잔고는 %,d원 입니다\n", mo);
				
			}else if (num == 4) {
				break a;
			}
			
		}System.out.println("ATM업무를 종료합니다");
		
		}
		
		
		
	
}
