package com.beaver.dec133.main;

import javax.swing.JFrame;

import com.beaver.dec133.coffee.Coffee;
import com.beaver.dec133.human.Human;

public class OMain1 {
	public static void main(String[] args) {
//		// 타이틀이 ㅋㅋㅋ 인 JFrame
//		JFrame f = new JFrame("ㅋㅋㅋ");
//		// 사이즈를 300, 500 수정
//		f.setSize(300, 500);
//		// 타이틀을 ㅎㅎㅎ 로 수정
//		f.setTitle("ㅎㅎㅎ");
//		//보이게 하고 싶음
//		f.setVisible(true);
		
		// 커피 객체
		//	이름이 아메리카노, 3000원
		//	정보를 출력
		Coffee c = new Coffee("아메리카노", 3000);
		c.printInfo();
		System.out.println("---------------------");
		Human h = new Human();
//		h.name = "asdf"; <= private라 안됨
		h.setName("김뜨또");
		h.setAge(-25);
		System.out.println(h.getAge());
		h.printInfo();
	}
}































