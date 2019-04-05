<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="static/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/css/header.css"/>
<script src="static/js/bootstrap.min.js"></script> 
<title>Insert title here</title>
<style type="text/css">
 /* .test,th{
       text-align: right;
        padding-left:10px; 
       padding-right:40px;
       } */
</style>
</head>
<body>


<table  style="width:100%;background-color: #213f96">
<thead>
  <tr>
   <!--  <th width: 80px;></th>
     <th width: 80px;></th>
      <th width: 80px;></th>
    <th><font color="#001a66"><center> <h2> LogHub </h2></center></th> -->
    <td style="width: 90%;"><font color="white" size="5px"><center><font color="#213f96">LogHubLo</font>LogHub</center></td>
  <td style="padding: 10px">
  <ul class="nav navbar-nav addidToHref " style="float: right">
            
              <li class="dropdown">
				  <button style="background-color: #001a66" class="btn btn-primary dropdown-toggle"  type="button" data-toggle="dropdown">${userName}
				  </br>${orgUnit}
				  <span class="caret"></span></button>
				  <ul class="dropdown-menu">
				 	 <li><a href="${pageContext.request.contextPath}/loggedOut">Logout</a></li>
				  </ul>
              </li>
          </ul> 
  </td>
  </tr>
  </thead>
</table>


</body>
</html>