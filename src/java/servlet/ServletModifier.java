/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import table.DetailPlat;
import table.Ingredient;
import table.Plat;

/**
 *
 * @author Dawood
 */
public class ServletModifier extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Ingredient ingr = new Ingredient();
            DetailPlat dp = new DetailPlat();
            String message = "";
            Vector detailplat = new Vector();
            
            if(request.getParameter("idDetail")!=null && request.getParameter("plat")!=null ){
                dp.supprimerDetailPlat(new Integer(request.getParameter("idDetail")));
                detailplat = dp.getDetailPlatByPlat(new Integer(request.getParameter("plat")));
                message = "Ingredient supprime";
                request.setAttribute("idplat", new Integer(request.getParameter("plat")));
                
            }else if(request.getParameter("idingredient")!=null && request.getParameter("qte")!=null && request.getParameter("unite")!=null){
                
                int idplat = new Integer(request.getParameter("idplat"));
                int idingredient = new Integer(request.getParameter("idingredient"));
                double qte = new Double(request.getParameter("qte"));
                String unite = request.getParameter("unite");
                dp.insertDetailPlat(idplat, idingredient, qte, unite);
                detailplat = dp.getDetailPlatByPlat(idplat);
                request.setAttribute("idplat", idplat);
                message = "Ingredient ajoute";
                
            }else{
                
                int idplat = new Integer(request.getParameter("idplat"));
                detailplat = dp.getDetailPlatByPlat(idplat);
                message = "Bienvenue au modification d'ingredient de ce plat";
                request.setAttribute("idplat", idplat);
            }
            
            Vector liste = ingr.getAllIngredient();
            String view = "modifieringredient.jsp";
            
                    
            request.setAttribute("ingredient", liste);
            request.setAttribute("message", message);
            request.setAttribute("detailplat", detailplat);
            request.setAttribute("view",view);
            
            
            RequestDispatcher dispat = request.getRequestDispatcher("/templateAdmin.jsp");
            dispat.forward(request,response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletModifier.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ServletModifier.class.getName()).log(Level.SEVERE, null, ex);
        }
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

}
