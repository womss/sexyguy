package com.beaver.dec162.main;

import java.util.Scanner;

import com.beaver.dec162.calculator.Calculator;

// Java
//		예외처리가 강제
// Python
//		처리하기 싫으면 안해도 됨

public class EMain3 {
//	int price;
//	int weight;
//	
//	public EMain3() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	public EMain3(int price, int weight) {
//		super();
//		this.price = price;
//		this.weight = weight;
//	}


	public static void main(String[] args) {
		// 가격 / 무게(g)를 입력받아서 (main에서 정수로)
		// g당 가격이 얼마인지 값을 구해서 main에서 출력
		// 기능에 대한 것은 class하나 열어서
		Scanner k = new Scanner(System.in);
		System.out.println("가격 : 원");
		int price = k.nextInt();
		
		System.out.println("무게 : g");
		int weight = k.nextInt();
		
//		Trans t = new Trans();
//		t.printInfo();
		
		int z1 = Calculator.divide(price, weight);
		System.out.printf("g당 가격은 : %d원\n", z1);
		
		
//		try {
//			int z2 = Calculator.divide2(price, weight);
//			System.out.printf("g당 가격은 : %d원\n", z2);			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		// g당 얼마인지...
		// 다른 메소드에서 try-catch...
		//		=> 월권 행위 O / main 메소드에서 사용
		// throws : 이걸 더 많이 사용함! / main메소드 이외의 메소드
		
	}
}































