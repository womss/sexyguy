package com.beaver.jan131.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// class는 main이 있어야 하는데 main이 없다
//	main은 tomcat의 내부에 있음 ( 그래서 톰캣을 키고 실행을 해도 돌아간다 )

// Servlet (Server + Application)


// @XXX : Annotation
//	원래는 직접 다 구현해야 했는데... => 자동 처리를 해줌 !
@WebServlet("/LearnServlet") // LearnServlet을 Tomcat에 등록 // 클래스 이름과 어노테이션의 "/"이 같아야 함
							 // (*** 지우면 실행이 안됨!!!!)
public class LearnServlet extends HttpServlet {
	// HttpServlet클래스에 있는 기능(요청받으면 응답하기)을 상속받음
	//	뭔가를 더 추가 O
	
	// 작업하면서 버전 표시하라고...(지워도 무방함)
	private static final long serialVersionUID = 1L;
	
	// 생성자 - 이 LearnServlet 객체를 만드는건 tomcat
	//		별로 쓸 일 없음 (지워도 무방함)
    public LearnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // event-driven-programing (이벤트 기반 프로그래밍)
    //	Tomcat이 실행 => LearnServlet을 실행
    //		=> Tomcat LearnServlet이라는 객체를 만들어서 무한루프
    //		=> 어떤 이벤트가 발생하면 그것을 처리하고 루프로 복귀
    
    // 핵심부분 *** !!!
    // 루프돌다가 클라이언트가 이 Servlet으로 GET방식 요청하면
    // Tomcat이 doGet메소드를 자동으로 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	// 루프돌다가 클라이언트가 이 Servlet으로 POST방식 요청하면
	// Tomcat이 doPost메소드를 자동으로 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
