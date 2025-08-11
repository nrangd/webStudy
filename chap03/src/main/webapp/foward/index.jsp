<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Foward</title>
</head>
<body>
	<h3># 포워드 (Forward)</h3>
	
	<ul>
		<li>사용자의 요청을 처리하던 도중에 나머지 처리는 다른 서블릿(또는 jsp)으로 넘겨서 마저 처리하는 것</li>
		<li>사용자가 보낸 요청 객체를 그대로 다음 서블릿으로 전달하기 때문에
			요청에 실려있던 값들도 삭제되지 않고 그대로 전달된다</li>
		<li>포워드는 주로 서블릿에서 자바 코드가 많이 필요한 처리들(백엔드)을 모두 마친 후
			HTML이 많이 필요한 처리(프론트엔드)를 위해 JSP로 넘기는 용도로 많이 사용한다</li>
	</ul>
	
	<!-- input 태그가 form 바깥에 있을 때 form 속성을 사용해 해당 form 의 소속으로 만들어 줄 수 있다 -->
	<form id="snack-form" action="/chap03/foward/snack" ></form>
	
	<!-- form 속성에는 form 의 id 를 값으로 넣는다 -->
	<input type="text" name="id" value="213124" form="snack-form"> <br>
	<input type="text" name="name" value="계란과자" form="snack-form"> <br>
	<input type="text" name="price" value="2000" form="snack-form"> <br>
	<select name="userSelect" form="snack-form">
		<option value="a">A로 가기</option>
		<option value="b">B로 가기</option>
		<option value="c">C로 가기</option>
		<option value="d">D로 가기</option>
	</select>
	<input type="submit" value="전송하기" form="snack-form"> <br>
	
</body>
</html>