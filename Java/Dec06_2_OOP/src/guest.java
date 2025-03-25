import java.util.Scanner;

public class guest {
	String name;
	int age;
	
	
	public void gu1() {
		System.out.println("안녕하세요 의사 선생님");
		
	}
	public void gu2() {
		System.out.println("체중이 많이 나가는것 같아서요");
		
	}
	public double gu3() {
		Scanner k = new Scanner(System.in);
		System.out.printf("키는 ");
		double hei = k.nextDouble();
		System.out.printf("%.1fcm 이고\n", hei);
		return hei;
	}
	public double gu3_1() {
		Scanner k = new Scanner(System.in);
		System.out.printf("몸무게는 ");
		double wei = k.nextDouble();
		System.out.printf("%.1fkg 입니다\n", wei);
		return wei;
		
	}
	public String gu4() {
		System.out.println("좋은건가요 ? 나쁜건가요?");
		return name;
	}
	public void printCo() {
		Scanner k = new Scanner(System.in);
		System.out.println(" << 손님 >> ");
		System.out.println(name);
		System.out.println(age);
		System.out.println("================");
		
		
	}
	
	
	// 키에 대해 대답
	
	// 몸무게에 대해 대답
	
}
