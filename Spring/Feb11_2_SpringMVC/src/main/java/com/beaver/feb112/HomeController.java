package com.beaver.feb112;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



// 이전에 사용하던 JS Model2 ------------------------------------------------
//	http://IP:Port/프로젝트명/컨트롤러파일명(@WebServlet)
//		C : Servlet
//		상항판단을 잘해서 => 흐름을 제어
//		doGet(), doPost() 를 활용
//		주소에 컨트롤러파일명, 컨트롤러 하나당 GET하나, POST하나
//			=> 컨트롤러의 수가 많아짐

// 현재의 Spring MVC -----------------------------------------------------
//	http://IP:Port/top-level package의 마지막자리/임의대로 지정한 값
//		C : 일반 클래스
//			일반 메소드
//			컨트롤러 하나에 여러개의 요청 처리가 가능
//				=> 컨트롤러의 수가 많이 필요 없어짐

@Controller // 컨트롤러의 역할을 하는 클래스다
public class HomeController {
	
//	@Autowired
//	private lalala lalala;
	
	
	
	// 사이트 첫 접속시 method : GET
	// value에는 아무것도 쓰지 않은 상태 (26번줄 마지막의 임의대로 지정한 값이 없다)
	@RequestMapping(value = "/", method = RequestMethod.GET) // GET
	public String home() { // String 자료형이 기본
		
		return "index"; // index.jsp로 포워딩
	}
	
	// lalala.test라는 주소로 GET방식 요청이 들어오면
	//	'랄랄라~' 라는 내용이 콘솔창에 출력되는 메소드
	
	@RequestMapping(value = "/lalala.test", method = RequestMethod.GET) // 요청할 주소 임의로 지정 가능한 어노테이션
	public static void testLalala() {
		System.out.println("랄랄라  ~ ");
	}
	
}














