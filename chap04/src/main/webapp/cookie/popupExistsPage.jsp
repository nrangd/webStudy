<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean userWantsPopup = true;

	Cookie[] cookies = request.getCookies();
	
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("popup") && cookie.getValue().equals("no")) {
				userWantsPopup = false;
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인 페이지</title>
</head>
<body>
	
	<h1>여기는 들어오면 팝업창이 뜨는 곳입니다.</h1>
	
	<% if (userWantsPopup) {%>
	<script>
		// window.open(url, title, options)
		var popup = window.open('./popup.jsp', '팝업입니다', 'width=250, height=300');
		
	</script>
	<% } %>
</body>
</html>