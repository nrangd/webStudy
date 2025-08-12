<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인 페이지</title>
</head>
<body>
	
	<h1>여기는 들어오면 팝업창이 뜨는 곳입니다.</h1>
	
	<script>
		// window.open(url, title, options)
		window.open('./popup.jsp', '팝업입니다', 'width=250, height=300');
	</script>
</body>
</html>