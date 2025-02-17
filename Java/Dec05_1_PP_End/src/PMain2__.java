import java.util.Scanner;

public class PMain2__ {
	// 로또 프로그램 (함수 사용 O)
		// 로또 번호는 총 6개 번호 ( 보너스 번호 x )
		//	(1 ~ 45 사이의 정수 범위) + 중복 X
		// 컴퓨터가 뽑은 것과 유저가 입력한 값을 비교해서
		// 6개 일치 : 1등 / 5개 일치 : 2등 / 4개 일치 : 3등 / 나머지 : 꽝
		//		각각 경우에 따른 문구 출력
		
		
	
	public static void start() {
		System.out.println("로또 프로그램 시작");
		System.out.println("번호를 입력해주세요");
	}
	public static int mynum() {
		Scanner k = new Scanner(System.in);
		int[] rull = new int [6];
		
		while (true) {
		for (int i = 0; i < rull.length; i++) {
			System.out.printf(" %d번째 번호는 : \n", i + 1);
			int mynum = k.nextInt();
			if ((mynum > 45) || (mynum < 0)) {
			System.err.println("범위를 벗어난 입력입니다 다시 입력해주세요");
			activate1();
			}  
			for (int j = 0; j < rull.length; j++) {
				if ((mynum <= 45) || (mynum > 0)) {
				rull[j] = mynum;
				System.out.println(rull[j]);
				break ;
			}
		}	
	}
}}
	public static void activate1() {
		
		mynum();
	}
	public static void activate2() {
		start();
		activate1();
	}
	public static void main(String[] args) {
		activate2();
	}
	
}
