<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS</title>
<link rel="stylesheet" href="css/sns.css">
<script type="text/javascript" src="js/BeaverValidChecker.js"></script>
<script type="text/javascript" src="js/Check.js"></script>
<script type="text/javascript" src="js/go.js"></script>
</head>
<body>
	<h1 id="title" align="center">
		<a href="HomeController">MAKAO TALK</a>
	</h1>
	<p>
	<h2 align="center">Login</h2>
	<p>
	<h3 align="center">
		<a href="DBCController">DB연결</a>
	</h3>
	<h4>${r }</h4>
	<hr>
	<table>
		<tr>
			<td>
				<!-- <div id="mainContent"> --> <jsp:include page="${lp }" /> <!-- 본문이 와야 할 자리 -->
			</td>
			
			<td>
				</div> <jsp:include page="${cp }" />
			</td>
		</tr>

	</table>
</body>
</html>