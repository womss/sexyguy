<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/GB.css">
</head>
<body>
<table id="GBETbl">
		<tr>
			<th colspan="3">새 신을 신고 뛰어보자 홀~짝!</th>
		</tr>
		<tr>
			<td class="td1" colspan="3" align="center">
				자 드가자~
			</td>
		</tr>
		<tr>
			<td align="center">
				<a href="GamblingController?userHand=1"><img src="css/ghf.png"></a>
			</td>
			<td align="center">
				<img src="css/rhffk.gif">
			</td>
			<td align="center">
				<a href="GamblingController?userHand=2"><img src="css/Wkr.jpg"></a>
			</td>
		</tr>
		<tr>
			<td align="center"><img src="css/${uu }"></td>
			<td align="center"><img src="css/${uc }"></td>
			<td align="center"><img src="css/${cc }"></td>
		</tr>
		<tr>
			<td class="td3" colspan="3" align="center">
				동전 : ${comHand }
			</td>
		</tr>
		<tr>
			<td class="td3" colspan="3" align="center">
				답 : ${r }
			</td>
		</tr>
		<tr>
			<td class="td3" colspan="3" align="center">
				${c } ${w } ${l } ${p }
			</td>
		</tr>
		<tr>
			<td class="td3" colspan="3" align="center">
				<form action="GamblingController" method="post">
					<button>다시하기</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>