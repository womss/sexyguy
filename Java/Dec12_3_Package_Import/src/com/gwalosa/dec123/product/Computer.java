package com.gwalosa.dec123.product;

public class Computer extends Product {
	String cpu;
	int ram;
	int ssd;
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}

	public Computer(String name, int price, String cpu, int ram, int ssd) {
		super(name, price);
		this.cpu = cpu;
		this.ram = ram;
		this.ssd = ssd;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(cpu);
		System.out.println(ram);
		System.out.println(ssd);
	
	}
}
