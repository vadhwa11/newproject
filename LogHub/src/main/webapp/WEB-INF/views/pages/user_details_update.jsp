<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="static/css/header.css"/>
<link rel="stylesheet" type="text/css" href="static/js/bootstrap.min.css"/>
<script src="static/js/bootstrap.min.js"></script>
     <style type="text/css">
     
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
       
        .auto-style1 {
            width: 36%;
            margin-left: 323px;
        }

        .auto-style3 {
            width: 80%;
            height: 69px;
            
        }

        .auto-style4 {
            width: 98%;
        }

        .auto-style5 {
            width: 930px;
        }

        .auto-style6 {
            height: 26px;
        }

        .auto-style7 {
            width: 45px;
        }
        
        .select{
		width: 44%;
	 }
    </style>
    <meta charset="utf-8" />
    
    
   <!--  <script type="text/javascript">
    
    function AddUser(){
    	
    	alert("hjhjjhhjhj....")
    	windows.location.href="/user_details_addProcess";
    }
    
    </script>
     -->
    
</head>

<body>
<h1><font size="3px" color="Red">Masters > User Details > Update</font></h1>
<h2>${mesg}</h2>
    
        <br/>
        <table class="auto-style1">
            <tr>
                <td style="text-align: center; font-size: 30px; color: #001a66;"><h3>Update User Details</h3></td>
            </tr>
        </table>
<br>
<div class="card">
  <div class="container">
  <form id="form1" action="user_details_updateProcess?id=${userId} " modelAtrribute="userupdatepage" method="post">
	<hidden id="userId" name="userId"></hidden>
        <table class="auto-style3">
            <tr>
                <td class="auto-style5">
                    <table class="auto-style4" style="width:125%" >
                        <tr style="height: 40px">
                            <td class="auto-style6">User Name <font color="red">*</td>
                            <td class="auto-style6">
                                <input id="userName" name="userName" maxlength="40" value="${userDetails.userName}" />

                            </td>

                            <td class="auto-style7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</td>

                            <td class="auto-style6">User Id <font color="red">* </td>
                            <td class="auto-style6" style="right: 50px">
                                <input id="userid" type="text" name="userId" maxlength="20" value="${userDetails.userId}"/>
                            </td>
                            </tr>
                            
                            <tr style="height: 40px">
                             <td class="auto-style6">Password <font color="red">* </td>
                            <td class="auto-style6" style="right: 50px">
                                <input id="password"  type="text" name="password" maxlength="20" value="${userDetails.password}"/>
                            </td>
                        
                            <td class="auto-style7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</td>
                        
                        
                         <td class="auto-style6">Email Id <font color="red">*</td>
                            <td class="auto-style6" style="right: 50px">
                                <input id="emailid" type="text" maxlength="60" name="emailId" 
                                aria-required="true"
						        pattern="^(([-\w\d]+)(\.[-\w\d]+)*@([-\w\d]+)(\.[-\w\d]+)*(\.([a-zA-Z]{2,5}|[\d]{1,3})){1,2})$" 
						        required="required"
						      	spellcheck="false"
						        title="Email should be like user@gmail.com"
						        type="email"
                                
                                 value="${userDetails.emailId}"/>
                            </td>
                            </tr>
                            
                            <tr style="height: 40px">
                            <td class="auto-style6">Contact No.<font color="red">*</td>
                            <td class="auto-style6">
                                <input id="contactNo"  name="contactNo" type="text" 
                                minlength="10" maxlength="10"
                                type="tel" 
                                aria-required="true"
                                pattern="(0/91)?[7-9][0-9]{9}"
						        required="required"
						      	spellcheck="false"
						        title="Contact number should be 10 digit numeric only"
						        type="tel"
						        value="${userDetails.contactNo}" />
                            </td>
                            
                           <!--  pattern="^(?:\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}$"  -->
						       
                        
                          <%--<td class="auto-style7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</td>
                             <td class="auto-style6">Unit<font color="red">*</td>
                            <td class="auto-style6">
                            
                            <select name="orgUnit" id="orgUnit" style="width: 51%">
                                 <c:forEach items="${listOfUnits}" var="ListItem">
                                <c:if test="${ListItem == userDetails.orgUnit }">
                               <option value="${userDetails.orgUnit}" selected="selected">${userDetails.orgUnit}</option>
                               </c:if>
                               <c:if test="${ListItem != userDetails.orgUnit}">
                               <option value="${ListItem.unitId},${ListItem.orgUnit}">${ListItem.orgUnit}</option>
                               </c:if>
                               </c:forEach>
                               </select>
                          
                                
                            </td>
                             --%>
                                                   
                            
	                             <td class="auto-style7"></td>
	                             <td class="auto-style6">Unit<font color="red">*</font></td>
	
	                             <td>
	                             <select name="orgUnit" id="orgUnit" style="width: 51%" required="required">
                                 <c:forEach items="${listOfUnits}" var="ListItem">
                                <c:if test="${ListItem.orgUnit == userDetails.orgUnit}">
                               <option value="${ListItem.unitId},${ListItem.orgUnit}" selected="selected">${ListItem.orgUnit}</option>
                               </c:if>
                               <c:if test="${ListItem != userDetails.orgUnit}">
                               <option value="${ListItem.unitId},${ListItem.orgUnit}">${ListItem.orgUnit}</option>
                               </c:if>
                               </c:forEach>
                               </select>
								</td>
                            </tr>
                            
                            <tr style="height: 40px">
                            <td class="auto-style6">Department </td>
                            <td class="auto-style6">
                                <input id="deptId" name="department" type="text" maxlength="50" value="${userDetails.department}" />
                            </td>
                        
                            
                            <td></td>
                            <td></td>
                            <td class="auto-style6">
                            </td>
                            <td class="auto-style6">
                                
                           </td>
                        </tr>
                        
                          <tr style="height: 40px">
                        
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td class="auto-style6">
                            <button type="submit" name="Update" onclick="AddUser()" style=" width:80px; background: #001a66; color: #FFFFFF; padding-top: 5px;padding-bottom: 5px;padding-left: 10px;padding-right: 10px;; margin-left: 15px;" >Update</button>
                            </td>
                        <td class="auto-style6"></td>
                        </tr>
                       </table>
                </td>
            </tr>
      
        </table>
         </form>
</div>
</div>

   
</body>
</html>
