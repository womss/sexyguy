package com.beaver.feb171.fruit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FruitController {
	
	@Autowired
	private FruitDAO fDAO;
	
	@RequestMapping(value = "/fruit.get", method = RequestMethod.GET)
	public String getAllFruit(HttpServletRequest req) {
		fDAO.getAllFruit(req);
		return "index";
	}
	
	@RequestMapping(value = "/fruit.getXML", method = RequestMethod.GET, produces = "application/xml; charset=UTF-8")
	public @ResponseBody Fruits getFruitXML(HttpServletRequest req) {
		return fDAO.getXML(req);
	}
	
	@RequestMapping(value = "/fruit.searchXML", method = RequestMethod.GET, produces = "application/xml; charset=UTF-8")
	public @ResponseBody Fruits searchXML(Fruit f, HttpServletRequest req) {
		return fDAO.searchXML(f, req);
	}
}
