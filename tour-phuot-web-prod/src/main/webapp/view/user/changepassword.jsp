<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<script src="resource/js/jquery-1.11.1.min.js"></script>
<script src="resource/js/bootstrap.js"></script>

<script>
$(document).ready(function() {
$("input[type=password]").keyup(function(){
    var ucase = new RegExp("[A-Z]+");
	var lcase = new RegExp("[a-z]+");
	var num = new RegExp("[0-9]+");
	
	if($("#password1").val().length >= 6){
		$("#8char").removeClass("glyphicon-remove");
		$("#8char").addClass("glyphicon-ok");
		$("#8char").css("color","#00A41E");
	}else{
		$("#8char").removeClass("glyphicon-ok");
		$("#8char").addClass("glyphicon-remove");
		$("#8char").css("color","#FF0004");
	}
	
	/* if(ucase.test($("#password1").val())){
		$("#ucase").removeClass("glyphicon-remove");
		$("#ucase").addClass("glyphicon-ok");
		$("#ucase").css("color","#00A41E");
	}else{
		$("#ucase").removeClass("glyphicon-ok");
		$("#ucase").addClass("glyphicon-remove");
		$("#ucase").css("color","#FF0004");
	} */
	
	if(lcase.test($("#password1").val())){
		$("#lcase").removeClass("glyphicon-remove");
		$("#lcase").addClass("glyphicon-ok");
		$("#lcase").css("color","#00A41E");
	}else{
		$("#lcase").removeClass("glyphicon-ok");
		$("#lcase").addClass("glyphicon-remove");
		$("#lcase").css("color","#FF0004");
	}
	
	/* if(num.test($("#password1").val())){
		$("#num").removeClass("glyphicon-remove");
		$("#num").addClass("glyphicon-ok");
		$("#num").css("color","#00A41E");
	}else{
		$("#num").removeClass("glyphicon-ok");
		$("#num").addClass("glyphicon-remove");
		$("#num").css("color","#FF0004");
	} */
	
	if($("#password1").val() == $("#password2").val()){
		$("#pwmatch").removeClass("glyphicon-remove");
		$("#pwmatch").addClass("glyphicon-ok");
		$("#pwmatch").css("color","#00A41E");
	}else{
		$("#pwmatch").removeClass("glyphicon-ok");
		$("#pwmatch").addClass("glyphicon-remove");
		$("#pwmatch").css("color","#FF0004");
	}
	
});

$(function () {
    $("#btnSubmit").click(function () {
    	var ucase = new RegExp("[A-Z]+");
    	var lcase = new RegExp("[a-z]+");
    	var num = new RegExp("[0-9]+");
    	
        var password = $("#password").val();
        var confirmPassword = $("#hiddenpassword").val();
        var newpassword = $("#password1").val();
        var repeatpassword = $("#password2").val();
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        if(newpassword!= repeatpassword){
        	alert("New Passwords and Confirm Passwords do not match.");
        	return false;
        }

        if($("#password1").val().length >= 6){
    		$("#8char").removeClass("glyphicon-remove");
    		$("#8char").addClass("glyphicon-ok");
    		$("#8char").css("color","#00A41E");
    	}else{
    		$("#8char").removeClass("glyphicon-ok");
    		$("#8char").addClass("glyphicon-remove");
    		$("#8char").css("color","#FF0004");
    		return false;
    	}
    	
    /* 	if(ucase.test($("#password1").val())){
    		$("#ucase").removeClass("glyphicon-remove");
    		$("#ucase").addClass("glyphicon-ok");
    		$("#ucase").css("color","#00A41E");
    	}else{
    		$("#ucase").removeClass("glyphicon-ok");
    		$("#ucase").addClass("glyphicon-remove");
    		$("#ucase").css("color","#FF0004");
    		return false;
    	} */
    	
    	if(lcase.test($("#password1").val())){
    		$("#lcase").removeClass("glyphicon-remove");
    		$("#lcase").addClass("glyphicon-ok");
    		$("#lcase").css("color","#00A41E");
    	}else{
    		$("#lcase").removeClass("glyphicon-ok");
    		$("#lcase").addClass("glyphicon-remove");
    		$("#lcase").css("color","#FF0004");
    		return false;
    	}
    	
    	/* if(num.test($("#password1").val())){
    		$("#num").removeClass("glyphicon-remove");
    		$("#num").addClass("glyphicon-ok");
    		$("#num").css("color","#00A41E");
    	}else{
    		$("#num").removeClass("glyphicon-ok");
    		$("#num").addClass("glyphicon-remove");
    		$("#num").css("color","#FF0004");
    		return false;
    	} */

        return true;
    });
});


});
</script>
</head>
<body>
	<form method="post" action="updateprofile" >
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<h1>Change Password</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
						<input type="password" class="input-lg form-control"
							name="password" id="password" placeholder="Current Password"
							autocomplete="off">
						<input type="hidden" value="${user.password }" id="hiddenpassword">
						<input type="password" class="input-lg form-control"
							name="password1" id="password1" placeholder="New Password"
							autocomplete="off">
						<div class="row">
							<div class="col-sm-6">
								<span id="8char" class="glyphicon glyphicon-remove"
									style="color: #FF0004;"></span> 6 Characters Long<br> 
									<!-- <span
									id="ucase" class="glyphicon glyphicon-remove"
									style="color: #FF0004;"></span> One Uppercase Letter -->
							</div>
							<div class="col-sm-6">
								<span id="lcase" class="glyphicon glyphicon-remove"
									style="color: #FF0004;"></span> One Lowercase Letter<br> 
									<!-- <span
									id="num" class="glyphicon glyphicon-remove"
									style="color: #FF0004;"></span> One Number -->
							</div>
						</div>
						<input type="password" class="input-lg form-control"
							name="password2" id="password2" placeholder="Repeat Password"
							autocomplete="off">
						<div class="row">
							<div class="col-sm-12">
								<span id="pwmatch" class="glyphicon glyphicon-remove"
									style="color: #FF0004;"></span> Passwords Match
							</div>
						</div>
						<input type="submit" id="btnSubmit" 
							class="col-xs-12 btn btn-primary btn-load btn-lg"
							data-loading-text="Changing Password..." value="Change Password">
							</div>
							</div>
							</div>
					</form>
</body>
</html>