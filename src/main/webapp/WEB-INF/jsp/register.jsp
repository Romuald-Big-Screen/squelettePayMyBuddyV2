<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <!doctype html>
    <html lang="en">

    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
      <meta name="generator" content="Hugo 0.82.0">
      <title>Signin Template · Bootstrap v5.0</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
      <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
      <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
      <link href="index.css" rel="stylesheet">
    </head>

    <body class="text-center">
      <div class="container">
        <main class="form-signin">
          <div id="addUser">
            <h4 class="logo">Pay My Budy</h4>
            </br>
            <form:form action="registration" method="post" modelAttribute="registrationForm">

              <h1 class="h3 mb-3 fw-normal">Register</h1>
              <div class="form-floating">
                <form:input path="firstName" type="text" class="form-control floatingInput" />
                <label for="floatingInput">First Name</label>
              </div>
              <div class="form-floating">
                <form:input path="lastName" type="text" class="form-control floatingInput" />
                <label for="floatingInput">Last Name</label>
              </div>
              <div class="form-floating">
                <form:input path="email" type="email" class="form-control floatingInput" />
                <label for="floatingInput">Email address</label>
              </div>
              <div class="form-floating">
                <form:input path="password" type="password" class="form-control floatingPassword" />
                <label for="floatingPassword">Password</label>
              </div>
              <div class="form-floating">
                <form:input path="confirmPassword" type="password" class="form-control floatingPassword" />
                <label for="floatingPassword">Confirm Password</label>
              </div>

              <div class="checkbox mb-3">
                <label>
                  <input type="checkbox" value="remember-me"> Remember me
                </label>
              </div>
              <form:button class="w-100 btn btn-lg btn-primary" type="submit">Register</form:button>
              <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
            </form:form>
          </div>
        </main>
      </div>



    </body>

    </html>