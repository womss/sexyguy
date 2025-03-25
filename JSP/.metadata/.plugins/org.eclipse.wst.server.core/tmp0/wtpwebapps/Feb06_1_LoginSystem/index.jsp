<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginController" method="post"> <!-- 로그인 정보를 주소에 알리면 안되기 떄문에 메소드는 포스트 -->
		ID <input name="id" value="${cookie.lastLoginId.value }"> <p> <!-- 파라미터를 넘기기위한 네임 속성 // 로그인에 대한 처리 -->
		PW <input name="pw"> <p>
		<button>로그인</button>
	</form>
</body>
</html>