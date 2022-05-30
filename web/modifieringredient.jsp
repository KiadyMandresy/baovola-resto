<%@page import="table.DetailPlat"%>
<%@page import="table.Ingredient"%>
<%@page import="table.Plat"%>
<%@page import="java.util.Vector"%>
<%
    String message = (String)request.getAttribute("message");
    Vector liste = (Vector)request.getAttribute("ingredient");
    int idplat= (Integer)request.getAttribute("idplat");
    Vector listeDetailPlat = new Vector();
    if(request.getAttribute("detailplat")!=null){
        listeDetailPlat = (Vector)request.getAttribute("detailplat");
    }
    Ingredient ing = new Ingredient();
%>

<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">
            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <center><div class="card-body">
                            <h1 class="card-title">Modification Ingredient</h1>
                            <p><% out.println(message);%></p>
                            <form action="ServletModifier" method="post">
                                <input type="hidden" name="idplat" value="<%=idplat%>">
                                <p>Ingredient :
                                    <select name="idingredient" class="form-control" style="width:20%">
                                        <% for(int i=0; i<liste.size(); i++) { %>
                                        <option value="<%=((Ingredient)liste.get(i)).getId()%>"> <% out.println(((Ingredient)liste.get(i)).getNom());%></option>
                                        <% } %>
                                    </select>
                                </p>
                                <p>Quantite :  <input type="text" class="form-control" name="qte" style="width:20%"></p>
                                <p>Unite : <input type="text" class="form-control" name="unite" style="width:20%"></p>
                                <input type="submit" value="Ajouter comme ingredient" class="btn btn-secondary">
                            </form>
                        </div></center>
                </div>
            </div>
        </div>
        <div class="row">
               <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Liste des ingredients de ce plat </h4>
                        <div class="table-responsive">
                            <table class="table table-borderless">
                              <thead>
                                <th>Ingredient</th>
                                <th>Quantite</th>
                                <th>Unite</th>

                              </thead>
                              <tbody>
                              <% if(listeDetailPlat.size()!=0) {%>    
                                 <% for(int i=0; i<listeDetailPlat.size(); i++) { %>
                                <tr>
                                        <th><% out.println( ing.getIngredient( ((DetailPlat)listeDetailPlat.get(i)).getIdIngredient() ).getNom() ); %></th>
                                        <th><% out.println( ((DetailPlat)listeDetailPlat.get(i)).getQte()); %> </th>
                                        <th><% out.println( ((DetailPlat)listeDetailPlat.get(i)).getUnite()); %> </th>
                                        <form action="ServletModifier" method="post">
                                            <input type="hidden" value="<%=((DetailPlat)listeDetailPlat.get(i)).getId()%>" name="idDetail">
                                            <input type="hidden" value="<%=idplat%>" name="plat">
                                            <th><input type="submit" value="Supprimer" class="btn btn-danger"></th>
                                        </form>
                                </tr>
                               <% } %>
                                <% } %>
                              </tbody>
                            </table>
                          </div>
                    </div>
                </div> 
            </div>
        </div>                            
    </div>
</div>