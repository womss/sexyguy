import java.util.Random;
import java.util.Scanner;

public class PMain3_1 {
	// 가위바위보 게임 (함수 사용 o)
	// 1. 가위 => 콘솔창에 1을 입력하면 가위
	// 2. 바위 => 콘솔창에 2를 입력하면 바위
	// 3. 보 => 콘솔창에 3을 입력하면 보
	// 컴퓨터랑 가위바위보해서 1번 질동안 몇 숭하는지 출력할 수 있게
	
	// 게임 시작하면서 룰 설명
	public static void printStart(String[] h) {
		System.out.println("<< 가위바위보 게임 시작 >>");
		System.out.println(" =======================");
		for (int i = 1; i < h.length; i++) {
			System.out.printf("│ %d. %s\t\t\t│\n", i, h[i]);
		}
		System.out.println(" =======================");
	}
	// 컴퓨터가 뭐 냈는지
	public static int getComHand() {
		Random r = new Random();
		int comHand = r.nextInt(3) + 1;
		return comHand;
	}
	
	// 유저가 뭐 냈는지
	public static int getUserHand() {
		Scanner k = new Scanner(System.in);
		System.out.println("뭐낼래 ? : ");
		int userHand = k.nextInt();
		if (userHand < 1 || userHand > 3) {
			System.out.println("잘못 입력했습니다. 다시 입력하세요.");
		}
		return (userHand >= 1 && userHand <= 3) ? userHand : getComHand();
	}
	
	// 각자 뭐 냈는지 출력
	public static void printHand(int user, int com, String[] hand) {
		System.out.println("==================================");
		System.out.printf("│ 유저\t: %s\t│\n", hand[user]);
		System.out.printf("│ 컴퓨터: %s\t│\n", hand[com]);
		System.out.println("==================================");
	}
	// 게임 한 판에 대한 판정
	public static int judge(int user, int com) {
		int game = user - com;
		if (game == 0) {
			System.out.println("무승부");
			return 0;
		}else if (game == -1 || game == 2) {
			System.out.println("패배");
			return -123123;
		}else {
			System.out.println("승리");
			return 1;
		}
		
	}
	
	// 유저가 질 떄까지 진행한 후에 한 번 질동안 몇 숭했는지
	//		그 결과를 받아옴
	public static int getResult(String[] hand) {
		int com = 0;
		int user = 0;
		int win = 0;
		int result = 0;
		
		while (true) {
			com = getComHand();
			user = getUserHand();
			printHand(user, com, hand);
			result = judge(user, com);
			if (result == -123123) {
				break;
			}
			win += result;
		}
		return win;
	}
	
	// 몇 승했는지에 대한 결과 출력
	public static void printResult(int win){
		System.out.println("====================");
		System.out.printf("│ %d승으로 종료\t  │\n", win);
		System.out.println("====================");
	}
	// 실행하기 위한 함수
	public static void activate() {
		String[] hand = { "ㅋ", "가위", "바위", "보"};
		printStart(hand);
		
		int win = getResult(hand);
		printResult(win);
		
	}
	
	public static void main(String[] args) {
		activate();
	}
	// 
	
	
	
	
	
}
