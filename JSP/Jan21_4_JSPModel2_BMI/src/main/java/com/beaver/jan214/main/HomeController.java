// C.java
package com.beaver.jan214.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// BMI를 JSPModel2 방식으로 만들어주실건데
//	의사와 환자가 데이터를 주고 받는 형태로 만들고 싶음(OOP 반영)
//	환자가 정보를 주면 의사가 그 정보를 가지고 계산 형태(POST방식 요청)
//		=> 를 출력할 것!
// 입력할때 사진과 유효성 검사 다 진행

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("BMIInput.html").forward(request, response);	//포워딩
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Doctor.calculate(request);
		request.getRequestDispatcher("BMIOutput.jsp").forward(request, response); // 결과 값을 끌고 가서
//		BMIReturn.cal(request);
//		request.getRequestDispatcher("BMIResult.jsp").forward(request, response);
	}

}
