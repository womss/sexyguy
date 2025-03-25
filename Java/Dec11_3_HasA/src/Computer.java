
public class Computer {
	String cpu;
	int ram;
	int ssd;
	Company brand;
	
	public Computer() {
	}

//	public Computer(String cPU, int rAM, int sSD) {
//		super();
//		CPU = cPU;
//		RAM = rAM;
//		SSD = sSD;
//	}

	public Computer(String cpu, int ram, int ssd, Company brand) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.ssd = ssd;
		this.brand = brand;
	}
	
	public void printInfo() {
		System.out.printf("CPU는 : %s\n", cpu);
		System.out.printf("RAM은 : %dGB\n", ram);
		System.out.printf("SSD는 : %dGB\n", ssd);
//		System.out.println(brand.name); // .name 안햇음
//		System.out.println(brand.location); 
//		System.out.println(brand.human); 
		brand.printInfo(); // 위에는 이걸로 출력 가능
	}



}
