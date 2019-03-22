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
<title>Edit Wiki</title>

<style>
.jumbotron-img-top {
	width: 100%;
	height: 15vw;
	background-size: cover;
	background-repeat: no-repeat;
	background-image: url('../images/jumbotron-bg.jpg');
}

.help-img {
	width: 70%;
	height: 19vw;
}

.save-img {
	width: 90%;

}

.jumbotron-text {
	padding-top: 80px;
}

.input-image {
	width: 400px;
}
</style>

<script>
	$('#myModal').on('shown.bs.modal', function() {
		$('#myInput').trigger('focus')
	})
</script>
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
					Wiki Name:
					<form:input path="wikiName" />
				</h1>
				<span style="color:red">${wikiName}</span>
			</div>
			<br />
			<br />
			<br />
			<br />
			<br />
			<div class="form-group">
				Wiki Category:
				<form:input path="wikiCategory" />
				<div style="color:red">${wikiCategory}</div>
			</div>
			<div class="form-group ml-sm-5 mr-sm-5">
				 Wiki Info:
				<form:textarea rows="4" cols="50" path="wikiInfo" />
				<div style="color:red">${wikiInfo}</div>
			</div>
			<div class="form-group">
				
				Wiki Front Page Picture:
				<form:input class="input-image" path="wikiPicture" />
				<div style="color:red">${wikiPicture}</div>
				<form:hidden path="wikiId" />
				<!-- Add Info for adding image -->
				<button type="button" class="btn btn-warning mt-sm-2" data-toggle="modal"
					data-target="#imageHelp">Unsure how to add an Image? Click Me!</button>

				<!-- Modal -->
				<div class="modal fade" id="imageHelp" tabindex="-1"
					role="dialog" aria-labelledby="imageHelpLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="imageHelpLabel">Steps for adding image properly</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
							<label>
								1. Search IMG on Google and right click the IMG
							</label>
							<label>
								2. <img class="help-img"src="<c:url value="/images/help-img.jpg"/>" alt="...">
							</label>
							<label>
								3. <img class="save-img" src="<c:url value="/images/save-img.jpg"/>" alt="...">
							</label>
							<label>
								4. Save Wiki
							</label>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" data-dismiss="modal">Got It!</button>
							</div>
						</div>
					</div>
				</div>



			</div>
			<input type="submit" class="btn btn-primary mb-sm-4" value="Save Wiki" />
		</form:form>
	</div>
</body>
</html>