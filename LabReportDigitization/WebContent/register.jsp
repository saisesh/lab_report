<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/register.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/footer.css">
<title>Insert title here</title>
</head>
<body>
<%@include file="includes/header.jsp" %>
<div class="parent-container">
<div class="customer-register-form">
	  <form class="modal-content" id="register_form" action="registeruser" method="post">
	    <div class="sign-in"><span>Register Here</span></div>
	    <div class="register-error-msg">Please enter correct details.</div>
	    <div class="container">
	      <label for="firstname"><b>Firstname</b></label>
	      <input type="text" placeholder="Enter Firstname" name="firstname" required>
	      
	      <label for="lastname"><b>Lastname</b></label>
	      <input type="text" placeholder="Enter Lastname" name="lastname" required>
	      	   
	      <label for="uname"><b>Username</b></label>
	      <input type="text" placeholder="Enter Username" name="uname" required>
	
	      <label for="psw"><b>Password</b></label>
	      <input type="password" placeholder="Enter Password" name="psw" required>
	      
	      <label for="reenterpsw"><b>Reenter Password</b></label>
	      <input type="text" placeholder="Reenter Password" name="reenterpsw" required>
	      
	      <label for="email"><b>Email</b></label>
	      <input type="email" placeholder="Enter Email" name="email" required>
	      
	      <label for="age"><b>Age</b></label>
	      <input type="number" name="age" min="18" max="99">
	        
	      <label for="phone"><b>Enter Phone Number</b></label>
	      <input type="number" placeholder="Enter Phone Number" name="phone" required>
	      
	      <button type="submit">Register</button>
	    </div>    
	  </form>
  </div>
  </div>
   <%@include file="includes/footer.jsp" %>
   <script src="./js/lib/jquery.js"></script>
   <script src="./js/register.js"></script>
</body>
</html>