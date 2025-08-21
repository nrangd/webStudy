<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${bbs_list.bbs_subject}</title>
</head>
<body>
	<form id="f" method="POST"></form>
	제목 : 
	<input type="text" form="f" name="bbs_subject" value="${bbs_list.bbs_subject }"> <br>
	분류 : 
	<select form="f" name="bbs_keyword">
		<%-- <% for (String key : KEYWORDS) { %>
			<option value="key"><%=key %></option>
		<% } %> --%>
		<c:forEach items="${KEYWORDS}" var="key">
			<c:choose>
				<c:if test="${bbs_list.keyword == key }">
					<option value="key" selected>${key }</option>
				</c:if>
				<c:otherwise>
					<option value="key">${key }</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select> <br>
	예약날짜 
	<input type="date" form="f" name="bbs_reservation_date"> <br>
	<textarea rows="30" cols="70" form="f" name="bbs_content"></textarea> <br>
	<button id="edit-btn">수정하기</button>
	
	<script type="text/javascript">
		const add_btn = document.getElementById('edit-btn');
		add_btn.addEventlistener('click', (e) => {
			location.href="./edit";
		});
	</script>
</body>
</html>