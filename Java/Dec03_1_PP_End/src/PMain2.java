import java.util.Random;

public class PMain2 {
	
	public static void name() {
		
	}
	public static void main(String[] args) {
		// 10개의 정수를 랜덤으로 뽑아서 (1~100)					Random
		// 배열에 담고 => 출력
		
		// 배열(Random으로 받아온)의 최대값, 최소값 => 출력			
		Random r = new Random();							//랜덤기능 만들고
		int[] box= new int [10];							//배열 만들어서 10칸 할당
		int t = 0;											//랜덤값 넣기위한 선언
		for (int i = 0; i < box.length; i++) {				//10번
			System.out.printf("%d번 번호 뽑기 : ", i+1);		//번호를 랜덤하게 뽑겠다
			t = r.nextInt(100)+1;							//뽑은 10개의 랜덤값을 
			box[i] = t;										//배열box에 담고
			System.out.println(box[i]);
															//배열을 매번 출력 //for문안에 있는값을 한번에 출력하는걸 잘 못함
		}
//		for (int i = 0; i < box.length; i++) {				// 이중포문 연습해야함
//			System.out.print(box[i] + " ");
//		}
		for (int n : box) {
			System.out.print(n + " ");
		}
		for (int i = 0; i < box.length; i++) {
			
		}
	}
}
