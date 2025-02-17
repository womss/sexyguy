
public class Vehicle {
	String name;
	int speed;
	
	public Vehicle() {
	}

	public Vehicle(String name, int speed) {
		this.name = name;
		this.speed = speed;
	}
	
	public void printInfo() {
		
			System.out.printf("기종은 : %s\n", name);
			System.out.printf("현재 속도는 : %dkm/h\n", speed);
		
	}
}
