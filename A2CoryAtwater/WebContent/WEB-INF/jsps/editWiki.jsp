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
		<div style="background-color: red">
			<marquee behavior="scroll" direction="left">Time of Edit: ${date} </marquee>
		</div>
		<c:url value="/saveWiki" var="url" />
		<form:form modelAttribute="wiki" method="post" action="${url}">
			<div class="form-group jumbotron-img-top">
				
				<h1 class="display-1 jumbotron-text">
					<form:input path="wikiName" />
				</h1>
				<span style="color:red">${wikiName}</span>
			</div>
			<div class="form-group">
			<c:url value="/" var="homeUrl" />
				<a class="btn btn-success"
					href="${homeUrl}">Cancel</a>
				<c:url value="/deleteWiki/${wiki.wikiId}" var="deleteUrl" />
				<a class="btn btn-danger" href="${deleteUrl}">Delete</a>
			</div>
			<div class="form-group">
				Wiki Category:
				<form:input path="wikiCategory" />
				<span style="color:red">${wikiCategory}</span>
			</div>
			<div class="form-group ml-sm-5 mr-sm-5">
				<br />
				<form:textarea rows="4" cols="50" path="wikiInfo" />
				<span style="color:red">${wikiInfo}</span>
			</div>
			<div class="form-group">
				Wiki Front Page Picture:
				<form:input class="input-image" path="wikiPicture" />
				<span style="color:red">${wikiPicture}</span>
				<form:hidden path="wikiId" />
			</div>
			<input type="submit" class="btn btn-primary" value="Update Wiki" />
		</form:form>

	</div>
</body>
</html>