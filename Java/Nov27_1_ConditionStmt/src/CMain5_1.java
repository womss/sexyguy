import java.util.Scanner;

public class CMain5_1 {

	private static void startBMI() {
		System.out.println("====================");
		System.out.println("\t BMI 검사를 시작합니다");
		System.out.println("====================");
	}
	
	// 이름을 입력하는 함수
	private static String getName() {
		Scanner k = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = k.next();
		return name;
	}
	
	// 키를 입력하는 함수
	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("키 : ");
		double height = k.nextDouble();
		return height / 100; // m단위로 변환해서 return
	}
	// 몸무게를 입력하는 함수
	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("몸무게 : ");
		double height = k.nextDouble();
		return height;
	}
	
	// BMI 수치를 계산해주는 함수
	public static double calcBMI(double height, double weight) {
		double bmi = weight / (height * height);
		return bmi;
	}
	// 결과를 판정해주는 함수
	private static String judgeBMI(double bmi) {
		if (bmi >= 40) {
			return "고도비만";
		} else if (bmi >= 35) {
			return "중증도비만";
		}else if (bmi >= 30) {
			return "경도비만";
		}else if (bmi >= 25) {
			return "과체중";
		}else if (bmi >= 18.5) {
			return "정상";
		}else {
			return "저체중";
			}
	}
	// 결과를 출력해주는 함수 + 각 결과에 따른 코멘트 작성
	public static void printResult(String n, double h, double w, double b, String r) {
		System.out.println("=====================");
		System.out.printf("%s 님의 키는 %.1fcm, " + "몸무게는 %.1fkg이고..\n", n, h * 100, w);
		System.out.printf("체질량지수(BMI) : %.1f입니다.\n", b);
		
		try {
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.println(".");
			Thread.sleep(1000);
			System.out.println("곧 결과가 나옵니다");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("=============================");
		System.out.printf("\t%s님은 %s입니다 \n",n,r);
		
		switch (r) {
		case "저체중":
			System.out.println("\t하루에 5끼 챙겨드세요");
			break;
		case "정상":
			System.out.println("\t드시던 대로 드시면 됩니다.");
			break;
		case "과체중":
			System.out.println("\t먹는 양을 즐여야 함");
			break;
		case "경도비만":
			System.out.println("\t하루에 2끼만 드세요");
			break;
		case "중증도비만":
			System.out.println("\t하루에 1끼만 드세요");
			break;
		case "고도비만":
			System.out.println("\t죽는게 몸에 이롭다");
			break;
		//디폴트는 굳이 안넣어도 됨
		}
		System.out.println("=============================");
		
	}
	
	// Y를 입력했을 때 프로그램을 종료해주는 함수
	public static void exit() {
		Scanner k = new Scanner(System.in);
		System.out.print("종료하시겠습니까?(y/n ? : ");
		String answer = k.next();
		if (answer.equals("Y") || answer.equals("y")) {
			System.out.println("프로그램을 종료합니다");
			System.out.println("===========================");
	} else {
		System.out.println("무조건 종료 해야하는데요....?");
		exit();
		
	}
}
	// 기능들을 다 모아놓은 함수
	public static void activate() {
		startBMI();
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		double bmi = calcBMI(height, weight);
		String result = judgeBMI(bmi);
		printResult(name, height, weight, bmi, result);
		exit();
	}	
	
	public static void main(String[] args) {
	activate();
}
}
