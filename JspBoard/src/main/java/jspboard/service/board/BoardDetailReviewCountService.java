package jspboard.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.WebService;

public class BoardDetailReviewCountService extends WebService{

	private static BoardDetailReviewCountService instance = new BoardDetailReviewCountService();
	private BoardDetailReviewCountService() {};
	
	public static BoardDetailReviewCountService getInstance() {
		return instance;
	}
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("추천처리 방문함");
		
		return "/WEB-INF/views/board/detail.jsp";
	}
	
}
