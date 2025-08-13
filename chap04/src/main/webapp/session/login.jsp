<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int tryCount = request.getAttribute("tryCount") == null ? 0 : (int) request.getAttribute("tryCount");
	System.out.println(tryCount);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3># 간단한 로그인 기능을 만들어보세요</h3>
	
	<ul>
		<li>ID와 비밀번호를 올바르게 입력하면 로그인을 성공한다</li>
		<li>로그인을 성공한 사람은 이 페이지에 'xx'님이 로그인중입니다.
			라는 메세지와 그 사람이 설정해 놓은 그림이 하나 보여야 한다.</li>
		<li>로그인을 실패한 사람은 다시 이 페이지로 리다이렉트 하되
			이 페이지에서는 로그인 실패 횟수를 출력해주어야 한다</li>
		<li>ID와 비밀번호는 현재 프로젝트의 /data/member.txt에 저장되어 있는 내용을 사용한다</li>
	</ul>
	
	<form action="/chap04/login" method="POST">
		ID<input type="text" id="id" name='id'>
		PASSWORD<input type="password" id="password" name='password'>
		<input type="submit" value="로그인" />
	</form>
	<% if (tryCount >= 1) { %>
		<div><%=tryCount %>회 시도했습니다</div>
	<% } %>
</body>
</html>