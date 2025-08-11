package chap03.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foward/snack")
public class FowardSnackServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.printf("ID: %s\nNAME: %s\nPRICE: %s\n",
				request.getParameter("id"),
				request.getParameter("name"),
				request.getParameter("price"));
		
		// 포워드는 내부의 경로를 사용한다 (chap03 아래의 경로)
		String nextPage;
		switch (request.getParameter("userSelect").trim().toLowerCase()) {
			case "a":
				nextPage = "/pages/a.jsp";
				break;
			case "b":
				nextPage = "/pages/b.jsp";
				break;
			case "c":
				nextPage = "/pages/c.jsp";
				break;
			case "d":
				nextPage = "/foward/frontend";
				break;
			default:
				nextPage = "/pages/error.jsp";
				break;
		}
		
		// 요청을 마저 처리해야 하는 서블릿을 선택할 수 있다
		RequestDispatcher dispatcher= request.getRequestDispatcher(nextPage);
		
		// forward : 처리를 완전히 다음 서블릿으로 넘긴다.
		dispatcher.forward(request, response);
	}
}
