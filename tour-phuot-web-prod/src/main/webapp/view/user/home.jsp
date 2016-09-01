
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<link href="resource/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />

<link rel="stylesheet" href="resource/css/style.css" type="text/css" media="all" />

<link rel="stylesheet" href="resource/css/ken-burns.css">

<link href="resource/css/font-awesome.css" rel="stylesheet"> 

<link href='//fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>


<script src="resource/js/bootstrap.js"></script>
<script src="resource/js/homeAjax.js"></script>
<script type = "text/javascript" language = "javascript">
     var ctx = "<%=request.getContextPath()%>"
      $(function() {
    	  var location =[];
            $.getJSON(ctx+'/allLocation', function(data) {
            	$.each(data, function(index) {
            		location.push(data[index].name);
                 });
            	
            });
            $("#tags").autocomplete({
        		source:location
        	}); 
/*             $("#search").click(function(){
                alert(location)
            }); */
       });
</script>
</head>
<body>
	<div id="kb" class="carousel kb_elastic animate_text kb_wrapper" data-ride="carousel" data-interval="6000" data-pause="hover">
            <!-- Wrapper for Slides -->
            <div class="carousel-inner" role="listbox">
                <!-- First Slide -->
                <div class="item active">
					<div class="slider">
						<div class="carousel-caption kb_caption slider-grid">
							<h3>Singapore</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
						</div>
					</div>
                </div>

                <!-- Second Slide -->
                <div class="item">
					<div class="slider slider1">
						<div class="carousel-caption kb_caption kb_caption_right slider-grid">
							<h3>Hawaii</h3>
							<p>Vivamus vel nulla venenatis, tincidunt mi vel, consequat erat.</p>
						</div>
					</div>
                </div>

                <!-- Third Slide -->
                <div class="item">
					<div class="slider slider2">
						<div class="carousel-caption kb_caption kb_caption_center slider-grid">
						   <h3>Hong Kong</h3>
							<p>Nunc turpis purus, vestibulum at quam ac, feugiat dignissim nunc</p>
						</div>
					</div>
                </div>

            </div>
            <!-- Navigation Buttons -->
            <!-- Left Button -->
            <a class="left carousel-control kb_control_left" href="#kb" role="button" data-slide="prev">
                <span class="fa fa-angle-left kb_icons" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <!-- Right Button -->
            <a class="right carousel-control kb_control_right" href="#kb" role="button" data-slide="next">
                <span class="fa fa-angle-right kb_icons" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
    </div> 
    
    
    <!-- try -->
    <div id="searchbar">
	<div class="container">
		<div class="row">		
			<form action="searchLocation" >
				<div class="form-group col-xs-12 col-sm-5 col-sm-offset-2">
					<label for="" class="sr-only">Search</label>
					<input type="text" class="form-control input-lg" id ="tags" placeholder="Enter your location" name="locationName">		
				</div>		

				<div class="form-group col-xs-12 col-sm-3">
					<button  type="submit" id="search"class="btn btn-success btn-lg btn-block">Search</button>
				</div>
			</form>								
		</div>
		</div>
	</div> <!-- feature4 -->
	<!-- try -->	
	<!-- about -->
	<div class="about">
		<div class="container">
			<div class="w3l-about-heading">
				<h2>Top Tours</h2>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras porta efficitur ante quis volutpat.</P>
			</div>
			<div class="about-grids">
				<div class="col-md-3 about-grid">
					<div class="about-grid-info effect-1">
						<h4>San Francisco</h4>
					</div>
				</div>
				<div class="col-md-3 about-grid">
					<div class="about-grid-info about-grid-info1 effect-1">
						<h4>Maldives</h4>
					</div>
				</div>
				<div class="col-md-3 about-grid">
					<div class="about-grid-info about-grid-info2 effect-1">
						<h4>Ireland</h4>
					</div>
				</div>
				<div class="col-md-3 about-grid">
					<div class="about-grid-info about-grid-info3 effect-1">
						<h4>New Zealand</h4>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- //about -->
	<!-- offer -->
	<div class="offer">
		<div class="container">
			<div class="wthree-offer-grid">
				<h4>Today Best offers</h4>
				<p>Sed vitae purus ut libero malesuada molestie imperdiet a nibh. Etiam consectetur odio a massa vulputate porttitor. Quisque nibh orci, vestibulum sed gravida vel, eleifend nec libero. </p>
				<div class="click-button">
					<a href="single.html">Click Here</a>
				</div>
			</div>
		</div>
	</div>
	<!-- //offer -->
	<!-- news -->
	<div class="news">
		<div class="container">
			<div class="news-heading">
				<h3>News & Events</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras porta efficitur ante quis volutpat.</p>
			</div>
			<div class="news-grids">
				<div class="col-md-4 news-grid">
					<div class="agile-news-grid-info">
						<div class="news-grid-info-img">
							<a href="single.html"><img src="resource/images/n1.jpg" alt="" /></a>
						</div>
						<div class="news-grid-info-bottom">
							<div class="date-grid">
								<div class="admin">
									<a href="#"><i class="fa fa-user" aria-hidden="true"></i> Admin</a>
								</div>
								<div class="time">
									<p><i class="fa fa-calendar" aria-hidden="true"></i> May 09,2016</p>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="news-grid-info-bottom-text">
								<a href="single.html">Quisque gravida, nunc eu interdum porta</a>
								<p>Aliquam erat volutpat. Duis vulputate tempus laoreet. Integer viverra eleifend neque, eget dictum lectus. Quisque eu tempor dolor.</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 news-grid">
					<div class="agile-news-grid-info">
						<div class="news-grid-info-img">
							<a href="single.html"><img src="resource/images/n2.jpg" alt="" /></a>
						</div>
						<div class="news-grid-info-bottom">
							<div class="date-grid">
								<div class="admin">
									<a href="#"><i class="fa fa-user" aria-hidden="true"></i> Admin</a>
								</div>
								<div class="time">
									<p><i class="fa fa-calendar" aria-hidden="true"></i> May 09,2016</p>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="news-grid-info-bottom-text">
								<a href="single.html">Quisque gravida, nunc eu interdum porta</a>
								<p>Aliquam erat volutpat. Duis vulputate tempus laoreet. Integer viverra eleifend neque, eget dictum lectus. Quisque eu tempor dolor.</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 news-grid">
					<div class="agile-news-grid-info">
						<div class="news-grid-info-img">
							<a href="single.html"><img src="resource/images/n3.jpg" alt="" /></a>
						</div>
						<div class="news-grid-info-bottom">
							<div class="date-grid">
								<div class="admin">
									<a href="#"><i class="fa fa-user" aria-hidden="true"></i> Admin</a>
								</div>
								<div class="time">
									<p><i class="fa fa-calendar" aria-hidden="true"></i> May 09,2016</p>
								</div>
								<div class="clearfix"> </div>
							</div>
							<div class="news-grid-info-bottom-text">
								<a href="single.html">Quisque gravida, nunc eu interdum porta</a>
								<p>Aliquam erat volutpat. Duis vulputate tempus laoreet. Integer viverra eleifend neque, eget dictum lectus. Quisque eu tempor dolor.</p>
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- //news -->
	
	<script src="resource/js/SmoothScroll.min.js"></script>
</body>	

</html>