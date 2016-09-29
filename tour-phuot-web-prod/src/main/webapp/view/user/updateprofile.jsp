<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
<script src="resource/js/jquery-1.11.1.min.js"></script>
<script src="resource/js/bootstrap.js"></script>

	<style type="text/css">
	.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
	</style>
		<script type="text/javascript">
			$(document).ready(function(){
					var location = document.getElementById('locationhidden').value;
					$('#location').val(location);
			});
			 function showMyImage(fileInput) {
			        var files = fileInput.files;
			        for (var i = 0; i < files.length; i++) {           
			            var file = files[i];
			            var imageType = /image.*/;     
			            if (!file.type.match(imageType)) {
			                continue;
			            }           
			            var img=document.getElementById("image");            
			            img.file = file;    
			            var reader = new FileReader();
			            reader.onload = (function(aImg) { 
			                return function(e) { 
			                    aImg.src = e.target.result; 
			                }; 
			            })(img);
			            reader.readAsDataURL(file);
			        }    
			    }
		
				
			</script>
			
	
</head>
<body>
	<div class="container">
		<h1>Edit Profile</h1>
		<hr>
		<form:form class="form-horizontal"  modelAttribute="userModel" action="userprofile" method="post" enctype="multipart/form-data" autocomplete="off">
		<div class="row">
			<!-- left column -->
			<div class="col-md-3">
				<div class="text-center">
					
				<c:choose>
    					<c:when  test="${not empty userModel.image }">
    					<img src='resource/images/${userModel.image }' width="150" height="150px" class="avatar img-circle" id="image" 
						alt="avatar">
						<input type="hidden" value="${userModel.image }" name="image"/>
    					</c:when>    
    				<c:otherwise>
        				<img src='resource/images/medium-default-avatar.png' width="150" height="150px"  class="avatar img-circle" id="image"
						alt="avatar">
						<h6>Upload a different photo...</h6>
    				</c:otherwise>
				</c:choose>
					
					<input type="file" class="form-control" id="file" name="file" accept="image/*"  onchange="showMyImage(this);">
				</div>
			</div>

			<!-- edit form column -->
			<div class="col-md-9 personal-info">
				<h3>Personal info</h3>
				
					<div class="form-group">
						<label class="col-lg-3 control-label">User Name:</label>
						<div class="col-lg-8">
							<label class="form-control" >${userModel.username }</label>
							<input class="form-control" type="hidden"  value="${userModel.username }" name="username">
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Phone:</label>
						<div class="col-lg-8">
							<form:input cssClass="form-control" placeholder="Phone" value="${userModel.phone }" name="phone" path="phone"/>
							<form:errors path="phone" cssClass="error" />
							
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-xs-3 control-label">Location</label>
						<div class="col-xs-5 selectContainer">
						<input type="hidden" id="locationhidden" value="${userModel.diadiem }"/>
							<select class="form-control" name="location" id="location">
								<option value="null">Choose your location</option>
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
		
		</form:form>
			</div>

	<hr>
</body>
</html>