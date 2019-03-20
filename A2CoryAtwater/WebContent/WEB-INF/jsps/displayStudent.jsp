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
<h1>Display Students</h1>
	<c:forEach var ="student" items="${studentList}">
		<p>
			Name: ${student.name}<br>Song Writer:
			${student.music.songWriter}<br>Instrument:
			${student.music.instrument}<br>Genre: ${student.music.genre}<br>
			<c:url value="/editStudent/${student.id}" var="editUrl" />
			<a href="${editUrl}">Edit</a>
			<c:url value="/deleteStudent/${student.id}" var="deleteUrl" />
			<a href="${deleteUrl}">Delete</a>
		</p>
		</c:forEach>
		
		<c:url value ="/" var="addUrl" />
		<a href="${addUrl}">Add a Student</a>
</body>
</html>