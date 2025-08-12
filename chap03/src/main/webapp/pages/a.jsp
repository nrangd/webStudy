<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파라미터는 HTML로부터 넘어오는 값이기 때문에 어떤 값이 오더라도 문자열로 꺼낸다
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String price = request.getParameter("price");
	
	// 어트리뷰트는 다른 자바 서블릿에서 만들어진 값이기 때문에 자바의 타입이 그대로 유지된다
	// (어떤 타입이 들어있을지는 모르므로, 오브젝트 타입으로 꺼낸 후 다운 캐스팅해야 한다)
	int saledPrice = (int)request.getAttribute("saledPrice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>A</h3>
	
	<table>
		<tr>
			<th>과자ID</th>
			<td><%=id %></td>
		</tr>
		<tr>
			<th>과자이름</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><%=price %></td>
		</tr>
		<tr>
			<th>세일된 가격</th>
			<td><%=saledPrice %></td>
		</tr>
		
	</table>
</body>
</html>