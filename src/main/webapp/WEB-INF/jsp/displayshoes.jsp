<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action = "/saveshoes" method = "post" >
<table class="table table-striped">
                <thead>
                    <tr>
                        <th>Product-id</th>
                        <th>Brand-Name</th>
                        <th>Color</th>
                        <th>Size</th>
                        <th>Price</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="shoe" items="${shoes}">
                        <tr>
                        	<td><input type = "radio" name = "sesproduct_id" value = "${shoe.product_id}" id = "${shoe.product_id}">${shoe.product_id}</td>
                            <td>${shoe.brandName} </td>
                            <td>${shoe.color}</td>
                            <td>${shoe.size}</td>
                            <td>${shoe.price}</td>
                            
                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table> 
            <input type ="submit" name = "btnappr" value = "click on this for payment">
            </form>    
</body>
</html>