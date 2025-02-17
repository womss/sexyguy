<%@page import="java.sql.Connection"%>
<%@page import="com.beaver.db.manager.BeaverDBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 톰캣이 튜브대여소 역할을 할 줄 알아서
		// 튜브 = Connection 객체
		
		// 기본 : DriverManager.getConnection()을 실행하는 순간
		//	관련된 모든 작업을 해서 Connection 객체를 만들어줌 => 느림
		
		// 커넥션풀 : 미리 Connection객체 x 100개 만들어놓고
		//	클라이언트가 요청하면 => 만들어진거 하나 주면 됨 => 빠름
		
		// 설정 - context.xml(설계도, 사업계획서 느낌)
		// Servers(톰캣) - context.xml 파일이 존재함
		//		저걸 건들면... 우리가 사용하고 있는 워크스페이스 안에 있는
		//		모~~~든 프로젝트에 다 영향을 주게 됨
		//	프로젝트가 다르다 => DB서버가 다르다
		
		// 우리가 만든 context.xml을
		//	각 프로젝트의 META-INF폴더에 넣자!!
		
		String result = "실패";
		
		Connection con = null;
		try {
			con = BeaverDBManager.connect("sexy");
			result = "성공";
		} catch (Exception e) {
			e.printStackTrace();
		}
		BeaverDBManager.close(con, null, null);
	%>
	<h1>DB연결</h1>
	<h1><%=result %></h1>
</body>
</html>


















