package com.beaver.jan071.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
	public static void main(String[] args) {
		// 상품명입력 => 입력한 내용을 포함하는 상품의 정보를 삭제
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			String addr = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
			con = DriverManager.getConnection(addr, "sexy", "guy");
			
			Scanner k = new Scanner(System.in);
			System.out.println("상품명 : ");
			String name = k.next();
			
			String sql = "delete from jan03_product "
					+ "where p_name like '%'||?||'%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			if (pstmt.executeUpdate() >= 1) {
				System.out.println(" 성공 !");
			} else {
				System.out.println("그런 상품은 없습니다~");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
































