<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--// 프리픽스 - (c(코어기능을 쓸때는 c)라는)접두어-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${param.n }</h1>
	<!-- 코어는 조건문 반복문 위주로 많이 쓰임 -->
	<!-- 조건문 -->
	<!-- test는 조건 -->
	<c:if test="${param.n % 2 == 0 }">
		짝수
	</c:if>
	<hr>
	
	<!-- if-else + switch-case 느낌 -->
	<!-- 어떤 케이스에 동작할 것인가 -->
	<c:choose>
		<c:when test="${param.n >= 5 }">
			5 ~ 10 사이
		</c:when>
		<c:otherwise>
			나머지
		</c:otherwise>
	</c:choose>
	<hr>
	
	<!-- 반복문 -->
	<%
		// for (int i = 1; i <= 5;  i += 2) {
		// for ([begin="1"]=int i = 1; / [end="${param.n }"] = i <= 5; / [step="2"] = i += 2) {
		//	System.out.println(i);
		//	[var="v"] = System.out.println(i);
		// }
	%>
	<c:forEach begin="1" end="${param.n }" step="2" var="v">
		<marquee>${v }</marquee>
	</c:forEach>
	
	<c:forEach var="i" items="${ar }">
		<marquee>${i }</marquee>
	</c:forEach>
	<hr>
	<c:forEach var="beaver" items="${al }">
		${beaver.name } - ${beaver.age } <br>
	</c:forEach>
	<hr>
	
	<!-- try-catch -->
	<c:catch var="myExcept">
		<% int result = 100 / 2; %>
		계산결과 : <%=result %>
	</c:catch>
	<br>
	<c:catch var="myExcept">
		<% int result = 100 / 0; %>
		계산결과 : <%=result %>
	</c:catch>
	<c:if test="${myExcept != null}">
		에러 발생 : ${myExcept.message }
	</c:if>
	<br>
	
	<c:out value="${param.n } zzzzz"></c:out><br> <!-- 출력 -->
	<c:set var="name" value="홍길동" /> <!-- 변수 만들기 -->
	<c:out value="${name }" /> <br>
	
	<!-- Java : StringTokenizer  -->
	<c:forTokens var="item" items="서울,대전,대구,부산,찍고,아하" delims=",">
		지역 : ${item } <br>
	</c:forTokens>
	
	
	<td align="center">
		<button onclick="history.back()">뒤로가기</button>
	</td>
</body>
</html>









































