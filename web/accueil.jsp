<%-- 
    Document   : accueil
    Created on : 23 mai 2022, 15:58:06
    Author     : Dawood
--%>

<%@page import="table.Plat"%>
<%@page import="table.CategoriePlat"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vector Categorie = (Vector)request.getAttribute("listeCategorie");
    Vector ListePlat = (Vector)request.getAttribute("listePlat");
    //out.println( ((CategoriePlat)Categorie.get(0)).getDesignation() );

%>
<!DOCTYPE html>
<body>
    <div class="content">
        <div class="container_12">
           <div class="grid_8">
                <h3 class="head3">Liste de nos plats disponibles</h3>
                    <form id="form">

                       
                        <label class="name"> 
                        <select name="cat">
                            <option value="t">None</option>
                            <% for( int i=0; i<Categorie.size(); i++) { %>
                               <option value="<%=((CategoriePlat)Categorie.get(i)).getId()%>"><% out.println(((CategoriePlat)Categorie.get(i)).getDesignation()); %></option>
                            <% } %>                              
                        </select>
                        <a href="#" data-type="submit" class="btn">Send</a>
                        </label>

             
                        <div >
                            
                            <div class="table-responsive">
                              <table border="2px" border="solid" class="table">
                              <thead>
                                <tr>
                                   <th>Nom</th>
                                  <th>Prix</th>
                                </tr>
                              </thead>
                              <tbody>
                                <% for(int i=0; i<ListePlat.size(); i++) {%>
                                    <tr>
                                        <td><%out.println(((Plat)ListePlat.get(i)).getDesignation());%></td>
                                        <td><% out.println(((Plat)ListePlat.get(i)).getPrix()); %> </td>
                                        <form action="ServletCommandeValide" method="post">
                                            <input type="hidden" name="idcommande" value="<%=((Plat)ListePlat.get(i)).getId()%>">
                                            <td><input type="submit" value="Ajouter" class="btn btn-light"></td>
                                        </form>
                                    </tr>
                               <% } %>
                              </tbody>
                            </table>
                          </div>
                        </div>
                        
                    </div>
                   </form>   
                </div>
             </div>
            
                
            
          </div>              
</body>