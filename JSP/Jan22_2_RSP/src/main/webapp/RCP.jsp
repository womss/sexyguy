<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="RCP.css">
</head>
<body>
	<form action="RCPController" enctype="multipart/form-data">>
		<table id="rspTbl">
			<tr>
				<th colspan="3">가위바위보</th>
			</tr>
			<tr>
			<td class="td1" colspan="3" align="center">
				대 가위바위보 대회
			</td>
		</tr>
			<tr>
				<td align="center">
					<a href="RCPController?userHand=1"><img src="1.JPG" width="200"></a>
				</td>
				<td align="center">
					<a href="RCPController?userHand=2"><img src="2.JPG" width="200"></a>
				</td>
				<td align="center">
					<a href="RCPController?userHand=3"><img src="3.JPG" width="200"></a>
				</td>
			</tr>
		</table> 
			
		<hr>
		<table border="1" width="950pt" align="center">
			<tr>
				<td>
					<input style="display:none;">
					<img src="${usernum }.JPG" width="200">
				</td>
				<td>
					<input style="display:none;">
					<img src="${p1 }.gif" width="540">
				</td>
				<td>
					<input style="display:none;">
					<img src="${comnum }.JPG" width="200">
				</td>
			</tr>
			<tr align="center" height="50pt">
				<td>유저</td>
				<td class="td3">판정 : ${r }</td>
				<td>AI</td>
			</tr>
		</table>
		<table id="result" border="1" width="540pt" align="center">
			<tr align="center" height="100pt">
				<td class="td">
					${win }승
				</td>
				<td class="td">
					${draw }무
				</td>
				<td class="td">
					${lose }패
				</td>
			</tr>
			<tr align="center" height="50pt">
				<td class="td3">
					${t } ${w } ${d } ${l }
				</td>
			</tr>
			<tr>
				<td class="td3" colspan="3" align="center">
				<form action="RCPController" method="post">다시하기</form>
			</tr>
	</form>
</body>
</html>