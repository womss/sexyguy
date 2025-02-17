package com.beaver.dec136.register;

// 공장 역할을 할 클래스
public class Academy {
	private int studentCount; // 여기
	
	public Student consult(String name, int age) {
		studentCount++;
		Student s = new Student(studentCount, name, age);
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private String name;
//	private int age;
//	
//	public Academy() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Academy(String name, int age) {
//		super();
//		this.name = name;
//		this.age = age;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//	public void printInfo() {
//		System.out.println(name);
//		System.out.println(age);
//	}
}
