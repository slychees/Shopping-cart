<%-- 
    Document   : header
    Created on : May 25, 2021, 1:14:46 PM
    Author     : Sly Cheese
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
<!--        <h1>Hello World!</h1>-->
        <div class="fixed-header" >
        
            <nav>
                <a href="homepage.jsp"><span class="glyphicon glyphicon-home"></span> Home</a>                
                <a href="view_records.jsp">View records</a>
                <a href="view_orders.jsp">View orders</a>
                <a href="index.jsp">Add products</a>
                <a href="#">Services</a>
                <a href="about.html">About</a>
                <a href="contact.html">Contact Us</a>
<!--                <a href="Login.jsp" ><span class="glyphicon glyphicon-log-in"></span> Logout</a>-->
                <ul class="nav navbar-nav navbar-right">
<!--                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>     -->
                <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
                </ul>
            </nav>
        
    </div>
    </body>
</html>
