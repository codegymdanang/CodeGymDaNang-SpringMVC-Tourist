<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>

   <head>
      <title>The jQuery Example</title>
      <script type = "text/javascript" 
         src = "http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		
      <script type = "text/javascript" language = "javascript">
      var ctx = "<%=request.getContextPath()%>"
         $(document).ready(function() {
			
            $("#driver").click(function(event){
         	   alert("hello");
               $.getJSON(ctx+'/getall', function(data) {
            	   $.each(data, function(index) {
            		   var row = $("<tr><td>" + data[index].id + "</td><td>"+data[index].username+"</td></tr>");
                       $("#stage").append(row);
                   });
               });
            });
				
         });
      </script>
   </head>
	
   <body>
	
      <p>Click on the button to load URL:</p>
		
      <table id="stage" align="center">
		  <tr>
		    <th>ID</th>
		    <th>Username</th>
		  </tr>
		  
		</table>
		
      <input type = "button" id = "driver" value = "Load Data" align="center" />
		
   </body>
	
</html>