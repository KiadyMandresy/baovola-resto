<%-- 
    Document   : accueil
    Created on : 23 mai 2022, 15:58:06
    Author     : Dawood
--%>

<%@page import="table.DetailCommande"%>
<%@page import="table.Latabatra"%>
<%@page import="table.Plat"%>
<%@page import="table.CategoriePlat"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Vector Categorie = (Vector)request.getAttribute("listeCategorie");
    Vector ListePlat = (Vector)request.getAttribute("listePlat");
    Vector listDetail =(Vector)request.getAttribute("listeDetail");
    Plat p = new Plat();
        
%>
<body>
    <div class="content">
        <div class="content-wrapper">
            <div class="row">
                <div class="col-md-6 grid-margin stretch-card">
                    <div class="grid_8">
                         <h3 class="head3">Liste de nos plats disponibles</h3>
                                 <div class="form-group row">
                                     <form id="form" action="ServletCategoriePlat" method="post">
                                        <label class="col-sm-3 col-form-label">Categorie</label>
                                        <div class="col-sm-9">
                                          <select class="form-control" name="cat">
                                              <option value="t">None</option>
                                              <% for( int i=0; i<Categorie.size(); i++) { %>
                                                 <option value="<%=((CategoriePlat)Categorie.get(i)).getId()%>"><% out.println(((CategoriePlat)Categorie.get(i)).getDesignation()); %></option>
                                            <% } %>
                                          </select>
                                          <button type="submit" class="btn btn-primary mb-2">Valider</button>
                                        </div>
                                     </form>  
                                 </div>
                                 <div >
                                    <div class="table-responsive">
                                       <table border="2px" border="solid" class="table">
                                       <thead>
                                         <tr>
                                            <th>Nom</th>
                                           <th>Prix</th>
                                           <th>Quantite</th>
                                         </tr>
                                       </thead>
                                       <tbody>
                                         <% for(int i=0; i<ListePlat.size(); i++) {%>
                                             <tr>
                                                 <td><%out.println(((Plat)ListePlat.get(i)).getDesignation());%></td>
                                                 <td><% out.println(((Plat)ListePlat.get(i)).getPrix()); %> </td>
                                                 <form action="ServletAjoutPlat" method="post">
                                                     <input type="hidden" name="idplat" value="<%=((Plat)ListePlat.get(i)).getId()%>">
                                                     <td><input type="number" name="qte"  class="btn btn-light"></td>
                                                     <td><input type="submit" value="Ajouter" class="btn btn-light"></td>
                                                 </form>
                                             </tr>
                                        <% } %>
                                       </tbody>
                                     </table>
                                   </div>
                                 </div>
                             </div>
                       
                    </div>
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="grid_8">
                            <h3 class="head3">Commande en cours</h3>
                                 <form id="form">
                                     <div class="form-group row">                                  
                                        <div class="col-sm-9">
                                          
                                        </div>
                                     </div>
                                     <div >
                                         <div class="table-responsive">
                                           <table border="2px" border="solid" class="table">
                                           <thead>
                                             <tr>
                                                <th>Nom</th>
                                               <th>Quantite</th>
                                               <th>Prix</th>
                                             </tr>
                                           </thead>
                                           <tbody>
                                               </form>
                                             <form action="ServletValideCommande" method="get">    
                                             <% for(int i=0; i<listDetail.size(); i++) {%>
                                                 <tr>
                                                     <td><%out.println( p.getPlat(((DetailCommande)listDetail.get(i)).getIdPlat()).getDesignation() );%></td>
                                                     <td><%out.println(((DetailCommande)listDetail.get(i)).getQte());%></td>
                                                     <td><%out.println( ((DetailCommande)listDetail.get(i)).getQte()*p.getPlat(((DetailCommande)listDetail.get(i)).getIdPlat()).getPrix());%></td>
                                                     
                                                     <input type="hidden" name="idcommande" value="<%=((DetailCommande)listDetail.get(i)).getIdCommande()%>">
                                                      
                                                 </tr>
                                            <% } %>
                                           
                                           </tbody>
                                         </table>
                                         
                                         <div class="form-group">
                                            <div class="input-group">
                                                
                                                    <input type="text" class="form-control" placeholder="Nom de client" aria-label="Nom de client" name="nom">
                                                    <div class="input-group-append">
                                                        <input class="btn btn-sm btn-primary" type="submit">Valider</button>                                         
                                                    </div>
                                                </form>
                                            </div>
                                       </div>
                                    </div>
                                 </div>
                            
                        </div>
                    </div> 
                </div>
             </div>   
        </div>              
</body>
