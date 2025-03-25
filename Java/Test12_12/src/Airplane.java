
public class Airplane extends Vehicle {
	String airline;
	int capacity;
	
	public Airplane() {
	}

	public Airplane(String name, int speed, String airline, int capacity) {
		super(name, speed);
		this.airline = airline;
		this.capacity = capacity;
	}
	
	public int maxspeed() {
		return 900;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("항공사는 : %s\n", airline);
		System.out.printf("탑승 정원은 : %d명\n", capacity);
		
	}
	
}
