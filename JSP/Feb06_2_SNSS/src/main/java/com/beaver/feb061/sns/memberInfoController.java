package com.beaver.feb061.sns;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberInfoController")
public class memberInfoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.loginCheck(request)) {
			MemberDAO.update(request);
			DateManager.getCurYear(request);
			request.setAttribute("lp", "info.jsp");
		} else {
			request.setAttribute("lp", "main.jsp");
		}
		request.getRequestDispatcher("SNS.jsp").forward(request, response);
	}

}
