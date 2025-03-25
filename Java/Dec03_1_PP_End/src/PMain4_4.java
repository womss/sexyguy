import java.util.Scanner;
	// 메뉴 출력
	// 선택할 메뉴 번호 받아오기
	// 학생수 값 받아오기
	// 학생 개인의 점수 받아오기
	// 학생들의 점수 입력하기
	// 학색들의 점수를 출력하기
	// 최고점수, 평균점수 출력하기
	// 종료메시지
	// 기능들 모아둔 함수


public class PMain4_4 {
	
	
	// 메뉴 출력
	public static void startFirst() {
		System.out.println("==================================================");
		System.out.println("\t\t1. 학생수 | 5. 종료");
		System.out.println("==================================================");
	}
	
	public static void start() {
		System.out.println(" ==================================================");
		System.out.println("|1. 학생수 | 2. 점수입력 | 3. 점수리스트 |"
				+ " 4. 분석 | 5. 종료 |");
		System.out.println(" ==================================================");
	}
	
	
	// 선택할 메뉴 번호 받아오기
	public static int getSelectNo() {
		Scanner k = new Scanner(System.in);
		System.out.print("선택> ");
		int selelctNo = k.nextInt();
		return selelctNo;
	}
	
	// 학생수 값 받아오기
	public static int getStudentNum() {
		Scanner k = new Scanner(System.in);
		System.out.print("학생 수 : ");
		int studentNum = k.nextInt();
		if (studentNum <= 0) {
			System.out.println("1명 이상 ");	// 1명 아래로 할시엔 while - if문에서 else처리
		}
		return (studentNum > 0) ? studentNum : getStudentNum();
	}	
	
	// 학생 개인의 점수 받아오기
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
		
	// 학생들의 점수 입력하기
	public static int[] getScore(int[] scores) { 
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d번 학생 점수 입력 : ", i + 1);
			scores[i] = getScore();
		}
		return scores;
	}
		
	// 학생들의 점수를 출력하기
	public static void printScore(int[] scores) {
		int index = 1;
		for (int i : scores) {
			System.out.printf("%d번 학생 점수 : %d점\n", index++, i);
		}
	}
		
	// 최고점수, 평균점수 출력하기
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
		
	// 종료메시지
	public static void end() {
		System.out.println("\t\t\t종료합니다.");
		System.out.println("-------------------------------");
	}
		
	// 기능들 모아둔 함수
	public static void activate() {
		int selectNo = 0;
		int studentNum = 0;
		int[] scores = null;
		
		startFirst();
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
		activate();
	}
}
