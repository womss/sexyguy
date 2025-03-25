package com.beaver.jan243.jstlc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class JSTLCDataMaker {
	
	public static void make(HttpServletRequest req) {
		int[] ar = { 123, 456, 78, 91, 234 };
		req.setAttribute("ar", ar);
		
		ArrayList<Beaver> al = new ArrayList<Beaver>();
		al.add(new Beaver("비버", 3, 50.5, 10.1));
		al.add(new Beaver("비붜", 2, 40.4, 9.9));
		al.add(new Beaver("빕어", 5, 30.3, 6.6));
		al.add(new Beaver("빕워", 1, 10.1, 3.3));
		req.setAttribute("al", al);
		
		
	}
}
