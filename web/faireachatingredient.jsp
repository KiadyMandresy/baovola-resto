<%@page import="table.Ingredient"%>
<%@page import="java.util.Vector"%>
<%
    Vector liste = (Vector)request.getAttribute("liste");
    String message = null;
    if(request.getAttribute("message")!=null){
        message = (String)request.getAttribute("message");
    }
%>

<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">
            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <center><div class="card-body">
                        <h1 class="card-title">Inventaire</h1>
                        <form action="ServletFaireAchatIngredient" method="post">
                            <p>Ingredient  : 
                                <select name="idingredient" class="form-control" style="width:20%">
                                    <% for(int i=0; i<liste.size(); i++) { %>
                                    <option value="<%=((Ingredient)liste.get(i)).getId()%>"> <% out.println(((Ingredient)liste.get(i)).getNom());%></option>
                                    <% } %>
                                </select>
                            </p>
                            <p>Quantite  :  <input type="text" name="qte" class="form-control" style="width:20%"></p>
                            <input type="submit" value="Valider" class="btn btn-secondary">
                        </form>
                        <% if(message!=null) { %> 
                           <p><% out.println(message); %></p>  
                        <% } %>
                        </div></center>
                </div>
            </div>
        </div>
    </div>
</div>