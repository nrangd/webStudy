<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션</title>
</head>
<body>
	<h3># HTTP Session</h3>
	
	<ul>
		<li>웹 서버는 최초로 방문하는 클라이언트에게 세션ID를 발급한다</li>
		<li>발급받은 세션ID는 클라이어트의 쿠키에 보관되고
			클라이언트는 해당 서버로 요청할때마다 자신의 쿠키에 보과된 세션ID를 함께 들고간다</li>
		<li>세션ID는 해당 클라이언트가 예전에 서버에 접속했던 그 사람임을 증명하는 열쇠가 된다</li>
		<li>세션 객체의 어트리뷰트는 해당 세션ID를 지닌 사람만이 열어볼 수 있는 보관함 같은 역할을 한다</li>
		<li>세션 객체의 어트리뷰트는 접속자 수만큼 존재하기 때문에
			너무 많은양의 데이터를 보관하면 서버의 성능에 영향을 미칠 수 있으므로 주의해야 한다</li>
	</ul>
	
	<h3># 세션에 보관된 정보들</h3>
	
	<% 
		session.setMaxInactiveInterval(180);	// 세션 시간 3분으로 설정
	%>
	
	<ul>
		<li>새로 만들어진 세션인가요? : <%=session.isNew() %></li>
		<li>세션ID : <%=session.getId() %></li>
		<li>이 세션이 생성된 시간: <%=new java.util.Date(session.getCreationTime()) %></li>
		<li>이 세션이 가장 최근에 요청을 보낸 시간: <%=session.getLastAccessedTime() %></li>
		<li>장기 미활동시 세션이 삭제되는 시간: <%=session.getMaxInactiveInterval() %></li>
	</ul>
	<%
		session.invalidate(); // 세션 강제로 만료시키기
	%>
</body>
</html>