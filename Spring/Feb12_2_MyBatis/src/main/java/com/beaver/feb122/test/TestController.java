package com.beaver.feb122.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beaver.feb122.student.StudentDAO;

@Controller
public class TestController {
	
	@Autowired
	private TestDAO tDAO;	// TestDAO를 tDAO로 불러오겠다
	
	//학생에 대한 정보도 가져와서
	@Autowired
	private StudentDAO sDAO;
	
	@RequestMapping(value = "/test.reg", method = RequestMethod.GET)
	public String regTest(Test t, HttpServletRequest req) { // 시험과목 객체, 파라미터 요청
		tDAO.regTest(t, req);
//		tDAO.setDate(req);
		tDAO.getAllTest(req);
		sDAO.getAllStudent(req); // 등록후에 시험과목까지 가져올 수 있으면 좋겠습니다
		return "index";
	}
}
