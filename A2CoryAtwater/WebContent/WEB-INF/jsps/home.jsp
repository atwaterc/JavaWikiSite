<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>A2 - Wiki</title>

<style>
.card-img-top {
	width: 100%;
	height: 8vw;
	object-fit: cover;
}

</style>
</head>
<body
	style="background:transparent url('<c:url value="/images/bg.jpg"/>') no-repeat; background-size:cover; background-attachment: fixed;">

	<div class="text-center mt-sm-5 mb-sm-5">
		<img src="<c:url value="/images/sheriwiki.png"/>" class="img-fluid"
			alt="Responsive image" />
	</div>

	<div class="text-center mt-sm-2 mb-sm-3">
		<c:url value="/addWiki" var="addUrl" />
		<a class="btn btn-primary" href="${addUrl}">Add New Wiki</a>
	</div>

	<!-- Card information for each wiki inside database -->
	<div class="container">
		<div class="row">
			<c:forEach var="wiki" items="${wikiList}">

				<c:if test="${not empty wiki.wikiId}">

					<div class="col-sm">
						<div class="card mb-sm-2" style="width: 18rem; flex-grow: 2;">
							<img class="card-img-top"
								src="<c:url value="${wiki.wikiPicture}"/>" alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title">${wiki.wikiName}</h5>
								<p class="card-text text-truncate">
									${wiki.wikiInfo }<br /> <input type="hidden"
										value="${wiki.wikiId}" />
										<input type="hidden"
										value="${wiki.wikiCategory}" />
								</p>
								<c:url value="/viewWiki/${wiki.wikiId}/${wiki.wikiCategory }" var="viewUrl" />
								<a class="btn btn-primary float-right" href="${viewUrl}">Learn More</a>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>

</html>