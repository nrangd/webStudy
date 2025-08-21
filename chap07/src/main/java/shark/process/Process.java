package shark.process;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Process {
	
	// request, response를 전달받아 하고싶은 일은 한 후 가고 싶은 주소를 리턴하는 것을
	// 모두 처리라고 하겠다
	
	String process(HttpServletRequest request, HttpServletResponse response);
	
	
}
