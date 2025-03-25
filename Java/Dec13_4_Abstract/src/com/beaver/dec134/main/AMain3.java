package com.beaver.dec134.main;

import com.beaver.dec134.avengers.Avengers;
import com.beaver.dec134.avengers.IronMan;

// 다형성 (Polymorphism)
//	poly (많은) + Morph (모양)
//	상위타입 변수에 하위타입 객체를 담는 것이 가능
//	같은 형태이지만 다른 기능을 할 수 있음! (overriding과 밀접한 관련)

public class AMain3 {
	public static void main(String[] args) {
		// 아이언맨 담는 그릇 i에 아이언맨 만들어 넣음
		IronMan i = new IronMan("a", 123,"1조");
		
		// 어벤져스 담는 그릇 a에 아이언맨 만들어 넣음
		Avengers a = new IronMan("a", 123, "2조");
		
		// IronMan은 Avengers의 하위 클래스
		// Avengers 타입의 변수에 IronMan 객체를 담을 수 있음
		// 다형성을 통해, 상위 클래스 타입의 변수를 사용해서
		//		하위 클래스 객체를 참조할 수 있게 되면,
		//		코드의 유연성과 확장성이 증가
		a.attack();
		
		
	}
	
}
