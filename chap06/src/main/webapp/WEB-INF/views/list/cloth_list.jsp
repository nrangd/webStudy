<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, chap06.dto.Cloth"%>
<%
	List<Cloth> clothes= (List<Cloth>) request.getAttribute("cloth");
	String contextPath = request.getContextPath();
	System.out.println("jsp에서 받은 clothes: " + clothes);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>옷 목록</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/emp/css/emp_list.css">
</head>
<body>
	<h3>옷장 목록</h3>
	
	<div class="table">
		
		<div class="row header">
			<div>의류종류</div>
			<div>의류브랜드</div>
			<div>의류가격</div>
			<div>의류사이즈</div>
			<div>의류ID</div>
		</div>
		<% if(clothes != null) { %>
			
			<% for(Cloth cl : clothes) {%>
				<div class="row">
					<div><%=cl.getCloth_part() %></div>
					<div><%=cl.getCloth_brand() %></div>
					<div><%=cl.getCloth_price() %></div>
					<div><%=cl.getCloth_size() %></div>
					<div><%=cl.getCloth_id() %></div>
				</div>
			<% } %>
			
		<%} else {%>
			비어있음
		<%} %>
	</div>
	
	<button id="add_btn">새 상품 추가하기</button>
	
	<script src="<%=contextPath%>/resources/cloth/js/cloth_list.js"> </script>
</body>
</html>