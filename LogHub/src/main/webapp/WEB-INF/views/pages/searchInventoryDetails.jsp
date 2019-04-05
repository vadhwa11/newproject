<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="static/js/datatables.min.css"/>
<script type="text/javascript" src="static/js/datatables.min.js"></script> -->

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

<!-- <script type="text/javascript" src="static/js/jszip.min.js"></script>
<script type="text/javascript" src="static/js/pdfmake.min.js"></script>
<script type="text/javascript" src="static/js/vfs_fonts.js"></script>
<script type="text/javascript" src="static/js/buttons.html5.min.js"></script> -->

<style>
table, th, td {
font-size:14px;text-align: left;
}

table, td {
font-size:14px;

}

.loader {
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  width: 120px;
  height: 120px;
  -webkit-animation: spin 2s linear infinite; /* Safari */
  animation: spin 2s linear infinite;
}

/* Safari */
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>
<script type="text/javascript">

/* $(document).ready(function() {
 
     $('#project-details').dataTable( {
    	 "scrollY":"200px",
         "scrollCollapse": true,
          "pageLength": 5,
    	  "bSort": false
    	  
    	} ); 
  } ); */
  $(document).ready(function() {
	    $('#project-details').DataTable( {
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
	                	 /*  exportOptions: {
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
	    "scrollY":"200px",
        "scrollCollapse": true,
         "pageLength": 5,
   	  "bSort": false
	    } );
	} );
$(function () {
    $("#Reset").bind("click", function () {
        $("#depot")[0].selectedIndex = 0;
    });
});


function Reset(){
	document.getElementById("searchInventoryDetails").reset();
	document.getElementById('partNo').value="";
	document.getElementById('descr').value="";
	document.getElementById('depot').selectedIndex = 0;
	
	  var options = document.getElementById('depot').value;

	    for (var i = 0, l = options.length; i < l; i++) {
	        options[i].selected = options[i].defaultSelected;
	    }
	
}

function submitDetails(e){
		var partNo= document.getElementById('partNo').value;
		var descr= document.getElementById('descr').value;
		var depot= document.getElementById('depot').value;
		//alert("depot =="+depot);
		/* alert("partNo =="+partNo);
		alert("descr =="+descr);
		alert("equipment =="+equipment);
		alert("ledgerNo =="+ledgerNo);
		 */
		
		
		if(partNo =="" &&  descr=="" && depot=="" ){
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
		document.searchInventoryDetails.action="searchInventoryDetailsProcess";
		document.searchInventoryDetails.method="GET";
		document.searchInventoryDetails.submit();  
		/* $.ajax({
	         url: 'searchInventoryDetailsProcess',
	         type: 'get',
	         data:   $('#searchInventoryDetails').serialize(),
	         success:function(response)
	         {
	         }  
	 	 }); */
	}




</script>

</head>
<body>
 <div id="inventoryDetails1">
 <p align="center" style="font-size: 20px">Inventory Details</p>
 </div>

 <form id ="searchInventoryDetails" action="searchInventoryDetailsProcess" modelAtribute="inventory" method="post">
        		 <table width="100%">
                      	<!-- <tr style="height: 50px">
					      	 <td><font size="2px">Type of search<font color="white">****</font> </font>
					       	           <select name="selectTypes" id="selectTypes">
					                       	<option value="0" > Select</option>
										   <option value="1" selected="selected">Status of Inventory</option>
										   <option value="2">Inventory Details </option>
										   <option value="3">Last Purchase Price(LPP) Details</option>
										</select>
							   </td>
					                  
					      </tr> -->
                          <tr style="height: 50px;">
                        
                           <td style="width: 10%"><font size="2px">Part Number </font></td>
                            <td>
                               <c:if test="${empty partNo}"> 
                                	  <input id="partNo" name="partNo" type="text" style="width: 200px"/>
                                </c:if>
                                <c:if test="${not empty partNo}"> 
                                	<input id="partNo" name="partNo" value=${partNo} type="text" style="width: 200px"/>
                               </c:if>
                            </td>
                            <td style="width: 250px"></td>
                            <td style="width: 10%"><font size="2px">Description </font></td>
                            <td>
                                <c:if test="${empty descr}"> 
                                	<input id="descr" name="descr" type="text" style="width: 200px"/>
                                </c:if>
                                <c:if test="${not empty descr}"> 
                                	<input id="descr" name="descr" value=${descr} type="text" style="width: 200px"/>
                                </c:if>
                            </td>
                            <td style="width: 250px"></td>
                             <td style="width: 10%"><font size="2px">Depot </font></td>
                            <td>
                                <c:if test="${empty depot}"> 
	                               <select name="depot"  id="depot" style="width: 200px" id="depot">
	                                <option value="">Select</option>
	                                <c:forEach items="${depotList}" var="ListItem">
	                               <option value="${ListItem.depotName}">${ListItem.depotName}</option>
	                               </c:forEach>
	                              </select> 
								</c:if>
								
                               <c:if test="${not empty depot}"> 
	                               <select name="depot" id="depot" style="width: 200px">
	                               
	                               <option value="">Select</option>
	                                <c:forEach items="${depotList}" var="ListItem">
	                                
	                                <c:if test="${ListItem.depotName == depot}">
	                               <option value="${ListItem.depotName}" selected="selected">${ListItem.depotName}</option>
	                               </c:if>
	                              
	                               <c:if test="${ListItem.depotName != depot}">
	                                <option value="${ListItem.depotName}">${ListItem.depotName}</option>
	                               </c:if>
	                               </c:forEach>
	                                
	                              </select>
                               </c:if>
                            </td>
                            
                       
                         
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
                                <button type="button"  onclick="Reset()" style=" width:60px;padding:2px; background: #001a66;margin-left: 20px;color: #FFFFFF;border-radius: 5px; border: none">Reset</button>
				                <button type="submit" onclick="return submitDetails(event)" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;border-radius: 5px; border: none">Search</button>
                            </td>
						</tr>   
                    </table>
                 
                <br>   </br>
                         <!-- Data Grid -->
				     <!-- <div class="loader"></div> -->
				     <c:if test="${searchInventoryResult.size()>0}">
				   
				     <table  id="project-details"  style="background-color: #001a66" bordercolor="#001a66">
						<thead>
								<tr style="color: white">
									<th>Part Number</th>
									<th>Second Part Number</th>
									<th>Description</th>
									<th>Depot</th>
									<th>Equipment</th>
									<th>Quantity</th>
									<th>UOM</th>
									<th>Ledger Number</th>
									<th>Unit Price</th>
									<th>Currency</th>
								</tr>
						</thead>
						<tbody>
						<c:forEach items="${searchInventoryResult}" var="ListItem">
								<tr>
								
									<td>${ListItem.partNo}</td>
									<td>${ListItem.sPartNo}</td>
									<td>${ListItem.descr}</td>
									<td>${ListItem.depot}</td>
									<td>${ListItem.equipment}</td>
									<td>${ListItem.icgQty}</td>
									<td>${ListItem.uom}</td>
									<td>${ListItem.ledgerNo}</td>
									<td>${ListItem.unitPrice}</td>
									<td>${ListItem.currency}</td>
									
								</tr>
							</c:forEach>
							</tbody>
						</table>
						  
						</c:if>
					<c:if test="${searchInventoryResult.size() == 0}">
				<h3><p align="center"  style="margin-top: 100px;color: red;">No Record Found !!</p></h3>
				</c:if>
                       
                       
            <p style="text-align: center; color: red;">${error}</p>
     <p style="text-align: center; color: green;">${success}</p>            
</form>
</body>
</html>



