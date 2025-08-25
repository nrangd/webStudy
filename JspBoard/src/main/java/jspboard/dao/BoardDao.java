package jspboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspboard.dto.JspBoard;

public class BoardDao{
	private static BoardDao instance = new BoardDao();
	
	private static Connection conn;
	
	private BoardDao() {};
	
	public static BoardDao getInstance(Connection conn) {
		instance.setConnection(conn);
		return instance;
	}
	
	private void setConnection(Connection conn) {
		BoardDao.conn = conn;
	}
	
	public List<JspBoard> selectAll() {
		List<JspBoard> list = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM jspboard");
				ResultSet rs = pstmt.executeQuery()){
			while(rs.next()) {
				list.add(new JspBoard(
							rs.getInt("board_id"),
							rs.getString("board_title"),
							rs.getString("board_writer"),
							rs.getString("board_writer_ip_addr"),
							rs.getString("board_password"),
							rs.getString("board_content"),
							rs.getDate("board_write_date"),
							rs.getInt("board_view_count"),
							rs.getInt("board_pos_count"),
							rs.getInt("board_neg_count")
						));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		
	}
	
	public JspBoard selectOne(int board_id) {
		String sql = "SELECT * FROM jspboard WHERE board_id = ?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, board_id);
			
			try (ResultSet rs =  pstmt.executeQuery();) {
				return rs.next() ? new JspBoard(
						rs.getInt("board_id"),
						rs.getString("board_title"),
						rs.getString("board_writer"),
						rs.getString("board_writer_ip_addr"),
						rs.getString("board_password"),
						rs.getString("board_content"),
						rs.getDate("board_write_date"),
						rs.getInt("board_view_count"),
						rs.getInt("board_pos_count"),
						rs.getInt("board_neg_count")
					) : null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void insert(
			String board_title, 
			String board_writer, 
			String board_writer_ip_addr, 
			String board_password, 
			String board_content) {
		String sql = "INSERT INTO jspboard(board_id, board_title, board_writer, "
				+ "board_writer_ip_addr, board_password, board_content, board_write_date,"
				+ "board_view_count, board_pos_count, board_neg_count) "
				+ "VALUES(jspboard_board_id_seq.nextval, ?, ?, ?, ?, ?, SYSDATE, 0, 0, 0)";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, board_title);
			pstmt.setString(2,  board_writer);
			pstmt.setString(3, board_writer_ip_addr);
			pstmt.setString(4,  board_password);
			pstmt.setString(5, board_content);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int increaseViewCount(int board_id) {
		String sql = "UPDATE jspboard SET board_view_count = board_view_count + 1 WHERE board_id = ?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setInt(1, board_id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
