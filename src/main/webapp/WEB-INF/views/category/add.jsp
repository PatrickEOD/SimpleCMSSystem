<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Category</title>
</head>
<body>
<h1>Add Category</h1>
<form:form method="post" action="http://localhost:8080/WAR_JEE_W02_Hibernate_SpringCMS/category/add" modelAttribute="category">
	<form:hidden path="id"/>
	Name:
	<form:input path="name"/><br/>
	Description:
	<form:textarea path="description" rows="4" cols="20"/><br/>
	<input type="submit" value="save"/>
</form:form>
</body>
</html>