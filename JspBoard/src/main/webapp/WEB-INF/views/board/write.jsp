<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h3>글쓰기</h3>
	
	<form id="f" action="./write" method="POST" >
		글 제목 <input type="text" name="board_title" />
		작성자 <input type="text" name="board_writer" />
		비밀번호 <input type="password" name="board_password" /> <br>
		
		글내용 : <br>
		<textarea name ="board_content" rows="30" cols="10"></textarea>
	</form>
	
	<button type="submit" form="f">글쓰기</button>
	<button onclick="location.href='./'">목록</button>
</body>
</html>