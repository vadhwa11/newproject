<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
hr { 
    display: block;
    margin-top: 0.5em;
    margin-bottom: 0.5em;
    margin-left: auto;
    margin-right: auto;
    border-style: inset;
    border-width: 1px;
} 
.collapsible {
   background:transparent;
    color: white;
    cursor: pointer;
    padding:10px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
   
}
.collapsible2 {
    background:transparent;
    color: white;
    cursor: pointer;
    padding:10px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
    margin-top: 10px;
}
.collapsible1 {
    background:transparent;
    color: white;
    cursor: pointer;
    padding-bottom: 7px;
    padding-top:7px;
    
   /*  padding:10px; */
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
    margin-left: -10px;
}

.active, .collapsible:hover {
    background-color: #286090;
    
   
}
.active, .collapsible1:hover {
    background-color: #286090;
}
.active, .collapsible2:hover {
    background-color: #286090;
   /*  margin-top: 10px; */
}
.content {
    padding: 0 18px;
    display: none;
    overflow: hidden;
    background:transparent;
}
</style>
</head>
<body>

		<div>
			<br>
			<p align="center">
				<img src="${pageContext.request.contextPath}/static/img/logo1.png"
					style="width: 95px; height: 100px;"></a>
			</p>
			<p align="center">
				<font size="3px" color="white">Indian Coast Guard 
			</p>
			</font>
		</div>
		
		<hr>
		<!-- <button class="collapsible1"> -->
		<div class="collapsible1">
		 <p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchInventoryStatus">
				<font  size="2" color="white">Search Inventory Status</font></a>
			</p>
			</div>
		<%-- <div class="collapsible1">	
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchInventoryDetails">
				<font  size="2" color="white">Search Inventory Details</font></a>
			</p>
		</div>	 --%>
		<div class="collapsible1">
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchInventoryLpp">
				<font  size="2" color="white">Search Inventory LPP</font></a>
			</p>
			</div>
			<div class="collapsible1">
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchNAC">
				<font  size="2" color="white">NAC</font></a>
			</p>
			</div>
			<button class="collapsible"><font  size="2" color="white">Settings</font></button>
			
			<div class="content">
			<button class="collapsible2"><font  size="2" color="white">SKU</font></button>
			<div class="content">
			 <c:if test="${userType == 'admin'}">
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/addInventory">
				<font  size="2" color="white">Add SKU</font></a>
			</p>
			</c:if>
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchInventory">
				<font  size="2" color="white">Search SKU</font></a>
			</p>
			</div>
			<button class="collapsible2"><font  size="2" color="white">Currency</font></button>
			<div class="content">
			<c:if test="${userType == 'admin'}">
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/addCurrencyPage">
				<font  size="2" color="white">Add Currency</font></a>
			</p>
			</c:if>
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchCurrency">
				<font  size="2" color="white">Search Currency</font></a>
			</p>
			</div>
			</div>
		<%-- <button class="collapsible"><font  size="2" color="white">Inventory Types</font></button>
		
		<div class="content">
        <p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchInventoryStatus">
				<font  size="2" color="white">Search Inventory Status</font></a>
			</p>
			
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchInventoryDetails">
				<font  size="2" color="white">Search Inventory Details</font></a>
			</p>
			
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchInventoryLpp">
				<font  size="2" color="white">Search Inventory LPP</font></a>
			</p>
		</div>
		
		<img alt="" src="${pageContext.request.contextPath}/static/img/setting.png" style="width: 10px;height: 10px;">
		<button class="collapsible"><font  size="2" color="white">Settings</font></button>
		<div class="content">
        <p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/addInventory">
				<font  size="2" color="white">Add SKU</font></a>
			</p>
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchInventory">
				<font  size="2" color="white">Search SKU</font></a>
			</p>
			 <p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/addCurrencyPage">
				<font  size="2" color="white">Add Currency</font></a>
			</p>
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchCurrency">
				<font  size="2" color="white">Search Currency</font></a>
			</p>
			
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchNAC">
				<font  size="2" color="white">NAC</font></a>
			</p>
			
		</div> --%>
		<!-- </button> -->
		
		<%-- <p class="collapsible1"><a href="${pageContext.request.contextPath}/home"><font  size="2" color="white">Inventory details</font></a></p>

        <p class="collapsible1"><a href="${pageContext.request.contextPath}/home"><font  size="2" color="white">Depot wise Inventory</font></a></p>
		 --%>
		
		<%-- <button class="collapsible"><font  size="2" color="white">Inventory</font></button>
		
		<div class="content">
        <p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/addInventory">
				<font  size="2" color="white">Add Inventory</font></a>
			</p>
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchInventory">
				<font  size="2" color="white">Search Inventory</font></a>
			</p>
		</div>
<br>
<button class="collapsible"><font  size="2" color="white">Currency</font></button>
		
		<div class="content">
        <p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/addCurrency">
				<font  size="2" color="white">Add Currency</font></a>
			</p>
			<p align="left" style="padding-left: 20px;">
				<a href="${pageContext.request.contextPath}/searchCurrency">
				<font  size="2" color="white">Search Currency</font></a>
			</p>
		</div> --%>
<script>
var coll = document.getElementsByClassName("collapsible");
var i;
//alert(coll.length);
for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}

var coll = document.getElementsByClassName("collapsible2");
var i;
//alert(coll.length);
for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}
</script>

</body>
</html>