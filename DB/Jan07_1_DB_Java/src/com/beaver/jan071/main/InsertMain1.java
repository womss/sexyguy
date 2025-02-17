package com.beaver.jan071.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// jan03_product
public class InsertMain1 {
	public static void main(String[] args) {
		// SQL문을 사용해서
		//		=> DB서버로 전송
		//		=> DB서버에서 실행해서
		//		=> 그 결과를 받아올 수 있어야!
	
		Connection con = null;
	try {
		String addr = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
		con = DriverManager.getConnection(addr, "sexy", "guy");
//		System.out.println("Success !");
		
		// 주의할 점 2가지 !!!
		// 1. 띄어쓰기 주의 !!!
		//		띄어쓰기 안하면 productvalues(...) 가 됨
		String sql = "insert into jan03_product "
				+ "values(jan03_product_seq.nextval, "
				+ "'테스트', 10, 10, 3)";
		// 2. 닫는괄호 ) 뒤에 ';' 쓰지 말것!!! ex) + "'테스트', 10, 10, 3);"; 이렇게 작성하면 문법 오류
		
		// 설버에 전송/실행/결과 받아오는 작업을 하는 총괄 매니저
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
		
		System.out.println("Insert 성공 !");

		
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
		
		
	
