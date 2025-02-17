<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/BMIInput2.css"> 
<style type="text/css">


</style>
<title>BMI Result</title>
</head>
<body>
	<%
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	String path = request.getServletContext().getRealPath("img"); // WEB-INF폴더 안에 img 폴더 생성
	System.out.println(path);
	// 파일 용량 				인코딩 방식			중복이름 방지
	MultipartRequest mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());

	String name = mr.getParameter("name");
	double height = Double.parseDouble(mr.getParameter("height"));
	double weight = Double.parseDouble(mr.getParameter("weight"));
	height /= 100;
	double bmi = weight / (height * height);
	String result = "저체중";
	if (bmi >= 40) {
		result = "고도비만";
	} else if (bmi >= 35) {
		result = "중증도비만";
	} else if (bmi >= 30) {
		result = "경도비만";
	} else if (bmi >= 25) {
		result = "과체중";
	} else if (bmi >= 18.5) {
		result = "정상";
	}

	// BMI 수치 => 소수점 둘째자리까지만 (html쪽에서는 안되니 여기서 해결)
	String bmi2 = String.format("%.2f", bmi);

	String image = mr.getFilesystemName("photo");
	image = URLEncoder.encode(image, "UTF-8");
	image = image.replace("+", " ");
	%>
	

		<table id="resultTbl">
			<tr>
				<th colspan="2">BMI Result</th>
			</tr>
			<tr>
				<td class="td1" align="center">이름</td>
				<td class="td2"><%=name%></td>
			</tr>
			<tr>
				<td class="td1" align="center">키</td>
				<td class="td2"><%=height%></td>
			</tr>
			<tr>
				<td class="td1" align="center">몸무게</td>
				<td class="td2"><%=weight%></td>
			</tr>
			<tr>
				<td class="td1" align="center">BMI</td>
				<td class="td2"><%=bmi2%></td>
			</tr>
			<tr>
				
				<td class="td1" align="center">결과</td>
				<td class="td2"><%=result%>
				</marqee>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<img src="img/<%=image %>" style="max-width: 20%; height: auto;"><%=image %>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

































