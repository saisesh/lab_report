$(document).ready(function() {
	var accessTokenFromBrowser = getCookie("access_token");
	if (accessTokenFromBrowser == null || accessTokenFromBrowser == '') {
		window.location.href = '/LabReportDigitization/index.jsp';
	}
	var post_url = '/LabReportDigitization/profile';
	var request_method = 'POST'; // get form GET/POST method
	$.ajax({
		url : post_url,
		type : request_method,
		data : {
			accessToken : accessTokenFromBrowser
		}
	}).done(function(response) { //	
		var responseObj = JSON.parse(response);
		if (responseObj.status == '200') {		
			$('#uname').html(responseObj.username);
			$('#firstname').html(responseObj.firstname);
			$('#lastname').html(responseObj.lastname);
			$('#email').html(responseObj.email);
			$('#age').html(responseObj.age);
			$('#phone').html(responseObj.phone);
			$('.logout').show();
		} else {
			window.location.href = '/LabReportDigitization/index.jsp';
		}
	});
});

function logout(){	
	document.cookie = 'access_token=';
	window.location.href='/LabReportDigitization/index.jsp';
}