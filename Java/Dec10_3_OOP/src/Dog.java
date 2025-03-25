import java.util.Scanner;

public class Dog {
	Scanner sign = new Scanner(System.in);
	
	public int dogBat() {
		System.out.println("내가 낼건 : ");
		System.out.println("1. 가위"); // 1 - 2 = -1 짐 1 - 3 = -2 이김
		System.out.println("2. 바위"); // 2 - 1 = 1 이김 2 - 3 = -1 짐 
		System.out.println("3.  보"); // 3 - 1 = 2 짐 3 - 2 = 1 이김
		int dsign = sign.nextInt();		// -2, 1 이김 // -1, 2 짐 // 
		System.out.println(" 강아지는 사인을 보냈다 !");
		return dsign;
	}
}
