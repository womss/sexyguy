// for (변수초기화; 조건식; 값의증감) {
//		(반복실행시킬)내용
// }

// 이중 for문 >> for문안에 for문 >> 중첩 for문

public class RMain1 {		//JVM이 main 함수를 불러와서 for문 시작
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			System.out.printf("i값 : %d--------\n", i);	// 1 2 3 4 5 = 5
			for (int j = 1; j < 6; j++) {				// i for문이 하나 증감이 이루어질때 j for문을 한 사이클 돌림
				System.out.printf("j값 : %d\n", j);		// 1 2 3 4 5 = 25
			}											// 1 2 3 4 5
		} // 여기서 j for문이 한사이클 끝나고 다시 i의 증감부분으로가서 조건을 맞추기 위해 다시 시작
		System.out.println("=========================");
		/// for문은 참에서 시작해서 거짓이 될때 끝나고
		/// 삼항연산자 + 재귀는 거짓에서 시작해서 참이 될때 끝남
		// 구구단
		// <2단>
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		// <9단>
		// ...
		// 9 x 9 = 81
		
		// 내가
//		int a2 = 2;
//		int a3 = 3;
//		int a4 = 4;
//		int a5 = 5;
//		int a6 = 6;
//		int a7 = 7;
//		int a8 = 8;
//		int a9 = 9;
//		for (int i = 1; i <10; i++) {
//			//for (int j = 2; j < 3; j++) {
//				System.out.printf("%d X %d = %d\t", a2, i, a2*i);
//				System.out.printf("%d X %d = %d\t", a3, i, a3*i);
//				System.out.printf("%d X %d = %d\t", a4, i, a4*i);
//				System.out.printf("%d X %d = %d\t", a5, i, a5*i);
//				System.out.printf("%d X %d = %d\t", a6, i, a6*i);
//				System.out.printf("%d X %d = %d\t", a7, i, a7*i);
//				System.out.printf("%d X %d = %d\t", a8, i, a8*i);
//				System.out.printf("%d X %d = %d\n", a9, i, a9*i);
//			}
		//강사님
//		for (int dan = 2; dan < 10; dan++) {
//			System.out.printf("[%d단]\n", dan);
//			for (int i = 1; i < 10; i++) {
//				System.out.printf("%d X %d = %d\n", dan, i, dan*i);
//			}
//		}
		System.out.println("==========================");
		// 가로배열 해보기
//		for (int dan = 2; dan < 10; dan++) {
//			System.out.printf("[%d단]", dan);
//			for (int i = 2; i < 10; i++) {
//				System.out.printf(" %d X %d = %d ", i,dan , dan*i);
				
//			}
//		}System.out.println("=================");
		//강사님
		for (int i = 2; i < 10; i++) {
			System.out.printf("<<<%d단>>>\t", i);
		}
		System.out.println();
		for (int i = 1; i < 10; i++) {
			for (int dan = 2; dan < 10; dan++) {
				System.out.printf("%d X %d = %d\t", dan, i, dan*i);
			}
			System.out.println(); //? 줄바꿈이 전체 for문 다 진행되고 하는게 아닌가 물어보기
		}
		
		
		
	}
			
	
}





















