package com.beaver.jan231.main;

import java.util.Random;

public class test {
	// 1 ~ 999
	//	001 ~ 011
	//	012 ~ 987	- 답이 될 수 있음
	//	988 ~ 999
	
	public static String pickAns() {
		int a = new Random().nextInt(976)+12;	// 12 ~ 987
		String ans = String.format("%03d", a);	// "012" ~ "987" // 숫자형을 집어 넣는데
		
		// charAt() : 해당 인덱스에 있는 문자를 반환
		// char 자료형은 ascii (특정 정수값) 코드값으로 사용!
		if (ans.charAt(0) == ans.charAt(1) || ans.charAt(0) == ans.charAt(2) || ans.charAt(1) == ans.charAt(2)) {
			return pickAns();
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(pickAns());
		int a = 452;
		System.out.println(a/100); // 4
		System.out.println((a/10)%10); // 5
		System.out.println(a%10); // 2
		
	}
	
	
	
	
}































