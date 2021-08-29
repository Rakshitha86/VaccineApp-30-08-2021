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
<body>
	<nav class="navbar navbar-light" style="background-color: yellow;">
		<a class="navbar-brand" style="color: Purple; font-weight: bold">
			Vaccine Application</a>
	</nav>
	<form action="addmemberdetails.do">
		<div class="col-sm-4" class="form-group row">
			<label class="text-danger">FullName :</label> <input
				style="background-color: silver; color: blue; font-weight: bold;"
				class="form-control" type="text" name="name"
				placeholder="Enter the name">
			<h4>${ErrorInTheFieldFullname}</h4>
		</div>

		<div class="form-check">
			<label class="text-danger" class="form-check-label">SelectGender:</label>
		</div>
		<div class="col-sm-4">
			</label> <label class="text-dark" class="radio-inline"> <input
				type="radio" name="gender" value="male">Male
			</label> <label class="text-dark" class="radio-inline"> <input
				type="radio" name="gender" value="female">Female
			</label> <label class="text-dark" class="radio-inline"> <input
				type="radio" name="gender" value="others">Prefer not to say
			</label>
			<h4>${ErrorInTheFieldgender}</h4>
		</div>
		<div class="col-sm-4" class="form-group row">
			<div>
				<label class="text-danger" class="form-check-label">VaccineType:</label>
			</div>
			<select name="VaccineType">
				<option>Covaxin</option>
				<option>Covishield</option>
				<option>Sputnik</option>
				<option>Inactivated Vaccine</option>
				<option>Live-attenuated Vaccine</option>
				<option>Viral vector Vaccine</option>
				<option>Subunit Vaccine</option>
				<option>Genetic Vaccine</option>
			</select>
			<h4>${ErrorInTheFieldtype}</h4>
		</div>



		<div>
			<input style="margin-top: 10px; margin-left: 30px;" type="submit"
				value="Register" class="btn btn-primary"> <input
				style="margin-top: 10px; margin-left: 30px;" type="reset"
				value="Reset" class="btn btn-secondary">
		</div>
	</form>
	<footer style="background: yellow;"
		class="page-footer font-small #20c997">
		<div class="footer-copyright text-center py-2" style="color: Purple">
			All Right Reserved &copy; Xworkz 2021</div>
	</footer>
</body>
</html>