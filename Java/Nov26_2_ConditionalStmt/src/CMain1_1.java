import java.util.Scanner;

public class CMain1_1 {
	
	// 국어 점수가...
			// 60점 미만이면 '가'
			// 60점 이상이면 '양'
			// 70점 이상이면 '미'
			// 80점 이상이면 '우'
			// 90점 이상이면 '수' 출력
	
	public static int kor() {
		Scanner k = new Scanner(System.in);
		System.out.println("국어 점수 : ");
		int kor = k.nextInt();
		return kor;
	}
	
	public static void match(int kor) {
		if (kor>=90) {
			System.out.println("수");
		}
		else if (kor>=80) {
			System.out.println("우");
		}
		else if (kor>=70) {
			System.out.println("미");
		}
		else if (kor>=60) {
			System.out.println("양");
		}
		else //(kor<60)
			{
			System.out.println("가");
		}
	}
	public static int numnum() {
		Scanner k = new Scanner(System.in);
		System.out.println("수학 점수 입력 : ");
		int n = k.nextInt();
		return n;
	}
	
	public static void nummatch(int num) {
		if (num >50) {
			System.out.println("반타작 이상");
		}
		else {
			System.out.println("반타작 이하");
			
		}
		
	
	}
	
	
	public static void main(String[] args) {
		int kor = kor();
		match(kor);
		int num = numnum();
		nummatch(num);
	}
}
