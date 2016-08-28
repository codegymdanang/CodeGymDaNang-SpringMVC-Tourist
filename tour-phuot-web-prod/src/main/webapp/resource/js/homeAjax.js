var ctx = "<%=request.getContextPath()%>"
         $(document).ready(function() {
			
            $("#fetchContacts").click(function(event){
               $.getJSON(ctx + '/homedata/1', function(data) {
                  $('#stage').html('<p> Id: ' + data.hotnewsId + '</p>');
                  $('#stage').append('<p>Name : ' + data.name+ '</p>');
                  $('#stage').append('<p>Description: ' + data.description + '</p>');
                  $('#stage').append('<p>Image: ' + data.image + '</p>');                  
               });
            });
				
         
            var postData = {
               	 name: "Bao cong an TP",
            	 description: "CATP",
            	 image:  "nvt.jpg"
            };
            
            $("#addHotNew").click(function(event){               
            	$.ajax({
            	    url: ctx + '/homedata/createHotnew',
            	    type: 'post',
            	    data: JSON.stringify(postData),
            	    headers: {
            	      "Content-Type": "application/json"
            	    },
            	    dataType: 'json',
            	    success: function (data) {
            	    	 $('#stage').html(data);
            	    }
            	});
            });
            
            
            
               /* $("#searchByLocationName").click(function(event){                   
                   $.getJSON(ctx + '/searchLocation', function(data) {
                	   if(data.location_name != 'null'){
                		   window.location.href = 'searchLocation';   
                	   }
                	   else{
                		   window.location.href = 'HomeError';
                	   }
                	                      
                    });                                   
                });*/
                       
        });
      
         
        