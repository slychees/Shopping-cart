/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Statement;  /** Very important for MYSQL connection */
import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sly Cheese
 */
@WebServlet(name = "RegSign", urlPatterns = {"/RegSign"})
public class RegSign extends HttpServlet {
    String URL = "jdbc:derby://localhost:1527/sample";
    String USER = "app";
    String PASSWORD ="app";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cred = request.getParameter("credential");
        String payouts = request.getParameter("category");
        if(cred.equals("logout")){
            HttpSession session = request.getSession(false);
            if(session != null){
                session.removeAttribute("username");
                session.removeAttribute("email");
                session.removeAttribute("password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
                dispatcher.forward(request, response);
            }
        }
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//      Add global variables here. From the active form
        String username = request.getParameter("username");
        String email =  request.getParameter("email");
        String password =  request.getParameter("password");
        String cpassword =  request.getParameter("confirmpassword");
        
//        custclass product =  new custclass();
        String country = request.getParameter("country");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String phone = request.getParameter("phone");
        String cus_email = request.getParameter("email");
//        String cus_info = request.getParameter("category");
//      Get inputs from product page
//        String productid = request.getParameter("product_id");
//        String productname = request.getParameter("productname");
//        String category = request.getParameter("category");
//        String quantity = request.getParameter("quantity");
//        String price = request.getParameter("price");        
//        String description = request.getParameter("description");
        String cred = request.getParameter("credential");
//        InputStream inputStream = null;	// input stream of the upload file
        if(cred.equals("register")){
//            register the user
             try{
                 Connection connect;
                 Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                 connect = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement st = (Statement) connect.createStatement();
                 st.executeUpdate("INSERT INTO REGISTER (USERNAME,EMAIL,PASSWORD,CPASSWORD) VALUES ('"+username+"','"+email+"','"+password+"','"+cpassword+"')");
//                 response.sendRedirect("signin.jsp");
                 response.sendRedirect("homepage.jsp");
                 connect.close();
                 
             }catch (SQLException | ClassNotFoundException err){
                 response.sendRedirect("Login.jsp");
                 PrintWriter out = response.getWriter();
                 out.println(err);
             }
             
        }
        else if(cred.equals("sign_in")){
             try{
                 Connection connect;
                 Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                 connect = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pt = (PreparedStatement) connect.prepareStatement ("SELECT * FROM REGISTER WHERE email=? and password=?");
                 pt.setString(1, email);
                 pt.setString(2, password);
                 ResultSet result = pt.executeQuery();
                 if(result.next()){
                     HttpSession session = request.getSession();
                     session.setAttribute("username", result.getString("username"));
                     session.setAttribute("email", result.getString("email"));
                     session.setAttribute("password", result.getString("password"));
                     if(result.getBoolean("is_admin")){
                        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                        dispatcher.forward(request, response);
                     }else{
                        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
                        dispatcher.forward(request, response);     
                     }
                     
                 }else{
                     request.setAttribute("error", "Email or password is incorrect");
                     RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                     dispatcher.forward(request, response);
                 }
             }catch (SQLException err){
                 PrintWriter out = response.getWriter();
                 out.println(err);
             } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegSign.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
//         if (cred.equals("CHECK_OUT")){
//             try {
//             Connection connect;
//                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//                connect = DriverManager.getConnection(URL, USER, PASSWORD);
//                PreparedStatement pt = (PreparedStatement) connect.prepareStatement("SELECT * FROM CUSTOMERINFO PHONENO=?");
//                pt.setString(1, phone);
//                ResultSet result = pt.executeQuery();
//                
//                if(result.next()){
//                    custclass product =  new custclass();
//                    product.setCountry(result.getString("country"));
//                    product.setFname(result.getString("fname"));
//                    product.setLname(result.getString("lname"));
//                    product.setAddress(result.getString("address"));
//                    product.setCity(result.getString("city"));
//                    product.setState(result.getString("state"));
//                    product.setZip(result.getString("zip"));
//                    product.setPhone(result.getString("phone"));
//                    product.setEmail(result.getString("email"));
//                    
//                    PrintWriter out = response.getWriter();
//                    out.println("SUCCESFUL");
//                    request.setAttribute("product", product);
//                    RequestDispatcher dispatcher = request.getRequestDispatcher("updaterecord.jsp");
//                    dispatcher.forward(request, response);
//                    
//                } 
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(RegSign.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SQLException ex) {
//                Logger.getLogger(RegSign.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            }
             }
}
//                else if(cred.equals("add_product")){
////            add code to register
//                try{
//                 Connection connect;
//                 Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//                 connect = DriverManager.getConnection(URL, USER, PASSWORD);
//                 Statement st = (Statement) connect.createStatement();
//                 st.executeUpdate("INSERT INTO products (product_id,product_name,category,quantity,price,description) VALUES ('"+productid+"','"+productname+"','"+category+"','"+quantity+"','"+price+"','"+description+"')");
//                 response.sendRedirect("signin.jsp");
//             }catch (SQLException err){
//                 PrintWriter out = response.getWriter();
//                 out.println(err);
//             } catch (ClassNotFoundException ex) {
//                 PrintWriter out = response.getWriter();
//                 out.println(ex);
//            }
//        }
   

