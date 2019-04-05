<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login Page</title>
<style>
.login-page {
  width: 360px;
  padding: 4% 0 0;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #001a66;
  max-width: 360px;
  margin: 0 auto 10px;
  padding: 25px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #ccccff;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #001a66;
  width: 40%;
  border: 0;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
/* .form button:hover,.form button:active,.form button:focus {
  background: #43A047;
} */
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #000080;
  text-decoration: none;
}
.form .register-form {
  display: none;
}
.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}
body {
    background: url("${pageContext.request.contextPath}/static/img/background1.jpg") no-repeat center center fixed;
   
   -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
	font-size: 12px;

}
</style>

<script type="text/javascript">
 function ForgetPasswordAlert(){
	 
	 alert(" Please Contact to System Administrator ")
	 
 }

</script>
</head>


<body>
<h4><p style="text-align: center; color: red;">${error}</p></h4>

<div class="header" align="center">
		<font size="30" color="white">LogHub</font>
	</div>



	<script type="text/javascript">
          function login() {
        	  document.loginProcess.action="loginProcess";
			
		}
          </script>
<div class="login-page">
	<div class="form">
         <p align="center"><font size="5px" color="white">Login Page</font></p><br>
			<form class="login-form" method="post" name="loginProcess"
				modelAttribute="user">
				 <font size="3px" color="white">User Id </font><input name="userId" type="text" size="30" maxlength="50"
					placeholder="UserId" required="required" autocomplete="on" /><br>
				<font size="3px" color="white">Password </font><input name="password" type="password" size="20"
					placeholder="Password" required="required" maxlength="48" /><br><br>
				<button onclick="login()"><img src="${pageContext.request.contextPath}/static/img/login-btn.png"
					style="width: 80px; height: 40px;"></a></button>

				<p class="message">
					<a href="" onclick="ForgetPasswordAlert()"><font color="White">Forgot Password</a></font>
				</p>
			</form>
			</div>
</body>
</html>
<div class="footer">
			<p><center>All Rights Reserved . Design by SDOT Team</p>
</div> 