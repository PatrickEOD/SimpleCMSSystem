<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Authors</title>
</head>
<body>
<h1>List of Authors</h1>
<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Surname</th>
	</tr>
	<c:forEach items="${author}" var="a">
		<tr>
			<td>${a.id}</td>
			<td>${a.firstName}</td>
			<td>${a.lastName}</td>
			
			<td><a href='<c:url value="/author/edit/${a.id}"/>'>Edit author</a>
				<a href='<c:url value="/author/delete/${a.id}"/>'>Delete author</a></td>
		</tr>
	</c:forEach>
</table>
<a href='<c:url value="/author/add"/>'>Add Author</a><br/>
<a href="<c:url value="/home/"/>">Home Page</a>

</body>
</html>