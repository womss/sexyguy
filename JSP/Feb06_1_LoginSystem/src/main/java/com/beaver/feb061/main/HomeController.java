package com.beaver.feb061.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.feb061.member.MemberDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.loginCheck(request)) { 
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response); // 로그인이 되었다면 로그인 성공 페이지로
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response); // 로그인 정보가 안맞는다면 다시 로그인 페이지로
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
