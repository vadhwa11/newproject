

     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">


/* function CheckDuplicateCurrencyName(){
	//alert("mmmmm")
	var name = document.getElementById('currencyName').value;
	   $.ajax({
           url: 'duplicateCurrencyName?name='+name,
           type: 'get',
           data: {name:name},
           dataType: 'json',
           success:function(response)
           {
        	   if(idval.toLowerCase()== response.poContractNo){
        		   alert("Duplicate Currency Name Not Allowed.. ");
        		   idval = document.getElementById('currencyName').value="";   
        	   }
          	}
       });
	 
 }
 */

function Reset(){
	document.getElementById("currencyAdd").reset();
	
}


 function currencyFormSubmit(){
    	//	alert("mmmmmmmmmmm ")
    	 
 


</script>

</head>
<body>

<script type="text/javascript">


function CheckDuplicateCurrencyName(){
	//alert("mmmmm")
	var name = document.getElementById('currencyName').value;
	//alert('name:: '+name)
	   $.ajax({
           url: 'duplicateCurrencyName?name='+name,
           type: 'get',
           data: {name:name},
           success:function(response)
           {
        	  // alert("response... "+response.length)
           //console.log("response... "+response)
        	   if(response=="yes"){
        		   alert("Duplicate Currency Name Not Allowed.. ");
        		   idval = document.getElementById('currencyName').value="";   
        	   }
          	}
       });
	 
 }
 

function Reset(){
	document.getElementById("currencyAdd").reset();
	
}




</Script>


<br>
<p align="center" style="font-size: 20px">Add Currency Details</p>
<br>
  
<form id ="currencyAdd"  modelAtribute="searchparameters" action="addCurrencyPageProcess" method="post">

 
                    <table width="100%">
                      
					   <tr style="height: 50px;">
                        
                          <td style="width: 12%"><font size="2px">Currency Name </font><font color="red">*</font></td>
                            <td>
                                <input id="currencyName" name="currencyName" type="text" pattern="^\S+$" required="required" onChange="CheckDuplicateCurrencyName()" style="width: 250px"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 12%;"><font size="2px">Currency Value </font><font color="red">*</font></td>
                     
                            
                            <td>
                               <input id="currencyValue" name="currencyValue" type="text" pattern="[0-9]+(\.[0-9]{0,2})?%?"  required="required" style="width: 250px"/>
                            </td>
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><button type="button" onclick="Reset()" style=" width:60px;padding:2px;margin-left:30px; background: #001a66;color: #FFFFFF;border-radius: 5px; border: none">Reset</button></td>
                            <td >
                                
                            <button id="Submit1" type="submit" value="currencyAdd"  onclick="currencyFormSubmit(),CheckDecimal(document.form1.text1)" style=" width:60px;padding:2px; margin-left:30px; background: #001a66;color: #FFFFFF;border-radius: 5px; border: none">Add</button>
                            </td>
                            
                        </tr> 
                        </table>
                       <p style="text-align: center; color: red;">${error}</p>
     <p style="text-align: center; color: green;">${success}</p>    
                       
                  
</form>
</body>
</html>
