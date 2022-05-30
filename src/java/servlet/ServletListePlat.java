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
import table.DetailPlat;
import table.Plat;

/**
 *
 * @author Dawood
 */
public class ServletListePlat extends HttpServlet {

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
            Plat plat = new Plat();
            CategoriePlat catplat= new CategoriePlat();
            Vector liste = new Vector();
            Vector categorie = catplat.getAllCategorie();
            
            if(request.getParameter("suppr")!=null){
                int idplat = new Integer(request.getParameter("suppr"));
                DetailPlat dp = new DetailPlat();
                Vector detailplat = dp.getDetailPlatByPlat(idplat);
                for(int i=0;i<detailplat.size();i++){
                    dp.supprimerDetailPlat( ((DetailPlat)detailplat.get(i)).getId() );
                }
                plat.deletePlat(idplat);
                liste = plat.getAllPlats();
            }
            if(request.getParameter("cat")!=null){
                int idcat = new Integer(request.getParameter("cat"));
                liste = plat.getPlatsByCat(idcat);
            }
            else if(request.getParameter("rech")!=null){
                String mot = request.getParameter("rech");
                liste = plat.recherchePlat(mot);
            }
            else{
                liste = plat.getAllPlats();
            }
            
            request.setAttribute("liste", liste);
            request.setAttribute("cat", categorie);
            
            String view = "listeplat.jsp";
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
            Logger.getLogger(ServletListePlat.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletListePlat.class.getName()).log(Level.SEVERE, null, ex);
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
