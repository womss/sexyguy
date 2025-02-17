import java.util.Scanner;

public class CMain4_4 {
	
	// Scanner로 입력받을 것
	
			// "이병" 입력 => 눈치, 관등성명, 훈련, 잠
			// "일병" 입력 => 관등성명, 훈련, 잠
			// "상병" 입력 => 훈련, 잠
			// "병장" 입력 => 잠
	
	public static String grade() {
		Scanner k = new Scanner(System.in);
		System.out.println("계급 : ");
		String g = k.next();
		return g;
		
	}
	
	
	public static void match(String gg) {
		switch (gg) {
		case "이병":
			System.out.println("눈치");
		case "일병":
			System.out.println("관등성명");
		case "상병":
			System.out.println("훈련");
		case "병장":
			System.out.println("잠");
			break;

		default:
			System.out.println("민간인");
			break;
		}
		
	}
	public static void main(String[] args) {
		String g = grade();
		match(g);
		
	}
	
	
	
	
}
