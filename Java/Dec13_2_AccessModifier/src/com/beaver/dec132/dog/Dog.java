package com.beaver.dec132.dog;

// 점근제어자 (Access Modifier)
//		클래스, 멤버변수, 메소드, 생성자에서 사용
//		외부에서 (멤버변수, 클래스에) 접근하지 못하도록 제한하는 역할

public class Dog {
							// 접근 범위
	public int a;			// 접근 제한 없음
	protected int b;		// 같은 패키지 내 or
							// 다른 패키지라면 그 하위 클래스에 한해서 가능
	/*default*/ int c;		// (default : 아무것도 쓰지 않은...)
							// 같은 패키지 내
	private int d;			// 클래스 내부에서만 O
							//	외부에서는 사용 X
	
	
	
	
	
}

















