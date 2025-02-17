package com.beaver.jan071.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	public static void main(String[] args) {
		// 매장명입력 => 그 단어를 포함하는 모든 매장의 상품을
		//				20% 할인된 가격으로 바꾸기 *0.8
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String addr = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
			con = DriverManager.getConnection(addr, "sexy", "guy");
			
			Scanner k = new Scanner(System.in);
			System.out.println("20% 할인된 가격으로 바꿀 상품명 입력 : ");
			String sale = k.next();
			
			String sql = "update jan03_product "
					+ "set p_price = p_price * 0.8"
					+ "where p_m_no = ("
					+ "select m_no"
						+ "from jan03_product"
						+ "where p_name = "+ sale +")";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// rs.getXXX("컬럼명") : 현재 위치의 컬럼 읽기
				// rs.getXXX(인덱스) : 비추! (헷갈릴 여지가 있음!)
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt("p_price"));
				System.out.println("---------------------------");
				
			}
//				jan03_market
			System.out.println("해당상품을 모든 매장에서 가격을 조정 합니다");
			// 조정된 값 출력
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

































