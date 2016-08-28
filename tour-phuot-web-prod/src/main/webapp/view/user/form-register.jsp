
<head>

<link rel="stylesheet" type="text/css"
	href="resource/css/form-register-css.css">

</head>

<div class="register">
	<div class="top_register">
		<a class="btn btn-link" href="#" role="button"> <!-- Trigger/Open The Modal -->
			<button id="my_register" class="">Register</button>
		</a>
	</div>
	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">

			<div class="box">
				<span class="close">×</span>
				<div class="login">
					<div class="name-login">
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
							id="inlineCheckbox1" value="admin" name="role1"> admin
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="inlineCheckbox2" value="user" name="role1"> user
						</label> <label class="checkbox-inline"> <input type="checkbox"
							id="inlineCheckbox3" value="tour guide" name="role1"> tour guide
						</label>
						<br>
						
						<button type="submit" id="join" class="btn btn-info btn-xs">JOIN
							TOURSTUDENT</button>






					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</div>

<script>
	// Get the modal
	var modal = document.getElementById('myModal');

	// Get the button that opens the modal
	var btn = document.getElementById("my_register");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks the button, open the modal
	btn.onclick = function() {
		modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>

