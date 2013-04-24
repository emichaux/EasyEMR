<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html>
<head>
	<link href="./css/bootstrap.css" rel="stylesheet">  
	<link rel="stylesheet" href="./css/jquery-ui-1.10.2.custom.css" />
  	<script src="./js/jquery-1.9.1.js"></script>
  	<script src="./js/jquery-ui-1.10.2.custom.js"></script>
  	<link rel="stylesheet" href="/resources/demos/style.css" />

	

<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
</script>
	
	
<script>
	$(function() {
    $( document ).tooltip();
  });
</script>
  <style>
  label {
    display: inline-block;
    width: 5em;
  }
  </style>
  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>  
  
  
	<title>Easy EMR</title>
</head>

<body>

<f:view>
	<div class="navbar navbar-fixed-top center">
	  		<div style="float: left">
  			<p><img src="./img/easyEmr_LOGO.png" height="80" width="110"></p>
  			</div>
	  <div class="navbar-inner"> 

  			   <h5 style="float:left">Hello, <h:outputLabel style="color:red" value="#{loginBean.systemUser.firstName }"/></h5>
  			
  		
        <div class="container-fluid">
                 <h:form>
						<h:commandLink tabindex="-1" action="#{loginBean.logout}"><h5 style="color:red">Log Out</h5></h:commandLink>
						<h:commandLink tabindex="-2" action="#{userService.switchToUpdateInfo}"><h5 style="color:gray">Change My Password</h5></h:commandLink>
				</h:form>
				</div>
			</div>			
	    </div>  
	    
			    			
<br><br>
<br><br>
<br><br>


 <h:form>
			<div class="container span6 well center">
			<div class="table table-striped">
			<center>
			<h:commandButton value="Display All Patients" 
							action="#{patientService.displayAllPatients }" />
				<h4>Patient List</h4>
				<h:dataTable value="#{patientService.patientList}" var="patient">
					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="CardID" />
							</h:column>
						</f:facet>
						<h:outputText value="#{patient.cardID }" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="First Name" />
							</h:column>
						</f:facet>
						<h:outputText value="#{patient.firstName}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Last Name" />
							</h:column>
						</f:facet>
						<h:outputText value="#{patient.lastName}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="DOB" />
							</h:column>
						</f:facet>
						<h:outputText value="#{patient.birthDate}" />

					</h:column>
				</h:dataTable>
				<a href="create.jsp"><h5> Back to Medical Records Page</h5></a>
				</center>
			</div>
			</div>
		</h:form>  



</f:view>
</body>
</html>