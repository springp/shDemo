<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Awesome Flat Login Form" />
  <meta name="keywords" content="Login, Flat, HTML5, CSS3" />
  <meta name="author" content="Wahid Anggara - LunarPixel" />
  <title>Login Form by LunarPixel</title>
  
<link href="<%= request.getContextPath()%>/resources/css/font-awesome.css" rel="stylesheet" type="text/css"> 
<link href="<%= request.getContextPath()%>/resources/css/login_style.css" rel="stylesheet" >
<link href="<%= request.getContextPath()%>/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
<link rel="shortcut icon" href="<%= request.getContextPath()%>/resources/img/favicon.ico"/>
<link rel="apple-touch-icon" href="<%= request.getContextPath()%>/resources/img/favicon.png"/>

</head>
<body onload='document.loginForm.username.focus();'>
  <div class="logo"></div>
  <div class="login"> <!-- Login -->
    <h1>Login to your account</h1>

    <form name='loginForm' class="form" action="<c:url value='/login' />" method='POST'>

      <p class="field">
        <input type="text" name="username" placeholder="Username" required/>
        <i class="fa fa-user"></i>
      </p>

      <p class="field">
        <input type="password" name="password" placeholder="Password" required/>
        <i class="fa fa-lock"></i>
      </p>

      <p class="submit"><input type="submit" name="commit" value="Login"></p>

      <p class="remember">
        <input type="checkbox" id="remember" name="remember" />
        <label for="remember"><span></span>Remember Me</label>
      </p>

      <p class="forgot">
        <a href="#">Forgot Password?</a>
      </p>
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
  </div> <!--/ Login-->
  <div class="copyright">
    <p>Copyright &copy; 2014. Created by <a href="http://lunarpixel.deviantart.com" target="_blank">LunarPixel</a></p>
  </div>
</body>
</html>