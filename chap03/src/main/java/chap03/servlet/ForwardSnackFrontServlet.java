package chap03.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foward/frontend")
public class ForwardSnackFrontServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head>"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>과자 목록 보는 곳</title>"
				+ "</head><body><h1>d.jsp입니다</h1>"
				+ String.format("ID: %s <br>Name: %s <br>PRICE: %s <br>", 
						request.getParameter("id"),
						request.getParameter("name"),
						request.getParameter("price"))
				+ "</body></html>");
	}
}
