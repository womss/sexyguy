<%@page import="com.beaver.jan221.main.Beaver"%>
<%@page import="java.util.ArrayList"%>
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
		// JSP는 자바의 문법과 HTML의 문법을 엄격하게 구분함
		//	자바 문법은 <% % > 스크립트릿 안에서만 사용함
		//	각 영역의 코드들이 섞여있어 코드의 가독성이 떨어지거나,
		//		유지보수 하기 어려움
		//	그래서 JSP파일 안에서 Java의 코드를 최소화 하고자 함!
		
		// EL (Expression Language)
		//	값 받을때 Java대신 가능 + HTML문법에 종속됨
		//	.jsp에서만 사용이 가능
		//		(.jsp를 톰캣이 Servlet으로 바꿀때 EL을 Java코드로 바꿔줌)
		//	따로 Java영역을 만들어서 해당 값들을 불러올 필요가 없음!!!
		
		//	문법 : ${XXX }
		//		연산자 사용 가능
		//		형 변환 자동
		//		값이 없으면 그냥 넘어감 //널포인트익셉션같은거 안뜨고
		//		import가 없어도 됨!
		//		가독성이 좋죠 !
		
		//		파라미터값 읽기 : ${param.파라미터명 }
		
		//		어트리뷰트값 읽기 (int, double, String, ... 포함)
		//			: ${어트리뷰트명 }
		
		//		어트리뷰트값 읽기(객체)
		//			: 주소값 - ${어트리뷰트명 }
		//			  속성값 - ${어트리뷰트명.멤버변수명 }
		
		//		어트리뷰트값 읽기(List, [])
		//			AL / [] 자체 - ${어트리뷰트명 }
		//			인덱스 위치의 객체 - ${어트리뷰트명[인덱스] }
		//			인덱스 위치의 객체 속성 - ${어트리뷰트명[인덱스].멤버변수명 }
		
		//		반복문, 조건문 - EL (X) / CustomTag (O)
	
	%>
	<%
		// request.setCharacterEncoding("UTF-8");									/*  */
		// Beaver b = (Beaver) request.getAttribute("b"); // 이건 언제 쓰는거지			
		String x = request.getParameter("x");										
		String y = request.getParameter("y");										
		int z = (Integer) request.getAttribute("z");
		Beaver b = (Beaver) request.getAttribute("b");
		ArrayList<Beaver> bvs = (ArrayList<Beaver>) request.getAttribute("bvs");
	%>
	<h1>결과</h1>
	<%=x %> + <%=y %> = <%=z %> <br>
	<%=b.getName() %> : <%=b.getAge() %>
	: <%=b.getWeight() %> : <%=b.getWeight() %> <p>
	<%=b %> <p>
																					<!-- /* */이거 사이에 있는거 지워도 됨  -->
	<%=bvs %> <p>
	<%=bvs.get(1) %> <p> <!-- 이거 뭐지? -->
	<%=bvs.get(2).getName() %>, <%=bvs.get(3).getAge() %> <p>
	
	<%
		for (int i = 0; i < bvs.size(); i++) {
	%>
		<%=bvs.get(i).getName() %> : <%=bvs.get(i).getAge() %>살 <br>			
	<%
		}																			/*  */
	%>																				
	<hr>
	${param.x } <p>
	${param.y } <p>
	${param.x * param.y } <p>
	${z } <p>
	<hr>
	${b.name } : ${b.age } : ${b.height } : ${b.weight } <p>
	<hr>
	${param.asdfafasfeafasd } <!-- 값이 없을 때 그냥 넘어가는 예시 -->
	<hr>
	${bvs } <p>
	${bvs[1] } <p>
	${bvs[2].name }, ${bvs[3].age } <p>
	
	
	
</body>
</html>













