$(document).ready(function() {
	var accessTokenFromBrowser = $.cookie("access_token");
	var post_url = $(this).attr("action"); // get form action url
	var request_method = $(this).attr("method"); // get form GET/POST method
	if (accessTokenFromBrowser != null || accessTokenFromBrowser != '') {
		$.ajax({
			url : post_url,
			type : request_method,
			data : {
				accessToken : accessTokenFromBrowser
			}
		}).done(function(response) { //
			console.log(response);
			if (responseObj.status == 200) {
				window.location.href = '/LabReportDigitization/home.jsp';
			} else {
				window.location.href = '/LabReportDigitization/index.jsp';
			}
		});
	}
});

$("#login_form").submit(function(event) {
	event.preventDefault(); // prevent default action
	var post_url = $(this).attr("action"); // get form action url
	var request_method = $(this).attr("method"); // get form GET/POST method
	var form_data = $(this).serialize(); // Encode form elements for
	// submission
	$.ajax({
		url : post_url,
		type : request_method,
		data : form_data
	}).done(function(response) { //
		const responseObj = JSON.parse(response);
		var token = responseObj.token;
		document.cookie = "access_token=" + token;
		if (responseObj.status == 200) {
			window.location.href = '/LabReportDigitization/home.jsp';
			$('.login-error-msg').hide();		
		} else {
			$('.login-error-msg').show();
		}
	});
});