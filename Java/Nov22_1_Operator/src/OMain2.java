import java.util.Scanner;

public class OMain2 {
	public static void main(String[] args) throws InterruptedException {
		// 키, 몸무게를 입력받아서 => 비만도 검사 프로그램
		
		// 표준체중 = (키 - 100) * 0.9
		// 비만도 = (실제 체중 / 표준 체중) * 100
		// 비만도가 120이 넘으면 '비만', 아니면 '안비만' 문구를 출력
		// 아무 키나 입력했을 때 프로그램이 종료되게
		
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("안녕하세요\n체중측정 프로그램입니다\n키와 몸무게를 입력해주세요.\n");
		System.out.print("키 : ");
		double tall = k.nextDouble();
		double no = (tall - 100) * 0.9;
		System.out.print("몸무게 : ");
		double wei = k.nextDouble();
		double kg = (wei / no) * 100;
		
		String fat = (kg > 120) ? "비만입니다" : "비만이 아닙니다";
		
		
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		System.out.println(".");
		
		System.out.println("______________________________");
		Thread.sleep(200);
		System.out.println("\t 작성자의 정보");
		Thread.sleep(200);
		System.out.printf(" 작성자의 키 \t: %.1fcm\n", tall);
		Thread.sleep(500);
		System.out.printf(" 작성자의 몸무게 \t: %.1fkg\n", wei);
		Thread.sleep(200);
		System.out.println("______________________________");
		Thread.sleep(500);
		System.out.println("\t  측정결과");
		Thread.sleep(500);
		System.out.printf(" 작성자의 표준체중 \t: %.1fkg\n", no);
		Thread.sleep(500);
		System.out.printf(" 작성자의 체중 측정 \t: %s\n", fat);
		Thread.sleep(200);
		System.out.println("______________________________");
		Thread.sleep(500);
		System.out.print(" 종료하고 싶으시다면 아무키나 눌러주세요 : ");
		String end = k.next();
		System.out.println("프로그램을 종료합니다.");
		// 프로그램을 끄는 건 따로 없고  프로그램이 끝나는 기준은 아무런 코드가 남아있지 않다면 '자동' 종료
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
