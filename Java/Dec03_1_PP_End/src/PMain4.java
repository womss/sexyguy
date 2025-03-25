// 함수.ver
//	1을 입력하면 학생 수 값을 입력받을 수 있게							//1. 학생 수 입력
//	2을 입력하면 각 학생들의 점수를 입력받을 수 있게 (점수 범위 고려 o)		//2. 학생 점수 입력
//	3을 입력하면 학생들의 점수리스트 출력할 수 있게						//3. 2번 프린트
//	4를 입력하면 최고점수와 평균점수를 분석해서 출력할 수 있게				//4. 2번 max, 2합 / 3 = ever
//	5를 입력하면 프로그램 종료										//5. 종료

	// 메뉴 출력
	// 선택할 메뉴 번호 받아오기
	// 학생수 값 받아오기
	// 학생 개인의 점수 받아오기
	// 학생들의 점수 입력하기
	// 학색들의 점수를 출력하기
	// 최고점수, 평균점수 출력하기
	// 종료메시지
	// 기능들 모아둔 함수



import java.util.Scanner;

public class PMain4 {
//메뉴 출력
	public static int menu() {
Scanner k = new Scanner(System.in);
		
		System.out.println("학생 점수 관리 프로그램을 시작합니다.\n메뉴 번호를 입력해주세요.\n"
							+ "1. 학생 수 입력\n2. 점수 입력\n3. 점수 리스트 출력\n4. 최고점수, 평균점수 분석\n5. 종료하기");
		int menu = k.nextInt();
		return menu;
	}
	
// 선택할 메뉴 번호 받아오기
	public static void menumenu(int mm) {
	
		
		

	
	}
	
// 학생수 값 받아오기
	public static int std(int mm , int[] a) {
		Scanner k = new Scanner(System.in);
		if (mm == 1) {
			System.out.println("학생 수 입력 : ");
			int std = k.nextInt();
			System.out.printf("학생 수는 %d명", std);
//			a = new int std;
			
		
			
			return std;
		}
		return mm;
		
	}
	
// 학생 개인의 점수 받아오기
	public static void stdSc(int mm) {
		menu();
		Scanner k = new Scanner(System.in);
		System.out.println();
	}
// 학생들의 점수 입력하기
// 학색들의 점수를 출력하기
// 최고점수, 평균점수 출력하기
// 종료메시지
// 기능들 모아둔 함수

	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		int[] a = null;
		int mm = menu();
		int stdN = std(mm, a);
		stdSc(mm);
	}
}
