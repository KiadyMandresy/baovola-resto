/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import connex.Connex;
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
import table.DetailCommande;
import table.IngredientPlat;
import table.ListePlatCommande;
import table.StockIngredient;

/**
 *
 * @author ravonirinafitahianarandriamanantena
 */
public class attribuer extends HttpServlet {

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
            StockIngredient si = new StockIngredient();
            IngredientPlat ip = new IngredientPlat();
            DetailCommande dc = new DetailCommande();
            String idS = (String)request.getParameter("serveur");
            String idD = (String)request.getParameter("id");
            String idP = (String)request.getParameter("idPlat");
            String q = (String)request.getParameter("qte");
            int idServeur = new Integer(idS);
            int idDet = new Integer(idD);
            int idPlat = new Integer(idP);
            int qte = new Integer(q);
            dc.attribuerServeur(idDet, idServeur);
            Vector ing = ip.getIngredientPlat(idPlat);
            for(int i=0;i<ing.size();i++){
                IngredientPlat inp = (IngredientPlat)(ing.get(i));
                double quantite = inp.getQuantite()*qte;
                si.sortie(inp.getIdIngredient(), quantite);
            }
            
            ListePlatCommande lpc = new ListePlatCommande();
            Vector liste = lpc.getListePlatCommande();
            request.setAttribute("liste", liste);
            RequestDispatcher dispat = request.getRequestDispatcher("/cuisine.jsp");
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
            Logger.getLogger(attribuer.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(attribuer.class.getName()).log(Level.SEVERE, null, ex);
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
