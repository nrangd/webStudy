package jspboard.service.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.WebService;

public class Error404WebService extends WebService{

	private static Error404WebService instance = new Error404WebService();
	
	public Error404WebService() {};
	
	public static Error404WebService getInstance() {
		return instance;
	}
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/views/404/404.jsp";
	}
}
