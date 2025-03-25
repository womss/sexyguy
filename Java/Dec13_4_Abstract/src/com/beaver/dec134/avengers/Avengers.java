package com.beaver.dec134.avengers;

public abstract class Avengers {
	private String name;
	private int age;
	
	
	public Avengers() {
		// TODO Auto-generated constructor stub
	}


	public Avengers(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	
	public void printInfo() {
		System.out.printf("어벤져스 멤버 : %s\n", name);
		System.out.printf("멤버 나이 : %d\n", age);
	}
	
	public abstract void attack();
	
	
	
}
