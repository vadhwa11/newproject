<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="static/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/js/datatables.min.css"/>
<script type="text/javascript" src="static/js/datatables.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/js/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="static/js/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="static/css/header.css"/>
<script src="static/js/bootstrap.min.js"></script>
<style type="text/css">

#project-details {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
    text-align: center;
}

#project-details td, #project-details th {
    border: 1px solid #ddd;
    padding: 8px;
    max-width:200px;
    word-wrap:break-word;
}

#project-details tr:nth-child(even){background-color: #f2f2f2;}

#project-details tr:hover {background-color: #ddd;}

#project-details th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: center;
    background-color: #001a66;
    color: white;
    
}

 #dataTable3{
 			width: 750px !important;
			box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
   			transition: 0.3s;
 			
            border: 1px;
            border-style: solid;
    		border-color: black;
    		text-align: center;
          	padding: 0 1.4em 1.4em 1.4em !important;
    		margin: 0 150 1 -5  !important;
        }
        
       #dataTable3,th{
       text-align: center;
       /*  padding-left:10px; */
       padding-right:40px;
       }
       
       #dataTable3,td{
       text-align: left;
       padding-left:10px;
        padding-right:10px;
       } 
.card {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    width: 1240px !important;
    border-radius: 5px;
    background: #ebebe0;
    margin-bottom: 20px;
    
}

.card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.container {
    
    padding: 16px 16px;
}

</style>
</head>
<body>

<script type="text/javascript">


 function Reset(){
	 document.getElementById("form1").reset();
 }
 

 $(document).ready(function() {
     $('#user-details').DataTable();
 } );


</script>

       <h3><p style="text-align: center; font-size: 25px; color: #001a66;">Search User Details</p></h3>
       <h4><p style="text-align: center; color: red;">${error}</p></h4>
     <h4><p style="text-align: center; color: green;">${success}</p></h4>
     </br>


<div class="card">
  <div class="container">
<form id="form1" action="user_details_searchProcess" modelAtrribute="user" method="post">
<table style="width: 100%">

<tr style="height: 40px">
<td>User Name </td>
<td><input type="text" name="userName" ></td>

<td>User ID </td>
<td><input type="text" name="userId"></td>
</tr>

<tr style="height: 40px">
<td>Email Id</td>
<td><input type="text" name="emailId" style="margin-right: 40px;"></td>
<td></td>
<td></td>

</tr>

<tr style="height: 40px">
<td></td>
<td></td>
<td></td>

<td>
 <input id="Submit2" type="button"  value="Reset" onclick="Reset();"  style="width:80px; background: #001a66; color: #FFFFFF; padding-top: 5px;padding-bottom: 5px;padding-left: 10px;padding-right: 10px"/>
<button id="Submit1" type="submit" value="Search" onclick="getList();" style=" width:80px; background: #001a66; color: #FFFFFF; padding-top: 5px;padding-bottom: 5px;padding-left: 10px;padding-right: 10px">Search</button>

</td></tr>
</table>
</form>
</div></div>


<c:if test="${userResult.size() > 0}"> 
  <div id="project-details">
  
		<h3><p align="left" >User Details</p></h3>
		<br>
		<table id="user-details" style="width: 100%">

			<thead>
				<tr>
					<th>User Name</th>
					<th>User Id</th>
					<th>Unit</th>
					<th>Department</th>
					<th>Email Id</th>
					<th>Contact No.</th>
					<th>View Details</th>
					<th>Edit</th>
				</tr>
			</thead>

			<tbody>
	
			<c:forEach items="${userResult}" var="ListItem">
				<tr>
					            <td>${ListItem.userName}</td>
								<td>${ListItem.userId}</td>
								<td>${ListItem.unitName}</td>
								<td>${ListItem.department}</td>
								<td>${ListItem.emailId}</td>
								<td>${ListItem.contactNo}</td>
					<td><a href="${pageContext.request.contextPath}/user_details_viewProcess?id=${ListItem.id}"  style="background: #001a66;color: white;padding: 2px;margin-left: 30px;">View</a></td>
                    <td><a href="${pageContext.request.contextPath}/user_details_viewForUpdateProcess?id=${ListItem.id} "  style="background: #001a66;color: white;padding: 2px;">Edit</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	
	</c:if>
	<c:if test="${userResult.size() == 0}">
<h3><p align="center"  style="margin-top: 100px;color: red;">No Record Found !!</p></h3>
</c:if>

</body>
</html>