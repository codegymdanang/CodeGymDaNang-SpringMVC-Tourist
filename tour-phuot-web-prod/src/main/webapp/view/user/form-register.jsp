
<head>

<link rel="stylesheet" type="text/css"
	href="resource/css/form-register-css.css">

</head>

	<div class="container" align="center">
		<div id="register_arround">
					<div class="name-register">
						<h3>JOIN TOURSTUDENT NOW</h3>
					</div>
					<br>
					<hr>
					<form action="saveuser" method="post">

						<div class="username">
							<input type="text" id="username" name="username"
								placeholder="userName">
						</div>
						<input type="password" name="password" id="password"
							placeholder="Password">
							 <input type="text" name="image"
							id="image" placeholder="image">
						<div class="phone-css">
							<input class="text" type="text" name="phone" id="phone"
								placeholder="Phone">
						</div>
						<label class="checkbox-inline"> <input type="checkbox"
							id="inlineCheckbox1" value="1" name="role1"> admin
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="inlineCheckbox2" value="2" name="role1"> user
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="inlineCheckbox3" value="3" name="role1"> tour guide
						</label>
						<br>
						
						<button type="submit" id="join" class="btn btn-info btn-xs">JOIN
							TOURSTUDENT</button>

					</form>
		</div>
	</div>
