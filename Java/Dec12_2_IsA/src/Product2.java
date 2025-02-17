
public class Product2 {
	String name;
	int price;
	
	public Product2() {
		System.out.println("Product !");
	}

	public Product2(String name, int price) { // 얘다
		super();
		this.name = name;
		this.price = price;
		System.out.println("Product !");
	}
	public void printInfo() {
		System.out.printf("상품 : %s\n", name);
		System.out.printf("가격 : %,d\n", price);
		
	}
	
}
