package chap06.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chap06.dao.ClothDAO;
import chap06.dao.DepartmentDAO;
import chap06.dao.EmployeeDAO;
import chap06.dao.JobDAO;
import chap06.dao.OjdbcConnector;
import chap06.dto.Cloth;
import chap06.dto.Department;
import chap06.dto.Employee;
import chap06.dto.Job;

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
		
		String contextPath = request.getContextPath();
		
		String method = request.getMethod();
		
		String uri= request.getRequestURI();
		uri = uri.substring(contextPath.length(), uri.length());
		System.out.println(uri);
		
		if(uri.equals("/employee/list")) {
			EmployeeDAO employeeDao = new EmployeeDAO(conn);
			
			List<Employee> empList = employeeDao.getAll();
			
			System.out.println(empList);
			
			request.setAttribute("employees", empList);
			
			request
				.getRequestDispatcher("/WEB-INF/views/emp/emp_list.jsp")
				.forward(request, response);
		} else if (uri.equals("/department/list")) {
			DepartmentDAO departmentDAO = new DepartmentDAO(conn);
			
			List<Department> depList = departmentDAO.getAll();
			
			System.out.println(depList);
			
			request.setAttribute("department", depList);
			
			request.getRequestDispatcher("/WEB-INF/views/list/dep_list.jsp").forward(request, response);
		} else if (uri.equals("/job/list")) {	
			JobDAO jobDao = new JobDAO(conn);
			
			List<Job> jobList = jobDao.getAll();
			
			System.out.println(jobList);
			
			request.setAttribute("job", jobList);
			
			request.getRequestDispatcher("/WEB-INF/views/list/job_list.jsp").forward(request, response);
		} else if (uri.equals("/cloth/list")) {
			
			// db에서 옷장 데이터들을 챙겨와서 List에 넣는다.
			ClothDAO clothDao = new ClothDAO(conn);
			List<Cloth> clothes= clothDao.getAll();
			System.out.println(clothes);
			
			// list에 넣어진 옷장 데이터를 request의 어트리뷰트에 저장해둔다.
			request.setAttribute("cloth", clothes);
			// request에 실린 데이터와 함께 jsp파일로 포워드를 해준다
			request.getRequestDispatcher("/WEB-INF/views/list/cloth_list.jsp").forward(request, response);
		} else if(uri.equals("/cloth/add")) {
			if(method.equals("GET")) {
				// GET일떄는 새 상품을 등록하는 폼으로 이동
				request
				.getRequestDispatcher("/WEB-INF/views/list/add.jsp")
				.forward(request, response);
			} else if (method.equals("POST")) {
				// POST일때는 폼에서 전달받은 데이터를 통해 DB에 등록하고 목록으로 이동
				ClothDAO dao = new ClothDAO(conn);
				
				// input에서 날짜를 전달받는 경우
				String release_date = request.getParameter("release_date");
				LocalDate ld = LocalDate.parse(release_date);
				Date d = Date.valueOf(ld);
				
				System.out.println("release_date: " + release_date);
				
				request.setCharacterEncoding("UTF-8");
				// 원래 파라미터를 가져올때 NULL 체크를 해야함
				Cloth dto = new Cloth(
						request.getParameter("cloth_part"),
						request.getParameter("cloth_brand"),
						Integer.parseInt(request.getParameter("cloth_price")),
						request.getParameter("cloth_size"),
						null // ID는 시퀀스로 추가
						);
				
				dao.insert(dto);
				response.sendRedirect("./list");
				// dao.insert();
			}
			
		} else if(uri.equals("/index")) {
			request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		} else {
			System.out.println("없는주소로 이동중"+uri);
			response.sendRedirect(contextPath+"/index");
		}
		
//		} else {
//			PrintWriter out = response.getWriter();
//			out.print("<html><head></head><body>존재하지 않는 페이지</body></html>");
//		}
		
		// 이곳에 접속하면 DB로부터 모든 사원들을 꺼내서 콘솔에 출력해보세요
		
//		EmployeeDAO employeeDao = new EmployeeDAO(conn);
//		
//		List<Employee> empList = employeeDao.getAll();
//		
//		System.out.println(empList);
//		
//		request.setAttribute("employees", empList);
//		
//		request
//			.getRequestDispatcher("/WEB-INF/views/emp/emp_list.jsp")
//			.forward(request, response);
		
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
	
	@Override
	public void destroy() {
		try {
			if(conn != null) {
				conn.close();
			}
			System.out.println("DB연결 해제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
