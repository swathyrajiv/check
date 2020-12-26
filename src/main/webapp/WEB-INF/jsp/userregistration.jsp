<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>save_shoes</title>
</head>
<body>
<form action="/userregistration" method ="post">
<!--  <input type = "text" value = "<%= request.getAttribute("id")%>" name = "username" >-->
Name <input type = "text" name = "username" required><br>
<br>
Address<input type = "text"  name = "address"required><br>
<br>
Email<input type = "text" name = "emailid"required><br>
<br>
phone#<input type = "text" name = "phoneno" required><br>
<br>
<input type="submit" name= "submit" value = "click here to register">
<br>
</form>
</body>
</html>