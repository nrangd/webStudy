<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="chap06.dto.Cloth"%>
<%
	String contextPath = request.getContextPath();
	String[] CLOTH_SIZE = (String[]) application.getAttribute("CLOTH_SIZES");
	
	Cloth cloth = null;
	if (request.getAttribute("cloth") == null) {
		response.sendRedirect("./list");
	} else {		
		cloth = (Cloth) request.getAttribute("cloth");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><% %></title>
</head>
<body>
	<form id="f" action="./modify" method="POST"></form>
	<div id="modify">
		<div>상품 번호</div>
		<div>
			<input form="f" name="cloth_id" type="text" value="<%=cloth.getCloth_id() %>" readonly>
		</div>
		<div>상품 파트</div>
		<div>
			<input form="f" name="cloth_part" type="text" value="<%=cloth.getCloth_part() %>">
		</div>
		<div>상품 브랜드</div>
		<div>
			<input form="f" name="cloth_brand" type="text" value="<%=cloth.getCloth_brand() %>">
		</div>
		<div>상품 가격</div>
		<div>
			<input form="f" name="cloth_price" type="text" value="<%=cloth.getCloth_price() %>">
		</div>
		<div>상품 사이즈</div>
		
		<div>
			<select form="f" name="cloth_size">
			<% for (String size : CLOTH_SIZE) {%>
				<% if(cloth.getCloth_size().equals(size)) { %>
					<option value="<%=size%>" selected><%=size %></option>
				<% } else {%>
					<option value="<%=size%>"><%=size %></option>
				<% } %>
			<% } %>
			</select>
		</div>
		
		<button type="submit" form="f">수정하기</button>
		<button id="list_btn">목록</button>
	</div>
</body>
</html>