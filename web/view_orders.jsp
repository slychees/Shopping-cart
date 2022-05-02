<%-- 
    Document   : view_orders
    Created on : May 22, 2021, 10:10:35 AM
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
<%@page import="src.custclass"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/adminheadbord.css" rel="stylesheet" />
        
        <title>JSP Page</title>
         <%
    String URL = "jdbc:derby://localhost:1527/sample";
    String USER = "app";
    String PASSWORD ="app";
    try{
        Connection connect;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        connect = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement pt = (PreparedStatement) connect.prepareStatement("SELECT * FROM CUSTOMERINFO");
        ResultSet result = pt.executeQuery();
        List <custclass> order_items = new ArrayList();
        while(result.next()){
            custclass product =  new custclass();
//            product.setCountry(result.getString("country"));
            product.setCountry(result.getString("country"));
            product.setFname(result.getString("fname"));
            product.setLname(result.getString("lname"));
            product.setAddress(result.getString("address"));
            product.setCity(result.getString("city"));
            product.setState(result.getString("state"));
            product.setZip(result.getString("zip"));
            product.setPhone(result.getString("phoneno"));
            product.setEmail(result.getString("email"));
            product.setItempurchased(result.getString("itempurchased"));
            product.setQuantity(result.getString("quantity"));
            product.setPrice(result.getString("price"));
            product.setTotalprice(result.getString("totalprice"));            
            order_items.add(product);
        }
        request.setAttribute("order_items", order_items);
    }catch(SQLException e){
        PrintWriter print = response.getWriter();
        print.println(e);
    }catch (ClassNotFoundException ex){
        PrintWriter print = response.getWriter();
        print.println(ex);
    }
    %>
    
    
    
    </head>
    <body>
        <h2> </h2><br>
        
        <%@ include file="header.jsp" %>

        
        <br><h2>View Orders</h2> <br>
        

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

<div style="word-spacing: 1.5em;"><h4><span style="word-spacing: 0em">First Name</span> &nbsp;&nbsp;<span style="word-spacing: 0em">Last Name</span> 
      &nbsp;  Address &nbsp; City   &nbsp;   Zip &nbsp; <span style="word-spacing: 0em">Phone No</span> &nbsp; E-mail &nbsp;&nbsp;<span style="word-spacing: 0em">Item purchased</span>     Quantity    Price <span style="word-spacing: 0em">Total Price</span></h4>  </div>
         <% if(request.getAttribute("order_items") == null) {%>
        <h1>Product Item is NULL</h1>     <br><br><br>  

                <%}else{%>
         
                <% List order_items = (ArrayList) request.getAttribute("order_items") ;%>
            <!--    <%= order_items.size() %> -->
                <% for(int i=0; i < order_items.size(); i++) { %>
                <div style="color: blue">
                    <form action="CustPayOut" method="post" >
                <% custclass product = (custclass) order_items.get(i); %>
            <!--    <div class="column" style="background-color:white;"> -->
            <!--        <img src="<%= product.getCountry() %>" alt="alt" />   -->                 <!-- class="img-fluid tm-gallery-img" -->
 <div style="word-spacing: 1em;";">                      
<h5> &nbsp;<%= product.getFname() %> &nbsp; &nbsp; &nbsp; <%= product.getLname() %> &nbsp; &nbsp; &nbsp; <span style="word-spacing: 0em"> <%= product.getAddress() %></span> &nbsp;&nbsp; <%= product.getCity() %> &nbsp; <%= product.getZip() %> &nbsp;&nbsp; <%= product.getPhone() %>&nbsp;&nbsp; <%= product.getEmail() %> &nbsp; &nbsp;<%= product.getItempurchased()%>  &nbsp;&nbsp; <%= product.getQuantity()%> &nbsp;&nbsp;&nbsp;<%= product.getPrice()%>&nbsp;&nbsp; <%= product.getTotalprice()%>
 

<!-- <input type="submit" name="category" value="PAYOUTS" onclick="showAlert()"> -->
<input type="hidden" name="PAY_OUT" value="<%= product.getPhone() %>"> </h5>
<input type="hidden" name="CHECK_OUT" value="credential"> </h5>
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
        
                            
                            
                            <br><br>                      
                            
<!--    <sql:setDataSource 
        var = "myDS" 
          driver = "org.apache.derby.jdbc.ClientDriver"
         url = "jdbc:derby://localhost:1527/sample" 
         String USER = "app" 
         String PASSWORD ="app";/>
    
         
 
      <sql:query var="list_users" dataSource="${myDS}">
        SELECT * FROM CUSTOMERINFO;
      </sql:query>
      
      
    
 
      <table border = "1" width = "100%">
         <tr>
             <th>Country</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>City</th>
            <th>State</th>
            <th>Zip</th>
            <th>Phone No</th>
            <th>Email</th>
            <th>Item Purchased</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total Price</th>
            
         </tr>
         
         

         
         </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.country}" /></td>
                    <td><c:out value="${user.fname}" /></td>
                    <td><c:out value="${user.lname}" /></td>
                    <td><c:out value="${user.Address}" /></td>
                    <td><c:out value="${user.City}" /></td>
                    <td><c:out value="${user.State}" /></td>
                    <td><c:out value="${user.Zip}" /></td>
                    <td><c:out value="${user.Phone}" /></td>
                    <td><c:out value="${user.Email}" /></td>
                    <td><c:out value="${user.Itempurchased}" /></td>
                    <td><c:out value="${user.Quantity}" /></td>
                    <td><c:out value="${user.Price}" /></td>
                    <td><c:out value="${user.Totalprice}" /></td>
                
                </tr>
            </c:forEach>
      </table>-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <link href="css/adminheadbord.css" rel="stylesheet" />
        
    </body>
</html>
