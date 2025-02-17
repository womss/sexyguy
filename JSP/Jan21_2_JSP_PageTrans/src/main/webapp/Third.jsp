<%@page import="java.util.Random"%>
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
		// Parameter 읽기
		int a = Integer.parseInt(request.getParameter("a"));
		
		String bbb = request.getParameter("b"); // String
		Integer bb = Integer.parseInt(bbb);		// String => Integer
		int b = bb.intValue();					// Integer = > int
		
		// Attribute 읽기
		Object ccc = request.getAttribute("c");	// Object
		Integer cc = (Integer) ccc;				// Object => Integer
		int c = cc.intValue();					// Integer => int
		
		int c2 = (Integer) request.getAttribute("c"); // 세줄을 한번에 오토언박싱
		
		String d = (String) request.getAttribute("d");
		Random e = (Random) request.getAttribute("e");		
	%>
	<h1>Third</h1>
	a : <%=a %> <br>
	b : <%=b %> <br>
	c : <%=c %> <br>
	d : <%=d %> <br>
	e : <%=e.nextInt(100) + 1 %> <br>

</body>
</html>