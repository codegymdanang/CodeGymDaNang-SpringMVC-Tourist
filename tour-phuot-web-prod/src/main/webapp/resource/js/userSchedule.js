$(document).ready(function() {
	var postData = {
		place_id : "2",
		status : 2,
	/*createdDate : "04-20-2016",
	startDay : "04-20-2016",
	endDay : "04-20-2016"*/

	};

	/* click like button */
	$('.like').click(function(event) {
		postData.place_id = this.val;
		alert("success" + postData.place_id);
		$.ajax({
			type : 'POST',
			url : ctx + '/homedata/like',
			data : JSON.stringify(postData),
			headers : {
				"Content-Type" : "application/json"
			},
			dataType : 'json',
			error : function(e) {
				console.log(e);
			},
			success : function(data) {
				alert("success");

			}
		});
	});

	/* click like button */
	$('#like2').click(function(event) {
		postData.place_id = $('#like2').val();
		$.ajax({
			type : 'POST',
			url : ctx + '/homedata/like',
			data : JSON.stringify(postData),
			headers : {
				"Content-Type" : "application/json"
			},
			dataType : 'json',
			error : function(e) {
				console.log(e);
			},
			success : function(data) {
				alert("success");

			}
		});
	});

	/* click dislike button */
	/*	$("#dislike").click(function(event) {
	 //postData.place_id = $("#dislike").val();
	 $.ajax({
	 url : 'http://localhost:8080/tour-phuot-web-prod/homedata/like',
	 type : 'post',
	 data : JSON.stringify(postData),
	 headers : {
	 "Content-Type" : "application/json"
	 },
	 dataType : 'json',
	 success : function(data) {
	 alert("success");
	 ;
	 }
	 });
	 });*/

	/* click remind button */
	/*	$("#remind").click(function(event) {
	 //postData.place_id = $("#remind").val();
	 $.ajax({
	 url : 'http://localhost:8080/tour-phuot-web-prod/homedata/like',
	 type : 'post',
	 data : JSON.stringify(postData),
	 headers : {
	 "Content-Type" : "application/json"
	 },
	 dataType : 'json',
	 success : function(data) {
	 alert("success");
	 }
	 });
	 });*/

});
