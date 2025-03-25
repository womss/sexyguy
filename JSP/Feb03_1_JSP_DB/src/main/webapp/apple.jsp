<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/apple.css">
</head>
<body>
	<table id="appleTbl">
        <!-- 등록 버튼을 오른쪽 컬럼과 합쳐서 정렬 -->
        <tr>
            <td colspan="2" align="center">
                ${r } <a href="AppleRegController" class="btn">+ 등록</a>
            </td>
        </tr>
        
        <!-- 테이블 헤더 -->
        <tr class="table-header">
            <td>지역</td>
            <td>가격</td>
        </tr>
        
        <!-- 데이터 리스트 -->
        <c:forEach var="apple" items="${apples}">
            <tr class="dataTr" onclick="goAppleDetail('${apple.a_location}');">
                <td>${apple.a_location}</td>
                <td>
                    <fmt:formatNumber value="${apple.a_price}" type="number" />
                </td>
            </tr>
        </c:forEach>
    </table>

    <!-- 페이지 네비게이션 -->
    <div class="pagination">
        <c:forEach var="p" begin="1" end="${pageCount}">
            <a href="ApplePageController?p=${p}" class="page-link">${p}</a>
        </c:forEach>
</body>
</html>