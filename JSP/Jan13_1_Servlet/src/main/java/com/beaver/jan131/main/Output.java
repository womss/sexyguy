package com.beaver.jan131.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output")
public class Output extends HttpServlet {
//	<form action="Output"> 클래스명과 액션명이 같아야 함
	
	// 사용자가 입력한 데이터가 주소에
	//	인터넷 주소에 한글 - X
	//		ㅋ => %2A (URL인코딩)
	
	// 사용자가 입력한 ㅋ(UTF-8) -URLEncoding-> %2A
	// 사용자로부터 받아온 %2A -URLDecoding-> ㅋ
	
	// GET방식 요청파라미터 한글처리
	//		UTF-8로 맞추자!
	//		Tomcat Servers 폴더 - servers.xml 65번줄 설정을 건드렸음!!
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); 	// 받아온 값을 다시 변환
		String a = request.getParameter("a");		// input name="a"랑 이름이 같아야 함
		PrintWriter out = response.getWriter(); 
		out.print("<html>");
		out.print("<head><title>Hi</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<h2>Output-Get</h2>");
		out.printf("<h2>%s</h2>",a);
		out.print("</body>");
		out.print("</html>");
		
	}

	// GET방식요청 vs POST방식요청
	//	GET : 요청파라미터가 주소(URL)에 있음
	//			대부분 GET방식을 사용함 <a> 태그는 GET방식만 됨
	//	POST : 요청파라미터가 주소(URL)에 없음, 내부적으로 전달
	//			보안성 높음 - 로그인, 회원가입, ...
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 이거 안하면 한글 깨짐, 영어는 괜찮
		response.setCharacterEncoding("UTF-8"); 	
		String a = request.getParameter("a");		
		PrintWriter out = response.getWriter(); 
		out.print("<html>");
		out.print("<head><title>Hi</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<h2>Output-POST</h2>");
		out.printf("<h2>%s</h2>",a);
		out.print("</body>");
		out.print("</html>");
	}

}
