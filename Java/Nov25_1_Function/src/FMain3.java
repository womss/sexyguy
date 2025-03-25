import java.util.Scanner;

public class FMain3 {

	// 비만도 검사 프로그램 (함수.ver)
	
	// 키(cm), 몸무게는(kg)는 입력받을 것
	// 표준체중 = (키 - 100) * 0.9
	// 비만도 = (실제체중 / 표준체중) * 100
	// 비만도가 120이 넘으면 '비만, 아니면 '안비만'
	//	을 판정한 후 전체 결과를 출력
	//		ㄴ 이거를 함수로
	
	//함수 : main함수에서 java를 모르는 사람이
	//		봐도 뭘 한건지 알아볼 수 있게 + 간결하게
	
	// 기능을 잘 분류해서 함수로 표현을 해줘야함
	//		=> 유지보수 편해진다★★★
	
	// 만약에... 표준체중을 구하는 공식이 0.9 => 0.8로 바뀜
	// 다양한 기능을 함수 하나에 구현하고(예를들어 메인에 다 때려놓고),
	// 변경사항을 수정하게 됐을 때
	// 한번에 잘 찾을 수 있을까?
	// 어떤 기능(함수)를 만들까 설계해본 후 코드 짤 것
	
	// ctrl + shift + /(numpad) : 함수 닫기
	// ctrl + shift + *(numpad) : 함수 열기
	
	// 메모리를 아낄것인가? vs 가독성을 좋게 할 것인가	
	
	//강사님
	// 비만도 검사 시작 내용을 출력하는 함수
	public static void startFat() {
		System.out.println("비만도 검사 시작");
		
	}
	// 키를 입력받는 함수
	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("키 : ");
		double height = k.nextDouble();
		return height;
		
		
	}
	
	
	// 몸무게를 입력받는 함수
	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("몸무게 : ");
		double weight = k.nextDouble();
		return weight;
		
		
	}
	// 키를 넣으면 표준 체중을 구해주는 함수
	public static double calStdWeight(double height) {
		double stdWeight = (height - 100) * 0.9;
		return stdWeight;
		
	}
	// 실제 체중과 표준체중을 넣으면
	//	비만도를 계산해서 값을 구해주는 함수
	public static double fat(double weight, double stdWeight) {
		double howfat = (weight / stdWeight) * 100;
		return howfat;
	}
	
	// 비만도를 가지고 '비만 / '안비만' 판정해주는 함수
	public static String judge(double fat) {
		String result = (fat > 120) ? "비만": "안비만";
		return result;
		
	}
	// 결과를 풀력해주는 함수
	public static void printResult(double h, double w, double std, double b, String r) {
		System.out.println("=====================");
		System.out.printf("키 : %.1fcm\n", h);
		System.out.printf("몸무게 : %.1fkg\n", w);
		System.out.printf("표준체중 : %.1fkg\n", std);
		System.out.printf("비만도 : %.1f\n", b);
		System.out.printf("당신은 : [%.s]입니다\n", r);
		System.out.println("=====================");
		
	}
	
	//함수들을 다 모아둔 함수 (start();) - 나는 메인에 height();로 시작했음
	public static void start() {
		startFat();
		double height = getHeight();
		double weight = getWeight();
		double stdWeight = calStdWeight(height);
		double bimando = fat(weight, stdWeight);
		String result = judge(bimando);
		printResult(height, weight, stdWeight, bimando, result);
		
	}
	public static void main(String[] args) {
		start();
	}
	
	
//	static Scanner k = new Scanner(System.in);
//	
//	
//	public static void height (double ss) {
//		//System.out.println("_________________________");
//		System.out.printf("키는 %.1fcm입니다.\n"),ss;
//		
		
//		System.out.printf("사용자의 키는 %.1fcm이고,\n몸무게는 %.1fkg 입니다.\n따라서"
//							+ "\n사용자의 표준 체중은 %.1fkg이고,\n비만도는 %.1f입니다\n", a, b, ever, fat);
//		String result = (fat>120 ? "비만입니다" : "비만이 아닙니다");
//		System.out.println(" ________________________");
//		System.out.printf("ㅣ   사용자는 %s    ㅣ\n", result);
//		System.out.println("ㅣ________________________ㅣ");
		
	
//	public static void weight() {
//		System.out.print("몸무게를 입력해 주세요 : ");
//		double kg = k.nextDouble();
//	}
//	
//	
//	
//	public static void main(String[] args) {
//		height();
//		System.out.print("키를 입력해 주세요 : ");
//		double cm = k.nextDouble();
//		double ss = cm;
//		System.out.print("몸무게를 입력해 주세요 : ");
//		double kg = k.nextDouble();
//		double ever = (cm - 100) * 0.9;
//		double fat = (kg/ever) * 100;
//		System.out.printf("");
		
//		double a =178.2;
//		
//		height(a);
//		double ever =height(a); 
//		double b =70.2;
//		weight(b);
	}
	
	

