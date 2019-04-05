<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!DOCTYPE html>
<html>
<head>
     <style type="text/css">
     
     .card {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
     width: 1240px !important;
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
     
        .auto-style1 {
            width: 36%;
            margin-left: 323px;
        }

        .auto-style3 {
            width: 80%;
            height: 69px;
            
        }

        .auto-style4 {
            width: 98%;
        }

        .auto-style5 {
            width: 930px;
        }

        .auto-style6 {
            height: 26px;
        }

        .auto-style7 {
            width: 45px;
        }
    </style>
    <meta charset="utf-8" />
</head>

<body>

    <form id="form1">
        <br />
        <table class="auto-style1">
            <tr>
                <td style="text-align: center; font-size: 30px; color: #001a66;"><h3>User Details</h3></td>
            </tr>
        </table>
<br>
<div class="card">
  <div class="container">
	<hidden id="userId" name="userId"></hidden>
        <table class="auto-style3">
            <tr>
                <td class="auto-style5">
                    <table class="auto-style4" style="width:105%" >
                        <tr style="height: 40px">
                            <td class="auto-style6">User Name</td>
                            <td class="auto-style6">
                                <input id="userName" name="userName" value="Mr.Prabhakaran" readonly="readonly"/>

                            </td>

                            <td class="auto-style7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;</td>

                            <td class="auto-style6">UserId </td>
                            <td class="auto-style6" style="right: 50px">
                                <input id="sserId"  type="text" value="PC001" readonly="readonly"/>
                            </td>
                        </tr>
                         <tr style="height: 40px">
                            <td class="auto-style6">EmailId</td>
                            <td class="auto-style6">
                                <input id="emailId" name="emailId" type="text" value="prabha@gmail.com" readonly="readonly"/>
                            </td>
                            &nbsp;
                            <td class="auto-style7"></td>
                            <td class="auto-style6">Contact No</td>
                            <td class="auto-style6">
                                <input id="contactNo"  name="contactNo" type="text" value="9945456566" readonly="readonly"/>
                            </td>
                        </tr>
                         <tr style="height: 40px">
                            <td class="auto-style6">Orgnization Unit</td>
                            <td class="auto-style6">
                                <input id="orgUnit" name="orgUnit" type="text" value="Okha" readonly="readonly" />
                            </td>
                            &nbsp;
                            <td class="auto-style7"></td>
                            <td class="auto-style6">Department Id</td>
                            <td class="auto-style6">
                                <input id="deptId" name="deptId" type="text" value="IT"  readonly="readonly"/>
                            </td>
                        </tr>
                       
                       </table>
                </td>
            </tr>
        </table>
</div>
</div>

    </form>
</body>
</html>
