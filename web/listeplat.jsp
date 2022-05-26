<%-- 
    Document   : listePlat
    Created on : 22 mars 2022, 10:30:57
    Author     : mac
--%>
<%@page import="table.CategoriePlat"%>
<%@page import="table.Plat"%>
<%@page import="java.util.Vector"%>
<%
    Vector listeCat = (Vector)request.getAttribute("cat");
    Vector liste = (Vector)request.getAttribute("liste");
    CategoriePlat cat = new CategoriePlat();
%>
<!DOCTYPE html>

      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-12 grid-margin stretch-card">
             <div class="card">
               <div class="card-body">
                 <h4 class="card-title">Liste des plats</h4>
                 <div>
                    <form class="form-inline" action="ServletListePlat" method="post">
                        <input type="text" class="form-control"  placeholder="Recherche..."  name="rech"style="width: 350px">
                        <input type="submit" class="btn btn-secondary" value="Rechercher">
                    </form>
                     <br>
                     <br>
                    <form class="form-inline" action="ServletListePlat" method="post">
                     <div class="form-group row">
                      <label class="col-sm-3 col-form-label">Categorie</label>
                      <div class="col-sm-9">
                        <select class="form-control" name="cat">
                            <option value="t">None</option>
                            <% for( int i=0; i<listeCat.size(); i++) { %>
                               <option value="<%=((CategoriePlat)listeCat.get(i)).getId()%>"><% out.println(((CategoriePlat)listeCat.get(i)).getDesignation()); %></option>
                          <% } %>
                        </select>
                      </div>
                    </div>
                      <button type="submit" class="btn btn-secondary">Valider</button>
                    </form>
                 </div>
               </div>
             </div>
           </div>
          </div>   
          <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <th>Nom</th>
                        <th>Categorie</th>
                        <th>Prix</th>
                      </thead>
                      <tbody>
                         <% for(int i=0; i<liste.size(); i++) { %>
                        <tr>
                            <form class="form-inline" action="ServletIngredientPlat" method="post">
                                <input type="hidden" value="<%=((Plat)liste.get(i)).getId()%>" name="idplat">
                                <input type="hidden" value="<%= ((Plat)liste.get(i)).getDesignation()%>" name="nom">
                                <input type="hidden" value="<%= ((Plat)liste.get(i)).getPrix()%>" name="prix">
                                <th><% out.println( ((Plat)liste.get(i)).getDesignation() ); %></th>
                                <th><% out.println( cat.getCatById( ((Plat)liste.get(i)).getIdCategorie() )) ; %></th>
                                <th><% out.println(((Plat)liste.get(i)).getPrix() ); %></th>
                                <th><button type="submit" class="btn btn-secondary">Voir ingredient</button></th>
                            </form>
                        </tr>
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
          
        