import java.util.Scanner;

public class KIMain2 {
	public static void main(String[] args) {
		// 국어, 수학, 영어 점수를 입력 받아서
		// 각 점수들과 총점, 평균점수 까지 출력
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		double rnr = k.nextDouble();
		System.out.print("수학점수 : ");
		double tn = k.nextDouble();
		System.out.print("영어점수 : ");
		double dud = k.nextDouble();
		//System.out.print("총점 : ");
		//double chd = k.nextDouble();
		System.out.println("---------------------------------");
		
		System.out.printf("국어점수 : %.1f점\n", rnr);
		System.out.printf("수학점수 : %.1f점\n", tn);
		System.out.printf("영어점수 : %.1f점\n", dud);
		System.out.printf("총점 : %.1f점\n", rnr+tn+dud);
		System.out.printf("평균 : %.1f점\n", (rnr+tn+dud)/3);
		
		// int / int = int
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
