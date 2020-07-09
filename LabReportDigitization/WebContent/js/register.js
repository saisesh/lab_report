$("#register_form").submit(function(event) {
	event.preventDefault(); // prevent default action
	var post_url = $(this).attr("action"); // get form action url
	var request_method = $(this).attr("method"); // get form GET/POST method
	var form_data = $(this).serialize(); // Encode form elements for
	$.ajax({
		url : post_url,
		type : request_method,
		data : form_data
	}).done(function(response) { //
		console.log(response);
		const responseObj = JSON.parse(response);
		if (responseObj.status == 200) {
			const responseObj = JSON.parse(response);
			var token = responseObj.token;
			document.cookie = "access_token=" + token;
			window.location.href = '/LabReportDigitization/home.jsp';
			$('.register-error-msg').hide();
		} else {
			$('.register-error-msg').show();
		}
	});
});