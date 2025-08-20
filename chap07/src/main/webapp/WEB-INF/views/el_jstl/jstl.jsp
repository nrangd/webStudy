<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3># JSTL core</h3>
	
	<ul>
		<li>c:set - 현재 페이지 어트리뷰트에 원하는 값을 추가한다</li>
		<li>c:if - if문을 편리하게 사용할 수 있다 (else if, else를 쓸 수 없다)</li>
		<li>c:choose, c:when, c:otherwise - if, else if, else문을 사용할 수 있다</li>
		<li>c:forEach - 반복문을 쉽게 사용할 수 있다</li>
		<li>c:forTokens - 전달한 문자열을 split하여 쉽게 반복할 수 있다</li>
		<li>c:url - 원하는 url을 좀 더 편리하게 생성할 수 있다</li>
	</ul>
	
	<h3># c:set</h3>
	
	<c:set var="fruit" value="복숭아" scope="page"/>
	<c:set var="fruit" value="사과" scope="request"/>
	<c:set var="fruit" value="오렌지" scope="session"/>
	
	<%
		pageContext.setAttribute("fruit", "황도복숭아");
		application.setAttribute("fruit", "파인애플");
	%>
	
	<ul>
		<li>fruit=${pageScope.fruit}</li>
		<li>fruit=${requestScope.fruit}</li>
		<li>fruit=${sessionScope.fruit}</li>
		<li>fruit=${applicationScope.fruit}</li>
	</ul>
	
	<h3># c:if</h3>
	
	<%-- 원래는 이렇게 해야하는 문법
	 if (Integer.parseInt(pageContext.getAttribute("age")) >= 19) { } --%>
	<p>
		else if, else를 쓸 수 없기 때문에 간단한 if문이 필요한 경우에 사용된다
	</p>
	
	<c:set var="age" value="15"/>
	
	<c:if test="${age >= 19}">
		<div>성인입니다</div>
	</c:if>
	<c:if test="${age < 19}">
		<div>성인이 아닙니다.</div>
	</c:if>
	
	<h3># c:choose, c:when, c:otherwise</h3>
	
	<p>조건문에 else else if</p>
	
	<c:choose>
		<c:when test="${age >= 19}">
			성인입니다.
		</c:when>
		<c:when test="${age >= 14}">
			청소년입니다.
		</c:when>
		<c:when test="${age >= 5 }">
			어린이입니다.
		</c:when>
		<c:otherwise>
			유아입니다.
		</c:otherwise>
	</c:choose>
	
	<h3># c:forEach</h3>
	
	<ul>
		<li>items와 var을 사용하는 방법과 begin, end를 사용해 원하는 숫자를 직접 생성하는 방법이 있다</li>
		<li>items에는 iterable(하나씩 꺼낼 수 있는) 객체를 사용해야 한다 (List, Set, Array, ...)</li>
		<li>begin은 시작값이고 end는 마지막 값이다 (마지막 번호는 end값을 포함한다)</li>
	</ul>
	
	<div>
	<c:forEach items="${steadies}" var="book">
		<div style="display: flex;">
			<div style="width: 100px;">${book.isbn}</div>
			<div style="width: 200px;">${book.book_name}</div>
			<div style="width: 100px;">${book.author}</div>
			<div style="width: 100px;">${book.price}</div>
			<div style="width: 100px;">${book.page}</div>
			<div style="width: 250px;">${book.pub_date}</div>
		</div>
	</c:forEach>
	</div>
	
	<div id="gugudan">
	<c:forEach begin="2" end="9" var="dan">
		<div style="display: flex;">
			<c:forEach begin="0" end="9" var="gop">
				<c:if test="${gop == 0}">
					<div style="width: 50px;">${dan}단</div>
				</c:if>
				<c:if test="${gop > 0}">
					<div style="width: 150px;">${dan} x ${gop} = ${dan * gop}</div>
				</c:if>
			</c:forEach>
		</div>
	</c:forEach>
	</div>
	
	<h3># 반복문의 정보를 볼 수 있는 varStatus</h3>
	
	<ul>
		<li>status.index, status.current: 현재 값을 볼 수 있다 (var과 같음)</li>
		<li>status.count: 현재 카운트를 볼 수 있다 (1부터 시작)</li>
		<li>status.first: 첫 번째 반복이라며 true가 나온다</li>
		<li>status.last: 마지막 반복이라면 true가 나온다</li>
	</ul>
	
	<div>
		<c:forEach begin="50" end="80" step="3" var="i" varStatus="status">
			<div
				<c:if test="${status.first}">
					style="color: blue;"
				</c:if>
				<c:if test="${status.last}">
					style="color: green;"
				</c:if>
			>${status.index}은 ${status.count}번째 반복입니다.</div>
		</c:forEach>
	</div>
	
	<h3># c:forTokens</h3>
	
	<c:set var="snacks" value="오감자, 브이콘, 엄마손파이/ 포카칩, 스윙칩/ 포스틱, 양파링, 새우깡"/>
	
	<div>
		<c:forTokens items="${snacks}" delims=",/" var="snack" varStatus="status">
			<div>${status.count}번째 과자는 ${snack}입니다.</div>
		</c:forTokens>
	</div>
	
	<h3># c:url</h3>
	
	<!-- page 영역에 원하는 url을 저장해놓고 사용하는 기능을 제공한다 -->
	<c:url value="/el_jstl/el" var="el_page" scope="page"/>
	<c:url value="/el_jstl/el" var="el_study2" >
		<c:param name="name">Cheolsu Kim</c:param>
		<c:param name="age">31</c:param>
		<c:param name="nationality">British</c:param>
	</c:url>
	
	<ul>
		<li><c:url value="/jstl/el"/> : 알아서 컨텍스트 경로를 추가해준다</li>
		<li><a href="<c:url value="el_jstl/el"/>">EL 공부하러가기..</a></li>
		<li><a href="${el_study}">EL 공부하러가기..</a></li>
		<li>파라미터가 있는 url 생성하기: ${el_study2}</li>
		<li><a href="${el_study2}">파라미터 들고 EL 공부하러 가기</a></li>
		<li>연습) 직접 만들던 프로젝트의 .jsp 파일들을 모두 EL/JSTL로 교체하기</li>
	</ul>
</body>
</html>