package com.beaver.feb031.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleRegController")
public class AppleRegController extends HttpServlet {
	
	// 등록하러 form이 있는 페이지로 오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cp", "reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	// 포스트방식으로 받았을때 데이터를 등록하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에 등록
		AppleDAO.getAppledao().reg(request);
		
		// 게시판에 나올 데이터 가지고
//		AppleDAO.getAppledao().getAllApples(request);
		AppleDAO.getAppledao().getApples(1, request);
		
		// 등록 후에 보여줄 페이지로 이동
		request.setAttribute("cp", "apple.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
