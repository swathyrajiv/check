<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display cuizine</title>
<style >
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
<%--  <form action = "/saveshoes" method = "post" > --%>
<table class="table table-striped">
                <thead>
                    <tr>
                        <th>Product-id</th>
                        <th>Cuizine-Name</th>
                        <th>Cuizine-Type</th>
                        <th>Veg/Non Veg</th>
                        <th>Vegan</th>
                        <th>price</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cuiz" items="${cuizineList}">
                        <tr>
                        	<%-- <td><input type = "radio" name = "sesproduct_id" value = "${shoe.product_id}" id = "${shoe.product_id}"required>${shoe.product_id} </td> --%>
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
           <%--  </form>  --%>
            <form action="/loginuser" method ="post">
            <input type ="submit" name = logsubmit value ="login here" required>
                        </form> 
                <form action = "/registerUser" method = "post" >
                <label>New User Register here</label>
                <input type ="submit" name = registerSubmit value ="register here"required>
                </form>
                
                      
            <div></div> 
             Copyright &copy; 2020 Sporty Shoes  
</body>
</html>