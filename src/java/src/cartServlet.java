/*
 * To change this template, choose Tools | Templates
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
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.css.StyleOrigin.USER;
import static javax.management.remote.JMXConnectorFactory.connect;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.http.Part;
import src.Carte;
import src.home;

/**
 *
 * @author nazaraf
 */
@WebServlet(name = "cartServlet", urlPatterns = {"/cartServlet"})
public class cartServlet extends HttpServlet {
    List<item> dict = new ArrayList();
    List all_items =  new ArrayList();
    
    String URL = "jdbc:derby://localhost:1527/sample";
    String USER = "app";
    String PASSWORD ="app";
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

    }
     

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        String a = request.getParameter("karte");               
        String productid = request.getParameter("productid");
        String act = request.getParameter("action");
        String id = request.getParameter("productid");
        String qtycake = request.getParameter("quantity");
        String ordertotal = request.getParameter("ordertotal");
        if(act.equals("ADD")){
            String URL = "jdbc:derby://localhost:1527/sample";
            String USER = "app";
            String PASSWORD ="app";
            try{
                Connection connect;
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
                    

                    if(all_items.contains(id)){
                        for(int i=0; i < dict.size(); i++) { 
                            String item_id = (String) all_items.get(i);
                            if(item_id.equals(id)){
                                item unit_item = new item();
                                unit_item.setItem(product);
                                unit_item.setQuantity(Integer.parseInt(qtycake));
                                unit_item.setItemid(Integer.parseInt(id));
                                dict.set(i, unit_item);
                            }
                        }
                    }else{
                        item unit_item = new item();
                        unit_item.setItem(product);
                        unit_item.setQuantity(Integer.parseInt(qtycake));
                        unit_item.setItemid(Integer.parseInt(id));
                        dict.add(unit_item);
                        all_items.add(id);
                    }
                    request.getSession().setAttribute("cart", dict);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
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
                

            request.getSession().setAttribute("cart", dict);            

        }else if(act.equals("DELETE")){
            for(int i=0; i < dict.size(); i++) { 
                item item = (item) dict.get(i);
                if(item.getItemid() == Integer.parseInt(id)){
                    dict.remove(item);
                }
            }
             for(int i=0; i < all_items.size(); i++) { 
                String item_id = (String) all_items.get(i);
                if(item_id.equals(id)){
                    all_items.remove(item_id);
                }
            }
            request.getSession().setAttribute("cart", dict);            
//            request.setAttribute("total_price" = qty + cakeprice);
            RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
            rd.forward(request, response);
        }else if(act.equals("CHECKOUT")){
            request.setAttribute("ordertotal", ordertotal);  
            request.getSession().setAttribute("cart", dict);    
//            request.setAttribute("total_price" = qty + cakeprice);
            RequestDispatcher rd = request.getRequestDispatcher("checkout_1.jsp");
            rd.forward(request, response);
        }else if(act.equals("PAY")){
            
                    custclass cust =  new custclass();
                    String country = request.getParameter("country");
                    String first_name =  request.getParameter("first_name");
                    String last_name =  request.getParameter("last_name");
                    String address =  request.getParameter("address");
                    String city =  request.getParameter("city");
                    String state =  request.getParameter("state");
                    String zip =  request.getParameter("zip_code");                    
                    String email =  request.getParameter("email_address");
                    String phone =  request.getParameter("phone_number");
                    String quantity =  request.getParameter("quantity");
                    String itempurchased =  request.getParameter("itempurchased");
                    String price =  request.getParameter("price");
                    String totalprice =  request.getParameter("ordertotal");                     
                    String cust_info = request.getParameter("ACTIONS");  //Declare a variable to hold the hidden button name "ACTIONS"
                try{    
                Connection connect;
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                connect = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement sta = (Statement) connect.createStatement();
                sta.executeUpdate("INSERT INTO CUSTOMERINFO (COUNTRY,FNAME,LNAME,ADDRESS,CITY,STATE,ZIP,EMAIL,PHONENO,QUANTITY,ITEMPURCHASED,PRICE,TOTALPRICE)values('"+country+"','"+first_name+"','"+last_name+"','"+address+"','"+city+"','"+state+"','"+zip+"','"+email+"','"+phone+"','"+quantity+"','"+itempurchased+"','"+price+"','"+totalprice+"')");
                
//                RequestDispatcher rd = request.getRequestDispatcher("checkout_1.jsp");
//            alert("Success");
//              JoptionPane.showMessageDialog(null, "Thanks for your patronage");
            response.sendRedirect("homepage.jsp");
            
            } catch (ClassNotFoundException ex) {
               PrintWriter prn = response.getWriter();
               prn.println(ex);
            } catch (SQLException ex) {
               PrintWriter prn = response.getWriter();
               prn.println(ex);
            }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//
//    private void alert(String success) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}}
