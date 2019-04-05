<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
 /* $(document).ready(function() {
	  
	     document.getElementById("sku").value = localStorage.getItem("sku");
	  
	  } );  */

	 /*  $(document).ready(function() {
		  
		     document.getElementById("sku").value = "";
		  
		  } );  */

	  /*    $(window).on('beforeunload', function() {
	    localStorage.setItem("sku",document.getElementById("sku").value);
	    
	  });   */
</script>
</head>
<body>
<p align="center" width="100%" style="font-size: 20px">Search SKU</p>

<br>
<form action="searchInventoryProcess" modelAtribute="inventory" method="post">

<table width="100%">
                        <tr style="height: 50px">
                        
                          <!--  <td style="width: 10%"><font size="2px">SKU </font><font color="red">*</font></td>
                            <td>
                                <input id="sku" name="sku" type="text" required="required" style="width: 200px"/></td>
                                <td style="width: 200px"></td>
                               <td> <button type="submit" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;">Search</button>
                            </td>
                             <td style="width: 60%"></td> -->
                             
                        <td style="width: 12%"><font size="2px">SKU </font><font color="red">*</font></td>
                            <td style="width: 200px">
                            <c:if test="${empty sku}"> 
                                <input id="sku" name="sku" type="text" required="required" style="width: 200px"/>
                                </c:if>
                                <c:if test="${not empty sku}"> 
                                <input id="sku" name="sku" value=${sku} type="text" required="required" style="width: 200px"/>
                                </c:if>
                                </td>
                                <td style="width: 200px"></td>
                               <td> <button type="submit" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;border-radius: 5px; border: none">Search</button>
                            </td>
                           <td style="width: 10%"></td>
                            <td style="width: 200px">
                               
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"></td>
                     
                            
                            <td style="width: 200px">
                               
                            </td>

                            <td style="width: 200px"></td>

                            <td style="width: 10%"></td>
                            <td style="width: 200px">
                                
                            </td>
                        </tr>
                           
                            </table>
</form>

<br>
<c:if test="${inventoryResult.size() > 0}"> 
<c:forEach items="${inventoryResult}" var="ListItem">
<form id ="inventoryAdd" action="inventoryAddProcess" modelAtribute="inventory" method="post">

 
                    <table width="100%">
                        <tr style="height: 50px">
                        
                           <td style="width: 12%"><font size="2px">SKU </font><font color="red">*</font></td>
                            <td>
                                <input value="${ListItem.sku }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.sku }"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%;"><font size="2px">UOM </font><font color="red">*</font></td>
                     
                            
                            <td>
                               <input value="${ListItem.uom }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.uom }"/>
                              
                            </td>

                            <td style="width: 200px"></td>

                            <td style="width: 10%"><font size="2px">Depot </font><font color="red">*</font></td>
                            <td>
                                <input value="${ListItem.depot }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.depot }"/>
                            </td>
                        </tr>
                        
                         <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Quantity </font><font color="red">*</font></td>
                            <td>
                                <input value="${ListItem.icgQty }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.icgQty }"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Equipment </font><font color="red">*</font></td>
                            <td>
                                <input value="${ListItem.equipment }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.equipment }"/>
                            </td>
                            <td style="width: 100px"></td>
                             <td style="width: 10%"><font size="2px">Part Number </font><font color="red">*</font></td>
                            <td>
                                <input value="${ListItem.partNo }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.partNo }"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Second Part Number </font><font color="red">*</font></td>
                            <td>
                                <input value="${ListItem.sPartNo }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.sPartNo }"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Description </font><font color="red">*</font></td>
                            <td>
                                <input value="${ListItem.descr }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.descr }"/>
                            </td>
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><font size="2px">Ledger Number </font><font color="red">*</font></td>
                            <td>
                                <input value="${ListItem.ledgerNo }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.ledgerNo }"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Unit Price </font><font color="red">*</font></td>
                            <td>
                                <input value="${ListItem.unitPrice }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.unitPrice }"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Currency </font><font color="red">*</font></td>
                            
                                <td>
                                 <input value="${ListItem.currency }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.currency }"/>
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><font size="2px">Category </font><font color="red">*</font></td>
                            <td>
                                 <input value="${ListItem.cat }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.cat }"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Minimum Stock Level </font><font color="red">*</font></td>
                            <td>
                                 <input value="${ListItem.msl }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.msl }"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Type of store (xdpt)</font><font color="red">*</font></td>
                            <td>
                                 <input value="${ListItem.xDept }" type="text" required="required" style="width: 200px" readonly="readonly" data-toggle="tooltip" title="${ListItem.xDept }"/>
                            </td>
                           <!--  <td style="width: 200px"></td>
                             <td style="width: 10%">Part Number <font color="red">*</font></td>
                            <td>
                                <input id="partNumber" name="partNumber" type="text" required="required" style="width: 200px"/>
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
                           
                            </td>
					</tr>   
                        </table>
    <c:set var="inventoryResultForUpdate"  value="${ListItem}" scope="session"/>                    
               
</form>


<c:if test="${userType == 'admin'}">
<a href="${pageContext.request.contextPath}/updateInventory">For update please click here</a>
</c:if>
</c:forEach>
</c:if>
<c:if test="${inventoryResult.size() == 0}">
<p style="color: red">No Record Found !!</p>
</c:if>
<p style="text-align: center; color: red;">${error}</p>
     <p style="text-align: center; color: green;">${success}</p>  
</body>
</html>
