<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function gogo() {
		location.href = "Second.jsp?a=100&b=200";
	}	
</script>
</head>
<body>

	<!--
		First.jsp에서 정수 a, b 를 입력하고
		Second.jsp로 요청했을 때 해당 화면에서 각 숫자들 출력
		<a> 
	 -->
	<h1>First</h1>
	<hr>						<!-- 	<	 > -->
	<a href="Second.jsp?a=10&b=20">&lt;a&gt;로 [GET방식 요청]</a> 	<!-- <a></a> : 클릭하면 이동 -->
	<hr>
	<div onclick="gogo();">JavaScript로 [GET방식 요청]</div>		<!-- JavaScript(location.href) : 이벤트를 지정할 수 있음 -->
	<hr>
	<form action="Second.jsp">									<!-- <form> + <button> : 버튼 클릭 or input에서 엔터치면 이동 -->
	a : <input name="a"> <br>
	b : <input name="b"> <p>
	<button>form + button 조합으로 [GET / POST방식 요청]</button>
	</form>
		
		
	<!--
	<form action="Second.jsp">
		정수 입력 : <input name="number" autofocus>
		<button>입력</button>
	</form>

	 	정수 입력 : <input name="number" autofocus>
	-->

</body>
</html>