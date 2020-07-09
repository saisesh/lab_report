<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/footer.css">
</head>
<body>
  <%@include file="includes/header.jsp" %>
  <div class="parent-container">
  <div class="login-page-content"> 
  	<div class="signup-text">Sign up and find out our exciting features on Website!</div>
  	<button type="submit"onclick="window.location.href='./register.jsp'">Register here</button>
  </div>
  <div class="customer-login-form">
	  <form class="modal-content" id="login_form" action="customerlogin" method="post">
	    <div class="sign-in"><span>Sign In Here</span></div>
	    <div class="login-error-msg">Please enter correct details.</div>
	    <div class="container">	   
	      <label for="uname"><b>Username</b></label>
	      <input type="text" placeholder="Enter Username" name="uname" required>
	
	      <label for="psw"><b>Password</b></label>
	      <input type="password" placeholder="Enter Password" name="psw" required>
	        
	      <button type="submit">Login</button>
	      <label>
	        <input type="checkbox" checked="checked" name="remember"> Remember me
	      </label>
	    </div>    
	  </form>
  </div>
  </div>
  <%@include file="includes/footer.jsp" %>
</body>
<script src="./js/lib/jquery.js"></script>
<script src="./js/lib/projectutils.js"></script>
<script src="./js/login.js"></script>
</html>