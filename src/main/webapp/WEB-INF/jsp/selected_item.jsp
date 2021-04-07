<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selected</title>
</head>
<body>
<table class="table table-striped">
                <thead>
                    <tr>
                        
                        <th>Cuizine-Name</th>
                      
                        <th>price</th>
                        <th>quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cuiz" items="${fetchdetails}">
                        <tr>
                        	
                            <td>${cuiz.cuizineName} </td>
                            
                            <td>${cuiz.price}</td>
                            
                        </tr>
                    </c:forEach>
                   
                </tbody>
            </table> 
            <form action="/payment" method="post">
           <input type ="text" name = "price" id = "price" value ="${fetchdetails.stream().map(cuiz -> cuiz.price).sum()}">
           <input type ="submit" value ="go to payment" name = "payment">
           </form>
</body>
</html>