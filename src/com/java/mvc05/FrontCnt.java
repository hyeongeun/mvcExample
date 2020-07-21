package com.java.mvc05;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FrontCnt
 */
public class FrontCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(FrontCnt.class.getName());
	public static String logMsg = "logMsg---------";

	private HashMap<String, Object> commandMap = new HashMap<String, Object>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontCnt() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("configFile");
		System.out.println("configFile : "+configFile);
		logger.info(logMsg+configFile);

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		Properties pro = new Properties();

		try {
			fis = new FileInputStream(configFile);
			bis = new BufferedInputStream(fis);
			pro.load(bis);


		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis!=null)bis.close();
				if(fis!=null)fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}

		}

		Iterator<Object> keyIter = pro.keySet().iterator();
		while(keyIter.hasNext()) {
			String key =(String)keyIter.next();
			String value = pro.getProperty(key);
			//System.out.println(key + "\t" + value);
			logger.info(logMsg+ key +"\t" +value); 

			try {
				//문자열을 오브젝트로 만들어주기
				Class<?> handleClass = Class.forName(value);
				Object handleObj = handleClass.getDeclaredConstructor().newInstance();
				commandMap.put(key,handleObj);
			}catch(Exception e) {
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
		//System.out.println(cmd);
		logger.info(logMsg+cmd);

				String view = null;
				try {
					//해당 클래스의 값을 최상위 클래스에 담아주기 
					Command com = (Command)commandMap.get(cmd);
					view = com.actionDo(request, response);
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
