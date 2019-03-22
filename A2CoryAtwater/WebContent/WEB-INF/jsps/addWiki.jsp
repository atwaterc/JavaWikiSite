<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Edit Wiki</title>

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

.input-image{
	width: 400px;
}
</style>
</head>
<body>
	<div class="text-center">
		<c:url value="/saveWiki" var="url" />
		<form:form modelAttribute="wiki" method="post" action="${url}">
			<div class="form-group jumbotron-img-top mb-sm-5">
				<c:url value="/" var="homeUrl" />
				<a class="btn btn-success float-left mt-sm-2 ml-sm-2"
					href="${homeUrl}">Cancel</a>
				<h1 class="display-1 jumbotron-text">
					Wiki Name: <form:input path="wikiName" />
				</h1>
			</div>
			<br /><br /><br /><br />
			<div class="form-group">
				Wiki Category:
				<form:input path="wikiCategory" />
			</div>
			<div class="form-group ml-sm-5 mr-sm-5">
				<br />
				Wiki Info:
				<form:textarea rows="4" cols="50" path="wikiInfo" />
			</div>
			<div class="form-group">
				Wiki Front Page Picture:
				<form:input class="input-image" path="wikiPicture" />
				<form:hidden path="wikiId" />
			</div>
			<input type="submit" class="btn btn-primary" value="Save Wiki" />
		</form:form>
	</div>
</body>
</html>