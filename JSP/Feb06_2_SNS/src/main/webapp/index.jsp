<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<link rel="stylesheet" href="css/signup.css">
<link rel="stylesheet" href="css/board.css">
<script type="text/javascript" src="js/BeaverValidChecker.js"></script>
<script type="text/javascript" src="js/memberCheck.js"></script>
<script type="text/javascript" src="js/go.js"></script>
<script type="text/javascript" src="js/boardCheck.js"></script>
</head>
<body>
	<table id="siteTitleTbl">
		<tr>
			<td id="siteTitle" align="center">
				<a href="HomeController">SNS MODE</a>
			</td>
		</tr>
		<tr>
			<td id ="siteMenu" align="center">
				<a href="BoardController">Board</a>
			</td>
		</tr>
	</table>
	<table id="siteContentTbl">
		<tr>
			<td id="siteContent" align="center">
				<jsp:include page="${cp }"></jsp:include>
			</td>
		</tr>
	</table>
	<table id="siteLoginTbl">
		<tr>
			<td>
				<jsp:include page="${lp }" /><span id="dbResult">${r }</span>
			</td>
		</tr>
	</table>
</body>
</html>










