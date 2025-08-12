<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Attribute Test</title>
</head>
<body>
	사원번호:
	<select name="employee_id" form="f">
		<option value="101">101</option>
		<option value="102">102</option>
		<option value="103">103</option>
	</select>
	<button type="submit" form="f">조회</button>
	
	<form id="f" action="/chap03/attr/test/r"></form>
</body>
</html>