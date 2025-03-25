package com.beaver.db.manager;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	import javax.naming.Context;
	import javax.naming.InitialContext;
	import javax.sql.DataSource;



	public class BeaverDBManager {

		
		public static Connection connect(String poolName) throws Exception {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/" + poolName);
			// java:comp/env/ 는 context.xml파일이 있는 경로
			return ds.getConnection();
		}
		
		// 빌린 튜브 반납
		public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
			try {
				rs.close();
			} catch (Exception e) {
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
