package com.beaver.feb031.apple;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/goAppleDetail")
public class goAppleDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AppleDAO.getAppledao().getAllApples(request);
	        request.setAttribute("cp", "detail.jsp");
	        request.getRequestDispatcher("index.jsp").forward(request, response);
//	        RequestDispatcher dispatcher = request.getRequestDispatcher("appleDetail.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppleDAO.getAppledao().getAllApples(request);
	}

}
