package shark.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shark.process.Process;
import shark.process.*;

public class FrontController extends HttpServlet{
	
	
	private String encoding;
	
	private String prefix = "/WEB-INF/views";
	private String suffix = ".jsp";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.encoding =  config.getInitParameter("encoding");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding(request.getServletContext().getInitParameter("encoding"));
		
		request.setCharacterEncoding(encoding);

//		ServletContext application =  request.getServletContext();	// ServletContext : 서블릿들 담아놓는 통(서버)
//		HttpSession session = request.getSession(); // 세션
		
		
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath(); // 이 서블릿으로 들어오기 위해 필요한 주소
		String uri = request.getRequestURI();
		String cmd = uri.substring(contextPath.length());
		
		System.out.println("-----------------");
		System.out.println("uri: " + uri);
		System.out.println("contextPath : " + contextPath);
		System.out.println("servletPath : " + servletPath);
		System.out.println("command : " + cmd);
		System.out.println("-----------------");
		
		// 1. 하고싶은 처리(Service, Business Logic)를 한다.
		// 2. 어느 페이지를 사용자에게 보여줄지 정한다 (포워드 또는 리다이렉트)
		Map<String, Process> cmd_mapper = new HashMap<>();
		
		cmd_mapper.put("/el_jstl/", new JstlIndexProcess());
		cmd_mapper.put("/el_jstl/el", new ElTestProcess());
		cmd_mapper.put("/el_jstl/jstl", new JstlTestProcess());
		cmd_mapper.put("/el_jstl/home", new JstlHomeProcess());
		
		Process service = cmd_mapper.get(cmd);
		
		if (service != null) {
			String nextServlet = service.process(request, response);
			
			if (nextServlet.startsWith("redirect:")) {
				response.sendRedirect(nextServlet.replace("redirect:", contextPath));
			} else {
				request.getRequestDispatcher(prefix + nextServlet + suffix).forward(request, response);
			}
			
		} else {
			throw new ServletException("올바르지 않은 URI입니다...");
		}
		
		
		// 다형성을 활용하여 너무 길어질 수 있는 if ~ else if 문을 없애버릴 수 있다
		/*
		 * if (todo.equals("/el_jstl/")) {
		 * request.getRequestDispatcher("/WEB-INF/views/el_jstl/index.jsp").forward(
		 * request, response); } else if (todo.equals("/el_jstl/el")) {
		 * 
		 * application.setAttribute("book", "[디지털지자인] 모바일 UI/UX 반응형 웹디자인");
		 * session.setAttribute("book", "모두의HTML5 & CSS3"); request.setAttribute("book",
		 * "포토샵 & 일러스트레이터 2022");
		 * 
		 * request.setAttribute("obj_book", new Book( "913858468891", "손자병법", "임용한",
		 * 22800, 500, java.sql.Date.valueOf(LocalDate.of(2025, 1, 28)) ));
		 * 
		 * request.setAttribute("score", 2222); request.setAttribute("CLOTHES_SIZES",
		 * new String[] {"XL","L","S","XS"});
		 * request.getRequestDispatcher("/WEB-INF/views/el_jstl/el.jsp").forward(
		 * request, response); } else if (todo.equals("/el_jstl/jstl")) { List<Book>
		 * steadySellers = new ArrayList<>();
		 * 
		 * request.setAttribute("steadies", steadySellers);
		 * 
		 * steadySellers.add(new Book("1", "그리스 로마 신화", "남궁성", 3000, 50, new Date()));
		 * steadySellers.add(new Book("2", "죄와 벌", "남궁성", 3000, 50, new Date()));
		 * steadySellers.add(new Book("3", "연금술사", "남궁성", 3000, 50, new Date()));
		 * steadySellers.add(new Book("4", "신곡", "남궁성", 3000, 50, new Date()));
		 * steadySellers.add(new Book("5", "모비딕", "남궁성", 3000, 50, new Date()));
		 * 
		 * request.getRequestDispatcher("/WEB-INF/views/el_jstl/jstl.jsp").forward(
		 * request, response); } else if (todo.equals("/el_js")) {
		 * 
		 * } else { System.out.println("url이 잘못됨"); }
		 */
		
		
	}
}	
