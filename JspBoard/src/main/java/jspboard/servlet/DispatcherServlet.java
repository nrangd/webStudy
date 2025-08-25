package jspboard.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.WebService;
import jspboard.service.error.Error404WebService;
import jspboard.service.board.*;
import jspboard.service.main.*;

public class DispatcherServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5895437641343756433L;
	
	Map<String, WebService> cmd_mapping;

	@Override
	public void init(ServletConfig config) throws ServletException {
		cmd_mapping = new HashMap<>();
		cmd_mapping.put("GET:/", MainIndexWebService.getInstance());
		cmd_mapping.put("GET:/error/404", Error404WebService.getInstance());
		cmd_mapping.put("GET:/board/", BoardListService.getInstance(config.getServletContext()));
		cmd_mapping.put("GET:/board/write", BoardWriteFormService.getInstance());
		cmd_mapping.put("POST:/board/write", BoardWriteService.getInstance());
		cmd_mapping.put("GET:/board/detail", BoardDetailService.getInstance());
		cmd_mapping.put("GET:/board/detail/review", BoardDetailReviewCountService.getInstance());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
//		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();
		
		System.out.println("URI: " + uri);
//		System.out.println("ContextPath: " + contextPath);
		System.out.println("ServletPath: " + servletPath);
		
		String cmd = request.getMethod() + ":" + uri;
		
		WebService webService = cmd_mapping.get(cmd);
		
		String nextView = null;
		
		if (webService != null) {
			nextView = webService.service(request, response);
		}
		
		if (nextView != null) {
			if(nextView.startsWith("redirect:")) {
				response.sendRedirect(nextView.replace("redirect:", ""));
			} else {
				request.getRequestDispatcher(nextView).forward(request, response);				
			}
		} else {
			response.sendRedirect("/error/404");
		}
	}
}
