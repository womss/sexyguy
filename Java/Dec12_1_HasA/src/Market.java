
public class Market {
	String name;
	String location;
	Plate plate;
	
	public Market() {
	}

	
	public Market(String name, String location, Plate plate) {
		this.name = name;
		this.location = location;
		this.plate = plate;
	}


	public void printMarket() {
		System.out.printf("시장의 이름은 : %s, 위치는 : %s", name, location);
		plate.printPlate();
	}
}
