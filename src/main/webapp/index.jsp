<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <%@include file="layout/head.jsp"%>
  </head>
  <body class="be-splash-screen">
  <div class="be-wrapper be-login">
    <div class="be-content">
      <div class="main-content container-fluid">
        <div class="splash-container">
          <div class="card card-border-color card-border-color-primary">
            <div class="card-header"><img class="logo-img" src="assets\img\logo-xx.png" alt="logo" width="102" height="27"><span class="splash-description">Please enter your user information.</span></div>
            <div class="card-body">
              <form action="/login" method="post">
                <div class="form-group">
                  <input class="form-control" id="username" name="username" type="text" placeholder="Username" autocomplete="off">
                </div>
                <div class="form-group">
                  <input class="form-control" id="password" name="password" type="password" placeholder="Password">
                </div>
                <div class="form-group row login-tools">
                  <div class="col-6 login-forgot-password"><a href="pages-forgot-password.html">Forgot Password?</a></div>
                </div>
                <div class="form-group login-submit">
                  <input type="submit" class="btn btn-primary btn-xl" value="Sign In">
<%--                  <a class="btn btn-primary btn-xl" href="index.html" data-dismiss="modal">Sign in</a>--%>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%@include file="layout/alert.jsp"%>

  <%@include file="/layout/script.jsp"%>
  </body>
</html>
