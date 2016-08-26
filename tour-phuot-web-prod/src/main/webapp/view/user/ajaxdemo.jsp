<html>

   <head>
      <title>The jQuery Example</title>
      <script type = "text/javascript" 
         src = "http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		
      <script type = "text/javascript" language = "javascript">
      var ctx = "<%=request.getContextPath()%>"
         $(document).ready(function() {
			
            $("#submit").click(function(event){
            	 var ctx = "<%=request.getContextPath()%>"
            	var data = {
            		    username: $("#username").val(),
            		    password: $("#password").val(),
            		    image: $("#image").val(),
            		    phone: $("#phone").val()
            		};
            	$.ajax({
            	    type: "POST",
            	    url: ctx+"/addall",
            	    contentType: "application/json", // NOT dataType!
            	    data: JSON.stringify(data),
            	    success: function(response) {
            	        $("#stage").html(response);
            	    }
            	});
					
            });
				
         });
      </script>
   </head>
	
   <body>
	
      <p>Click on the button to load result.html file −</p>
		
      <div id = "stage" style = "background-color:cc0;">
         STAGE
      </div>
		
      

	    <input type="text" name="username" id="username"/>
	    <input type="text" name="password" id="password"/>
	    <input type="text" name="image" id="image" />
	    <input type="text" name="phone" id="phone"/>
	    <input type="button" name="submit" id="submit" value="Submit" />
	
   </body>
	
</html>