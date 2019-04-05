<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<head>
<link rel="stylesheet" type="text/css" href="static/css/header.css"/>
<style type="text/css">
#project-details {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
    text-align: center;
}

#project-details td, #project-details th {
    border: 1px solid #ddd;
    padding: 8px;
}

#project-details tr:nth-child(even){background-color: #f2f2f2;}

#project-details tr:hover {background-color: #ddd;}

#project-details th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: center;
    background-color: #001a66;
    color: white;
    
}
.card {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    width: 100%;
    border-radius: 5px;
    background: #ebebe0;
    margin-bottom: 20px;
    
}

.card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

.container {
    
    padding: 16px 16px;
}

</style>
</head>
<body>

<script type="text/javascript">
function toggleAppearance()
{
     var dataDiv = document.getElementById("search-details");
     if(dataDiv.style.visibility == "hidden")
     {
    	// alert("Hello");
          dataDiv.style.visibility = "visible";
     }
    else
     {
    	// alert("Hi");
          dataDiv.style.visibility = "hidden";
     }  
}
</script>

<h2>Favourites</h2>

<div class="card">
  <div class="container">
    <p><a href="#" onclick="toggleAppearance();"><font color="red">Normal Refit of ICGS Samudra Prahari - BG Expiry Date is 31/07/2018.</font></a></p>
	<p class="text-warning"><a href="#" onclick="toggleAppearance();"><font color="#F39C12">Normal Refit of ICGS Samudra Prahari - ABG Expiry Date is 30/08/2018.</font></a></p>
	<p class="text-success"><a href="#" onclick="toggleAppearance();"><font color="green">Short Refit(SR-17) of ICGS Summer - BG Expiry Date is 30/9/2018.</font></a></p>
	<p class="text-danger"><a href="#" onclick="toggleAppearance();">Normal Refit of ICGS Samudra Prahari - BG Expiry Date is 31/10/2018.</a></p>
	
  </div>
</div>


</div>
</body>
</html>