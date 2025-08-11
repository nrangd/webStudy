package chap02.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/coffee/purchase")

public class CoffeePurchaseServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3103949709860083219L;

	// Get 방식 요청은 doGet 메서드에서 처리하게 할 수 있다.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 doGet 입니다...");
		System.out.printf("메뉴: %s\n", request.getParameter("menu"));
		
	}
	
	// Post 방식 요청은 doPost 메서드에서 처리하게 할 수 있다.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("여기는 doPost 입니다...");
		System.out.printf("메뉴: %s\n", request.getParameter("menu"));
		System.out.printf("수량: %s\n", request.getParameter("qty"));
	}

	// service 메서드에서 요청을 먼저 받은 후 해당하는 요청 방식의 메서드로 보내주는 것이 기본 동작이다
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 Service 입니다...");
		
		// 요청에 실려온 여러 정보들 확인해보기
		System.out.println("요청 방식: " + request.getMethod());
		System.out.println("접속자 IP주소: " + request.getRemoteAddr());
		System.out.println("접속자가 사용한 포트번호: " + request.getRemotePort());
		System.out.println("서버가 사용한 포트번호: " + request.getLocalPort());
		System.out.println("여기로 접속하기 위한 URI: " + request.getServletPath());
		
		String method = request.getMethod();
		if (method.equals("GET")) {
			doGet(request, response);
		} else if (method.equals("POST")) {
			doPost(request, response);
		}
		
//		super.service(request, response);
	}
	
}
