
public class FMain1 {
	// 정수 두개를 넣으면, 그 중에 큰 숫자를 출력해주는 함수
	public static int printBigger(int a, int b) {
		int bigNum = (a > b) ? a : b;
		System.out.println(bigNum);
		return bigNum;
	}

	// 실수 두개를 넣으면, 그 중에 큰 숫자를 구해주는 함수
	public static double getBigger(double a, double b) {
		double bigNum = (a > b) ? a : b;
		System.out.println(bigNum);
		return bigNum;

	}

//	public static void numBigger (int a, int b) {
//		System.out.println (a>b ? a : b);
//		
//	}
//	
//	public static void pnumBigger (double a, double b) {
//		System.out.println(a>b ? a : b);
//	}

	public static void main(String[] args) {
		// num(10,20);
		// pnum(2.2,4.4);
		printBigger(3, 6);
		double bigNum = getBigger(1.3, 4.5);


//		
//		System.out.print("정수 입력 : ");
//		int wjd = k.nextInt();
//		System.out.print("정수 입력 : ");
//		int wjd2 = k.nextInt();
//		
//		
//		System.out.print("실수 입력 : ");
//		double tlf = k.nextDouble();
//		System.out.print("실수 입력 : ");
//		double tlf2 = k.nextDouble();

		/////////////////////////

	}

}
