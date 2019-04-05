<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
 <link href="<c:url value='/static/css/app.css' />" type="text/css"
	rel="stylesheet"></link>

</head>

<body>
<table style="width: 100%;">
     <tr>
        <td id="header">
            <tiles:insertAttribute name="header"></tiles:insertAttribute>
        </td>
    </tr>
    <tr>
        <td id="sidemenu">
            <tiles:insertAttribute name="menu"></tiles:insertAttribute>
        </td>
        <td id="site-content">
           <tiles:insertAttribute name="body" ></tiles:insertAttribute> 
        </td>
    </tr>
   
</table>
	
</body>
</html>