import java.util.Random;
import java.util.Scanner;

public class PMain1_1 {
	// UP % DOWN 게임 (함수 사용 O)
		// 컴퓨터가 1 ~ 100 사이의 정수를 뽑음 (ex : 34)
		// 유저가 입력
		//		1트 : 50 -> down
		//		2트 : 25 -> up
		//		... 아트몬스터
		//		10트 : 34 => 정답! (프로그램 종료)
	// 몇번만에 맞췄는지 추가하기
	
	// 컴퓨터가
	private static int getNumber() {
		Random r = new Random();
		int i = r.nextInt(100)+1;
		return i;
	}
	
	//유저가 답을 입력할 수 있는 함수
	private static int getUserAns() {
		Scanner k = new Scanner(System.in);
		System.out.println("정답은 ? : ");
		int answer = k.nextInt();
		if (answer < 1) {
			System.out.println("정답은 1 이상이어야 합니다.");
		}else if (answer > 100) {
			System.out.println("정답은 100 이하이어야 합니다.");
		}
		return (answer >= 1 && answer <= 100) ? answer : getUserAns();
	}
	
	// 정답을 한 번 입력했을 때 정답인지 아닌지 확인
	//		+ 반복문을 깰지 말지 전달됨
	private static boolean checkAnswer(int number, int userAns) {
		if (number == userAns) {
			System.out.println("정답은 ");
//			return true;		// 정답일 때 true값을 리턴하면서 종료하게
		} else if (number > userAns) {
			System.out.println("UP !");
//			return false;		// 정답이 아닐때 false값을 리턴하면서
								// 게임을 계속 진행하도록
		} else {
			System.out.println("DOWN !");
//			return false;
		}
		return (number == userAns); // 이 조건에 맞을때 true,
									// 맞지 않으면 false 값 return
	}
	
	// 정답을 맞출때까지 반복하는 함수
	public static void printResult() {
		int number = getNumber();
		int userAns = 0;
		int turn = 0;
		while (true) {
			turn++;
			userAns = getUserAns();
			if (checkAnswer(number, userAns)) { // 정답 O(을 맞춘다면) => true(값이 되서 돌아가고 아니면 안돌아감)
				System.out.printf("[%d] !\n", number);
				System.out.printf("%d번 만에 정답 !\n", turn);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		printResult();
	}
}
