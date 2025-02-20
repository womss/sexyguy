package com.beaver.feb113.uc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 컨트롤러로서의 역할을 하겠다
@Controller
public class UCController {
	
	@Autowired
	private UCDAO ucd;
	
	@RequestMapping(value = "/unit.convert", method = RequestMethod.GET) // 홈 컨트롤러를 제외한 컨트롤러가 다중일땐 value 값이 같은 값이 있어선 안됨, 있다면 어디로 가야할지 몰라 오류가 뜸 
	public String unitConvert(UCResult ur, HttpServletRequest req) {
		ucd.convert(ur, req);
		return "output";
	}
	
	
	
	
}
