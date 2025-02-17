
public class Food {
	String name;
	int Price;
	Store where;
	
	public Food() {
	}

	public Food(String name, int price, Store madeIn) {
		super();
		this.name = name;
		Price = price;
		this.where = madeIn;
	}
	
	public void printFood() {
		System.out.printf("메뉴 : %s\n가격 : %,d원\n", name, Price, where);
		if (name != null) {
			System.out.printf("아래는 해당 메뉴를 파는 식당의 정보입니다\n");
			where.printStore();
		}
	}
}
