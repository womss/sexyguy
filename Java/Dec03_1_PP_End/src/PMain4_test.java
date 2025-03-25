import java.util.Scanner;
//함수.ver
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


public class PMain4_test {
	// 4.처음 보이는 메뉴 팝업
	public static void startFirst() {
		System.out.println("==================================================");
		System.out.println("\t\t1. 학생수 | 5. 종료");
		System.out.println("==================================================");
	}// 5. startFirst 종료 다시 activate로
	
	public static void start() {
		System.out.println(" ==================================================");
		System.out.println("|1. 학생수 | 2. 점수입력 | 3. 점수리스트 |"
				+ " 4. 분석 | 5. 종료 |");
		System.out.println(" ==================================================");
	}
	
	
	public static int getSelectNo() {
		Scanner k = new Scanner(System.in);
		System.out.print("선택> ");
		int selelctNo = k.nextInt();
		return selelctNo;
	}
	
	public static int getStudentNum() {
		Scanner k = new Scanner(System.in);
		System.out.print("학생 수 : ");
		int studentNum = k.nextInt();
		if (studentNum <= 0) {
			System.out.println("1명 이상 ");
		}
		return (studentNum > 0) ? studentNum : getStudentNum();
	}	
	
	public static int getScore() {
		Scanner k = new Scanner(System.in);
		int score = k.nextInt();
		if (score > 100) {
			System.out.println("점수는 100점을 넘을 수 없습니다.");
			System.out.print("다시 입력 : ");
			}else if (score < 0) {
				System.out.println("점수는 0점보다 낮을 수 없습니다.");
				System.out.print("다시 입력 : ");
			}
		return (score >= 0 && score <= 100) ? score : getScore();
	}
		
	public static int[] getScore(int[] scores) { // 리턴타입에 배열도 들어가는지 처음 알았음
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d번 학생 점수 입력 : ", i + 1);
			scores[i] = getScore();
		}
		return scores;
	}
		
	public static void printScore(int[] scores) {
		int index = 1;
		for (int i : scores) {
			System.out.printf("%d번 학생 점수 : %d점\n", index++, i);
		}
	}
		
	public static void printStats(int[] scores) {
		int sum = 0;
		int max = 0;
		double avg = 0;
		for (int i : scores) {
			sum += i;
			max = (max < i) ? i : max;
		}
		avg = (double) sum / scores.length;
		System.out.printf("최고 점수 : %d점\n", max);
		System.out.printf("평균 점수 : %.2f점\n", avg);
	}
		

	public static void end() {
		System.out.println("\t\t\t종료합니다.");
		System.out.println("-------------------------------");
	}
		
					// 2. activate 실행
	public static void activate() {
		int selectNo = 0;
		int studentNum = 0;
		int[] scores = null;
		// 3.startFirst 실행
		startFirst();
		// 5-1 종료 후 복귀
		selectNo = getSelectNo();
		if (selectNo == 1) {
			studentNum = getStudentNum();
			scores = new int [studentNum];
			while (true) {
				start();
				selectNo = getSelectNo();
				if (selectNo == 1 ) {
					studentNum = getStudentNum();
					scores = new int[studentNum];
				} 
				else if (selectNo == 2) {
					getScore(scores);
				}
				else if (selectNo == 3) {
					printScore(scores);
				}
				else if (selectNo == 4) {
					printStats(scores);
				}
				else if (selectNo == 5) {
					end();
					break;
				}
				else {
					System.out.println("잘못된 번호입니다");
					System.out.println("다시 입력하세요");
				}
			}
			
		}else if (selectNo == 5) {
			end();
		}else {
			System.out.println("\t입력이 잘못되었습니다.");
			System.out.println("\t다시 입력하세요");
			activate();
		}
		
	}
	
	
	public static void main(String[] args) {
		// 1. main에서 제일 먼저 실행
		activate();
	}
}
