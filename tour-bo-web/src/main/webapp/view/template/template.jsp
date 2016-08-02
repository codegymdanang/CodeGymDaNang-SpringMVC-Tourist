
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootstrap 101 Template</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="resource/css/Home.css">
<link rel="stylesheet" href="resource/js/angular.min.js">
</head>
<body>
	<div id="wrapper" ng-app="myApp">
	<div ng-controller="PeopleCtrl">
		<tiles:insertAttribute name="navbar" />
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
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="resource/js/bootstrap.min.js"></script>
</body>

