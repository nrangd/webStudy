<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jsp_include</title>
	<link rel="stylesheet" href="/chap08/assets/css/jsp_include.css" />
</head>
<body>
	<div id="main">
		<jsp:include page="header.jsp"/>
		<jsp:include page="nav.jsp"/>
		<jsp:include page="content.jsp"/>
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>