<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>editCuizineAdd</title>
</head>
<body>
 <form action="/editCuizineAdd" method="post">
 chosen product id is <input type = "text" name = product_id value = ${updateCuizId}>
 
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
<br>
save changes<input type = "submit" name = submit>
<input type ="text" name =confirm>
</form> 
</body>
</html>