<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="city" value="서울, 인천, 대구, 부산, 광주, 제주도"/>
	
	<c:forTokens var="data" items="${city }" delims=",">
		<c:out value ="${data }"/>
	</c:forTokens>
	<br><br>
	
	
	<c:set var="traffic" value="비행기, 자동차, 버스, 승합차 | 자전거. 오토바이"/>
	<c:forTokens var="tdata" items="${traffic }" delims=",|." varStatus="sts">
		${tdata }
		${sts.count }	
	</c:forTokens>
</body>
</html>