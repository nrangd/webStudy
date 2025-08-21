package dbListTest2.process.bbs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbListTest2.db.OjdbcConnector;
import dbListTest2.db.dao.BBSDAO;
import dbListTest2.db.dto.BBS;
import dbListTest2.process.Process;

/***
 *  bbs 테이블의 목록을 보여주는 페이지에 들어갈 내용을 처리하는곳
 */

public class BBS_List implements Process{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		
		// TODO 임의로 만든 db접속 나중에 제대로 수정해야함
		try (Connection conn = new OjdbcConnector().getConnection();) {
			// db에서 테이블 목록을 불러와서 list에 넣는다
			BBSDAO dao = new BBSDAO(conn);
			List<BBS> list = dao.getAll();
			System.out.println(list);
			// 저장해둔 list를 request객체의 attribute에 담아둔다
			request.setAttribute("bbs_list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// 경로(cmd)를 리턴해줌
		return "/bbs/bbs_list";
	}

}
