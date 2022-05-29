<%-- 
    Document   : choixdeTable
    Created on : 29 mai 2022, 16:26:06
    Author     : mac
--%>
<%@page import="table.Latabatra"%>
<%@page import="java.util.Vector"%>
<%
   Vector listelatabatra = (Vector)request.getAttribute("listelatabatra");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <div class="content">
        <div class="container_12">
            <div class="grid_12">
                <div class="col-md-6">
                    <div class="form-group row">
                        <form action="ServletPlat" method="post">
                            <label class="col-sm-3 col-form-label">Choisissez une table</label>
                             <div class="col-sm-9">
                               <select class="form-control" name="latabatra">
                                   <option value="t">None</option>
                                   <% for( int i=0; i<listelatabatra.size(); i++) { %>
                                      <option value="<%=((Latabatra)listelatabatra.get(i)).getId()%>"><% out.println(((Latabatra)listelatabatra.get(i)).getNumero()); %></option>
                                 <% } %>
                               </select>
                               <input type="submit" value="Choisir" class="btn btn-light">
                             </div>
                        </form>   
                    </div>
                  </div>
            </div>
        </div>
    </div>
</body>
