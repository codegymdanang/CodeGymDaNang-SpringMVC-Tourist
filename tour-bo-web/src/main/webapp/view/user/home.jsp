<section ng-controller="controller1">
	<div class="row">
		<div class="col-md-12 well">
		<div>
     		<h1>xin chao {{data.user}}</h1>
     	</div>
     
     	<script>
     		angular.module("appLong",[]).controller("controller1",function($scope){
     			$scope.data = {
                 user : 'con cho quoc'
             	};
     		});
     	</script>
	</div>
</section>
