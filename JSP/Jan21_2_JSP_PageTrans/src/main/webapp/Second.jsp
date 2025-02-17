<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 값
		//	parameter
		//		html에서 만들어낸 값(a, b)
		//		request에 저장
		//		String or String[]
				
		//	attribute // 요청객체 소속(request)
		//		Java에서 만들어낸 값(c, d, e)
		//		request에 저장
		//		Object (객체) //형변환해서 사용해야한다
		
		// 이동
		//	First => Second	: 사용자가 뭔가 액션을 취해서 넘어옴
		//		- 이것을 request (요청)이라고 부름
		
		//	Second => Third : 액션을 하지 않아도 넘어감(자동이동)
		//		- redirect	: 단순 자동이동(점검중) 화면이동만 가능
		//		response.sendRidirect("Third.jsp") // 응답객체로만 활용되서 값의 전달은 이루어지지 않음
		
		//		- forward	: 자동이동(값이 전달되는!)
		//		RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
		//		rd.forward(request, response);
	%>
	<%
		
		//		- include	: 포함(Second속에 Third가 포함되는)
		//		위치조절이 안됨! (Third가 무조건 상단에 들어옴) - 비추!
		//		조만간 ! 위치조절이 되는 include를 보도록 합시다 ~
		//		RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
		//		rd.include(request, response);
		
		
		
		
		
	%>

	<%
		request.setCharacterEncoding("UTF-8");
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		// RequestDispatcher : 클라이언트로부터 들러온 요청을
		//						원하는 쪽으로 넘기는 기능
		// 호출된 페이지에서는 request.setAttribute(key, value)
		//	메소드를 통해서 넘겨받은 데이터를 처리할 수 있음
		// => Redirect랑은 다르게 (데이터처리를 못하는 Redirect)
		//		request와 response 객체를 가지고 넘어가기 때문에
			//	ㄴparameter , Attribute
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
		
		int c = a + b;
		request.setAttribute("c", c); // "c" 불러올 이름
		
		String d = "ㅋ";
		request.setAttribute("d", d);
		
		Random e = new Random();
		request.setAttribute("e", e);
		
		// rd.forward(request, response);
		rd.include(request, response); //왔다갔다 하면서 보기
		
	%>
	
	<h1>Second</h1>
	<hr>
	a : <%=a %> <br>
	b : <%=b %> <br>
	

</body>
</html>