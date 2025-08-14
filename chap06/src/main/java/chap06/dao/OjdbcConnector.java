package chap06.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OjdbcConnector {
	
	private String url;
	private String user;
	private String password;
	
	public OjdbcConnector(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
