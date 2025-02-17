import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PMain1_1 {
	
	public static int[] getNum() {
		Scanner k = new Scanner(System.in);
		int[] num = new int [5];
		
		
		for (int i = 0; i < num.length; i++) {
			System.out.printf("%d번째 숫자 입력 : ",i + 1);
			num[i] = k.nextInt();
		}
		System.out.println();
		System.out.println("-------------------");
		return num;
	}
	// 정렬 전의 값을 출력
	public static void printNum(int[] num) {
		System.out.println("<< 입력한 값 >>");
		for (int i : num) {
			System.out.println(i + " ");
		}
		System.out.println();
		System.out.println("==========================");
		System.out.println("배열의 갯수 : "+ num. length );
		System.out.println();
	}
	
	// 정렬
	public static int[] getResult(int[] num) {
		int b = 0;
		for (int turn = 0; turn < num.length; turn++) {
			for (int i = 0; i < num.length-1; i++) {
				// num.length - 1
				//	: 다음 배열값이랑 비교하기 위해서
				//		+ 1을 사용했는데
				// length 길이 그대로 사용하면 에러가 발생함
				if (num[i] > num[i + 1]) {
					b = num[i];
					num[i] = num[i + 1];
					num[i + 1] = b;
				}
				System.out.print(num[i] + " ");
			}
			System.out.println(num[4]);
			System.out.println("정렬된 값 : " + b);
			b = 0; // 무조건 4턴을 다 보여주는데
					// 4턴 이전에 끝났을 때 정렬된 값 초기화
			System.out.println("-------------------");
		}
		return num;
	}
	
	// 정렬 후의 값을 출력
	public static void printResult(int[] result) {
		System.out.println("<< 정렬 후 값 >>");
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("----------------------");
	}
	public static void main(String[] args) {
		int[] num = getNum();
		printNum(num);
		int[] result = getResult(num);
		printResult(result);
		
		Arrays.sort(num);
		for (int i : num) {
			System.out.print(i + " ");
		}
	}
	// 사실상 크게 의미가 없음
	//	성능에서 효과가 없기 때문에(딸깍으로 가능하다/Arrays.sor)
	//	선택정렬, 삽입정렬, 퀵정렬, 합병정렬, ...			// 한번 살펴 보기
	//	코테용으로 사용만 
}
