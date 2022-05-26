<%-- 
    Document   : login.jsp
    Created on : 26 mai 2022, 10:22:16
    Author     : ravonirinafitahianarandriamanantena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,700">-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/log.css">
        <title>Login</title>
    </head>
    <body>
        <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-center auth px-0">
        <div class="row w-100 mx-0">
          <div class="col-lg-4 mx-auto">
            <div class="auth-form-light text-left py-5 px-4 px-sm-5">
              <h4>Restaurant</h4>
              <h6 class="font-weight-light">Sign in to continue.</h6>
                <form class="pt-3" action="login" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control form-control-lg" id="exampleInputEmail1" name="user" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control form-control-lg" id="exampleInputPassword1" name="mdp" placeholder="Password">
                    </div>
                    <div class="mt-3">
                        <input class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" type="submit"/>
                    </div>
                </form>
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
    </body>
</html>
