<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>El - 2. setMethod, getMethod</h3>
	
	<%--객체 선언 MemberInfo member = new MemberInfo() --%>
	<jsp:useBean id="member" class="com.java.el.MemberInfo"></jsp:useBean>
	
	<%--setMethod --%>
	${member.setName("이영자") }
	${member.setId("lee1234") }
	${member.setPwd("1234") }

	<h3>${member.toString()}</h3>
	
	<%--getMethod 거의 사용안함 아래것으로 사용함 --%>
	<h3>${member.getName() }</h3>
	<h3>${member.getId() }</h3>
	<h3>${member.getPwd() }</h3>
	<br><br>
	
	<h3>${member.name }</h3>
	<h3>${member.id}</h3>
	<h3>${member.pwd}</h3>
	
</body>
</html>