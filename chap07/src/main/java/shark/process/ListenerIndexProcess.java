package shark.process;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListenerIndexProcess implements Process{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		application.setAttribute("icecream", "누가바");
		session.setAttribute("icecream", "스크류바");
		request.setAttribute("icecream", "더위사냥");
		
		return "/listener/index";
	}
	
}
