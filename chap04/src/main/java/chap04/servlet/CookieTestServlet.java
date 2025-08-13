package chap04.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/test/*")
public class CookieTestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri, contextPath, servletPath;
		
		System.out.println("URL: " + request.getRequestURL());
		System.out.println("URI: " + (uri = request.getRequestURI()));
		System.out.println("ContextPath: " + (contextPath = request.getContextPath()));
		System.out.println("ServletPath: " + (servletPath = request.getServletPath()));
		
		// uri에서 ContextPath를 빼고, servletPath를 빼면 맨 뒤의 *d에 해당하는 원하는 것만 남는다
		String cmd = uri
				.substring(servletPath.length())
				.substring(contextPath.length());
		
		System.out.println("What user wand: " + cmd);
		
		if (cmd.equals("/add")) {
			// 쿠키를 추가하는 방법 (응답에 쿠키 객체를 실어놓기)
			Cookie cookie = new Cookie("nickname", "Bob");
			Cookie cookie2 = new Cookie("age", "20");
			Cookie cookie3 = new Cookie("cookie24", "console.log('babo')");
			
			//경로를 설정하지 않으면 현재 경로가 path로 등록됨 (/cookie/test/*에서만 사용하는 쿠키가 됨)
			cookie.setMaxAge(60); // 쿠키 수명 설정 (초 단위)
			cookie.setPath(contextPath + "/cookie"); // 쿠키가 적용되는 경로의 범위 설정
			
			cookie2.setMaxAge(-1); // 수명을 음수로 설정하면 웹 브라우저가 꺼질때까지만 유지됨
			cookie2.setPath(contextPath);
			
			cookie3.setMaxAge(24*60*60); // 24시간 유지되는 쿠키
			cookie3.setPath(contextPath);
			cookie3.setHttpOnly(true);	// 쿠키의 자바스크립트 문법이 동작하지 않도록 막아주는 옵션
			
			//이번 응답으로 웹 브라우저에 해당 쿠키를 추가함
			response.addCookie(cookie); 
			response.addCookie(cookie2);
			response.addCookie(cookie3);
			response.sendRedirect(contextPath + "/cookie/cookieTest.jsp");
		} else if (cmd.equals("/delete")) {
			String to_delete = request.getParameter("to_delete");
			
			if(to_delete == null) {
				System.out.println("[ERROR] 삭제할 쿠키 이름이 잘못되었습니다.");
			} else {
				// 쿠키를 삭제하는 방법은 해당 쿠키의 수명을 0으로 만들고 재등록하는 것이다.
				Cookie cookie = new Cookie(to_delete, "");
				
				cookie.setMaxAge(0);
				cookie.setPath(contextPath); //path까지 일치하는 쿠키만 삭제할 수 있다
				
				response.addCookie(cookie);
			}
			response.sendRedirect(contextPath + "/cookie/cookieTest.jsp");
		}
	}
}
