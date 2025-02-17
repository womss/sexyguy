package com.beaver.dec161.planet;

import com.beaver.dec161.human.Human;

public class Planet {
	String name;
	int size;
	boolean visible;
	
	
	public Planet() {
		// TODO Auto-generated constructor stub
	}

	public Planet(String name) {
		super();
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int i) {
		this.size = i;
	}

	public boolean isVision() {
		return visible;
	}

	public void setVision(boolean vision) {
		this.visible = vision;
	}

	public void printInfo() {
		System.out.printf("행성이름 : %s\n", name);
//		System.out.printf("행성크기 : %s\n", size);
//		System.out.printf("보이나? : %s\n", visible);
		
	}
	public void add(Human h1) {
		System.out.printf("%s에 %s 이/가 입주 !\n", name, h1.getName()); // 얘는 왜 그냥 네임이 아니라 겟네임으로?
	}
	public void add1(Human h1) {
		System.out.println("help");
	}
	
}
