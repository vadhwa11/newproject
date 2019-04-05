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

<link rel="stylesheet" type="text/css" href="static/js/datatables.min.css"/>
<script type="text/javascript" src="static/js/datatables.min.js"></script>
<link rel="stylesheet" type="text/css" href="static/js/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="static/js/dataTables.bootstrap.min.css"/>


<style>
table, th, td {
font-size:14px;
}

/* p{
font-size:14px;
} */

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
			                  autoPrint: false  
		                	  
		                  } ,
	                  {
	                	  extend: 'excelHtml5',
	                	  title: '',
	                	  /* exportOptions: {
	                		  columns: [ 0, 1,2,3,4,5,6]
	                		 }, */
		                  autoPrint: false  
	                	  
	                  },
	                  {
	                	  extend: 'pdfHtml5',
	                	  title: '',
	                	  /* exportOptions: {
	                		  columns: [ 0, 1,2,3,4,5,6]
	                		 }, */
		                  autoPrint: false  
	                	  
	                  } 
		                   
		        ],
	    	 "scrollY": "200px",
	         "scrollCollapse": true,
	          "pageLength": 5,
	    	  "bSort": false
	    	} ); 
	  } );


function Reset(){
	document.getElementById("inventoryAdd").reset();
	
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
  <div>
 <p align="center" style="font-size: 20px">Reference For (LPP) Details</p>
 </div>
 <div >
	 <form id ="referenceForLPPForm" action="refrenceForLPP" modelAtribute="inventory" method="get">
       		 
        		 <table width="100%">
        		 <tr>
        		 <td style="width: 1400px">
        		 
        		 </td>
        		 </tr>
        		 </table>
                    <!-- <table width="100%">
                      	 <tr style="height: 50px">
					      	 <td><font size="2px">Type of search<font color="white">****</font> </font>
					       	           <select name="selectTypes" id="selectTypes">
					                       	<option value="0" > Select</option>
										   <option value="1" selected="selected">Status of Inventory</option>
										   <option value="2">Inventory Details </option>
										   <option value="3">Last Purchase Price(LPP) Details</option>
										</select>
							   </td>
					                  
					      </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 10%"><font size="2px">Part Number </font></td>
                            <td>
                                <input id="partNo" name="partNo" type="text" style="width: 200px"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Description </font></td>
                            <td>
                                <input id="descr" name="descr" type="text" style="width: 200px"/>
                            </td>
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><font size="2px">Equipment </font></td>
                            <td>
                                  <input id="equipment" name="equipment" type="text" style="width: 200px"/>
                            
                            </td>
                            
                        </tr>
                        
                           <tr style="height: 50px;">
                        
                           <td style="width: 10%"><font size="2px">Ledger Number</font></td>
                            <td>
                                <input id="ledgerNo" name="ledgerNo" type="text" style="width: 200px"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px"> </font></td>
                            <td>
                            </td>
                            <td style="width: 100px"></td>
                             <td style="width: 10%"><font size="2px"> </font></td>
                            <td>
                            </td>
                            
                        </tr>
                          
                         
                         <tr style="height: 50px;">
				           <td style="width: 10%"></td>
                            <td style="width: 200px">
                                
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"></td>
                            <td style="width: 200px">
                               
                            </td>
                          <td style="width: 200px"></td>
                             <td style="width: 10%"></td>
                             
                            <td>
                                <button type="button" onclick="Reset()" style=" width:60px;padding:2px; background: #001a66;margin-left: 20px;color: #FFFFFF;border-radius: 5px; border: none">Reset</button>
				                <button type="submit"  id="submit" onclick="return submitLpp(event)" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;border-radius: 5px; border: none">Search</button>
                            
                            </td>
					</tr>   
                 
                 </table> -->
                       
				  
     <!-- Data Grid -->
     
     <c:if test="${listOfRefForLLP.size()>0}">
       <table  id="project-details"  style="background-color: #001a66">
			<thead>
					<tr style="color: white">
					<th>Supply Order Number</th>
					<th>Supply Order Date</th>
					<th>Supplier</th>
					<th>CRV Number</th>
					<th>CRV Date</th>
					<th>Depot where Supply was done</th>
					<th>Unit Price</th>
					<th>Currency</th>
					
				</tr>
		</thead>
		<tbody>
		<c:forEach items="${listOfRefForLLP}" var="ListItem">
				<tr>
				
					<td>${ListItem.supplyOrderNo}</td>
					<td>${ListItem.supplyOrderDate}</td>
					<td>${ListItem.supplier}</td>
					<td>${ListItem.crvNo}</td>
					<th>${ListItem.crvDate}</th>
					<th>${ListItem.depot}</th>
					<th>${ListItem.unitPrice}</th>
					<th>${ListItem.currency}</th>
					
					
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</c:if>
	<c:if test="${listOfRefForLLP.size() == 0}">
		<h3><p align="center"  style="margin-top: 100px;color: red;">No Record Found for Refrence For LLP !!</p></h3>
		
	</c:if>
  	<p style="text-align: center; color: red;">${error}</p>
	 
	
	
</form>
</div>	
</body>
</html>







