package jspboard.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.dao.BoardDao;
import jspboard.dto.JspBoard;
import jspboard.service.WebService;

public class BoardDetailService extends WebService{
	
	private static BoardDetailService instance = new BoardDetailService();
	private BoardDetailService() {};
	
	public static BoardDetailService getInstance() {
		
		return instance;
	}

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		Integer board_id = Integer.parseInt(request.getParameter("board_id"));
		
		try {
			
			BoardDao boardDao = (BoardDao) request.getServletContext().getAttribute("boardDao");
			
			boardDao.increaseViewCount(board_id); // 조회수 증가
			System.out.println("조회수 정상 증가");
			JspBoard board = boardDao.selectOne(board_id); // 조회
			System.out.println("조회된 보드?" + board);
			
			if (board == null) {
				throw new NumberFormatException("글 번호로 조회 실패!");
			} else {
				request.setAttribute("board", board);
				return "/WEB-INF/views/board/detail.jsp";
			}
		} catch (NumberFormatException e) {
			return "/WEB-INF/views/error/board_not_exists.jsp";
		}
		
		
	}

}
