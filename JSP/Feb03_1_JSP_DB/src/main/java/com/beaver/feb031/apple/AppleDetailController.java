package com.beaver.feb031.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleDetailController")
public class AppleDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (AppleDAO.getAppledao().getAppleDetail(request)) { // 참이냐 거짓이냐고 나뉠 수 있다 리턴값이 불리언이기 때문
			// 트루값이 정상적으로 불러와 진다면 상세페이지를 불러온다
			request.setAttribute("cp", "detail.jsp");
		} else {
			AppleDAO.getAppledao().getApples(1, request);
			request.setAttribute("cp", "apple.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// update
		if (AppleDAO.getAppledao().update(request)) { // 업데이트가 정상적으로 성공 했다면
			AppleDAO.getAppledao().getApples(1, request); // 사과 목록 페이지로
			request.setAttribute("cp", "apple.jsp");
		} else {
			AppleDAO.getAppledao().getApples(1, request); // 아니어도 사과 목록 페이지로
			request.setAttribute("cp", "apple.jsp");
			
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
