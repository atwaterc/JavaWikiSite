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
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
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
		<button type="button" id="add" class="btn btn-primary"
			data-toggle="modal" data-target="#myModal">Add New Wiki 
		</button>
	</div>

	<!-- Modal to add new Wiki-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add New Wiki</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<!-- Wiki form input -->
					<c:url value="/saveWiki" var="url" />
					<form:form modelAttribute="wiki" method="post" action="${url}">
		
						Wiki Title: <form:input class="mt-sm-1 mb-sm-1" path="wikiName" />
						<br />Info: <form:textarea class="mb-sm-1" rows="4" cols="50" path="wikiInfo" />
						<br />Wiki Picture: <form:input path="wikiPicture" />
						<br />
						<form:hidden path="wikiId" />
						<input type="submit" class="btn btn-primary float-right" value="Save Wiki" />

					</form:form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Cancel</button>
				</div>
			</div>
		</div>
	</div>

<!-- Card information for each wiki inside database -->
	<div class="container">
		<div class="row">

			<c:forEach var="wiki" items="${wikiList}">
				<div class="col-sm">
					<div class="card mb-sm-2" style="width: 18rem; flex-grow: 2;">
						<img class="card-img-top"
							src="<c:url value="${wiki.wikiPicture}"/>" alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">${wiki.wikiName}</h5>
							<p class="card-text text-truncate">
								${wiki.wikiInfo }<br />
								<input type="hidden" value="${wiki.wikiId}" />
							</p>
							<c:url value="/viewWiki/${wiki.wikiId}" var="viewUrl" />
							<a class="btn btn-primary" href="${viewUrl}">View</a>
							<c:url value="/editWiki/${wiki.wikiId}" var="editUrl" />
							<a class="btn btn-success" href="${editUrl}">Edit</a>
							<c:url value="/deleteWiki/${wiki.wikiId}" var="deleteUrl" />
							<a class="btn btn-danger float-right" href="${deleteUrl}">Delete</a>
							
						</div>
					</div>

				</div>
			</c:forEach>

		</div>
	</div>
</body>


<script>
	$('add').on('click', function() {
		$('#myModal').modal();
	});
</script>
</html>