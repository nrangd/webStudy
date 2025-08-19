package dbListTest2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbListTest2.dto.BBS;

public class BBSDAO {
	Connection conn;
	/*
	
		BBS_ID NUMBER NOT NULL 
		, BBS_NUMBER NUMBER NOT NULL 
		, BBS_SUBJECT VARCHAR2(100) 
		, BBS_REGIST_DATE DATE 
		, BBS_RESERVATION_DATE DATE 
		, BBS_CONTENT VARCHAR2(2000) 
		, BBS_KEYWORD VARCHAR2(20)
	
	 */
	
	public BBSDAO(Connection conn) {
		this.conn = conn;
	}
	
	// 모든 bbs테이블의 컬럼을 리턴하는 메서드
	public List<BBS> getAll() {
		String sql = "SELECT * FROM BULLETIN_BOARD_SYSTEM";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				) {
			List<BBS> list = new ArrayList<BBS>();
			while(rs.next()) {
				list.add(new BBS(
							rs.getInt("bbs_number"),
							rs.getString("bbs_subject"),
							rs.getDate("bbs_regist_date"),
							rs.getDate("bbs_reservation_date"),
							rs.getString("bbs_keyword")
						));
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// bbs테이블의 특정 컬럼을 리턴하는 메서드
	public BBS get(int id) {
		return null;
	}
	
	public int insert(BBS bbs) {
		
		return 0;
	}
	
	public int update(int id) {
		
		return 0;
	}
	
	public int delete(int id) {
		
		return 0;
	}
}
