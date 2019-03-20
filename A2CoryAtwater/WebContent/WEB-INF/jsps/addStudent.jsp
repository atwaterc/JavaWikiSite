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
	<c:url value="/saveStudent" var="url" />
	<form:form modelAttribute="student" method="post" action="${url}">
		
		Name: <form:input path ="name" />
		<br />Instrument: <form:input path ="music.instrument" />
		<br />Song Writer: <form:checkbox path ="music.songWriter" />
		<br />Genre: <form:select path="music.genre" items="${student.music.GENRES}" />
		<br />
		<form:hidden path="id"/>
		<input type="submit" value="Save Student!" />
		
	</form:form>
</body>
</html>