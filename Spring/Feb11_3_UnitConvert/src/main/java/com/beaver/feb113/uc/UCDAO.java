package com.beaver.feb113.uc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// 하나의 객체로 만들기 위한
@Service
public class UCDAO {
	// UCDAO 객체가 생성될때, servlet-context.xml에서 unit 값을 주입
	private HashMap<String, String> unit; // 값을 넣었을때 오른쪽 스트링에 맞는 값을 가져오겠다?
	
	// Spring이 XML을 읽고 setUnit() 호출하여 unit 값을							@@여기 써야함@@
	//		UCDAO 객체에 자동으로 주입
	public void setUnit(HashMap<String, String> unit) {
		this.unit = unit;
	}
	
	// 정리 : servlet-context.xml 에
	//    <beans:property name="unit"> 부분이 있고,
	//   UCDAO의 unit이라는 프로퍼티(속성)를
	//   XML에서 설정했기 때문에 자동으로 setter메소드를
	//   호출해 그 값을 담아냄
	// cf) (2월10일) Cat 객체를 @Autowired로 주입할 때는
	//   setter 메소드가 없어도 자동으로 주입됨

	// 강사님
	public void convert(UCResult ur, HttpServletRequest req) {
		double n1 = ur.getN1(); // 변환 객체는 이미 ur에 들어있다
		String what = req.getParameter("select");
		double n2 = n1 * 1.61;
		if (what.equals("inch")) {
			n2 = n1 * 0.39;
		} else if (what.equals("pyeong")) {
			n2 = n1 * 0.3;
		} else if (what.equals("f")) {
			n2 = n1 * 1.8 + 32;
		}

		// 단위들은 어떻게 받아올 것인가 ?
		System.out.println(unit);
		System.out.println(unit.get(what));
		
		String[] u = unit.get(what).split(",");
		
		ur.setN2(n2); // 변환후의 수치 값
		ur.setU1(u[0]);	//
		ur.setU2(u[1]);	//
		
		req.setAttribute("ur", ur);
		
		
	}
}
