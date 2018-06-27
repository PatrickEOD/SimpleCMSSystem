<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add author</title>
</head>
<body>
<h1>Add Author</h1>
<form:form method="post" action="http://localhost:8080/WAR_JEE_W02_Hibernate_SpringCMS/author/add" modelAttribute="author">
	<form:hidden path="id"/>
	Name:
	<form:input type="text" path="firstName"/>
	<form:errors path="firstName"/><br/>
	Surname:
	<form:input type="text" path="lastName"/>
	<form:errors path="lastName"/><br/>
	<input type="submit" value="save"/>
</form:form>
<br/>
<a href='<c:url value="/author/list"/>'>Authors</a>
</body>
</html>