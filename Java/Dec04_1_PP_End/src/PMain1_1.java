import java.util.Scanner;

public class PMain1_1 {
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
	
	
		// 가격 관련 일의자리 입력에 대한 방지를 위한 함수
	private static boolean isLastDigitInvalid(int money) {
		int lastDigit = money % 10; // 일의 자리
		return lastDigit >= 1 && lastDigit <=9;
	}
	// 물건 가격
	public static int getPrice() {
		Scanner k = new Scanner(System.in);
		System.out.println("물건 가격 : ");
		int price  = k.nextInt();
		
		if (price < 10) {
			System.out.println("물건 가격은 최소 10원 이상");
		}else if (isLastDigitInvalid(price)) {
			System.out.println("일의 자리에 대한 화폐는 없음");
		}
		
		return (price >= 10 && !(isLastDigitInvalid(price))) ? price : getPrice();
	}
	
	// 낸 돈
	public static int paymoney(int price) {
		Scanner k = new Scanner(System.in);
		System.out.println("낸 돈 : ");
		int money = k.nextInt();
		
		if (money < price) {
			System.out.println("돈이 부족합니다. 다시 입력하세요");
		}else if (money < 10) {
			System.out.println("화폐 단위는 10원부터");
		}else if (isLastDigitInvalid(money)) {
			System.out.println("일의 자리에 대한 화폐는 없음");
		}

		return((money >= price) || money <= 10) && !(isLastDigitInvalid(money)) ? money : paymoney(price);
	}
	
	// 거스흠돈 계산
	public static int getChange(int money, int price) {
		return money - price;
	}
	
	public static void printResult(int price, int money, int change) {
		System.out.println("============================");
		System.out.printf("물건가격 : %,d원\n", price);
		System.out.printf("낸 돈 : %,d\n", money);
		System.out.printf("거스름돈 : %,d원\n", change);
		System.out.println("============================");
	}
	
	//거스름돈을 화폐에 따라 어떻게 줄 것인지
	public static void printChange(int change) {
		// 2가지 방법
		//	1.
//		int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
//		for (int i = 0; i < currency.length; i++) {
//			if (change >= currency[i]);{
//				System.out.printf("%d원권 : %d개\n", currency[i], (change/currency[i]));
//				change %= currency[i];
//			}
//			
//		}
		//	2.
		int currency2 = 100000;
		while (true) {
			currency2 /= 2; // 왜 /=?
			if (change >= currency2) {
				System.out.printf("%,d원권 : %d개\n", currency2, (change / currency2));
				change %= currency2;
			}
			
			currency2 /= 5;
			if (change >= currency2) {
				System.out.printf("%,d원권 : %d개\n", currency2, (change / currency2));
				change %= currency2;
			}
			if (currency2 == 10) {
				break;
			}
		
	}
	
	}
	
	public static void main(String[] args) {
		int price = getPrice();
		int money = paymoney(price);
		int change = getChange(money, price);
		printResult(price, money, change);
		printChange(change);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
