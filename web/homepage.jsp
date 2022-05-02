<%-- 
    Document   : homepage
    Created on : Apr 30, 2021, 10:00:07 AM
    Author     : Sly Cheese
--%>
<%@page import="src.item"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.home"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
 
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
        List<item> cart = new ArrayList();
        if(session.getAttribute("cart") != null){
          cart = (ArrayList) session.getAttribute("cart");
        } 
        
        int cartSize = cart.size();
    %>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
      <!--  <link href="css/mystyle.css" rel="stylesheet" />    -->
        <link href="css/adminheadbord.css" rel="stylesheet" /> 
    </head>
    <body>            
        <nav class="navbar navbar-inverse">
    <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Vegan Cakes</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="homepage.jsp">Home</a></li>
      
<!--      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>-->
<!--        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>-->
      </li>
<!--      <li><a href="index.jsp">Add products</a></li>-->
      <li><a href="#">Services</a></li>
      <li><a href="#">Products</a></li>
      <li><a href="about.html">About</a></li>
      <li><a href="contact.html">Contact Us</a></li>
      
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
<!--      <li><a href="Register.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>-->
<!--      <li><a href="AdminLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Admin Login</a></li>-->
      <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      <li><a href="Cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Cart ${cart.size()}</a></li>
    </ul>
    </div>
    </nav>
    
        <!--<div class="container"> -->
      <!--  <style>
        div.sticky {
          position: -webkit-sticky;
          position: sticky;
          top: 0;
          background-color: yellow;
          width: 50px;
          padding: 10px;
          font-size: 20px;
        }
        </style> -->
               
    </head>
    <body>
        <h3>Welcome to Vegan Cakes shopping center. Your stisfaction is our priority!</h3><br>
         <% if(request.getAttribute("product_items") == null) {%>
         <h1>Product Item is NULL</h1>     <br><br><br>  
                <%}else{%>
                <% List product_items = (ArrayList) request.getAttribute("product_items") ;%>
                <% for(int i=0; i < product_items.size(); i++) { %>
                                
                
                <div style="color: blue"> 
                 <form action="cartServlet" method="post" >
                <% home product = (home) product_items.get(i) ;%>
                <div class="columnIndex" style="background-color:white;"> 
                    <img src="img/<%= product.getImage() %>" alt="alt" width="170" height="150"/>                              <!-- class="img-fluid tm-gallery-img" -->
                    <h4><%= product.getProductname() %> &nbsp; |&nbsp; &nbsp; Price: £<%= product.getPrice() %></h4>                   
                    <h6>Category: <%= product.getCategory() %></h6>                
                <!--    <h6>Quantity: <%= product.getQuantity() %>  &nbsp; |&nbsp; &nbsp; Price: £<%= product.getPrice() %></h6>
                <!--    <h5>Price: £<%= product.getPrice() %></h5>  -->
                    <h5><%= product.getDescription() %></h5>  
                    <% int quantity = 0; %>
                    <% for(int u=0; u < cart.size(); u++) { %>
                    <% item unit_item = (item) cart.get(u); %>
                        <% if (unit_item.getItemid() == Integer.parseInt(product.getProductid())) { %>
                            <% quantity+=unit_item.getQuantity(); %>
                        <% } %>
                    <% } %>
                    <% if (quantity > 0) { %> 
                        <input type="number" name="quantity" value="<%= quantity %>" width="10" required ><br />
                    <% } else { %>
                     <input type="number" name="quantity" width="3" required ><br />
                    <% } %><br>
                    <button class="btn" type="submit" >Add to Cart</button>
                    <input type="hidden" name="action" value="ADD" />
                    <input type="hidden" name="productid" value="<%= product.getProductid() %>" />
                 </div> 
                 </form>
                    
                <% } %>
                <% } %>
               </div> 
               <jsp:include page="kartrin.jsp" flush="true" />
               
    <!--           < if (session.getAttribute("addToCart"))
               ListIterator lit = ((List)) session.getAttribute("")
               int a = 0;
               int total = 0;
               while (lit.hasNext()) {
               a++;
               int id = Integer.parseInt((String)) lit.next
               }
                   
               %>
               <script>
                   function addToCart(product_id) {
                       $.post("addToCartController", {
                           id: id                           
                       }, function (data, status) {
                           $(".sticky").text(data + " Items");
                       }};
                   }
               </script>
               <div class="sticky" onclick="window.location.href='kartrin.jsp'" onclick="addToCart('< product.getproductid() >
                   < 
                   if session.getAttribute(("addToCart") != null) {
                   out.print(((Last) session.getAttribute("addToCart")).size() + Items);
                   }
                   > -->
<!--               </div>-->
               
        <div class="fixed-footer">
        <div class="container">Copyright &copy; 2021 Your Company</div>        
        </div>
    </body>
    
    
    <!--<!-- <button class="btn" name="kartes(i)" value="CART(i).addActionLister(cort)">Add to Cart</button> -->
</html>
