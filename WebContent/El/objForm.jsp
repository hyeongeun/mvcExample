<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="objFormView.jsp" method ="post">
		<label>이름</label>
		<input type="text" name="name">
		<br>
		<label>아이디</label>
		<input type="text" name="id">
		<br>
		<label>비밀번호</label>
		<input type="text" name="pwd">
		<br>
		
		<input type="submit" value="확인">
		<input type="reset" value="취소">
		
		<% //자바코드 작성가능
			java.util.Date date = new java.util.Date();
		
			//내장객체로 지원(class 객체 안만드는 것)
			//pageScope	: 현재 페이지에서만 데이터 공유
			pageContext.setAttribute("pName", "apple");
				
			//requestScope	: 요청 시 데이터 공유(form, include, forward)
			request.setAttribute("rName", "banana");
				
			//sessionScope	: 하나의 웹어플리케이션에서 데이터 공유(cookies, session), 웹브라우저 한개 당 
			session.setAttribute("sName", "melon");
			
			//applicationScope : 하나의 웹어플리케이션에서 데이터 공유, 웹 서버가 꺼질때까지
			application.setAttribute("aName","strawberry");
		%>
	
	
	</form>

</body>
</html>