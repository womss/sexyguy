package com.beaver.jan231.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/GamblingController")
public class GamblingController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) { // 요청파라미터명이 없으면
			request.setAttribute("uu", "ghfWkr.jpg");
			request.setAttribute("uc", "rhffk.gif");
			request.setAttribute("cc", "ghfWkr.jpg");
			request.setAttribute("comHand", "몇개가 나올까요~");
			request.getRequestDispatcher("Gambling.jsp").forward(request, response);
		} else {
			GamblingEngine GBE = GamblingEngine.getRge();
			GBE.doGBE(request);
		}
		request.getRequestDispatcher("Gambling.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GamblingEngine GBE = GamblingEngine.getRge();
		GBE.reset(request);
		request.setAttribute("uu", "ghfWkr.jpg");
		request.setAttribute("uc", "rhffk.gif");
		request.setAttribute("cc", "ghfWkr.jpg");
		request.setAttribute("r", "전적 초기화 완료 !");
		request.getRequestDispatcher("Gambling.jsp").forward(request, response);
	}

}
