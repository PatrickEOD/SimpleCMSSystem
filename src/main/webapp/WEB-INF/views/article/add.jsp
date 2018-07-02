<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add article</title>
</head>
<body>
<h1>Add Article</h1>
<form:form method="post" action="http://localhost:8080/WAR_JEE_W02_Hibernate_SpringCMS/article/add" modelAttribute="article">
	<form:hidden path="id"/>
	Title:
	<form:input type="text" path="title"/>
	<form:errors path="title"/><br/>
	Author:
	<form:select itemLabel="lastName" itemValue="id" path="author.id"
		items="${authors}"/><br/> 
	Categories:
	<form:select itemLabel="name" itemValue="id" path="category"
		items="${categories}" multiple="true"/><br/>
	Content:
	<form:input type="text" path="content"/>
	<form:errors path="content"/><br/>
	Draft:
	<form:radiobutton path="draft" value="true"/><br/>
	
	<input type="submit" value="save"/>
</form:form>
<br/>
<a href='<c:url value="/article/list"/>'>Articles</a>

</body>
</html>