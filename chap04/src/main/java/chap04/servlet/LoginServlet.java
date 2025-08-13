package chap04.servlet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String imgName = "";
		String data = "";

		
		int tryCount = req.getAttribute("tryCount") == null ? 0 : (int)req.getAttribute("tryCount");
		boolean login_success = false;
		
		String memberText = req.getServletContext().getResource("/data/member.txt").getPath();
		File file = new File(memberText);
		
		try (FileReader fr = new FileReader(file);){
			char[] buff = new char[2048];
			
			int len;
			StringBuilder infoBuilder = new StringBuilder();	
			while ((len = fr.read(buff)) != -1) {
				// new String(char[], start, end)
				// : 해당 char[]의 내용을 통해 새 문자열 인스턴스를 생성하는 생성자
				//   문자열을 만들 때 사용할 인덱스의 시작 위치와 마지막 위치를 직접 설정할 수 있다
				infoBuilder.append(new String(buff, 0, len));
			}
			data = infoBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(data);

		Pattern infoPattern = Pattern.compile("([\\w]+)/([\\w]+)/([\\w/_.]+)");
		Matcher infoMatcher = infoPattern.matcher(data);
		
		while(infoMatcher.find()) {
			String did = infoMatcher.group(1);
			String dpswd = infoMatcher.group(2);
			String dpath = infoMatcher.group(3);
			
			if(id.equals(did)) {
				if(password.equals(dpswd)) {
					login_success = true;
					imgName = dpath;
					break;
				}
			}
		}
		
		if(login_success) {
			resp.sendRedirect("");
		} else {
			req.setAttribute("tryCount", tryCount++);
			resp.sendRedirect("/chap04/session/login.jsp");
		}
	}
}
