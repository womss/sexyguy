<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" href="resources/js/test.js"></script>
<script type="text/javascript" href="resources/js/BeaverValidCheker.js"></script>
<script type="text/javascript">
function test() {
	let x = document.form.on;
	
	if (!x.value) {
		alert('공란을 입력해주세요');
		return false;
	}
	if (isNaN(x.value)) {
		x.value="";
		alert('숫자를 입력해주세요');
		return false;
	}
	return true;
}
</script>

</head>
<body>
	<!-- 
		input 1개,
		<select> / <option> 4개
			cm -> inch
			㎡ -> 평
			℃ -> ℉
			mi/h - km/h
		버튼 1개
		를 form으로 감싸기
		
		input에 숫자하나 입력하고 특정 <option> 고른 후에
		버튼을 누르면  unit.convert로 GET방식 요청
				=> 단위 변환을 해서
				
				action="unit.convert"
	-->
	<form name="form" action="unit.convert" method="get" onsubmit="return test();">
		<input name="on" placeholder="값 입력"> <hr> <!-- n1 -->
		<select name="select">
			<option value="inch">inch</option>
			<option value="pyeong">평</option>
			<option value="f">℉</option>
			<option value="km">km/h</option>
		</select>
		<button>값 변환</button>
	</form>

</body>
</html>