
public class RMain2 {
	public static void main(String[] args) {
		// 별찍기
		//	j
		// /	0	1	2	3	4			
		//i	0	ㅋ							i = 0	j=0
		// 	1	ㅋ	ㅋ						i = 1	j=0,1
		// 	2	ㅋ	ㅋ	ㅋ					i = 2	j=0,1,2
		// 	3	ㅋ	ㅋ	ㅋ	ㅋ				i = 3	j=0,1,2,3
		// 	4	ㅋ	ㅋ	ㅋ	ㅋ	ㅋ			i = 4	j=0,1,2,3,4
		
		// 내가
		for (int i = 0; i < 5; i++) {
			
		}
		for (int j = 0; j < 1; j++) {
			System.out.printf("ㅋ",j);
		}System.out.println();
		for (int j = 0; j < 2; j++) {
			System.out.printf("ㅋ",j);
		}System.out.println();
		for (int j = 0; j < 3; j++) {
			System.out.printf("ㅋ",j);
		}System.out.println();
		for (int j = 0; j < 4; j++) {
			System.out.printf("ㅋ",j);
		}System.out.println();
		for (int j = 0; j < 5; j++) {
			System.out.printf("ㅋ",j);
		}
		System.out.println();
		
		//강사님
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) { //j가 i보다 작거나 같아질때까지 반복
				System.out.print("ㅋ");
			}
			System.out.println();
		}
		
		//ㅋ
		// ㅋ
		//  ㅋ
		//   ㅋ
		//    ㅋ
		
		//내가
//		for (int i = 0; i < 5; i++) {			// i는 0부터 4까지 반복
//			for (int j = 1; j == i; j++) {		// j가 i랑 같아질때까지 반복 = 5번
//					System.out.print(".\n");
//					System.out.print("..");
//					
//				}
//				System.out.println("ㅋ\n");
//				
//			}
		
		//강사님
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				if (i==j){
					System.out.print("ㅋ");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		// 2번째 방법
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				// j가 i보다 작은 공간은
				// 띄어쓰기로 메꿔줌
				System.out.print(" ");
			}
			// 그 이외의 공간은 "ㅋ"로 메꿔줌
			System.out.println("ㅋ");
		}
		// 3번째 방법
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((i == j) ? "ㅋ" : " ");
				}
				
			}
			System.out.println("==============");
		
		//ㅋㅋㅋㅋㅋ
		//ㅎㅎㅎㅎ
		//ㅋㅋㅋ
		//ㅎㅎ
		//ㅋ
		// 내가
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print((i % 2 == 0) ? "ㅋ" : "ㅎ");
			}
			
		}	
		System.out.println("=======================");
		// 강사님
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print((i % 2 == 0) ? "ㅋ" : "ㅎ");
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (5-i); j++) {
				System.out.print((i % 2 == 0) ? "ㅋ" : "ㅎ");
			}
			System.out.println();
		}
		System.out.println("=================");
		
		// ㅋ
		// ㅎㅎㅎ
		// ㅋㅋㅋㅋㅋ
		// ㅎㅎㅎㅎㅎㅎㅎ
		// ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
		
		//내가
		for (int i = 1; i <= 5; i+=1) {
			for (int j = 1; j < (10); j+=2) {
				System.out.print((i % 2 == 0) ? "ㅋ" : "ㅎ");
			}
			System.out.println();
		}
		System.out.println("=====================");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= (i*2); j++) { // i의 2배 이하
				System.out.print((i % 2 == 0) ? "ㅋ" : "ㅎ");
			}
			System.out.println();
		}
		System.out.println("=========================");
		
		//     *
		//    ***
		//   *****
		//  *******
		// *********
		
		//내가
//		
//		for (int i = 1; i <= 5; i++) {
//			for (int j = 0; j <= i+4; j++) {
//				
//				System.out.println();
//			}
//		}
		//강사님
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (4-i); j++) { //왼쪽 공백 만들기
				System.out.print(" ");
				}
			for (int j = 0; j <= (i*2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("===========");
		
		for (int i = 0; i < 5; i++) {			//i와 j를 더한값이 4를 넘으면 별을 찍는다
			for (int j = 0; j < (i+5); j++) {
				System.out.print((i + j >= 4)? "*" : " ");
			}
			System.out.println();
		}
		System.out.println("====================");
		
		
		}
	
	
	
	
}

