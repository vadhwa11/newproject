<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="static/js/jquery.min.js"></script>
<script type="text/javascript">

function Reset(){
	document.getElementById("inventoryTypes").reset();
	
}

$(document).ready(function(){
	
	$('#inventoryStatus').hide();
	$('#inventoryDetails').hide();
	$('#inventoryLpp').hide();
	$('#inventoryStatus1').hide();
	$('#inventoryDetails1').hide();
	$('#inventoryLpp1').hide();
	$('#searchTypes').show();
	
	
	  $("#selectTypes").change(function () { 
     	var select_item = document.getElementById('selectTypes').value;
	     if (select_item == "1") {
	    //	alert("111111111=="+select_item);
         	$('#inventoryStatus').show();
         	$('#inventoryDetails').hide();
         	$('#inventoryLpp').hide();
         	
         	$('#inventoryStatus1').show();
         	$('#inventoryDetails1').hide();
         	$('#inventoryLpp1').hide();
         	$('#searchTypes').hide();
         	//var url = 'searchInventoryStatus';
         	
     	} 
         else if (select_item == "2") {
        //	alert("222222222=="+select_item);
        	$('#inventoryStatus').hide();
         	$('#inventoryDetails').show();
         	$('#inventoryLpp').hide();
         	
         	$('#inventoryStatus1').hide();
         	$('#inventoryDetails1').show();
         	$('#inventoryLpp1').hide();
         	$('#searchTypes').hide();
         //	var url = 'searchInventoryDetails';
     	} 
         
         else if (select_item == "3") {
        	alert("33333333=="+select_item);
         	$('#inventoryStatus').hide();
         	$('#inventoryDetails').hide();
         	$('#inventoryLpp').show();
         	
         	$('#inventoryStatus1').hide();
         	$('#inventoryDetails1').hide();
         	$('#inventoryLpp1').show();
         	$('#searchTypes').hide();
         ///	var url = 'searchInventoryLpp';
     	} 
         else if (select_item == "0") {
        	//alert("44444444=="+select_item);
     		$('#inventoryStatus').hide();
         	$('#inventoryDetails').hide();
         	$('#inventoryLpp').hide();
         	$('#inventoryStatus1').hide();
         	$('#inventoryDetails1').hide();
         	$('#inventoryLpp1').hide();
         	$('#searchTypes').show();
     	}
         else{
        	// alert("44444444=="+select_item);
         	
         }
         
       /*  alert("url=="+url);
        
        
        
            $.ajax({
          url: url,
          type:'get',
          contentType: "application/json",
          dataType: 'json',
          success: function(output_string){
             $('#result_table').append(output_string);
            } // End of success function of ajax form
           }); // End of ajax call
        */
        
        /* $.ajax(
        	    {
        	    	type: 'get',      
        	      url: url,
        	      success: function (data) {
        	        alert(data);
        	      },
        	      error: function (xhr, statusText, err) {
        	        alert("error"+xhr.status);
        	      }
        	    }); */

          $.ajax({   
             url: url,
             type: 'get',      
             datatype: "json",
           //  data: "Item=" + $("#Items").val(),
             success: function (response) {

             },
             error: function (xhr, status, error) {
                 //                                  
                 alert(error);
             } 
         });
     });
 });  

	
</script>

</head>
<body>
 <div id="searchTypes">
 <p align="center" style="font-size: 20px">Search Types</p>
 </div>
 <div id="inventoryStatus1">
 <p align="center" style="font-size: 20px">Status of Inventory</p>
 </div>
  <div id="inventoryDetails1">
 <p align="center" style="font-size: 20px">Inventory Details</p>
 </div>
  <div id="inventoryLpp1">
 <p align="center" style="font-size: 20px">Last Purchase Price(LPP) Details</p>
 </div>
<br>


  <table width="100%">
      <tr style="height: 50px">
       <td><font size="2px">Type of search<font color="white">****</font> </font>
       	           <select name="selectTypes" id="selectTypes">
                       	<option value="0" selected="selected"> Select</option>
					   <option value="1">Status of Inventory</option>
					   <option value="2">Inventory Details </option>
					   <option value="3">Last Purchase Price(LPP) Details</option>
					</select>
		   </td>
                  
      </tr>
      <tr>
       <td>
      	 <div id="inventoryStatus">
      		<form id ="searchInventoryStatus" action="searchInventoryStatus" modelAtribute="inventory" method="get">
      	 		<%--  <jsp:include page="searchInventoryStatus.jsp" />  --%>
      	 			 <table width="100%">
                       
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
                             <td style="width: 10%"><font size="2px">Depot </font></td>
                            <td>
                                <select name="depot" style="width: 200px" id="depot">
                                <option value="">Select</option>
                                <c:forEach items="${depotList}" var="ListItem">
                               <option value="${ListItem.depotName}">${ListItem.depotName}</option>
                               </c:forEach>
                              </select>
                            </td>
                            
                        </tr>
                        
                           <tr style="height: 50px;">
                        
                           <td style="width: 10%"><font size="2px">Second Part Number</font></td>
                            <td>
                                <input id="sPartNo" name="sPartNo" type="text" style="width: 200px"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px"> Equipment</font></td>
                            <td>
                           	 <input id="equipment" name="equipment" type="text" style="width: 200px"/>
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
                                <button type="button" onclick="Reset()" style=" width:60px;padding:2px; background: #001a66;margin-left: 20px;color: #FFFFFF;">Reset</button>
				                <button type="submit" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;">Search</button>
                            </td>
					</tr>   
                        </table>
                       
				     <p style="text-align: center; color: red;">${error}</p>
				     <p style="text-align: center; color: green;">${success}</p>  
				     
				    
            </form> 
         </div>
         
          <div id="inventoryDetails">
         	 <form id ="searchInventoryDetails" action="searchInventoryDetails" modelAtribute="inventory" method="get">
        		 <%-- <jsp:include page="searchInventoryDetails.jsp" />  --%>
        		 
        		 <table width="100%">
                      
                          <tr style="height: 50px;">
                        
                           <td style="width: 10%"><font size="2px">Part Number </font></td>
                            <td>
                                <input id="sPartNo" name="sPartNo" type="text" style="width: 200px"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Description </font></td>
                            <td>
                                <input id="descr" name="descr" type="text" style="width: 200px"/>
                            </td>
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><font size="2px">Depot </font></td>
                            <td>
                                <select name="depot" style="width: 200px">
                                <option value="">Select</option>
                                <c:forEach items="${depotList}" var="ListItem">
                               <option value="${ListItem.depotName}">${ListItem.depotName}</option>
                               </c:forEach>
                              </select>
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
                                <button type="button" onclick="Reset()" style=" width:60px;padding:2px; background: #001a66;margin-left: 20px;color: #FFFFFF;">Reset</button>
				                <button type="submit" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;">Search</button>
                            </td>
						</tr>   
                    </table>
                    
                    
        	 </form> 
         </div>
        
         <div id="inventoryLpp">
         	<form id ="searchInventoryLpp" action="searchInventoryLpp" modelAtribute="inventory" method="get">
        		 <%-- <jsp:include page="searchInventoryLpp.jsp" />   --%>
        		 
        		 
                     <table width="100%">
                  
                        
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
                            <!-- <td style="width: 100px"></td>
                             <td style="width: 10%"><font size="2px"> </font></td>
                            <td>
                            </td> -->
                            
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
                                <button type="button" onclick="Reset()" style=" width:60px;padding:2px; background: #001a66;margin-left: 20px;color: #FFFFFF;">Reset</button>
				                <button type="submit" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;">Search</button>
                            </td>
					</tr>   
                 </table>
                       
           			
            </form>
         </div> 
     
      </td>
       </tr>
    </table>
      
        <!-- Data Grid -->
				     
				     <c:if test="${searchInventoryResult.size()>0}">
				     <table class="project-details">
						<thead>
								<tr>
									<th class="project-details">Part Number</th>
									<th class="project-details">Second Part Number</th>
									<th class="project-details">Description</th>
									<th class="project-details">Depot</th>
									<th class="project-details">Equipment</th>
									<!-- <th>Quantity</th>
									<th>Ledger Number</th> -->
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
									
								</tr>
							</c:forEach>
							</tbody>
						</table>
						</c:if>
					<c:if test="${searchInventoryResult.size() == 0}">
				<h3><p align="center"  style="margin-top: 100px;color: red;">No Record Found !!</p></h3>
				</c:if>
           
         </div>
         
          
     <p style="text-align: center; color: red;">${error}</p>
     <p style="text-align: center; color: green;">${success}</p>            

</body>
</html>
 


