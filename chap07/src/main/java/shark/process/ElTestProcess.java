package shark.process;

import java.time.LocalDate;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shark.dto.Book;

public class ElTestProcess implements Process{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application =  request.getServletContext();	// ServletContext : 서블릿들 담아놓는 통(서버)
		HttpSession session = request.getSession(); // 세션
		
		application.setAttribute("book", "[디지털지자인] 모바일 UI/UX 반응형 웹디자인");
		session.setAttribute("book", "모두의HTML5 & CSS3");
		request.setAttribute("book", "포토샵 & 일러스트레이터 2022");
		
		request.setAttribute("obj_book", new Book(
					"913858468891",
					"손자병법",
					"임용한",
					22800,
					500,
					java.sql.Date.valueOf(LocalDate.of(2025, 1, 28))
				));
		
		request.setAttribute("score", 2222);
		request.setAttribute("CLOTHES_SIZES", new String[] {"XL","L","S","XS"});
		return "/el_jstl/el";
	}

}
