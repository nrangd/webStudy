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
	
	private String prefix = "/WEB-INF/views";
	private String suffix = ".jsp";
	private Map<String, Process> cmd_mapper;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		cmd_mapper = new HashMap<>();
		
		cmd_mapper.put("/el_jstl/", new JstlIndexProcess());
		cmd_mapper.put("/el_jstl/el", new ElTestProcess());
		cmd_mapper.put("/el_jstl/jstl", new JstlTestProcess());
		cmd_mapper.put("/el_jstl/home", new JstlHomeProcess());
		cmd_mapper.put("/filter/", new FilterIndexProcess());
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
	}
}	
