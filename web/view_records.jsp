<%-- 
    Document   : view_records
    Created on : May 1, 2021, 2:57:16 PM
    Author     : Sly Cheese
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="src.home"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
    String URL = "jdbc:derby://localhost:1527/sample";
    String USER = "app";
    String PASSWORD ="app";
    try{
        Connection connect;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        connect = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement pt = (PreparedStatement) connect.prepareStatement("SELECT * FROM CAKES");
        ResultSet result = pt.executeQuery();
        List <home> product_items = new ArrayList();
        while(result.next()){
            home product =  new home();
            product.setProductid(result.getString("productid"));
            product.setProductname(result.getString("productname"));
            product.setCategory(result.getString("category"));
            product.setQuantity(result.getString("quantity"));
            product.setPrice(result.getInt("price"));
            product.setDescription(result.getString("description"));
            product.setImage(result.getString("image"));
            product_items.add(product);
        }
        request.setAttribute("product_items", product_items);
    }catch(SQLException e){
        PrintWriter print = response.getWriter();
        print.println(e);
    }catch (ClassNotFoundException ex){
        PrintWriter print = response.getWriter();
        print.println(ex);
    }
    %>
    
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <link href="css/adminheadbord.css" rel="stylesheet" />

    
    </head>
    <body>
        <%@ include file="header.jsp" %>
<!--        <div class="fixed-header" >
        
            <nav>
                <a href="homepage.jsp"><span class="glyphicon glyphicon-home"></span> Home</a>                
                <a href="view_records.jsp">View records</a>
                <a href="view_orders.jsp">View orders</a>
                <a href="index.jsp">Add products</a>
                <a href="#">Services</a>
                <a href="about.html">About</a>
                <a href="contact.html">Contact Us</a>
                <a href="Login.jsp" ><span class="glyphicon glyphicon-log-in"></span> Logout</a>
                <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>     
                <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
                </ul>
            </nav>
        -->
    </div>
        
        <h2>View cakes in database</h2> <br><br>
        

<!--                        <table width:70%; >
                        <tr>
                        <div><th>Product ID</th>
                          <th>Product Name</th> 
                          <th>Price</th>
                          <th>Quantity</th>
                          <th>Category</th>
                          <th> &nbsp; &nbsp; &nbsp; </th>
                          <th>Description</th>                          
                        </tr>
                        </table>    -->
<div style="word-spacing: 3em;"><h4><span style="word-spacing: 0em"> Product ID </span> &nbsp;<span style="word-spacing: 0em">Product Name</span> Price Quantity  Category Description</h4>  </div>
         <% if(request.getAttribute("product_items") == null) {%>
        <!-- <h1>Product Item is NULL</h1>     <br><br><br>  -->
                <%}else{%>
                
                <% List product_items = (ArrayList) request.getAttribute("product_items") ;%>
                <% for(int i=0; i < product_items.size(); i++) { %>
                <div style="color: blue">
                    <form action="updaterecord" method="post" >
                <% home product = (home) product_items.get(i) ;%>
            <!--    <div class="column" style="background-color:white;"> -->
            <!--        <img src="<%= product.getImage() %>" alt="alt" />   -->                 <!-- class="img-fluid tm-gallery-img" -->
 <div style="word-spacing: 2em;";">                      
<h5>&nbsp;<%= product.getProductid() %>&nbsp; &nbsp;
    <%= product.getProductname() %>&nbsp;  £<%= product.getPrice() %> &nbsp;  <%= product.getQuantity() %> &nbsp; <span style="word-spacing: 0em"><%= product.getCategory() %></span>  <%= product.getDescription() %> 
 
<input type="submit" name="category" value="EDIT">
<input type="submit" name="category" value="DELETE" onclick="showAlert()">
<input type="hidden" name="productid" value="<%= product.getProductid() %>"> </h5>
 </div>       
                </form>    
                 </div> 
                <% } %>
                <% } %>                 
        
        
                            <script type="text/javascript"> 
                            function showAlert(){ 
                            alert("Record deleted successfully"); 
                            } 
                            </script> 
  
    <div class="fixed-footer">
        <div class="container">Copyright &copy; 2021 Your Company</div>        
    </div>
    </body>
</html>
