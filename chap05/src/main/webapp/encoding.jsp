<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h3># JSP의 여러가지 charset 설정</h3>
	
	<dl>
		<dt>1. html의 meta태그에 설정되어있는 charset 설정</dt>
		<dd>이 페이지를 해석하는 웹 브라우저가 사용하게 되는 charset설정</dd>
		<dt>2. contentType에 설정된 charset 설정</dt>
		<dd>이 서블릿의 실행 결과로 만들어지는 응답을 생성할 때 사용하는 charset</dd>
		<dt>3. pageEncoding에 설정되어있는 charset 설정</dt>
		<dd>이 JSP 페이지(.jsp)를 서블릿(.java)으로 변환할 때 사용할 charset</dd>
	</dl>
	
	<h3># GET 방식으로 한글 보내기</h3>
	
	<ul>
		<li>GET방식은 URL에 데이터를 실어보내는 방식이므로,
			서버가 해당URL을 해석할 때 서버에 설정된 파라미터 인코딩 타입(charset)으로 request 객체에 파라미터를 추가한다</li>
		<li>GET방식을 사용할 때 한글이 깨지는 문제가 발생한다면 서버의 설정을 건드려야 한다</li>
	</ul>
	
	<form action="<%=request.getContextPath() %>/test/encoding" method="GET">
		<input type="text" name="name" value="Allen">
		<input type="text" name="age" value="30">
		<input type="submit" value="확인">
	</form>
	
	<h3># POST 방식으로 한글 보내기</h3>
	
	<ul>
		<li>POST방식 요청은 request 객체의 body 내부에 실려있는 데이터를
			디코딩하여 파라미터에 추가하는 것이기 때문에 request 객체에 설정된 인코딩 타입을 설정해줘야 한다</li>
		<li>POST방식 요청에서 한글이 깨지는 문제가 발생한다면
			request 객체의 charset을 설정해줘야 한다</li>
	</ul>
	
	<form action="<%=request.getContextPath() %>/test/encoding" method="POST">
		<input type="text" name="name" value="Allen">
		<input type="text" name="age" value="30">
		<input type="submit" value="확인">
	</form>
	
	<h3># 자바스크립트로 요청 보내기</h3>
	 
	<button id="postBtn">post</button>
	<button id="getBtn">get</button>
	
	<form id="f" method="POST"></form>
	<input type="hidden" name="name" value="초코하임" form="f">
	<input type="hidden" name="age" value="30" form="f">
	
	<script>
		const contextPath = '<%=request.getContextPath() %>'
	</script>
	<script src="<%=request.getContextPath() %>/resources/encoding.js"></script>
</body>
</html>