// 파라미터가 있으면 RCP.jsp로 값을 보내고
package com.beaver.jan2211.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 문제 : GET방식 요청할때마다 다른 엔진을 생성하고 있어서
//			전적(숫자)가 안쌓임
// 해결책 : 시도할때마다 새로운 엔진이 생기니 => 엔진 하나 고정 => Singleton pattern!!!!

@WebServlet("/RCPController")
public class RCPController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) { // 요청파라미터명이 없으면
			request.setAttribute("uh", "gogae.gif");
			request.setAttribute("ch", "gogae.gif");
			request.getRequestDispatcher("RCP.html").forward(request, response);
		} else {
			// 요청파라미터명이 있으면 => 사이트의 기능활용을 GET 방식!
//			RSPGameEngine rge = new RSPGameEngine(); // 이건 게임엔진에서 다시 만들었기때문에 주석처리
			RSPGameEngine rge = RSPGameEngine.getRge();
			rge.doRSP(request);
//			RCPCalculator.calculator(request);
		}
		request.getRequestDispatcher("RCP.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RSPGameEngine rge = RSPGameEngine.getRge();
		rge.reset(request);
		request.setAttribute("uh", "gogae.gif");
		request.setAttribute("ch", "gogae.gif");
		request.getRequestDispatcher("RCP.html").forward(request, response);
	}

}
