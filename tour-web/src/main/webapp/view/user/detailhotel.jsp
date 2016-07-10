<<<<<<< HEAD
<div class="col-md-7">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide" src="resource/images/Danangcity.jpg"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>10 Best Attractions in Da Nang.</h1>
						<p>The best attractions in Da Nang are a good mix of
							centuries-old pagodas, French colonial buildings, as well as
							tranquil beaches with clear blue waters, and verdant national
							parks.</p>
						<p>
							<a class="btn btn-lg btn-primary"
								href="http://www.vietnam-guide.com/da-nang/top10/top10-da-nang-attractions.htm?cur=USD"
								role="button">Sign up today</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide" src="resource/images/Hoiancity.jpg"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Hoi An Travel Guide.</h1>
						<p>Ancient and peaceful, Hoi An is one of the most popular
							destinations in Vietnam that caters to travellers of all tastes
							and across the continents.</p>
						<p>
							<a class="btn btn-lg btn-primary"
								href="http://www.vietnamonline.com/destination/hoi-an.html"
								role="button">Learn more</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide" src="resource/images/Nhatrangcity.jpg"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Hanoi announces master plan of Thang Long Citadel relic
							site.</h1>
						<p>Hanoi’s People’s Committee on Wednesday announced a
							master plan of Thang Long Citadel relic site.</p>
						<p>
							<a class="btn btn-lg btn-primary"
								href="http://vovworld.vn/en-US/News/Hanoi-announces-master-plan-of-Thang-Long-Citadel-relic-site/98986.vov"
								role="button">Browse gallery</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</div>
<div class="col-md-7"></div>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="UTF-8"%>
 

    <table border="1">
    <tr>
        <td>ID</td>
        <td> Name</td>
        <td>Price</td>
        <td>description</td>
        
      </tr>
    <c:forEach items="${list}" var="hotel">    
      <tr>
        <td>${hotel.id}</td>
        <td>${hotel.name}</td>
        <td>${hotel.price}</td>
        <td>${hotel.description}</td>
      </tr>
    </c:forEach>
    </table>
>>>>>>> branch 'master' of https://github.com/levunguyen/touristinvietnam
