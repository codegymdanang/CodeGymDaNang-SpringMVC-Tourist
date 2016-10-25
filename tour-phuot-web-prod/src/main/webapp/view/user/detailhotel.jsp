<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="resource/css/service_hotel.css"
	type="text/css">
	<script src="resource/js/angular.min1.js"></script>
	<script  src="resource/js/angular-route.min.js">
	</script>
	<script src="resource/js/hotel.angular.js">
	</script>
<%-- <table border="1">
	<tr>
		<td>ID</td>
		<td>Name</td>

	</tr>
	<c:forEach items="${list}" var="location">
		<tr>
			<td>${location.id}</td>
			<c:forEach items="${location.ListHotel}" var="hotel">
			<td>${hotel.name}</td>
			</c:forEach>
			<td>${location.name}</td>
		</tr>
	</c:forEach>
	<c:forEach items="${list2}" var="hotel">
		<tr>
			<td>${hotel.hotelName}</td>
		</tr>
	</c:forEach>

</table> --%>
<body ng-app="App">
<div  ng-controller="TodoCtrl">
	<div ng-repeat="hotel in hotels">
		<form>
			<div class="box">
				<div class="boxinner">
					<div class="col-md-3">
						<image src="resource/images/hotel.jpg" width="150px"
							height="150px">
					</div>
					<div class="col-md-6">
						<p>{{hotel.name }}</p>
						<p>{{hotel.price} }</p>
						<p>{{hotel.description }}</p>
						<p>{{hotel.location.locationName }}</p>
					</div>
					<div class="col-md-3 ">
						<div class="buttoninner">
							<button type="button" class="btn btn-warning">View
								Details</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
	 