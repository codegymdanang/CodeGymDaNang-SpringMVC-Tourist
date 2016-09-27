var ctx = "<%=request.getContextPath()%>"
        $(document).ready(function() {
        	var ctx = "<%=request.getContextPath()%>"
        		        	        		
        	 /*click dislike button*/
        	 var postData = {
        			 LocationEntity : $.session.get('locationEntity'),                 	 
                	 status:  1,
                };
                
                $("#dislike").click(function(event){               
                	$.ajax({
                	    url: ctx + '/homedata/dislike',
                	    type: 'post',
                	    data: JSON.stringify(postData),
                	    headers: {
                	      "Content-Type": "application/json"
                	    },
                	    dataType: 'json',
                	    success: function (data) {
                	    	alert("success");;
                	    }
                	});
                });
            
            /*click like button*/                                
                   $("#remind").click(function(event){               
                   	$.ajax({
                   	    url: ctx + '/homedata/remind',
                   	    type: 'post',
                   	    data: JSON.stringify(postData),
                   	    headers: {
                   	      "Content-Type": "application/json"
                   	    },
                   	    dataType: 'json',
                   	    success: function (data) {
                   	    	alert("success");
                   	    }
                   	});
                   });
            
            /*click remind button*/                  
                      $("#like").click(function(event){               
                      	$.ajax({
                      	    url: ctx + '/homedata/like',
                      	    type: 'post',
                      	    data: JSON.stringify(postData),
                      	    headers: {
                      	      "Content-Type": "application/json"
                      	    },
                      	    dataType: 'json',
                      	    success: function (data) {
                      	    	alert("success");;
                      	    }
                      	});
                      });				                                                                             
                       
        });
      
         
        