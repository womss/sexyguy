package com.beaver.dec136.register;

public class Student {
	private int age;
	private String name;
	private int num;
//	private boolean num;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(int num, String name, int age) {
	super();
	this.num = num;
	this.name = name;
	this.age = age;
}

	public void printInfo() {
	System.out.println(name);
	System.out.println(num);
	System.out.println(age);
}


	
}
