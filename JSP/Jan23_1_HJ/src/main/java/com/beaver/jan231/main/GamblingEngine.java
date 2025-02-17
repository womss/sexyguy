package com.beaver.jan231.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class GamblingEngine {
	private int coin;
	private int c;
	private int win;
	private int lose;
	private String pp;
	
	private static final GamblingEngine GBE = new GamblingEngine();
	
	public GamblingEngine() {
		// TODO Auto-generated constructor stub
	}
	
	// Controller에서 사용하기 위한 getter (public)
	public static GamblingEngine getRge() {
		return GBE;
	}
	
	public void doGBE(HttpServletRequest request) {
		int userHand = Integer.parseInt(request.getParameter("userHand"));
		if (userHand == 1) {
			request.setAttribute("uu","ghf.png"); // 이미지 처리할것 까지 지정했고
		} else {
			request.setAttribute("uu","Wkr.jpg"); // 이미지 처리할것 까지 지정했고
		}
//		String comHand = (coin % 2 == 0) ? "짝" : "홀";
//		request.setAttribute("r", "gameAns");
//		
		
		
		int comHand = new Random().nextInt(10)+1;
		if (comHand % 2 == 0) {
			request.setAttribute("cc","Wkr.jpg");
		} else {
			request.setAttribute("cc","ghf.png");
		}
		
		
		if (comHand % 2 == userHand % 2) {
			request.setAttribute("uc","win.gif");
			win++;
			c++;
		} else {
			request.setAttribute("uc","lose.gif");
			lose++;
			c++;                                                                                                                                                                                                                                                                                                               
		}
		
		// 판정
		request.setAttribute("comHand", comHand +"개");
		request.setAttribute("c", c + "전");
		request.setAttribute("w", win + "승");
		request.setAttribute("l", lose + "패");
		double p = (win / (double) c) * 100;
		pp = String.format("%.2f", p);
		request.setAttribute("p", "승률 : " + pp + "%)");
	}
	
	// 초기화
	public void reset(HttpServletRequest request) {
		c = 0;
		win = 0;
		lose = 0;
		pp = "0";
		request.setAttribute("c", c + "전");
		request.setAttribute("w", win + "승");
		request.setAttribute("l", lose + "패");
		request.setAttribute("p", "승률 : " + pp + "%)");
		request.setAttribute("r", "전적 초기화 완료 !");
	}
	
	
	
	
	
	
}
