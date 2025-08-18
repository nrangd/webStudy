<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, dbListTest.dto.Something"%>
<%
	List<Something> somethings = (List<Something>) request.getAttribute("something");
	System.out.println(somethings);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>cloth list</title>
	<style>
		.table {
			width: fit-content;
		}
		
		.row {
			display: flex;
			border-bottom: 1px solid white;
		}
		
		.row > div {
			margin: 0 2px;
			width: 100px;
		}
		
		.header {
			background-color: coral;
			
		}
	</style>
</head>
<body>
	<h3>옷목록 보여주는곳</h3>
	<div class="table">
		<div class="row header">
			<div>id</div>
			<div>str1</div>
			<div>str2</div>
			<div>date</div>
			<div>number</div>
		</div>
		<% if (somethings.size() != 0) { %>
			<% for(Something s : somethings) { %>
				<div class="row">
					<div><%=s.getSt_id() %></div>
					<div><%=s.getSt_str1() %></div>
					<div><%=s.getSt_str2() %></div>
					<div><%=s.getSt_date() %></div>
					<div><%=s.getSt_number() %></div>
				</div>
			<% } %>
		<% } else if(somethings.size() == 0) { %>
			<div>비어있음!</div>
		<% } else { %>
			<p>List가 Null임</p>
		<% } %>
		<button id="data_add_btn">데이터 추가하기</button>
	</div>
</body>
</html>