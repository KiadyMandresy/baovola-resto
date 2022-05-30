<%-- 
    Document   : etatdestock
    Created on : 30 mai 2022, 12:11:15
    Author     : Dawood
--%>

<%@page import="table.Ingredient"%>
<%@page import="table.ResteIngredient"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vector liste = (Vector)request.getAttribute("liste");
    Ingredient ing = new Ingredient();
%>
<div class="main-panel">
        <div class="content-wrapper">
            <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                        <h4 class="card-title">Etat de stock ingredient</h4>
                  <div class="table-responsive">
                    <table class="table table-borderless" >
                      <thead>
                        <th>Nom</th>
                        <th>Reste en stock</th>
                      </thead>
                     <tbody>  
                         <% for(int i=0; i<liste.size(); i++) { %>
                        <tr>
                            <form class="form-inline" action="ServletDetailPlat" method="post">
                                <th><% out.println( ing.getIngredient( ((ResteIngredient)liste.get(i)).getIdIngredient()).getNom() ); %></th>
                                <th><% out.println( ((ResteIngredient)liste.get(i)).getReste()); %></th>
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
                      
                      