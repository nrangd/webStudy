<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스너란 무엇인가</title>
</head>
<body>
	<h3># JSP Listener</h3>
	
	<ul>
		<li>웹 서버에서 특정 이벤트가 발생하기를 기다리다가 실행되는 객체</li>
		<li>ServletContextListener : 
			서블릿 컨텍스트(서버)가 시작, 종료될때마다 발생하는 이벤트에 대한 리스너</li>
		<li>ServletContextAttributeListener : 
			서블릿 컨텍스트(어플리케이션 객체)에 어트리뷰트를 추가, 제거할때마다 발생하는 이벤트에 대한 리스너</li>
		<li>HttpessionListener : 
			HTTP 세션이 시작, 종료 될때마다 발생하는 이벤트에 대한 리스터</li>
		<li>HttpessionAttrubuteLisneter : 
			세션 객체에 어트리뷰트를 추가, 제거할때마다 발생하는 이벤트에 대한 리스터</li>
		<li>ServletRequestListener :
			요청이 발생했을때와 응답을 수행하여 요청 객체가 파괴될때 발생하는 이벤트에 대한 리스너</li>
		<li>ServletRequestAttributeListner : 
			요청 객체에 어트리뷰트를 추가, 제거할때마다 발생하는 이벤트에 대한 리스너</li>
	</ul>
	
	<h3># 아이스크림 목록</h3>
	
	<ol>
		<li>application: ${applicationScope.icecream}</li>
		<li>session: ${sessionScope.icecream}</li>
		<li>request: ${icecream}</li>
	</ol>
</body>
</html>