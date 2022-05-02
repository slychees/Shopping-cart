<%-- 
    Document   : Cart
    Created on : May 1, 2021, 1:12:23 PM
    Author     : Sly Cheese
--%>

<%@page import="src.item"%>
<%@page import="src.home"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
      <!--  <link href="css/adminheadbord.css" rel="stylesheet" /> -->
        <title>JSP Page</title>
    </head>
    
        
        
        
        
        
        <table border="0" cellpadding="0" width="97%" bgcolor="green">
                    <tr>
                    <td><b>PRODUCT ID</b></td>
                    <td><b>PRODUCT NAME</b></td>
                    <td><b>IMAGE &nbsp; &nbsp; &nbsp; &nbsp; </b></td>
                    <td><b>CATEGORY</b></td>
                    <td><b>QUANTITY &nbsp; &nbsp; &nbsp; </b></td>
                    <td><b>PRICE &nbsp; &nbsp; &nbsp; &nbsp; </b></td>
                    <td><b>Quantity in Cart | Total Price for</b></td>
                    </tr>
                </table>   
    
        <% if(session.getAttribute("cart") == null) {%>
         <h1>Product Item is NULL</h1>     <br><br><br>  
                <%}else{%>
                <% List cart = (ArrayList) session.getAttribute("cart") ;%>
                <% int total_price = 0 ;%>
                <% for(int i=0; i < cart.size(); i++) { %>
                          
               
                 <form name="shoppingC" action="cartServlet" method="post" >
                     
                     
                <% item product = (item) cart.get(i) ;%>
                <% total_price +=  product.getItem().getPrice() * product.getQuantity() ;%>
                 
                 
                 <div class="row">
                     <div class="col-md"><%= product.getItem().getProductid() %></div>                     
                     <div class="col-md"><%= product.getItem().getProductname() %> </div>
                     <div class="col-md"><img src="img/<%= product.getItem().getImage() %>" alt="alt" width="70" height="50"/></div>
                     <div class="col-md"><%= product.getItem().getCategory() %></div>
                     <div class="col-md"><%= product.getQuantity()%></div>
                     <div class="col-md">£<%= product.getItem().getPrice() %></div>
                     <div class="col-md"><%= product.getQuantity() %> in cart | Total Price: <%= product.getItem().getPrice() * product.getQuantity() %></div>
                     <div class="col-md"><button type="submit" class="btn btn-light"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">
                         <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/> 
                         </svg></button></div>
                     <input type="hidden" name="productid" value="<%= product.getItem().getProductid()  %>">
                     <input type="hidden" name="action" value="DELETE">
                     <br>
                     <hr>
                     <br>
                 </div>
                 
                 </form>
                    
                <% } %>
                    OVERALL TOTAL PRICE: <%= total_price  %>
                    <form action="cartServlet" method="post">
                        <input type="submit" value="CHECKOUT">
                        <input type="hidden" name="ordertotal" value="<%= total_price  %>">                        
                        <input type="hidden" name="action" value="CHECKOUT">
                        
                    </form>
                <% } %>
                
    </body>
</html>