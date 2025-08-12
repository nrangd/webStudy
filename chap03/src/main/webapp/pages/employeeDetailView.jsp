<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object employee_id = request.getAttribute("employee_id");
	Object first_name = request.getAttribute("first_name");
	Object last_name = request.getAttribute("last_name");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><%=first_name %> <%=last_name %>의 상세 정보</title>
</head>
<body>
	<div>
		<div>사번: <%=employee_id %></div>
		<div>이름: <%=first_name %></div>
		<div>성: <%=last_name %></div>
	</div>
</body>
</html>