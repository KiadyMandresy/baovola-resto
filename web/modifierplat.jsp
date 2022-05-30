<%-- 
    Document   : modifierplat
    Created on : 30 mai 2022, 10:23:49
    Author     : Dawood
--%>

<%@page import="java.util.Vector"%>
<%@page import="table.CategoriePlat"%>
<%@page import="table.Plat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Plat plat = (Plat)request.getAttribute("plat");
    Vector liste = (Vector)request.getAttribute("categorie");
    CategoriePlat cp = new CategoriePlat();
%>
<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">
            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <center><div class="card-body">
                            <h1 class="card-title">Modification ¨Plat</h1>
                            <form action="ServletModifierPlat" method="post">
                                <input type="hidden" name="idplat" value="<%=plat.getId()%>">
                                <p>Categorie :
                                    <select name="idcategorie" class="form-control" style="width:20%">
                                        <option value="<%=plat.getIdCategorie()%>" selected> <% out.println( cp.getCatById( plat.getIdCategorie() ) );%> </option>
                                        <% for(int i=0; i<liste.size(); i++) { %>
                                        <option value="<%=((CategoriePlat)liste.get(i)).getId()%>"> <% out.println(((CategoriePlat)liste.get(i)).getDesignation());%></option>
                                        <% } %>
                                    </select>
                                </p>
                                <p>Nom :  <input type="text" class="form-control" name="nom" style="width:20%" value="<%=plat.getDesignation()%>"></p>
                                <p>Prix : <input type="text" class="form-control" name="prix" style="width:20%" value="<%=plat.getPrix()%>"></p>
                                <input type="submit" value="Ajouter comme ingredient" class="btn btn-secondary">
                            </form>
                        </div></center>
                </div>
            </div>
        </div>
    </div>
</div>