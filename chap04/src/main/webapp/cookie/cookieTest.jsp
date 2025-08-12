<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 요청에는 현재 경로에서 사용되는 모든 쿠키들이 포함되어 있다.
	Cookie[] cookies = request.getCookies();
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>cookieTest</title>
</head>
<body>
	
	<% if (cookies != null) { %>
		<h3>현재 페이지를 구성하기 위해 사용할 수 있는 모든 쿠키들</h3>
		<ul>
		<% for (int i = 0; i < cookies.length; i++) {%>
			<li>
				<%=cookies[i].getName() %>=<%=cookies[i].getValue() %>
				<a href="<%=contextPath %>/cookie/test/delete?to_delete=<%=cookies[i].getName() %>">[이 쿠키 삭제]</a>
			</li>
		<%} %>
		</ul>
	<%} %>
	
	<a href="<%=contextPath %>/cookie/test/add">새 쿠키 생성하기</a>
	
	
	<script>
		console.log(document.cookie);
	</script>
</body>
</html>