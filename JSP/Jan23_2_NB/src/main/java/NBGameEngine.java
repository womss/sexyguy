import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class NBGameEngine {
	private int t;
	private String ans;
	
	private static final NBGameEngine NGE = new NBGameEngine();
	
	public NBGameEngine() {
		// TODO Auto-generated constructor stub
	}

	public static NBGameEngine getNge() {
		return NGE;
	}
	
	public void pickAns() { 
		int a = new Random().nextInt(976)+12;
		String ans = String.format("%03d", a);
		
		if (ans.charAt(0) == ans.charAt(1)
			|| ans.charAt(0) == ans.charAt(2)
			|| ans.charAt(1) == ans.charAt(2)) {
//			return pickAns();위랑 이거랑 뭔차이지
			pickAns(); 
			return;
			
		}
//		return ans; 뭔차이
		this.ans = ans;
	}
	
	public void doNB(HttpServletRequest request) {
		System.out.println(ans);
		String userAns = request.getParameter("userAns");
		request.setAttribute("ua", "유저의 답 :" + userAns);
		
		int strike = 0;
		int ball = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (userAns.charAt(i) == ans.charAt(j)) {
					if (i == j) {
						strike++;
					} else {
						ball++;
					}
				}
			}
		}
		t++;
		request.setAttribute("t", t + "번째 시도 !");
		request.setAttribute("s", "S + " + strike);
		request.setAttribute("b", "B + " + ball);
		
		if (strike == 3) {
			String result = "정답 ! " + ans + " 이었습니다 !";
			t = 0;
			request.setAttribute("r", result);
			request.setAttribute("ua", null);
			request.setAttribute("s", null);
			request.setAttribute("h", null);
			request.setAttribute("btn", "<button onclick='goHome();'>다시시작</button>");
			request.setAttribute("con", "<script>alert('ㅊㅊ!');</script>");
			request.setAttribute("call", "<img src='css/call.gif'>");
		}
		
	}
	
	
	
}

































