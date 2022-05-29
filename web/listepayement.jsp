<%-- 
    Document   : listePlat
    Created on : 22 mars 2022, 10:30:57
    Author     : mac
--%>
<%@page import="table.VuePayement"%>
<%@page import="table.Plat"%>
<%@page import="java.util.Vector"%>
<%
    Vector liste = new Vector();
    String date1 = "";
    String date2 = "";
    double total = 0;
    if(request.getAttribute("liste")!=null){
        liste = (Vector)request.getAttribute("liste");
        date1 = (String)request.getAttribute("date1");
        date2 = (String)request.getAttribute("date2");
        total = ((VuePayement)liste.get(0)).total(liste);
    }
%>
<!DOCTYPE html>

      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
            <div class="row">
            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Choisir 2 dates</h4>
                        <form class="form-inline" action="ServletPayement" method="post">
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
                            <button type="submit" class="btn btn-secondary mb-2">Voir</button>
                        </form>
                    </div>
                </div> 
            </div>
        </div>
          <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <% if(liste.size()!=0) {%>
                        <h4 class="card-title">Liste des additions payées entre le "<% out.println(date1); %>" et le "<% out.println(date1); %>" :</h4>
                  <% } %>
                  <div class="table-responsive">
                    <table class="table table-bordered" >
                      <thead>
                        <th>Numero table</th>
                        <th>Type de Payement</th>
                        <th>Montant</th>
                        <th>Date</th>
                      </thead>
                     <tbody>
                        <% if(liste.size()!=0) {%>    
                         <% for(int i=0; i<liste.size(); i++) { %>
                        <tr>
                            <form class="form-inline" action="ServletDetailPlat" method="post">
                                <th><% out.println( ((VuePayement)liste.get(i)).getNumeroTable() ); %></th>
                                <th><% out.println( ((VuePayement)liste.get(i)).getTypePayement()); %></th>
                                <th><% out.println( ((VuePayement)liste.get(i)).getMontant()); %> Ariary</th>
                                <th><% out.println( ((VuePayement)liste.get(i)).getDaty()); %></th>
                            </form>
                        </tr>
                        <% } %>
                        <tr>
                            <th></th>
                            <th>Total :</th>
                            <th><% out.println(total);%> Ariary</th>
                            <th></th>
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
          
        