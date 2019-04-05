<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
 <script src="static/js/jquery-ui.js"></script>
   
<!-- jquery-ui.css and main.js is used for datePicker   -->
<script src="static/js/main.js"></script>
<link rel="stylesheet" type="text/css" href="static/js/jquery-ui.css"/> 
<link rel="stylesheet" type="text/css" href="static/js/print.css"/> 


<title>Insert title here</title>
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
	    	 /* processing: true,
	    	    "language": {
	    	        "processing": "Hang on. Waiting for response..." //add a loading image,simply putting <img src="loader.gif" /> tag.
	    	    },
	    	    serverSide: true, */
	    	    dom: 'Bfrtip',
		        buttons: [
		                  {
		                	  extend: 'print',
		                	  title: '',
			                  autoPrint: false  
		                	  
		                  }, ,
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
	                	 /*  exportOptions: {
	                		  columns: [ 0, 1,2,3,4,5,6]
	                		 }, */
		                  autoPrint: false  
	                	  
	                  } 
		                   
		        ],
	    	 "scrollY": "200px",
	         "scrollCollapse": true,
	          "pageLength": 5,
	    	  "bSort": false,
	    	 
	    	} ); 
	  } );


function Reset(){
	//alert("reset");
	document.getElementById("searchNacPageForm").reset();
	document.getElementById('partNo').value="";
	document.getElementById('fromDate').value="";
	document.getElementById('toDate').value="";
	document.getElementById('depot').selectedIndex = 0;

	var options = document.getElementById('depot').value;

	    for (var i = 0, l = options.length; i < l; i++) {
	        options[i].selected = options[i].defaultSelected;
	    }
	
}

 
function DateCheck()
{
	
 /*  var StartDate= document.getElementById('issueDate').value.split("/");
  var EndDate= document.getElementById('expiryDate').value.split("/"); */
     var startDate = document.getElementById('fromDate').value;
	 var startDateArray = startDate.split("/");
	 var endDate = document.getElementById('toDate').value;
	 var endDateArray = endDate.split("/");
	/*  var returnDate = document.getElementById('returnDate').value; 
	 	var returnDateArray = returnDate.split("/"); */
  
 
    var newStartDate = startDateArray[1] + '/' + startDateArray[0] + '/' + startDateArray[2];
	 var newEndDate = endDateArray[1] + '/' + endDateArray[0] + '/' + endDateArray[2];
	 //var newreturnDate = returnDateArray[1] + '/' + returnDateArray[0] + '/' + returnDateArray[2];
  
  
  var eDate = new Date(newEndDate);
  var sDate = new Date(newStartDate);
  //var rDate = new Date(newreturnDate);
  

  if(sDate!= '' && eDate!= '' && sDate > eDate)
    {
    alert("Please ensure that the To Date is greater than From Date.");
    document.getElementById("toDate").value = "";
    
    return false;
    }
  
  /* if(sDate!= '' && rDate!= '' && sDate > rDate)
  {
  alert("Please ensure that the Return Date is greater than Issue Date.");
  document.getElementById("returnDate").value = "";
  
  return false;
  } */

} 
 
 

function submitNacForm(e){
	
	var partNo= document.getElementById('partNo').value;
	var depot= document.getElementById('depot').value;
	var fromDate= document.getElementById('fromDate').value;
	var toDate= document.getElementById('toDate').value;
	
	/*alert("depot =="+depot);
	 alert("partNo =="+partNo);
	alert("descr =="+descr);
	alert("equipment =="+equipment);
	alert("ledgerNo =="+ledgerNo);
	 */
	
	
	if(partNo =="" && depot=="" && fromDate=="" && toDate==""){
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
	if(toDate=="" && fromDate!=""){
		alert("Please enter To Date also")
		e.stopPropagation();
		 return false; 
		//alert("else");
	}
	if(toDate!="" && fromDate==""){
		alert("Please enter From Date also")
		e.stopPropagation();
		 return false; 
		//alert("else");
	}
	else{
		submitForm();
		return true;
	
	}
}
	

function submitForm(){
	document.searchNacPageForm.action="search_NAC_Page";
	document.searchNacPageForm.method="POST";
	document.searchNacPageForm.submit();  
	
	/* $.ajax({
         url: 'searchInventoryStatusProcess',
         type: 'get',
         data:   $('#searchInventoryStatus').serialize(),
         success:function(response)
         {
         }  
 	 }); */
}
/*
function PrintDoc() {

    var toPrint = document.getElementById('printarea');

    var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');

    popupWin.document.open();

    popupWin.document.write('<html><title>::Preview::</title><link rel="stylesheet" type="text/css" href="print.css" /></head><body onload="window.print()">')

   popupWin.document.write(toPrint.innerHTML);
    

    popupWin.document.write('</html>');

    popupWin.document.close();

}
 */
</script>

  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>

</head>
<body>

<h4 align="center">Record of Not Available Certificate(NAC)</h4>

  
 	<form id= "searchNacPageForm" name="searchNacPage" action="search_NAC_Page" method=post>
 	
 	 <table width="100%">
                 <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">Part No </font></td>
                            <td>
                            <c:if test="${ empty partNo}">
                                <input id="partNo" name="partNo" type="text"  style="width: 200px" />
                                </c:if>
                                <c:if test="${not empty partNo}">
                                <input id="partNo" value ="${partNo}" name="partNo" type="text"  style="width: 200px" />
                                </c:if>
                            </td>
                            <td style="width: 200px"></td>
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
	                               <select id="depot" name="depot" style="width: 200px">
	                               
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
                            
                            <td style="width: 250px"></td>
                             <td style="width: 10%"><font size="2px">From Date </font></td>
                            <td>
                             <c:if test="${empty fromDate}">
                                <input id="fromDate" name="fromDate" type="text" class="datepicker" onchange="DateCheck()" onkeypress="return false;" style="width: 200px" maxlength="6"/>
                             </c:if>
                             <c:if test="${not empty fromDate}">
                                <input id="fromDate" value="${fromDate}"name="fromDate" type="text"  class="datepicker"  onchange="DateCheck()"  onkeypress="return false;" style="width: 200px" maxlength="6"/>
                             </c:if>
                            </td>
                            
                        </tr>
                        
                          <tr style="height: 50px;">
                        
                           <td style="width: 12%"><font size="2px">To Date </font></td>
                            <td>
                            <c:if test="${empty toDate}">
                                <input id="toDate" name="toDate" type="text" class="datepicker" onchange="DateCheck()" onkeypress="return false;" style="width: 200px" />
                                 </c:if>
                                 
                                 <c:if test="${not empty toDate}">
                                <input id="toDate" value="${toDate}" name="toDate" type="text" class="datepicker" onchange="DateCheck()" onkeypress="return false;" style="width: 200px" />
                                 </c:if>
                                 
                            </td>
                            <td style="width: 250px"></td>
                            <td style="width: 10%"></td>
                            <td>
                                
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
                             <td style="width: 10%">
                            <!--  <input type="button" value="Print Preview" class="btn" onclick="PrintPreview()"/> -->
                             </td>
                           <!--   <td style="width: 10%"><input type="button" value="Print Preview" class="btn" onclick="PrintDoc()"/></td> -->
                            <td>
                            <!-- <input type="button" value="Reset" onclick="Reset()" style=" width:60px; background: #001a66;  color: #FFFFFF; padding: 1px;"align="right">
                                <button id="Submit1" type="submit" value="Add" style=" width:60px; background: #001a66; 
				                color: #FFFFFF; padding: 1px; margin-left: 30px;">Add</button> -->
				                <button type="button" onclick="Reset()" style=" width:60px;padding:2px; background: #001a66;margin-left: 20px;color: #FFFFFF;border-radius: 5px; border: none">Reset</button>
				                <button type="submit" onclick="return submitNacForm(event)" style=" width:60px;padding:2px; background: #001a66;margin-left: 30px;color: #FFFFFF;border-radius: 5px; border: none" >Search</button>
                            </td>
					</tr>   
                            </table>
	</form>	
   
    <!-- Data Grid -->
   <c:if test="${listObjNacItemDTO.size()>0}">
   		<!--  <table  id="project-details"  style="background-color: #001a66" > -->
   		 <table  id="project-details" style="background-color: #001a66" bordercolor="#001a66">
 	<thead>
 		<tr style="color: white">
			<th>Part No</th>
			<th>Description</th>
			<th>Equipment</th>
			<th>Unit</th>
			<th>Ledger Number</th>
			<th>NAC Number</th>
			<th>NAC Date</th>
			<th>Depot</th>
			<th>Demand No</th>
			<th>Demand Date</th>
			<th>Quantity</th>
			</tr>
	</thead>
	<tbody>
		<c:forEach items="${listObjNacItemDTO}" var="listObjNac">
			<tr>
				<td>${listObjNac.partNo}</td>
				<td>${listObjNac.description}</td>
				<td>${listObjNac.equipment}</td>
				 <td>${listObjNac.signalAdd}</td>
				<td>${listObjNac.ledgerNo}</td>
			    <td>${listObjNac.nacNo}</td>
				<td>${listObjNac.nacDate}</td> 
				<td>${listObjNac.depot}</td> 
				 <td>${listObjNac.demandNo}</td>  
				<td>${listObjNac.demandDate}</td> 
				<td>${listObjNac.quantity}</td> 
			</tr>
		</c:forEach>
	
	</tbody>
   </table>
   </c:if>
   
   <c:if test="${listObjNacItemDTO.size() == 0}">
	<h3><p align="center"  style="margin-top: 100px;color: red;">No Record Found !!</p></h3>
	</c:if>
	
   </div>
</body>
<!-- <script type="text/javascript">
function PrintPreview() {
	debugger;
alert("Print Preview");
	var toPrint = document.getElementById('printarea');

    var popupWin = window.open('', '_blank', 'width=1000,height=750,location=no,left=200px');

    popupWin.document.open();

    popupWin.document.write('<html><title>::Print Preview::</title><link rel="stylesheet" type="text/css" href="print.css" media="screen"/></head><body">')

    popupWin.document.write('<table  class="tabl" style="background-color: #fffff">');
    popupWin.document.write('<thead>');
    popupWin.document.write('<tr>');
    popupWin.document.write('<th>Part No</th>');
    popupWin.document.write('<th>Description</th>');
    popupWin.document.write('<th>Equipment</th>');
    popupWin.document.write('<th>Unit</th>');
    popupWin.document.write('<th>Ledger Number</th>');
    popupWin.document.write('<th>NAC Number</th>');
    popupWin.document.write('<th>NAC Date</th>');
    popupWin.document.write('</tr>');
    popupWin.document.write('</thead>');
    popupWin.document.write('<tbody>');
   popupWin.document.write('<c:forEach items="${listObjNacItemDTO}" var="listObjNac">');
   popupWin.document.write('<tr>');
   popupWin.document.write('<td>${listObjNac.partNo}</td>');
   popupWin.document.write('<td>${listObjNac.description}</td>')
 /*  var description=${listObjNac.description}; */
  //alert(description)
 /*  popupWin.document.write('<td>description.match(/.{1,20}/g)</td>'); */
   popupWin.document.write('<td>${listObjNac.equipment}</td>');
    popupWin.document.write('<td>${listObjNac.signalAdd}</td>');
    popupWin.document.write('<td>${listObjNac.ledgerNo}</td>'); 
    popupWin.document.write('<td>${listObjNac.nacNo}</td>'); 
    popupWin.document.write('<td>${listObjNac.nacDate}</td> ');
    popupWin.document.write('</tr>');
    popupWin.document.write('</c:forEach>'); 
    popupWin.document.write('</tbody> '); 
    popupWin.document.write('</table>');	
    
    popupWin.document.write('</body>');
    popupWin.document.write('</html>');

    popupWin.document.close();
}
</script> -->
</html>