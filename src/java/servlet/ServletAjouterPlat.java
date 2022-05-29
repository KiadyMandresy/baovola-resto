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
import table.CategoriePlat;
import table.Ingredient;
import table.Plat;

/**
 *
 * @author Dawood
 */
public class ServletAjouterPlat extends HttpServlet {

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
            CategoriePlat cp = new CategoriePlat();
            Plat plat = new Plat();
            Vector liste = cp.getAllCategorie();
            request.setAttribute("liste", liste);
            String view = "ajoutplat.jsp";
            String message ="";
            
            if(request.getParameter("des")!=null && request.getParameter("prix")!=null && request.getParameter("idcategorie")!=null){
                String des = request.getParameter("des");
                double prix = new Double(request.getParameter("prix"));
                int cat = new Integer(request.getParameter("idcategorie"));
                Ingredient ingr = new Ingredient();
                try{
                    view = "ajoutingredient.jsp";
                    message="Ajout de nouveau plat reussi";
                    plat.insertPlat(des, prix, cat);
                    plat = plat.getLastPlat();
                    Vector listeIngr = ingr.getAllIngredient();
                    
                    request.setAttribute("ingredient", listeIngr);
                    request.setAttribute("idplat", plat.getId());
                    
                }catch(Exception ex){
                    view = "ajoutplat.jsp";
                    message = "L' ajout de ce plat a echoue";
                }
                request.setAttribute("message", message);
            }
            
            
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
            Logger.getLogger(ServletAjouterPlat.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletAjouterPlat.class.getName()).log(Level.SEVERE, null, ex);
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
