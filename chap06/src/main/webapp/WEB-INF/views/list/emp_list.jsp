<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, chap06.dto.Employee"%>
<%
	List<Employee> employees = null;
	if (request.getAttribute("employees") != null) {
		employees = (List<Employee>) request.getAttribute("employees");
		
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사원 목록</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/emp/css/emp_list.css">
</head>
<body>
	<h3>모든 사원 목록</h3>
	
	<div class="table">
	<% if (employees == null) { %>		
		<div>조회된 사원이 없습니다.</div>
	<% } else {%>
		<div class="row header">
			<div class="first_name">First Name</div>
			<div class="last_name">Last Name</div>
			<div class="salary">Salary</div>
			<div class="commission_pct">Commission Pct</div>
			<div class="phone_number">Phone Number</div>
			<div class="email">Email</div>
		</div>
		<% for(Employee employee : employees) {%>
			<div class="row">
				<div class="first_name"><%=employee.getFirst_name() %></div>
				<div class="last_name"><%=employee.getLast_name() %></div>
				<div class="salary"><%=employee.getSalary() %></div>
				<div class="commission_pct"><%=employee.getCommission_pct() %></div>
				<div class="phone_number"><%=employee.getPhone_number() %></div>
				<div class="email"><%=employee.getEmail() %></div>
			</div>
		<% } %>
	<% } %>
	</div>
</body>
</html>