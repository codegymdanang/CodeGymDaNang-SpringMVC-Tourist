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
	<script type="text/javascript" language="javascript">
	$(document).ready(function() {
		var ctx = "<%=request.getContextPath()%>"
         $.ajax( {
                 url:ctx+'/view/user/user_overview.jsp',
                 success:function(data) {
                    $('#content').html(data);
                 }
              });
         
         $("#overview").click(function(event){
        	 $.ajax( {
        	 url:ctx+'/view/user/user_overview.jsp',
             success:function(data) {
                $('#content').html(data);
             }
        	 });
             });
         
        $("#account").click(function(event){
            $.ajax( {
                url:ctx+'/view/user/userdetails.jsp',
                success:function(data) {
                   $('#content').html(data);
                }
             });
         });

        
        });

    
	

	</script>
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
				<div class="profile-usertitle">
					<div class="profile-usertitle-name">
						${user.username }
					</div>
					<div class="profile-usertitle-job">
						HOST
					</div>
				</div>
				<div class="profile-userbuttons">
					<button type="button" class="btn btn-success btn-sm">Follow</button>
					<button type="button" class="btn btn-danger btn-sm">Message</button>
				</div>
				<div class="profile-usermenu">
					<ul class="nav">
						<li class="active">
							<a href="#" id="overview">
							<i class="glyphicon glyphicon-home"></i>
							Overview </a>
						</li>
						<li>
							<a href="#" id="account">
							<i class="glyphicon glyphicon-user"></i>
							Account Settings </a>
						</li>
						<li>
							<a href="#" id="help">
							<i class="glyphicon glyphicon-flag"></i>
							Help </a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<input type="hidden" id="hiddenphone" value="${user.phone }">
		<input type="hidden" id="hiddendiadiem" value="${user.diadiem }">
		<div class="col-sm-9" id="content">
            
    </div>
            </div>
		</div>
	</form>
</body>
</html>