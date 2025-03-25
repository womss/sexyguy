package com.beaver.feb062.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.feb062.main.TokenManager;
import com.beaver.feb062.member.MemberDAO;


@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request);					// 로그인상태인지 아닌지 체크하는
		TokenManager.make(request);						// 토큰(시간)값을 가져오는
		BoardDAO.getBdao().clearSearch(request);		// 검색값(search)을 null값을 넣어서 최초 진입시 검색이 안되게, null값이 아니라면 검색결과가 없다고 알림이 뜸
		BoardDAO.getBdao().getBoardMsg(1, request);
		request.setAttribute("cp", "board/board.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
