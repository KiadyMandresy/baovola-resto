<%@page import="table.IngredientPlat"%>
<%@page import="java.util.Vector"%>
<%
    Vector listeIngr = (Vector)request.getAttribute("liste");
    String nom = (String)request.getAttribute("nom");
    String prix = (String)request.getAttribute("prix");
    int idplat = (Integer)request.getAttribute("idplat");
    double prixsugg =0;
    double total = ((IngredientPlat)listeIngr.get(0)).getSommePrixRev(idplat);
    if(request.getAttribute("prixsugg")!=null){
        prixsugg = (Double)request.getAttribute("prixsugg");
    }
%>

<!DOCTYPE html>

      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
            
          <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Liste des ingredients de : <% out.println(nom); %></h4>
                  <h3 class="card-title">Son prix de vente : <% out.println(prix); %> Ariary</h3>
                
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <th>Ingredient</th>
                        <th>quantite</th>
                        <th>unite</th>
                        <th>Prix </th>
                      </thead>
                      <tbody>
                      <% for(int i=0; i<listeIngr.size(); i++) { %>
                        <tr>
                            <th><% out.println( ((IngredientPlat)listeIngr.get(i)).getIngredient() );%></th>
                            <th><% out.println( ((IngredientPlat)listeIngr.get(i)).getQuantite() );%> </th>
                            <th><% out.println( ((IngredientPlat)listeIngr.get(i)).getUnite() );%></th>
                            <th><% out.println( ((IngredientPlat)listeIngr.get(i)).getPrixRev() );%> Ariary</th>
                        </tr>
                      <% } %>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>Prix de revient :</th>
                            <th><% out.println( total );%> Ariary</th>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                <form action="ServletIngredientPlat" method="post">
                    <input type="hidden" name="idplat" value="<%=idplat%>">
                    <input type="hidden" name="sugg" value="f">
                    <input type="submit" value="Suggerer prix de vente" class="btn btn-secondary">   
                </form>
                <% if(prixsugg!=0) {%>
                    <br>
                    <br>
                    <h3>Prix de vente conseillé : <% out.println(prixsugg);%> Ariary</h3>
                <% } %>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>