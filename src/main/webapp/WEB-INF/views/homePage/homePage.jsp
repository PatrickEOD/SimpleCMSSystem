<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
<h1>Home Page</h1>
<h3>5 last added articles</h3>
<table>
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Created</th>
		<th>Content</th>
		
	</tr>
	<c:forEach items="${listLast5}" var="a">
		<tr>
			<td>${a.id}</td>
			<td>${a.title}</td>
			<td>${a.created}</td>
			<td>${a.content}</td>
			
		</tr>
	</c:forEach>
</table>
<a href='<c:url value="/article/add"/>'>Add Article</a>
<a href='<c:url value="/article/list"/>'>Articles list</a>
</body>
</html>