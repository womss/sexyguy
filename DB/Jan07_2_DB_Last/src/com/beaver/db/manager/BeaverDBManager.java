package com.beaver.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BeaverDBManager {
	public static Connection connect() throws SQLException {
		String addr = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
		return DriverManager.getConnection(addr, "sexy", "guy");
	}
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			rs.close();				// C, U, D때는 필요없고, R 때만 필요
									// insert하게 되면
									// NullPointerExeption이 발생
		} catch (Exception e) {	// 모든 Exeption이 잡히도록 할 것!
									// 메시지는 안보려고!!
									//e.printStackTrace(); 이거 지워야 빨간 에러(작동은 함) 안뜸★★★★★
		}
		
		try {
			pstmt.close();
		} catch (Exception e) {
			
		}
		
		try {
			con.close();
		} catch (Exception e) {
		
		}
		
	}
}
