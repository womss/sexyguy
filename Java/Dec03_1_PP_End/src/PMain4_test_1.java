import java.util.Scanner;

//함수.ver
//	1을 입력하면 학생 수 값을 입력받을 수 있게							
//	2을 입력하면 각 학생들의 점수를 입력받을 수 있게 (점수 범위 고려 o)		
//	3을 입력하면 학생들의 점수리스트 출력할 수 있게						
//	4를 입력하면 최고점수와 평균점수를 분석해서 출력할 수 있게				
//	5를 입력하면 프로그램 종료	

// 함수는 뭐가 먼저 와도 노상관


public class PMain4_test_1 {
	
	public static void menu() {
		Scanner k = new Scanner(System.in);
		
		System.out.println(" _______성적 프로그램_______");
		System.out.println("________________________");
		System.out.println(" 1. 학생수 입력\t\t|");
		System.out.println("________________________|");
		System.out.println(" 2. 학생 점수 입력\t\t|");
		System.out.println("________________________|");
		System.out.println(" 3. 점수리스트 출력\t\t|");
		System.out.println("________________________|");
		System.out.println(" 4. 최고점수, 평균점수 출력\t|");
		System.out.println("________________________|");
		System.out.println(" 5. 프로그램 종료\t\t|");
		System.out.println("________________________|");
		
	}
	private static void name() {
		
	}
//		aa
//	}
//	gce
//	컴  <= jvm(개쩌는 할아브)(바이트코드) <= 컴파일러가 바이트코드(이클립스)
//	jre
//	
	public static void main(String[] args) {
		menu();
	}
}
