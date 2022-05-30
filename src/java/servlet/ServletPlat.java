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
import javax.servlet.http.HttpSession;
import table.CategoriePlat;
import table.Commande;
import table.DetailCommande;
import table.Plat;
import table.Serveur;
import table.Utilisateur;

/**
 *
 * @author mac
 */
public class ServletPlat extends HttpServlet {

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
               
                HttpSession session = request.getSession();
                int idTable = new Integer(request.getParameter("latabatra"));
                session.setAttribute("latabatra", idTable);
                Commande c= new Commande();
                int idutil = ((Utilisateur)session.getAttribute("utilisateur")).getId();
                Serveur ss = new Serveur();       
                c.InsertCommande(idTable,ss.getServeur(idutil).getId());
                
                CategoriePlat cp = new CategoriePlat();
                Vector v = cp.getCategorie();
                request.setAttribute("listeCategorie", v);
                
                Plat p = new Plat();
                Vector plat = p.getAllPlats();
                request.setAttribute("listePlat", plat);
                
                DetailCommande dc = new DetailCommande();
                Vector listeDetail = dc.getDetail(c.getlastId());
                request.setAttribute("listeDetail", listeDetail);
                
                String view  = "accueil.jsp";
                request.setAttribute("view",view);
                RequestDispatcher dispat = request.getRequestDispatcher("/template.jsp");
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
            Logger.getLogger(ServletPlat.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletPlat.class.getName()).log(Level.SEVERE, null, ex);
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
