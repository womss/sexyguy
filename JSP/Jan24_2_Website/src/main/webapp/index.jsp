<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/test.css">
<!-- <link rel="stylesheet" href="css/home.css">  -->
<script type="text/javascript" src="test.js"></script>
</head>
<body>
	<table id="siteTbl">
		<tr>
			<th id="siteTitle" align="left">네이버</th>
		</tr>
		<tr>
			<td id="siteMenu">
				<a href="HomeController">홈</a>
				<a href="AController">A</a>
				<a href="BController">B</a>
				<a href="CController">C</a>
			</td>
		</tr>
		<tr>
			<td id="siteContent"><jsp:include page="${contentPage }" /></td>
		</tr>
		<tr>
			<td><img src="css/bat.jpg" id="img1"></td>
			<td><img src="css/c.JPG" id="img2"></td>
		</tr>
	</table>
</body>
</html>