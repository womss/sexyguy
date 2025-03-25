// 아무곳에서도 상속을 안받으면 extends Object
// Product is a Object(자바 객체)

public class Product /* extends Object가 생략되어있다 상속을 안받아서 */ {
	String name;
	int Price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		Price = price;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(Price);
	}
}
