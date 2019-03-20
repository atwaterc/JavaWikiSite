<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Edit Wiki</title>

<style>
</style>
</head>
<body>
<h1>Edit Wiki</h1>
	<c:url value="/saveWiki" var="url" />
	<form:form modelAttribute="wiki" method="post" action="${url}">
		
		Wiki Title: <form:input path ="wikiName" />
		<br />Info: <form:textarea rows="4" cols="50" path ="wikiInfo" />
		<br />Wiki Picture: <form:input path ="wikiPicture"/>
		<br />
		<form:hidden path="wikiId"/>
		<input type="submit" value="Save Wiki" />
		
	</form:form>
</body>
</html>