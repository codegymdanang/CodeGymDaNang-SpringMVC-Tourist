$(document).ready(function(){
	
    $("#search_friends").click(function(){
    	$.ajax({
    		url :  "/servicefriend/findfriend",
    		type : "POST",
    		data : {
    		name : $("#name").val(),
    		search: $("#search").val()
    		},
    		success : function(response) {
    		alert("duy");
    		},
    		error : function(error) {
    		console.log(error);
    		}
    		});
//        alert($("#search").val()+"is : " + $("#name").val()+"\n search by: "+$("#search").val());
    });
});