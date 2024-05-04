<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In Form</title>
    <link rel="stylesheet" href="css/LoginCoo.css">
</head>

<body>
	<img src="img/icons/Login-bro.svg">
    <div class="wrapper login">
        <div class="container">
            <div class="col-left">
                <div class="login-text">
                    <h2>bienvenue !</h2>
                    <p>connecté à votre compte .<br>Coordinateur</p>
                    <a href="" class="btn">Back</a>
                </div>
            </div>

            <div class="col-right">
                <div class="login-form">
                    <h2>Login</h2>
                    <form action="">
                        <p>
                            <label>Email address<span>*</span></label>
                            <input type="text" placeholder="Email" name="email"required>
                        </p>
                        <p>
                            <label>Password<span>*</span></label>
                            <input type="password" placeholder="Password" name="password" required>
                        </p>
                        <p>
                            <input type="submit" value="Sign In">
                        </p>
                        <p>
                            <a href="">Forgot password?</a>
                        </p>
                    </form>
                </div>
            </div>

        </div>
    </div>
</body>
</html>