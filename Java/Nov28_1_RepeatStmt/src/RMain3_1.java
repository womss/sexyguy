import java.util.Random;
import java.util.Scanner;

public class RMain3_1 {
	public static void main(String[] args) {
	Random r = new Random();
	int num = r.nextInt(100)+1;
	Scanner k = new Scanner(System.in);
	
	int myNum = 0;
	for (int turn = 1; turn <= 100; turn++) {
		// 몇 번 반복할지 모르기 때문에 조건을 지정할 수 없음
		// 조건 지정 안해도 됨 turn을 지우고 ;;세미콜론 채우면(or true;) 무한 반복
		
		System.out.print("입력 : ");
		myNum = k.nextInt();
		
		if (num == myNum) {
			System.out.println("정답");
			System.out.printf("%d번만에 정답을 맞췄습니다.\n", turn);
			break;	// 반복문을 종료시킴
		}else if (num < myNum) {
			System.out.println("DOWN");
		}else {
			System.out.println("UP");
		}
		System.out.println("=============================");
		
	}
	
}
}
