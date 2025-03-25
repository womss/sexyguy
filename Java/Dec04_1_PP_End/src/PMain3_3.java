import java.util.Random;
import java.util.Scanner;

public class PMain3_3 {
	// 가위바위보 게임 (함수 사용 o)
	// 1. 가위 => 콘솔창에 1을 입력하면 가위 -2 1 승
	// 2. 바위 => 콘솔창에 2를 입력하면 바위 0 무승부
	// 3. 보 => 콘솔창에 3을 입력하면 보	-1 2 패
	// 컴퓨터랑 가위바위보해서 1번 질동안 몇 숭하는지 출력할 수 있게
	
	public static int userPic() throws InterruptedException {
	Scanner k = new Scanner(System.in);
	System.out.println("\t\t▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
	System.out.println("\t\t▦  가위바위보 게임을 시작합니다\t▦");
	System.out.println("\t\t▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
	System.out.println("\t\t▦\t 1. 가위\t\t▦");
	System.out.println("\t\t▦\t 2. 바위\t\t▦");
	System.out.println("\t\t▦\t 3. 보\t\t▦");
	System.out.println("\t\t▦    번호를 선택하세요 :  \t▦");
	System.out.println("\t\t▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
	int uPic = k.nextInt();
	System.out.println("\t\t\t사용자의 선택");
	Thread.sleep(1000);
	if (uPic == 1) {
		System.out.println();
		System.out.println("\t\t         χ_χ_χ_χ");
		System.out.println("\t\t         χ 가위 χ");
		System.out.println("\t\t         χ_χ_χ_χ");
	}else if (uPic == 2) {
		System.out.println();
		System.out.println("\t\t         δ_δ_δ_δ");
		System.out.println("\t\t         δ 바위 δ");
		System.out.println("\t\t         δ_δ_δ_δ");
	}else if (uPic == 3) {
		System.out.println();
		System.out.println("\t\t         ψ_ψ_ψ_ψ");
		System.out.println("\t\t         ψ  보  ψ");
		System.out.println("\t\t         ψ_ψ_ψ_ψ");
	}return uPic;
	
	}
	public static int aiPic() throws InterruptedException {
		Random r = new Random();
		int aPic = r.nextInt(3)+1;
		Thread.sleep(1000);
		System.out.println("\t\t__________________________");
		System.out.println("\t\t\t ai의 선택");
		Thread.sleep(500);
		System.out.println("\t\t\t    .");
		Thread.sleep(500);
		System.out.println("\t\t\t    .");
		Thread.sleep(500);
		System.out.println("\t\t\t    .");
		Thread.sleep(500);
		if (aPic == 1) {
			System.out.println();
			System.out.println("\t\t         χ_χ_χ_χ");
			System.out.println("\t\t         χ 가위 χ");
			System.out.println("\t\t         χ_χ_χ_χ");
			Thread.sleep(1000);
		}else if (aPic == 2) {
			System.out.println();
			System.out.println("\t\t         δ_δ_δ_δ");
			System.out.println("\t\t         δ 바위 δ");
			System.out.println("\t\t         δ_δ_δ_δ");
			Thread.sleep(1000);
		}else if (aPic == 3) {
			System.out.println();
			System.out.println("\t\t         ψ_ψ_ψ_ψ");
			System.out.println("\t\t         ψ  보  ψ");
			System.out.println("\t\t         ψ_ψ_ψ_ψ");
			Thread.sleep(1000);
		}return aPic;
	}
	public static void match(int up, int ap, int win) throws InterruptedException {
		if ((up - ap == -2) || (up - ap == 1)) {
			win ++;
			
			System.out.println();
			System.out.println("\t\t\tωωωωωωωωωω");
			System.out.println("\t\t\tω이겼습니다 ω");
			System.out.printf("\t\t\tω %d연승중  ω\n", win);
			System.out.println("\t\t\tωωωωωωωωωω");
			Thread.sleep(1500);
			rePlay(win);
		}else if (up - ap == 0) {
			
			System.out.println();
			System.out.println("\t\t\t무승부 입니다");
			System.out.println();
			Thread.sleep(1500);
			rePlay(win);
		}else if ((up - ap == -1) || (up - ap == 2)) {
			
			System.out.println();
			System.out.println("\t\t      ㅠ_ㅠ졌습니다ㅠ_ㅠ");
			System.out.printf("\t\t\t %d연승 마감\n", win);
			System.out.println();
			Thread.sleep(1500);
		}
	}
	
	
	public static void rePlay(int win) throws InterruptedException {
		
		int up = userPic();
		int ap = aiPic();
		match(up, ap, win);
	}
	
	public static void main(String[] args) throws InterruptedException {
		int win = 0;
		rePlay(win);
	}
	
	
}
