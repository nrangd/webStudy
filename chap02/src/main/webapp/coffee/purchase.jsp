<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	// form으로 전달한 데이터들은 모두 request 객체에 실려있다
	// request 내장 객체는 Servlet의 HttpServletRequest 타입 매개변수와 같은 객체이다
	String menu = request.getParameter("menu");
	String qty = request.getParameter("qty");
	String comment = request.getParameter("comment");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>주문확인페이지</title>
</head>
<body>
	<h3>주문 확인</h3>
	
	<ul>
		<li>메뉴 : <%=menu %></li>
		<li>수량 : <%=qty %></li>
		<li>요청사항 : <%=comment %></li>
	</ul>
</body>
</html>