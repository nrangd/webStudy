<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>팝업임</title>
	<link rel="stylesheet" href="/chap04/resources/popup.css">
</head>
<body>
	<div id="apple"></div>
	<div id="nomore">
		<label for="chk">오늘 하루 그만보기</label>
		<input id="chk" type="checkbox">
	</div>
	
	<script src="/chap04/resources/popup.js"></script>
	
	<!-- 
	<script type="text/javascript">
		// 직접 X눌러서 창을 닫는 이벤트는 보통 잘 안쓰는듯 하다..
		const chk = document.getElementById('chk');
		window.addEventListener('beforeunload', (e) => {
			location.href="/chap04/cookie/test/popup";
			window.alert("창이 닫힙니다");
			if (chk.checked) {
			}
		});
		
	</script>
	 -->
</body>
</html>