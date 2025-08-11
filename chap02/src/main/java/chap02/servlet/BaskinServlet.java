package chap02.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/baskin")
public class BaskinServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String size = request.getParameter("size");
		String[] flavors = request.getParameterValues("flavor"); // name 하나로 여러개 값 받기
		
		System.out.println("#### 주문 내용 ####");
		System.out.println("용량: " + size + "g");
		System.out.println("------------------");
		for (int i = 0; i < flavors.length; i++) {
			System.out.printf("맛%d - %s\n", i + 1, flavors[i]);
		}
	}
}
