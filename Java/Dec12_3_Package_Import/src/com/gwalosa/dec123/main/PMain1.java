package com.gwalosa.dec123.main;

import com.gwalosa.dec123.product.Computer;
//import com.gwalosa.dec123.product.Scanner;
// ctrl + shift + o : import 정리
public class PMain1 {
	public static void main(String[] args) {
		// 매직스테이션, 800000원, i5-1234, 8GB, 500GB 컴퓨터
		// 출력
		Computer c = new Computer("매직스테이션", 800000, "i5-1234", 8, 500);
		c.printInfo();
		System.out.println("--------------------------");
		
		// 멀티익스프레스, 500000원, 스캐너
		// 출력
		com.gwalosa.dec123.product.Scanner s = new com.gwalosa.dec123.product.Scanner("멀티익스프레스", 50000);
//		Scanner s = new Scanner("멀티익스프레스", 50000);
		s.printInfo();
		System.out.println("--------------------------");
		
	}
}
