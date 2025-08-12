<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// jsp에서 session은 내장객체라서 별도 선언없이 사용가능
	Object login_success = session.getAttribute("login_success");
	Object tryCount = session.getAttribute("tryCount");
	if(tryCount == null) {
		tryCount = 0;
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Session Attribute Test</title>
</head>
<body>

	<p>
		연습 문제: 해당 세션에서 로그인 시도를 3번 실패하면 더 이상 로그인을 시도할 수 없게 
		입력란을 비활성화하기
	</p>

	<% if (login_success == null || !((boolean) login_success)) {%>
		<form action="/chap03/attr/test/s" method="POST">
		<% if ((int)tryCount >= 3) { %>
			ID <input type="text" name="user_id" disabled> <br>
			패스워드 <input type="password" name="user_password" disabled> <br>	
		<% } else { %>
			ID <input type="text" name="user_id"> <br>
			패스워드 <input type="password" name="user_password"> <br>			
		<% } %>
			<button type="submit">로그인</button>
		</form>
	
	<% } else { %>
		<div>test 님이 로그인 중입니다</div>
	<% } %>
</body>
</html>