<section ng-controller="customersCtrl">
	<div class="row">
		<div class="col-md-12 well">
			<div>
				<ul>
					<li ng-repeat="x in myData">{{ x.id+" "+x.name}}</li>
				</ul>
			</div>

			<script>
				var app = angular.module("myapp", []);
				  app.controller('customersCtrl', function($scope, $http) {
					 $http.get("http://localhost:8080/tour-phuot-web-prod/allPlace").then(function(response) {
						$scope.myData = response.data;
					}); 
				});  
			</script>
		</div>
</section>
