package com.beaver.franc.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.beaver.db.manager.BeaverDBManager;
import com.beaver.franc.Reservation.Reservation;
import com.beaver.franc.Restaurant.Restaurant;

// MVC의 C - 프로그램의  실행과 코드의 흐름을 관리
// if (번호 == 1) {
//		ConsolScreen.예약하기기능 (입력)
//		DAO.db예약기능 (insert)
//		결과보여주기 (성공 or 실패)
// }

public class Controller {
	public static void main(String[] args) {
		int menu = 0;
		String result = null;
		Reservation rsv = null;
		Restaurant rst = null;
		ArrayList<Reservation> rsvResult = null;
		ArrayList<Restaurant> rstResult = null;
		
		
		ConsolScreen.showWelcome();
		while (true) {
			try {
				menu = ConsolScreen.showMainMenu();
				if (menu == 9) {
					ConsolScreen.exit();
					break;
				} else if (menu == 1) {
					rsv = ConsolScreen.showRsvMenu();
					result = DAO.book(rsv);
					ConsolScreen.printResult(result);
				} else if (menu == 2) {
					rst = ConsolScreen.showRstMenu();
					result = DAO.registerRst(rst);
					ConsolScreen.printResult(result);
				} else if (menu == 3) {
					rsvResult = DAO.getAllReserve();
					ConsolScreen.showRsvResultMenu(rsvResult);
				} else if (menu == 4) {
					rstResult = DAO.getAllrestaurant();
					ConsolScreen.showRstResultMenu(rstResult);
				} else if (menu == 5) {
					rst = ConsolScreen.showSearchRstMenu();
					rstResult = DAO.searchRestaurant(rst);
					ConsolScreen.showRstResultMenu(rstResult);
				} else if (menu == 6) {
					rsv = ConsolScreen.showSearchRsvMenu();
					rsvResult = DAO.searchReservation(rsv);
					ConsolScreen.showRsvResultMenu(rsvResult);
				} else if (menu == 7) {
					rsvResult = DAO.getAllReserve(); // 서비스 차원에서 예약 수정할 예약표 보여주기
					ConsolScreen.showRsvResultMenu(rsvResult);
					
					rsv = ConsolScreen.showUpdateRsvMenu();
					result = DAO.rsvCorrection(rsv);
					ConsolScreen.printResult(result);
					
					rsvResult = DAO.getAllReserve();				// 예약 완료된 결과표 보여주기
					ConsolScreen.showRsvResultMenu(rsvResult);
					
				} else if (menu == 8) {
					rsvResult = DAO.getAllReserve();
					ConsolScreen.showRsvResultMenu(rsvResult);
					
					rsv = ConsolScreen.cancelReservation();//
					result = DAO.cancelReservation(rsv);
					ConsolScreen.printResult(result);
					
					rsvResult = DAO.getAllReserve();
					ConsolScreen.showRsvResultMenu(rsvResult);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void no1() {
//		// 1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)
//		Scanner k = new Scanner(System.in);
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		
//		System.out.println("예약자 성함 : ");
//		String no1name = k.next();
//		
//		System.out.println("예약 날짜/시간 : ");
//		System.out.println("ex) 2025-01-0112:30");
//		String no1date = k.next();
//		
//		System.out.println("예약자 연락처 : ");
//		String no1phone = k.next();
//		
//		System.out.println("예약 지점 : ");
//		System.out.println("1. 쿠우쿠우");
//		System.out.println("2. 명륜진사갈비");
//		System.out.println("3. 메이찬");
//		int no1market = k.nextInt();
//				
//		try {
//			String addr = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
//			con = DriverManager.getConnection(addr, "sexy", "guy");
//			
//			String sql1 = "insert into booking "
//					+ "values(booking_seq.nextval, ?, TO_DATE(?, 'YYYY-MM-DD HH24:MI'),? ,?)";
//			pstmt = con.prepareStatement(sql1);
//			pstmt.setString(1, no1name);
//			pstmt.setString(2, no1date);
//			pstmt.setString(3, no1phone);
//			pstmt.setInt(4, no1market);
//			if (pstmt.executeUpdate() >= 1) {
//				System.out.println(" 성공 !");
//			} else {
//				System.out.println("그런 매장은 없습니다~");
//			}	
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		5
//		try {
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	public static void no2() {
////		 2. 매장 등록(지점명, 지점장, 좌석수)
//		Scanner k = new Scanner(System.in);
//		System.out.println("등록할 매장명 입력 :");
//		String no2name = k.next();
//		System.out.println("지점장 입력 :");
//		String no2ceo = k.next();
//		System.out.println("매장 좌석 입력 :");
//		int no2seat = k.nextInt();
//		
//		 String no = "insert into market values(market_seq.nextval, ?, ?, ?)";
//		 Connection con = null;
//		PreparedStatement pstmt = null;
//	try {
//		String addr = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
//		con = DriverManager.getConnection(addr, "sexy", "guy");
//		
//		String sql1 = "insert into market "
//				+ "values(market_seq.nextval, ?, ? ,?)";
//		pstmt = con.prepareStatement(sql1);
//		pstmt.setString(1, no2name);
//		pstmt.setString(2, no2ceo);
//		pstmt.setInt(3, no2seat);
//		if (pstmt.executeUpdate() == 1) {
//			System.out.println(" 성공 !");
//		} else {
//			System.out.println("그런 매장은 없습니다~");
//		}
//	}catch (Exception e) {
//		e.printStackTrace();
//	}
//	}
//	public static void no3() {
////		3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분)	
//		Scanner k = new Scanner(System.in);
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			String addr = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
//			con = DriverManager.getConnection(addr, "sexy", "guy");
//			
//			String sql1 = "select * from booking";
//			pstmt = con.prepareStatement(sql1);
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//			    String bookingDate = rs.getString("b_date"); // 예약 날짜
//			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
//			       Date utilDate = null;
//			       utilDate = sdf.parse(utilDate);
//			       java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//			    System.out.println("전체 예약 날짜: " + bookingDate);
//				System.out.println("---------------------------");
//				
//				System.out.println(" 전체 예약 조회 !");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	
//		
//	}
////	public static void main(String[] args) {
////		no3();
////	}
//}
