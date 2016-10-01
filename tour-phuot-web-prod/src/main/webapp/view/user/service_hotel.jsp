<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="vi">
<head>
<title>Service Hotel</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resource/css/service_hotel.css"
	type="text/css">
	
		
     <script type = "text/javascript" language = "javascript">
     var ctx = "<%=request.getContextPath()%>"
    	 var list2;
	 var list;
     var row;
      $(document).ready(function() {
         
          $.ajax( {
              url: ctx+'/hoteldata/all',
              success:function(data) {
            	  list=data;
            	  $.each(data, function( index, value ) {
                    row = $("<form><div class='box'><div class='boxinner'><div class='col-md-3'><image src='resource/images/hotel.jpg' width='150px' height='150px'></div><div class='col-md-6'><p>"+value.hotelName+"</p><p>"+value.price+"</p><p>"+value.description+"</p><p>"+value.location.locationName+"</p></div><div class='col-md-3'><div class='buttoninner'><button type='button' class='btn btn-warning'>ViewDetails</button></div></div></div></div></form>"); 
                     $("#myData").append(row);
                 });
              },
              async: true
           });
			
    	  $('input[type=radio][name=g-radio]').change(function() {
    		$("#myData").html(""); 
    		list2=$.extend([], list);
    		if (this.value == 'A') {//100000
    			
	        	for (i = 0; i < list2.length; i++) { 
	        	    if(list2[i].price <=100000)
	        	    	list2.splice( i, 1 );
	        	}
	        }
	        else if (this.value == 'B') {
    	        	for (i = 0; i < list2.length; i++) { 
    	        	    if(list2[i].price <=150000)
    	        	    	list2.splice( i, 1 );
    	        	}
    	        }
	         else if (this.value == 'C') {
    	        	for (i = 0; i < list2.length; i++) { 
    	        	    if(list2[i].price >200000)
    	        	    	list2.splice( i, 1 );
    	        	}
    	        }
	        
	        $.each(list2, function( index, value ) {
	        	row = $("<form><div class='box'><div class='boxinner'><div class='col-md-3'><image src='resource/images/hotel.jpg' width='150px' height='150px'></div><div class='col-md-6'><p>"+value.hotelName+"</p><p>"+value.price+"</p><p>"+value.description+"</p><p>"+value.location.locationName+"</p></div><div class='col-md-3'><div class='buttoninner'><button type='button' class='btn btn-warning'>ViewDetails</button></div></div></div></div></form>");
                  $("#myData").append(row);
               });
	        
    	    });
    	  
       });

      </script>
	
</head>
<body>
	<div class="mycontainer">
		<div id="container">
			<div class="col-md-1"></div>
			<div class="menuinner">
				<div class="menuininer">
					<div class="col-md-2">
						<ul class="list-group ">
							<!-- affix -->
							<li class="list-group-item">
								<h4>Filter by Name</h4> <input type="text"
								placeholder="Hotel or Motel" style="width: 164px;">
							</li>
							<li class="list-group-item">
								<h4>Choose Price</h4>
								<div class="radio">
									<label><input type="radio" value="A" name="g-radio">>100000</label>
								</div>
								<div class="radio">
									<label><input type="radio" value="B" name="g-radio">100000-200000</label>
								</div>
								<div class="radio ">
									<label><input type="radio" value="C" name="g-radio">200000-300000
									</label>
								</div>
							</li>
							<li class="list-group-item">
								<h4>Stars</h4>
								<button type="button5" class="btn btn-default">
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</button>
								<br>
								<button type="button4" class="btn btn-default">
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>

								</button>
								<br>
								<button type="button3" class="btn btn-default ">
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>

								</button>
								<br>
								<button type="button2" class="btn btn-default ">
									<span class="glyphicon glyphicon-star " aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>

								</button>
								<br>
								<button type="button1" class="btn btn-default">
									<span class="glyphicon glyphicon-star " aria-hidden="true"></span>

								</button>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="col-md-8">
				<div class="boxHeader">
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Recommend <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Most Choose</a></li>
									<li><a href="#">Best Price</a></li>
								</ul></li>
							<li class="active"><a href="#">Star <span
									class="sr-only">(current)</span></a></li>
							<li><a href="#">Price</a></li>

						</ul>

					</div>
				</div>
				<span id="myData">
				
				</span>
			</div>

		</div>
	</div>
</body>
</html>
