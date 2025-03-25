package com.beaver.feb031.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.feb031.apple.AppleDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	// 톰캣이 이 프로젝트를 처음 싱행시킬때
	public HomeController() {
		AppleDAO.getAppledao().countApples(); // 사과 개수 구해오기
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("cp" , "Home.jsp");
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		if (request.getParameterNames().hasMoreElements()) {
			request.setAttribute("cp", "Home.jsp");
		} else {
			request.setAttribute("cp", "Home.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
