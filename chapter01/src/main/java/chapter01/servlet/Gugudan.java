package chapter01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello/gugudan")
public class Gugudan extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"UTF-8\">\r\n"
				+ "	<title>구구단</title>"
				+ " <link rel=\"stylesheet\" href=\"/chapter01/assets/css/gugudan.css\">"
				+ "</head>\r\n"
				+ "<body>");
		
		out.print("<div id=\"gugudan\"></div>");
		out.print("<div id=\"gugudan2\">\r\n"
				+ "        <div></div>\r\n"
				+ "        <div></div>\r\n"
				+ "        <div></div>\r\n"
				+ "        <div></div>\r\n"
				+ "        <div></div>\r\n"
				+ "        <div></div>\r\n"
				+ "        <div></div>\r\n"
				+ "        <div></div>\r\n"
				+ "    </div>");
		
		out.print("<div id=\"gugudan3\"></div>");
		
		out.print("<script src=\"/chapter01/assets/js/gugudan.js\"></script>");
		
		out.print("</body></html>");
		
	}
}
