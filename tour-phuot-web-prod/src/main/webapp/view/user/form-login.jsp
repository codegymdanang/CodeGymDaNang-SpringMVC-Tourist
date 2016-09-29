<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
<link rel="stylesheet" type="text/css"
	href="resource/css/form-login-css.css">
</head>

<!-- <div class="top">
	<a class="btn btn-link" href="#" role="button"> Trigger/Open The Modal
		<button id="myBtn" class="">Login</button>
	</a>

</div> -->


<div class="container" align="center">
	<div id="login_arround">
	<!-- 	<div class="row">

				<div class="image">
					<div class="col-md-6">
						<img src="resource/images/login/image_login.jpg" width="300"
							height="300px">
					</div>
				</div>
				<div class="col-md-6"> -->
					<div class="namelogin">

						<h3>LOGIN</h3>	
					</div>
					<hr>
					<form
						action="<%=request.getContextPath()%>/j_spring_security_check"
						method="post">
						<input type='text' name='username' value=''> 
						<input type="password" name="password" placeholder="Password">

						<div class="row">
							<div class="col-md-6">
								<input type="checkbox" name="remember" id="remember" /> <label
									class="check" for="remember"><span>Remember Me</span></label>
							</div>

							<div class="col-md-6">
									<a class="text_right" href="find">Forgotten account?</a>
							</div>
						</div>

						<!-- <div class="login"> -->
						<input type="submit" value="Login">
						<!-- </div> -->
					</form>

		<br/>
		  <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
		    <div class=" " style="color: red;">
		          <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
		
		      <c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope = "session" />
		    </div>
		  </c:if>
					<div class="logo">
						<div class="row">
							<div class="col-md-6">
								<a href="#">
									<div class="face">
										<img src="resource/images/login/i_face.png" width="25"
											height="25">
									</div>
								</a> <a href="#">
									<div class="google">
										<img src="resource/images/login/i_google.png" width="25"
											height="25">
									</div>
								</a> <a href="#">
									<div class="twi">
										<img src="resource/images/login/i_twi.png" width="25"
											height="25">
									</div>
								</a>
								
							</div>
							<div class="col-md-6">
								<p class="p1">
									<a id="my_register" class="text_right" href="register">CREATE
										NEW ACCOUNT</a>
								</p>
							</div>
						</div>
					</div>

			<!-- 	</div> -->

			</div>
	
</div>


			
<!-- <script>
	// Get the modal
	var modal = document.getElementById('myModalOfLogin');

	// Get the button that opens the modal
	var btn = document.getElementById("myBtnOfLogin");

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
 -->

