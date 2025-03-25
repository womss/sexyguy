<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/reg.css">
<script text="text/javascript" src="js/BeaverValidCheker.js"></script>
<script text="text/javascript" src="js/feb03Check.js"></script>
</head>
<body>
    <div class="container">
        <h1>사과 정보 등록</h1>
        <form action="AppleRegController" method="post" name="appleRegForm" onsubmit="return appleRegCheck();">
            <table id="submit">
                <tr>
                    <td>지역</td>
                    <td><input name="a_location" autocomplete="off" autofocus placeholder="지역" class="input-text"></td>
                </tr>
                <tr>
                    <td>색</td>
                    <td>
                        <select name="a_color" class="select-box">
                            <option>빨강</option>
                            <option>초록</option>
                            <option>노랑</option>
                            <option>황금</option>
                            <option>검정</option>
                            <option>무지개</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>맛 </td>
                    <td>
                        <select name="a_flavor" class="select-box">
                            <option>단맛</option>
                            <option>신맛</option>
                            <option>떫은맛</option>
                            <option>쓴맛</option>
                            <option>무맛</option>
                            <option>매운맛</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>가격 </td>
                    <td><input name="a_price" type="number" autocomplete="off" placeholder="가격, 숫자만 입력" class="input-text"></td>
                </tr>
                <tr>
                    <td>설명 </td>
                    <td><textarea name="a_info" maxlength="100" autocomplete="off" placeholder="5자 이상" class="text-area"></textarea></td>
                </tr>
                <tr>
					<td colspan="2" class="button-group">
						<button type="submit" class="btn">저장</button>
						<button type="button" class="btn" onclick="history.back()">뒤로가기</button>
						<button type="reset" class="btn">초기화</button>
					</td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>