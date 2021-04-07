<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add shoes</title>
<style>
.img {
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

<form action="/addcuizineview" method="post">
<span>${success}</span>
enter cuizine name:<input type  = "text" name = "cuizineName" required><br>
<br>
enter cuizine type&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type  = "text" name = "cuizineType" required><br>
<br>
enter veg/nonveg&nbsp; <input type  = "text" name = "vegornonveg" required><br>
<br>
enter vegan or non vegan&nbsp;<input type  = "text" name = "vegan" required><br> 
<br>
enter price &nbsp;<input type = "text" name = "price" required><br>
<br>
<input type ="submit" name = "submit" value = "submit">
<br>
<br>
<a href = "/log">click here to go back to welcome page</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href = "/logout">log out</a>
 </form> 
 
 <div>
 </div>
 <div>
 </div>
 <div>
 </div>
 <div>
 </div>
   Copyright &copy; 2020 Sporty Shoes        
   
</body>
</html>