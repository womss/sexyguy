package com.beaver.feb061.sns;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signupController")
public class signupController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("lp", "membership.jsp");
//		request.setAttribute("cp", "Login.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.signup(request);
		if (request.getParameterNames().hasMoreElements()) {
			request.setAttribute("lp", "membership.jsp");
			request.setAttribute("cp", "Login.jsp");
			
		} else {
			request.setAttribute("lp", "main.jsp");
			request.setAttribute("cp", "Login.jsp");
		}
		request.getRequestDispatcher("SNS.jsp").forward(request, response);
	}

}
