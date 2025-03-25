import java.util.Scanner;

public class PMain1 {
	// 거스름돈 환전 프로그램
	// 함수 사용 (o)
	
	// < 입력 >
	//	구매한 물건 가격 : 35000
	//	낸 돈 : 41530
	//---------------------------------// ff - dd 한 금액을 50000으로 나눠서 
	// 거스름돈 : 6530 을
	//	  50000	: 0
	//	  10000	: 0
	//	   5000	: 1
	//	   1000	: 1
	//	    500	: 1
	//		100	: 0
	//		 50	: 0
	//		 10	: 3
	//	0개 짜리는 출력 x
	
	// 물건 가격 입력 함수
	public static int Stuff() {
		Scanner k = new Scanner(System.in);
		System.out.println("구매하려는 물건의 가격 : ");
		int stuff = k.nextInt();
		return stuff;
		
	}
	
	// 지불 금액 입력 함수
	public static int pay() {
		Scanner k = new Scanner(System.in);
		System.out.println("내가 지불할 돈 : ");
		int pay = k.nextInt();
		return pay;
	
	}
	
	// 거스름돈 계산 함수
	public static int match(int ss, int pp) {
		int re = pp-ss;
		System.out.printf("거스름돈은 : %,d원 이고\n", re);
		System.out.println("남겨야할 지폐 권수는");
		return re;
	}
	public static int cal(int rr, int dhaks, int aks, int dhcjs, int cjs, int dhqor, int qor, int dhtlq, int tlq) {
		// 오만원권
		int redhaks = rr / dhaks;
		System.out.println(redhaks);
		// 만원권
		int reaks = (rr - (dhaks * redhaks)) / aks ;
		System.out.println(reaks);
		// 오천원권
		int redhcjs = (rr - (dhaks * redhaks) + (reaks * aks)) / dhcjs ;
		System.out.println(redhcjs);
		
		
		
		return dhaks;
	}
	public static void restMoney(int rr) {
		if (rr / 50000 >= 1) {
			System.out.printf("50000원권 %d장\n", rr / 50000);
		}
		if ((rr - 50000) / 10000 >= 1 ) {
			System.out.printf("10000원권 %d장", (rr - 50000) / 10000);
		}
		if ((rr - 50000) / 10000 >= 1 ) {
			System.out.printf("10000원권 %d장", (rr - 50000) / 10000);
	
		}
}
	
	
	public static void main(String[] args) {
		int dhaks	= 50000;
		int aks		= 10000;
		int dhcjs	= 5000;
		int cjs		= 1000;
		int dhqor	= 500;
		int qor		= 100;
		int dhtlq	= 50;
		int tlq		= 10;
		
		int ss = Stuff();
		int pp = pay();
		int rr = match(ss, pp);
		int cc = cal(rr, dhaks, aks, dhcjs, cjs, dhqor, qor, dhtlq, tlq);
		restMoney(rr);
	}
}
