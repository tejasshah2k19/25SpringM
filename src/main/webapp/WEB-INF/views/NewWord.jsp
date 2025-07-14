<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Word</title>
<!-- Bootstrap 4.5 CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card shadow-sm">
					<div class="card-header text-center bg-primary text-white">
						<h4>New Word</h4>
					</div>
					<div class="card-body">
						<form action="saveword" method="post">
							<div class="form-group">
								<label for="firstName">Hint</label> <input type="text"
									class="form-control" name="hint" id="firstName"> <span
									class="text-danger">${result.getFieldError("firstName").getDefaultMessage()}</span>

							</div>
							<div class="form-group">
								<label for="lastName">Word</label> <input type="text"
									class="form-control" name="word" id="lastName"> <span
									class="text-danger">
									${result.getFieldError("lastName").getDefaultMessage()}</span>
							</div>
							<div class="form-group">
								<label for="email">Difficulty</label> <input type="text"
									class="form-control" name="difficulty" id="email">
								${result.getFieldError("email").getDefaultMessage()}
							</div>
							<button type="submit" class="btn btn-primary btn-block">Save
								Word</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap 4.5 JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
