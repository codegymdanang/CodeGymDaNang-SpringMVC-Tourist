<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

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
</html>