<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="guru.tour.entity.PlaceEntity"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>locationPage</title>
<script src="resource/js/userSchedule.js"></script>



<script>
var ctx = "<%=request.getContextPath()%>"	
	$(document).ready(function() {

		if ($("#inlineCheckbox1").prop("checked") == true) {
			$("#diadiem").fadeIn();
		}
		if ($("#inlineCheckbox1").prop("checked") == true) {
			$("#thucan").fadeIn();
		}
		if ($("#inlineCheckbox1").prop("checked") == true) {
			$("#noio").fadeIn();
		}
		$("#btn1").click(function() {
			$("#hide1").fadeToggle("slow");
		});
		$("#btn2").click(function() {
			$("#hide2").fadeToggle("slow");
		});
		$("#btn3").click(function() {
			$("#hide3").fadeToggle("slow");
		});

		$("#inlineCheckbox1").click(function() {
			if ($("#inlineCheckbox1").prop("checked") == true) {
				$("#diadiem").fadeIn("slow");
			} else {
				$("#diadiem").fadeOut("slow");
			}
		});
		$("#inlineCheckbox2").click(function() {
			if ($(this).prop("checked") == true) {
				$("#thucan").fadeIn("slow");
			} else {
				$("#thucan").fadeOut("slow");
			}
		});
		$("#inlineCheckbox3").click(function() {
			if ($(this).prop("checked") == true) {
				$("#noio").fadeIn("slow");
			} else {
				$("#noio").fadeOut("slow");
			}
		});
	});
</script>


</head>
<body style="background-color: #d8d8d8;">

	<div class="container" style="padding-top: 10px;">
		<div class="row">
			<div class="col-md-10">
				<label class="checkbox-inline"> <input type="checkbox"
					id="inlineCheckbox1" value="option1" checked="checked">
					Place
				</label> <label class="checkbox-inline"> <input type="checkbox"
					id="inlineCheckbox2" value="option3" checked="checked">
					Food
				</label> <label class="checkbox-inline"> <input type="checkbox"
					id="inlineCheckbox3" value="option2" checked="checked">
					Hotlel
				</label>

			</div>
			<div class="col-md-2">
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="true">
						Sort by <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li><a href="#"></a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="diadiem" style="display: none">
			<h3>Place</h3>
			<h1>Result : ${places2.size()}</h1>

			<div class="row">
			<c:forEach var="placeEntity" items="${places2}">
				
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="resource/images/${placeEntity.images}"
								alt="${placeEntity.images}">
								<a>${placeEntity.id}</a>
						</div>
							
						<div style="text-align: center;">
							<div class="col-sm-4 col-sm-push-2">
								<button id="dislike" value="${placeEntity.id}">
									<span class="glyphicon glyphicon-thumbs-down"></span>
								</button>
							</div>
							<div class="col-sm-4 ">
								<button id="remind" value="${placeEntity.id}">
									
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
							</div>
							<div class="col-sm-4 col-sm-pull-2">
								<button id="like" class="like" value="${placeEntity.id}">
									<span class="glyphicon glyphicon-thumbs-up"></span>
								</button>
							</div>
						</div>
					</div>
					
				</c:forEach>
			</div>
			
			<div class="row" style="padding-top: 10px;">
				<div id="hide1" style="display: none">
					<div class="ss">
						<div class="col-sm-6 col-md-4">
							<div class="thumbnail">
								<img src="resource/images/danang.jpg" alt="...">
							</div>
							<div style="text-align: center;">
								<div class="col-sm-4 col-sm-push-2">
									<button>
										<span class="glyphicon glyphicon-thumbs-down"></span>
									</button>
								</div>
								<div class="col-sm-4 ">
									<button>
										<span class="glyphicon glyphicon-eye-open"></span>
									</button>
								</div>
								<div class="col-sm-4 col-sm-pull-2">
									<button>
										<span class="glyphicon glyphicon-thumbs-up"></span>
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="resource/images/danang.jpg" alt="...">
						</div>
						<div style="text-align: center;">
							<div class="col-sm-4 col-sm-push-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-down"></span>
								</button>
							</div>
							<div class="col-sm-4 ">
								<button>
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
							</div>
							<div class="col-sm-4 col-sm-pull-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-up"></span>
								</button>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="resource/images/danang.jpg" alt="...">
						</div>
						<div style="text-align: center;">
							<div class="col-sm-4 col-sm-push-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-down"></span>
								</button>
							</div>
							<div class="col-sm-4 ">
								<button>
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
							</div>
							<div class="col-sm-4 col-sm-pull-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-up"></span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row" style="padding-top: 10px;">
			<div class="col-md-10"></div>
			<div class="col-md-2">
				<button id="btn1">>> More</button>
			</div>
		</div>
	</div>
	<div id="thucan" style="display: none">
		<h3>Food</h3>
		<div class="row">

			<div>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="resource/images/gallery-img1.jpg" alt="...">
					</div>
					<div style="text-align: center;">
						<div class="col-sm-4 col-sm-push-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-down"></span>
							</button>
						</div>
						<div class="col-sm-4 ">
							<button>
								<span class="glyphicon glyphicon-eye-open"></span>
							</button>
						</div>
						<div class="col-sm-4 col-sm-pull-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-up"></span>
							</button>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="resource/images/gallery-img3.jpg" alt="...">
					</div>
					<div style="text-align: center;">
						<div class="col-sm-4 col-sm-push-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-down"></span>
							</button>
						</div>
						<div class="col-sm-4 ">
							<button>
								<span class="glyphicon glyphicon-eye-open"></span>
							</button>
						</div>
						<div class="col-sm-4 col-sm-pull-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-up"></span>
							</button>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="resource/images/gallery-img4.jpg" alt="...">
					</div>
					<div style="text-align: center;">
						<div class="col-sm-4 col-sm-push-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-down"></span>
							</button>
						</div>
						<div class="col-sm-4 ">
							<button>
								<span class="glyphicon glyphicon-eye-open"></span>
							</button>
						</div>
						<div class="col-sm-4 col-sm-pull-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-up"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row" style="padding-top: 10px;">
			<div id="hide2" style="display: none">
				<div class="ss">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="resource/images/gallery-img5.jpg" alt="...">
						</div>
						<div style="text-align: center;">
							<div class="col-sm-4 col-sm-push-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-down"></span>
								</button>
							</div>
							<div class="col-sm-4 ">
								<button>
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
							</div>
							<div class="col-sm-4 col-sm-pull-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-up"></span>
								</button>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="resource/images/my.jpg" alt="...">
						</div>
						<div style="text-align: center;">
							<div class="col-sm-4 col-sm-push-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-down"></span>
								</button>
							</div>
							<div class="col-sm-4 ">
								<button>
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
							</div>
							<div class="col-sm-4 col-sm-pull-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-up"></span>
								</button>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="resource/images/cau.jpg" alt="...">
						</div>
						<div style="text-align: center;">
							<div class="col-sm-4 col-sm-push-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-down"></span>
								</button>
							</div>
							<div class="col-sm-4 ">
								<button>
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
							</div>
							<div class="col-sm-4 col-sm-pull-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-up"></span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row" style="padding-top: 10px;">
			<div class="col-md-10"></div>
			<div class="col-md-2">
				<button id="btn2">>> More</button>
			</div>
		</div>
	</div>
	<div id="noio" style="display: none">
		<h3>Hotel</h3>
		<div class="row">
			<div>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="resource/images/g7.jpg" alt="...">
					</div>
					<div style="text-align: center;">
						<div class="col-sm-4 col-sm-push-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-down"></span>
							</button>
						</div>
						<div class="col-sm-4 ">
							<button>
								<span class="glyphicon glyphicon-eye-open"></span>
							</button>
						</div>
						<div class="col-sm-4 col-sm-pull-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-up"></span>
							</button>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="resource/images/hotel.jpg" alt="...">
					</div>
					<div style="text-align: center;">
						<div class="col-sm-4 col-sm-push-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-down"></span>
							</button>
						</div>
						<div class="col-sm-4 ">
							<button>
								<span class="glyphicon glyphicon-eye-open"></span>
							</button>
						</div>
						<div class="col-sm-4 col-sm-pull-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-up"></span>
							</button>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="resource/images/g7.jpg" alt="...">
					</div>
					<div style="text-align: center;">
						<div class="col-sm-4 col-sm-push-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-down"></span>
							</button>
						</div>
						<div class="col-sm-4 ">
							<button>
								<span class="glyphicon glyphicon-eye-open"></span>
							</button>
						</div>
						<div class="col-sm-4 col-sm-pull-2">
							<button>
								<span class="glyphicon glyphicon-thumbs-up"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row" style="padding-top: 10px;">
			<div id="hide3" style="display: none">
				<div class="ss">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="resource/images/2.jpg" alt="...">
						</div>
						<div style="text-align: center;">
							<div class="col-sm-4 col-sm-push-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-down"></span>
								</button>
							</div>
							<div class="col-sm-4 ">
								<button>
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
							</div>
							<div class="col-sm-4 col-sm-pull-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-up"></span>
								</button>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="resource/images/g7.jpg" alt="Huetravel">
						</div>
						<div style="text-align: center;">
							<div class="col-sm-4 col-sm-push-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-down"></span>
								</button>
							</div>
							<div class="col-sm-4 ">
								<button>
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
							</div>
							<div class="col-sm-4 col-sm-pull-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-up"></span>
								</button>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<img src="resource/images/g7.jpg" alt="...">
						</div>
						<div style="text-align: center;">
							<div class="col-sm-4 col-sm-push-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-down"></span>
								</button>
							</div>
							<div class="col-sm-4 ">
								<button>
									<span class="glyphicon glyphicon-eye-open"></span>
								</button>
							</div>
							<div class="col-sm-4 col-sm-pull-2">
								<button>
									<span class="glyphicon glyphicon-thumbs-up"></span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row" style="padding-top: 10px;">
			<div class="col-md-10"></div>
			<div class="col-md-2">
				<button id="btn3">>> More</button>
			</div>
		</div>
	</div>
	</div>
	</div>
</body>
</html>