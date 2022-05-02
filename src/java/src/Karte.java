/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.Cookies;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.sun.org.apache.bcel.internal.generic.FNEG;

/**
 *
 * @author Sly Cheese
 */
//@WebServlet(name = "Karte", urlPatterns = {"/Karte"})
public class Karte extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
//     * @param request servlet request
//     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        System.out.println(" Request Processing ... ");
        
        
    HttpSession session = req.getSession(true);
       if (session == null)
        {
       res.sendRedirect("http://localhost:8080/error.html");
        }
    ArrayList list= (ArrayList)session.getAttribute("product_items");
    String action = req.getParameter("Karte").trim();
    
    
     if(action.equals("CART(i)")) 
     {
       Carte cart = getproduct_items(req);  
      if(list==null)
      {
      list = new ArrayList();
      list.add(cart);
      }
       else
      {
        boolean found = false; 
        String productname = cart.getName().trim();
        for(int i=0;i<list.size(); i++)
        {
          String name = ((Carte)list.get(i)).getName().trim();
          Carte acart = (Carte)list.get(i);
          if(productname.equals(name))
          {  
              found = true;
            acart.setQuantity(acart.getQuantity()+cart.getQuantity());
          }
          }
        if(!found)
        {
            list.add(cart);
        }
      }
      session.setAttribute("shoppingcart", list);
     //RequestDispatcher rd = getServletContext.d
     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homepage.jsp");
     dispatcher.forward(req, res);
    } //if add
     
     else if(action.equals("DELETE"))
     {
         int index = Integer.parseInt(req.getParameter("deleteindex"));
        
         list.remove(index);
         session.setAttribute("shoppingcart", list);
     //RequestDispatcher rd = getServletContext.d
     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
     dispatcher.forward(req, res); 
     }
     
     else if(action.equals("CATEL"))
     {
         
     float total =0;
          for(int i=0;i<list.size(); i++)
        {
          
          Carte acart = (Carte)list.get(i);
          total += acart.getPrice()*acart.getQuantity();
        }
          
         req.setAttribute("amount", String.valueOf(total));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Checkout.jsp");
     dispatcher.forward(req, res);  
     }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Carte getproduct_items(HttpServletRequest req) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
