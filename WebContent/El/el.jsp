<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>JAVA 명령어는 JSTL, EL 사용해야한다.</div>
	<!-- HTML 주석 -->
	<%-- JSP주석은 인터넷화면에서는 보이지 않는다. --%>
	<%--데이터, 연산자 --%>
	<h3>El - 1. 출력,연산자 가능(직접데이터 사용 가능, 변수(JSTL))</h3>
	<ol>
		<li> 수 출력: ${10},${99.99}</li>
		<li> 문자(문자열) 출력: ${"apple" },${'apple'}</li>
		<li>연산${10+20 }, ${10-20 },${4/5 },${5%7} </li>
		<li>작다: ${2<3 }, ${2 lt 3 }</li> 
		<li>크다: ${2>3 }, ${2 gt 3} </li>
		<li>작거나 같다: ${2.5 <=3.7 }, ${2 le 3 }</li>
		<li>크거나 같다: ${2.5 >=3.7 }, ${2 ge 3 }</li>
		<li>논리연산자:${"&&, AND , ||,OR, !,NOT"}</li>
		<li>빈문자열: ${null} </li>
	</ol>
	
</body>
</html>