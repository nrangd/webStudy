<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠키란 무엇인가</title>
</head>
<body>
	<h3># HTTP Cookie</h3>
	
	<ul>
		<li>서버가 클라이언트의 웹 브라우저에 데이터를 보관할 수 있는 기능</li>
		<li>쿠키도 데이터를 파라미터나 어트리뷰트처럼 name/value 형태로 보관한다</li>
		<li>클라이언트는 해당 서버로 요청을 보낼때마다 본인이 보유한 모든 쿠키를 요청에 실어보내게 된다</li>
		<li>서버측에서는 요청 객체에 들어있는 쿠키를 꺼내서 확인해볼 수 있다</li>
		<li>서버는 응답에 원하는 쿠키를 실어 보내면 웹 브라우저는 해당 쿠키를 새로 등록하고
			다음번 요청부터 해당 쿠키를 요청에 포함시킨다</li>
		<li>쿠키의 수명은 서버측에서 설정이 가능하다</li>
		<li>수명이 끝난 쿠키는 웹 브라우저에서 저절로 사라진다</li>
		<li>쿠키는 언제든지 클라이언트 측에서 열어볼 수 있고 위/변조가 가능한 값이기 때문에
			해당 사실에 대해 항상 인지하고 있어야 한다</li>
	</ul>
	
	<a href="./cookieTest.jsp">쿠키 기본 테스트 하러가기</a> <br>
	
	<a href="./popupExistsPage.jsp">쿠키 팝업 테스트하러 가기...</a> <br>
	
</body>
</html>