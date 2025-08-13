package chap04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/popup")
public class PopupServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String nomore = request.getParameter("nomore");
		
		if (nomore == null) {
			response.sendRedirect(contextPath + "/cookie/popup.jsp");
		} else if (nomore.equals("t")) {
			Cookie cookie = new Cookie("popup", "no");
			
			cookie.setMaxAge(60 * 60 * 25);
			
			cookie.setPath(contextPath + "/cookie");
			
			response.addCookie(cookie);
			response
				.getWriter()
				.append("<html><head></head><body><script>window.close()</script></body></html>");
		}
	}
}
