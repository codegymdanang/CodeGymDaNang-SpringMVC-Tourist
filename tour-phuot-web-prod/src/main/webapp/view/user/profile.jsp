<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi-VN">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="resource/css/service_host.css"
	type="text/css">
</head>
<body>
	<c:forEach items="${list}" var="host">
		<div class="row activity">
			<div class="col-md-8">
				<div class="col-md-3">
					<a href="detail_profile"><img src="resource/images/p5.jpg"></a>
					<a href="detail_profile"><p>BNQ</p></a>
				</div>
				<div class="col-md-9">
					<div>
						<h1>${host.title}</h1>
					</div>
					<div>
						<p>Party all night long till 6 a.m</p>
					</div>
					<div>
						<p>${host.serviceHostEntity.name}</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="share">
					SHARE THIS ACTIVITY <br> <a href="https://www.facebook.com/"
						target="_blank"><img class="face"
						src="resource/images/facebook.png"></a> <a
						href="https://mail.google.com" target="_blank"> <img
						class="face" src="resource/images/gmail.png"></a>
				</div>
			</div>
		</div>

		<hr>
		<div class="row about-activity">
			<div class="col-md-8">
				<h2>About Activity</h2>
				<hr>
				<div id="step3">
					<div class="col-md-2">
						<h3>Summary</h3>
					</div>
					<div class="col-md-10">
						<div class="summary">
							<p>${host.summary}</p>
							<hr>
							<div class="reviews">
								<h2>Activity Reviews</h2>
								<hr />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<h3 class="center">BOOKING</h3>
				<hr />
				<div class="row detail">
					<div class="col-xs-5 col-xs-5 col-md-5 col-md-5">Price:</div>
					<div class="col-md-7">${host.price}</div>
					<div class="col-xs-5 col-xs-5 col-md-5 col-md-5">Place:</div>
					<div class="col-md-7">${host.serviceHostEntity.name}</div>
					<div class="col-xs-5 col-xs-5 col-md-5 col-md-5">Duration:</div>
					<div class="col-md-7">${host.duration}</div>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>