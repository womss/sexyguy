import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class BaseballEngine {	// 최초로 만들어진 1
	private int userNum;	// u
	private int count;
	private String cn = pickNum(); // pickNum에서 나온 리턴값을 고정값으로 cn에 넣겠다
	
	private static final BaseballEngine BBE = new BaseballEngine(); // 생성자가 없으면 안된다? 질문하기	// 새로 만들어 놓은 2
	
	public BaseballEngine() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static BaseballEngine getBBE() {
		return BBE;	//BBE를 리턴함으로써 전역변수에 있는 BBE를 통해 doBBE를불러올 수 있는건지 질문하기
	}
	public static String pickNum() { // 중복되지 않는 수 뽑음
		int comNum = new Random().nextInt(976)+12;
		String cn = String.format("%03d", comNum);
		
		if (cn.charAt(0) == cn.charAt(1) || cn.charAt(0) == cn.charAt(2) || cn.charAt(1) == cn.charAt(2)) {
			return pickNum();
		}
		return cn;
	}
	
	public void doBBE(HttpServletRequest request) { // 수 비교
		int strike = 0;
		int ball = 0;
		String input = request.getParameter("input");
		for (int i = 0; i < 3; i++) {	// 0 1 2
			for (int j = 0; j < 3; j++) { // 012 012 012
				if (i==j) { // 자릿수 첫번째 끼리 검사
					if (cn.charAt(i)== input.charAt(j) ) { // 값 컴486 사람 146 
						strike++;
					}
				} else if (i!=j) { // 첫번째가 아닌것끼리 검사하겠다
					if (cn.charAt(i)== input.charAt(j) ) { // 값 컴486 사람 146 
						ball++;
					}
				}
			}
		}
		count++;
		String done = "";
		if (strike == 3) {
			done = "정답입니다 !";
		}
		request.setAttribute("done", done); 
		
//		userNum = Integer.parseInt(request.getParameter("answer"));
		request.setAttribute("cn", cn); 
//		int comHand = new Random().nextInt(976)+12;
//		request.setAttribute("c", comNum);
//		int u100 = userNum / 100; // 4
//		if (cn.charAt(0)== request.
//		int u10 = (userNum / 10) % 10; // 5
//		int u1 = userNum % 10; // 2
//		
//		int c100 = comNum / 100; // 4
//		int c10 = (comNum / 10) % 10; // 5
//		int c1 = comNum % 10; // 2
		
		
//		if (u100 == c100) {
//			strike += 1;
//			count++;
//		} else if (u10 == c10) {
//			strike += 1;
//			count++;
//		} else if (u1 == c1) {
//			strike += 1;
//			count++;
//		} else if (u100 == c10 || u100 == c1) {
//			ball += 1;
//			count++;
//		} else if (u10 == c100 || u10 == c1) {
//			ball += 1;
//			count++;
//		} else if (u1 == c100 || u1 == c10) {
//			ball += 1;
//			count++;
//		}
		
		
		request.setAttribute("u", input+"!"); // 452 
		request.setAttribute("cc", count + "회");
		request.setAttribute("s", strike + "스트라이크");
		request.setAttribute("b", ball + "볼");
		
	}
	public void reset(HttpServletRequest request) {
		count = 0;
		int strike = 0;
		int ball = 0;
		cn = pickNum();
		request.setAttribute("cc", count + "회");
		request.setAttribute("s", strike + "스트라이크");
		request.setAttribute("b", ball + "볼");
		request.setAttribute("r", "전적 초기화 완료 !");
	}
}
