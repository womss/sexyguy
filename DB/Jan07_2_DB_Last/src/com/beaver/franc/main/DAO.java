package com.beaver.franc.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.beaver.db.manager.BeaverDBManager;
import com.beaver.franc.Reservation.Reservation;
import com.beaver.franc.Restaurant.Restaurant;

// DAO / DTO 패턴
//		MVC패턴의 M
//		DAO (Data Access Object)
//			: M 중에서 DB관련한 작업을 전담하고 있는 클래스
//		DTO (Data Transfer Object)
//			: DAO의 작업결과를 표현하는 클래스 (Reservation / Restaurant)

// java.util.Date - 주력 (Spring에서는 이걸 원함)
// java.sql.Date - JDBC에서는 이걸 원함

// java.util.Date => java.sql.Date
//		: new Date(클래스명.get날짜관련멤버변수명().getTime());

// java.sql.Date => java.util.Date : 알아서 바꿔줌


public class DAO {
	
	// 1. 예약하기
	public static String book(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;		//sql문을 수행할 총괄 매니저
		
		try {
			con = BeaverDBManager.connect();
			String sql = "insert into jan08_reservation "
					+ "values(jan08_reservation_seq.nextval, "
					+ "?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql); // sql을 수행시키는 문구
			pstmt.setString(1, rsv.getName());
			pstmt.setDate(2, new Date(rsv.getWhen().getTime()));
			pstmt.setString(3, rsv.getPhone());
			pstmt.setString(4, rsv.getLocation());
			
			if (pstmt.executeUpdate() == 1) {
				return "예약 성공"; // 1 이게 아닌 경우에도 리턴이 필요함
			}
			return ""; // 1-1 Java문법상 필요해서 억지로 넣은 것!
		} catch (Exception e) {
//			e.printStackTrace();
			return "예약 실패";
		} finally {
			BeaverDBManager.close(con, pstmt, null);
		}
		
	}
	// 2. 매장등록
	public static String registerRst(Restaurant rst) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = BeaverDBManager.connect();
			String sql = "insert into jan08_restaurant values(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rst.getLocation());
			pstmt.setString(2, rst.getOwner());
			pstmt.setInt(3, rst.getSeat());
			
			if (pstmt.executeUpdate() == 1) {
				return "매장 등록 성공";
			}
			return "";
		} catch (Exception e) {
//			e.printStackTrace();
			return "매장 등록 실패";
		} finally {
			BeaverDBManager.close(con, pstmt, null);
		}
	}
	// 3. 전체 예약 확인 (예약번호 오름차순 정렬)
	public static ArrayList<Reservation> getAllReserve() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 쿼리문 사용할거라서 리저트셋도 작성 ★★★알아보기★★★
		
		try {
			con = BeaverDBManager.connect(); // 데이터베이스 서버랑 연결
			String sql = "select * from jan08_reservation order by r_no"; // sql 작성
			pstmt = con.prepareStatement(sql); // sql 수행
			// rs : select문을 수행한 결과
			rs = pstmt.executeQuery(); 
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			Reservation r = null;
			
			while (rs.next()) {
				r = new Reservation();
				// Reservation 클래스의 멤버변수 X !
				// DB의 컬럼명 - O!
				r.setNo(rs.getInt("r_no"));
				r.setName(rs.getString("r_name"));
				r.setWhen(rs.getDate("r_time"));
				r.setPhone(rs.getString("r_phonenum"));
				r.setLocation(rs.getString("r_location"));
				rsvs.add(r);
//				System.out.println("예약 번호 : "+rs.getString("r_no"));
//				System.out.println("예약자 : "+rs.getString("r_name"));
//				System.out.printf("예약 날짜 : "+rs.getDate("r_time"),rs.getTime("r_time")+"\n");
//				System.out.println("예약자 연락처 : "+rs.getString("r_phonenum"));
//				System.out.println("예약 지점 : "+rs.getString("r_location"));
//				System.out.println("---------------------------");
				
			}
			return rsvs;
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		} finally {
			BeaverDBManager.close(con, pstmt, null); // 이거 rs 확인
		}
	}
	// 4. 전체 매장 확인 (지점명 오름차순 정렬)
	public static ArrayList<Restaurant> getAllrestaurant() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BeaverDBManager.connect(); 
			String sql = "select * from jan08_restaurant order by r_location";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Restaurant> rsts = new ArrayList<Restaurant>();
			Restaurant r = null;
			while (rs.next()) {
				r = new Restaurant();
				r.setLocation(rs.getString("r_location"));
				r.setOwner(rs.getString("r_owner"));
				r.setSeat(rs.getInt("r_seat"));
				rsts.add(r);
				
			}
			return rsts;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			BeaverDBManager.close(con, pstmt, rs);
		}
		
	}
	// 5. 매장 찾기 (입력한 좌석 수 이상의 매장, 지점명 오름차순 정렬)
	public static ArrayList<Restaurant> searchRestaurant(Restaurant rst) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BeaverDBManager.connect();
			String sql = "select * from jan08_restaurant where r_seat >= ? order by r_location";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rst.getSeat());
			// ?
			rs = pstmt.executeQuery();
			ArrayList<Restaurant> rsts = new ArrayList<Restaurant>();
			while (rs.next()) {
				rsts.add(new Restaurant(rs.getString("r_location"),
										rs.getString("r_owner"),
										rs.getInt("r_seat")));
			}
			return rsts;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			BeaverDBManager.close(con, pstmt, null);
		}
	}
	
	// 6. 예약 찾기 (예약자의 이름으로 찾기, 예약 번호순으로 정렬)
	public static ArrayList<Reservation> searchReservation(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BeaverDBManager.connect();
			String sql = "select * from jan08_Reservation where r_name like '%'||?||'%' order by r_no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getName());
			rs = pstmt.executeQuery();
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			while (rs.next()) {
				rsvs.add(new Reservation(rs.getInt("r_no"),
										rs.getString("r_name"),
										rs.getDate("r_time"),
										rs.getString("r_phonenum"),
										rs.getString("r_location")));
			}
			return rsvs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			BeaverDBManager.close(con, pstmt, rs);
		}
	}
		
	
	// 7. 예약정보수정 (예약자의 전화번호 수정)
	public static String rsvCorrection(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = BeaverDBManager.connect();
			String sql = "update jan08_reservation set r_phonenum = ? where r_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getPhone());
			pstmt.setInt(2, rsv.getNo());
			if (pstmt.executeUpdate() == 1) {
				return "예약 수정 성공";
			};
			return "수정할 예약이 없습니다.";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 수정 실패";
	} finally {
		BeaverDBManager.close(con, pstmt, null);
	}
}
	
	
	// 8. 예약 취소 (예약 번호로 취소)
	public static String cancelReservation(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = BeaverDBManager.connect();
			String sql = "delete from jan08_reservation where r_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rsv.getNo());
			if (pstmt.executeUpdate() == 1) {
				return "예약 취소 완료";
			};
			return "취소할 내역이 이미 삭제 되었거나 없습니다.";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 취소 실패";
	} finally {
		BeaverDBManager.close(con, pstmt, null);
	}
}
	
	public static void main(String[] args) {
		
		
	}
}





























