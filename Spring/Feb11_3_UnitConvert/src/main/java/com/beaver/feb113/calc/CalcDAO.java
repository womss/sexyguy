package com.beaver.feb113.calc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.beaver.feb113.calc.CalcResult;
import com.beaver.feb113.uc.UCResult;

public class CalcDAO {

	// 내가
	public double calculate(CalcResult cr, HttpServletRequest req) {
		double x = Double.parseDouble(req.getParameter("on"));
		String select = req.getParameter("select");
		req.setAttribute("on", x);

		if (select.equals("inch")) {
			req.setAttribute("ounit", "cm");
			req.setAttribute("nunit", "inch");
			req.setAttribute("nn", x * 0.39370);
			req.setAttribute("color", "red");
			return (double) (x * 0.39370);

		} else if (select.equals("pyeong")) {
			req.setAttribute("ounit", "㎡");
			req.setAttribute("nunit", "pyeong");
			req.setAttribute("nn", x * 0.3025);
			req.setAttribute("color", "green");
			return (double) (x * 0.3025);

		} else if (select.equals("f")) {
			req.setAttribute("ounit", "℃");
			req.setAttribute("nunit", "℉");
			req.setAttribute("nn", (x * 9 / 5) + 32);
			req.setAttribute("color", "blue");
			return (double) ((x * 9 / 5) + 32);

		} else if (select.equals("km")) {
			req.setAttribute("ounit", "mi/h");
			req.setAttribute("nunit", "km/h");
			req.setAttribute("nn", x * 1.609344);
			req.setAttribute("color", "pink");
			return (double) (x * 1.609344);
		}
		return 0;

	}

}
