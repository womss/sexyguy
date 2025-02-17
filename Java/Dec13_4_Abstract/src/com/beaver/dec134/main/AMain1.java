package com.beaver.dec134.main;
import com.beaver.dec134.anlmal.Animal;
import com.beaver.dec134.anlmal.Bird;

public class AMain1 {
	public static void main(String[] args) {
		// 동물 Class
		// 종, 나이
		// 정보를 출력하는 기능
		
		// 공통의 속성이나 기능을 묶어서 이름을 붙이는 것
		//		: 추상화 (Abstraction)
		Bird b = new Bird("새", 93, 3);
		b.printInfo();
		b.roar();
		b.bite();
		
//		Animal a = new Animal();
//		a.setSort("기린");
//		a.setAge(12);
//		a.printInfo();
	}
}
