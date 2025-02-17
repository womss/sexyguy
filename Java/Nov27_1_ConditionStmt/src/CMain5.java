import java.util.Scanner;
import java.util.regex.Matcher;

public class CMain5 {
//	// BMI 검사 프로그램 (함수. ver)
//	
//	// 이름, 키(cm), 몸무게(kg) 입력
//	// BMI(체질량지수) : 몸무게 / (키 * 키) 키 : m단위
//					//k / (h*h)h
//	//	18.5미만이면 저체중
//	//	18.5이상이면 정상
//	//	25이상이면 과체중
//	//	30이상이면 경도비만
//	//	35이상이면 중증도비만
//	//	40이상이면 고도비만
//	//	결과에 따른 코멘트 출력 후
//	//	콘솔창에 Y를 입력하면 프로그램이 종료
//	
//	public static String getN() {
//		Scanner k = new Scanner(System.in);
//		System.out.println("이름 : ");
//		String name = k.next();
//		return name;
//	}
//	
//	public static double getH() {
//		Scanner k = new Scanner(System.in);
//		System.out.println("키 : ");
//		double height = k.nextDouble();
//		return height;
//	}
//	
//	public static double getK() {
//		Scanner k = new Scanner(System.in);
//		System.out.println("몸무게 : ");
//		double kg = k.nextDouble();
//		return kg;
//	}
//	
//	public static double BMI(double h, double k) {
//		h = h/100;
//		double nm = (k / (h*h));
////		System.out.printf(" BMI : %.1f\n", nm);
//		
//		return nm;
//		
//	}
//	public static String match(double b,String n) {
//		String bmd = "";
//		if (b >= 40) {
//			bmd = "고도비만";
//			//System.out.printf("BMI가 %.1f라서\n%s님은 %s입니다\n", b, bmd, n);
//		}else if (b >= 35) {
//			bmd = "중증도비만";
//			//System.out.printf("BMI가 %.1f라서\n%s님은 %s입니다\n", b, bmd, n);
//		}else if (b >= 30) {
//			bmd = "경도비만";
//			//System.out.printf("BMI가 %.1f라서\n%s님은 %s입니다\n", b, bmd, n);
//		}else if (b >= 25) {
//			bmd = "경도비만";
//		}else if (b >= 18.5) {
//			bmd = "정상";
//		}else {
//			bmd = "저체중";
//		}
//		return bmd;
//	}
//	public static String end() throws InterruptedException {
//		Scanner k = new Scanner(System.in);
//		System.out.println("종료하시려면 y 키를 입력해주세요");
//		String end = k.next();
//		String endd = (end.equals("y") ? end : end());
//		Thread.sleep(0);
//		System.out.println("시스템을 종료합니다.");
//		return endd;
//	}
//	
//	public static void full() throws InterruptedException {
//		String n = getN();
//		double h = getH();
//		double k = getK();
//		double b = BMI(h,k);
//		String m  = match(b,n);
//		
////		System.out.printf(" BMI : %.1f\n", b);
//		System.out.printf(" 사용자의 정보\n이름 : %s\n키 : %.1fcm\n몸무게 : %.1f이고\n"
//						+ "BMI 는 [%.1f]\n", n, h, k, b);
//		System.out.printf("따라서 %s님은 [%s]입니다\n", n, m);
//		
//		System.out.println(end());
//	}
//	
//	public static void main(String[] args) throws InterruptedException {
////		String n = getN();
////		double h = getH();
////		double k = getK();
////		double b = BMI(h,k);
////		String m  = match(b,n);
//////		System.out.printf(" BMI : %.1f\n", b);
////		System.out.printf(" 사용자의 정보\n이름 : %s\n키 : %.1fcm\n몸무게 : %.1f이고\n"
////						+ "BMI 는 [%.1f]\n", n, h, k, b);
////		System.out.printf("따라서 %s님은 [%s]입니다\n", n, m);
////		
////		System.out.println(end());
//		full();
//	}
	
	//프로그램 시작을 알리는 함수
	private static void name() {
		System.out.println("====================");
		System.out.println("====================");
		System.out.println("====================");
	}
	
	// 
}
