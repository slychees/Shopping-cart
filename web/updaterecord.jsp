<%-- 
    Document   : updaterecord
    Created on : May 1, 2021, 10:26:36 PM
    Author     : Sly Cheese
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% 
     
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Cake</title>        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link href="css/adminheadbord.css" rel="stylesheet" />
    </head>
    <body>
        <div class="fixed-header" >
        
            <nav>
                <a href="#"><span class="glyphicon glyphicon-home"></span> Home</a>
                <a href="view_records.jsp">View Cakes</a>
                <a href="#">About</a>
                <a href="#">Products</a>
                <a href="#">Services</a>
                <a href="#">Contact Us</a>
                
                <ul class="nav navbar-nav navbar-right">
    <!--  <a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>  -->
      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    </ul>
             <!--   <a href="Login.jsp" ><span class="glyphicon glyphicon-log-in"></span> Logout</a>    -->
            </nav>
        
    </div>
        <div class="container">
            <div><h1>Add cakes to the database</h1></div>
        
        
    <form method="post" enctype="multipart/form-data" action="updaterecords"> <!-- enctype="..." is used as a security to send the image from the form to the backend -->
        <pre>

        Product ID:   <input type="text" name="productid" Placeholder="Product ID" size="23" value="${product.getProductid()}"/>

        Product Name: <input type="text" name="productname" Placeholder="Product Name" size="23" value="${product.getProductname()}" />

        Category:     <select name="category" value="${product.getCategory()}"">
                                <option>Sponge Cake</option>
                                <option>Pound Cake</option>
                                <option>Angel Food Cake</option>
                                <option>Biscuit Cake</option>
                                <option>Baked Flourless Cake</option>
                                
                      </select> 

        Quantity:    <input type="number" name="quantity" placeholder="Quantity" id="quantity" size="24" value="${product.getQuantity()}" />

        Price:       <input type="text" name="price" Placeholder="Price" size="5" value="${product.getPrice()}"/>

        Description: <textarea id="descript" name="description" rows="4" cols="18" Placeholder="Product Description">${product.getDescription()}</textarea> <br>

        Choose a file:<input type="file" name="uploadedFile"> 

               
                  <input type="submit" name="update" value="Update record" onclick="showAlert()" />
                  <input type="hidden" name="cupdate" value="vupdate" /> 
        </pre>
    </form>
                            <script type="text/javascript"> 
                            function showAlert(){ 
                            alert("Record updated successfully"); 
                            } 
                            </script>
          
    </body>
    </body>
</html>
