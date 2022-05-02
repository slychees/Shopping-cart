/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Sly Cheese
 */
@WebServlet(name = "view_records", urlPatterns = {"/view_records"})
public class view_records extends HttpServlet {

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
    
//    Connection connect;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet view_records</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet view_records at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
    }
//        custclass product =  new custclass();
//        String cred = request.getParameter("credential");
//        String phone;
////        if(cred.equals("ADD")){
//        try {
//            Connection connect;
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//            connect = DriverManager.getConnection(URL, USER, PASSWORD);
//            PreparedStatement pt = (PreparedStatement) connect.prepareStatement("SELECT * FROM CUSTOMERINFO PHONENO=?");
//            
//            pt.setString(1, phone);
//            ResultSet result = pt.executeQuery();
//            
//            if(result.next()){
//                custclass product =  new custclass();
//                product.setCountry(result.getString("country"));
//                product.setFname(result.getString("fname"));
//                product.setLname(result.getString("lname"));
//                product.setAddress(result.getString("address"));
//                product.setCity(result.getString("city"));
//                product.setState(result.getString("state"));
//                product.setZip(result.getString("zip"));
//                product.setPhone(result.getString("phone"));
//                product.setEmail(result.getString("email"));
//                
//                PrintWriter out = response.getWriter();
//                out.println("SUCCESFUL");
//                request.setAttribute("product", product);
//                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//                dispatcher.forward(request, response);
//                
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(view_records.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(view_records.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        } 
}

