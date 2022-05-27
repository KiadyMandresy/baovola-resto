<%-- 
    Document   : listIngredient
    Created on : 5 avr. 2022, 10:00:30
    Author     : mac
--%>
<%@page import="table.IngredientConso"%>
<%@page import="java.util.Vector"%>
<%
    Vector list = new Vector();
    String date1 = "";
    String date2 = "";
    double total = 0;
    if(request.getAttribute("listIngredient")!=null){
       list= (Vector)request.getAttribute("listIngredient");
       date1 = (String)request.getAttribute("date1");
       date2 = (String)request.getAttribute("date2");
       total = ((IngredientConso)list.get(0)).getTotal(list);
    }
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="main-panel">
    <div class="content-wrapper">
        <div class="row">
            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Choisir 2 dates</h4>
                        <form class="form-inline" action="ServletIngredientConso" method="post">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Date 1</label>
                                <div class="col-sm-9">
                                    <input type="date" name="date1" >                              
                                </div>
                                <label class="col-sm-3 col-form-label">Date 2</label>
                                <div class="col-sm-9">
                                    <input type="date" name="date2" >                              
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary mb-2">Voir</button>
                        </form>
                    </div>
                </div> 
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <% if(list.size()!=0) {%>
                  <h4 class="card-title">Liste des ingredients consommés entre le "<% out.println(date1); %>" et le "<% out.println(date2); %>" :</h4>
                  <% } %>
                  <div class="table-responsive">
                    <table class="table table-bordered">
                      <thead>
                        <th>Nom</th>
                        <th>Qte</th>
                        <th>Prix</th>
                       
                      </thead>
                      <tbody>
                      <% if(list.size()!=0) {%>    
                         <% for(int i=0; i<list.size(); i++) { %>
                        <tr>
                            <form class="form-inline" action="ServletDetailPlat" method="post">
                                <th><% out.println( ((IngredientConso)list.get(i)).getIngredient() ); %></th>
                                <th><% out.println( ((IngredientConso)list.get(i)).getQuantite()); %></th>
                                <th><% out.println( ((IngredientConso)list.get(i)).getPrix()); %></th>
                            </form>
                            
                        </tr>
                       <% } %>
                        <tr>
                            <th></th>
                            <th>Total :</th>
                            <th><% out.println(total);%></th>
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