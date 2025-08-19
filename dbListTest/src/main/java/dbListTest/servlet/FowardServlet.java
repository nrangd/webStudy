package dbListTest.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbListTest.dao.SomethingDAO;
import dbListTest.dto.Something;

public class FowardServlet extends HttpServlet {
	
	Connection conn;
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = new OJdbcConector("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","1234").getConnection();
			System.out.println("db접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		
		String uri = request.getRequestURI().substring(contextPath.length());
		String method = request.getMethod();
				
		SomethingDAO dao = new SomethingDAO(conn);
		
		System.out.println(uri);
		
		if(uri.equals("/something/list")) {
			// 디비에서 정보를 가져오고
			List<Something> list = dao.getAll();
			// request의 어트리뷰트에 저장해두고
			request.setAttribute("something", list);
			// forward시킨후 새 페이지(jsp)에서 저장한 내용을 불러서 쓸거다
			request.getRequestDispatcher("/WEB-INF/views/list/something.jsp").forward(request, response);
		} else if(uri.equals("/something/add")) {
			if(method.equals("GET")) {
				request.getRequestDispatcher("/WEB-INF/views/list/add.jsp").forward(request, response);				
			} else if(method.equals("POST")) {
				
				request.getRequestDispatcher("/WEB-INF/views/list/something.jsp").forward(request, response);
			}
		} else if (uri.equals("/index")) {
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		} else {
			response.sendRedirect(contextPath + "/index");
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("서블렛 닫힘");
		try {
			System.out.println("DB접속 종료");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
