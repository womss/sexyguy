import java.util.Scanner;

// main함수에서 진행
//	1을 입력하면 학생 수 값을 입력받을 수 있게							//Scanner // while
//	2을 입력하면 각 학생들의 점수를 입력받을 수 있게 (점수 범위 고려 o)		//
//	3을 입력하면 학생들의 점수리스트 출력할 수 있게						//
//	4를 입력하면 최고점수와 평균점수를 분석해서 출력할 수 있게				//
//	5를 입력하면 프로그램 종료										//



public class PMain3 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		
		int front = 0;	// 메뉴 초기화면
		int hu = 0;	// 학생 수
		int member[] = null;	// 학생 배열 /전역 변수 /if for 지역변수
		int max = 0;
		int ever = 0;
		for (int i = 0; true; i++) {
//		int sc = 0;
			int gkq = 0;
			System.out.printf("   학생 점수 관리 프로그램\n"
					+ " 1. 학생 수 입력\n"
					+ " 2. 학생 점수 입력\n"
					+ " 3. 학생 점수 리스트\n"
					+ " 4. 최고점수, 평균점수\n"
					+ " 5. 프로그램 종료");
			front = k.nextInt();
			if (front == 1) {								//1번을 입력할 시 
				System.out.println("학생 정원 : ");			//학생 정원 : 출력하고 입력
				hu = k.nextInt();
				member = new int [hu];
			}
			else if (front == 2) {
					for (int j = 0; j < member.length; j++) { // 입력받은 학생 수만큼 점수 입력
						System.out.println(" 학생 점수 입력 : ");
						int sc = k.nextInt();
						member[j] = sc;
				}}
					else if (front == 3) {
					for (int q = 0; q < member.length; q++) {	// 학생 수만큼 점수 리스트를 출력
						System.out.println("-----------------------------");
						System.out.printf("%d번 학생 점수 : %d\n", q, member[q]);
//						System.out.println(member[q]);
						
					}System.out.println("-----------------------------");
				}else if (front == 4) {
					for (int j = 0; j < member.length; j++) {
						if (max < member[j]) {
							max = member[j];
						}System.out.printf(" 최대 점수는 : %d점", member[j]);
						for (int j2 = 0; j2 < member.length; j2++) {
							gkq += member[j2]; 
							System.out.println(gkq/member.length);   // @@ 이거 다시 보기
						}
					}
				}
			}
				
		}
//			for (int j = 0; j < member.length; j++) {
//				
//				System.out.println("학생 점수 입력");
//				int sc = k.nextInt();
//			}
		}
		
	
