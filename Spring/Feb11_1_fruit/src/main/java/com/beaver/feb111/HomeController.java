package com.beaver.feb111;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beaver.feb111.fruit.Fruit;
import com.beaver.feb111.member.MemberDAO;

@Controller
public class HomeController {
	
	// Fruit 클래스 => 이름 / 가격
	// 현재 Autowierd된 Fruit fr 필드는 xml의 과일데이터중에
	//		어떤 객체를 사용할지를 제대로 지정되지 않아서 오류 발생
	// 다른 이름을 지정하겠다
	//	=> @Qualifier를 사용해서 명확하게 어떤 객체를 주입할지 지정!!
	@Autowired
	@Qualifier("f")
	private Fruit fr;
	
	@Autowired
	private Fruit f2;
	
	// 오토와이어드로 끌고 와서
	@Autowired
	private MemberDAO mDAO;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println(fr.getName());
		System.out.println(fr.getPrice());
		
		mDAO.test();
		
		return "home";
	}
	
}
