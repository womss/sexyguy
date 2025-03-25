<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/test.css">
<script type="text/javascript" src="js/BeaverValidCheker.js"></script>
<script type="text/javascript" src="js/NBValidChecker.js"></script>
<script type="text/javascript" src="js/go.js"></script>
</head>
<body>
	<form action="HomeController" name="nbForm"
		onsubmit="return check();">
		<table id="nbTbl">
			<tr>
				<th align="center">숫자 야구</th>
			</tr>
			<tr>
				<td align="center">
				<input class="ip" name="userAns" maxlength="3"
				autocomplete="off" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td class="td1" align="center">
				<marquee behavior="alternate">숫자만 3자리, 중복숫자 x</marquee>
				</td>
			</tr>
			<tr>
				<td align="center">
				<button class="btn">확인</button>
				</td>
			</tr>
			<tr>
				<td class="td1" align="left">${ua }</td>
			</tr>
			<tr>
				<td class="td1" align="left">${s }</td>
			</tr>
			<tr>
				<td class="td1" align="left">${b }</td>
			</tr>
			<tr>
				<td class="td1" align="left">${t }</td>
			</tr>
			<tr>
				<td class="td1" align="left">${r }</td>
			</tr>
		</table>
	</form>
	<div align="center">
		${btn }
	</div>
	${con }
	<div align="center">${call }</div>





	<%-- <table id="baseballTbl" align="center">
		<tr>
			<th>숫자 야구</th>
		</tr>
		<tr>
			<th>정답 ${cn }</th>
		</tr>
		<tr>
			<td align="center">
			<form action="HomeController">
			<input name="input" type="text" width="150px" height="50px" maxlength="3" placeholder="???">
			<button>제출</button>
			</form>
			</td>
		</tr>
		<tr>
			<td align="center">사용자가 낸 숫자 ${u }</td>
			<td align="center">${cc } ${s } ${b }</td>
			
			<td class="td3" align="center">
				<form action="HomeController" method="post">
					<button>다시하기</button>
				</form>
			</td>
		</tr>
		<tr>
			<td align="center">${done }</td>
		</tr>
	</table> --%>
</body>
</html>