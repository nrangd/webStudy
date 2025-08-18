<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 상품 등록하기</title>
</head>
<body>
	<form action = './add' method="POST">
		옷 종류: <input type="text" name="cloth_part" value="Jean"/> <br>
		브랜드: <input type="text" name="cloth_brand" value="Levis"/> <br>
		가격: <input type="number" name="cloth_price" value="1000"/> <br>
		사이즈: <input type="text" name="cloth_size" value="L"/> <br>
		
		날짜: <input type="date" name="release_date"/> <br>
		<input type="submit" value="추가"/>
	</form>
</body>
</html>