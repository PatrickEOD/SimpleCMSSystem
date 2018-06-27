<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
<div>
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
				<td><fmt:formatDate value="${a.created}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${a.content}</td>
			</tr>
		</c:forEach>
	</table>
<%-- 	<a href='<c:url value="/article/add"/>'>Add Article</a> --%>
<%-- 	<a href='<c:url value="/article/list"/>'>Articles list</a> --%>
</div>
<br/>
<div>
	<h1>Article categories:</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
		</tr>
		<c:forEach items="${categories}" var="b">
			<tr>
				<td>${b.name}</td>
				<td>${b.description}</td>
				<td>
					<a href='<c:url value="/home/listByCategories/${b.id}"/>'>Search articles</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<div>
	<h3>Available links:</h3>
	<a href='<c:url value="/article/list"/>'>Articles</a><br/>
	<a href='<c:url value="/category/list"/>'>Categories</a><br/>
	<a href='<c:url value="/author/list"/>'>Authors</a>
</div>

<%-- 	<form:form method="post" action="http://localhost:8080/WAR_JEE_W02_Hibernate_SpringCMS/home/" modelAttribute="categories"> --%>
<!-- 		Get list of articles from categories:<br /> -->
<%-- 		<form:select itemLabel="name" itemValue="id" path="category" --%>
<%-- 			items="${categories}" /><br /> --%>
<!-- 		<input type="submit" value="Select category" /> -->
<%-- 	</form:form> --%>
</body>
</html>