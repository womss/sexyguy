// Candy has a Company : 제조사 (V) 주가 사탕이다
// Company has a Cany : 상품
public class Candy {
	String name;
	String favor;
	Company brand;
	
	public Candy() {
	}
	
	public Candy(String name, String favor) {
		super();
		this.name = name;
		this.favor = favor;
	}
	public void printInfo() {
		System.out.printf("사탕 이름 : %s\n", name);
		System.out.printf("사탕 맛 : %s\n", favor);
	}
	
	
	
}
