<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<form:input type="text" path="title"/><br/>
	Author:
	<form:select itemLabel="firstName" itemValue="id" path="author.id"
		items="${authors}"/><br/> 
	Categories:
	<form:select itemLabel="name" itemValue="id" path="category"
		items="${categories}" multiple="true"/><br/>
	Content:
	<form:input type="text" path="content"/><br/>
		
	<input type="submit" value="save"/>
</form:form>

</body>
</html>