package chap06.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.EmployeeDAO;
import chap06.dao.OjdbcConnector;
import chap06.dto.Employee;

public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext application = config.getServletContext();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = new OjdbcConnector(
					application.getInitParameter("jdbc_url"), 
					application.getInitParameter("jdbc_user"), 
					application.getInitParameter("jdbc_password")).getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// # ForwardServlet의 모든 요청에 대한 처리 절차
		
		// 1. 일단 uri를 확인 (어떤 DB에서 꺼낼지, 어디로 포워드 할지 결정됨)
		
		// 2. DB에서 데이터를 꺼냄 (하고 싶은 처리를 함, 비즈니스 로직)
		
		// 3. 꺼낸 데이터를 실어놓음
		
		// 4. 포워드
		
		
		// 이곳에 접속하면 DB로부터 모든 사원들을 꺼내서 콘솔에 출력해보세요
		
		EmployeeDAO employeeDao = new EmployeeDAO(conn);
		
		List<Employee> empList = employeeDao.getAll();
		
		System.out.println(empList);
		
		request.setAttribute("employees", empList);
		
		request
			.getRequestDispatcher("/WEB-INF/views/emp/emp_list.jsp")
			.forward(request, response);
		
	/*
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "1234")){
			
			String query = "SELECT * FROM employees";
			
			
			try (PreparedStatement pstmt = conn.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery()) {
				StringBuilder text = new StringBuilder();
				response.getWriter().append("<html><head></head><body><ul>");
				while(rs.next()) {
					text.delete(0, text.length());
					text.append("[");
					int colCount = rs.getMetaData().getColumnCount();
					for(int i = 1; i <= colCount; i++) {
						text.append(rs.getString(i));
					}
					text.append("]");
					
					response.getWriter().append("<li>"+text.toString()+"</li>");
				}
				response.getWriter().append("</ul></body></html>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	*/
	}
}
