import java.util.Scanner;

public class CMain2 {
			// 점수를 입력 받아서
			// 90점 이상이면 'A'
			// 90미만 80이상이면 'B'
			// 80미만 70이상이면 'C'
			// 70미만 60이상이면 'D'
			// 60미만이면 'F' 의 값을 변수에 담아서 출력
			// switch-case로
	
	public static int num() {
		Scanner k = new Scanner(System.in);
		System.out.println("점수 입력 : ");
		int num = k.nextInt();
		return num;
		}
	
	
	//강사님
	public static void match(int num) {
		String grade = "";
		switch (num/10) {
		case 9: case 10:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "c";
			break;
		case 6:
			grade = "d";
			break;
			
		default:
			grade = "F";
			break;
	//출력
//	public static void match(int num) {
//		switch (num/10) {
//		case 9: case 10:
//			System.out.println("90점 이상이라 A입니다");
//			break;
//		case 8:
//			System.out.println("80점 이상이라 입니다");
//			break;
//		case 7:
//			System.out.println("70점 이상이라 C입니다");
//			break;
//		case 6:
//			System.out.println("60점 이상이라 D입니다");
//			break;
//			
//		default:
//			System.out.println("F입니다");
//			break;
		}
	}
	
	public static void main(String[] args) {
		int num = num();
		match(num);
		
	}
}
