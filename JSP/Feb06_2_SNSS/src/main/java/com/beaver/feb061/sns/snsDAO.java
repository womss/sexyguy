package com.beaver.feb061.sns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.db.manager.BeaverDBManager;



public class snsDAO {
	private int allMemberCount;
	// HomeController에서 시작
	// SNS.jsp로
	// 
	private static final snsDAO snsDAO = new snsDAO();
	public snsDAO() {
		// TODO Auto-generated constructor stub
	}
	public static snsDAO getSnsdao() {
		return snsDAO;
	}
	
	public void getAllMembers(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BeaverDBManager.connect("sexy");
			
			// sql문 작성
			String sql = "select * from feb03_apple order by a_price";
			pstmt = con.prepareStatement(sql);
			
			// C / U / D : pstmt.executeUpdate()로 실행 (인서트 / 업데이트 / 딜리트)
			//		=> 데이터 몇 개 영향을 받았는지 리턴 했었다
			// R : pstmt.executeQuery()로 실행
			//		=> select결과를 ResultSet으로 보냄
			rs = pstmt.executeQuery();
			
			ArrayList<Member> members = new ArrayList<Member>();
			Member member = null;
			while (rs.next()) {
				member = new Member(); // 이거 뭐지
				member.setId(rs.getString("id")); // "db 컬럼명"
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setBirth(rs.getDate("birth"));	// (rs.getString("birth"));
				members.add(member);
			}
			req.setAttribute("members", members);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BeaverDBManager.close(con, pstmt, rs);
	}
		
	
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		try {
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");					// pw파라미터 받고
			
			if (id.equals("헬") && pw.equals("me")) {			// 아이디와 비번이 같다면
				Member m = new Member(id, pw, pw, pw, pw, pw);
				req.getSession().setAttribute("m", m);			// Member값을 m에 담고
				req.getSession().setMaxInactiveInterval(600);	// 로그인 유지시간을 1시간
			}
			
			Cookie c = new Cookie("lastLoginId", id);
			c.setMaxAge(600);	// 쿠키의 유지시간 10분 // 그리고 응답 객체에 쿠키를 추가 해야함 public static void login(HttpServletRequest req, "HttpServletResponse res")
			res.addCookie(c);	// 응답 객체에 방금만든 쿠키를 추가
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 등록하기
//	public void reg(HttpServletRequest req) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			con = BeaverDBManager.connect("sexy");
//			
//			// 데이터 입력 한거 받아올수 있어야겠어요
//			req.setCharacterEncoding("UTF-8");
//			String id = req.getParameter("id");
//			String pw = req.getParameter("pw");
//			String name = req.getParameter("name");
//			String phone = req.getParameter("phone");
//			Date birth = Date.parse(req.getParameter("birth"));
//			int price = Integer.parseInt(req.getParameter("a_price"));
//			
//			// <textArea>에서 엔터친거 : \r\n
//			// 웹페이지에서 줄바꾸기 : <br>
//			
//			// sql문 작성
//			String sql = "insert into feb06_member values(?, ?, ?, ?, ?)";
//			
//			// DB관련 총괄매니저
//			pstmt = con.prepareStatement(sql);
//			
//			// sql 완성 (빵꾸난자리 메꾸기 => ?, ?, ?...)
//			pstmt.setString(1, location);
//			pstmt.setString(2, color);
//			pstmt.setString(3, flavor);
//			pstmt.setInt(4, price);
//			pstmt.setString(5, introduce);
//			
//			// 실행 + 결과처리 같이 진행
//			// 영향을 받은게 하나라면
//			if (pstmt.executeUpdate() == 1) {
//				req.setAttribute("r", "[등록 성공]");
//				allAppleCount++; // 새로 등록하는 자료는 바로 등록이 안되는데 이걸 해줘야 개수도 올라가고 반영도 됨
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			req.setAttribute("r", "[등록 실패]");
//		}
//		BeaverDBManager.close(con, pstmt, null);
//		
//		// 애플배열이 다섯개 이상(한페이지초과분)이면
//		// 배열(5개로 가정) 나누기 4 = 1 + 1(기존페이지)
//		// 2페이지 생성
//		// 배열이 4개면 생성x
//		// 배열이 9개면 9/4
//	}
//	
	public void countMembers() {
		//디비연결
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 트라이문 안에서 디비연결
			con = BeaverDBManager.connect("sexy");
			String sql = "select count(*) from feb06_member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 쿼리문 어쩌구
			// 값을 하나하나 꺼낼 필요는 없을것 같다
			rs.next();
			// 단일 결과값을 가져오는데 / 전역변수에 담아낸다
			allMemberCount = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

		
}
	

		
		