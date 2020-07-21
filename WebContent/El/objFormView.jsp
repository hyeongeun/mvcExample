<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- EL 내장객체 - HTTP 요청 파라미터 paramValues(배열) -->
	<h3>이름: ${param.name} </h3>
	<h3>아이디: ${param.id }</h3>
	<h3>비밀번호: ${param.pwd }</h3>
	<br><br>
	
	<!-- EL 내장객체 - JSP 저장객체 (Scope)읽기  -->
	<ul>
		<li>${pageScope.pName }</li> <%--결과가 나오지 못한다 자기 페이지가 아닌 넘어가는 페이지가 되기 때문 --%>
		<li>${requestScope.rName}</li>   <%--결과가 안나온다. --%>
		<li>${sessionScope.sName }</li>
		<li>${applicationScope.aName }</li>
	</ul>
</body>
</html>