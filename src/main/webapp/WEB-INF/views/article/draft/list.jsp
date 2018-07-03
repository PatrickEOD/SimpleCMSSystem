<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Drafts</title>
</head>
<body>
<h1>List of articles drafts</h1>
<table>
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Authors</th>
		<th>Categories</th>
		<th>Content</th>
		<th>Created</th>
		<th>Updated</th>
		<th>Draft</th>
		
	</tr>
	<c:forEach items="${draft}" var="a">
		<tr>
			<td>${a.id}</td>
			<td>${a.title}</td>
			<td>${a.author.firstName} ${a.author.lastName}</td>
			<td>
				<c:forEach items="${a.category}" var="c">
					${c.name}
				</c:forEach>
			</td>
			<td>${a.content}</td>
			<td><fmt:formatDate value="${a.created}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td><fmt:formatDate value="${a.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${a.draft}</td>
			
			<td><a href='<c:url value="/draft/edit/${a.id}"/>'>Edit draft</a>
				<a href='<c:url value="/draft/delete/${a.id}"/>'>Delete draft</a></td>
		</tr>
	</c:forEach>
</table>
<a href='<c:url value="/draft/add"/>'>Add article draft</a><br/>
<a href='<c:url value="/article/add"/>'>Add Article</a><br/>
<a href='<c:url value="/article/list"/>'>Articles</a><br/>
<a href="<c:url value="/home/"/>">Home Page</a>

</body>
</html>