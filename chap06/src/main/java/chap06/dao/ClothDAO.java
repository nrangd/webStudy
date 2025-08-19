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
	
	public int insert(Cloth cloth) {
		String sql = "INSERT INTO "
				+ "cloth(cloth_id, cloth_part, cloth_brand, cloth_price, cloth_size) "
				+ "VALUES(cloth_seq.nextval, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, cloth.getCloth_part());
			pstmt.setString(2, cloth.getCloth_brand());
			pstmt.setInt(3, cloth.getCloth_price());
			pstmt.setString(4, cloth.getCloth_size());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public Cloth get(int cloth_id) {
		String sql = "SELECT * FROM cloth WHERE cloth_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, cloth_id);

			try (ResultSet rs = pstmt.executeQuery();){
				rs.next();
				
				return new Cloth(
							rs.getString(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							cloth_id
						);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int update(Cloth cloth) {
		String sql = "UPDATE cloth SET "
				+ "cloth_part = ?, cloth_brand = ?, cloth_size = ?, cloth_price = ? WHERE cloth_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, cloth.getCloth_part());
			pstmt.setString(2, cloth.getCloth_brand());
			pstmt.setString(3, cloth.getCloth_size());
			pstmt.setInt(4, cloth.getCloth_price());
			pstmt.setInt(5, cloth.getCloth_id());
			
			int updated_row = pstmt.executeUpdate();
			
			return updated_row > 0 ? cloth.getCloth_id() : -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int delete(int id) {
		String sql = "DELETE FROM cloth WHERE cloth_id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
