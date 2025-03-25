package com.beaver.dec134.main;

import com.beaver.dec134.avengers.Avengers;
import com.beaver.dec134.avengers.IronMan;

public class AMain2 {
	public static void main(String[] args) {
		// 어벤져스 클래스
		// 이름, 나이 속성 + 정보 출력
		// 공격하기 기능
		
		
		// Avengers로부터 상속받은
		// 내부에 만들어놓은 클래스
		//		클래스명은 모름
		// 단 한번만 사용할 수 있고
		// 오직 하나의 객체만을 사용할 수 있는 1회용 클래스
		//	(= 말인 즉, 다른 곳에서 불러올 수 없다)
		
		// 익명 내부 클래스 (anonymus inner clsaa)
		Avengers a = new Avengers("파커", 3) { // 중괄호 안쪽부분이 클래스 부분
			@Override
			public void attack() {
				System.out.println("거미줄 발사!");
			}
		};		
		a.printInfo();
		a.attack();
		System.out.println("-----------------------");
		
		// 아이언맨은 저벤져스
		// 속성으로 재산
		// 공격은 빔
		// 흡연 O
		// 운전 O
		IronMan i = new IronMan("로버트 다우니 주니어", 43, "10조");
		i.printInfo();
		i.attack();
		i.drive();
		i.cigar();
			
			
		
		
		
		
	}
}
