package com.beaver.feb061.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.feb061.sns.DateManager;
import com.beaver.feb061.sns.MemberDAO;
import com.beaver.feb061.sns.snsDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	
	public HomeController() {
		snsDAO.getSnsdao().countMembers(); // 회원 수 구해오기
//		BoardDAO.getBdao().countAllBoardMsg();
	}
	
	// 유효성 검사 후에 db에 반영
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DateManager.getCurYear(request);
		MemberDAO.loginCheck(request);
			if (request.getParameterNames().hasMoreElements()) {
				request.setAttribute("lp", "main.jsp");
				request.setAttribute("cp", "Login.jsp");
			} else {
				request.setAttribute("lp", "main.jsp");
				request.setAttribute("cp", "Login.jsp");
			}
			request.getRequestDispatcher("SNS.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
