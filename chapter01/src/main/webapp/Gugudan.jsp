<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		div > div {
			display: flex;
			flex-direction: column;
			min-width: fit-content;
		} 
	</style>
</head>
<body>
	<h3># JSP로 구구단 출력하기</h3>
	
	<div style="display: flex; column-gap: 20px;">
		<%
		for (int i = 2; i <= 9; i++) {
		%>
			<div>
			<%
			for(int j = 1; j <= 9; j++) {
			%>
			
				<span><%= String.format("%d * %d = %d",i , j , i * j) %></span>
			
			<%
			}
			%>
			</div>
		<%
		}
		%>
	</div>
</body>
</html>