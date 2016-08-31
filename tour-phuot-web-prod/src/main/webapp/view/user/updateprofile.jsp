<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
<script src="resource/js/jquery-1.11.1.min.js"></script>
<script src="resource/js/bootstrap.js"></script>
	<script>

	function myFunction() {
	    var pass1 = document.getElementById("password").value;
	    var pass2 = document.getElementById("confirmpassword").value;
	    var ok = true;
	    if (pass1 != pass2) {
	        //alert("Passwords Do not match");
	        document.getElementById("password").style.borderColor = "#E34234";
	        document.getElementById("confirmpassword").style.borderColor = "#E34234";
	        ok = false;
	    }
	 
	    return ok;
	}
    </script>

</head>
<body>
	<div class="container">
		<h1>Edit Profile</h1>
		<hr>
		<form class="form-horizontal" onsubmit="return myFunction()" action="getUser" method="post" enctype="multipart/form-data">
		<div class="row">
			<!-- left column -->
			<div class="col-md-3">
				<div class="text-center">
					<img src='resource/images/${user.image }' width="150" height="150px" class="avatar img-circle"
						alt="avatar">
					<h6>Upload a different photo...</h6>

					<input type="file" class="form-control" id="file" name="file">
				</div>
			</div>

			<!-- edit form column -->
			<div class="col-md-9 personal-info">
				<h3>Personal info</h3>
				
					<div class="form-group">
						<label class="col-lg-3 control-label">User Name:</label>
						<div class="col-lg-8">
							<label class="form-control" >${user.username }</label>
							<input class="form-control" type="hidden"  value="${user.username }" name="username">
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Phone:</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" placeholder="Phone" value="${user.phone }" name="phone">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label">Password:</label>
						<div class="col-md-8">
							<input class="form-control" type="password" id="password" name ="password"
								placeholder="***********">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Confirm password:</label>
						<div class="col-md-8">
							<input class="form-control" type="password" id="confirmpassword" name="confirmpassword"
								placeholder="***********">
						</div>
					</div>

					<div class="form-group">
						<label class="col-xs-3 control-label">Location</label>
						<div class="col-xs-5 selectContainer">
							<select class="form-control" name="location" id="location">
								<option value="da nang">Choose your location</option>
								<option value="da nang">Da Nang</option>
								<option value="ha noi">Ha Noi </option>
								<option value="hcm">Ho Chi Minh</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-8">
							<input type="submit" class="btn btn-primary" value="Save Changes" id="submit">
							<span></span> <input type="reset" class="btn btn-default"
								value="Cancel">
						</div>
					</div>
					</div>
					</div>
				</form>
			</div>

	<hr>
</body>
</html>