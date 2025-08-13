package chap04.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chap04.model.User;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet{
	Map<String, User> allUsers = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			String path = config.getServletContext().getResource("/data/member2.txt").getPath();
			
			File f = new File(path);
			try (
					FileReader fr = new FileReader(f);
					BufferedReader in = new BufferedReader(fr);
			) {
				String line;
				while((line = in.readLine()) != null) {
					
					Pattern pattern = Pattern.compile("\\[(.+)/(.+)/\"(.+)\"\\]");
					
					Matcher matcher = pattern.matcher(line);
					
					while(matcher.find()) {
						String user_id = matcher.group(1);
						String user_password = matcher.group(2);
						String user_image_path = matcher.group(3);
						
						allUsers.put(
								user_id,
								new User(user_id, user_password, user_image_path));
					}
				}
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loginFailureProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		
		Object tc = session.getAttribute("try_count");
		Integer try_count = tc == null ? 0 : (Integer) tc;
		session.setAttribute("try_count", try_count + 1);
		response.sendRedirect(contextPath + "/session/login2.jsp");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		
		if (user_id == null || user_password == null 
				|| user_id.equals("") || user_password.equals("")) {
			loginFailureProcess(request, response);
			return;
		}
		
		System.out.println(allUsers);
		
		// 아이디가 빈 값은 아닌데 유저 중에 없는 경우
		User u = allUsers.get(user_id);
		if (u == null) {
			loginFailureProcess(request, response);
			return;
		}
		
		User guest = new User(user_id,user_password,null);
		
		// 로그인에 실패한 경우(비밀번호 틀림)
		boolean loginSuccess = u.canLogin(guest);
	
		if(!loginSuccess) {
			loginFailureProcess(request, response);
			System.out.println("로그인 실패");
			return;
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("login", true);
			session.setAttribute("user", u);
			
//			request.getRequestDispatcher("/session.login.jsp").forward(request, response);
			response.sendRedirect(contextPath + "/session/login2.jsp");
		}
	}
}
