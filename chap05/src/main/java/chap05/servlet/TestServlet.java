package chap05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/encoding")
public class TestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String method = request.getMethod();
		
		if(uri.endsWith("encoding") && method.equals("GET")) {
			System.out.println("### GET TEST ###");
			System.out.println("name: " + request.getParameter("name"));
			System.out.println("age: " + request.getParameter("age"));
		} else if(uri.endsWith("encoding") && method.equals("POST")){
//			request.setCharacterEncoding("UTF-8");
			System.out.println("### POST TEST ###");
			System.out.println("name: " + request.getParameter("name"));
			System.out.println("age: " + request.getParameter("age"));
		} else {
			System.out.println("여긴뭘까");
		}
	}
}
