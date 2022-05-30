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
import table.Plat;

/**
 *
 * @author Dawood
 */
public class ServletModifierPlat extends HttpServlet {

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
            if( request.getParameter("idcategorie")!=null && request.getParameter("nom")!=null && request.getParameter("prix")!=null ){
                int id = new Integer(request.getParameter("idplat"));
                int categorie = new Integer( request.getParameter("idcategorie") );
                String nom = request.getParameter("nom");
                double prix = new Double(request.getParameter("prix"));
                Plat plat = new Plat();
                try{
                    plat.update(id, nom, prix, categorie);
                    RequestDispatcher dispat = request.getRequestDispatcher("/ServletListePlat");
                    dispat.forward(request,response);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                
            }else{
                int id = new Integer(request.getParameter("idplat"));
                Plat plat = new Plat();
                CategoriePlat ct = new CategoriePlat();

                Vector categorie = ct.getAllCategorie();
                plat = plat.getPlat(id);

                request.setAttribute("categorie", categorie);
                request.setAttribute("plat", plat);
                String view = "modifierplat.jsp";

                request.setAttribute("view",view);
                RequestDispatcher dispat = request.getRequestDispatcher("/templateAdmin.jsp");
                dispat.forward(request,response);
            }
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
            Logger.getLogger(ServletModifierPlat.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletModifierPlat.class.getName()).log(Level.SEVERE, null, ex);
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