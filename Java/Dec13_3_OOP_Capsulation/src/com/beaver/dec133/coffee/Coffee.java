package com.beaver.dec133.coffee;

public class Coffee {
	private String name;
	private int price;
	
public Coffee() {
	// TODO Auto-generated constructor stub
}


	public Coffee(String name, int price) {
	super();
	this.name = name;
	this.price = price;
}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public void printInfo() {
		if (name != null) {
			System.out.printf("커피 메뉴는 : %s\n", name);
			System.out.printf("커피 가격은 : %,d원\n", price);
			
		}
	}
}
