package com.beaver.dec163.main;

import javax.xml.bind.ParseConversionEvent;

// Wrapper Class : (자료형) 기본형들의 객체형 (포장객체)
//		Integer, Double, Long, Void, Boolean, ...
//		기본 자료형을 객체로 다루기 위해 사용하는 Class
//		Java의 기본형은 값을 가지고 있는 객체 생성이 가능
//		기본형이 가지고 있는 값을 내부에 두고 그 위를 포장하는 방식
//	기본형 => 래퍼클래스 : Boxing
//	래퍼클래스 => 기본형 : UnBoxing

// 1. 객체나 클래스가 제공하는 method 사용할 때
// 2. 클래스가 제공하는 상수를 사용(MIN_VALUE, MAX_VALUE, ...)
// 3. 숫자, 문자로 형변환을 할 때 (v) 이게 가장 많이 쓰임

public class WMain {
	public static void main(String[] args) {
//		int a = 10;
//		double b = (double) a; 기본형이 왔다갔다 하는건 가능한데
		
//		int a = 10;
//		String b = (String) a; 우리가 아는 선에서 다른 기본형으로는 안됨
		
		String a1 = "100";
		
		// Integer 객체를 생성 => 값을 넣어서 => 형변환 => Int형으로 return
		Integer b = new Integer(a1);
		System.out.println("------------------------");
		System.out.println(b.getClass());
		b.intValue();// 기본형 자료형으로 바꿔봄
		System.out.println("------------------------");
		System.out.println(b); 								// 100
		System.out.println("------------------------");
		System.out.println(b.TYPE); // UnBoxing과정까지 해봄 	// int
		System.out.println("------------------------");
		
		// 기본형 => 객체형
		double c = 123.456;
		Double d = new Double(c);		// 포장하기
		
		// 객체형 => 기본형
		Boolean e = new Boolean(true);
		boolean f = e.booleanValue();	// 포장뜯기
		
		// 객체형 => 기본형 (위의 과정을 자동으로 해줌 : Auto-Unboxing)
		Integer g = 10;
//		System.out.println(g.getClass());
		int h = g;
		
		// 기본형 => 객체형 (위의 과정을 자동으로 해줌 : Auto-boxing)
		int i = h;
		Integer j = i;
		
		int max = Integer.MAX_VALUE;
		System.out.println("------------------------");
		System.out.println(max);							// 2147483647
		System.out.println("------------------------");
		int min = Integer.MIN_VALUE;
		System.out.println(min);							// -2147483647
		System.out.println("------------------------");
		// int 자료형의 값을 => String(문자열)으로
		String num1 = Integer.toString(321);
		System.out.println(num1);							// 321
		System.out.println("------------------------");
		// String => 기본형
		String k = "345.67";
		Double k2 = Double.parseDouble(k);
		double k3 = k2.doubleValue();
		
		String m = "150";
		int m2 = Integer.parseInt(m); // 이렇게 오토 언박싱이 가능하다
		// 포장 객체는 이게 끝
		// 예외처리 ★
		// 날짜처리 ★
		// 포장객체 ★
		// 내일은 문자열들에대한 처리, 파일처리 (바깥으로)과정, Http 웹에있는걸 이클립스로 크롤링
		
//		 Integer a = null;
//	        int b = a + 10;
//	        System.out.println("Result: " + b);
	        System.out.println(Boolean.TRUE);
	        System.out.println(Character.MAX_VALUE);
	}
}
