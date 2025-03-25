package com.beaver.dec201.main;

import java.util.HashMap;

// Map 계열 (Python : dict / Object-C : NSDictionary)
//		가변 사이즈
//		<Key, Value>
//		순서 개념 X
//		HashMap, HashTable, ...

public class MapMain {
	public static int asdfMethod() {
		int a = staticMethod();
	}
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("아메리카노", 4000);
		hm.put("녹차라떼", 5000);
		hm.put("레몬에이드", 6000);
		hm.put("녹차라떼", 7000); // '녹차라떼' key값이 같기 때문에
								// 제일 마지막에 저장된 Value로 수정

		// key를 넣으면 value를 추출
		System.out.println(hm.get("녹차라떼"));

		for (String string : hm.keySet()) { // key값만 추출
			System.out.println(string);
			System.out.println(hm.get(string));
			System.out.println("---------------");

		}
		
		

	}

	public static int staticMethod() {
		System.out.println("Static Method");
		return 3;
	}
}
