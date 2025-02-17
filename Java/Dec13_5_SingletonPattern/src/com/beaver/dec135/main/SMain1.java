package com.beaver.dec135.main;

import com.beaver.dec135.nothing.Nothing;

// 원하는 객체 하나 생성
//	이름, 나이, 별멸
//	출력

// 유일한 마루였으면 좋겠음!
//	디자인 패턴 프로그래밍 중에
//		*** 싱글톤패턴 (Singleton Pattern)s
//	클래스가 최초 한번만 메모리를 할당하고 (static)
//		그 메모리에 객체를 만들어서 사용하는 디자인 패턴
//	고정된 메모리 영역을 얻으면서 한번의 new로 객체를 사용하기 때문에
//		메모리 낭비를 방지할 수 있음

public class SMain1 {
	public static void main(String[] args) {
//		Nothing n = new Nothing("구구", 2, "구구구");
//		n.printInfo();
//		System.out.println(n);
//		System.out.println("------------------");
//		
//		Nothing n2 = new Nothing("구구", 2, "구구구");
//		n.printInfo();
//		System.out.println(n2);
		
		Nothing n = Nothing.getNothing();
		n.printInfo();
		System.out.println(n);
		System.out.println("------------------");
		Nothing n2 = Nothing.getNothing();
		n2.printInfo();
		System.out.println(n2);
		
		
		
	}
}
