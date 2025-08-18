<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList, chap06.dto.Job" %>
<%

	List<Job> jobs = null;
	if (request.getAttribute("job") != null) {
		jobs = (ArrayList<Job>) request.getAttribute("job");
	}
	System.out.println(jobs);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직무 목록</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/emp/css/emp_list.css">
</head>
<body>
<h3>모든 직무 목록</h3>
	
	<div class="table">
	<% if (jobs == null) { %>		
		<div>조회된 사원이 없습니다.</div>
	<% } else {%>
		<div class="row header">
			<div class="">직무id</div>
			<div class="">직무이름</div>
			<div class="">최소월급</div>
			<div class="">최대월급</div>
		</div>
		<% for(Job job : jobs) {%>
			<div class="row">
				<div class=""><%=job.getJob_id() %></div>
				<div class=""><%=job.getJob_title() %></div>
				<div class=""><%=job.getMin_salary() %></div>
				<div class=""><%=job.getMax_salary() %></div>
			</div>
		<% } %>
	<% } %>
	</div>
</body>
</html>