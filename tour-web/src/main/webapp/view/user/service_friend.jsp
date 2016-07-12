<head>
<link rel="stylesheet" href="resource/css/service_friend.css"
	type="text/css">
</head>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <span class="glyphicon glyphicon-user" style="font-size: 100px"></span>
                <p><a href="#" class="a">Avatar</a></p><br>
                <p class="border" style="box-shadow:10px 5px 2px #888888 ">Rating
                    <span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
                    <span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
                    <span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
                    <span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
                    <span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
                </p>
                <p><a href="#" class="a">Wall</a></p>
                <p><a href="#" class="a">Information</a></p>
                <p><a href="#" class="a">Friends</a></p>
            </div>
             <div class="col-md-9">
                <div class="row">                
                    <div class="col-md-12">
                            <form class="form-horizontal" method="post" action="findfriends" >
                                <div class="form-group">
                                	<div class="col-md-2">
		                                <select class="form-control" id="search" name="search">
		                                    <option>Name</option>
		                                    <option>Age</option>
		                                    <option>Favorites</option>
		                                    <option>Phone</option>
		                                </select>
	                                </div>
	                                <div class="col-md-8">
	                                    <input type="text" class="form-control" name="name" id="name" placeholder="Input here">                                   
	                                </div>
	                                <div class="col-md-2">
	                                	<button id="search_friends" type="submit" class="btn btn-default"><span class="glyphicon glyphicon-zoom-in"></span></button>
	                                </div>
                                </div>
                            </form>
                    </div>
                    <!--<div class="col-md-4">-->
                    <!--</div>-->
                </div>
                <hr class="distance">
                <div class="row">
                    <div class="col-md-3">
                        <span class="glyphicon glyphicon-user" style="font-size: 100px"></span>
                        <p>Rating
                            <span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
                            <span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
                            <span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
                            <span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
                            <span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
                        </p>
                    </div>
                    <div class="col-md-5">
                        <table class="table table-hover">
                            <tr>
                                <th>
                                    Name
                                </th>
                                <th>
                                    Age
                                </th>
                                <th>
                                    Favorites
                                </th>
                                <th>
                                    Phone
                                </th>
                            </tr>
                            <tr>
                                <td>
                                    Lorem ipsum dolor sit amet.
                                </td>
                                <td>
                                    Lorem ipsum dolor sit amet.
                                </td>
                                <td>
                                    Lorem ipsum dolor sit amet.
                                </td>
                                <td>
                                    Lorem ipsum dolor sit amet.
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="col-md-4">
                        <a class="btn btn-success btn-responsive" href="#" style="box-shadow:10px 5px 2px #008B00 ">Follow</a><br><br>
                        <a class="btn btn-danger btn-responsive" href="#" style="box-shadow:10px 5px 2px #FF6347 ">Report</a>
                    </div>
                </div>
                <img src="resource/images/map.png" class="img-responsive">          
            </div>
        </div>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<span class="glyphicon glyphicon-user" style="font-size: 100px"></span>
			<p>
				<a href="#" class="a">Avatar</a>
			</p>
			<br>
			<p class="border" style="box-shadow: 10px 5px 2px #888888">
				Rating <span class="glyphicon glyphicon-star"
					style="font-size: 10px"></span> <span
					class="glyphicon glyphicon-star" style="font-size: 10px"></span> <span
					class="glyphicon glyphicon-star" style="font-size: 10px"></span> <span
					class="glyphicon glyphicon-star" style="font-size: 10px"></span> <span
					class="glyphicon glyphicon-star" style="font-size: 10px"></span>
			</p>
			<p>
				<a href="#" class="a">Wall</a>
			</p>
			<p>
				<a href="#" class="a">Information</a>
			</p>
			<p>
				<a href="#" class="a">Friends</a>
			</p>
		</div>
		<div class="col-md-9">
			<div class="row">
				<div class="col-md-3">
					<form role="form">
						<div class="form-group">
							<select class="form-control" id="search" name="search">
								<option>Name</option>
								<option>Age</option>
								<option>Favorites</option>
								<option>Phone</option>
							</select>
						</div>
					</form>


				</div>
				<div class="col-md-9">
					<form class="form-horizontal">
						<div class="form-group">
							<div class="col-md-10">
								<input type="text" class="form-control" name="name" id="name"
									placeholder="Input here">
							</div>
							<button id="search_friends" type="submit" class="btn btn-default">
								<span class="glyphicon glyphicon-zoom-in"></span>
							</button>
						</div>
					</form>
				</div>
				<!--<div class="col-md-4">-->
				<!--</div>-->
			</div>
			<hr class="distance">
			<div class="row">
				<div class="col-md-3">
					<span class="glyphicon glyphicon-user" style="font-size: 100px"></span>
					<p>
						Rating <span class="glyphicon glyphicon-star"
							style="font-size: 10px"></span> <span
							class="glyphicon glyphicon-star" style="font-size: 10px"></span>
						<span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
						<span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
						<span class="glyphicon glyphicon-star" style="font-size: 10px"></span>
					</p>
				</div>
				<div class="col-md-5">
					<table class="table table-hover">
						<tr>
							<th>Name</th>
							<th>Age</th>
							<th>Favorites</th>
							<th>Phone</th>
						</tr>
						<tr>
							<td>Lorem ipsum dolor sit amet.</td>
							<td>Lorem ipsum dolor sit amet.</td>
							<td>Lorem ipsum dolor sit amet.</td>
							<td>Lorem ipsum dolor sit amet.</td>
						</tr>
					</table>
				</div>
				<div class="col-md-4">
					<a class="btn btn-success btn-responsive" href="#"
						style="box-shadow: 10px 5px 2px #008B00">Follow</a><br>
					<br> <a class="btn btn-danger btn-responsive" href="#"
						style="box-shadow: 10px 5px 2px #FF6347">Report</a>
				</div>
			</div>
			<img src="resource/images/map.png" class="img-responsive">
		</div>
	</div>


</div>
<!-- 
</body>
</html> -->