<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change password</title>
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
<form action="/changepasswordedit" method = "post">
<h1>Sporty shoes ... Welcome to sporty shoes</h1>
Enter user name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type  = "text" name = "userName"  required><br>
<br>
Enter password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type  = "password" name = "password"  required><br>
<br>
Confirm password&nbsp;&nbsp;<input type  = "password" name = "cpassword"   required><br>
<input type = "submit" name = "submit" value = "click to update">
<div>
</div>
<div>
</div>
<div>
</div>
Copyright &copy; 2020 Sporty Shoes
</form>
</body>
</html>