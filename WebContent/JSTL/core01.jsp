<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSTL(JSP Standard Tag Library): Java를 태그로 만들어 놓음 
		CORE(변수선언, if문 for문), XML, FMT, SQL(데이터베이스는 여기서 할 필요가 없다.), Function 
	--%>
	<h3>변수선언</h3>
	<c:set var="su" value="10"/>
	<c:set var="imsi" value="${'20' }"/>
	
	<h3>${su} / ${imsi}</h3>
	
	<c:set var="msg" value="${'Hi' }" scope="page"/> 	<!-- page(기본값),request,session,application -->
	<c:set var="age" value="23"/>
	
	<div>
		메시지: ${msg}
		나이: ${age }
	</div><br><br>
	
	<jsp:useBean id="member" class="com.java.el.MemberInfo"/>
	<c:set target="${member }" property="name" value="홍길동"/>	<!-- value="${param.name}" -->
	<c:set target="${member }" property="id" value="abc123"/>
	<c:set target="${member }" property="pwd" value="1234"/>
	
	<h3>${member.name }</h3>
	<h3>${member.id }</h3>
	<h3>${member.pwd }</h3>
	
	<c:set var="id" value="${member.id }" scope="session"/>
	<h3>${sessionScope.id }</h3>
	<br><br>
	
	
	<h3>변수제거</h3>
	<c:remove var="age"/>
	<c:remove var="id" scope="session"/>
	<div>${age},${id }</div>
	
</body>
</html>