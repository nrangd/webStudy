<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, dbListTest2.dto.BBS"%>
<%
	List<BBS> list = null;
	if(request.getAttribute("bbs_list") != null) {
		list = (List<BBS>) request.getAttribute("bbs_list");
	} else {
		System.out.println("전달받은 값이 비어있음");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 리스트 페이지</title>
	<style type="text/css">
		.header {
			background-color: coral;
		}
		.row {
			display: flex;
			width: fit-content;
			background-color: antiquewhite;
			border-bottom: 1px solid beige;
		}
		.row > div {
			width: 100px;
		}
	</style>
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

	<div id="list">
		<div class="row header">
			<div>번호</div>
			<div>제목</div>
			<div>등록날짜</div>
			<div>등록예약날짜</div>
			<div>분류탭</div>
		</div>
		<% if(list.size() != 0) { %>
			<% for (BBS bbs : list) { %>
				<div class="row">
					<div><%=bbs.getBbs_number() %></div>
					<div><%=bbs.getBbs_subject() %></div>
					<div><%=bbs.getBbs_regist_date() %></div>
					<div><%=bbs.getBbs_reservation_date() %></div>
					<div><%=bbs.getBbs_keyword() %></div>
				</div>
			<% } %>
		<% } else if(list.size() == 0) { %>
			<div>비어있음</div>
		<% } else {%>
			<div>테이블을 불러오는데 문제가생김</div>
		<% } %>
	</div>
	<button id="add-btn">추가하기</button>
	
	<script>
		const add = document.getElementById('add-btn');
		add.addEventListener('click', (e) => {
			location.href="./add";
		});
	</script>
</body>
</html>