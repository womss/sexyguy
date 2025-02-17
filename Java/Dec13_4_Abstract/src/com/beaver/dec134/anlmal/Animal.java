package com.beaver.dec134.anlmal;

// 추상클래스 : 
//		사용할 클래스들의 공통적인 속성, 기능들을 추출해서
//		어느정도 규격을 잡아놓은 추상적인 클래스

// abstract가 있으면 추상 클래스 (공통분모)
public abstract class Animal {
	private String sort;
	private int age;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String sort, int age) {
		super();
		this.sort = sort;
		this.age = age;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void printInfo() {
		System.out.printf("동물의 종류는 : %s\n", sort);
		System.out.printf("동물의 나이는 : %d\n", age);
	}
	
	// abstract 메소드 : 미완성된 메소드(내용이 없는)
	// 하위클래스에서 반드시!!! 오버라이딩 해야 !!!
	
	// abstract 메소드가 하나라도 있으면
	// abstract 클래스 or interface 여야 함! // abstract 메소드를 만들고 클래스에 abstract가 없으면 오류 클래스명과 메소드명에 공존해야함
	public abstract void roar();
		
	
}
