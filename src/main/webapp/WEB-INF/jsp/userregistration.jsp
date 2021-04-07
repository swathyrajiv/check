<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>save_shoes</title>
<style>
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
}
h2{
}
div {
  border: white;
  background-color: white;
  padding-top: 50px;
  padding-right: 30px;
  padding-bottom: 50px;
  padding-left: 80px;
}
</style>
</head>
<body>
<form action="/userregistration" method ="post">
<h2>please enter your personal details</h2>
<div></div>
Name <input type = "text" name = "username" required><br>
<br>
Address<input type = "text"  name = "address"required><br>
<br>
Email<input type = "text" pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name = "emailid"required><br>
<br>
phone#<input type = "text" pattern= "[789][0-9]{9}" name = "phoneno" required><br>
<br>
password<input type = "password" name = password required><br>
<input type="submit" name= "submit" value = "click here to register">
<br>
<div></div>
<div></div>
<div></div>
<div></div>
<div></div>
Copyright &copy; 2020 Sporty Shoes
</form>
</body>
</html>