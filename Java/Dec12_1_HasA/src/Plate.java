
public class Plate {
	String name;
	int price;
	Food f2;
	
	public Plate() {
	}

	public Plate(String name, int price, Food f2) {
		this.name = name;
		this.price = price;
		this.f2 = f2;
	}

	
	public void printPlate() {
		System.out.printf("접시종류는 : %s/n 가격은 : %d", name, price);
		System.out.println("아래는 %s를 구매한 곳입니다");
		f2.printFood();
	}
}
