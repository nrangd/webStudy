package dbListTest2.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * 페이지를 찾을수 없을때 넘어오는걸 처리하는곳
 * 
 * <p>당장은 할게없어서 404.jsp파일로 넘어가도록 String값만 보냄
 */
public class NotFound implements Process{
	
	// 페이지를 잘못 찾아왔을때 오는곳
	// index.jsp로 온다
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		return "/404";
	}

}
