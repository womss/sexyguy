package com.beaver.feb122;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beaver.feb122.student.StudentDAO;
import com.beaver.feb122.test.TestDAO;

@Controller
public class HomeController {
	
	@Autowired
	private StudentDAO sDAO;
	@Autowired
	private TestDAO tDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		sDAO.getAllStudent(req);
		tDAO.getAllTest(req);
		return "index";
	}
	
}
