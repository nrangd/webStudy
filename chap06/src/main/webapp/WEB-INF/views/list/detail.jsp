<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="chap06.dto.Cloth"%>
<%
	String contextPath = request.getContextPath();

	Cloth cloth = null;
	if (request.getAttribute("cloth") == null) {
		// response.sendRedirect(contextPath + "/cloth/list");
		System.out.println("문제가 생겨서 리다이렉트");
		response.sendRedirect("./list");
	} else {		
		cloth = (Cloth) request.getAttribute("cloth");
		System.out.println("cloth받음");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><%=cloth.getCloth_id() %>번 상품 상세정보</title>
	<link rel="stylesheet" href="<%=contextPath %>/resources/cloth/css/detail.css">
</head>
<body>
	
	<div>
		<div>상품 번호</div>
		<div><%=cloth.getCloth_id() %></div>
		<div>상품 파트</div>
		<div><%=cloth.getCloth_part() %></div>
		<div>상품 브랜드</div>
		<div><%=cloth.getCloth_brand() %></div>
		<div>상품 가격</div>
		<div><%=cloth.getCloth_price() %></div>
		<div>상품 사이즈</div>
		<div><%=cloth.getCloth_size() %></div>
	</div>
	
	<button id="modify_btn" onclick="moveTo('./modify?cloth_id=<%=cloth.getCloth_id()%>')">수정</button>
	<button id="delete_btn" onclick="moveTo('./delete?cloth_id=<%=cloth.getCloth_id()%>')">삭제</button> <!-- 삭제 기능 구현하기 -->
	<button id="list_btn">목록</button>
	
	<script src="<%=contextPath %>/resources/cloth/js/detail.js"></script>
</body>
</html>