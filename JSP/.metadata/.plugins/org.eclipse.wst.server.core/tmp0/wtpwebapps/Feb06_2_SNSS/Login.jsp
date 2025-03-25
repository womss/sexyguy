<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="login-container">
	<table id="loginTb">
		<form id="fm" action="LoginController" method="post"> <!-- 로그인 정보를 주소에 알리면 안되기 떄문에 메소드는 포스트 -->
			<tr class="tr1">
				<td class="td1">
					로그인
				</td>
			</tr>
			<tr class="tr2">
				<td class="td2">
					ID <input class="id" value="${cookie.lastLoginId.value }"> <p> <!-- 파라미터를 넘기기위한 네임 속성 // 로그인에 대한 처리 -->
				</td>
			</tr>
			<tr class="tr2">
				<td class="td2">
					PW <input class="pw"> <p>
				</td>
			</tr>
			<tr class="tr3">
				<td class="td3">
					<button class="btn">로그인</button>
	</form>
					<button class="btn" onclick="membershipController();">회원가입</button>
				</td>
			</tr>
	</table>
	</div>

</body>
</html>