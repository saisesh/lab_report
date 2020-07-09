function uploadReport() {
	debugger;
	var reportFile = document.getElementById("reportFile");
	if (reportFile.value != '') {
		reportFile.disabled = true;
	} else {
		reportFile.disabled = false;
	}
	var uname = $('#uname').html();
	if (uname.startsWith("a") || uname.startsWith("b") || uname.startsWith("c")
			|| uname.startsWith("d")) {
		$('.report-process-fail').show();
	} else {
		$('.report-process-success').show();
	}
}