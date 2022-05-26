<%@page import="table.IngredientPlat"%>
<%@page import="java.util.Vector"%>
<%
    Vector listeIngr = (Vector)request.getAttribute("liste");
    String nom = (String)request.getAttribute("nom");
    String prix = (String)request.getAttribute("prix");
    double tot =0;
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
                        <th>unite</th>
                        <th>quantite</th>
                        <th>Prix </th>
                      </thead>
                      <tbody>
                      <% for(int i=0; i<listeIngr.size(); i++) { %>
                        <tr>
                            <th><% out.println( ((IngredientPlat)listeIngr.get(i)).getIngredient() );%></th>
                            <th><% out.println( ((IngredientPlat)listeIngr.get(i)).getUnite() );%></th>
                            <th><% out.println( ((IngredientPlat)listeIngr.get(i)).getQuantite() );%> </th>
                            <th><% out.println( ((IngredientPlat)listeIngr.get(i)).getPrixRev() );%> Ariary</th>
                        </tr>
                        <% tot += ((IngredientPlat)listeIngr.get(i)).getPrixRev(); %>
                      <% } %>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>Prix de revient :</th>
                            <th><% out.println(tot);%> Ariary</th>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>