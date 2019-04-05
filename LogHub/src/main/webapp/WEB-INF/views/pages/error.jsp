<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
<style type="text/css">
body {
    background: url("${pageContext.request.contextPath}/static/img/background1.jpg") no-repeat center center fixed;
   
   -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
	font-size: 12px;

}
</style>
</head>
<body>
<body>

	<div class="header" align="center" >
		<font size="30" color="white">Indian Coast Guard</font>
		<br>
		<font size="3" color="white">Ministry of Defence</font>
	</div>
	</br>
	</br>
	</br>
	</br>
	<!-- <a style="color: #FF0000"/> -->
		<center>
			<h3 style="color: #FF0000">UserId/ Password is wrong- Please Try Again</h3>
			<h4 style="color: #FF0000">To login again</h4>
			<a href="${pageContext.request.contextPath}/"><font color="white">click here
			</font></a>
		</center>
</body>
</html>
