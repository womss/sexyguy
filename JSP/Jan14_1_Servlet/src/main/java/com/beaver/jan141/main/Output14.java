package com.beaver.jan141.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output14")
public class Output14 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String host = request.getParameter("host");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
//		String hobby = request.getParameter("hobby");
		String[] hobbies = request.getParameterValues("hobby");
		String introduction = request.getParameter("introduction");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>web</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<h2>회원 정보</h2>");
		out.printf("<h2>id : %s</h2>", id);
		out.printf("<h2>e-mail : %s@%s</h2>", email, host);
		
		out.printf("<h2>연락처 : %s</h2>", phone);
		out.printf("<h2>성별 : %s</h2>", gender);
		out.printf("<h2>취미 : </h2>");
		  if (hobbies != null) {
	            for (String hobby : hobbies) {
	                out.printf("<h2>%s</h2>", hobby);
	            }
	        } else {
	            out.print("<h2>선택된 취미가 없습니다.</h2>");
	        }
		out.printf("<h2>자기소개 : %s</h2>", introduction);
		
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 이거 안하면 한글 깨짐, 영어는 괜찮
		response.setCharacterEncoding("UTF-8"); 	
		String id = request.getParameter("id");		
		String pw = request.getParameter("pw");
		PrintWriter out = response.getWriter(); 
		out.print("<html>");
		out.print("<head><title>Hi</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<h2>Output14-POST</h2>");
		out.print("</body>");
		out.print("</html>");
	}

}
