package com.beaver.feb112.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// 멤버변수 없으면 : static method 기반
//	M / DAO에는 게시판같은 기능을 구현한다면 멤버변수가 생김(생길 수 밖에 없음)
//		=> static기반 method는 포기 => 객체를 만들어서 사용해야하는데
//		=> 새로고침 or 요청 => calculate.do로 요청할 때마다 새로운cDAO가
//		=>	allCalcCount도 제대로 카운팅 X !

// 해결방안 : cALDAO를 singleton처리!

// Spring식의 Singleton 처리방법
@Service // service-context.xml에 CalcDAO 객체 하나를 등록해놓은 효과!
public class CalcDAO {
	private int allCalcCount; // 몇 번 계산했는지 // 하나를 가져올땐 와이어 기능을 가져올땐 서비스
	
	public void calculate(CalcResult cr, HttpServletRequest req) {
		allCalcCount++;
		System.out.println(allCalcCount);
		int add = cr.getX() + cr.getY();
		System.out.println(add);
		
		
	}
	
	
	
}



































