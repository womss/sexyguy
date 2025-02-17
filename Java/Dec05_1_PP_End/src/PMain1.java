import java.util.Random;
import java.util.Scanner;

public class PMain1 {
	// UP % DOWN 게임 (함수 사용 O)
	// 컴퓨터가 1 ~ 100 사이의 정수를 뽑음 (ex : 34)
	// 유저가 입력
	//		1트 : 50 -> down
	//		2트 : 25 -> up
	//		... 아트몬스터
	//		10트 : 34 => 정답! (프로그램 종료)
	
	public static void start() {
		System.out.println("\t  UP & DOWN 게임을 시작합니다");
		System.out.println("\t 컴퓨터가 생각한 숫자를 맞춰야 하며");
		System.out.println("\t입력한 값이 더 낮아야 할 때는 DOWN");
		System.out.println("\t 입력한 값이 더 높아야 할 때는 UP");
		System.out.println("\t   입력한 값이 맞으면 정답입니다");
	}

	public static int aiNumber() {
		Random r = new Random();
		int answer = r.nextInt(100)+1;
		return answer;
	}
	public static int go() throws InterruptedException {
		Scanner k = new Scanner(System.in);
		System.out.println();
		Thread.sleep(1000);
		System.out.println("\t      ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ");
		System.out.println("\t       숫자를 입력하세요 : ");
		System.out.println("\t      ΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞΞ");
		int go = k.nextInt();
		if ((go > 100) || (go <0)) {
			System.err.println("\t    형식에 맞는 답이 아닙니다");
			go();
		}
		return go;
 	}
	public static void match(int an, int go, int count) throws InterruptedException {
		
		if (an > go) {
			Thread.sleep(1000);
			System.out.println("\t       ωωωωωωωωωωω");
			System.out.println("\t       ω   U P   ω");
			System.out.println("\t       ωωωωωωωωωωω");
			count ++;
			activate1(an, count);
		}else if (an < go) {
			Thread.sleep(1000);
			System.out.println("\t       ωωωωωωωωωωω");
			System.out.println("\t       ω D O W N ω");
			System.out.println("\t       ωωωωωωωωωωω");
			count ++;
			activate1(an, count);
		}else if (an == go){
			Thread.sleep(500);
			System.out.println("\t   \\^O^/ 정답입니다 \\^O^/");
			System.out.println();
			System.out.printf("\t   %d번 만에 정답을 맞히셨습니다.\n", count);
			Thread.sleep(500);
			System.out.println();
			System.out.println("\t      다시 하시겠습니까?");
			System.out.println("\t    1. 예\t2. 아니요");
			Scanner k = new Scanner(System.in);
			int re = k.nextInt(); 
			if (re == 1) {
				activate2();
			}else if (re == 2) {
				System.out.println("\t   UP & DOWN 게임을 종료합니다.");
			}
		}
	}
	public static void activate1(int an, int count) throws InterruptedException {
		int go = go();
		
		match(an, go,count);
	}
	public static void activate2() throws InterruptedException {
		int count = 0;
		start();
		int an = aiNumber();
		activate1(an, count);
	}
	public static void main(String[] args) throws InterruptedException {
		
		activate2();
	}
}
