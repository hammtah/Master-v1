
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <link rel="stylesheet" href="css/auth-style.css">
    <link rel="stylesheet" href="css/generic-style.css">
    <!-- Lato -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,100;1,300;1,400;1,700;1,900&display=swap" rel="stylesheet">
    <!-- Montserra -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
    <section class="conatainer " id="signin-container">
        <div class="auth-logo-div">
            <a href="header.jsp">
                <img src="img/icons/monmstr-logo-2.svg" alt="logo">
            </a>
        </div>
        <section class="wraper">
            <h1 class="title">Sign In</h1>
            <form action="addUser" class="" method="post" autocomplete="off" >
                <!-- Info personnel -->
                <section class="form-up form-part-1 current">

                    <section class="up-connection">
                        <div class="up-connection-div input-div">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" class="input" placeholder="Alaoui32@gmail.com">
                        </div>
                        <div class="up-connection-div input-div">
                            <label for="password">Password</label>
                            <input type="password" name="password" id="password" class="input">
                        </div>
                    </section>
                </section>
                <!--  -->
                <!--  -->
                <section class="form-down">
                    <div class="control-div">
                        <button type="submit" class="btn submit" id="submit">
                            Sign In
                        </button>
                    </div>
                    <p class="footer-text">Don't have an account ? <a href="signup.jsp" class="link signup-link sign-link">Sign Up </a></p>
                </section>
            </form>
        </section>
    </section>
</body>
</html>