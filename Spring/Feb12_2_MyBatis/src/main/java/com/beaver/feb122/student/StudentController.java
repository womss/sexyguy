package com.beaver.feb122.student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beaver.feb122.test.TestDAO;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDAO sDAO;
	
	@Autowired
	private TestDAO tDAO;
	
	
	@RequestMapping(value = "/student.reg", method = RequestMethod.GET)
	public String regStudent(Student s, HttpServletRequest req) {
		sDAO.regStudent(s, req);
		tDAO.getAllTest(req);
		sDAO.getAllStudent(req);// 등록후에 학생데이터까지 가져올 수 있으면 좋겠습니다
		return "index";
	}
	
	
	
}
