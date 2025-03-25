
public class coffee {
	String name;
	int price;
	
	// Ctrl + Space
	public coffee() {
		// 객체의 값을 초기화하는데 목적
	}
	
	// Ctrl + Sift + Space
	public coffee(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
	}




	// 내가
//	public void printCo() {
//		System.out.printf("커피 이름 : %s / 가격 : %,d", name, price);
//	}
}
