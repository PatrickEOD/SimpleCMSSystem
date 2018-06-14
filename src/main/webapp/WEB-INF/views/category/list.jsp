<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Category</title>
</head>
<body>
<h1>List of categories</h1>
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Description</th>
	</tr>
	<c:forEach items="${category}" var="c">
		<tr>
			<td>${c.id}</td>
			<td>${c.name}</td>
			<td>${c.description}</td>
			<td><a href="<c:url value="/category/edit/${c.id}"/>">Edit category</a>
				<a href="<c:url value="/category/delete/${c.id}"/>">Delete category</a></td>
		</tr>
	</c:forEach>
</table>
<a href="<c:url value="/category/add"/>">Add category</a>
</body>
</html>