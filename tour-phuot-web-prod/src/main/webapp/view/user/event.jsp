<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi-VN">
<head>
<meta charset="utf-8">
<title>event</title>
<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="resource/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resource/css/jquery.rateyo.css">
<link rel="stylesheet" type="text/css" href="resource/css/event.css">
</head>
<body>
	<div class="container">
		<div id="wrapper">
			<div class="header">
				<h2>EVENT</h2>
			</div>
			<hr>
			<div class="content">
				<div class="row">
					<div class="col-md-3">
						<img class="event_icon" src="resource/images/event_icon.png">
					</div>
					<div class="col-md-9">
						<div class="row">
							<div class="col-sm-12 wrap-infor">
								<div class="col-md-3">
									<img class="image_day" src="resource/images/august_icon.png">
								</div>
								<div class="col-md-9">
									Da Nang’s coastline stretches 30 kilometres, renowned for
									pristine beautiful beaches with white sand, crystal-clear blue
									water and also popular for fishing, water-skiing, diving, and
									yachting. According to US Forbes Magazine, Da Nang is selected
									as one of the 6 most beautiful beaches in the world by its
									idyllic beach with smooth sand and a gentle slope. In addition,
									the green environment, less pollution, and traffic restriction
									of Da Nang got it listed as a first class city, and has a
									higher urbanization ratio than any of Vietnam’s other
									provinces. It is considered to be the most worth-living city in
									Vietnam.
									<div class="row" id="rate_and_share">
										<div class="col-md-6">
											Rating:
											<div class="rateYo"></div>
										</div>
										<div class="col-md-6">
											<img src="resource/images/faceshare_icon_03.png" alt="" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 wrap-infor">
								<div class="col-md-3">
									<img class="image_day" src="resource/images/august_icon.png">
								</div>
								<div class="col-md-9">
									Time: 7AM, 06.08.2016. Location: Bien Dong park, Vo Nguyen Giap
									Str., Son Tra Dist. Registration Fee: 50.000 VND/ person (BIB
									number) Registration fee: 200.000 VND/person (BIB number +
									running t-shirt)
									<div class="row" id="rate_and_share_run">
										<div class="col-md-6">
											Rating:
											<div class="rateYo"></div>
										</div>
										<div class="col-md-6">
											<img src="resource/images/faceshare_icon_03.png" alt="" />
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<sf:form action="show" method="GET">
		<table border="1">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Description</td>
				<td>Startday</td>
				<td>Endday</td>
			</tr>
			<c:forEach items="${list}" var="event">
				<tr>
					<td>${event.id}</td>
					<td>${event.name}</td>
					<td>${event.description}</td>
					<td>${event.startday}</td>
					<td>${event.endday}</td>
				</tr>
			</c:forEach>
		</table>
	</sf:form>


	<script>
		$(function() {
			
			$(".rateYo").rateYo({
				rating : 3.6
			});
		});
	</script>
</body>
</html>
