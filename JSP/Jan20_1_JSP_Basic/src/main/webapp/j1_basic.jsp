<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<marquee><%=1230 * 877 %></marquee>

	HTML : 웹사이트 제작 가능
	--------------------- 디자인 / 이벤트 부족
	HTML : 뼈대를 만들고
	CSS : 디자인
	JavaScript : 이벤트 처리
	--------------------- 파라미터 읽기, 계산, 조건문, 반복문
							: 프로그래밍언어쪽의 기능이 부재
	Servlet : 클라이언트가 요청하면
		=> HTML + CSS JavaScript를 만들어서 응답하는 자바 프로그램
	--------------------- 어렵고, 작업이 불편
	JSP (Java Servlet/Server Page)
		작업 형태 : HTML + CSS + JavaScript에 필요한 부분마다
				Java코드를 첨가!
		실제 정체 : Tomcat이 Servlet으로 바꿔서 실행
		
		
	Servlet : 자바코드 안에서 HTML을 구현하겠다
	JSP : HTML안에서 자바의 코드를 추가하자
	
	<%-- 
		1. 스크립트릿 (Scriptlet)
		JSP에서 Java코드를 실행할 때 사용하는 블록
		<% Java코드가 여기에 ! %>
		
		2. 지시자
		특별한 지시를 내릴 수 있도록 하는 블록
		<%@ page / include / taglib / ... %>
		
		3. 표현식
		어떤 값을 (웹페이지에) 출력 결과로 포함시키고 싶을 때 사용하는 블록
		<%= 값 / 변수 / 계산식 / ... %>
		숫자, 문자열, 변수 등 값 사용 가능
		Servlet의 out.print() 와 같은 기능
		
		4. 선언문
		표현식에서 사용할 수 있는 Java의 method를 작성할 때 사용하는 블록
		<%! 멤버변수 / method %>
		Java의 method와 동일 (이름 규칙도 동일)
		
		5. 주석 (이 설명들을 감싼 형태가 주석
		 --%>
	

</body>
</html>



































