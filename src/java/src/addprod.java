package src;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Sly Cheese
 */
@WebServlet(urlPatterns = {"/addprod"})
@MultipartConfig                    //Tells the the servlet that an image MUST be included to it
public class addprod extends HttpServlet {

    String URL = "jdbc:derby://localhost:1527/sample";
    String USER = "app";
    String PASSWORD ="app";
    
    
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
    final Part imagePart = request.getPart("uploadedFile");
    String ardcake = request.getParameter("addck");  //Declare a variable to hold the hidden button name "practic"
    String folder = "C:\\Users\\Sly Cheese\\Documents\\NetBeansProjects\\CW3\\web\\img";
            
    if(ardcake.equals("cks")){                     //Check if the declared variable (ardcake) = form hidden value "cks"
//            register the user
             try{
                 String image = (String) getFileName(imagePart);
                 OutputStream add;
                 InputStream imagecontent;
                 add = new FileOutputStream(new File(folder+File.separator+image));
                 imagecontent = imagePart.getInputStream();
                 int access = 0;
                 final byte[] imageSize = new byte[1024];
                 while ((access = imagecontent.read(imageSize)) != -1){
                     add.write(imageSize, 0, access);
                 }
                 Connection con;
                 Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                 con = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement sta = (Statement) con.createStatement();
                 sta.executeUpdate("INSERT INTO CAKES (PRODUCTID,PRODUCTNAME,CATEGORY,QUANTITY,PRICE,DESCRIPTION,IMAGE)values('"+productid+"','"+productname+"','"+category+"','"+qty+"','"+price+"','"+description+"','"+image+"')");
                 response.sendRedirect("index.jsp");
//                 PrintWriter out = response.getWriter();
//                out.println("SUCCESFUL");
             }catch (SQLException err){
                 PrintWriter out = response.getWriter();
                 out.println(err);
                 out.println("ERROR !");
             } catch (ClassNotFoundException ex) {
                 PrintWriter out = response.getWriter();
                 out.println(ex);
                 out.println("ERROR 2");
            }

    }else{
        PrintWriter out = response.getWriter();
        out.println("SUCCESFUL");
    }
    }

}
