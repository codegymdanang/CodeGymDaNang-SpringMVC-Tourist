<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<<<<<<< HEAD
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootstrap 101 Template</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="resource/css/Home.css">
</head>
<body>
	<div id="wrapper">
		<tiles:insertAttribute name="nav" />
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row show-grid">
					<tiles:insertAttribute name="aside" />
					<!-- <div id="page-wrapper"> -->
					<div class="col-md-10">
						<tiles:insertAttribute name="header" />
						<tiles:insertAttribute name="body" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="resource/js/bootstrap.min.js"></script>
</body>
=======

<html>
<head>
<title>Guru</title>
<!-- <link href="resource/css/timeline.css" rel="stylesheet">
	<link href="resource/css/sb-admin-2.css" rel="stylesheet">
	<link href="resource/css/morris.css" rel="stylesheet">
	 <link href="resource/css/font-awesome.min.css" rel="stylesheet" type="text/css">
 -->
<link rel="stylesheet" href="resource/css/style.css">
<link href="resource/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
	<div id="wrapper">
		<aside>
			<tiles:insertAttribute name="aside" />
		</aside>
		<header>
			<tiles:insertAttribute name="header" />
		</header>
		<div id="content">
			<nav>
				<tiles:insertAttribute name="nav" />
			</nav>
			<article>
				<tiles:insertAttribute name="body" />
			</article>
		</div>
	</div>
</body>
<script src="resource/js/jquery.js"></script>
<script src="resource/js/price-range.js"></script>
<script src="resource/js/bootstrap.min.js"></script>
<script src="resource/js/jquery.scrollUp.min.js"></script>
<script src="resource/js/search.js"></script>
>>>>>>> branch 'master' of https://github.com/levunguyen/touristinvietnam
</html>