import java.util.Scanner;

public class RMain1_1 {
	public static void main(String[] args) {
		
		// 코멘트를 입력받을건데, scanner
		//	내용은 계속 받아올 것 + 출력 / for + print
		// 내용이 "ㅎㅇ"면 반복문 끝 / if + break
		
		Scanner k = new Scanner(System.in);
		String cmt = null;
//		while (!cmt.equals(("ㅎㅇ")) {
//		}
		while (true) {
			System.out.println(" 내용 : ");
			cmt = k.next();
			System.out.println("------------");
			System.out.println(cmt);
			System.out.println("------------");
			if (cmt.equals("ㅎㅇ")) {
				System.out.println("반복문 끝");
				break;
			}
			
			
			
		}
		
		
		
		
		
		
	}
}
