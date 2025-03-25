import java.util.Scanner;

public class CMain3_3 {
	// 조건문 : if, switch
			// switch-case ('sw' + 자동완성)
			//	: (ex : 권한 설정) // if문으로도 가능하긴한데 switch가 조금 더 직관적인 경우가 있다
			
			// 비교 조건이 특정한 값이나 문자열인 경우
			//	case 안에 있는 코드를 실행하고
			//	break; 를 이용해서 각 조건이 만족하면
			//	switch문이 깨지도록
			
			// 딱 떨어지는값에 대한 식
//			switch (변수 or 식) {
//			case 값 A:
//				변수 or 식의 값이 A일때 이 부분이 실행
//				break;
//			case 값 B:
//				변수 or 식의 값이 A일때 이 부분이 실행
//			case 값 C:
//				변수 or 식의 값이 A일때 이 부분이 실행
//				break;
//			default:
//				A / B / C 값도 아닐때 이 부분이 실행
//				break;
//			}
			
			// x가 1일때 "ㅋ" 출력 / 2일때 "ㅎ" 출력
			//	3일때 "ㅠㅠ" 출력 /
			// 위에 세 조건이 아니면 "졸려..." 출력
	
	public static int num() {
		Scanner k = new Scanner(System.in);
		System.out.println("1~3 입력 : ");
		int n = k.nextInt();
		return n;
	
}
	
	public static void match(int n) {
		switch (n) {
		case 1:
			System.out.println("ㅋ");
			break;
		case 2:
			System.out.println("ㅎ");
			break;
		case 3:
			System.out.println("ㅠㅠ");
			break;
		default:
			System.out.println("졸려");
			break;
		}
		
	}
	
	
	public static void main(String[] args) {
		int n = num();
		match(n);
	}
	
	
	
	
}
