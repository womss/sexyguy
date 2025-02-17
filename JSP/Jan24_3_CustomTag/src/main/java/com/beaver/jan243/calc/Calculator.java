package com.beaver.jan243.calc;

import javax.servlet.http.HttpServletRequest;

public class Calculator {

	public static void calculate(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		request.setAttribute("a", x + y);
		request.setAttribute("s", x - y);
		request.setAttribute("m", x * y);
		request.setAttribute("d", String.format("%.2f", x /(double) y));
	}
	
}







































