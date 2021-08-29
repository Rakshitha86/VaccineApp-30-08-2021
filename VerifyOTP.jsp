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
<h4>${OTPsentmesssage}</h4>
	<form action="verifyotp.do" method="get">
		<div>
			<label class="text-danger">OTP :</label> <input
				style="background-color: silver; color: blue; font-weight: bold;"
				class="form-control" type="number" name="otp"
				placeholder="Enter otp" required="required"> <input
				type="submit" value="Verify OTP">
		</div>
	</form>
	<h4>${OTPverification}</h4>
	<footer style="background-color: yellow;"
		class="page-footer font-small fixed-bottom #20c997">
		<div class="footer-copyright text-center py-2"
			style="color: Purple; max-width: 100%;">All Right Reserved
			&copy; Xworkz 2021</div>
	</footer>
</body>
</html>