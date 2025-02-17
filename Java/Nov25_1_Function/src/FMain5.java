import java.util.Random;
import java.util.Scanner;

public class FMain5 {

	// 동전 맞추기 게임
	// 10개
	
	// 동전 10개 섞기
	public static int shakeCoin() {
//		Random r= new Random();
//		int coin = r.nextInt(10)+1;
//		return coin;
		return new Random().nextInt(10)+1;
		
	}
	
	public static int askUserAns() {
		//Scanner k = new Scanner(System.in);
		//System.out.print("몇 개? : ");
		//int userAns = k.nextInt();
		//return userAns;
		return new Scanner(System.in).nextInt();
	}
	
	//답 맞춰보기
	public static String getResult(int coin, int userAns) {
		String result = (coin == userAns) ? "정답" : "땡";
		return result;
	}
	
	// 결과 출력
	public static void printResult(int coin, int userAns, String result) {
		System.out.printf("쥐고 있던 동전은 %d개 \n", coin);
		System.out.printf("당신의 답은 %d개 \n", userAns);
		System.out.printf("그래서 결과는...[%s]입니다 \n", result);
		
	}
	public static void main(String[] args) {
		int coin = shakeCoin();
		int userAns = askUserAns();
		String result = getResult(coin,userAns);
		
	}
		

	
	
	
}
	// 개수 몇개인지 입력
	// 컴퓨터 몇개인지 발표
	// 사용자랑답이랑 컴퓨터 답이랑 맞는지 비교
	// 결과 출력
	
	
	// 내가
//	public static int userAn() {		// 유저의 개수 예측
//		Scanner k = new Scanner(System.in);
//		System.out.print("동전 갯수는? (1~10개 사이) : ");
//		int useran = k.next();
//		return useran;
//		
//	}
//	
//	
//	public static int aiAn() {			// ai의 동전개수 발표
//		Random r = new Random();
//		int aicoin = r.nextInt(10)+1;
//		return aicoin;
//		
//	}
//	
//	public static String userAiAn(int ucoin, int aicoin) {		// 유저와 ai의 답이 맞는지
//		String userAiAn = (ucoin.equals(aicoin)) ? "정답" : "실패";
//		return userAiAn;
//	}
//	
//	public static void printResult(int ucoin, int aicoin, String result) {
//		System.err.println("===================");
//		System.out.printf("사용자 배팅 개수 : %s\n", ucoin);
//		System.out.printf("ai 짤짤이 결과 : %d\n", aicoin);
//		System.out.printf("배팅 결과 : %s\n", result);
//	}
//	
//	
//	public static void main(String[] args) {
//		int ucoin = userAn();
//		int aicoin = aiAn();
//		String result = userAiAn(ucoin, aicoin);
//		printResult(ucoin,aicoin,result);
//	}
//	
//	
//}
