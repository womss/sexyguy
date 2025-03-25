
public class WhatisValue {
	// 알고 싶은 자료형의 기본값에 대해 멤버변수로 만들어서 //멤버변수가 무엇?
	
	// 출력하는 메소드를 생성 // 출력하는 메소드는 어디에?
//	내가
//	String stringValue;
//	int intValue;
//	double doubleValue;
	
	
	// 기본형 - 정수
	byte bytefeild;
	short shortfeild;
	int intfeild;
	long longfeild;
	
	// 기본형 - 논리, 문자
	boolean booleanfeild;
	char charfeild;
	
	// 기본형 - 실수
	float floatfeild;
	double doublefeild;
	
	// 참조형 - 문자열, 배열
	String Stringfeild;
	int[] arrayfeild;
	
	//출력하는 메소드를 생성
	public void printInfo() {
		System.out.println("byte : " + bytefeild);
		System.out.println("short : " + shortfeild);
		System.out.println("int : " + intfeild);
		System.out.println("long : " + longfeild);
		System.out.println("boolean : " + booleanfeild);
		System.out.println("char : " + charfeild);
							// char : 기본값이 빈칸
							// 인코딩 방식 중 유니코드
							// \u0000 - 빈칸
		System.out.println("float : " + floatfeild);
		System.out.println("double : " + doublefeild);
		System.out.println("String : " + Stringfeild);
		System.out.println("Array : " + arrayfeild);
	}
	
}
