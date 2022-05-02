<%-- 
    Document   : index
    Created on : Apr 27, 2021, 4:58:06 PM
    Author     : Sly Cheese
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<!--                <a href="homepage.jsp"><span class="glyphicon glyphicon-home"></span> Home</a>
                <a href="view_records.jsp">View Cakes</a>
                <a href="#">About</a>
                <a href="#">Products</a>
                <a href="#">Services</a>
                <a href="#">Contact Us</a>-->
<%@ include file="header2.jsp" %>
                
                <ul class="nav navbar-nav navbar-right">
    <!--  <a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>  -->
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    </ul>
             <!--   <a href="Login.jsp" ><span class="glyphicon glyphicon-log-in"></span> Logout</a>    -->
            </nav>
        
    </div>
        <div class="container">
            <div><h1>Add cakes to the database</h1></div>
        
        
    <form method="post" enctype="multipart/form-data" action="addprod"> <!-- enctype="..." is used as a security to send the image from the form to the backend -->
        <pre>

        Product ID:   <input type="text" name="productid" Placeholder="Product ID" size="23"/>

        Product Name: <input type="text" name="productname" Placeholder="Product Name" size="23" />

        Category:     <select name="category" >
                                <option>Sponge Cake</option>
                                <option>Pound Cake</option>
                                <option>Angel Food Cake</option>
                                <option>Biscuit Cake</option>
                                <option>Baked Flourless Cake</option>
                                
                      </select> 

        Quantity:    <input type="number" name="quantity" placeholder="Quantity" id="quantity" size="24" />

        Price:       <input type="text" name="price" Placeholder="Price" size="5" />

        Description: <textarea id="descript" name="description" rows="4" cols="18" Placeholder="Product Description"></textarea> <br>

        Choose a file:<input type="file" name="uploadedFile"> 

               
                  <input type="submit" name="Submit" value="Submit" onclick="showAlert()" />
                  <input type="hidden" name="addck" value="cks">
        </pre>
    </form>
        </div>    
        
                            <script type="text/javascript"> 
                            function showAlert(){ 
                            alert("Record added successfully"); 
                            } 
                            </script>
                            
                            
    <footer class="tm-footer text-center">
            <div class="fixed-footer">
        <div class="containerF"><a rel="nofollow" href="Login.jsp">Admin Login</a></div>
        <div class="containerF"> Copyright &copy; 2021 Your Company     | Design: </div>
    </div>
        <p>Copyright &copy; 2020 Simple House </p>
            
            
    </footer>
    </body>
</html>
