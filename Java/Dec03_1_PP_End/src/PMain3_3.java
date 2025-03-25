import java.util.Iterator;
import java.util.Scanner;

//main함수에서 진행
//	1을 입력하면 학생 수 값을 입력받을 수 있게							//Scanner // while
//	2을 입력하면 각 학생들의 점수를 입력받을 수 있게 (점수 범위 고려 o)		//
//	3을 입력하면 학생들의 점수리스트 출력할 수 있게						//
//	4를 입력하면 최고점수와 평균점수를 분석해서 출력할 수 있게				//
//	5를 입력하면 프로그램 종료										//



public class PMain3_3 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int selectNo = 0;
		int studentNum = 0;
		// 배열의 기본값 = null;
		int[] scores = null;
		
		a : while (true) {
			if (scores == null) {
				System.out.println("======================================");
				System.out.println("\t\t1. 학생수 | 5. 종료");
				System.out.println("======================================");
				System.out.print("선택>");
				selectNo = k.nextInt();
				if (!(selectNo == 1 || selectNo == 5)) {
					System.out.println("\t잘못된 메뉴 선택");
					continue;
				}
			} else {
				System.out.println("======================================");
				System.out.println("1. 학생수 | 2. 점수 입력 | "
						+ "3. 점수 리스트 | 4. 분석 | 5. 종료");
				System.out.println("======================================");
				System.out.print("선택>");
				selectNo = k.nextInt();
			}
			
			switch (selectNo) {
//1번 메뉴------------------------------------------------------------------------
			case 1:
				System.out.print(" 학생 수 : ");
				studentNum = k.nextInt();
				if (studentNum <= 0) {
					System.out.println("학생 수는 1명 이상");
					break;
				}
				scores = new int [studentNum];
				
				break;
//2번 메뉴------------------------------------------------------------------------
			case 2:
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("%d번 학생 점수 입력 : ", i+1);
					scores[i] = k.nextInt();
					if (scores[i] < 0 || scores[i] > 100) {
						System.out.println("잘못된 점수 입력");
						i--;
						// i++로 인한 다음 인덱스로의 이동을 취소하는 효과@@@@@@@@@@@@@@@
						// 잘못된 점수가 입력되면 i--를 통해서
						// 인덱스를 감소시켜, 현재 인덱스의 점수를
						// 다시 입력받을 수 있도록 함
						continue;
					}
				}
				break;
//3번 메뉴------------------------------------------------------------------------
			case 3:
				int index = 1;
				for (int i : scores) { // for문이랑 다르게 index(i)값이 없어서 임의로 불러와야함
					System.out.printf("%d번 학생 점수 : %d점\n", index++, i); //@@@@@@@@@@@@@
					
				}
			break;
//4번 메뉴------------------------------------------------------------------------
			case 4:
				int sum = 0;
				double avg = 0;
				int max = 0;
				for (int i : scores) {
					sum += i;
					max = (max < i) ? i : max;
				}
				avg = (double) sum / scores.length; // <=배열의 크기가 학생의 수
				System.out.printf("최고 점수 : %d점\n", max);
				System.out.printf("평균 점수 : %.2f점\n", avg);
				break;
//5번 메뉴------------------------------------------------------------------------
			case 5:
				System.out.println("종료합니다.");
				System.out.println("==================================");
				break a;
				
			default:
				System.out.println("==================================");
				System.out.println("다시 입력");
				break;
			}
			
			
			
		}
	}
}
