<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${board.board_title }</title>
	<link rel="stylesheet" href="/resources/board/css/detail.css">
</head>
<body>
	<div id="board_detail" style="width: fit-content;">
		<div class="subject" style="display: flex;">
			<div class="title">
				${board.board_title }
			</div>
			<div class="writer">
				${board.board_writer }
			</div>
			<div class="view_count">
				${board.board_view_count }
			</div>
		</div>
		<div class="content" style="height:1000px; background-color:wheat;">
			${board.board_content }
		</div>
		
		<button onclick="location.replace('./detail/review?r=1&board_id=${board.board_id }')">추천하기</button>
		<span>${board.board_pos_count }</span>
		<button onclick="location.replace('./detail/review?r=0&board_id=${board.board_id }')">비추천하기</button>
		<span>${board.board_neg_count }</span>
		
		
	</div>
	
	<button onclick="location.href='/board/'">목록</button>
	<button>수정</button>
	<button>삭제</button>
</body>
</html>