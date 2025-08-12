package chap03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/attr/test/*")
public class AttributeTestServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		String uri = request.getRequestURI();
		
		// 하나의 서블릿에서 요청 방식과 요청 자원을 활용해 처리를 구분할 수 있다.
		System.out.println("요청방식:" + method);
		System.out.println("요청자원:" + uri);
		
		if(method.equals("GET")) {
			if (uri.endsWith("r")) {
				// 파라미터를 전달받은 데이터
				String employee_id = request.getParameter("employee_id");
				
				// 파라미터로 전달받은 데이터를 활용하여 DB에서 해당 사원 정보를 꺼내왔다고 가정
				
				// 꺼낸 정보를 다음 서블릿에서 활용할 수 있게끔 어트리뷰트에 실어놓기
				request.setAttribute("employee_id", employee_id);
				request.setAttribute("first_name", "Smith");
				request.setAttribute("last_name", "Sam");
				
				// 포워딩
				request
				.getRequestDispatcher("/pages/employeeDetailView.jsp")
				.forward(request, response);
			} 
			
		} else if(method.equals("POST")) {
			if(uri.endsWith("s")) {
				String user_id = request.getParameter("user_id");
				String user_password = request.getParameter("user_password");

				// 세션 꺼내기 (요청 내부에 실려있는 세션ID를 통해 세션 객체를 꺼냄)
				HttpSession session = request.getSession();	// JSP에서는 내장 객체임
				Object tryCount = session.getAttribute("tryCount");
				if(tryCount == null) {
					session.setAttribute("tryCount", 0);
					tryCount = session.getAttribute("tryCount");
				}
				
				// 아이디 test에 비밀번호 1234면 로그인 성공으로 간주
				if(user_id != null && user_password != null &&
						user_id.equals("test") && user_password.equals("1234")) {
					// 로그인 성공
					session.setAttribute("login_success", true);
				} else {
					// 로그인 실패
					session.setAttribute("login_success", false);
					session.setAttribute("tryCount", (int)tryCount + 1);
				}
				System.out.println(tryCount);
				response.sendRedirect("/chap03/attribute/test/sessionAttrTest.jsp");
			}
		}
	}
}
