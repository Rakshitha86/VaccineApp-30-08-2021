<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
</head>
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: yellow;">
		<a class="navbar-brand" style="color: Purple; font-weight: bold">
			Vaccine Application</a>

	</nav>

	<form action="forgotpassword.do" method="post">

		<h2>Reset Password Here</h2>
		<div class="col-sm-4" class="form-group row">
			<label class="text-danger">EmailId :</label> <input
				style="background-color: silver; color: blue; font-weight: bold;"
				class="form-control" type="email" name="mail"
				placeholder="Enter your email">
			<h4>${ErrorInTheFieldMail}</h4>
		</div>
		<div class="col-sm-4" class="form-group row">
			<label class="text-danger">CreatePassword :</label> <input
				style="background-color: silver; color: blue; font-weight: bold;"
				class="form-control" type="password" name="Createpassword"
				placeholder="Enter the password">
			<h4>${ErrorInTheFieldCreate}</h4>
		</div>
		<div class="col-sm-4" class="form-group row">
			<label class="text-danger">ConfirmPassword :</label> <input
				style="background-color: silver; color: blue; font-weight: bold;"
				class="form-control" type="password" name="Confirmpassword"
				placeholder="Confirm the password">
			<h4>${ErrorInTheFieldConfirm}</h4>
		</div>

		<div class="container">
			<input style="margin-top: 10px; margin-left: 30px;" type="reset"
				value="Reset" class="btn btn-secondary">
		</div>
	</form>


	<footer style="background-color: yellow;"
		class="page-footer font-small fixed-bottom #20c997">
		<div class="footer-copyright text-center py-2"
			style="color: Purple; max-width: 100%;">All Right Reserved
			&copy; Xworkz 2021</div>
	</footer>
</body>
</html>