
public class Computer extends Product {
	String cpu;
	int ram;
	int hdd;

	public Computer() {
	}

	
	public Computer(String name, int price, String cpu, int ram, int hdd) {
		super(name, price);
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(cpu);
		System.out.println(ram);
		System.out.println(hdd);
	}
	
	
	//	public void printInfo() {
//		System.out.printf("컴퓨터 이름은 : %s\n", name);
//		System.out.printf("컴퓨터 가격은 : %,d\n", Price);
//		System.out.printf("컴퓨터  cpu : %s\n", cpu);
//		System.out.printf("컴퓨터  ram : %dGB\n", ram);
//		System.out.printf("컴퓨터  hdd : %dGB\n", hdd);
//	}
}
