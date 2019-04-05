<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<p align="center" style="font-size: 20px">Update SKU</p>
<br>
<form id ="inventoryUpdate" action="updateInventoryProcess" modelAtribute="inventory" method="post">


                    <table width="100%">
                        <tr style="height: 50px">
                        
                           <td style="width: 12%"><font size="2px">SKU </font><font color="red">*</font></td>
                            <td>
                                <input id="sku" name="sku" type="text" value="${inventoryResultForUpdate.sku}" readonly="readonly" required="required" style="width: 200px" maxlength="8"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%;"><font size="2px">UOM </font><font color="red">*</font></td>
                     
                            
                            <td>
                               <select name="uom" required="required" style="width: 200px">
                               
                               <c:forEach items="${uomList}" var="ListItem">
                                <c:if test="${ListItem.uom == inventoryResultForUpdate.uom}">
                               <option value="${ListItem.uom}" selected="selected">${ListItem.uom}</option>
                               </c:if>
                               <c:if test="${ListItem.uom != inventoryResultForUpdate.uom}">
                               <option value="${ListItem.uom}">${ListItem.uom}</option>
                               </c:if>
                               </c:forEach>
                              </select>
                            </td>

                            <td style="width: 200px"></td>

                            <td style="width: 10%"><font size="2px">Depot </font><font color="red">*</font></td>
                            <td>
                                <select name="depot" required="required" style="width: 200px">
                                
                               <c:forEach items="${depotList}" var="ListItem">
                                <c:if test="${ListItem.depotName == inventoryResultForUpdate.depot}">
                               <option value="${ListItem.depotName}" selected="selected">${ListItem.depotName}</option>
                               </c:if>
                               <c:if test="${ListItem.depotName != inventoryResultForUpdate.depot}">
                               <option value="${ListItem.depotName}">${ListItem.depotName}</option>
                               </c:if>
                               </c:forEach>
                               
                               
                                <%-- <option value="">Select</option>
                                <c:forEach items="${depotList}" var="ListItem">
                               <option value="${ListItem.depotName}">${ListItem.depotName}</option>
                               </c:forEach> --%>
                              </select>
                            </td>
                        </tr>
                        
                         <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Quantity </font><font color="red">*</font></td>
                            <td>
                                <input id="icgQty" name="icgQty" type="text" value="${inventoryResultForUpdate.icgQty}" required="required" style="width: 200px"
                                maxlength="10"
                                pattern="\d*"; 
						      	spellcheck="false"
						        title="Quantity should be numeric only" />
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Equipment </font><font color="red">*</font></td>
                            <td>
                                <input id="equipment" name="equipment" type="text" data-toggle="tooltip" title="${inventoryResultForUpdate.equipment}" value="${inventoryResultForUpdate.equipment}" required="required" style="width: 200px" maxlength="100"/>
                            </td>
                            <td style="width: 100px"></td>
                             <td style="width: 10%"><font size="2px">Part Number </font><font color="red">*</font></td>
                            <td>
                                <input id="partNo" name="partNo" type="text" data-toggle="tooltip" title="${inventoryResultForUpdate.partNo}" value="${inventoryResultForUpdate.partNo}" required="required" style="width: 200px" maxlength="60"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Second Part Number </font><font color="red">*</font></td>
                            <td>
                                <input id="sPartNo" name="sPartNo" type="text" data-toggle="tooltip" title="${inventoryResultForUpdate.sPartNo}" value="${inventoryResultForUpdate.sPartNo}" required="required" style="width: 200px" maxlength="60"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Description </font><font color="red">*</font></td>
                            <td>
                                <input id="descr" name="descr" type="text" data-toggle="tooltip" title="${inventoryResultForUpdate.descr}" value="${inventoryResultForUpdate.descr}" required="required" style="width: 200px" maxlength="200"/>
                            </td>
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><font size="2px">Ledger Number </font><font color="red">*</font></td>
                            <td>
                                <input id="ledgerNo" name="ledgerNo" type="text" value="${inventoryResultForUpdate.ledgerNo}" required="required" style="width: 200px" maxlength="15"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Unit Price </font><font color="red">*</font></td>
                            <td>
                                <input id="unitPrice" name="unitPrice" type="text" value="${inventoryResultForUpdate.unitPrice}" required="required" style="width: 200px"
                                maxlength="11"
                                pattern="^[1-9]\d*(\.\d+)?$"; 
						      	spellcheck="false"
						        title="Price should be numeric only" />
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Currency </font><font color="red">*</font></td>
                            
                                <td>
                                
                                <select name="currency" required="required" style="width: 200px">
                                
                               <c:forEach items="${currencyList}" var="ListItem">
                                <c:if test="${ListItem.currencyName == inventoryResultForUpdate.currency}">
                               <option value="${ListItem.currencyName}" selected="selected">${ListItem.currencyName}</option>
                               </c:if>
                               <c:if test="${ListItem.currencyName != inventoryResultForUpdate.currency}">
                               <option value="${ListItem.currencyName}">${ListItem.currencyName}</option>
                               </c:if>
                               </c:forEach>
                              </select>
                            
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><font size="2px">Category </font><font color="red">*</font></td>
                            <td>
                                <input id="cat" name="cat" type="text" value="${inventoryResultForUpdate.cat}" required="required" style="width: 200px" maxlength="6"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Minimum Stock Level </font><font color="red">*</font></td>
                            <td>
                                <input id="msl" name="msl" type="text" value="${inventoryResultForUpdate.msl}" required="required" style="width: 200px"
                                maxlength="6"
                                pattern="\d*"; 
						      	spellcheck="false"
						        title="Minimum Stock Level should be numeric only"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Type of store (xdpt)</font><font color="red">*</font></td>
                            <td>
                                <input id="xDept" name="xDept" type="text" data-toggle="tooltip" title="${inventoryResultForUpdate.xDept}" value="${inventoryResultForUpdate.xDept}" required="required" style="width: 200px" maxlength="20"/>
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
                           
				                <button type="submit" style=" width:60px;padding:2px; background: #001a66;margin-left: 110px;color: #FFFFFF;border-radius: 5px; border: none">Update</button>
                            </td>
					</tr>   
                        </table>
                       
            <p style="text-align: center; color: red;">${error}</p>
     <p style="text-align: center; color: green;">${success}</p>    
  <%--    </c:forEach> --%>        
</form>

</body>
</html>
