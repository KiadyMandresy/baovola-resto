<%@page import="table.Plat"%>
<%@page import="table.Client"%>
<%@page import="table.DetailCommande"%>
<%@page import="table.Commande"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vector liste = (Vector)request.getAttribute("liste");
    Vector detail = new Vector();
    Client fc = new Client();
    Plat fp = new Plat();
    String nomcli = "";
    String numtable ="";
    double total = 0;
    if(request.getAttribute("detail")!=null){
        detail = (Vector)request.getAttribute("detail");
        nomcli = (String)request.getAttribute("nomcli");
        numtable = (String)request.getAttribute("numtable");
    }
%>
    <!DOCTYPE html>
<body>
    <div class="content">
        <div class="container_12">
            <div class="grid_12">
                <h3>Commandes validées</h3>
                <div style="float: left; width: 50%;margin-left: -25%" >
                    <h3 class="card-title" >Liste des commandes validées</h3>
                    <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Client</th>
                          <th>Status</th>
                        </tr>
                      </thead>
                      <tbody>
                        <% for(int i=0; i<liste.size(); i++) {%>
                            <tr>
                                <td><% out.println( fc.getClientByCom( ((Commande)liste.get(i)).getId() ).getNom() ) ;%></td>
                                <td>Validée</td>
                                <form action="ServletCommandeValide" method="post">
                                    <input type="hidden" name="idcommande" value="<%=((Commande)liste.get(i)).getId()%>">
                                    <td><input type="submit" value="Voir commande" class="btn btn-light"></td>
                                </form>
                            </tr>
                       <% } %>
                      </tbody>
                    </table>
                  </div>
                </div>
                <% if(detail.size()!=0) { %> 
                <div style="float: right;width: 50%; margin-right: -25%">
                    <h3 class="card-title">Details commande</h3>
                    <p>Client : <% out.println(nomcli);%></p>    
                    <p>Table :  <% out.println(numtable);%></p>
                    <p>Status : Validée</p>
                    
                    <table class="table">
                      <thead>
                        <tr>
                          <th>Designation</th>
                          <th>Prix</th>
                          <th>Quantite</th>
                        </tr>
                      </thead>
                      <tbody>
                        <% for(int i=0; i<detail.size(); i++) {%>
                            <tr>
                                <td><% out.println( fp.getPlat( ((DetailCommande)detail.get(i)).getIdPlat() ).getDesignation() );%></td>
                                <td><% out.println( fp.getPlat( ((DetailCommande)detail.get(i)).getIdPlat() ).getPrix() ); %></td>
                                <td><% out.println( ((DetailCommande)detail.get(i)).getQte() ); %></td>
                                <% total += ((DetailCommande)detail.get(i)).getQte() * fp.getPlat( ((DetailCommande)detail.get(i)).getIdPlat() ).getPrix();%>
                            </tr>
                       <% } %>
                      </tbody>
                    </table>
                      <br>
                      <br>
                      <p>Total : <% out.println(total);%></p>
                </div>
                <% } %>
            </div>
        </div>
    </div>
</body>
