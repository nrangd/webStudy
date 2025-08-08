<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Jsp Tutorial.jsp</title>
	<style>
		pre {
			font-size: 25px;
			font-weight: bold;
		}
	</style>
</head>
	
<body>
	<h3># JSP (Java Server Pages)</h3>
	
	<ul>
		<li>동적 웹 페이지를 생성하기 위한 자바 API</li>
		<li>HTML 코드 내부에 자바코드를 활용할 수 있다</li>
		<li>.jsp로 만들어진 프로그램의 실행 결과는 .html 형식의 문자열이다</li>
	</ul>
	
	<h3># .jsp 파일의 처리 순서</h3>
	
	<ol>
		<li>.jsp 파일을 해석하여 .java 파일로 변환한다 (1차 컴파일)</li>
		<li>.java 파일을 컴파일하여 실행가능한 형태로 만든다 (2차 컴파일)</li>
		<li>2차 컴파일의 결과물을 WAS의 웹 컨테이너에 등록하고 사용자의 요청을 기다린다</li>
		<li>사용자가 해당 페이지를 요청하면 웹 컨테이너에 등록되어 있던
			.jsp파일을 실행하여 나온 결과물을 응답해준다</li>
	</ol>
	
	<%-- JSP 주석 --%>
	
	<%--
		<%  %> : 해당 영역 내부에서 자바 코드를 사용할 수 있다
		<%= %> : 자바의 값을 HTML로 출력한다 (out.print의 축약버전)
		<%! %> : 클래스 영역에 메서드를 선언할 수 있다.
		<%@ %> : 현재 JSP 페이지에 대한 설정 문법들을 사용할 수 있다.
	--%>
	
	<%!
		String rabbit() {
			return "<pre>"
					+ "  /)/)\n"
					+"(    ..)\n"
					+"(    >>)"
					+"</pre>";	
		}
	%>
	
	<%
		int a = 10;
		out.print("<div>" + a + "</div>");
	%>
	<div><%=a %></div>
	
	<%
		// 이 공간은 무언가의 메서드 안에서 쓰는듯 함
		for (int i = 0; i < 10; i++) {
			// out : HTML로 내보내는 아웃스트림 (선언한 적도 없는데 사용할수 있는 기본 내장 객체)
			// out.print(String.format("<div id='box%d'></div>", i));
			out.print(rabbit());
		}
	%>
</body>
</html>