package com.beaver.dec134.anlmal;

import com.beaver.dec134.bite.Bite;

// 클래스끼리는 다중상속 X (1대 1로만 상속 가능)
// 클래스(bird) + 인터페이스(bite)는 다중상속 가능

public class Bird extends Animal implements Bite/*, Fly, Eat, ...*/ { // 클래스도 상속 받고 인터페이스도 상속을 받음 ///클래스 하나랑 인터페이스로 계속??
	private int leg;
	
	
	public Bird() {
		// TODO Auto-generated constructor stub
	}


	public Bird(String sort, int age, int leg) {
		super(sort, age);
		this.leg = leg;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.printf("다리 개수는 : %d\n", leg);
	}
	@Override
	public void roar() {
		System.out.println("짹짹~ 외모 짹~");
	}
	
	@Override
	public void bite() {
		System.out.println("새는 부리로 찢어");
	}
	
	
	
	
	
	
	
}
