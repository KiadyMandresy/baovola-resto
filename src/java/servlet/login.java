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
import table.ListePlatCommande;
import table.Utilisateur;

/**
 *
 * @author ravonirinafitahianarandriamanantena
 */
public class login extends HttpServlet {

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
            HttpSession session = request.getSession();
            String user = request.getParameter("user");
            String mdp = request.getParameter("mdp");
            Utilisateur u = new Utilisateur();
            Utilisateur zao = u.log(user,mdp);
            if(zao.getRoleUser() == null) response.sendRedirect("login.jsp");
            if(zao.getRoleUser().compareTo("Cuisine") == 0){
                ListePlatCommande lpc = new ListePlatCommande();
                Vector liste = lpc.getListePlatCommande();
                session.setAttribute("utilisateur",zao);
                request.setAttribute("liste", liste);
                RequestDispatcher dispat = request.getRequestDispatcher("/cuisine.jsp");
                dispat.forward(request,response);
//                Utilisateur test = (Utilisateur)request.getSession().getAttribute("utilisateur");
//                out.println(test.getUsernamde());
            }
            if(zao.getRoleUser().compareTo("admin") == 0){
//                ListePlatCommande lpc = new ListePlatCommande();
//                Vector liste = lpc.getListePlatCommande();
                session.setAttribute("utilisateur",zao);
//                request.setAttribute("liste", liste);
                String view = "listeingredient.jsp";
                request.setAttribute("view", view);
                RequestDispatcher dispat = request.getRequestDispatcher("/templateAdmin.jsp");
                dispat.forward(request,response);
//                Utilisateur test = (Utilisateur)request.getSession().getAttribute("utilisateur");
//                out.println(test.getUsernamde());
            }
            if(zao.getRoleUser().compareTo("serveur") == 0){
//                ListePlatCommande lpc = new ListePlatCommande();
//                Vector liste = lpc.getListePlatCommande();
                session.setAttribute("utilisateur",zao);
//                request.setAttribute("liste", liste);
                String view = "accueil.jsp";
                request.setAttribute("view", view);
                RequestDispatcher dispat = request.getRequestDispatcher("/template.jsp");
                dispat.forward(request,response);
//                Utilisateur test = (Utilisateur)request.getSession().getAttribute("utilisateur");
//                out.println(test.getUsernamde());
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
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
