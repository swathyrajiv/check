<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>purchase history</title>
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
<table class="table table-striped">
                <thead>
                    <tr>
                        
                        <th>Brand-Name</th>
                        <th>Color</th>
                        <th>Size</th>
                        <th>Price</th>
                         
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="shoe" items="${updalist}">
                        <tr>
                        	
                            <td>${shoe.brandName} </td>
                            <td>${shoe.color}</td>
                            <td>${shoe.size}</td>
                            <td>${shoe.price}</td>
                            
                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table> 
           
            <table class="table table-striped">
                <thead>
                    <tr>
                        
                        <th>user-name</th>
                        <th>email-id</th>
                        <th>address</th>
                        <th>phone</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${updalistuser}">
                        <tr>
                        	
                            <td>${user.username} </td>
                            <td>${user.address}</td>
                            <td>${user.emailid}</td>
                            <td>${user.phoneno}</td>
                            
                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table> 
            <div></div>
            <a href = "/log">click on this link to go back to welcome page</a>
            <div></div>
            <div></div>
            <div></div>
           
            Copyright &copy; 2020 Sporty Shoes
</body>

</html>