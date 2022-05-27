<%-- 
    Document   : accueil
    Created on : 23 mai 2022, 15:58:06
    Author     : Dawood
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <input type="text" placeholder="Name:" data-constraints="@Required @JustLetters" />
                        
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