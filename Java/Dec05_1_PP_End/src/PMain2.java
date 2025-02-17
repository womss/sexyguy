import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PMain2 {
	// 로또 프로그램 (함수 사용 O)
	// 로또 번호는 총 6개 번호 ( 보너스 번호 x)
	//	(1 ~ 45 사이의 정수 범위) + 중복 X
	// 컴퓨터가 뽑은 것과 유저가 입력한 값을 비교해서
	// 6개 일치 : 1등 / 5개 일치 : 2등 / 4개 일치 : 3등 / 나머지 : 꽝
	//		각각 경우에 따른 문구 출력
	
	// 정수 하나 입력
	// 정수 6개에 대한 입력 0
	// 입력한 숫자 출력 0
	// 랜덤한 정수 6개 뽑기 + 중복 제거
	// 컴퓨터가 뽑아온 숫자 출력
	// 입력한 번호와 랜덤으로 뽑힌 번호를 모든 경우의 수로 값이 같은지 비교
	//		같은 경우에는 카운트를 올리기
	// 결과 출력
	// 실행
	
	
	public static void start() {
		System.out.println("\t 인생을 바꿀 기회를 잡으시겠습니까?");
		System.out.println("\t잡길 원한다면 번호를 6개 입력해주세요.");
		
	}
	public static int[] pic() {
		int[] b = new int [6];
		Scanner k = new Scanner(System.in);
		a : for (int i = 0; i < b.length; i++) {
			System.out.printf("\t %d번째 숫자를 넣어주세요.\n", i);
			b[i] = k.nextInt();
			if((shwndqhr(b) == 0)) {
				continue a;
			}
			
			break a;
		}
		return b;
	}
	public static void userPic(int[] b) {
		
		for (int i : b) {
			System.out.print(i+" ");
			
		}
	}
	public static void lotto() {
		Random r = new Random();
		int[] ai = new int [6];
		for (int i = 0; i < ai.length; i++) {
			ai[i] = r.nextInt(45)+1;
		}
		System.out.println("행운의 숫자는");
		for (int i : ai) {
			System.out.println(ai);
		}
		return;
	
}
	public static int shwndqhr(int[] ai) {
		Arrays.sort(ai);
		for (int j = 0; j < ai.length-1; j++) {
			if (ai[j] == ai[j+1]) {
			 return 0;
			
		}
			
	}
		return 1;
	}
//	private static void match(int[] b, int[] ai) {
//		for (int i : ai) {
//			for (int j : b) {
//				if (condition) {
//					
//				}
//			}
//		}
		 
		
//	}
	public static void main(String[] args) {
		
//		start();
//		
//		lotto(0, 0, 0, 0, 0, 0);
	}
}
