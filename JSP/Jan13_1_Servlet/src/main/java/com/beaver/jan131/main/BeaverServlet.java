package com.beaver.jan131.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BeaverServlet")
public class BeaverServlet extends HttpServlet {
	
	// GET방식 요청(기본) 받으면 or
	//	주소를 알고 있으면 직접 타이핑해서 접속 O
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 랜선에 붙어있는 응답용 빨대 (PrintWriter)
//		PrintWriter out = response.getWriter();
//		out.print("<html>");
//		out.print("<head><title>Hello!</title><meta charset='UTF-8'></head>");
//		out.print("<body>");
//		for (int i = 0; i < 5; i++) {
//			out.print("<marquee>Hello !</marquee>");
//		}
//		out.print("</body>");
//		out.print("</html>");
		
		// 실행했을 때.. 주소창 요청파라미터 lang의 값으로
		// korean을 입력하면 '네'
		// english를 입력하면 'yse'
		// 그 외에는 '몰라'
		// <h1>로 출력
		
		// 클라이언트에게 서버층이 어떤 방식으로 인코딩을 했는지
		//		! 항.상 ! 알려줘야함!!!
		response.setCharacterEncoding("UTF-8");
		
		// ?변수명=값&변수명=값&...
		String language = request.getParameter("lang");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Hello!</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<h1>");
		if (language.equals("korean")) {
			out.print("네");
		} else if (language.equals("english")) {
			out.print("yes");
		} else {
			out.print("몰라");
		}
		
		out.print("</h1>");
		out.print("</body>");
		out.print("</html>");
		
		
//		   PrintWriter out = response.getWriter();
//		      out.print("<html>");
//		      out.print("<head><title>Hello!</title><meta charset='UTF-8'></head>");
//		      out.print("</body>");
//		      out.print("<h1>");
//		      if (lang.equals("korean")) {
//		         out.print("네");
//		      }else if (lang.equals("english")) {
//		         out.print("yes");
//		      }else {
//		         out.print("몰라");
//		      }
//		      out.print("</h1>");
//		      out.print("</body>");
//		      out.print("</html>");
		
		
	}

	// POST방식 요청 받으면
	//	프로그램을 통해서만 가능
	//	(계정의 비밀번호같이 주소값에 숨기고 싶은 것들...)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
