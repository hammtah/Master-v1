<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>header</title>
    <!-- styles -->
    <link rel="stylesheet" href="css/generic-style.css">
    <link rel="stylesheet" href="css/header-style.css">
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
    <nav class="nav">
        <section class="nav-l">
            <div class="icon-div">
                <a href="" class="icon-link">
                    <img src="img/icons/monmstr-logo-2.svg" alt="icon">
                </a>
            </div>
            <ul class="links">
           		<li>
                <a href="" class="link"> Masters</a>
                </li>
                <li>
               		<a href="" class="link">Nouveautés</a>
                <li>
                	<a href="" class="link">Contactez Nous</a>
                </li>
                <li>
                	<a href="" class="link">Coordinateur</a>
                </li>
                
            </ul>
        </section>
        <section class="nav-r">
            <form class="search-div" method="POST" action="" id="search-form">
                <img src="img/icons/search.svg" alt="search-bar" class="search-icon">
                <input type="text" name="search" id="search-inpt" class="search-inpt" placeholder="Search...">
            </form>
            <!--the profile icon -->
            <a href="" class="profile-div">
                <img src="https://images.rawpixel.com/image_png_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIyLTA4L2pvYjEwMzQtZWxlbWVudC0wNi0zOTcucG5n.png" alt="profile">
            </a>
            <!-- signup and signin -->
            <ul class="links auth-div">
            	<li>
                <a href="signin.jsp" class="link">Sign In</a>
                </li>
                <li>
                <a href="signup.jsp" class="link custom-btn">Sign Up</a>
                </li>
            </ul>
        </section>
    </nav>
</body>
</html>