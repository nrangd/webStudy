package chap03.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect/snack")
public class RedirectSnackServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String price;

		System.out.printf("과자이름 : %s, 가격 : %s\n", 
				request.getParameter("name"), 
				price = request.getParameter("price"));
		
		if (Integer.parseInt(price) >= 3000) {
			// 서블릿의 본래 용도 (알맞은 응답 만들어놓기)
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<html><head>"
					+ "<meta charset=\"UTF-8\">"
					+ "<title>과자 목록 보는 곳</title>"
					+ "</head><body>"
					+ "<h3>장바구니</h3>"
					+ "<ul>"
					+ "<li>" + request.getParameter("name") + " : "
					+ request.getParameter("price") + "</li>"
					+ "</ul>"
					+ "</body></html>");			
		} else {
			// 클라이언트의 웹브라우저에게 '이 주소로 다시 연결바랍니다'라고 응답하기 (리다이렉트)
			response.sendRedirect("/chap03/redirect/index.jsp");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.printf("ID: %s\nNAME: %s\nPRICE: %s\n",
				request.getParameter("id"),
				request.getParameter("name"),
				request.getParameter("price"));
		
		// 리다이렉트는 위의 요청과 별개로 다시 클라이어트에서 새 요청을 만드는 것이기 때문에
		// 가지고 있던 파라미터들을 들고가지 않는다.
		switch (request.getParameter("userSelect").trim().toLowerCase()) {
		case "a":
			response.sendRedirect("/chap03/pages/a.jsp");
			break;
		case "b":
			response.sendRedirect("/chap03/pages/b.jsp");
			break;
		case "c":
			response.sendRedirect("/chap03/pages/c.jsp");
			break;
		default:
			response.sendRedirect("/chap03/pages/error.jsp");
			break;
		}
	}
}
