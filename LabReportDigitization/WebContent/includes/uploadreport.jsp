<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="upload-report-section">
	<h3>Upload report section</h3>
	<input type="file" id="reportFile">
	<button onclick="uploadReport()">Process Report</button>
	<div class="report-process-success">Your score is 8, your claim is approved!</div>
	<div class="report-process-fail"> Your score is 4, your claim is denied!</div>
</div>