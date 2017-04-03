<%@page import="org.springframework.web.client.RestTemplate"%>
<%@page import="com.fasterxml.jackson.databind.util.JSONPObject"%>
<%@page import="guru.tour.entity.UserPostEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">
var ctx = "<%=request.getContextPath()%>";
var numberOfElements="";
var currentIndex = ${currentIndex};
var totalPage = ${totalPage};
var lastPage=${totalPage};		 
	$(document).ready(function() {
		returnPage(0);	  
		$('#post').click(function(){
			if($("#comment").val().length > 5 && $("#comment").val().length <20 ){		
				var data = {
		    		    id_user: $("#id_user").val(),
		    		    id_post: $("#id_post").val(),
		    		    comment: $("#comment").val(),
		    		};
						$.ajax({
							type : 'POST',
							url : ctx + '/addComment',
							contentType: "application/json",
							data: JSON.stringify(data),
							
							success : function(response) {
								alert("da click post");
								returnPage(lastPage);
							},
							
							
						});
				returnPage2(lastPage);	
			}else{
				$('#myPost').html("Comment's size should be between 5 and 20");
			}
			return false;
		});
		
	});
	
	function returnPage(page) {
		currentIndex = page;		
		  $.ajax( {
				type : 'GET',
	            url: ctx+'/getAllComment/'+$("#id_post").val()+'/'+page,
	            success:function(data) {
	          	  $("#myData").empty();
	          	  $(".pagination li").remove();
	          	  var row="";
	          	var startPage = data.number -1;
	         	if(startPage <=0){
	         		startPage = 0;
	         		 row +="<li class='disabled'><a href='#'>&lt;&lt;</a></li>"
	                		+"<li class='disabled'><a href='#'>&lt;</a></li>"
	         	}else{
	         		 row +="<li><a href='#' onclick='returnPage(0)'>&lt;&lt;</a></li>"
	              		+"<li><a href='#'  onclick='prePage()'>&lt;</a></li>"
	         	}
	         	var endPage = startPage +3;
	         	if (endPage+1 > data.totalPages){
	         		endPage =  data.totalPages;
	         	}
	         
	         	for(i = startPage+1; i <=endPage; i++){
	         		row +="<li><a href='#' onclick='returnPage("+(i-1)+")'>"+i+"</a></li>"
	         	}
	         	if(endPage+1 > data.totalPages){
	         		row +=	"<li class='disabled'><a href='#'>&gt; </a></li>"+
	                "<li class='disabled'><a href='#'>&gt;&gt;</a></li>"
	         	}else{
	         		row +=	"<li><a href='#' onclick='nextPage()'>&gt; </a></li>"+
	                "<li><a href='#' onclick='returnPage("+(data.totalPages-1)+")'>&gt;&gt; </a></li>"
	         	}
	         	 $(".pagination").append(row);
	          	
	          	 if(data.number+1 == data.totalPages){
	          		 $("#myData").empty();
	             	  $(".pagination li").remove();
	          		var row="<li><a href='#'  onclick='returnPage(0)'>&lt;&lt;</a></li>"
	            		+"<li><a href='#'  onclick='prePage()'>&lt;</a></li>"
	            		+"<li><a href='#' onclick='returnPage("+(data.number)+")'>"+(data.number+1)+"</a></li>"
	          		+"<li class='disabled'><a href='#'>&gt;</a></li>"
	          		+"<li class='disabled'><a href='#'>&gt;&gt;</a></li>"
	          		$(".pagination").append(row);
	          	} 			  
	          	  $.each(data.content, function( index) {	            	
	                  row = $("<div><p>" + data.content[index].comment + "</p><p> By:"+data.content[index].id_user+"</p></div><hr style='border-color:#165512'>");
	                   $("#myData").append(row);
	               });
	         },
         });
	}
	
	function returnPage2(page) {
		if(page < 0){
			page = 0;
		}
		if(lastPage < 0){
			lastPage = 0;
		}
		currentIndex = page;	
		  $.ajax( {  
			type : 'GET',  
            url: ctx+'/getAllComment/'+$("#id_post").val()+'/'+page,
            success:function(data) {
            	if(data.numberOfElements > 1){
            		lastPage= lastPage+1;
            	}
            },
         });
	}
	
	function nextPage() {
		if(currentIndex < totalPage){
			currentIndex= currentIndex+1;
			returnPage(currentIndex);
		}
	}
	
	function prePage() {
		if(currentIndex > 0){
			currentIndex= currentIndex-1;
			returnPage(currentIndex);
		}		 
	}
</script>
</head>
<body>
	<%@ page import="java.sql.*"%>

	<div class="container">

		
			<textarea   id="comment" cols="50" rows="5"></textarea>	<br>		
			<span id="myPost" style="color:red;"></span><br/>
			Id_User<input type="text" name="id_user" id="id_user" value="${id_user}"/><br/>
			Ten nguoi comment <input value="${username}"/><br/>
			<input type="hidden" name="id_post" id="id_post" value="${id_post}"/><br/>
			<input type="text" name="totalPage" id="totalPage" value="${totalPage}"/><br/>
			<input type="text" name="currentIndex" id="currentIndex" value="${currentIndex}"/><br/>
			<input type="button" id="post" value="Post Comment"/>
			
			<span id="myData"></span>	
			 <ul class="pagination">
	    	</ul>

	</div>

</body>
</html>