package chap06.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap06.dto.Job;

public class JobDAO {
Connection conn;
	
	public JobDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Job> getAll() {
		
		try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM jobs");
				ResultSet rs = pstmt.executeQuery()) {
			ArrayList<Job> list = new ArrayList<>();
			
			while(rs.next()) {
				
				list.add(new Job(
						rs.getString("job_id"),
						rs.getString("job_title"),
						rs.getInt("min_salary"),
						rs.getInt("max_salary")));
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
