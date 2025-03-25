package com.beaver.feb062.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.db.manager.BeaverDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {

	// 회원가입
	public static void signUp(HttpServletRequest req) {
		// 일단 파일업로드 시도
		String path = null;
		MultipartRequest mr = null;
		
		try {
			path = req.getServletContext().getRealPath("img");
			System.out.println(path);
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024,
					"UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) { // 파일 업로드 실패의 경우
			e.printStackTrace();
			req.setAttribute("r", "회원가입 실패(사진파일 용량)");
			return; // 업로드에 실패하면 뒤에 남은 DB작업
					// 	은 하지 말자 (강제 종료)
		}
		
		// 파일 업로드 성공시에 계속 진행
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			String id = mr.getParameter("m_id");
			String pw = mr.getParameter("m_pw");
			String name = mr.getParameter("m_name");
			String phone = mr.getParameter("m_phone");
			
			String y = mr.getParameter("m_y");
			int m = Integer.parseInt(mr.getParameter("m_m"));
			int d = Integer.parseInt(mr.getParameter("m_d"));
			String birthday = String.format("%s%02d%02d", y, m, d);
			
			String photo = mr.getFilesystemName("m_photo");
			photo = URLEncoder.encode(photo, "UTF-8").replace("+", " ");
			
			String sql = "insert into feb06_sns values( "
					+ "?, ?, ?, ?, to_date(?, 'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, birthday);
			pstmt.setString(6, photo);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "회원가입 성공");
			}
		} catch (Exception e) { // ID중복, DB연결상태가 :p
			e.printStackTrace();
			// DB쪽 문제로 가입은 실패지만,
			// 사진파일이 업로드는 되어있는 상태
			// 사진파일 지워줘야(Java로)
			File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
			f.delete();
			req.setAttribute("r", "회원가입 실패(DB서버)");
		}
		BeaverDBManager.close(con, pstmt, null);
	}
	
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("m_id");
			String pw = req.getParameter("m_pw");
			
			// String sql = "select * from feb06_sns";
			// String sql = "select * from feb06_sns
			//					where m_id=? and m_pw=?";
			// 해킹기법 - SQL Injection
			//		보안상 취약점을 이용해서
			//		데이터베이스가 비정상적인 동작을 하게 하는 기법
			
			String sql = "select * from feb06_sns where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 데이터가 있는지 + 그 데이터를 가리키게
				String dbPw = rs.getString("m_pw");
				if (dbPw.equals(pw)) {
					Member m = new Member(
							rs.getString("m_id"), dbPw, rs.getString("m_name"),
							rs.getString("m_phone"), rs.getDate("m_birthday"),
							URLDecoder.decode(rs.getString("m_photo"), "UTF-8"));
					req.getSession().setAttribute("loginMember", m);
					req.getSession().setMaxInactiveInterval(600);
					
					Cookie c= new Cookie("lastLoginId", id);
					c.setMaxAge(60 * 60 * 24 * 5);
					res.addCookie(c);
					req.setAttribute("r", "로그인성공");
				} else {
					req.setAttribute("r", "로그인실패(PW오류)");
				}
			} else {
				req.setAttribute("r", "로그인실패(미가입ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그인실패(DB서버)");
		}
		BeaverDBManager.close(con, pstmt, rs);
	}
	
	// 로그인상태 확인
	public static boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");	// 요청(req)에서 세션(HttpSession) 객체를 가져오고 세션에서 "loginMember"이라는 속성(객체)을 가져옴
		
		if (m != null) { // 로그인 정보가 있다면 이니까
			// 로그인 성공 or 상태 유지시
			req.setAttribute("lp", "member/welcome.jsp");
			return true;
		}
		// 로그인상태가 아니거나 로그인 실패시
		req.setAttribute("lp", "member/login.jsp");
		return false;
	}
	
	// 로그아웃
	public static void logout(HttpServletRequest req) {
		// 세션 끊기 : 다른 세션값들도 같이 끊어지기에 비추
		// req.getSession().setMaxInactiveInterval(-1);
		
		// Member에 대한 session만 null로 바꿔주면...
		req.getSession().setAttribute("loginMember", null);
		req.setAttribute("r", "로그아웃 성공");
	}
	
	// 정보 수정
	public static void update(HttpServletRequest req) {
		// 파일 업로드 실패하면 => 거기서 땡!
		String path = null;
		MultipartRequest mr = null;
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String old_m_photo = m.getM_photo();
		String new_m_photo = null;
		
		try {
			path = req.getServletContext().getRealPath("img");
			System.out.println(path);
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024,
					"UTF-8", new DefaultFileRenamePolicy());
			
			new_m_photo = mr.getFilesystemName("m_photo"); // 선택한 파일명
			if (new_m_photo != null) {	// 이 있으면(새로운 파일을 넣었으면)
				new_m_photo = URLEncoder.encode(new_m_photo, "UTF-8").replace("+", " ");
			} else { // 이 없으면 (새로운 파일을 안넣었으면)
				new_m_photo = old_m_photo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일용량...");
			return;
		}
		
		// 여기까지 진행하는데 별일 없었다
		
		// 파일 크기가 10MB보다 적은걸로 잘 선택해서 - 파일업로드 성공
		// 파일 선택 안해서(0MB)
		
		// 파일 선택을 했다 : 프사 바꾸겠다
		//		=> 새 프사 파일명을 DB에 넣어야
		//		=> 새 프사 파일명을 확보
		//		+ 기존 프사 파일 삭제도 해야 
		//		=> 원래 프사 파일명을 확보
		
		// 파일 선택을 안하면 : 프사는 안바꾸겠다
		//		=> 기존 프사 파일명을 DB에 넣어야
		//		=> 원래 프사 파일명을 확보
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			String m_id = mr.getParameter("m_id");
			String m_pw = mr.getParameter("m_pw");
			String m_name = mr.getParameter("m_name");
			String m_phone = mr.getParameter("m_phone");
			
			String m_y = mr.getParameter("m_y");
			int m_m = Integer.parseInt(mr.getParameter("m_m"));
			int m_d = Integer.parseInt(mr.getParameter("m_d"));
			String m_birthday = String.format("%s%02d%02d", m_y, m_m, m_d); 
			
			String sql = "update feb06_sns set m_pw=?, m_name=?, m_phone=?, "
					+ "m_birthday=to_date(?, 'YYYYMMDD'), m_photo=? "
					+ "where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_pw);
			pstmt.setString(2, m_name);
			pstmt.setString(3, m_phone);
			pstmt.setString(4, m_birthday);
			pstmt.setString(5, new_m_photo);
			pstmt.setString(6, m_id);
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "정보수정 성공");
				
				if (!new_m_photo.equals(old_m_photo)) { // 프사를 바꿨으면
					new File(path + "/" + URLDecoder.decode(old_m_photo, "UTF-8")).delete();
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				m = new Member(m_id, m_pw, m_name, m_phone,
						sdf.parse(m_birthday), 
						URLDecoder.decode(new_m_photo, "UTF-8"));
				req.getSession().setAttribute("loginMember", m);
			} else {
				req.setAttribute("r", "정보수정 실패");
				if (!new_m_photo.equals(old_m_photo)) { 
					new File(path + "/" + URLDecoder.decode(new_m_photo, "UTF-8")).delete();
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "정보수정 실패(DB문제)");
			try {
				if (!new_m_photo.equals(old_m_photo)) { 
					new File(path + "/" + URLDecoder.decode(new_m_photo, "UTF-8")).delete();
				}						
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		BeaverDBManager.close(con, pstmt, null);
	}

	
	// 회원 탈퇴
	public static void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String m_id = m.getM_id();
			
			String sql = "delete feb06_sns where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "회원탈퇴 성공");
				// DB에서 데이터는 지웠음
				// 그 사람이 사용한 프사 => 지워야!
				String m_photo = m.getM_photo();
				m_photo = URLDecoder.decode(m_photo, "UTF-8");
				String path = req.getServletContext().getRealPath("img");
				File f = new File(path + "/" + m_photo);
				f.delete();
				req.getSession().setAttribute("loginMember", null);
			} else {
				req.setAttribute("r", "이미 탈퇴처리됨");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "탈퇴실패(DB서버)");
		}
		BeaverDBManager.close(con, pstmt, null);
	}
	
	
	
	
	
	
	
}


















