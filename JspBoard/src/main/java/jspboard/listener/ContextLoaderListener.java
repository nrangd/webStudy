package jspboard.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import jspboard.dao.BoardDao;

public class ContextLoaderListener implements ServletContextListener{

	Connection conn;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		
		try {
			Class.forName(application.getInitParameter("driverName"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		try {
			conn = DriverManager.getConnection(
							application.getInitParameter("jdbcUrl"),
							application.getInitParameter("jdbcUser"),
							application.getInitParameter("jdbcUserPassword")
						);
			System.out.println("db연결이 잘 되었습니다" + conn);

			application.setAttribute("boardDao", BoardDao.getInstance(conn));
			
			System.out.println("boardDao도 잘 생성됨...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// name을 모두 꺼내고 싶은 경우...
//		Enumeration<String> e = sce.getServletContext().getInitParameterNames();
//		
//		String name;
//		while(e.hasMoreElements()) {
//			e.nextElement();
//		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		
		try {
			if(conn != null) conn.close();
//			((Connection) application.getAttribute("boardDao")).close();
			System.out.println("DB연결을 잘 끊었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB연결을 해제하는중에 문제가 생김");
		}
	}
}
