<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>user-list.jsp</h3><hr>
<ol>
	<c:forEach items="${userList}" var="user">
		<li>${user.id},${user.name}</li>
	</c:forEach>
</ol>
</body>
</html>