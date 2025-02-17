

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 숫자 야구 => 볼 스트라이크  
//	3자리 숫자 (백의자리 숫자 0 가능), 중복 숫자 X !
//	입력 하는 부분
//		1. 숫자아닌거 입력 못하게(값이 안넘어가게)
//		2. 중복 숫자 입력 다시 입력하게
//		3. 무조건 3자리 숫자여야 하도록
//		유효성 검사

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (!request.getParameterNames().hasMoreElements()) { // 요청파라미터명이 없으면
			NBGameEngine.getNge().pickAns();
		} else {
			NBGameEngine.getNge().doNB(request);
		}
		request.getRequestDispatcher("NumBaseball.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseballEngine.getBBE().reset(request);
		request.getRequestDispatcher("NumBaseball.jsp").forward(request, response);
	}
	
}
	
	
	
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (!request.getParameterNames().hasMoreElements()) { // 요청파라미터명이 없으면
//			request.setAttribute("u", "은 뭘까요?");
//			request.setAttribute("done", "맞춰보세요 ~");
//			request.getRequestDispatcher("NumBaseball.jsp").forward(request, response);
//		} else {
//			new BaseballEngine().doBBE(request);		// 3을 만들겠다
//			BaseballEngine.getBBE().doBBE(request); // 1 안에 있는 만들어져 있는 2베이스볼을 불러와 쓰겠다
//			request.getRequestDispatcher("NumBaseball.jsp").forward(request, response);
//		}
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		BaseballEngine.getBBE().reset(request);
//		request.getRequestDispatcher("NumBaseball.jsp").forward(request, response);
//	}
//	
//}