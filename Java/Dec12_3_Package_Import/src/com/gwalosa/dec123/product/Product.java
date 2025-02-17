package com.gwalosa.dec123.product;

public class Product {
	String name;
	int price;
	
	
	public Product() {
	}


	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
	}
}
