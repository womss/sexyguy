import java.util.Scanner;

public class guest2 {
	String name;
	int age;
	Scanner mouth = new Scanner(System.in);
	double height;
	double weight;
	double bmi;
	String bmiResult;
	
	
	public void printGeust2() {
		System.out.println(" < 손님 > ");
		System.out.println("name");
		System.out.println("age");
		System.out.println("====================");
	}
	
	public void enter() {
		System.out.println(name + " : 드루갑니다 ~ 안녕하세요 !");
	}
	
	// 키에 대해 대답
	public double answerHeight() {
		return mouth.nextDouble();
	}
	
	// 몸무게에 대해 대답
	public double answerWeight() {
		return mouth.nextDouble();
	}
	
	public void exit() {
		System.out.println("================");
		System.out.println(name + " : 힝구...");
		System.out.println("내가 " + bmiResult + "이라니...");
		System.out.println("퇴장...");
		System.out.println("================");
	}

}