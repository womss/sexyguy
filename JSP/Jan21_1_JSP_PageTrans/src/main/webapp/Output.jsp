<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getRandomColor() {
		// Math.random()						=> 0.0 ~ 0.99999
		// Math.random() * 255					=> 0.0 ~ 254.99999
		// Math.round(Math.random() * 255)		=> 0 ~ 255
		
		let r = Math.round(Math.random() * 255);
		let g = Math.round(Math.random() * 255);
		let b = Math.round(Math.random() * 255);
		
		return "rgb(" + r + "," + g + "," + b + ")";
	}
	
	function init() {
		// alert(getRandomColor());
		// 캔버스
		let cv = document.getElementById("cv");
		// 펜
		let pen = cv.getContext("2d");
		// 좌표
		let x = null;
		let y = null;
		
		// 반복문같은
		setInterval(() => {
			pen.save(); // 현재 pen 상태 저장
			pen.fillStyle = "rgba(0, 0, 0, 0.2)"; // 투명도 : 0 ~ 1
			pen.fillRect(0, 0, 500, 500); // (0,0)부터 (500,500)까지 채우기
			
			// x축 y축으로 움직일때 마다 그림자효과
			pen.shadowOffsetX = 0;
			pen.shadowOffsetY = 0;
			pen.shadowBlur = 10; // 그림자 흐림정도
			pen.shadowColor = "white"; // 그림자 색상
			
			x = Math.random() * 500;
			y = Math.random() * 500;
			pen.fillStyle = getRandomColor();
			pen.fillRect(x, y, 20, 20); // 가로세로 20픽셀만큼 네모를 찍음
			
			pen.restore(); // 이전 성정으로
			
		}, 200); // 0.2초마다 셋인터벌 반복
		
	}
	
	
</script>
</head>
<body onload="init();">
	<canvas id="cv" width="500px" height="500px"></canvas>
	<hr>

	<%
		response.sendRedirect("test.jsp");
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("number");
		System.out.println(num);
		////////////////////////////////////////////		split
		//split
		// num.split(",");
		// 를 배열에
		
		//split
		String[] numData = num.split(",");
		
		int sum1 = 0;
		for (String n : numData) {
			try {
			  sum1 += Integer.parseInt(n);
			} catch (Exception e) {
		}
	}
		////////////////////////////////////////////		StringTokenizer
		StringTokenizer st = new StringTokenizer(num, ",");
		int sum2 = 0;
		while (st.hasMoreTokens()) {
			try {
				sum2 += Integer.parseInt(st.nextToken());
			} catch (Exception e) {
			}
		}
	%>
		합(split) : <%=sum1 %> <br>
		합(StringTokenizer) : <%=sum2 %>
	
	
	<%-- 내가
	<%	

		
		
		
		
		////////////////////////////////////////////
		StringTokenizer stst = new StringTokenizer(num, ",");
		int a = 0;
		while (st.hasMoreTokens()) {
		String token = stst.nextToken();
		  int number = Integer.parseInt(token.trim());
		  a += number;
			
			System.out.println(stst.nextToken());
			}
	%>
	입력값 : <%=num %>
	숫자 더한 값 : <%=a %>	
	--%>

</body>
</html>