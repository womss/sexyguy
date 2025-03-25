package com.beaver.jan071.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 연결
			String addr = "jdbc:oracle:thin:@192.168.0.12:1521:xe";
			con = DriverManager.getConnection(addr, "sexy", "guy");
			
			// 연결이 되면 입력받기(Scanner)
			// 마트 테이블의 마트 이름, 지점명, 몇 평, 주차 가능 대수
			Scanner k = new Scanner(System.in);
			System.out.println("마트이름 입력 : ");
			String name = k.next();
			System.out.println("지접명 입력 : ");
			String location = k.next();
			System.out.println("평 수 입력 : ");
			int land = k.nextInt();
			System.out.println("주차 가능 대수 입력 : ");
			int parking = k.nextInt();
			
			// SQL
			// Java변수에 있는 값 들어갈 자리에 '?'로 대체
			// 내가
			String sql = "insert into jan03_market "
					+ "values(jan03_market_seq.nextval,"
					+ name + "," + location + "," + land + ","+ parking + ")";
			String sql1 = "insert into jan03_market "
					+ "values(jan03_market_seq.nextval,"
					+ "?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql1);
			
			// ?에 값 채우기 : pstmt.setXXX(물음표번호, 값)
			// XXX : 자료형, 물음표번호는 1부터 시작!
			
			// sql 변수의 첫번째(1) 물음표는 String인 name의 값을 넣어라!
			pstmt.setString(1, name);
			pstmt.setString(2, location);
			pstmt.setInt(3, land);
			pstmt.setInt(4, parking);

			// 전송/실행/결과 받기
			//	이 작업 때문에 영향을 받은 데이터의 수가 리턴
//			int dataCount = pstmt.executeUpdate();
//			if (dataCount == 1) {
//				System.out.println("Insert 성공 !");
//			}
			if (pstmt.executeUpdate() == 1) {
				System.out.println("Insert 성공 !");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();			// 닫는 순서 주의 !!
									// con.close()보다 먼저 닫기!
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