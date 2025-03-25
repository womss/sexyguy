<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사과 상세 정보</title>
<link rel="stylesheet" href="css/detail.css">
</head>
<body>
    <h1>사과 상세 정보</h1>
    <table>
<form action="AppleDetailController" method="post">
    	<tr>
    		<td>지역</td>
    		<td class="td2">
    			<input name="a_location" autocomplete="off"
    			readonly="readonly" class="inputt"
    			value="${apple.a_location}">
    		</td>
    	</tr>
    	<tr>
    		<td>색상</td>
    		<td class="td2">
    			<input name="a_color" autocomplete="off"
    			class="inputt"
    			value="${apple.a_color}">
    		</td>
    	</tr>
    	<tr>
			<td>맛</td>
    		<td class="td2">
    			<input name="a_flavor" autocomplete="off"
    			class="inputt"
    			value="${apple.a_flavor}">
    		</td>
    	</tr>
    	<tr>
			<td>가격</td>
    		<td class="td2">
    			<input name="a_price" autocomplete="off"
    			class="inputt"
    			value="${apple.a_price}">
    		</td>
    	</tr>
    	<tr>
    		<td>설명</td>
    		<td class="td2">
    			<input name="a_info" autocomplete="off"
    			class="inputt"
    			value="${apple.a_info}">
    		</td>
    	</tr>
    	<tr>
    		<td class="button-container" align="center" colspan="2">
    		<button class="btn">수정</button>
    		
</form>
    		<button class="btn" onclick="deleteApple('${apple.a_location}');">삭제</button>
    		</td>
    	</tr>
    </table>
     <div class="button-container">
        <button onclick="history.back()">&lt;뒤로가기</button>
    </div>
</body>
</html>