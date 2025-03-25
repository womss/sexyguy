import java.util.Scanner;

public class PMain1 {
	public static void main(String[] args) {
		// main 함수에								
		// 어떤 정수를 콘솔창에 입력						scanner
		//	그 정수의 약수를 구해서 출력해주는 프로그램			
		// 	음수값은 무시								
		//	ex) 12의 약수는 : 1, 2, 3, 4, 6, 12		
		//	계속 입력하면 약수를 계속 출력해서 보여주고			
		//		=> 콘솔창에 0을 입력하면 프로그램이 종료되게	break;
		//		(0 입력하기 전까지는 계속 반복)				
		//	배열 사용 x								
		
		 Scanner k = new Scanner(System.in);
		 
		 int n = 1;
		 
		while (n!= 0) {
			 System.out.println("정수 입력 : ");
			  n = k.nextInt();
			for(int i = 1; i <= n; i++) { // ㅁ니ㅏㄴ인밀라ㅣ링라
			if (n % i  == 0) {
				if (i==n) {
					System.out.print(n);
					System.out.println();
					continue;
				}
				System.out.print(i+",");
			}
				
			}
			
		}	
	}
}
			
		
		 
		 
		 
		 
		 
		 
	

















