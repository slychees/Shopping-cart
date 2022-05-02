/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

/**
 *
 * @author Sly Cheese
 */
@WebServlet(name = "updaterecord", urlPatterns = {"/updaterecord"})
//@MultipartConfig
public class updaterecord extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String URL = "jdbc:derby://localhost:1527/sample";
    String USER = "app";
    String PASSWORD ="app";
    
    Connection connect;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
 //   String practice = request.getParameter("practice");
    
    
             }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    
    private String getFileName(final Part image) {
        for (String content:image.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"","");
        }
        }
        return null;

        }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String productid = request.getParameter("productid");
    String productname =  request.getParameter("productname");
    String category =  request.getParameter("category");
    String qty =  request.getParameter("quantity");
    String price =  request.getParameter("price");
    String description =  request.getParameter("description");
//    final Part imagePart = request.getPart("uploadedFile");
    String ardcake = request.getParameter("category");  //Declare a variable to hold the hidden button name "practic"
    String folder = "C:\\Users\\Sly Cheese\\Documents\\NetBeansProjects\\CW3\\web\\img";
            
    if(category.equals("UPDATE")){                     //Check if the declared variable (ardcake) = form hidden cks
//            register the user
//             try{
//                 String image = (String) getFileName(imagePart);
//                 OutputStream add;
//                 InputStream imagecontent;
//                 add = new FileOutputStream(new File(folder+File.separator+image));
//                 imagecontent = imagePart.getInputStream();
//                 Connection con;
//                 Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//                 con = DriverManager.getConnection(URL, USER, PASSWORD);
//                 Statement sta = (Statement) con.createStatement();
//                 sta.executeUpdate("UPDATE CAKES (PRODUCTID,PRODUCTNAME,CATEGORY,QUANTITY,PRICE,DESCRIPTION,IMAGE)values('"+productid+"','"+productname+"','"+category+"','"+qty+"','"+price+"','"+description+"','"+image+"')");
////                 response.sendRedirect("index.html");
//                PrintWriter out = response.getWriter();
//                out.println("SUCCESFUL");
//             }catch (SQLException err){
//                 PrintWriter out = response.getWriter();
//                 out.println(err);
//                 out.println("ERROR !");
//             } catch (ClassNotFoundException ex) {
//                 PrintWriter out = response.getWriter();
//                 out.println(ex);
//                 out.println("ERROR 2");
//            }

    }else if(category.equals("EDIT")){         //Sends the record to the form for update
            try{
//                Connection connect;
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                connect = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement pt = (PreparedStatement) connect.prepareStatement("SELECT * FROM CAKES WHERE productid=?");
                pt.setString(1, productid);
                ResultSet result = pt.executeQuery();
                if(result.next()){
                    home product =  new home();
                    product.setProductid(result.getString("productid"));
                    product.setProductname(result.getString("productname"));
                    product.setCategory(result.getString("category"));
                    product.setQuantity(result.getString("quantity"));
                    product.setPrice(result.getInt("price"));
                    product.setDescription(result.getString("description"));
                    product.setImage(result.getString("image"));
                    
                    request.setAttribute("product", product);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("updaterecord.jsp");
                    dispatcher.forward(request, response);
                    
                }
            }catch(SQLException e){
                PrintWriter print = response.getWriter();
                print.println(e);
                print.println("1");
            }catch (ClassNotFoundException ex){
                PrintWriter print = response.getWriter();
                print.println(ex);
                print.println("2");
            }
    }else if(category.equals("DELETE")){
        try
    {
      // create the JDB connection
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
           
      Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
      
      // create the mysql delete statement.
      // i'm deleting the row where the id is "3", which corresponds to my
      // "Barney Rubble" record.
      String sql = "DELETE FROM CAKES WHERE productid=?";
      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      preparedStmt.setString(1, productid);

      // execute the preparedstatement
      preparedStmt.execute();
      response.sendRedirect("view_records.jsp");
//      PrintWriter out = response.getWriter();
//      out.println("SUCCESFUL");
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    }

    
}}

    



