package com.beaver.feb031.apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.beaver.db.manager.BeaverDBManager;

public class AppleDAO {
	private int allAppleCount;
	
	// 나중에 기능하나 활용할걸 생각해서
	// 만들어 놓은걸 불러와서 활용
	private static final AppleDAO APPLEDAO = new AppleDAO();
	public AppleDAO() {
		// TODO Auto-generated constructor stub
	}

	public static AppleDAO getAppledao() {
		return APPLEDAO;
	}	
	
	// 모든 사과 데이터 다 가져오기 // 클라이언트로부터 요청이 들어왔을때 동작하게 한다 (HttpServletRequest req)
	public void getAllApples(HttpServletRequest req) {
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
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//			ArrayList<Integer> pages = new ArrayList<Integer>();
//			
//			int page = 0;
//			 if (apples.size() >= 5) { // 5개 이상일 때만 페이지 계산
//		            page = (apples.size() % 4 == 0) ? (apples.size() / 4) : (apples.size() / 4) + 1;
//		            for (int i = 1; i <= page; i++) {
//		                pages.add(i); // 페이지 리스트에 추가
//		            }
//		        }
//			 req.removeAttribute("p");
			
			
			
			
//			if (apples.size() >= 5) { // 5개 이상일 때만 페이지 계산
//				if (apples.size() >= 5 && apples.size() % 4 == 0) { // 4의 배수일때 처리
//					page = apples.size() / 4;
//					for (int i = 1; i <= page; i++) {
//						pages.add(i);
//						req.setAttribute("p", page);
//					}
//				} else { // 5개는 넘지만 4의 배수가 아니라면 나머지 페이지 부분 +1처리
//					page = (apples.size() / 4) + 1;
//					for (int i = 1; i <= page; i++) {
//						req.setAttribute("p", i);
//					}
//				}
//			}
//				else { // 5개를 안넘을 때는 페이지를 지워 깔끔히
//					req.removeAttribute("p");
//				}
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			Apple apple = null;
			while (rs.next()) {
				apple = new Apple(); // 이거 뭐지
				apple.setA_location(rs.getString("a_location")); // "db 컬럼명"
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_info(rs.getString("a_info"));
				apples.add(apple);
			}
			req.setAttribute("apples", apples);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BeaverDBManager.close(con, pstmt, rs);
	}

	// 등록하기
	public void reg(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = BeaverDBManager.connect("sexy");
			
			// 데이터 입력 한거 받아올수 있어야겠어요
			req.setCharacterEncoding("UTF-8");
			String location = req.getParameter("a_location");
			String color = req.getParameter("a_color");
			String flavor = req.getParameter("a_flavor");
			int price = Integer.parseInt(req.getParameter("a_price"));
			
			// <textArea>에서 엔터친거 : \r\n
			// 웹페이지에서 줄바꾸기 : <br>
			String introduce = req.getParameter("a_info").replace("\r\n", "<br>");
			
			// sql문 작성
			String sql = "insert into feb03_apple values(?, ?, ?, ?, ?)";
			
			// DB관련 총괄매니저
			pstmt = con.prepareStatement(sql);
			
			// sql 완성 (빵꾸난자리 메꾸기 => ?, ?, ?...)
			pstmt.setString(1, location);
			pstmt.setString(2, color);
			pstmt.setString(3, flavor);
			pstmt.setInt(4, price);
			pstmt.setString(5, introduce);
			
			// 실행 + 결과처리 같이 진행
			// 영향을 받은게 하나라면
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "[등록 성공]");
				allAppleCount++; // 새로 등록하는 자료는 바로 등록이 안되는데 이걸 해줘야 개수도 올라가고 반영도 됨
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "[등록 실패]");
		}
		BeaverDBManager.close(con, pstmt, null);
		
		// 애플배열이 다섯개 이상(한페이지초과분)이면
		// 배열(5개로 가정) 나누기 4 = 1 + 1(기존페이지)
		// 2페이지 생성
		// 배열이 4개면 생성x
		// 배열이 9개면 9/4
	}
	
	// 데이터가 총 몇개인지 구하는 메소드 하나
	public void countApples() {
		//디비연결
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 트라이문 안에서 디비연결
			con = BeaverDBManager.connect("sexy");
			String sql = "select count(*) from feb03_apple";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 쿼리문 어쩌구
			// 값을 하나하나 꺼낼 필요는 없을것 같다
			rs.next();
			// 단일 결과값을 가져오는데 / 전역변수에 담아낸다
			allAppleCount = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// DB에 데이터가 100개 있다 ?
	//	=> 해당 페이지 번호에 맞는 데이터만 가져오는 메소드 하나
	public void getApples(int pageNo, HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BeaverDBManager.connect("sexy");
			
			// SQL 수행하는데 필요한 값 챙기기
			
			// allAppleCount : 전체 사과 데이터 수
			int applePerPage = 4; // 한 페이지당 보여줄 사과 데이터 수
			
			// 페이지 수 구하기
			// Math.ceil : 숫자 올림 (반올림 X)
			int pageCount = (int) Math.ceil(allAppleCount / (double) applePerPage); // 올림처리 후 (double)로 인해 결과가 0.0 하지만 페이지 카운트는 정수형 그래서 맨 앞에 정수 처리
			req.setAttribute("pageCount", pageCount);
			/////////////////////////////////////////////////////////////////////////////////
			
			String sql = "select * from ( "
					+ "select rownum as rn, a_location, a_color, "
					+ "a_flavor, a_price, a_info "
					+ "from ( "
					+ 	"select * "
					+ 	"from feb03_apple "
					+ 	"order by a_price "
					+ 	") "
					+ ") "
					+ "where rn >= ? and rn <= ?";
			// 시작점과 끝점은 공식처럼 생각
			int start = (applePerPage * (pageNo - 1)) + 1;
			int end = (pageNo == pageCount) ? allAppleCount : (start + applePerPage - 1);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;
			while (rs.next()) {
				apple = new Apple(); // 이거 뭐지
				apple.setA_location(rs.getString("a_location")); //
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_info(rs.getString("a_info"));
				apples.add(apple);
			}
			req.setAttribute("apples", apples);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BeaverDBManager.close(con, pstmt, rs);
	}
	// 상세정보 가져오기 (프라이머리 키)
	// 제대로 데이터를 가져왔으면 : true
	// 실패했으면 : false
	public boolean getAppleDetail(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = BeaverDBManager.connect("sexy");
			
			String location = req.getParameter("a_location");
			
			String sql = "select * from feb03_apple where a_location = ?";
			// 총괄매니저
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery(); // 이거 뭐지
			
			if (rs.next()) {
				Apple apple = new Apple();
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_info(rs.getString("a_info"));
				req.setAttribute("apple", apple); // "apple" 이게 ${apple.a_location} 여기의 애플
				return true; // 일반적인 상황 : 데이터가 하나		// 여기선 왜 리턴 트루인지
				
			}
			return false; // ex) 다른 사람이 그 데이터를 지웠으면 : 데이터 없음
		} catch (Exception e) {
			e.printStackTrace();
			return false; // DB서버 상태가 안좋음 (ex: 서버가 안켜짐)
		} finally {
			BeaverDBManager.close(con, pstmt, rs);
		}
	}

	// 수정
	public boolean update(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null; 이건 빠졌네 왜?
		
		try {
			con = BeaverDBManager.connect("sexy");
			// 포스트 방식일테니까 인코딩도 맞춰주겠습니다
			req.setCharacterEncoding("UTF-8");
			
			String location = req.getParameter("a_location");
			String color = req.getParameter("a_color");
			String flavor = req.getParameter("a_flavor");
			int price = Integer.parseInt(req.getParameter("a_price"));
			String introduce = req.getParameter("a_info");
			
			String sql = "update feb03_apple set "
					+ "a_color = ?, a_flavor = ?, a_price = ?, "
					+ "a_info = ? where a_location = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, color);
			pstmt.setString(2, flavor);
			pstmt.setInt(3, price);
			pstmt.setString(4, introduce);
			pstmt.setString(5, location);
					
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "[수정성공]");
				return true;
			} else { // 수정중에 삭제할 경우 그냥 실패로
				req.setAttribute("r", "[수정실패]");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "[수정실패]");
			return false;
		} finally {
			BeaverDBManager.close(con, pstmt, null);
		}
	}
	
	// 삭제
	public void delete(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		
		try {
			con = BeaverDBManager.connect("sexy");
			
			// 내용을 요청파라미터로 받아온다
			String location = req.getParameter("a_location");
			// sql문 작성 delete문
			String sql = "delete from feb03_apple where a_location = ? ";
			
			// 총괄매니저 sql문 수행하게끔
			pstmt = con.prepareStatement(sql);
			
			// 빵꾸 채우기
			pstmt.setString(1, location);
//			rs = pstmt.executeQuery();
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "[삭제완료]");
				allAppleCount--;
			} else {
				req.setAttribute("r", "[삭제실패]");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "[최종삭제실패]");
			
		} finally {
			BeaverDBManager.close(con, pstmt, null);
		}
	}
		
		
		
		
		
		
	
	
	
	
	
	
	
}
























