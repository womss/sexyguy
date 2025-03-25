package com.beaver.dec132.main;

import com.beaver.dec132.dog.Dog;

public class AMain1 extends Dog {
	public static void main(String[] args) {
	Dog dog = new Dog();
	dog.a = 1;
	dog.b = 2; // Dog는 상위 클래스
	dog.c = 3;
	dog.d = 4;
	
	AMain1 amin = new AMain1();
	amin.a = 1;		// 'a' 는 public, 접근 가능
	amin.b = 2;		// 'b' 는 protected, 접근 가능
					// AMain1이 Dog의 하위 클래스이고,
					// AMain1dml 객체를 톨해 protected 멤버변수에 접근
	amin.c = 3;		// 'c' 는 default, 접근 불가능
					// 같은 패키지만 가능 여긴 다른 패키지에 있어서 안됨
	amin.d = 4;		// 'd' 는 private, 접근 불가능
	
	// 결론 : private < default < protected < public
	
	
	
	
	}
}
