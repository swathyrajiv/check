<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact List - Spring Boot Web Application Example</title>
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
</head>
<body>
   <form action="login" method="post">
   <h2>Sporty shoes we know your taste ....</h2>
<img src="/images/shoesimg.jpg" height="500" style="width:50%" width="700">
<br>
<div class = "b">
<h2>login here</h2>
enter name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type  = "text" name = "userName" required><br>
<br>
enter password<input type  = "password" name = "password" required><br>
<br>
<input type  = "submit" name = "submit" value = "submit"><br> 

</div>

 </form> 
  <div class="fixed-footer">
        <div class="container">Copyright &copy; 2020 Sporty Shoes</div>        
    </div> 
</body>
</html>