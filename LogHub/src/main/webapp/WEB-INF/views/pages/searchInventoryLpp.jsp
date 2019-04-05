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
	                		  columns: [ 0, 1,2,3,4,5,6]
	                		 },
		                  autoPrint: false  
	                	  
	                  },
	                  ,
	                  {
	                	  extend: 'excelHtml5',
	                	  title: '',
	                	  exportOptions: {
	                		  columns: [ 0, 1,2,3,4,5,6]
	                		 },
		                  autoPrint: false  
	                	  
	                  },
	                  {
	                	  extend: 'pdfHtml5',
	                	  title: '',
	                	  exportOptions: {
	                		  columns: [ 0, 1,2,3,4,5,6]
	                		 },
		                  autoPrint: false  
	                	  
	                  } 
	                  /* {
	                	  extend: 'copyHtml5',
	                	  title: '',
	                	  exportOptions: {
	                		  columns: [ 0, 1,2,3,4,5,6]
	                		 },
		                  autoPrint: false  
	                	  
	                  }, */
	                  
	        ],
    	 "scrollY": "200px",
         "scrollCollapse": true,
          "pageLength": 5,
    	  "bSort": false
    	} ); 
  } );


function Reset(){
	document.getElementById("searchInventoryLpp").reset();
	//alert("reset");
	document.getElementById('partNo').value="";
	document.getElementById('descr').value="";
	document.getElementById('equipment').value="";
	document.getElementById('ledgerNo').value="";
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
 <p align="center" style="font-size: 20px">Last Purchase Price(LPP) Details</p>
 </div>
 <div >
	 <form id ="searchInventoryLpp" action="searchInventoryLppProcess" modelAtribute="inventory" method="post">
       		 
        		 
                    <table width="100%">
                      	<!--  <tr style="height: 50px">
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
                        
                           <td style="width: 12%"><font size="2px">Part Number </font></td>
                            <td>
                               <c:if test="${empty partNo}"> 
                                	<input id="partNo" name="partNo" type="text" style="width: 200px"/>
                                </c:if>
                                <c:if test="${not empty partNo}"> 
                                	<input id="partNo" name="partNo" value=${partNo} type="text" style="width: 200px"/>
                                </c:if>
                            </td><br>
                            <td style="width: 225px"></td>
                            <td style="width: 10%"><font size="2px">Description </font></td>
                            <td>
                                <c:if test="${empty descr}"> 
                                	<input id="descr" name="descr" type="text" style="width: 200px"/>
                                </c:if>
                                <c:if test="${not empty descr}"> 
                                	<input id="descr" name="descr" value=${descr} type="text" style="width: 200px"/>
                                </c:if>
                            </td>
                            <td style="width: 225px"></td>
                             <td style="width: 10%"><font size="2px">Equipment </font></td>
                            <td>
                                <c:if test="${empty equipment}"> 
                                	 <input id="equipment" name="equipment" type="text" style="width: 200px"/> 
                                </c:if>
                                <c:if test="${not empty equipment}"> 
                                	<input id="equipment" name="equipment" value=${equipment} type="text" style="width: 200px"/>
                               </c:if>
                            
                            </td>
                            
                        </tr>
                        
                           <tr style="height: 50px;">
                        
                           <td style="width: 10%"><font size="2px">Ledger Number</font></td>
                            <td>
                                
                                <c:if test="${empty ledgerNo}"> 
                                	 <input id="ledgerNo" name="ledgerNo" type="text" style="width: 200px"/>
                                </c:if>
                                <c:if test="${not empty ledgerNo}"> 
                                	<input id="ledgerNo" name="ledgerNo" value=${ledgerNo} type="text" style="width: 200px"/>
                               </c:if>
                            </td>
                            <td style="width: 200px"></td>
                           <!--  <td style="width: 10%"><font size="2px"> </font></td>
                            <td>
                            </td> -->
                           
                       <%--     
                           <td style="width: 10%"><font size="2px">Depot</font></td>
                            <td>
                                
                                <c:if test="${empty ledgerNo}"> 
                                	 <input id="depot" name="depot" type="text" style="width: 200px"/>
                                </c:if>
                                <c:if test="${not empty ledgerNo}"> 
                                	<input id="depot" name="depot" value=${ledgerNo} type="text" style="width: 200px"/>
                               </c:if>
                            </td>
                            <td style="width: 200px"></td>
                          <!--   <td style="width: 10%"><font size="2px"> </font></td>
                            <td>
                            </td> -->
                            
                            
                            
                            
                            <td style="width: 10%"><font size="2px">Quantity</font></td>
                            <td>
                                
                                <c:if test="${empty ledgerNo}"> 
                                	 <input id="icgQty" name="icgQty" type="text" style="width: 200px"/>
                                </c:if>
                                <c:if test="${not empty ledgerNo}"> 
                                	<input id="icgQty" name="icgQty" value=${ledgerNo} type="text" style="width: 200px"/>
                               </c:if>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px"> </font></td>
                            <td>
                            </td>
                           
                            --%>
                           
                           
                           
                            
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
                 
                 </table>
                       
                </br>    
				  
     <!-- Data Grid -->
     
     <c:if test="${searchInventoryResult.size()>0}">
      <table  id="project-details"  style="background-color: #001a66" bordercolor="#001a66">
			<thead>
					<tr style="color: white">
					<th>Part Number</th>
					<th>Second Part Number</th>
					<th>Description</th>
					<th>Equipment</th>
					<th>Ledger Number</th>
					<th>Unit Price</th>
					<th>Currency</th>
					<th>Depot</th>
					<th>Quantity</th>
					<th>Reference Of LPP</th>
				</tr>
		</thead>
		<tbody>
		<c:forEach items="${searchInventoryResult}" var="ListItem">
				<tr>
				
					<td>${ListItem.partNo}</td>
					<td>${ListItem.sPartNo}</td>
					<td>${ListItem.descr}</td>
					<td>${ListItem.equipment}</td>
					<th>${ListItem.ledgerNo}</th>
					<th>${ListItem.unitPrice}</th>
					<th>${ListItem.currency}</th>
					<th>${ListItem.depot}</th>
					<th>${ListItem.icgQty}</th>
					<th><a href="${pageContext.request.contextPath}/refrenceForLPP?sku=${ListItem.sku}">Reference Of LPP</a></th>
					
				<input type="hidden" name="sku" value="${ListItem.sku}"/>	

					
					
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
</div>	
</body>
</html>