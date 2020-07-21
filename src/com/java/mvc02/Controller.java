package com.java.mvc02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */

//FrontController Pattern: 사용자의 모든 요청을 단 하나의 서블릿에서 처리하는 형태
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Controller doGet Function");

		StringBuffer URL=request.getRequestURL();
		String URI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String servletPath = request.getServletPath();

		System.out.println(URL);
		System.out.println(URI);
		System.out.println(contextPath);
		System.out.println(servletPath);

		String uri = request.getRequestURI();
		String cmd = uri.substring(request.getContextPath().length());
		System.out.println(cmd);

		String view = null;

		if(cmd.equals("/write.kitri")) {
			//클래스 Write w = new Write();  --> DTO, DAO  --> DB  --> DTO,DAO --> Controller --> write.jsp
			request.setAttribute("message", "글쓰기");
			view ="/mvc/write.jsp";		//결과페이지
		}else if(cmd.equals("/list.kitri")) {
			//클래스 List l = new List(); --> DTO,DAO -->DB --> DTO,DAO --> Controller --> list.jsp
			request.setAttribute("message", "글목록");
			view ="/mvc/list.jsp";		//결과페이지
		}

		if(view != null) {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
