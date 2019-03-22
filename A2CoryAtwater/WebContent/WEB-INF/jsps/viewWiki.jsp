<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Wiki</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<style>
.jumbotron-img-top {
	width: 20%;
	height: 15vw;
}

.wiki-img-right {
	width: 25%;
	height: 15vw;
}

.jumbotron-img-left {
	width: 25%;
	height: 15vw;
}

.wiki-img {
	width: 100%;
}

.jumbotron-text {
	padding-top: 10px;
}

.info-span { 
    display:block;
    width:850px;
    word-wrap:break-word;
}
</style>
</head>
<body style="background-color: #E9E5DC">
	<div class="text-center">

		<c:url value="/saveWiki" var="url" />
		<form:form modelAttribute="wiki" method="post" action="${url}">

			<div class="card sticky-top shadow	">
				<c:choose>
					<c:when test="${wiki.wikiCategory == 'Sports'}">
						<div class="float-right">
							<img class="jumbotron-img-top float-right mt-sm-0"
								src="<c:url value="/images/sports-bg.jpg"/>" alt="...">
								<img class="jumbotron-img-top float-left"
								src="<c:url value="/images/corner-design.png"/>" alt="...">
						</div>
					</c:when>
					<c:when test="${wiki.wikiCategory == 'History'}">
						<div class="float-right">
							<img class="jumbotron-img-top float-right"
								src="<c:url value="/images/history-bg.png"/>" alt="...">
								<img class="jumbotron-img-top float-left"
								src="<c:url value="/images/corner-design.png"/>" alt="...">
						</div>
					</c:when>
					<c:when test="${wiki.wikiCategory == 'Music'}">
						<div class="float-right">
							<img class="jumbotron-img-top float-right"
								src="<c:url value="/images/music-bg.png"/>" alt="...">
								<img class="jumbotron-img-top float-left"
								src="<c:url value="/images/corner-design.png"/>" alt="...">
						</div>
					</c:when>
					<c:when test="${wiki.wikiCategory == 'Technology'}">
						<div class="float-right">
							<img class="jumbotron-img-top float-right"
								src="<c:url value="/images/robot-bg.png"/>" alt="...">
								<img class="jumbotron-img-top float-left"
								src="<c:url value="/images/corner-design.png"/>" alt="...">
						</div>
					</c:when>
					<c:otherwise>
						<div class="float-right">
							<img class="jumbotron-img-top float-right"
								src="<c:url value="/images/img-nf.jpg"/>" alt="...">
								<img class="jumbotron-img-top float-left"
								src="<c:url value="/images/corner-design.png"/>" alt="...">
						</div>
					</c:otherwise>
				</c:choose>
				
				

				<div class="card-img-overlay">
					<h1 class="display-1 jumbotron-text">${wiki.wikiName} </h1>
					<span class="h6">(${wiki.wikiCategory})</span>
				</div>
			</div>

			<div class="form-group mt-sm-3">
				<!-- Dropdown for similar categories -->
				<div class="dropdown">
				<c:url value="/" var="homeUrl" />
					<a class="btn btn-primary"
						href="${homeUrl}">Home</a>
				<c:url value="/editWiki/${wiki.wikiId}" var="editUrl" />
				<a class="btn btn-success" href="${editUrl}">Edit</a>
				<c:url value="/deleteWiki/${wiki.wikiId}" var="deleteUrl" />
				<a class="btn btn-danger" href="${deleteUrl}">Delete</a>
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Similar ${wiki.wikiCategory} Wiki's</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<c:forEach var="wikiCategory" items="${wikiCategory}">
							<c:url
								value="/viewWiki/${wikiCategory.wikiId}/${wiki.wikiCategory}"
								var="viewUrl" />
							<a class="dropdown-item btn btn-secondary" href="${viewUrl}">${wikiCategory.wikiName}</a>
						</c:forEach>
					</div>
				</div>
			</div>
			
			<div class="form-group ml-sm-5 mr-sm-5">
				<img class="wiki-img-right float-right rounded mb-sm-2 mr-sm-5 border border-primary shadow-lg"
					src="<c:url value="${wiki.wikiPicture}"/>" alt="..."> <br />
				<label class="mb-sm-4 text-left" style="float: left;"><span class="info-span">${wiki.wikiInfo}</span></label>
			</div>
			<div class="form-group">
				<form:hidden path="wikiId" />
			</div>
		</form:form>

	</div>


</body>
</html>