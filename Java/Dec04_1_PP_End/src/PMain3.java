import java.util.Random;
import java.util.Scanner;

public class PMain3 {
	// 가위바위보 게임 (함수 사용 o)
	// 1. 가위 => 콘솔창에 1을 입력하면 가위
	// 2. 바위 => 콘솔창에 2를 입력하면 바위
	// 3. 보 => 콘솔창에 3을 입력하면 보
	// 컴퓨터랑 가위바위보해서 1번 질동안 몇 숭하는지 출력할 수 있게
	
	
	
	public static int userPic() {
		Scanner k = new Scanner(System.in);
		Random r = new Random();
	
		System.out.println("\t가위 바위 보 게임을 시작합니다");
		System.out.println("\t=========================");
		System.out.println("\t\t1. 가위 ");
		System.out.println("\t\t2. 바위 ");
		System.out.println("\t\t3. 보 ");
		System.out.println("\t=========================");
		System.out.println(" \t해당 번호를 입력해주세요  : ");
		int usernumber = k.nextInt();
		if (usernumber == 1) {
			System.out.println("사용자가 낸 건 : 가위");
		}else if (usernumber == 2) {
			System.out.println("사용자가 낸 건 : 바위");
		}else if (usernumber == 3) {
			System.out.println("사용자가 낸 건 : 보");
		}
	return usernumber;
	}
	public static int aiPic() throws InterruptedException {
		Random r = new Random();
		
		System.out.println("AI가 낸 건 : ");
		Thread.sleep(1000);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println(".");
		Thread.sleep(1000);
		System.out.println(".");
		Thread.sleep(1000);
		int aiN = r.nextInt(3)+1;
		if (aiN == 1) {
			System.out.print("가위");
			System.out.println();
		}else if (aiN == 2) {
			System.out.print("바위");
			System.out.println();
		}else if (aiN == 3) {
			System.out.print("보");
			System.out.println();
		}
		return aiN;
	}
	
	public static void Match(int usernumber , int aiP, int win2, int lose, int draw ) throws InterruptedException {
		while (true) {
		if ((usernumber - aiP == -2) || (usernumber - aiP == 1 )) {
			System.out.println("=========");
			System.out.println(" 이겼습니다 ");
			System.out.println("=========");
			win2++;
			activate(win2, lose, draw);
			break;
		} else if (usernumber - aiP == 0) {
			System.out.println("=========");
			System.out.println(" 비겼습니다 ");
			System.out.println("=========");
			activate(win2, lose, draw);
			break;
		}else if ((usernumber - aiP == -1 ) || (usernumber - aiP == 2 )) {
			System.out.println("=========");
			System.out.println("  졌습니다 ");
			System.out.println("=========");
			
			System.out.printf("<< %d승으로 종료 >>", win2);
		}break;
	}
}
	public static void activate(int win, int lose , int draw) throws InterruptedException {
		
		
		int usernumber = userPic(); // 사용자 번호 입력 (가위바위보 출력)
	
		int aiP = aiPic();
		
		Match(usernumber, aiP,win,lose,draw);
	}
	
	public static void main(String[] args) throws InterruptedException {

		int win = 0;
		int lose = 0;
		int draw = 0;
		
		activate(win, lose, draw);
	}
}
