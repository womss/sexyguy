<%@page import="com.beaver.jan214.main.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- V2.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		request.setCharacterEncoding("UTF-8");
		Guest g = (Guest) request.getAttribute("g");
		String name = request.getParameter("name");
		/*
		int height = Integer.parseInt(request.getParameter("height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		int bmi = (Integer) request.getAttribute("bmi");
		*/
	%>
	
	<table id="resultTbl">
			<tr>
				<th colspan="2">BMI Result</th>
			</tr>
			<tr>
				<td class="td1" align="center">이름</td>
				<td class="td2"><%=g.getName()%></td>
			</tr>
			<tr>
				<td class="td1" align="center">키</td>
				<td class="td2">${g.height * 100}cm</td> <!-- 이름에서 객체를 불러온거 말고 다른 문법 활용해보겠습니다 --> 
			</tr>
			<tr>
				<td class="td1" align="center">몸무게</td>
				<td class="td2">${g.weight }kg</td>
			</tr>
			<tr>
				<td class="td1" align="center">BMI</td>
				<td class="td2">${g.bmi }</td>
			</tr>
			<tr>
				<td class="td3" colspan="2" align="center">
				<marqee behavior="alternate">
					당신은 ${g.status } 입니다.
				</marqee>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<img src="img/${g.photo }" style="max-width: 20%; height: auto;">${g.photo }
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

</body>
</html>