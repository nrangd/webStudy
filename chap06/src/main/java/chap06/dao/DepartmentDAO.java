package chap06.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap06.dto.Department;

public class DepartmentDAO {
	Connection conn;
	
	public DepartmentDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Department> getAll() {
		
		
		try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM departments");
				ResultSet rs = pstmt.executeQuery()){
			ArrayList<Department> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new Department(
						rs.getInt(0), 
						rs.getString(1), 
						rs.getInt(2), 
						rs.getInt(3)));
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
