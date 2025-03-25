package com.beaver.dec161.main;

import com.beaver.dec161.avengers.Ironman;
import com.beaver.dec161.human.Human;
import com.beaver.dec161.planet.Planet;

public class OMain1 {
	public static void main(String[] args) {
		// 게임 개발 중 ...
		// 행성 (이름, 크기, 보이는지 안보이는지)
		// 사람 (이름)
		
		// 이름이 '지구'인 행성 생성 (행성 이름)
		// 이름이 '???'인 사람 생성 (사람 이름)
		
		Planet p1 = new Planet("안드로메다");
		p1.printInfo();
		System.out.println("-----------------------");

		Human h1 = new Human("타노스");
		h1.printInfo();
		System.out.println("-----------------------");
		
		// 이 행성에 사람이 입주(텍스트로 표현)
		p1.add(h1);

		// 사수 : interface
		// interface 부사수 제어용
		// attack();을 반드시 구현하게!
		
		// 아이언맨 객체 - attack 기능 구현
		// 속성, 생성자, getter, setter x
		Ironman i1 = new Ironman();
		
		// 이 사람이 아이언맨을 자기 전담 영웅으로 픽 // 메소드 하나
		h1.pick(i1);
		
		// 이 사람이 도와달라고 소리 침!!! => 아이언맨이 공격!
		h1.helpAaaaaaa();
		
		// 이 행성사이즈를 1000으로 수정
		p1.setSize(1000);		
		// 이 행성을 보이게 수정
		p1.setVision(true);
		
	}
}

























