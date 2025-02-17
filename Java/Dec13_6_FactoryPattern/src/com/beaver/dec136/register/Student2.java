package com.beaver.dec136.register;

public class Student2 {
	private String name;
	private int age;
	private int count;
	
	public Student2() {
		// TODO Auto-generated constructor stub
	}

	public Student2(String name, int age, int count) {
		super();
		this.name = name;
		this.age = age;
		this.count = count;
	}

	public void printInfo() {
		System.out.printf("이름 : %s\n", name);
		System.out.printf("나이 : %d\n", age);
		System.out.printf("%d번째 학생\n", count);
	}
	
}
