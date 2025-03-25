
public class Car extends Vehicle{
	String brand;
	String type;
	
	public Car() {
	}

	public Car(String name, int speed, String brand, String type) {
		super(name, speed);
		this.brand = brand;
		this.type = type;
	}
	
	public int maxspeed() {
		return 200;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("브랜드 : %s\n", brand);
		System.out.printf("차 종 : %s\n", type);
	}
}
