<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/home.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/footer.css">
<link rel="stylesheet" href="./css/profile.css">
<link rel="stylesheet" href="./css/uploadreport.css">
</head>
<body>
	<%@include file="includes/header.jsp"%>
	<div class="home-main-content">
		<div class="profile-content">
			<%@include file="includes/profile.jsp"%>
		</div>
		<div class="user-report-upload">
			<%@include file="includes/uploadreport.jsp"%>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
<script src="./js/lib/jquery.js"></script>
<script src="./js/lib/projectutils.js"></script>
<script src="./js/profile.js"></script>
<script src="./js/uploadreport.js"></script>
</html>