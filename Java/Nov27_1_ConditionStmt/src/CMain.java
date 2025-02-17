import java.util.Scanner;

public class CMain {
	// 1년 = 12달
	// 각 달마다 며칠인지 다릅니다
	// 몇 월인지 입력을 받아서
	// 31일까지 있습니다. / 30일까지 있습니다. / 28일까지 있습니다.
	// 14월 => 없는 달입니다. 출력
	//31 
	
	public static int mon() {
		Scanner k = new Scanner(System.in);
		System.out.println(" 몇 월? : ");
		int mo = k.nextInt();
		return mo;
		
	}
	
	public static void match(int mo) {
		
		int day = 0;
		switch (mo) {
		case 1: case 3: case 5: case 7: case 8: case 10:case 12:
			day = 31;
			System.out.printf("%d월은 %d일까지 있습니다.\n", mo,day);
			break;
		case 4: case 6: case 9: case 11:
			day = 30;
			System.out.printf("%d월은 %d일까지 있습니다.\n", mo,day);
			break;
		case 2: 
			day = 28;
			System.out.printf("%d월은 %d일까지 있습니다.\n", mo,day);
			break;

		default:
			System.out.printf("%월은 없는 달입니다",mo);
			break;
		}
		
	}
	
	
	public static void main(String[] args) {
		int mo = mon();
		match(mo);
	}
	
}
