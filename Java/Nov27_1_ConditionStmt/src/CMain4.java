import java.util.Scanner;

public class CMain4 {
	// f1 : 정수를 하나 입력 받아서 //함수만들기
	// 그게 양수면 "양" / 0이면 "0" / 음수면 "음" 출력
	
	// f2 : 정수를 하나 입력 받아서
	//	3의 배수면 "3의 배수"
	//	가 아니고 4의 배수면  "4의 배수"
	//	도 아니면 "몰라"
	//	를 판정해주는 함수
	//	ex) 12 : "3의 배수" + "4의 배수"
	
	public static int getNum() {
		Scanner k = new Scanner(System.in);
		System.out.println(" 정수 입력 : ");
		int f = k.nextInt();
		
		if (f % 12 == 0) { // (x % 3 == 0) && (f % 4 == 0)
			
		}
		
		return f;
		
	}
	public static void matchf1(int f) {
		if (f > 0) {
			System.out.println("양");			
		}else if (f == 0) {
			System.out.println("0");
		}else {
			System.out.println("음");
			
		}
	}
	private static void matchf2(int f) {
		String f2 = "";
		if (f ==0) {
			
		}
		else if (f % 3 == 0) {
			f2="3의 배수";
			System.out.printf("%d는 %s입니다\n",f ,f2);
			}else if (f % 4 == 0) {
				f2 = "4의 배수";
				System.out.printf("%d는 %s입니다\n",f ,f2);
			}else if (f % 12 == 0) {
				System.out.printf("%d는 %s입니다\n",f ,f2);
		}
//		}else if (f % 4 == 0) {
//			System.out.println("4의 배수");
			
			//}
		else {
			System.out.println(" 나도 모름 ");
		}
		
	}
	
	public static void main(String[] args) {
		int f = getNum();
		matchf1(f);
		matchf2(f);
	}
}
