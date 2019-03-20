<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Wiki</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<style>
.jumbotron-img-top {
	width: 100%;
	height: 15vw;
	background-size: cover;
	background-repeat: no-repeat;
	background-image: url('../images/jumbotron-bg.jpg');
}

.jumbotron-text {
	padding-top: 80px;
}
</style>
</head>
<body>
	<div class="text-center">
		<c:url value="/saveWiki" var="url" />
		<form:form modelAttribute="wiki" method="post" action="${url}">
			<div class="form-group jumbotron-img-top">
				<c:url value="/" var="homeUrl" />
				<a class="btn btn-success float-left mt-sm-2 ml-sm-2" href="${homeUrl}">Back</a>
				<h1 class="display-1 jumbotron-text">${wiki.wikiName}</h1>
			</div>
			<div class="form-group">
				<c:url value="/editWiki/${wiki.wikiId}" var="editUrl" />
				<a class="btn btn-success" href="${editUrl}">Edit</a>
				<c:url value="/deleteWiki/${wiki.wikiId}" var="deleteUrl" />
				<a class="btn btn-danger" href="${deleteUrl}">Delete</a>
			</div>
			<div class="form-group ml-sm-5 mr-sm-5">
				<br /> <label>${wiki.wikiInfo}</label>
			</div>
			<div class="form-group">
				<form:hidden path="wikiId" />
			</div>
		</form:form>
	</div>
</body>
</html>