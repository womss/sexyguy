package com.beaver.jan2211.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSPGameEngine {
//	int ran;
	
//	Random r = new Random();
	int ran = 0;
	
////////////////////////////////
	private int t;
	private int winn;
	private int draww;
	private int losee;
	
	private static final RSPGameEngine RGE = new RSPGameEngine();
	
	private RSPGameEngine() { // <= public을 private로 바꿔줌
		// TODO Auto-generated constructor stub
	}
	
	// Controller에서 사용하기 위한 getter (public)
	public static RSPGameEngine getRge() {
		return RGE;
	}

	public void doRSP(HttpServletRequest request) {
		int userHand = Integer.parseInt(request.getParameter("userHand"));
		request.setAttribute("uh", userHand + ".JPG"); // 이미지 처리할것 까지 지정했고
		
		int comHand = new Random().nextInt(3)+1;
		request.setAttribute("ch", comHand + ".jpg");
		
		// 판정
		int result = userHand - comHand;
		if (result == 0) {
			request.setAttribute("r", "무");
			draww++;
			t++;
		}	else if (result == -1 || result == 2) {
			losee++;
			t++;
		}	else {
			winn++;
			t++;
		}
		
		request.setAttribute("t", t + "전");
		request.setAttribute("w", winn + "승");
		request.setAttribute("d", draww + "무");
		request.setAttribute("l", losee + "패");
		
	}
	
	// 초기화
	public void reset(HttpServletRequest request) {
		t = 0;
		winn = 0;
		draww = 0;
		losee = 0;
		request.setAttribute("r", "전적 초기화 완료 !");
	}
	
	
}
