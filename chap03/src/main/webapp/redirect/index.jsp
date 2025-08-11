<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Redirect</title>
</head>
<body>
	<h3># 리다이렉트 (Redirect)</h3>
	
	<ul>
		<li>요청을 보낸 클라이언트에게 다른 주소로 다시 요청하라고 응답하는 것</li>
		<li>클라이언트 측에서 찾아올 수 있는 주소를 응답해줘야 한다 (서버에서 찾아가는 경로 X)</li>
		<li>리다이렉트 응답을 받은 클라이언측의 웹 브라우저는 받은 주소로 새로운 요청을 다시 보낸다)</li>
		<li>요청을 새로 만들어 보내는 것이기 때문에 request 에 실려있던 데이터들은 모두 사라진다</li>
	</ul>

	<!-- a 링크의 href 속성에 데이터를 실어보내는 것도 GET방식 요청에 속한다-->	
	<a href="/chap03/redirect/snack?name=potatochip&price=2000">데이터 보내기1</a>
	<a href="/chap03/redirect/snack?name=potatochip&price=3500">데이터 보내기2</a>
	
	<form action="/chap03/redirect/snack" method="POST">
		페이지:
		<select name="userSelect">
			<option value="a">A로 가기</option>
			<option value="b">B로 가기</option>
			<option value="c">C로 가기</option>
		</select>
		<input type="hidden" name="id" value="ABC12345">
		<input type="hidden" name="name" value="chocopie">
		<input type="hidden" name="price" value="5500">
		<button type="submit">선택</button>
	</form>
</body>
</html>