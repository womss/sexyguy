package com.beaver.jan221.main;
// 추가 데이터를 더 만들기 위해 클래스를 하나 더 만듬
public class Beaver {
	private String name;
	private int age;
	private double height;
	private double weight;
	
	public Beaver() {
		// TODO Auto-generated constructor stub
	}

	public Beaver(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
