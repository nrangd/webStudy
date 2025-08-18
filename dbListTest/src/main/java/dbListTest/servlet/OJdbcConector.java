package dbListTest.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OJdbcConector {
	String url;
	String user;
	String password;
	public OJdbcConector(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
