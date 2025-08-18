package dbListTest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbListTest.dto.Something;

public class SomethingDAO {
	Connection conn;
	
	public SomethingDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Something> getAll() {
		try (PreparedStatement pstmt= conn.prepareStatement("SELECT * FROM somethings");
				ResultSet rs = pstmt.executeQuery()){
			List<Something> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new Something(
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5)
						));
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void addData(Something s) {
		String query = "INSERT INTO "
				+ "something(st_id, st_str1, st_str2, st_date, st_number) "
				+ "values(somethings_id_seq.nextval, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(query);){
			pstmt.setString(1, s.getSt_str1());
			pstmt.setString(2, s.getSt_str2());
			pstmt.setDate(3, s.getSt_date());
			pstmt.setInt(4, s.getSt_number());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
