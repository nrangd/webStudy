<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${bbs_list.bbs_subject }</title>
</head>
<body>
	이 페이지로 이동시켜주는 서블릿에서
	파라미터로 bbs모델(dto)을 받아서
	해당값으로 페이지 구성하기
	
	여기서 삭제 및 수정이 가능한 버튼들 달아주기
	
	수정 버튼을 누르면 bbs_edit페이지로 이동시켜주고
	삭제 버튼을 누르면 서블릿으로 가서 데이터 처리 후 다시 리스트로 돌아가도록 만들기
	
	<div class="table">
		<div class="subject">
			${bbs_list.bbs_subject }
		</div>
		<div class="content">
			<pre>${bbs_list.bbs_content}</pre>
		</div>
		<div class="comment">댓글창</div>
	</div>
</body>
</html>