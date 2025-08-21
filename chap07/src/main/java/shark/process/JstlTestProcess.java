package shark.process;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shark.dto.Book;

public class JstlTestProcess implements Process{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		List<Book> steadySellers = new ArrayList<>();
		
		request.getServletContext().setAttribute("steadies", steadySellers);
		
		steadySellers.add(new Book("1", "그리스 로마 신화", "남궁성", 3000, 50, new Date()));
		steadySellers.add(new Book("2", "죄와 벌", "남궁성", 3000, 50, new Date()));
		steadySellers.add(new Book("3", "연금술사", "남궁성", 3000, 50, new Date()));
		steadySellers.add(new Book("4", "신곡", "남궁성", 3000, 50, new Date()));
		steadySellers.add(new Book("5", "모비딕", "남궁성", 3000, 50, new Date()));
		
		return "/el_jstl/jstl";
	}

}
