package com.java.mvc06;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		request.setAttribute("message", "글쓰기다ㅏ다");
		
		return "/mvc/write.jsp";
	}

}
