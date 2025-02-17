
public class CMain2 {
	public static void main(String[] args) {
		// 커피
		// 커피 이름 / 가격
		// 아메리카노 / 3000
		// 출력
		
		coffee c1 = new coffee();
		c1.name = "아메리카노";
		c1.price = 3000;
		c1.printInfo();
		System.out.println("-------------");
		coffee c2 = new coffee("아메리카노", 3000);
		c2.printInfo();
		
		
		
		
		// 내가 
//		c1.name = "아메리카노";
//		c1.price = 5000;
//		c1.printCo();
	}
}
