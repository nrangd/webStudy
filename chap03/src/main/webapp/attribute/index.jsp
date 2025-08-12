<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attribute 테스트 페이지</title>
</head>
<body>
	
	<h3># 어트리뷰트 (Attribute)</h3>
	
	<ul>
		<li>요청을 받으면 원하는 처리를 수행한 후 결과를 저장해 놓을 수 있는 곳</li>
		<li>page, request, session, application 영역(scope)이 있다</li>
		<li>영역별로 저장한 데이터가 유지되는 기간이 다르다</li>
	</ul>
	
	<h3># Request Attribute</h3>
	
	<ul>
		<li>하나의 요청에 대해 응답하기 전까지 유지되는 어트리뷰트</li>
		<li>주로 서블릿에서 처리한 데이터를 포워드를 통해 JSP페이지로 전달하기 위해 사용된다</li>
		<li></li>
	</ul>
	
	<a href="./test/requestAttrTest.jsp">request 어트리뷰트 테스트하기</a>
	
	<h3># Session Attribute</h3>
	
	<ul>
		<li>서버로부터 발급받은 세션이 만료될때까지 수명이 유지되는 어트리뷰트</li>
		<li>서버는 해당 서버에 최초로 요청을 보낸 클라이언트에게 세션ID를 응답한다</li>
		<li>발급받은 세션ID는 유일한 값이며 해당 클라이언트 본인임을 증명할 수 있는 식별값이 된다</li>
		<li>해당 세션ID를 가지고 있는 클라이언트만이 해당 세션 객체에 접근할 수 있다</li>
		<li>세션은 접속 시간이 너무 오래되거나 웹 브라우저를 종료하면 사라진다 (ex. 은행 사이트)</li>
	</ul>
	
	<a href="./test/sessionAttrTest.jsp">session Attribute 테스트</a>
	
	<h3># Application Attribute</h3>
	
	<ul>
		<li>서버가 켜져 있는 동안 유지되는 어트리뷰트 영역</li>
		<li>데이터를 서버에 저장해놓는다</li>
		<li>세션 객체는 세션 ID의 개수(접속자 수)만큼 존재하지만
			서버는 1대이므로 어플리케이션 객체는 스태틱 변수 같은 역할을 하게된다</li>
	</ul>
	
	<h3># Page Attribute</h3>
	
	<ul>
		<li>현재 서블릿 내부에서만 사용하기 위한 어트리뷰트</li>
		<li>이 서블릿을 벗어나는 수간부터 유효하지 않기 때문에 포워드 등이 먹히지 않는다</li>
		<li>현재 서블릿에서 지역 변수처럼 활용하기 위한 어트리뷰트</li>
	</ul>
	
	<ul>
		<li>application 영역에 추가한 값: <%=application.getAttribute("animal") %></li>
		<li>session 영역에 추가한 값: <%=session.getAttribute("animal") %></li>
		<li>request 영역에 추가한 값: <%=request.getAttribute("animal") %></li>
		<li>page 영역에 추가한 값: <%=pageContext.getAttribute("animal") %></li>
	</ul>
	
	<a href="./addAllAttribute.jsp?way=redirect">다른 JSP페이지에 가서 속성추가하고 돌아오기 (리다이렉트)</a> <br>
	<a href="./addAllAttribute.jsp?way=forward">다른 JSP페이지에 가서 속성추가하고 돌아오기 (포워드)</a> <br>
</body>
</html>