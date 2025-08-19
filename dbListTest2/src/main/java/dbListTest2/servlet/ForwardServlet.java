package dbListTest2.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbListTest2.dao.BBSDAO;
import dbListTest2.dto.BBS;

public class ForwardServlet extends HttpServlet{
	Connection conn;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// TODO ServletContext와 application의 관계가 뭘까?
		// ServletContext는 뭘까?
		// https://cyk0825.tistory.com/78 심심할때 읽어보자
		
		ServletContext application = config.getServletContext();
		application.setAttribute("KEYWORDS", new String[] {"자유","창작","질문"});
		// 포워드 서블릿이 생성되었을때 초기의 세팅들을 해둔다
		// db에 접속을 시도하기
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드실패");
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","1234");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("드라이버에 접속하는데 문제가 생김");
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 유저가 웹에서 접속한 경로를 contextPath만 뺀채로 uri변수에 담는다
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI().substring(contextPath.length());
		// 요청으로 받은값이 읽는것만 하는 get 인가
		// 아니면 서버에 직접적으로 쓰는것을 원하는 post 인가 를 확인하는
		// 메서드(함수아님)를 변수에 담아둔다
		String method = request.getMethod();
		
		// uri에 담긴 변수에 따라 분기분(if)으로 어디로 가는지 정해준다
		if(uri.equals("/404")) {
		// 페이지를 잘못 찾아왔을때 오는곳
		// index.jsp로 온다
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
		} else if(uri.equals("/bbs/list")) {
		// bbs 테이블의 목록을 보여주는 페이지
			// db에서 테이블 목록을 불러와서 list에 넣는다
			BBSDAO dao = new BBSDAO(conn);
			List<BBS> list = dao.getAll();
			System.out.println(list);
			// 저장해둔 list를 request객체의 attribute에 담아둔다
			request.setAttribute("bbs_list", list);
			// 담아둔 정보와 함께 list.jsp페이지로 포워드 한다
			request.getRequestDispatcher("/WEB-INF/bbs/bbs_list.jsp").forward(request, response);
		} else if(uri.equals("/bbs/add")) {
		// bbs 테이블에 내용(컬럼)을 추가해주는 페이지
			if(method.equals("GET")) {
				// 이 페이지를 링크를 통해 혹은 직접들어왔을경우
				// 테이블을 추가해주는 bbs_add.jsp로 포워드해준다
				request.getRequestDispatcher("/WEB-INF/bbs/bbs_add.jsp").forward(request, response);				
			} else if(method.equals("POST")) {
				// 이 페이지로 POST방식의 요청이 들어왔을때
				// 전달 받은 데이터로 DB에 컬럼을 추가시킨다
				// 그 이후 정상적으로 처리가 되었다면 리스트 페이지로 포워드 혹은 리다이렉트를 해준다
				// TODO 단 유효하지 않은 데이터가 있을지도 모르니 그건 언젠간 처리를하자
			}
			
		} else if(uri.equals("/bbs/edit")) {
		// bbs 테이블 목록에서 선택된 컬럼의 id로부터 올수있는 페이지
		// 테이블 내용을 수정할 수 있다
			request.getRequestDispatcher("/WEB-INF/bbs/bbs_edit.jsp").forward(request, response);
		} else if(uri.equals("/bbs/delete")) {
		// bbs 테이블의 내용을 삭제 해주는곳
		// 여기서 특정 테이블의 컬럼을 삭제할 수 있다
		// 별도의 페이지가 있지는 않다
			
		// 삭제가 끝나면 리스트 페이지로 돌아옴
			request.getRequestDispatcher("/WEB-INF/bbs/bbs_list.jsp").forward(request, response);
		} else {
			// 지정되지 않은 경로로 이동시에 index링크로 리다이렉트시킨다
			response.sendRedirect(contextPath + "/404");
			System.out.println("유저가 접속시도한 uri : " + uri);
		}
	}
	
	@Override
	public void destroy() {
		// 포워드 서블릿이 사라질때 같이 끝내야할것들
		// db연결 닫기
		
	}
}
