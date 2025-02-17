import java.util.Scanner;

public class KImain3 {
	public static void main(String[] args) {
		// 반지름을 입력받아서 원의 면적 계산하기
		//	1. 원의 반지름을 입력
		//	2. 원의 면적 계산
		
		// 가로, 세로 입력받아서 사각형의 면적 계산하기
		
		// 시간(초)을 입력받아서 분, 시간단위로 변환해서 출력
		
		
		Scanner k = new Scanner(System.in);
		
		
		
		//강사님
		System.out.print("원의 반지름 : ");
		int radius = k.nextInt();
		double area = 3.14 * radius * radius;
		double area2 = (Math.PI * Math.pow(radius, radius));
		System.out.printf("원의 면적(그냥) : %.2f\n", area);
		System.out.printf("원의 면적(Math) : %.2f\n", area2);
		
		System.out.print("가로 : ");
		double wid = k.nextDouble();
		System.out.print("세로 : ");
		double hei = k.nextDouble();
		System.out.printf("면적 : %.2f\n", wid * hei);
		
		System.out.print("초 : ");
		int sec = k.nextInt();
		double min = sec / 60.0;
		//int / int = int
		double h = min / 60;
		
		System.out.printf("[%d초]는 [%.4f]분이다\n", sec, min);
		System.out.printf("[%d초]는 [%.4f]시간이다\n", sec, h);
		
		
		
		
		
		//나
		
		//System.out.print("원의 반지름 : ");
		//double o = k.nextInt();
		//System.out.printf("원의 면적 : %.1f\n",o*o*Math.PI);
		
		
		//System.out.print("가로 : ");
		//double rk = k.nextDouble();
		//System.out.print("세로 : ");
		//double tp = k.nextDouble();
		//System.out.printf("사각형의 면적 : %.1f\n", rk* tp);
		
		//System.out.print("초 입력 : ");
		//double t = k.nextInt();
		//System.out.printf("%.2f분\n",t/60);
		//System.out.printf("%.1f시간\n", t / 3600);
		
		
		
	}
}
