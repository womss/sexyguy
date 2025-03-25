package com.beaver.feb061.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	
	// 로그인 기능
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");					// pw파라미터 받고
			
			// 로그인 성공한 유저 정보
			//		사이트 어디서든지 사용 가능
			//		일정시간이 지나면 로그인 상태 풀리게
			//		session 소속의 attribute or cookie
			//		cookie는 위험!!
			if (id.equals("헬프") && pw.equals("me")) {			// 아이디와 비번이 같다면
				Member m = new Member(id, pw);
				req.getSession().setAttribute("m", m);			// Member값을 m에 담고
				req.getSession().setMaxInactiveInterval(10);	// 로그인 유지시간을 10초로
			}
			
			// 한번 로그인에 성공했으면,
			//	다음에 이 사이트에 들어왔을 때
			//	<input>에 id가 남아있었으면 좋겠다...
			//	로그인 혹은 사이트에 대한 접속을 끊어도, 재부팅해도 남아있는 것
			//		=> Cookie !
			
			Cookie c = new Cookie("lastLoginId", id);
			c.setMaxAge(600);	// 쿠키의 유지시간 10분 // 그리고 응답 객체에 쿠키를 추가 해야함 public static void login(HttpServletRequest req, "HttpServletResponse res")
			res.addCookie(c);	// 응답 객체에 방금만든 쿠키를 추가
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 페이지를 여기저기 다닐건데...
	//	로그인이 되어있는지 확인이 되어야겠음 !
	public static boolean loginCheck(HttpServletRequest req) { // 아 받아오는건 req고 보내는건 res였네
		Member m = (Member) req.getSession().getAttribute("m"); // m이란 녀석이 있는지 확인해봄
		// 로그인이 유지중이거나 로그인에 성공했다면(23번줄에 대한 
		//		45번줄의 attribute m의 값이 존재할 것!
		// 로그인상태가 아니라면
		//		45번줄의 attribute m의 값은 (로그인 시도 자체도 안했을테니 21번의 이프문이 안돌아감으로)null값이 나옴
		return (m != null); // 고로 로그인을 했을때만 트루값을 반환
		
	}
	
	
	
	
	
	
	
	
}






































