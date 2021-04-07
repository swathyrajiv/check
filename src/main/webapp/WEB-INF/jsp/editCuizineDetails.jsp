<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>editCuizineDetails</title>
</head>
<body>

<table class="table table-striped">
                <thead>
                    <tr>
                        <th>Product_code</th>
                        <th>Cuizine Name</th>
                        <th>Cuizine Type</th>
                        <th>Veg/NonVeg</th>
                        <th>Vegan</th>
                        <th>Price</th>
                         
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cuiz" items="${fetchCuizineList}">
                        <tr>
                        	<td>${cuiz.product_id}</td>
                            <td>${cuiz.cuizineName} </td>
                            <td>${cuiz.cuizineType}</td>
                            <td>${cuiz.vegornonveg}</td>
                            <td>${cuiz.vegan}</td>
                            <td>${cuiz.price}</td>
                            
                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
            <br> 
            <br>
            <br>
            <form action="/editCuiz" method = "post">
            <label> enter the product code to edit the details</label>
            <br>
           <input type="text" name = product_id required >
           <input type ="submit"name =submit value = "submit">
           </form>
           <form action ="/editCuizineDel" method ="post">
           <label>enter the product code you want to delete</label>
           <input type ="text" name = "product_id"required>
           <input type ="submit" name = submit value = "Delete">
           </form>
           
</body>
</html>