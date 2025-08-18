<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, chap06.dto.Department" %>
<%

	List<Department> department = null;
	if (request.getAttribute("department") != null) {
		department = (List<Department>) request.getAttribute("department");
	}

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 목록</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/emp/css/emp_list.css">
</head>
<body>
<h3>모든 부서 목록</h3>
	
	<div class="table">
	<% if (department == null) { %>		
		<div>조회된 사원이 없습니다.</div>
	<% } else {%>
		<div class="row header">
			<div class="">부서ID</div>
			<div class="">부서이름</div>
			<div class="">매니저ID</div>
			<div class="">위치ID</div>
		</div>
		<% for(Department dep : department) {%>
			<div class="row">
				<div class=""><%=dep.getDepartment_id() %></div>
				<div class=""><%=dep.getDepartment_name() %></div>
				<div class=""><%=dep.getManager_id() %></div>
				<div class=""><%=dep.getLocation_id() %></div>
			</div>
		<% } %>
	<% } %>
	</div>
</body>
</html>