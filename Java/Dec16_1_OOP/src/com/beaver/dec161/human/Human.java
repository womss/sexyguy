package com.beaver.dec161.human;

import com.beaver.dec161.avengers.Avengers;

public class Human {
	private String name;
	private Avengers hero;							// 아이언맨 객체 만들고 1
	public Human() {
		// TODO Auto-generated constructor stub
	}
	
	public Human(String name) {
		super();
		this.name = name;
		System.out.println("응애 나 애기" + name); // 이거 프린트 인포에 해도 되지 않나?
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printInfo() {
		System.out.printf("사람 이름 : %s\n", name);
	}
	
	public void pick(Avengers a) {				// 만들고 2
		hero = a;								// 만 3 이건 왜?
		System.out.println("두둥 등장");
	}
	
	public void helpAaaaaaa() {
		hero.attack();
	}
	
	
}
