// 쇼핑몰 - '상품' 에 대한 정보를 게시하고 싶음
public class IMain2 {
	public static void main(String[] args) {
		// 신발 (이름, 가격, 사이즈)
		// 출력
		
		// 컴퓨터 (이름, 가격, cpu, ram, hdd)
		// 출력
		
		// 노트북 (이름, 가격, cpu, ram, hdd, 무게, 배터리 지속시간)
		// 출력
		
		Shoes s = new Shoes("반스", 54000, 285);
		s.printInfo();
//		s.printInfo();
		System.out.println("---------------");
		
		Computer c = new Computer("삼성컴퓨터", 3500000, "i7-3500", 64, 200);
		c.printInfo();
		System.out.println("---------------");
		
		Laptop l = new Laptop("Gram", 2300000, "i7-3500", 8, 100, 0.8, 13);
		l.printInfo();
		
		
	}
}
