package chapter01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet(URI) : 이 서블릿으로 접속할 때 사용할 URI를 설정한다

// .jsp로 작성된 JSP 코드들은 1차적으로 서블릿 형태로 변환된다

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpServletRequest : 클라이언트 측의 요청에 실려오는 모드 정보들이 담겨있는 객체
		// HttpServletResponse : 우리가 응답을 실어놓어야 하는 객체, 
		// service() 메서드가 끝나면 이 객체에 실어놓은 내용을 바탕으로 응답을 생성하여 클라이언트에게 보낸다
		
		PrintWriter out = resp.getWriter();
		// .jsp로 작성된 JSP 코드들은 1차적으로 서블릿의 다음과 같은 형태로 변환된다
		out.print("<html lang=\"ko\"><head><title>안녕하세요</title></head><body>");
		out.print("<h3>Hello!</h3>");
		out.print("<p>Welcom to my page!</p>");
		out.print("<p>한글은 아마도 다 깨짐</p>");
		out.print("</body></html>");
	}
}
