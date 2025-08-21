package shark.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JstlHomeProcess implements Process{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		return "redirect:el_jstl";
	}

}
