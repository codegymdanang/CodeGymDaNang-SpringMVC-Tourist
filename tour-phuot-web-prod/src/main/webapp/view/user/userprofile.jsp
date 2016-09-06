<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User ProfileInsert title here</title>


<script src="resource/js/jquery-1.11.1.min.js"></script>
<script src="resource/js/bootstrap.js"></script>
<link rel="stylesheet" href="resource/css/userprofile.css"
	type="text/css">

</head>
<body>
<form  action="userprofile" method="post" >
	<div class="container">
    <div class="row profile">
		<div class="col-md-3">
			<div class="profile-sidebar">
				<!-- SIDEBAR USERPIC -->
				<div class="profile-userpic">
					<c:choose>
    					<c:when  test="${not empty user.image }">
    					<img src='resource/images/${user.image }' width="150" height="150px" class="avatar img-circle"
						alt="avatar">
    					</c:when>    
    				<c:otherwise>
        				<img src='resource/images/medium-default-avatar.png' width="150" height="150px" class="avatar img-circle"
						alt="avatar">
    				</c:otherwise>
				</c:choose>

				</div>
				<!-- END SIDEBAR USERPIC -->
				<!-- SIDEBAR USER TITLE -->
				<div class="profile-usertitle">
					<div class="profile-usertitle-name">
						${user.username }
					</div>
					<div class="profile-usertitle-job">
						HOST
					</div>
				</div>
				<!-- END SIDEBAR USER TITLE -->
				<!-- SIDEBAR BUTTONS -->
				<div class="profile-userbuttons">
					<button type="button" class="btn btn-success btn-sm">Follow</button>
					<button type="button" class="btn btn-danger btn-sm">Message</button>
				</div>
				<!-- END SIDEBAR BUTTONS -->
				<!-- SIDEBAR MENU -->
				<div class="profile-usermenu">
					<ul class="nav">
						<li class="active">
							<a href="#">
							<i class="glyphicon glyphicon-home"></i>
							Overview </a>
						</li>
						<li>
							<a href="#">
							<i class="glyphicon glyphicon-user"></i>
							Account Settings </a>
						</li>
						<li>
							<a href="#">
							<i class="glyphicon glyphicon-flag"></i>
							Help </a>
						</li>
					</ul>
				</div>
				<!-- END MENU -->
			</div>
		</div>
		<div class="col-sm-9">
            <div class="profile-content-center">
      <div class="row">
     
          <div class="panel panel-info">
            <div class="panel-body">
              <div class="row">
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Date of Birth</td>
                        <td>01/24/1995</td>
                      </tr>
                   
                         <tr>
                             <tr>
                        <td>Gender</td>
                        <td>Male</td>
                      </tr>
                        <tr>
                        <td> Address</td>
                        <td>${user.diadiem }</td>
                      </tr>
                      <tr>
                        <td>Email</td>
                        <td><a href="mailto:info@support.com">info@support.com</a></td>
                      </tr>
                      <tr>
                        <td>Phone Number</td>
                        <td>123-4567-890(Landline)<br><br>${user.phone }(Mobile)
                        </td>
                           
                      </tr>
                     
                    </tbody>
                  </table>
                  
                  <a href="<%=request.getContextPath()%>/updateprofile" class="btn btn-primary">Update Profile</a> &nbsp;             
					                  
                  <a href="<%=request.getContextPath()%>/changepassword" class="btn btn-primary">Change Password</a>
                </div>
              </div>
            </div>
            
          </div>
        </div>
      </div>
    </div>
            </div>
		</div>
	</form>
</body>
</html>