package com.beaver.feb062.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.feb062.main.DateManager;

@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request);
		DateManager.getCurYear(request);
		request.setAttribute("cp", "member/signup.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request);
		MemberDAO.signUp(request);
		request.setAttribute("cp", "member/signup.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}








