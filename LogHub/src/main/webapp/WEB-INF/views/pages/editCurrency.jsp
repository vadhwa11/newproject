

     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function Reset(){
	document.getElementById("currencyAdd").reset();
	
}


 function currencyFormSubmit(){
    		alert("mmmmmmmmmmm ")
    	 
   $.ajax({
	   
	      
             url: 'addCurrencyPageProcess',
             type: 'post',
             data: $('#currencyAdd').serialize(),
             success:function(response){ 
            	 alert(" nn "+response)
            	 debugger;
            	 console.log("nn "+response)
             if(response==1)
             {
            	 alert(" response :: "+response)
             }
             else{
            	 alert("no data added..")
             }
             }
             });
    		




</script>

</head>
<body>
<p align="center" style="font-size: 20px;margin-left: 70px">Edit Currency Details</p>
<br>

<form id="currencyEdit" action="editCurrencyPageProcess" modelAtrribute="searchparameters" method="post">

 
                    <table width="100%">
                        <tr style="height: 90px">
                        
                           <td style="width: 12%"><font size="2px">Currency Name </font><font color="red">*</font></td>
                            <td>
                                <input id="currencyName" name="currencyName" readonly="true" pattern="^\S+$" value ="${currencyName}" pattern="^\S+$" required="required" style="width: 250px"/>
								
                            </td>
                            <td style="width: 200px">
                            <input type="hidden" name="actualCurrencyName" value="${currencyName}"></td>
                            <td style="width: 12%;"><font size="2px">Currency Value </font><font color="red">*</font></td>
                     
                            
                            <td>
                               <input id="currencyValue" name="currencyValue" type="text" pattern="[0-9]+(\.[0-9]{0,2})?%?" value ="${currencyValue}" required="required" style="width: 250px"/>
                            </td>
							

                           
                        
                            
                           <td style="width: 200px"></td>
                            <td style="width: 10%"><button id="Submit1" type="submit" value="currencyedit"  onclick="editcurrencyFormSubmit()"  style=" width:60px;padding:2px; background: #001a66;margin-left: 50px;color: #FFFFFF;border-radius: 5px; border: none">Update</button>
                            </td>
					</tr>   
                        </table>
                       
            <p style="text-align: center; color: red;">${error}</p>
     <p style="text-align: center; color: green;">${success}</p>            
</form>
</body>
</html>
