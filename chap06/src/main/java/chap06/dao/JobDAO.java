package chap06.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap06.dto.Department;
import chap06.dto.Job;

public class JobDAO {
Connection conn;
	
	public JobDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Job> getAll() {
		
		
		try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM jobs");
				ResultSet rs = pstmt.executeQuery()){
			ArrayList<Job> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new Job(
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
