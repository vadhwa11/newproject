<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function Reset(){
	//document.getElementById("inventoryAdd").reset();
	//document.getElementById('sku').value="";
	document.getElementById('icgQty').value="";
	document.getElementById('equipment').value="";
	document.getElementById('partNo').value="";
	document.getElementById('sPartNo').value="";
	document.getElementById('descr').value="";
	document.getElementById('ledgerNo').value="";
	document.getElementById('unitPrice').value="";
	document.getElementById('cat').value="";
	document.getElementById('msl').value="";
	document.getElementById('xDept').value="";
	document.getElementById('error').value="";
	document.getElementById('depot').selectedIndex = 0;
	document.getElementById('uom').selectedIndex = 0;
	document.getElementById('currency').selectedIndex = 0;
	
	  var options1 = document.getElementById('depot').value;

	    for (var i = 0, l = options.length; i < l; i++) {
	        options1[i].selected = options1[i].defaultSelected;
	    }
	    var options2 = document.getElementById('uom').value;

	    for (var i = 0, l = options.length; i < l; i++) {
	        options2[i].selected = options2[i].defaultSelected;
	    }
	    var options3 = document.getElementById('currency').value;

	    for (var i = 0, l = options.length; i < l; i++) {
	        options3[i].selected = options3[i].defaultSelected;
	    }
}

</script>

</head>
<body>

<p align="center" style="font-size: 20px">Add SKU</p>
<br>
<form id ="inventoryAdd" action="addInventoryProcess" modelAtribute="inventory" method="post">

<c:if test="${empty inventory.sku}">
 
                    <table width="100%">
                        <tr style="height: 50px">
                        
                           <td style="width: 12%"><font size="2px">SKU </font><font color="red">*</font></td>
                            <td>
                                <input id="sku" name="sku" type="text" value="${sku}" readonly="readonly" required="required" style="width: 200px" maxlength="8"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%;"><font size="2px">UOM </font><font color="red">*</font></td>
                     
                            
                            <td>
                               <select id="uom" name="uom" required="required" style="width: 200px">
                               <option value="">Select</option>
                                <c:forEach items="${uomList}" var="ListItem">
                               <option value="${ListItem.uom}">${ListItem.uom}</option>
                               </c:forEach>
                               
                              </select>
                            </td>

                            <td style="width: 200px"></td>

                            <td style="width: 10%"><font size="2px">Depot </font><font color="red">*</font></td>
                            <td>
                                <select id="depot" name="depot" required="required" style="width: 200px">
                                <option value="">Select</option>
                                <c:forEach items="${depotList}" var="ListItem">
                               <option value="${ListItem.depotName}">${ListItem.depotName}</option>
                               </c:forEach>
                              </select>
                            </td>
                        </tr>
                        
                         <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Quantity </font><font color="red">*</font></td>
                            <td>
                                <input id="icgQty" name="icgQty" type="text" required="required" style="width: 200px"
                                maxlength="10"
                                pattern="\d*"; 
						      	spellcheck="false"
						        title="Quantity should be numeric only"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Equipment </font><font color="red">*</font></td>
                            <td>
                                <input id="equipment" name="equipment" type="text" required="required" style="width: 200px" maxlength="100"/>
                            </td>
                            <td style="width: 100px"></td>
                             <td style="width: 10%"><font size="2px">Part Number </font><font color="red">*</font></td>
                            <td>
                                <input id="partNo" name="partNo" type="text" required="required" style="width: 200px" maxlength="60"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Second Part Number </font><font color="red">*</font></td>
                            <td>
                                <input id="sPartNo" name="sPartNo" type="text" required="required" style="width: 200px" maxlength="60"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Description </font><font color="red">*</font></td>
                            <td>
                                <input id="descr" name="descr" type="text" required="required" style="width: 200px" maxlength="200"/>
                            </td>
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><font size="2px">Ledger Number </font><font color="red">*</font></td>
                            <td>
                                <input id="ledgerNo" name="ledgerNo" type="text" required="required" style="width: 200px" maxlength="15"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Unit Price </font><font color="red">*</font></td>
                            <td>
                                <input id="unitPrice" name="unitPrice" type="text" required="required" style="width: 200px" 
                                maxlength="11"
                                pattern="^[1-9]\d*(\.\d+)?$"; 
						      	spellcheck="false"
						        title="Price should be numeric only" />
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Currency </font><font color="red">*</font></td>
                            
                                <td>
                                <select id="currency" name="currency" required="required" style="width: 200px">
                                <option value="">Select</option>
                                <c:forEach items="${currencyList}" var="ListItem">
                               <option value="${ListItem.currencyName}">${ListItem.currencyName}</option>
                               </c:forEach>
                              </select>
                            
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><font size="2px">Category </font><font color="red">*</font></td>
                            <td>
                                <input id="cat" name="cat" type="text" required="required" style="width: 200px" maxlength="6"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Minimum Stock Level </font><font color="red">*</font></td>
                            <td>
                                <input id="msl" name="msl" type="text" required="required" style="width: 200px"
                                 maxlength="6"
                                pattern="\d*"; 
						      	spellcheck="false"
						        title="Minimum Stock Level should be numeric only"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Type of store (xdpt)</font><font color="red">*</font></td>
                            <td>
                                <input id="xDept" name="xDept" type="text" required="required" style="width: 200px" maxlength="20"/>
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
                            <!-- <input type="button" value="Reset" onclick="Reset()" style=" width:60px; background: #001a66;  color: #FFFFFF; padding: 1px;"align="right">
                                <button id="Submit1" type="submit" value="Add" style=" width:60px; background: #001a66; 
				                color: #FFFFFF; padding: 1px; margin-left: 30px;">Add</button> -->
				                <button type="button" onclick="Reset()" style=" width:60px;padding:2px; background: #001a66;margin-left: 20px;color: #FFFFFF;border-radius: 5px; border: none">Reset</button>
				                <button type="submit" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;border-radius: 5px; border: none">Add</button>
                            </td>
					</tr>   
                        </table>
                 </c:if>   
                 <c:if test="${not empty inventory.sku}">
 
                    <table width="100%">
                        <tr style="height: 50px">
                        
                           <td style="width: 12%"><font size="2px">SKU </font><font color="red">*</font></td>
                            <td>
                                <input id="sku" value="${inventory.sku }" name="sku" type="text" required="required" style="width: 200px" maxlength="8"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%;"><font size="2px">UOM </font><font color="red">*</font></td>
                     
                            
                            <td>
                               <select id="uom"  name="uom" required="required" style="width: 200px">
                               <option value="">Select</option>
                               <c:forEach items="${uomList}" var="ListItem">
                                <c:if test="${ListItem.uom == inventory.uom}">
                               <option value="${ListItem.uom}" selected="selected">${ListItem.uom}</option>
                               </c:if>
                               <c:if test="${ListItem.uom != inventory.uom}">
                               <option value="${ListItem.uom}">${ListItem.uom}</option>
                               </c:if>
                               </c:forEach>
                              </select>
                            </td>

                            <td style="width: 200px"></td>

                            <td style="width: 10%"><font size="2px">Depot </font><font color="red">*</font></td>
                            <td>
                                <select id="depot"  name="depot" required="required" style="width: 200px">
                                <option value="">Select</option>
                                <c:forEach items="${depotList}" var="ListItem">
                                <c:if test="${ListItem.depotName == inventory.depot}">
                               <option value="${ListItem.depotName}" selected="selected">${ListItem.depotName}</option>
                               </c:if>
                               <c:if test="${ListItem.depotName != inventory.depot}">
                               <option value="${ListItem.depotName}">${ListItem.depotName}</option>
                               </c:if>
                               </c:forEach>
                              </select>
                            </td>
                        </tr>
                        
                         <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Quantity </font><font color="red">*</font></td>
                            <td>
                                <input id="icgQty" value="${inventory.icgQty }" name="icgQty" type="text" required="required" style="width: 200px"
                                maxlength="10"
                                pattern="\d*"; 
						      	spellcheck="false"
						        title="Quantity should be numeric only"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Equipment </font><font color="red">*</font></td>
                            <td>
                                <input id="equipment" value="${inventory.equipment }" name="equipment" type="text" required="required" style="width: 200px" maxlength="100"/>
                            </td>
                            <td style="width: 100px"></td>
                             <td style="width: 10%"><font size="2px">Part Number </font><font color="red">*</font></td>
                            <td>
                                <input id="partNo"  value="${inventory.partNo }" name="partNo" type="text" required="required" style="width: 200px" maxlength="60"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Second Part Number </font><font color="red">*</font></td>
                            <td>
                                <input id="sPartNo" value="${inventory.sPartNo }" name="sPartNo" type="text" required="required" style="width: 200px" maxlength="60"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Description </font><font color="red">*</font></td>
                            <td>
                                <input id="descr" value="${inventory.descr }" name="descr" type="text" required="required" style="width: 200px" maxlength="200"/>
                            </td>
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><font size="2px">Ledger Number </font><font color="red">*</font></td>
                            <td>
                                <input id="ledgerNo" value="${inventory.ledgerNo }" name="ledgerNo" type="text" required="required" style="width: 200px" maxlength="15"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Unit Price </font><font color="red">*</font></td>
                            <td>
                                <input id="unitPrice" value="${inventory.unitPrice }" name="unitPrice" type="text" required="required" style="width: 200px" 
                                maxlength="11"
                                pattern="^[1-9]\d*(\.\d+)?$"; 
						      	spellcheck="false"
						        title="Price should be numeric only" />
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Currency </font><font color="red">*</font></td>
                            
                                <td>
                                <select id="currency" name="currency"  required="required" style="width: 200px">
                                <option value="">Select</option>
                                <c:forEach items="${currencyList}" var="ListItem">
                                <c:if test="${ListItem.currencyName == inventory.currency}">
                               <option value="${ListItem.currencyName}" selected="selected">${ListItem.currencyName}</option>
                               </c:if>
                               <c:if test="${ListItem.currencyName != inventory.currency}">
                               <option value="${ListItem.currencyName}">${ListItem.currencyName}</option>
                               </c:if>
                               </c:forEach>
                              </select>
                              </select>
                            
                            <td style="width: 200px"></td>
                             <td style="width: 10%"><font size="2px">Category </font><font color="red">*</font></td>
                            <td>
                                <input id="cat" value="${inventory.cat }" name="cat" type="text" required="required" style="width: 200px" maxlength="6"/>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Minimum Stock Level </font><font color="red">*</font></td>
                            <td>
                                <input id="msl" value="${inventory.msl }" name="msl" type="text" required="required" style="width: 200px"
                                 maxlength="6"
                                pattern="\d*"; 
						      	spellcheck="false"
						        title="Minimum Stock Level should be numeric only"/>
                            </td>
                            <td style="width: 200px"></td>
                            <td style="width: 10%"><font size="2px">Type of store (xdpt)</font><font color="red">*</font></td>
                            <td>
                                <input id="xDept" value="${inventory.xDept }" name="xDept" type="text" required="required" style="width: 200px" maxlength="20"/>
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
                            <!-- <input type="button" value="Reset" onclick="Reset()" style=" width:60px; background: #001a66;  color: #FFFFFF; padding: 1px;"align="right">
                                <button id="Submit1" type="submit" value="Add" style=" width:60px; background: #001a66; 
				                color: #FFFFFF; padding: 1px; margin-left: 30px;">Add</button> -->
				                <button type="button" onclick="Reset()" style=" width:60px;padding:2px; background: #001a66;margin-left: 20px;color: #FFFFFF;border-radius: 5px; border: none">Reset</button>
				                <button type="submit" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;border-radius: 5px; border: none">Add</button>
                            </td>
					</tr>   
                        </table>
                 </c:if>     
            <p id="error" style="text-align: center; color: red;">${error}</p>
     <p style="text-align: center; color: green;">${success}</p>            
</form>
</body>
</html>
