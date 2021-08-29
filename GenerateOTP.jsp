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
<body style="background-image: url('Images/.jpg');">

	<nav class="navbar navbar-light" style="background-color: yellow;">
		<a class="navbar-brand" style="color: Purple; font-weight: bold">
			Vaccine Application</a>
	</nav>

	<marquee
		style="font-size: 40px; font-weight: bold; color: maroon; font-style: italic;">Welcome
	</marquee>
	<form action="sendotp.do" method="get">
		<div class="col-sm-4" class="form-group row">
			<label class="text-danger">EmailId :</label> <input
				style="background-color: silver; color: blue; font-weight: bold;"
				class="form-control" type="email" name="email"
				placeholder="Enter your email">
		</div>

		<div class="container">
			<input class="btn btn-primary"
				style="margin-top: 10px; margin-left: 2%;" type="submit"
				value="Send OTP"><h4>${ErrorInTheFieldMail}</h4>
		</div>

		<h4>${Userexistmessage}</h4>
		<h4>${OTPsentmesssage}</h4>

		<lable style="margin-left:20px;"> Already have an account</lable>
		<a href="login.do">Login</a>

	</form>
	<footer style="background-color: yellow;"
		class="page-footer font-small fixed-bottom #20c997">
		<div class="footer-copyright text-center py-2"
			style="color: Purple; max-width: 100%;">All Right Reserved
			&copy; Xworkz 2021</div>
	</footer>
</body>
</html>