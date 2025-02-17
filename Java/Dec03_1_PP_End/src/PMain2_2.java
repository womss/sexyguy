import java.util.Random;

public class PMain2_2 {
	public static void main(String[] args) {
		// 10개의 정수를 랜덤으로 뽑아서 (1~100)					Random
		// 배열에 담고 => 출력
		int[]num = new int[10];
		Random r = new Random();
		for (int i = 0; i < num.length; i++) {
			num[i] = r.nextInt(100)+1;
		}
		
		for (int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("----------------------------");
		
		// 배열(Random으로 받아온)의 최대값, 최소값 => 출력	
		
		int min = num[0];	// 배열의 0번째 숫자가 최소값이라고 가정
		int max = num[0];	// 배열의 0번째 숫자가 최대값이라고 가정
		
		for (int i = 0; i < num.length; i++) {
			if (min > num[i]) { // min의 숫자보다 num[i]의 숫자가 더 작다면,
				min = num[i];	// num[i]의 숫자값을 min에 옮겨담기
			}else if (max < num[i]) {	// max의 숫자보다 num[i]의 숫자가 더 크다면
				max = num[i];			// num[i]ㅇ,; 숫자값을 max에 옯겨담기
				
			}
		}
		System.out.println(min);
		System.out.println(max);
		
	}
	
}
