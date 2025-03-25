
// Up & Down 게임 (main함수에)
// 1~100 사이의 정수
// 컴퓨터 vs 유저 => 같은 숫자를 입력하면 종료		//if? 삼항?
//		정답(정수)와 입력한 값보다 낮으면 DOWN!	// if로 하고 다시 입력 시키게?
//		정답이 입력한 값보다 높으면 UP
//		몇번만에 정답을 맞췄는지 출력			// 재귀?
//	반복문(for), 조건문(if)

import java.util.Random;
import java.util.Scanner;

public class Rmain3 {
	
	public static int bat() {
		Scanner k = new Scanner(System.in);
		System.out.println("숫자 배팅 : ");
		int bat = k.nextInt();
		return bat;
	}
	
	public static int aiNumber () {
		Random r = new Random();
		int rull = r.nextInt(100)+1;
		return rull;
	}
	public static void match(int b, int r) {
		if (b==r) {
			System.out.println("정답입니다");
		}else if (b>r) {
			System.out.println("DOWN");
		}else {
			System.out.println("UP");
		}return;
		
			
		
	}
	
	public static void main(String[] args) {
		int b = bat();
		int r = aiNumber();
		match(b,r);
	}
}
