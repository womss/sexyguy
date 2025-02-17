import java.util.Scanner;

public class FMain2 {
	
	// (3보다 작은) 정수 하나를 입력받는 함수
	//	3보다 크거나 같을 때 => 다시 입력 받을 수 있도록
	
	// 홀수만 입력 받을 수 있는 함수 (정수)
	//	=> 짝수를 입력하면 다시 입력 받을 수 있도록
	
	// 정수를 입력받는 함수 => 0~100
	//	=> 범위안의 정수가 아니라면 다시 입력 받을 수 있도록
	public static int number() {
		System.out.println(" 3보다 작은 정수 입력 : ");
		Scanner k = new Scanner(System.in);
		int num = k.nextInt();
		int numchek = num<3 ? num : number();
		return numchek;
	}
	
	
	public static int holsu() {
		System.out.println(" 홀수 입력 : ");
		Scanner k = new Scanner(System.in);
		int hol = k.nextInt();
		int holchek = (hol %2 == 1 ) ? hol : holsu();
		return holchek;
		
		
	}
	public static int numhun() {
		System.out.println(" 0~100 정수 입력 : ");			// 2그다음
		Scanner k = new Scanner(System.in);				// 1강사님은 이걸 제일먼저
		int numh = k.nextInt();							// 3
		int numhchek = (numh >= 0 && numh <=100 ) ? numh : numhun(); // &&을 ||로 착각
		return numhchek;
	
	}
	
	public static void main(String[] args) {
		//int number1 = number();
		System.out.println(number());
		//int holsu1 = holsu();
		System.out.println(holsu());
		//int numhun1 = numhun();
		numhun();
		//System.out.println(numhun());
		
	}
}
