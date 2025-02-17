import java.util.Scanner;

public class FMain4 {
	// 쉬는날.. 방에서 게임하고 있었는데
	// => 엄마가 심부름 시킴
	// void는 return할게 없다 (보낼 자료가 없다)
	public static void makeErrand() {
		System.out.println("아들 ~");
		System.out.println("돈 줄테니까");
		System.out.println("슈퍼가서");
		System.out.println("라면이랑");
		System.out.println("참치 사고");
		System.out.println("남은 돈 가져와~");
		System.out.println("_____________");
	}
	// 엄마가 돈을 주셨다 (돈 = 입력)
	public static int takeMoney() {
		Scanner k = new Scanner(System.in);
		System.out.print("엄마가 준 돈 : ");
		int money = k.nextInt();
		System.out.printf("엄마가 %d원을 주셨다\n", money);
		System.out.println("______________");
		return money;
		// 정수(int)에 대한 값을 main함수에 반환(return)할거니까
		// return type을 int로 선택
	}
	
	// 심부름 중에... (라면 :3200, 참치 : 2170, 과자 : 1500)
	// 돈이 얼마 남는지 생각...
	/**
	 * 심부름했을 때 얼마 남을지 생각해보는 기능
	 * @param money
	 */
	public static void doErrand(int money) {
		int ramen = 3200;
		int tuna = 2170;
		int snack = 1500;
		// 계산하는 함수
		//	계산이라는 작업을 하려면 '받아온 돈'이 필요
		// 그 돈은... 파라미터로 받아올 것
		System.out.printf("심부름하면 %d원이 남네\n", money - (ramen + tuna + snack));
		System.out.println("________________________");
	}
		//계산을 하고, 잔돈을 엄마한테 주자...
	public static int calculate(int money) {
		int ramen = 3200;
		int tuna = 2170;
		int snack = 1500;
		int bbingddang = 3000;
		
		int restMoney = money - (ramen + tuna + snack + bbingddang);
		return restMoney;
	}
	public static void main(String[] args) {
		makeErrand();
		int money = takeMoney();
		doErrand(money);
		int restMoney = calculate(money);
		System.out.println(restMoney);
	}
}

// 함수를 표현하는 4가지 방식
//	왜? 사용할까요?

//	보기 편하게
//	오류 발견에 편하게
//	역할 나눔
//	다른곳에서 사용하기 위해

// main함수에 코드를 최대한 짧게 구성하기 위해서
//	각각의 기능들을 묶어서 함수라는걸로 사용
//	기능을 나눠서 효율적으로 사용