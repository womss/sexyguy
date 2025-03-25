package com.beaver.dec134.bite;

// 클래스 : 멤버변수, 메소드
// 추상클래스 : 멤버변수, 메소드, 추상메소드
// 인터페이스 : 추상메소드, 멤버 상수
//		=> 객체생성 불가능 (Classs가 아니라서)

public interface Bite {
	// private int a;				// 멤버 변수 x
	public static final int B = 3;	// 멤버 상수 O
	
//	public void c() {
//		System.out.println("c");
//	}	// 메소드 X, BUT static 메소드 O
	
	public abstract void bite(); // 지금은 미완성인 채로 둘테니 나중엔 꼭 완성시켜라 라는 추상메소드
}
