<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="signupTbl">
		<form action="MemberInfoController" method="post" enctype="multipart/form-data" 
			name="updateForm" onsubmit="return updateCheck();">
			<tr>
				<td>
					<input name="m_id" value="${sessionScope.loginMember.m_id }"
					autocomplete="off" maxlength="10" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>
					<input name="m_pw" type="password" value="${sessionScope.loginMember.m_pw }"
					autocomplete="off" maxlength="12">
				</td>
			</tr>
			<tr>
				<td>
					<input name="m_name" value="${sessionScope.loginMember.m_name }"
					autocomplete="off" maxlength="10">
				</td>
			</tr>
			<tr>
				<td>
					<input name="m_phone" value="${sessionScope.loginMember.m_phone }"
					autocomplete="off" maxlength="11">
				</td>
			</tr>
			<tr>
				<td>
					생년월일<br>
					<select name="m_y">
						<option>
							<fmt:formatDate 
							value="${sessionScope.loginMember.m_birthday }" pattern="yyyy"/>
						</option>
						<c:forEach var="y" begin="${cy - 100 }" end="${cy }" step="1">
							<option>${y }</option>
						</c:forEach>
					</select>&nbsp;년&nbsp;&nbsp;
					<select name="m_m">
						<option>
							<fmt:formatDate 
							value="${sessionScope.loginMember.m_birthday }" pattern="M"/>
						</option>
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
					</select>&nbsp;월&nbsp;&nbsp;
					<select name="m_d">
						<option>
							<fmt:formatDate 
							value="${sessionScope.loginMember.m_birthday }" pattern="d"/>
						</option>
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
					</select>&nbsp;일&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					사진 ${sessionScope.loginMember.m_photo }<br>
					<img src="img/${sessionScope.loginMember.m_photo }"
						id="memberUpdatePhoto"><br>
					<input type="file" name="m_photo">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>정보 수정</button>
	</form>
					<button onclick="bye();">회원 탈퇴</button>
				</td>
			</tr>
		</table>

</body>
</html>