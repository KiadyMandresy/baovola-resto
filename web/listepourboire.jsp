<%-- 
    Document   : listepourboire
    Created on : 29 mai 2022, 10:06:58
    Author     : Dawood
--%>
<%@page import="table.Pourboire"%>
<%@page import="java.util.Vector"%>
<%
    Vector list =new Vector();
    String date1="";
    String date2="";
    if(request.getAttribute("list")!=null){
        list = (Vector)request.getAttribute("list");
        date1 = (String)request.getAttribute("date1");
        date2 = (String)request.getAttribute("date2");
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
                        <form class="form-inline" action="ServletPourboire" method="post">
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
                  <h4 class="card-title">Liste des pouboires des serveurs entre le "<% out.println(date1); %>" et le "<% out.println(date2); %>" :</h4>
                  <% }else{ %>
                    <h4 class="card-title">Pas de pourboire entre ces dates</h4>
                  <% } %>
                  <div class="table-responsive">
                    <table class="table table-borderless">
                      <thead>
                        <th>Nom</th>
                        <th>Total pourboire</th>
                       
                      </thead>
                      <tbody>
                      <% if(list.size()!=0) {%>    
                         <% for(int i=0; i<list.size(); i++) { %>
                        <tr>
                                <th><% out.println( ((Pourboire)list.get(i)).getNom() ); %></th>
                                <th><% out.println( ((Pourboire)list.get(i)).getPourboire()); %> Ariary</th>
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