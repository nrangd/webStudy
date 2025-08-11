<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	
	<h3># Form</h3>
	
	<ul>
		<li>form 태그는 해당 form 태그 내부에 있는 데이터를 모아서
			요청에 함께 실어 보낼 수 있는 태그</li>
		<li>요청에 실어 보낸 데이터는 서버측에서 받아 확인 할 수 있다</li>
		<li>form 태그 내부의 데이터는 key/value 방식으로 전송된다</li>
		<li>데이터가 실려있는 태그의 name 속성이 key 역할을 한다</li>
		<li>데이터가 실려있는 태그의 value 속성이 value 역할을 한다</li>
		<li>form 태그의 action 속성이 해당 form 에서 요청을 보낼 주소를 적는다</li>
		<li>form 태그의 method 속성에 요청 방식을 설정한다 (GET or POST)</li>
	</ul>
	
	<h3># Get 방식 요청</h3>
	
	<ul>
		<li>form 의 method 속성에 Get 이라고 적어놓으며 Get 방식 요청이 된다</li>
		<li>Get 방식을 요청을 보내면 데이터가 주소창에 다음과 같이 보이면서 전송된다
			(?name1=value1&name2=value2&...)</li>
		<li>Get 방식은 데이터가 주소창에 노출되기 때문에 민감한 데이터들을 전송하기에는 적합하지 않다</li>
		<li>URL에는 최대 길이 제한이 있기 때문에 Get 방식으로 보낼 수 있는 데이터의 양에는 한계가 있다
			(글 내용 등)</li>
	</ul>
	
	<h3># Post 방식 요청</h3>
	
	<ul>
		<li>Post 방식은 전송하는 데이터가 주소창에 노출되지 않으며 요청 객체의 내부에 실려 함께 전달된다
			(요청 객체의 body 라는 곳에 실려 전달됨)</li>
		<li>비밀번호 같은 데이터가 대놓고 노출되지는 않기 때문에 Get 방식 보다는 안전하다</li>
		
	</ul>
	
	<h3>#청년다방 온라인 주문 (GET)</h3>
	
	<form action="/chap02/coffee/purchase.jsp" method="get">
		<input type="text" name = "menu" value="아메리카노"/>
		<select name="qty">
			<option value="1">1개</option>
			<option value="2">2개</option>
			<option value="3">3개</option>
		</select> <br>
		<textarea name="comment" cols="30" rows="10">얼음 갈아서 주세요</textarea> <br>
		<input type = "submit" value = "주문하기">
	</form>
	
	<h3>#청년다방 온라인 주문 (POST)</h3>
	
	<form action="/chap02/coffee/purchase.jsp" method="post">
		<input type="text" name = "menu" value="Americano"/>
		<select name="qty">
			<option value="1">1개</option>
			<option value="2">2개</option>
			<option value="3">3개</option>
		</select> <br>
		<textarea name="comment" cols="30" rows="10">얼음얼음</textarea> <br>
		<input type = "submit" value = "주문하기">
	</form>
	
	<h3>#청년다방 온라인 주문 (GET, 서블릿으로 보내기)</h3>
	
	<form action="/chap02/coffee/purchase" method="get">
		<input type="text" name = "menu" value="Americano"/>
		<select name="qty">
			<option value="1">1개</option>
			<option value="2">2개</option>
			<option value="3">3개</option>
		</select> <br>
		<textarea name="comment" cols="30" rows="10">얼음얼음</textarea> <br>
		<input type = "submit" value = "주문하기">
	</form>
	
	<h3># 청년다방 온라인 주문 (POST, 서블릿으로 보내기)</h3>
	
	<form action="/chap02/coffee/purchase" method="post">
		<input type="text" name = "menu" value="Americano"/>
		<select name="qty">
			<option value="1">1개</option>
			<option value="2">2개</option>
			<option value="3">3개</option>
		</select> <br>
		<textarea name="comment" cols="30" rows="10">얼음얼음</textarea> <br>
		<input type = "submit" value = "주문하기">
	</form>
	
	<h3># 하나의 name 에 여러개의 값이 들어있는 경우 (checkBox 등)</h3>
	
	<h3>베스킨라빈스 맛 고르기</h3>
	
	<form action="/chap02/baskin" method="GET" 
		style="width: 500px; border: solid 3px gray; padding: 5px;">
		사이즈:
		<input id="single-regular" type="radio" name="size" value="115" checked>
		<label for="single-regular">싱글레귤러</label>
		<input id="single-king" type="radio" name="size" value="145">
		<label for="single-king">싱글킹</label>
		<input id="pint" type="radio" name="size" value="320">
		<label for="pint">파인트</label>
		<input id="quarter" type="radio" name="size" value="620">
		<label for="quarter">쿼터</label>
		<hr>
		맛: 
		<input id="strawberry" type="checkbox" name="flavor" value="strawberry">
		<label for="strawberry">딸기</label>
		<input id="mintchoco" type="checkbox" name="flavor" value="mintchoco">
		<label for="mintchoco">민트초코</label>
		<input id="mintapple" type="checkbox" name="flavor" value="mintapple">
		<label for="mintapple">민트애플</label>
		<input id="pineapple" type="checkbox" name="flavor" value="pineapple">
		<label for="pineapple">파인애플</label>
		<input id="alien" type="checkbox" name="flavor" value="alien">
		<label for="alien">외계인</label> <br>
		<hr>
		<button type="submit">주문하기</button>
	</form>
	
	<script src = "jquery-3.7.1.min.js"></script>
	<script type="text/javascript">
		const size = document.getElementsByName('size');
		const flavor = document.getElementsByName('flavor');

		// size.forEach((radio) => {
		// 	radio.addEventListener('change', (e) => {
		// 		const curr = e.currentTarget;

		// 		if(curr.checked) {
		// 			console.log(curr.value);
		// 		}
		// 	});
		// });

		// size[0].addEventListener('change', e => {
		// 	const curr = e.currentTarget;

		// 	if(curr.checked) {
		// 		let chkCount = 0;
		// 		flavor.forEach(checkbox => {
		// 			if(checkbox.checked) {
		// 				chkCount++;
		// 			}
		// 		});

		// 		if(chkCount > 1) {
		// 			alert("한개만 선택해주세요");
		// 		}
		// 	}
		// });

		$("input[name=size]").change(function() {
			$('input:checkbox[name=flavor]').each(function() {
				if(this.checked) {
					this.checked = false;
				}
			});
		})

		// $(document).ready(function(){
			$("input[name=flavor]").change(function(){
				const chkCount = $('input:checkbox[name="flavor"]:checked').length;
				console.log(chkCount);
				if($("#single-regular").is(":checked")) {
					if(chkCount > 1) {
						alert("하나만");
						this.checked = false; //checked 처리
						/*
						$('input:checkbox[name="flavor"]').each(function() {
							if(this.checked) {//checked 처리된 항목의 값
								alert(this.value);
							}
						});
						*/
					}
				} else if($("#single-king").is(":checked")) {
					if(chkCount > 2) {
						alert("두개만");
						this.checked = false; //checked 처리
						// $('input:checkbox[name="flavor"]').each(function() {
						// 	if(this.checked) {//checked 처리된 항목의 값
						// 		alert(this.value);
						// 	}
						// });
					}
				} else if($("#pint").is(":checked")) {
					if(chkCount > 3) {
						alert("세개만");
						this.checked = false; //checked 처리
						// $('input:checkbox[name="flavor"]').each(function() {
						// 	if(this.checked) {//checked 처리된 항목의 값
						// 		alert(this.value);
						// 	}
						// });
					}
				} else if($("#quarter").is(":checked")) {
					if(chkCount > 4) {
						alert("네개만");
						this.checked = false; //checked 처리
						// $('input:checkbox[name="flavor"]').each(function() {
						// 	if(this.checked) {//checked 처리된 항목의 값
						// 		alert(this.value);
						// 	}
						// });
					}
				}
			});
		// });

		// 체크된 박스갯수
		console.log($('input:checkbox[name="flavor"]:checked').length);
	</script>
</body>
</html>