<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
									/* 얼척없네 */
<style type="text/css">
	table {
		float: left;
		margin-right: 10px;
	}
									/* 얼척없네 */
</style>
</head>
<body>

	<%
	for (int i = 2; i <= 9; i++) {
	%>
	<table id="aa" border="1">
		<tr>
			<th><%=i%>단</th>
		</tr>
		<%
		for (int j = 1; j <= 9; j++) {
		%>
		<tr>
			<td><%=i%> x <%=j%> = <%=i * j%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>

	<!--  --><!--  --><!--  --><!--  --><!--  --><!--  --><!--  -->
	<table border="1">
		<tr>
			<%
			for (int a = 2; a <= 9; a++) {
			%>
			<th><%=a%>단</th>
			<%
			}
			%>
		</tr>
		<%
		for (int i = 1; i <= 9; i++) {
		%>
		<tr>
			<%
			for (int j = 2; j <= 9; j++) {
			%>
			<td><%=j%> x <%=i%> = <%=i * j%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>




	<%
	int a = 0;
	int b = 2;
	for (a = 1; a < 10; a++) {
		System.out.printf("<table>" + "<tr>");
		System.out.printf("%d 단", b);
		for (b = 2; b < 10; b++) {
			System.out.printf("<td>");

			System.out.printf("%d x %d = %d", b, a, b * a);
			System.out.printf("</td>");
		}
		System.out.printf("<tr>" + "<table> <p>" + "--------------------");
	}
	%>
	<table>
		<tr>
			<td>for (i=1 i<10 i++;) { s }</td>
		</tr>
	</table>

</body>
</html>