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
@WebServlet(name = "CustPayOut", urlPatterns = {"/CustPayOut"})
public class CustPayOut extends HttpServlet {
    
    String URL = "jdbc:derby://localhost:1527/sample";
    String USER = "app";
    String PASSWORD ="app";
    private String phone;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            /* TODO output your page here. You may use following sample code. */
            
        
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
//        try{
//        Connection connect;
//        response.setContentType("text/html");
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//        connect = DriverManager.getConnection(URL, USER, PASSWORD);
//        PreparedStatement prep = (PreparedStatement) connect.prepareStatement("SELECT * FROM CUSTOMERINFO");
//        ResultSet rs = prep.executeQuery();
//        PrintWriter out = response.getWriter();
//        out.println("<html><body><table><tr><td>Country</td><td>First Name</td><td>Last Name</td><td>Address</td><td>City</td><td>State</td><td>Zip</td><td>Phone</td><td>Email</td><td>Item Purchased</td><td>Quantity</td><td>Price</td><td>Total Price</td>");
//
//        custclass product =  new custclass();
//        String cred = request.getParameter("credential");
        
        
        String cred = request.getParameter("credential");
//        InputStream inputStream = null;	// input stream of the upload file
        if (cred.equals("CHECK_OUT")){
             try {
             Connection connect;
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                connect = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement prep = (PreparedStatement) connect.prepareStatement("SELECT * FROM CUSTOMERINFO");
                prep.setString(1, phone);
                ResultSet result = prep.executeQuery();
                if(result.next()){
                custclass product =  new custclass();
                product.setCountry(result.getString("country"));
                product.setFname(result.getString("fname"));
                product.setLname(result.getString("lname"));
                product.setAddress(result.getString("address"));
                product.setCity(result.getString("city"));
                product.setState(result.getString("state"));
                product.setZip(result.getString("zip"));
                product.setPhone(result.getString("phone"));
                product.setEmail(result.getString("email"));
                product.setItempurchased(result.getString("itempurchased"));
                product.setQuantity(result.getString("quantity"));
                product.setPrice(result.getString("price"));
                product.setTotalprice(result.getString("totalprice"));
                
                
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
                    
                    PrintWriter out = response.getWriter();
                    out.println("SUCCESFUL");
                    request.setAttribute("product", product);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("updaterecord.jsp");
                    dispatcher.forward(request, response);
                    
                
            
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

//    private static class result {
//
//        private static String getString(String country) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        public result() {
//        }
//    }

}           catch (ClassNotFoundException ex) {
                Logger.getLogger(CustPayOut.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CustPayOut.class.getName()).log(Level.SEVERE, null, ex);
            }}}}