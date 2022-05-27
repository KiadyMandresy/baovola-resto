<%-- 
    Document   : accueil
    Created on : 23 mai 2022, 15:58:06
    Author     : Dawood
--%>

<%@page import="table.CategoriePlat"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Vector Categorie = (Vector)request.getAttribute("listeCategorie");
    //out.println( ((CategoriePlat)Categorie.get(0)).getDesignation() );

%>
<!DOCTYPE html>
<body>
    <div class="content">
        <div class="container_12">
         
           <div class="grid_8">
                <h3 class="head3">Liste de plats</h3>
                    <form id="form">

                        <div class="success_wrapper">
                        
                        </div>
                        <label class="name">
                            
                            <select name="cat">
                                <option value="t">None</option>
                                <% for( int i=0; i<Categorie.size(); i++) { %>
                                   <option value="<%=((CategoriePlat)Categorie.get(i)).getId()%>"><% out.println(((CategoriePlat)Categorie.get(i)).getDesignation()); %></option>
                                <% } %>                              
                            </select>
                        
                        </label>

                        <label class="email">
                            <input type="text" placeholder="E-mail:" data-constraints="@Required @Email" />
                             <a href="#" data-type="submit" class="btn">Send</a></div>
                        </label>
                      
                      
                        <div>
                        <div class="clear"></div>
                   
                   </form>   
                </div>
             </div>
        </div>
</body>