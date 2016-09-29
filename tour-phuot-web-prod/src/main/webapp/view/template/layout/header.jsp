<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- banner -->
<div class="banner about-bg">
	<div class="top-banner about-top-banner">
		<div class="container">
			<div class="top-banner-left">
				<ul>
					<li><i class="fa fa-phone" aria-hidden="true"></i> +1 234 567
						8901</li>
					<li><a href="mailto:example@email.com"><i
							class="fa fa-envelope" aria-hidden="true"></i> phuot@gmail.com</a></li>
				</ul>
			</div>
			<div class="top-banner-right">
				<ul>
					<li><a class="btn btn-link" href="login" role="button"> <!-- Trigger/Open The Modal -->
							<button id="myBtnOfLogin" >LOGIN</button>
						</a>
					</li>
					<li><a class="facebook"
						href="https://www.facebook.com/groups/1722588871302570/"><i
							class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a class="facebook" href="#"><i class="fa fa-twitter"
							aria-hidden="true"></i></a></li>
					<li><a class="facebook" href="#"><i class="fa fa-dribbble"
							aria-hidden="true"></i></a></li>
					<li><a class="facebook" href="#"><i
							class="fa fa-google-plus" aria-hidden="true"></i></a></li>
							<c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><div class="dropdown">
  								<button class="dropbtn">Account</button>
  								<div class="dropdown-content">
							    <a href="<%=request.getContextPath()%>/userprofile">Account Settings</a>
							    <a href="<c:url value="/logout" />" > Log Out</a>
							  </div>
					</div></li>
					</c:if>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="header">
		<div class="container">
			<div class="logo">
				<h1>
					<a href="home">My Trip</a>
				</h1>
			</div>
			<div class="top-nav">
				<nav class="navbar navbar-default">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">Menu
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="home">Home</a></li>
							<li><a href="about">About</a></li>
							<li><a class="active" href="services">Services</a></li>
							<li><a href="codes">New&Event</a></li>
							<li><a href="gallery">Gallery</a></li>
							<li><a href="contact">Contact</a></li>
						</ul>
					</div>
				</nav>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- //banner -->


<%-- <jsp:include page="../../user/form-login.jsp"></jsp:include> --%>