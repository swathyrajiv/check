<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view purchase</title>
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
<form action="/viewhistory" method = "post">
<img src="/images/calender.png" height="500" width="700">
<h2>please enter the date here to find the purchase history </h2>
 date <input type ="date" name ="daten" required>
<input type = "submit" name = "submit" value ="click to find the purchase history">
<div></div>
 Copyright &copy; 2020 Sporty Shoes
</form>
</body>
</html>