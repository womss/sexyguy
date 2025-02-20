package com.beaver.feb061.sns;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.logout(request);
		MemberDAO.loginCheck(request);
		request.setAttribute("lp", "main.jsp");
		request.setAttribute("cp", "login.jsp");
		request.getRequestDispatcher("SNS.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.login(request, response); // 로그인에 대한 시도
		MemberDAO.loginCheck(request);
		request.setAttribute("lp", "main.jsp");
		request.setAttribute("cp", "login.jsp");
		request.getRequestDispatcher("SNS.jsp").forward(request, response);
	}
}
