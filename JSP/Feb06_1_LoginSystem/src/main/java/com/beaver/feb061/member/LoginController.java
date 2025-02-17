package com.beaver.feb061.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.login(request, response); // 로그인에 대한 시도
		
		// 1. 로그인에 성공시 => loginSuccess.jsp
		// 2. 로그인에 실패시 => index.jsp
		if (MemberDAO.loginCheck(request)) { 
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response); // 로그인이 되었다면 로그인 성공 페이지로
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response); // 로그인정보가 안맞는다면 다시 로그인 페이지로
		}
	}

}
