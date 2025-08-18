package chap06.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chap06.dto.Cloth;

public class ClothDAO {
	Connection conn;
	
	public ClothDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Cloth> getAll() {
		try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM cloth ORDER BY cloth_id asc");
				ResultSet rs = pstmt.executeQuery()) {
			List<Cloth> clothes = new ArrayList<>();
			while(rs.next()) {
//				clothes.add(new Cloth(
//							rs.getString("cloth_part"),
//							rs.getString("cloth_brand"),
//							rs.getInt("cloth_price"),
//							rs.getString("cloth_size"),
//							rs.getInt("cloth_id")
//						));
				clothes.add(new Cloth(
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5)
						));
				
			}
			
			return clothes;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
