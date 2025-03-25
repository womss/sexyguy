import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class PMain2_1 {
	// 로또 프로그램 (함수 사용 O)
	// 로또 번호는 총 6개 번호 ( 보너스 번호 x)
	//	(1 ~ 45 사이의 정수 범위) + 중복 X
	// 컴퓨터가 뽑은 것과 유저가 입력한 값을 비교해서
	// 6개 일치 : 1등 / 5개 일치 : 2등 / 4개 일치 : 3등 / 나머지 : 꽝
	//		각각 경우에 따른 문구 출력
	
	// 정수 하나 입력
	public static int getNum() {
		Scanner k = new Scanner(System.in);
		int num = k.nextInt();
		if (num < 1 || num > 45) {
			System.out.println("다시 입력 : ");
		}
		return (num >= 1 && num <= 45) ? num : getNum();
	}
	
	// 정수 6개에 대한 입력
	public static int[] getNums() {
		int[] myAnswer = new int [6];
		for (int i = 0; i < myAnswer.length; i++) {
			System.out.printf("%d번째 숫자 입력 : ", i + 1);
			myAnswer[i] = getNum();
		}
		return myAnswer;
	}
	// 입력한 숫자 출력
	public static void printMyAnswer(int[] myAnswer) {
		System.out.println("내가 뽑은 숫자 !");
		for (int i : myAnswer) {
			System.out.print("[" + i + "]");
		}
		System.out.println();
		System.out.println("================================");
	}
	// 랜덤한 정수 6개 뽑기 + 중복 제거
	public static int[] getLotto() {
		int[] lottoNum = new int[6];
		Random r = new Random();
		for (int i = 0; i < lottoNum.length; i++) {
			lottoNum[i] = r.nextInt(45)+1;
			// 앞의 배열 요소와 뒤의 배열요소의 값을
			// 구분하기 위해서 반복문 하나 더 추가
			for (int j = 0; j < i; j++) {
				System.out.println(lottoNum[j] + " " + lottoNum[i]);
				// i번째에서 뽑은거랑 이전에 뽑은 거를 비교해서
				if (lottoNum[j] == lottoNum[i]) {
					i--; 	// 중복된 값이 있으면 제거하고
							// 첫번째 for문으로 가서 다시 뽑는다
				}
			}
		}
		return lottoNum;
	}

	// 컴퓨터가 뽑아온 숫자 출력
	
	public static void printLottoNum(int[] lottoNum) {
		System.out.println("로또 번호");
		for (int i : lottoNum) {
			System.out.print("[" + i + "]");
		}
		System.out.println();
		System.out.println("================================");
	}
	// 입력한 번호와 랜덤으로 뽑힌 번호를 모든 경우의 수로 값이 같은지 비교
	//		같은 경우에는 카운트를 올리기
	private static int chekNum(int[] myAnswer, int[] lottoNum) {
		int count = 0;
		for (int i = 0; i < lottoNum.length; i++) {
			for (int j = 0; j < myAnswer.length; j++) {
				if (lottoNum[i] == myAnswer[j]) {
					count++;
				}
			}
		}
		return count;
	}
	// 결과 출력
	public static void printResult(int count) {
		System.out.printf("%d개 맞춰서 ...", count);
		if (count == 6) {
			System.out.println("1등!");
		} else if (count == 5) {
			System.out.println("2등!");
		} else if (count == 4) {
			System.out.println("3등!");
		} else if (count == 3) {
		System.out.println("4등!");
		} else {
			System.out.println("꽝!");
		}
	}
	// 실행
	public static void activate() {
		int[] lotoNum = getLotto();
				int[] myAnswer = getNums();
				printMyAnswer(myAnswer);
				printLottoNum(lotoNum);
				int count = chekNum(myAnswer, lotoNum);
				printResult(count);
	}
	public static void main(String[] args) {
		activate();
	}
	
}

