<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron">
		<h1>Kumar vs Wasif, Who will win?</h1>
	</div>
	
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