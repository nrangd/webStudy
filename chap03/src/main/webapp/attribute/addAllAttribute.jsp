<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	application.setAttribute("animal", "기린");
	session.setAttribute("animal", "코끼리");
	request.setAttribute("animal", "하마");
	pageContext.setAttribute("animal", "표범");
	
	String way = request.getParameter("way");
	
	if (way.equals("redirect")) {
		response.sendRedirect("/chap03/attribute/index.jsp");
	} else if (way.equals("forward")) {
		request
			.getRequestDispatcher("/attribute/index.jsp")
			.forward(request, response);
	}
%>