<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit-cuizine</title>
</head>
<body>
<form action="/editCuizineDetailsMap" method = "post">
<span>${success}</span><br>
please enter the cuizine name which you want to edit
<input type="text" name = editCuizine required >
<input type = "submit" name = "submit" value ="click to find the cuizine-details">
<div></div>
</form>
</body>
</html>