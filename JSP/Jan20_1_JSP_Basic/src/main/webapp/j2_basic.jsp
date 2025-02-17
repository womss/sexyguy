<%@page import="java.util.Random"%>
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		1 ~ 100 사이의 랜덤한 정수 하나를 넣었을 때,
		작인지 홀인지를 알려주는 기능
		
		뽑은 숫자와 홀짝 여부를 웹페이지에 출력 (<h1> 태그)
	 --%>
	
	<%!
		public String getOE(int x) {
			return (x % 2 == 0) ? "짝수" : "홀수";
		}
	%>	 
	
	<%
		Random r = new Random();
		int x = r.nextInt(100)+1;
	%>
	
	<h1>뽑은 숫자 : <%=x %></h1>
	<h1>홀짝 여부 : <%=getOE(x) %></h1>
	
	
	
	 
	 
</body>
</html>





































