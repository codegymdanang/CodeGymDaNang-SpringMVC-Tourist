$(document).ready(function(){
    $("#search_friends").click(function(){
        alert($("#search").val()+"is : " + $("#name").val()+"\n search by: "+$("#search").val());
    });
});