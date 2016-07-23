<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="vi">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Place detail</title>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}

#listFood tr:first-child {
	font-weight: bold;
}
</style>
<link rel="stylesheet" href="resource/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/style.css">
<script type="text/javascript" src="resource/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resource/js/jssor.slider.mini.js"></script>
<script>
	jQuery(document).ready(function($) {
		var jssor_1_options = {
			$AutoPlay : true,
			$AutoPlaySteps : 4,
			$SlideDuration : 160,
			$SlideWidth : 200,
			$SlideSpacing : 3,
			$Cols : 4,
			$ArrowNavigatorOptions : {
				$Class : $JssorArrowNavigator$,
				$Steps : 1
			},
			$BulletNavigatorOptions : {
				$Class : $JssorBulletNavigator$,
				$SpacingX : 1,
				$SpacingY : 1
			}
		};

		var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

		//responsive code begin
		//you can remove responsive code if you don't want the slider scales while window resizing
		function ScaleSlider() {
			var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
			if (refSize) {
				refSize = Math.min(refSize, 809);
				jssor_1_slider.$ScaleWidth(refSize);
			} else {
				window.setTimeout(ScaleSlider, 30);
			}
		}
		ScaleSlider();
		$(window).bind("load", ScaleSlider);
		$(window).bind("resize", ScaleSlider);
		$(window).bind("orientationchange", ScaleSlider);
		//responsive code end
	});
</script>
</head>
<body>
	<section>
	<div class="container">
		<div class="row">
			<div id="cover">
				<div class="row">
					<div class="col-md-2">
						<div id="avatar">
							<!-- <img src="resource/images/logo1.png" width="100%" height="100%"/> -->
						</div>
					</div>
					<div class="col-md-3">
						<div class="row">
							<div id="name">
								<h3>Hoi An</h3>
								<h3>(Quang Nam)</h3>
							</div>
							<div id="rating">
								Rating: <img src="resource/images/star.png" width="30%">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<h3>About</h3>
			<div class="col-md-9">
				<div class="row">
					<div id="about">

						<p>Hoi An Town is an exceptionally well-preserved example of a
							Southeast Asian trading port dating from the 15th to the 19th
							century. Its buildings and its street plan reflect the
							influences, both indigenous and foreign, that have combined to
							produce this unique heritage site.</p>

						<p>Hoi An has no airport, and no train station either. The
							only way to get there is by road. You can hire a taxi from the
							neighbouring city of Da Nang, which does have an airport with
							daily flights from Hanoi, Ho Chi Minh City and other large
							Vietnamese cities. There’s also a train station in Da Nang, and
							bus services are plentiful. We have a wide selection of hotels
							for you to choose from in both Cua Dai Beach and Hoi An City,
							whatever suits your pocket and style and the selection is wide -
							from the five-star Palm Garden Resort Hoi An to simpler
							accommodation choices such as the Phuoc An Hotel.</p>
						<p>${Place.description}</p>
					</div>
					<table id=foodList border="1">
					<tr>
						<td>ID</td>
						<td>NAME</td>
						<td>LOCATION NAME</td>
					</tr>
					<c:forEach items="${list}" var="food">
						<tr>
							<td>${food.id}</td>
							<td>${food.name}</td>
							<td>${food.locationEntity.name}</td>
						</tr>
					</c:forEach>
					</table>
				</div>
				<h3>Images</h3>
				<div class="row">

					<div id="jssor_1" class="jssor1">
						<!-- Loading Screen -->
						<div data-u="loading"
							style="position: absolute; top: 0px; left: 0px;">
							<div
								style="filter: alpha(opacity = 70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
							<div
								style="position: absolute; display: block; background: url('images/loading.gif') no-repeat center center; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
						</div>
						<div data-u="slides"
							style="cursor: default; position: relative; top: 0px; left: 0px; width: 809px; height: 150px; overflow: hidden;">
							<div style="display: none;">
								<img data-u="image" src="resource/images/001.jpg" />
							</div>
							<div style="display: none;">
								<img data-u="image" src="resource/images/002.jpg" />
							</div>
							<div style="display: none;">
								<img data-u="image" src="resource/images/003.jpg" />
							</div>
							<div style="display: none;">
								<img data-u="image" src="resource/images/004.jpg" />
							</div>
							<div style="display: none;">
								<img data-u="image" src="resource/images/005.jpg" />
							</div>
						</div>
						<!-- Bullet Navigator -->
						<div data-u="navigator" class="jssorb03"
							style="bottom: 10px; right: 10px;">
							<!-- bullet navigator item prototype -->
							<div data-u="prototype" style="width: 21px; height: 21px;">
								<div data-u="numbertemplate"></div>
							</div>
						</div>
						<!-- Arrow Navigator -->
						<span data-u="arrowleft" class="jssora03l"
							style="top: 0px; left: 8px; width: 55px; height: 55px;"
							data-autocenter="2"></span> <span data-u="arrowright"
							class="jssora03r"
							style="top: 0px; right: 8px; width: 55px; height: 55px;"
							data-autocenter="2"></span>
					</div>

				</div>
			</div>
			<div class="col-md-3">
				<div class="food">
					<h3>Hotel</h3>
					<div class="row">

						<div class="item">
							<img src="resource/images/ks2.jpg" width="100%" height="100%">
						</div>
					</div>
					<div class="foodname">
						<a>Victoria Hoi An Beach Resort & Spa</a> </br> <img
							src="resource/images/star.png" width="30%">
					</div>
				</div>

				<div class="food">
					<div class="row">
						<div class="item">
							<img src="resource/images/ks1.jpg" width="100%" height="100%">
						</div>
					</div>
					<div class="foodname">
						<a>Hoi An Sunrise Beach</a> </br> <img src="resource/images/star.png"
							width="30%">
					</div>
					<br> <a>More >></a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-9">
				<div id="comment">
					<h3>Comment</h3>
					<div class="row">
						<div class="col-md-2">
							<div class="user">
								<img src="resource/images/user.jpg" width="50%" /> <br>
								<h5>User</h5>
							</div>
						</div>
						<div class="col-md-7">
							<div class="usercomment">
								<p>...................</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<div class="user">
								<img src="resource/images/user.jpg" width="50%" /> <br>
								<h5>User</h5>
							</div>
						</div>
						<div class="col-md-7">
							<div class="usercomment">
								<p>......................</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<div class="user">
								<img src="resource/images/user.jpg" width="50%" /> <br>
								<h5>User</h5>
							</div>
						</div>
						<div class="col-md-7">
							<div class="usercomment">
								<p>.......................</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">

				<div class="food">
					<h3>Food</h3>
					<div class="row">
						<div class="item">
							<img src="resource/images/my.jpg" width="100%" height="100%">
						</div>
					</div>
					<div class="foodname">
						<a>My Quang</a> </br> <img src="resource/images/heart-review.png"
							width="30%">
					</div>
				</div>
				<div class="food">
					<div class="row">
						<div class="item">
							<img src="resource/images/cau.jpg" width="100%" height="100%">
						</div>
					</div>
					<div class="foodname">
						<a>Cao lau</a> </br> <img src="resource/images/heart-review.png"
							width="30%">
					</div>
					<div class="foodname">
						<br> <a>More >></a>
					</div>
				</div>
			</div>

		</div>
		<div class="row">
			<h3>Map</h3>
			<iframe
				src="https://www.google.com/maps/d/u/0/embed?mid=1HmZytTJhZED_6NQF7G_4BwApDaA"
				width="100%" height="480"></iframe>
		</div>
	</div>
	</section>
</body>
</html>