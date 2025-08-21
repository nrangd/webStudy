package dbListTest2.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Process {
	
	String process(HttpServletRequest request, HttpServletResponse response);
}
