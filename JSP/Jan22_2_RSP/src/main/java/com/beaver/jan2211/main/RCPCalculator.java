package com.beaver.jan2211.main;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;


public class RCPCalculator {
	public static void calculator(HttpServletRequest request) {
		String choice = request.getParameter("choice");					// 유저가 선택한 패 가져오기
		int usernum = Integer.parseInt(request.getParameter("choice"));	// 패 숫자로 변환
		
		Random ran = new Random();										// 랜덤
		int comnum = ran.nextInt(3)+1;									// AI 랜덤 숫자 등록
		
		int win = 0;
		int draw = 0;
		int lose = 0;
		int p1 = 0;
		
		if ((usernum-comnum == -2) || (usernum-comnum == 1)) {			// 이겼을 경우 win 하나 카운트업
			win += 1;
			p1 = 4;
		} else if (usernum-comnum == 0) {								// 비겼을 경우 draw 하나 카운트업
			draw += 1;
			p1 = 5;
		} else {														// 졌을 경우?
			lose += 1;
			p1 = 6;
		}
		request.setAttribute("usernum", usernum);	// 유저가 뽑은 카드
		request.setAttribute("comnum", comnum);		// AI가 뽑은 카드
		request.setAttribute("win", win);			// 이긴 횟수
		request.setAttribute("draw", draw);			// 비긴 횟수
		request.setAttribute("lose", lose);			// 진 횟수
		request.setAttribute("p1", p1);			// 결과 사진
	}
}
