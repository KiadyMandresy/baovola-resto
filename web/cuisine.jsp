<%-- 
    Document   : cuisine
    Created on : 26 mai 2022, 15:49:22
    Author     : ravonirinafitahianarandriamanantena
--%>
<%@page import="table.ListePlatCommande"%>
<%@page import="table.Utilisateur"%>
<%@page import="java.util.Vector"%>
<%
   Utilisateur u = (Utilisateur)request.getSession().getAttribute("utilisateur");
   if(u.getRoleUser().compareTo("Cuisine") != 0) response.sendRedirect("login.jsp");
   Vector liste = (Vector)request.getAttribute("liste");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuisine</title>
    </head>
    <body>
    <center>
        <div style="float:left;margin-left: 15%;">
            <h4>Cuisine - Plat à preparer</h4>
            </br>
            <form action="filtrer" nethod="post">
                <p>
                    <input type="datetime-local" name="date1"/>
                    <input type="datetime-local" name="date2"/>
                    <div class="mt-3">
                        <input class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" type="submit"/>
                    </div>
                </p>
            </form>
            </br>
            <div class="table-responsive">
            <table class="table">
                <thead>
                    <th>Plat</th>
                    <th>Date</th>
                    <th>Quantite</th>
                    <th></th>
                </thead>
                <% for(int i = 0; i<liste.size();i++) { 
                    ListePlatCommande l = (ListePlatCommande)(liste.get(i));
                %>
                <tbody>
                    <tr>
                        <td><% out.println(l.getDesignation()); %></td>
                        <td><% out.println(l.getDate()); %></td>
                        <td><% out.println(l.getQuantite()); %></td>
                        <td><a href="cuisine?id=<% out.println(l.getId());%>">Terminer</a></td>
                    </tr>
                </tbody>
                <% } %>
            </table>
            </div>
        </div>
        <% if((String)request.getAttribute("misy") != null){ 
            Vector plat = (Vector)request.getAttribute("plat");
            ListePlatCommande l = (ListePlatCommande)(plat.get(0));
            Vector serveur = (Vector)request.getAttribute("serveur");
        %>
        <div style="float:right;margin-right: 15%;">
            <p><h4>Plat : <% out.println(l.getDesignation()); %></h4></p>
            </br>
            </br>
            <form action="attribuer" method="post">
                <h4>Attribuer au serveur</h4>
                <select name="serveur">
                    <% for(int i = 0;i<serveur.size();i++) { 
                        Utilisateur s = (Utilisateur)(serveur.get(i));
                    %>
                        <option value="<%=s.getId() %>"><% out.println(s.getUsernamde()); %></option>
                    <% } %>
                </select>
                <input type="hidden" name="qte" value="<%=l.getQuantite() %>"/>
                <input type="hidden" name="idPlat" value="<%=l.getIdPlat() %>"/>
                <input type="hidden" name="id" value="<%=l.getId() %>"/>
                <div class="mt-3">
                    <input class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" type="submit"/>
                </div>
            </form>    
        </div>
        <% } %>
        </center>
</body>
</html>
