import java.util.Iterator;
import java.util.Scanner;

public class RMain1 {
	public static void main(String[] args) {
		// for, while, do-while
		// 반복문 10번 => 반복문 1번 돌때마다
		//	안녕하세요 x 3번씩 출력
		// => 갑자기 숫자 1이 맘에 안들어서
		for (int i = 1; i <=10; i++) {
			if (i==1) {
				continue;
			}
			System.out.printf("========%d번째=========\n", i);
			for (int j = 1; j <=3; j++) {
				
				System.out.println("안녕하세요");
//			}System.out.printf("========%d번째=========\n", i);
		}
		System.out.println("===========================");
		 
		
		
	}
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println("와");
			}else {
				// continue;	// 강제 턴 종료
								// 홀수일때는 무시하고, 다음으로 넘어감
				break;		// (공식적) 반복문 끝
				// return;		// (비공식적 - 잘 활용하진 않는다), 함수가 끝
								// => 어쨋든간에 반복문이 깨짐
				
			}
		}
		System.out.println("------------------------------");
		// 코멘트를 입력받을건데, scanner
		//	내용은 계속 받아올 것 + 출력 / for + print
		// 내용이 "ㅎㅇ"면 반복문 끝 / if + break
		
		Scanner k = new Scanner(System.in);
		
		for (int i = 0; true; i++) {
			System.out.println("코멘트 입력 : ");
			String get = k.next();
			if (get.equals("ㅎㅇ")) {
				break;
			}else {
				System.out.println("다시 입력하세요");
			}
		}System.out.println("코멘트를 종료합니다");
		
		
		
}
}














