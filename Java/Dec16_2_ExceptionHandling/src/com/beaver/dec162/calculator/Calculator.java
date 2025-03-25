package com.beaver.dec162.calculator;

public class Calculator {
	// 1. 여기서 아예 끝장을 내자!! (try - catch - finally)
	// 정상 : 7 - 8 - 9 - 13 - 14 // finally 설명 참조 7 - 8 - [13 - 14 - 15] - 9 ([] : finally)
	// 무게 값으로 0 : 7 - 8 - 9(Arith) - 10 - 11 - 12 // 7 - 8 - 9(Arith) - 10 - 11 - [13 - 14 - 15] - 12  
	public static int divide(int price, int weight) { // ???
		try {
			return price / weight;
		} catch (Exception e) {
			System.out.println("으엑");
			return -9999;
		}finally {
			System.out.println("zzzz");
		} //여기를 벗어나는 값이 생기면 여기서 해결을 보자
	}
	
	// 2. 미루기 : throws -> try보다 더 주력
	//	dvide2를 실행하다가 exception이 터지면
	//	dvide2를 호출한 쪽에서 해결해라!
	public static int divide2(int price, int weight) 
			throws /* ArithmeticException, ArrayIndexOutOfBoundsException */
				Exception {  //하나로 퉁쳐 익셉션
		int d = price / weight;
		return d;
	}
	
	
}
