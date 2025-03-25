package com.beaver.dec133.human;

// 캡슐화 (Encapsulation)
//		멤버변수에 접근할 수 있는 '통로'를 만들고
//		그 통로에 안전장치를 하는 개념
//		즉!! 외부에 노출할 필요가 없는 정보들을
//		캡슐처럼 감싸서 '은닉' 하는 기능

//	멤버변수를 외부에서 직접 건드릴수 없도록 'private'를 걸어놓을 것
public class Human {
	private String name; // 변수들의 외부 노출을 막기 위함
	private int age;
	private double weight;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {			//		┐
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
//													캡슐
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) {
			age *= -1;
		}
		this.age = age;
	}									//		┘
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
	}
	
}

