<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<head>
<meta charset="UTF-8">
<title>user_home</title>
<style>
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
}
h2{
}
</style>
</head>
<body>
<img src="/images/welcom.png" height="500" width="700">
<h1>Welcome to <%= request.getAttribute("name")%> </h1> 
<a href = "/addshoesview"> add product details</a>&nbsp;&nbsp;&nbsp;
<a href = "/viewpurchasehistory">view purchase history</a>&nbsp;&nbsp;
<a href = "/changepassword">Change password</a>&nbsp;&nbsp;
<a href = "/logout">log out</a>
<br>
<br>
<br>
<br>
<br>
<div class="fixed-footer">
        <div class="container">Copyright &copy; 2020 Sporty Shoes</div>        
    </div> 
</body>
</html>
