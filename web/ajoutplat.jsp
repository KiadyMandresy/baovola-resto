<%-- 
    Document   : ajoutplat
    Created on : 29 mai 2022, 21:16:14
    Author     : Dawood
--%>

<%@page import="table.CategoriePlat"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vector liste = (Vector)request.getAttribute("liste");
    String message = null;
    if(request.getAttribute("message")!=null){
        message = (String)request.getAttribute("message");
    }
%>
<!DOCTYPE html>

<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">
            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <center><div class="card-body">
                            <h1 class="card-title">Ajout de plat</h1>
                            <form action="ServletAjouterPlat" method="post">
                                <p>Designation :  <input type="text" class="form-control" name="des" style="width:20%"></p>
                                <p>Prix : <input type="text" class="form-control" name="prix" style="width:20%"></p>
                                <p>Categorie :
                                    <select name="idcategorie" class="form-control" style="width:20%">
                                        <% for(int i=0; i<liste.size(); i++) { %>
                                        <option value="<%=((CategoriePlat)liste.get(i)).getId()%>"> <% out.println(((CategoriePlat)liste.get(i)).getDesignation());%></option>
                                        <% } %>
                                    </select>
                                </p>
                                <input type="submit" value="Gerer les ingredients" class="btn btn-secondary">
                            </form>
                            <% if(message!=null) { %>
                                <p><% out.println(message);%></p>
                            <% } %>
                        </div></center>
                </div>
            </div>
        </div>
    </div>
</div>