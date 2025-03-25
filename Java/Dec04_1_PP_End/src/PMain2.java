import java.util.Random;
import java.util.Scanner;

public class PMain2 {
	public static void main(String[] args) {
		// 베스킨라빈스 31 게임 (main함수)
		// 유저 먼저 시작 (1~3 사이 정수
		// 프로그램 종료할 때까지 반복 + 전적 확인 메뉴
		
		Scanner k = new Scanner(System.in);
		Random r = new Random();
//		int me = 0;
//		int ai = 0;
//		int c = 0;;
		while (true) {
			int me = 0;
			int ai = 0;
			int c = 0;
			int w = 0;//
			int l = 0;//
			System.out.println("베스킨 라빈스 31 게임을 시작합니다\n1. 시작\n2. 스코어 확인\n3. 종료");
			int num = k.nextInt();
			if (num == 1) {
		
		
		a :	while (true) {
		
				for (int i = 0; true; i++) {
				
				System.out.println("   사용자 턴입니다");
				System.out.println("사용자 수 입력(최대 +3까지만) : ");
				me = k.nextInt();
				System.out.println();
				if (me <4 && me > 0) {
					c += me;
				}
				else {
//					(me > c+3 || me<c) {
						
				System.out.println("규칙보다 더 크게 혹은 기존 숫자보다 낮게 입력할 수 없습니다");
				System.out.println();
				break a;
				}
				if (c >= 31) {
					System.out.println("=================");
					System.out.println("사용자가 패배하였습니다");
					System.out.println("=================");
					System.out.println();
					l += 1;
					break a;
				}
//				c += me;
				System.out.println("사용자의 수 : "+ c);
				System.out.println("턴 넘김");
				System.out.println();
				System.out.println("   ai 턴입니다 ");
				ai = r.nextInt(3)+1;
				c += ai;
				
				System.out.println("ai의 수 : "+ c);
				if (c >= 31) {
					System.out.println("=================");
					System.out.println("ai가 패배하였습니다");
					System.out.println("=================");
					System.out.println();
					w += 1;
				break a;
				}
			
				System.out.println("턴 넘김");
					System.out.println();
			}
		
		
		
		}
	}
			else if (num == 2) {
				System.out.printf("사용자의 전적은 %d승,%d패입니다 ", w, l);
				break;
}
}}}