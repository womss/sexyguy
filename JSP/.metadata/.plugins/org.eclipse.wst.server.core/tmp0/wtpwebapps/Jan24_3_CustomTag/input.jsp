<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/BeaverValidCheker.js"></script>
<script type="text/javascript" src="js/calcCheck.js"></script>
<link rel="stylesheet" href="css/calc.css">
</head>
<body>
	<form action="CalcController" name="calcform" onsubmit="return calcCheck();">
		<table id="calcTbl">
			<tr>
				<td align="center">
				x :<input name="x" autocomplete="off" autofocus="autofocus" placeholder="x">
				</td>
			</tr>
			<tr>
				<td align="center">
				y :<input name="y" autocomplete="off" placeholder="x">
				</td>
			</tr>
			<tr>
				<td align="center">
				<button>계산하기</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>