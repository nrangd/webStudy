package jspboard.service.board;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.dao.BoardDao;
import jspboard.service.WebService;

public class BoardWriteService extends WebService {

	private static BoardWriteService instance = new BoardWriteService();
	
	private BoardWriteService() {};
	
	public static BoardWriteService getInstance() {
		return instance;
	}
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardWriterService거쳐감");
		String board_title = request.getParameter("board_title");
		String board_writer = request.getParameter("board_writer");
		String board_writer_ip_addr = request.getRemoteAddr();
		String board_password = request.getParameter("board_password");
		String board_content = request.getParameter("board_content");
		
		if (board_title == "" || board_title == null) { 
			request.setAttribute("cause", "글 제목");
		} else if (board_writer == "" || board_writer == null) {
			request.setAttribute("cause", "작성자");
		} else if (board_password == "" || board_password == null) {
			request.setAttribute("cause", "글 비밀번호");
		} else if (board_content == "" || board_content == null) {
			request.setAttribute("cause", "글 내용");			
		} else {
			// DB에 글 쓰기
			ServletContext application = request.getServletContext();
			
			BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
			
			boardDao.insert(
					board_title, 
					board_writer, 
					board_writer_ip_addr, 
					board_password, 
					board_content);
			System.out.println("insert 성공?");
			return "redirect:/board/";
		}
		
		System.out.println("글쓰는데 문제가 생김");
		return "/WEB-INF/views/board/write.jsp";
	}

}
