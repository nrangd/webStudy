<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="chap04.model.User"%>
<%
	String contextPath = request.getContextPath();

	boolean isLogin = false;
	if (session.getAttribute("login") != null) {
		isLogin = (boolean) session.getAttribute("login");
	}
	
	User user = null;
	if (isLogin) {
		user = (User) session.getAttribute("user");
	}
	
	int tryCount = session.getAttribute("try_count") == null ? 0 : (int) session.getAttribute("try_count");
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
	
	<% if (tryCount >= 1) { %>
		<div><%=tryCount %>회 시도했습니다</div>
	<% } %>
	
	<% if (!isLogin) {%>
		<form action="<%=contextPath %>/login2" method="POST">
			ID<input type="text" id="id" name='user_id'>
			PASSWORD<input type="password" id="password" name='user_password'>
			<input type="submit" value="로그인" />
		</form>
	<% } else { %>
		<div>'<%= user.getUser_id() %>' 님이 로그인하셧습니다.</div>
		<div>
			<img src="<%=contextPath + user.getProfile_image_path() %>" alt="<%=user.getUser_id()%>님의 이미지">
		</div>
	<% } %>
	
	
</body>
</html>