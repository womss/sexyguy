package com.beaver.feb062.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

// 이걸 만들어두지 않으면 새로고침을 할 때마다 같은 글이 추가로 생성됨
//		내가 쓴 글이 새로고침해도 그대로 있을 수 있도록 하기 위해
public class TokenManager {
	public static void make(HttpServletRequest request) {
		Date now = new Date();											// 현재 시간을 가져옴
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SS");		// 시간을 시 : 분 : 초 : 밀리초 형식으로 변환
		request.setAttribute("generatedToken", sdf.format(now));		// 변환한 시간을 generatedToken에 저장
																		// generatedToken는 함수를 실행했을(게시물을 작성했을) 당시의 시간을 가져오는 요청(request) 속성(Attribute)
	}
}
