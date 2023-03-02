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
<h1>user/list.jsp</h1>
<ol>
	<li><a href="view">KIM</li>
	<li><a href="view">LEE</li>
	<li><a href="view">HIM</li>
</ol>
<hr>
<ol>
	<li><a href="/spring_web_application/user/view">KIM</li>
	<li><a href="/spring_web_application/user/view">LEE</li>
	<li><a href="/spring_web_application/user/view">HIM</li>
</ol>
<hr>
<ol>
	<li><a href="<c:url value='/user/view'/>">KIM</li>
	<li><a href="<c:url value='/user/view'/>">LEE</li>
	<li><a href="<c:url value='/user/view'/>">HIM</li>
	
</ol>
</body>
</html>