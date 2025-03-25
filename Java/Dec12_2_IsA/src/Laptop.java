
public class Laptop extends Computer  {
	double weight;
	int battery;
	
	public Laptop() {
	}

	public Laptop(String name, int price, String cpu, int ram, int hdd, double weight, int battery) {
		super(name, price, cpu, ram, hdd);
		this.weight = weight;
		this.battery = battery;
	}
	@Override
	public void printInfo() {
	super.printInfo();
	System.out.println(weight);
	System.out.println(battery);
}
	
	
//	public void printInfo() {
//		System.out.printf("노트북 이름은 : %s\n", name);
//		System.out.printf("노트북 가격은 : %,d\n", Price);
//		System.out.printf("노트북  cpu : %s\n", cpu);
//		System.out.printf("노트북  ram : %dGB\n", ram);
//		System.out.printf("노트북  hdd : %dGB\n", hdd);
//		System.out.printf("노트북 무게는 : %.1fkg\n", weight);
//		System.out.printf("노트북 베터리 지속 시간 : %dH\n", battery);
//	}
}
