package com.beaver.jan243.jstlc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.jan243.calc.Calculator;

@WebServlet("/JSTLCController")
public class JSTLCController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("contentPage", "jstlc/input.jsp"); // 파라미터가 없으면 입력하게 하고
		} else {
			JSTLCDataMaker.make(request);
			request.setAttribute("contentPage", "jstlc/output.jsp");	// 파라미터가 있으면 계산
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);// 우리가 볼 뼈대
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
