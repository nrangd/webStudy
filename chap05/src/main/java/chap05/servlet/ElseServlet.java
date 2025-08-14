package chap05.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ElseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 지역 초기화 파라미터(init-param)는 init()에서 꺼낼 수 있다
		
		String a = config.getInitParameter("db_account");
		String b = config.getInitParameter("db_password");
		String c = config.getInitParameter("debug_mode");
		System.out.println("지역 초기화 파라미터들(init-param) : " + a+b+c);
		
		// 어플리케이션 객체 (서버에 1개)
		ServletContext application = config.getServletContext();
		
		// context-param은 application 객체에 저장되어 있다
		System.out.print("전역 파라미터들(context-param) : ");
		System.out.print(application.getInitParameter("ceo_name"));
		System.out.println(application.getInitParameter("resource_path"));
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("매핑에 안걸린 요청: " + request.getRequestURI());
	}

}
