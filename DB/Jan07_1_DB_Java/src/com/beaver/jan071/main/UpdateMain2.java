package com.beaver.jan071.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain2 {
	public static void main(String[] args) {
		// 매장명입력 => 그 단어를 포함하는 모든 매장의 상품을
		//				20% 할인된 가격으로 바꾸기 *0.8
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			String addr = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
			
			
			Scanner k = new Scanner(System.in);
			System.out.println("매장명 : ");
			String name = k.next();
			
			// 문제점 :	여기는 자바의 영역이기 때문에...
			//			%(formatting) => %?% - X ! 이런건 자바에 없어서 자바에서 안돌아감
			//	%를 문자로 만들어서 문자들을 연결해주는 파이프를 사용!★★★★★
			String sql = "update jan03_product "
					+ "set p_price = p_price * 0.8 "
					+ "where p_m_no in ( "
					+	"select m_no "
					+	"from jan03_market "
//					+	"where m_name like %?%"
					+	"where m_name like '%'||?||'%'"
					+	")";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			if (pstmt.executeUpdate() >= 1) { // 영향을 받은 데이터의 수는 1개 이상일 듯
				System.out.println(" 성공 !");
			} else {
				System.out.println("그런 매장은 없습니다~");
			}
			
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

































