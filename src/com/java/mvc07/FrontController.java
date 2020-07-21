package com.java.mvc07;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */

@WebServlet(urlPatterns = "*.eat", initParams = @WebInitParam(name="configFile", value="/WEB-INF/anno.properties"))

//요청이 들어오면 서블릿파일 하나에서 처리해 주기 
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(FrontController.class.getName());
	public static final String logMsg = "=====logMsg======";

	private HashMap< String, Object> commandMap = new HashMap<String, Object>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String configFile = config.getInitParameter("configFile");
		logger.info(logMsg + configFile);


		String path = config.getServletContext().getRealPath(configFile);
		logger.info(logMsg + path);

		//현재 서블릿이 가지고 있는 컨텍스트 실제 경로를 가지고 와라 하는 것이다. 
		//C:\lhe\mvc\apache-tomcat-9.0.35\wtpwebapps\mvcExample\WEB-INF\cmdURI.properties

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		Properties pro = new Properties();

		try{
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis);
			pro.load(bis);


		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis != null) bis.close();
				if(fis != null) fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//키값을 오브젝트로 바꾸어 주기  iterator가 object로 읽어오는 것이다. 
		Iterator<Object>keyIter = pro.keySet().iterator();
		while(keyIter.hasNext()) {
			String key = (String)keyIter.next();
			//properties파일에서 읽어오는 것이기 때문에  String
			String value = pro.getProperty(key);
			logger.info(logMsg+key+"\t"+value);
			
			try {
				// value가 어떤 클래스로 바뀔지 모르니까 ?로 처리 해준다. 
				Class<?> handlerClass = Class.forName(value);
				Object handlerInstance = handlerClass.getDeclaredConstructor().newInstance();
				commandMap.put(key, handlerInstance);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getServletPath();
		logger.info(logMsg + cmd);
		
		String view = null;
		try {
		Command com = (Command)commandMap.get(cmd);
		view = com.proRequest(request, response);
		}catch(Throwable e) {
			e.printStackTrace();
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
