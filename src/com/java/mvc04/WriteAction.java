package com.java.mvc04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction implements CommandAction{
	public String actionDo(HttpServletRequest request, HttpServletResponse response) {
		// DB작업들
		request.setAttribute("message", "글쓰기");
		
		return "/mvc/write.jsp";
	}

}
