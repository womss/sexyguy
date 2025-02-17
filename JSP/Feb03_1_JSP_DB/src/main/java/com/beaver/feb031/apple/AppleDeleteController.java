package com.beaver.feb031.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.ChannelSender;

@WebServlet("/AppleDeleteController")
public class AppleDeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppleDAO.getAppledao().delete(request); 		// DAO의 삭제기능을 돌리고
		AppleDAO.getAppledao().getApples(1, request);	// 사과 목록들을 받아와서 <= 이게 없다면 apple.jsp의 화면은 목록이 없는 빈 화면
        request.setAttribute("cp", "apple.jsp");		// 사과목록으로 이동 하겠다
       
		request.getRequestDispatcher("index.jsp").forward(request, response);
		

	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
