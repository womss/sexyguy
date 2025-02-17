
public class P_6000 {
	String name;
	int size;
	int Price;
	static final String BRAND = "NIKE";
	
	public void printP_6000() {
		System.out.printf("신발 모델명 : %s\n", name);
		System.out.printf("신발 사이즈 : %,dmm\n", size);
		System.out.printf("신발 가격 : %,d원\n", Price);
		System.out.printf("신발 브랜드 : %s\n", BRAND);
		System.out.println("----------------------------");
	}
}
