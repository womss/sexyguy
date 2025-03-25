package com.beaver.Jan213.main;

import javax.servlet.http.HttpServletRequest;

// Model : 일반 Java Class 눌렀을때 나오는 화면 보내기
//		실제 업무(계산, DB, ...)

//		back-end개발자 B
public class M {
	public static void add(HttpServletRequest request) { // 요청객체
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x + y;
		request.setAttribute("z", z); // 자바 내에서 만들어낸 값 어트리뷰트 // 클라이언트로부터 받은 값을 가지고 새롭게 뭔가를 만들었을땐 리퀘스트로 넣어줘야 V2.jsp에서 읽을 수 있음
	}
}
