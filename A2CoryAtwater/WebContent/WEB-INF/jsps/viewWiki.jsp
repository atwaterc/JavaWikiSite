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
	width: 20%;
	height: 15vw;
}
.wiki-img{
	width: 100%;
	
}

.jumbotron-text {
	padding-top: 10px;
}
</style>
</head>
<body style="background-color: #E9E5DC">
	<div class="text-center">

		<c:url value="/saveWiki" var="url" />
		<form:form modelAttribute="wiki" method="post" action="${url}">

			<div class="card sticky-top">
				<c:choose>
					<c:when test="${wiki.wikiCategory == 'Sports'}">
						<div class="float-right">
							<img class="jumbotron-img-top float-right"
								src="<c:url value="/images/sports-bg.jpg"/>" alt="...">
						</div>
					</c:when>
					<c:when test="${wiki.wikiCategory == 'History'}">
						<div class="float-right">
							<img class="jumbotron-img-top float-right"
								src="<c:url value="/images/history-bg.png"/>" alt="...">
						</div>
					</c:when>
					<c:when test="${wiki.wikiCategory == 'Music'}">
						<div class="float-right">
							<img class="jumbotron-img-top float-right"
								src="<c:url value="/images/music-bg.png"/>" alt="...">
						</div>
					</c:when>
					<c:when test="${wiki.wikiCategory == 'Technology'}">
						<div class="float-right">
							<img class="jumbotron-img-top float-right"
								src="<c:url value="/images/robot-bg.png"/>" alt="...">
						</div>
					</c:when>
					<c:otherwise>
						<div class="float-right">
							<img class="jumbotron-img-top float-right"
								src="<c:url value="/images/jumbotron-bg.jpg"/>" alt="...">
						</div>
					</c:otherwise>
				</c:choose>


				<div class="card-img-overlay">
					<c:url value="/" var="homeUrl" />
					<a class="btn btn-success float-left mt-sm-2 ml-sm-2"
						href="${homeUrl}">Back</a>
					<h1 class="display-1 jumbotron-text">${wiki.wikiName}</h1>
				</div>
			</div>

			<div class="form-group mt-sm-3">
				<c:url value="/editWiki/${wiki.wikiId}" var="editUrl" />
				<a class="btn btn-success" href="${editUrl}">Edit</a>
				<c:url value="/deleteWiki/${wiki.wikiId}" var="deleteUrl" />
				<a class="btn btn-danger" href="${deleteUrl}">Delete</a>
			</div>
			<div class="form-group ml-sm-5 mr-sm-5">
			<img class="jumbotron-img-top float-right rounded mb-sm-2 mr-sm-5"
								src="<c:url value="${wiki.wikiPicture}"/>" alt="...">
				<br /> <label style="float: left; width: 850px;">${wiki.wikiInfo}</label>

				<div class="card float-right mr-sm-4" style="width: 18rem;">
					<div class="card-header">Similar</div>
					<ul class="list-group list-group-flush">
						<c:forEach var="wikiCategory" items="${wikiCategory}">
							<li class="list-group-item">
								<c:url value="/viewWiki/${wikiCategory.wikiId}/${wiki.wikiCategory }" var="viewUrl" />
								<a class="btn btn-light" href="${viewUrl}">${wikiCategory.wikiName}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="form-group">
				<form:hidden path="wikiId" />

			</div>
		</form:form>

	</div>


</body>
</html>