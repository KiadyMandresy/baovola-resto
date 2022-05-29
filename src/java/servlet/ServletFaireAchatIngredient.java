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
import table.Ingredient;
import table.ResteIngredient;
import table.StockIngredient;

/**
 *
 * @author Dawood
 */
public class ServletFaireAchatIngredient extends HttpServlet {

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
            Vector liste = ingr.getAllIngredient();
            String message= null;
            request.setAttribute("liste", liste);
            
            if(request.getParameter("idingredient")!=null && request.getParameter("qte")!=null){
                StockIngredient si = new StockIngredient();
                int idingr = new Integer( request.getParameter("idingredient") );
                int qte = new Integer( request.getParameter("qte") );
                ingr = ingr.getIngredient(idingr);
                try{
                    si.entree(idingr, qte);
                    ResteIngredient reste = new ResteIngredient();
                    double resteIngredient = reste.resteIngredient(idingr);
                    message = "Le stock de "+ingr.getNom()+" est maintenant de "+resteIngredient;
                }catch(Exception ex){
                    message = "Le stock de "+ingr.getNom()+" n'a pas bouge ";
                    ex.printStackTrace();
                }
            }
            request.setAttribute("message", message);
            
            String view = "faireachatingredient.jsp";
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
            Logger.getLogger(ServletFaireAchatIngredient.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletFaireAchatIngredient.class.getName()).log(Level.SEVERE, null, ex);
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
