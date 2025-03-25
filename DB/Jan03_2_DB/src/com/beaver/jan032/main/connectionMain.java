package com.beaver.jan032.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 원래 : cmd기반 sqlplus라는 프로그램으로 OracleDB제어
//			cmd기반 불편
// 사제품 : eclipse, sqldeveloper, orange, toad, dbeaver, ...

// Socket통신
// HTTP통신

// DB서버와 통신 : Java에 내장되어 있음 (미완성상태)
//		DB 메이커가 많기 때문에... => 메이커 별로 통신이 조금씩 달라서
//		연결할 DB에 맞춰서 조금씩 터치를 해줘야함

// JDBC (Java DataBase Connectivity)
//		- Java에서 DB 프로그래밍을 하기 위해서 사용하는 API
// OracleDB 사용중 => 여기에 맞춰서 터치를 해야!
//		=> 그 기능은 ojdbc8.jar에 들어있음!

// 해당 프로젝트에 ojdbc8.jar 넣기!!

public class connectionMain {
	public static void main(String[] args) {
		Connection con = null;
		try {
			// 연결할 DB서버 주소 (메이커별로 형식이 다르다!)
			//	Data Source Explorer - 서버 이름쪽에 오른쪽 마우스 버튼
			//	- Properties - Driver Properties
			//	- Connection URL 값을 복사
			
			String addr = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
			
			con = DriverManager.getConnection(addr, "sexy", "guy");
			System.out.println("Success !");
			
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




























