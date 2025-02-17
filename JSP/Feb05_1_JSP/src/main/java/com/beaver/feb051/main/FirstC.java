package com.beaver.feb051.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// CMVN 중 Controller
//	JSP환경에서 상황판단을 하기엔 파일 자체가 무거움
//		JSP의 무게를 덜어내주기 위해 (GET? POST?) 판단을 하기에는 Servlet이 적합!
//			계산을 해야한다면 M(Model)으로
//			내용을 보여줘야한다면 V(View)으로
//		흐름제어

@WebServlet("/FirstC") // <= FirstC를 톰캣에 등록하겠다는 뜻
public class FirstC extends HttpServlet {
	
	// 이 파일에는 main메소드가 없음
	// 톰캣이 실행(main은 톰캣에) => 알아서 FirstC객체를 만들고...
	
	// 어쨌건 이 프로젝트가 여기서 처음 시작 되는데 그때
    public FirstC() {
        super();
        // 처음 실행했을 때 사과 데이터 총 갯수를 받아오기 위해 사용했음			// 찾
    }
    
    // 웹사이트의 페이지 전환에 있어서는
    //	C로 요청 => M에 가서 작업 => V로 포워딩
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사이트에 처음 들어오면
		// firstC로 요청파라미터 하나도 없이 GET방식으로 요청을 하면,
		if (!request.getParameterNames().hasMoreElements()) {	// 찾
			
			// firstV.jsp로 지금 일어난 요청을 제보해주는 객체
			RequestDispatcher rd = request.getRequestDispatcher("firstV.jsp");
			rd.forward(request, response); // firstV.jsp로 포워딩 하겠다
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

