package com.beaver.jan151.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class test extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 이거 안하면 한글 깨짐, 영어는 괜찮
		response.setCharacterEncoding("UTF-8"); 	
		String id = request.getParameter("ID");		
		String pw = request.getParameter("PW");
		String gd = request.getParameter("GD");
		String lc = request.getParameter("LC");
		String[] hb = request.getParameterValues("HB");
		String ind = request.getParameter("IND");
		
		// textarea에서 엔터 :\r\n
		// 웹페이지에서 줄바꾸기 : <br>
		ind = ind.replace("\r\n", "<br>");
		PrintWriter out = response.getWriter(); 
		out.print("<html>");
		out.print("<head><title>회원가입결과</title>");
		out.print("<meta charset='UTF-8'");
		out.print("<link rel='stylesheet' href='css/input.css'></head>");
		out.print("<body>");
		
		out.print("<h1>회원가입결과</h1>");
		out.printf("<h2>ID : %s</h2>", id);
		out.printf("<h2>PW : %s</h2>", pw);
		out.printf("<h2>성별 : %s</h2>", gd);
		out.printf("<h2>지역 : %s</h2>", lc);
		if (hb != null) { // 취미를 선택하지 않았을때를 대비해서
			out.print("<h2>취미 : ");
			for (String s : hb) { // 배열 열어서 하나씩 풀기
				out.print(s + " ");
			}
			out.print("</h2>");
		}else {
				out.print("<h2>취미 : 선택안함</h2>");
			}
			out.printf("<h2>자기소개 : %s</h2>", ind);
			out.printf("<h2><button onclick='history.back();'>이전페이지로</button>");
		
		out.print("</body>");
		out.print("</html>");
	}

}
