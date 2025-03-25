import java.util.Random;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class OMain3 {
	// 홀짝 게임 만들기
	//	동전 10개를 쥐고 있다가 짤짤이 후
	// 내가 '홀'이라고 하면 정답인지 아닌지를 판정해서 그 결과를 출력해주는 프로그램
	//1개는 있는걸로
	
	
	
	
	
	
	public static void main(String[] args) {
//		Random r = new Random();
//		int i = r.nextInt();		// int범위 안에 있는 랜덤한 숫자
//		int i2 = r.nextInt(5);		// 0 ~ 4 중 랜덤한 숫자(정수) (임의로 지정한 범위에서
//		int i3 = r.nextInt(5)+1;	// 1 ~ 5 중 랜덤한 숫자(정수 
//		System.out.println(i);
//		System.out.println(i2);
//		System.out.println(i3);
		
		//String ma = (what.equals("홀")) ? "배팅성공" : "배팅실패";
		
		Random r = new Random ();
		Scanner k = new Scanner(System.in);
		
		// 강사님
		// 지정한 갯수 중에서 랜덤한 동전 갯수를 뽑기
		//int coin = r.nextInt(10)+1;						//1
		// 동전 갯수가 홀수면 '홀', 짝수면 '짝'
		//String answer = (coin % 2 == 1) ? "홀" : "짝";		//2
		// 답을 맞출 수 있게 입력
		// 위 스캐너
		//System.out.print("홀 or 짝 : "
		//String userAns = k.next();
		
		// 결과를 맞춰봐야
		//	(컴퓨터가 뽑은 정답과 유저가 입력한 정답이 같은지)
		//String result = (answer.equals(userAns)) ? "정답" : "땡";
		//System.out.printf("뽑은 동전은 %d개 이므로, %s!\n", coin, result);
		
		
		
		System.out.print("홀 짝을 고르시오 : ");
		String bat = k.next();
		//슬립
		int i = r.nextInt(10)+1;							//1
		System.out.println(i);
		String what = (i % 2 == 1) ? "홀" : "짝";				//2
		System.out.printf("코인 개수 = %s\n", what);
		String goal = (bat.equals(what)) ? "축하합니다 배팅에 성공 하셨습니다" : "배팅에 실패 하셨습니다";
		
		System.out.println("_____________");
		System.out.printf("ㅣ%sㅣ", goal);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
