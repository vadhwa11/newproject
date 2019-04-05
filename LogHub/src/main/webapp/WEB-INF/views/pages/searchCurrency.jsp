<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script type="text/javascript" src="static/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="static/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="static/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="static/js/buttons.flash.min.js"></script>
<script type="text/javascript" src="static/js/jszip.min.js"></script>
<script type="text/javascript" src="static/js/pdfmake.min.js"></script>
<script type="text/javascript" src="static/js/vfs_fonts.js"></script>
<script type="text/javascript" src="static/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="static/js/buttons.print.min.js"></script>


<link rel="stylesheet" type="text/css" href="static/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="static/css/buttons.dataTables.min.css"/>


<!-- <link rel="stylesheet" type="text/css" href="static/js/datatables.min.css"/>
<script type="text/javascript" src="static/js/datatables.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/js/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="static/js/dataTables.bootstrap.min.css"/>
 -->

<style>
table, th, td {
font-size:14px;
text-align: left;
}

table, td {
font-size:14px;

}

</style>
<script type="text/javascript">


$(document).ready(function() {
	   /*   $('#project-details').DataTable({"bSort": false });  */ 
	     $('#project-details').dataTable( {
	    	 dom: 'Bfrtip',
		        buttons: [
		                  {
		                	  extend: 'print',
		                	  title: '',
		                	  exportOptions: {
		                		  columns: [ 0, 1]
		                		 },
			                  autoPrint: false  
		                	  
		                  } ,
	                  {
	                	  extend: 'excelHtml5',
	                	  title: '',
	                	  exportOptions: {
		                		  columns: [ 0, 1]
		                		 },
		                  autoPrint: false  
	                	  
	                  },
	                  {
	                	  extend: 'pdfHtml5',
	                	  title: '',
	                	  exportOptions: {
		                		  columns: [ 0, 1]
		                		 },
		                  autoPrint: false  
	                	  
	                  } 
		                   
		        ],
		        exportOptions: {
                    columns: [ 0, 1]
                },
	    	 "scrollY": "200px",
	         "scrollCollapse": true,
	          "pageLength": 5,
	    	  "bSort": false
	    	} ); 
	  } );

function Reset(){
	/* document.getElementById("searchcurrency").reset(); */
	document.getElementById("currencyName").value="";
	document.getElementById("currencyValue").value="";
	
}

function returnToPreviousPage (e) {
	  e = e || window.event;
	  // validation code

	  // if invalid
	  if (e.preventDefault) {
	    e.preventDefault();
	  } else {
	    e.returnValue = false;
	  }
	}
	

function submitLpp(e){
	
	var partNo= document.getElementById('partNo').value;
	var descr= document.getElementById('descr').value;
	var equipment= document.getElementById('equipment').value;
	var ledgerNo= document.getElementById('ledgerNo').value;
	
	/* alert("partNo =="+partNo);
	alert("descr =="+descr);
	alert("equipment =="+equipment);
	alert("ledgerNo =="+ledgerNo);
	 */
	
	
	if(partNo =="" && descr=="" && equipment=="" && ledgerNo=="" ){
		alert("Please enter atleast one Search field");
		/*if (window.event) {
            window.event.returnValue = false;
        } else {
            e.preventDefault();
        }
		  e.preventDefault();
		 e.stopPropagation();
		 returnToPreviousPage();*/
		 e.stopPropagation();
		 return false; 
	}
	else{
		//alert("else");
		submitForm();
		return true;
	}
}
	

function submitForm(){
	document.searchInventoryLpp.action="searchInventoryLppProcess";
	document.searchInventoryLpp.method="GET";
	document.searchInventoryLpp.submit(); 
	/* $.ajax({
        url: 'searchInventoryLppProcess',
        type: 'get',
        data:   $('#searchInventoryLpp').serialize(),
        success:function(response)
        {
        }  
	 }); */
}
 	

   
</script>

</head>
<body>
<script type="text/javascript">

function searchAll(){
	//alert("hjjjj")
     var name=document.getElementById("currencyName");
	var name1=name.value;
   //  alert(".... "+name1)
     document.getElementById("currencyName").required = false;
	document.searchCurrencyForm.action='searchAllCurrency';
	document.searchCurrencyForm.method="POST";
	document.searchCurrencyForm.submit();
	
}


function DeleteCurrency(e){
	//var name=document.getElementById("delCurr");
	alert("Do You Really Want To Delete the Currency ?")
	var txt;
    if (confirm("Press a button!")) {
    	document.getElementById("delCurr").submit();
    	return(true);
    } else {
    	e.stopPropagation();
    	return(false);
    }
    //document.getElementById("demo").innerHTML = txt;
	
}



</script>





  <div>
 <p align="center" style="font-size: 20px">Currency Search</p>
 </div>
 <div >
	 <form id="searchcurrency" name="searchCurrencyForm" action="search_currency_page">
       		 
        		 
                   <table width="100%">
                      
					   <tr style="height: 50px;">
                        
                          <td style="width: 12%"><font size="2px">Currency Name </font><font color="red">*</font></td>
                            <td>
                            <c:if test="${ empty currencyName}">
                                <input id="currencyName" name="currencyName" type="text" pattern="^\S+$" required="required" onChange="CheckDuplicateCurrencyName()" style="width: 250px"/>
                            </c:if>
                            
                            <c:if test="${ not empty currencyName}">
                                <input id="currencyName" value ="${currencyName}" name="currencyName" type="text" pattern="^\S+$" required="required" onChange="CheckDuplicateCurrencyName()" style="width: 250px"/>
                            </c:if>
                            
                            </td>
                            
                            <td style="width: 200px"></td>
                            <td style="width: 12%;"><font size="2px">Currency Value </font></td>
                     
                            
                            <td>
                               <input id="currencyValue" name="currencyValue" type="text"  pattern="[0-9]+(\.[0-9]{0,2})?%?" style="width: 250px"/>
                            </td>
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><button type="button" onclick="Reset()" style=" width:60px;padding:2px;margin-left:30px; background: #001a66;color: #FFFFFF;border-radius: 5px; border: none">Reset</button></td>
                            <td >
                                
                            <button type="submit" style=" width:60px;padding:2px; background: #001a66;margin-left: 2px;color: #FFFFFF;border-radius: 5px; border: none">Search</button>
                            </td>
                             <td>
                            <input type="button" value="All" onclick="searchAll()" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;border-radius: 5px; border: none"/>
                            </td>
                        </tr> 
                        </table>
                       
				  
     <!-- Data Grid -->
     <br><br> <br><br>
     <c:if test="${listObject.size()>0}">
       <table  id="project-details"  style="background-color: #001a66" >
			<thead>
					<tr style="color: white">
					<th>Currency Name</th>
					<th>Currency Value</th>
					<th>Edit</th>
					<th>Delete</th>
					
				</tr>
		</thead>
		<tbody>
		<c:forEach items="${listObject}" var="curdto">
				<tr>
				
					<td>${curdto.currencyName}</td>
					<td>${curdto.currencyValue}</td>
					<td>
					<c:if test="${userType == 'admin'}">
					<a href="${pageContext.request.contextPath}/editCurrencyPage?currencyName=${curdto.currencyName}&currencyValue=${curdto.currencyValue}"  style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;border-radius: 5px; border: none">Edit</a>
					</c:if>
					</td>
					
					<td>
					<c:if test="${userType == 'admin'}">
					<a id="delCurr" href="${pageContext.request.contextPath}/deleteCurrencyPage?currencyName=${curdto.currencyName}" onclick="return DeleteCurrency(event);" style=" width:60px;padding:2px; background: #FF0000;margin-left: 30px;color: #FFFFFF;border-radius: 5px; border: none">Delete</a>
					</c:if>
					</td>
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</c:if>
		
		
	<c:if test="${listObject.size() == 0}">
<h3><p align="center"  style="margin-top: 100px;color: red;">No Record Found !!</p></h3>
</c:if>


  <!-- Data Grid -->
     <br><br> <br><br>
     <c:if test="${currencyList.size()>0}">
       <table  id="project-details"  style="background-color: #001a66" >
			<thead>
					<tr style="color: white">
					<th>Currency Name</th>
					<th>Currency Value</th>
					<th>Edit</th>
					<th>Delete</th>
					
				</tr>
		</thead>
		<tbody>
		<c:forEach items="${currencyList}" var="curdto">
				<tr>
				
					<td>${curdto.currencyName}</td>
					<td>${curdto.currencyValue}</td>
					<td>
					<c:if test="${userType == 'admin'}">
					<a href="${pageContext.request.contextPath}/editCurrencyPage?currencyName=${curdto.currencyName}&currencyValue=${curdto.currencyValue}"  style=" width:60px;padding:2px; background: #001a66;margin-left: 10px;color: #FFFFFF;border-radius: 5px; border: none">Edit</a>
					</c:if>
					</td>
					
					<td>
					<c:if test="${userType == 'admin'}">
					<a id="delCurr" href="${pageContext.request.contextPath}/deleteCurrencyPage?currencyName=${curdto.currencyName}" onclick="return DeleteCurrency(event);" style=" width:60px;padding:2px; background: #FF0000;margin-left: 10px;color: #FFFFFF;border-radius: 5px; border: none">Delete</a>
					</c:if>
					</td>
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</c:if>
		
		
	<c:if test="${currencyList.size() == 0}">
<h3><p align="center"  style="margin-top: 100px;color: red;">No Record Found !!</p></h3>
</c:if>

  	<p style="text-align: center; color: red;">${error}</p>
	<p style="text-align: center; color: green;">${success}</p>  
	
	
</form>
</div>	
</body>
</html>







