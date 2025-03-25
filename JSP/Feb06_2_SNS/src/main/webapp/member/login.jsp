<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="loginTbl">
		<form action="LoginController" method="post" name="loginForm"
			onsubmit="return loginCheck();">
		<tr>
			<td align="center" id="loginId">Login</td>
		</tr>
		<tr>
			<td align="center">
				<input autocomplete="off" placeholder="ID"
				name="m_id" maxlength="10"
				value="${cookie.lastLoginId.value }">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input autocomplete="off" placeholder="Password"
				name="m_pw" maxlength="10" type="password">
			</td>
		</tr>
		<tr>
			<td align="center">
				<button>Login</button>
		</form>
				<button onclick="signupGo();">Sign Up</button>
			</td>
		</tr>
	</table>
</body>
</html>










