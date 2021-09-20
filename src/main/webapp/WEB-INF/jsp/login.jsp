<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <html lang="en">

    <head>

      <title>log in</title>
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
      <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet"
        crossorigin="anonymous">
           <!-- Bootstrap core CSS -->
                <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
      <link href="index.css" rel="stylesheet">
    </head>

    <body class="text-center" cz-shortcut-listen="true">
      <div class="container">

        <form class="form-signin" method="post" action="login" name = "f">

                  <h4 class="logo">Pay My Budy</h4>
                  </br>
                  <h2 class="form-signin-heading">Please sign in</h2>
                  </br>
                  <p>
                    <label for="username" class="sr-only">Username</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Username"
                      required="" autofocus=""/>
                  </p>
                  <p>
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                      required=""/>

                  </p>
                  <p>
                    Remember me ?
                    <input type="checkbox" id="remember-me" name="remember-me" class="checkbox" />

                  </p>

                  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                  </br>

                  <a class="py-2 text-dark text-decoration-none" href="/paymybuddy/register">New Member ?</a>
                </form>
      </div>
    </body>

    </html>