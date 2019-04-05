<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="static/js/jquery.min.js"></script>
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
		width: 100%;
	 }
    </style>
    <meta charset="utf-8" />
   
     
     
     <script type="text/javascript">
     
     
     $(document).ready(function(){
    		
    		 $('#orgUnitId')
    	     .change(
    	   		  
    	         function() {
    	       var idval =new Array(2);
    	         idval = document.getElementById('orgUnitId').value.split(",");
    	         //alert(" value now "+StartDate[1])
    	         var unitid=idval[0];
    	         var unitname=idval[1];
    
    	         }  );     
     })

     
     
     
     function Reset(){
    	 //alert("gfgffgggf")
    	 document.getElementById("userAddForm").reset();
     }
     
     
     function isDigits(argvalue) {
    	    argvalue = argvalue.toString();
    	    var validChars = "0123456789";
    	    var startFrom = 0;
    	    if (argvalue.substring(0, 2) == "0x") {
    	       validChars = "0123456789abcdefABCDEF";
    	       startFrom = 2;
    	    } else if (argvalue.charAt(0) == "0") {
    	       validChars = "01234567";
    	       startFrom = 1;
    	    }
    	    for (var n = 0; n < argvalue.length; n++) {
    	        if (validChars.indexOf(argvalue.substring(n, n+1)) == -1) return false;
    	    }
    	  return true;
    	}
     
     
     
     function addFormSubmit(){
    		
    	 
    var ab=document.getElementById('orgUnitId').value;
    	 
    	
    	 var idval =new Array(2);
         idval = document.getElementById('orgUnitId').value.split(",");
         //alert(" value now "+StartDate[1])
         var unitId=idval[0];
         var unitName=idval[1];
          document.userAdd.action='user_details_addProcess?id='+unitId+'&name='+unitName;
    	
    	document.userAdd.method="POST";
    	document.userAdd.submit();
    	 }
    	 
    	
    
     
     
     
    </script>
     
    
</head>

<body>

 
<h1><font size="3px" color="Red">Masters > User Details > Add </font></h1>
       <h3><p style="text-align: center; font-size: 25px; color: #001a66;">Add User Details</p></h3>
       <h4><p style="text-align: center; color: red;">${error}</p></h4>
     <h4><p style="text-align: center; color: green;">${success}</p></h4>
     </br>

<div class="card">
  <div class="container">
  <form id="userAddForm" action="user_details_addProcess" modelAtrribute="searchparameters" method="post">
	<hidden id="userId" name="userId"></hidden>
        <table class="auto-style3">
            <tr>
                <td class="auto-style5">
                    <table class="auto-style4" style="width:105%" >
                        <tr style="height: 40px">
                            <td class="auto-style6">User Name <font color="red">*</font> </td>
                            <td class="auto-style6">
                                <input type="text" id="userName" name="userName"  maxlength="40" required="required" />

                            </td>

                            <td class="auto-style7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</td>

                            <td class="auto-style6">User Id <font color="red">*</font> </td>
                            <td class="auto-style6" style="right: 50px">
                                <input id="userid" type="text" name="userId" value="" maxlength="20"  required="required"/>
                            </td>
                            </tr>
                            
                            <tr style="height: 40px">
                             <td class="auto-style6">Password  <font color="red">*</font> </td>
                            <td class="auto-style6" style="right: 50px">
                                <input id="password" type="text" name="password"   maxlength="20" required="required" />
                            </td>
                        
                            <td class="auto-style7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</td>
                        
                        
                         <td class="auto-style6">Email Id <font color="red">*</font> </td>
                            <td class="auto-style6" style="right: 50px">
                                <input id="emailid" type="text" name="emailId" 	 maxlength="60"
                               	aria-required="true"
						        pattern="^(([-\w\d]+)(\.[-\w\d]+)*@([-\w\d]+)(\.[-\w\d]+)*(\.([a-zA-Z]{2,5}|[\d]{1,3})){1,2})$" 
						        required="required"
						      	spellcheck="false"
						        title="Email should be like user@gmail.com"
						        type="email"
						        value=""
							/>
							 
                            </td>
                            </tr>
                            
                            <tr style="height: 40px">
                            <td class="auto-style6">Contact No. <font color="red">*</font> </td>
                            <td class="auto-style6">
                                <input id="contactNo"  name="contactNo" minlength="10" maxlength="10"
                                type="tel" 
                                aria-required="true"
                                pattern="(0/91)?[7-9][0-9]{9}"
						        required="required"
						      	spellcheck="false"
						        title="Contact number should be 10 digit numeric only"
						        type="tel"
						        value=""/>
                            </td>
                        
                       <!--  pattern="^(?:\(\d{3}\)|\d{3})[- ]?\d{3}[- ]?\d{4}$"  -->
                        
                          <td class="auto-style7"></td>
                             <td class="auto-style6">Unit<font color="red">*</font></td>

                             <td><select id="orgUnitId" class="select" name="orgUnit"  maxlength="100" 
                             aria-required="true"
                              required="required"
						      	spellcheck="false"
						        title=" Please Select Unit">
									<option value="">Select</option>
									<c:forEach items="${unitList}" var="ListItem">

										<option value="${ListItem.unitId},${ListItem.orgUnit}">${ListItem.orgUnit}</option>
									</c:forEach>
								</select>
							</td>
                             
                            
                           <!--  <td class="auto-style6">
                                <input id="orgUnit" name="orgUnit" type="text" maxlength="50"/>
                            </td> -->
                            </tr>
                            
                            <tr style="height: 40px">
                            <td class="auto-style6">Department </td>
                            <td class="auto-style6">
                                <input id="deptId" name="department" type="text" maxlength="50"/>
                            </td>
                        
                            
                            <td></td>
                            <td></td>
                            <tr style="height: 40px">
                            <td></td><td></td><td></td><td></td>
                            <td width="10%; class="auto-style6">
                            <input id="Submit2" type="button"  value="Reset" onclick="Reset();"  style="width:80px; background: #001a66; color: #FFFFFF; padding-top: 5px;padding-bottom: 5px;padding-left: 10px;padding-right: 10px"/>
                            
                            
                            <button id="Submit1" type="submit" value="userAdd"  onclick="addFormSubmit()" style=" width:80px; background: #001a66; color: #FFFFFF; padding-top: 5px;padding-bottom: 5px;padding-left: 10px;padding-right: 0px">Add</button>
                            </td>
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
