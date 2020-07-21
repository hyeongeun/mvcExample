package com.java.mvc04;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommandCnt
 */

public class CommandCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> commandMap = new HashMap<String, Object>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommandCnt() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() throws ServletException {
		WriteAction write = new WriteAction();
		commandMap.put("/write.action", write);
		
		ListAction list = new ListAction();
		commandMap.put("/list.action", list);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getRequestURI();
		cmd = cmd.substring(request.getContextPath().length());
		System.out.println(cmd);		// /write.action / list.action -> key가 되는 것이다. 

		 //해당 클래스의 값을 최상위 클래스에 담아주기
		CommandAction commandAction = (CommandAction)commandMap.get(cmd);
		String view = commandAction.actionDo(request, response);


		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
