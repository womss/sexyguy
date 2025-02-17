<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/input.css">
<script type="text/javascript" src="resources/js/index.js"></script>
</head>
<body>
	View (V) - <br>
		JSP : .html or .jsp <br>
		Spring Legacy : .jsp <br>
		Spring Boot : .html <br>
		
		Spring 내에서 쓰는 자원파일들(css, js, 그림, ...)
			webapp - resources / ... (경로)
	<hr>
	input 3개 => 이름, x, y <br>
	button 하나 를 <br>
	form에 담기
	<hr>
	<form action="calculate.do" method="post">
		<input name="n" autofocus autocomplete="off" placeholder="이름"> <p>
		<input name="x" autocomplete="off" placeholder="x"> <p>
		<input name="y" autocomplete="off" placeholder="y"> <p>
		<button type="submit">확인</button>
	</form>
	
</body>
</html>