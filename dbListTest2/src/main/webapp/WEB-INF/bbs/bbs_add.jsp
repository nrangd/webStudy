<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] KEYWORDS= (String[]) application.getAttribute("KEYWORDS");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블 값 입력</title>
</head>
<body>

<!-- 

BBS_ID NUMBER NOT NULL 
, BBS_NUMBER NUMBER NOT NULL 
, BBS_SUBJECT VARCHAR2(100) 
, BBS_REGIST_DATE DATE 
, BBS_RESERVATION_DATE DATE 
, BBS_CONTENT VARCHAR2(2000) 
, BBS_KEYWORD VARCHAR2(20)

 -->

	<form id="f"></form>
	제목 : 
	<input type="text" form="f" name="bbs_subject"> <br>
	분류 : 
	<select form="f" name="bbs_keyword">
		<% for (String key : KEYWORDS) { %>
			<option value="key"><%=key %></option>
		<% } %>
	</select> <br>
	예약날짜 
	<input type="date" form="f" name="bbs_reservation_date"> <br>
	<textarea rows="30" cols="70" form="f" name="bbs_content"></textarea> <br>
	<button id="add-btn">등록하기</button>
	
</body>
</html>