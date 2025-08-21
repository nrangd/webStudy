<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include</title>
</head>
<body>
	<h3># Include 기능을 이용해 파일 분할하기</h3>
	
	<ol>
		<li>
			JSP Include : 
			getRequestDispatcher.forward(request, response)처럼
			request와 response를 다른 서블릿으로 전달하여 응답 객체에 내용을 추가한 후에
			다시 현재 서블릿으로 돌아와서 응답 객체 생성을 계속 진행하게 된다
		</li>
		<li>file Include : 
			현재 파일에 해당 파일의 내용을 포함시켜버린 후 컴파일을 진행하여 응답을 생성한다
		</li>
	</ol>
	
	<div>
		<a href="./jsp_include/main.jsp">JSP include 해보러 가기...</a> <br>
		<a href="./file_include/main.jsp">File include 해보러 가기...</a> <br>
	</div>
</body>
</html>