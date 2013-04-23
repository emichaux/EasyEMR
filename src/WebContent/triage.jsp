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


 <div id="tabs" class="span8 center">
  <ul>
    <li><a href="#tabs-1"><b>General Information</b></a></li>
    <li><a href="#tabs-2">Proin dolor</a></li>
    <li><a href="#tabs-3">Aenean lacinia</a></li>
  </ul>
  <div id="tabs-1">
<h2>General Information</h2>
					<table>
						<tr>
							<td><h5 style="color:red">* Card ID </h5></td>
							<td><h:inputText id="visitID" style="width:50px"  value="#{encounterService.encounter.cardID}" title="Please type in the cardID, this is a required field." required="true"></h:inputText></td>
							<h:message for="visitID" style="color:red"> </h:message>							
						</tr>
						<tr>
							<td><strong>* First Name</strong></td>
							<td><h:inputText id="patientFirstName" style="width:130px" value="#{encounterService.patient.firstName }" title="Please type the patients First Name" required="true"></h:inputText></td>
							<h:message for="patientFirstName" style="color:red"> </h:message>
						</tr>
						<tr>
							<td><strong>* Last Name</strong></td>
							<td><h:inputText id="patientLastName" style="width:130px" value="#{encounterService.patient.lastName }" title="Please type the patients Last Name" required="true"></h:inputText></td>
							<h:message for="patientLastName" style="color:red"> </h:message>
						</tr>
						<tr>
							<td><strong>Location</strong></td>
							<td><h:selectOneMenu id ="location" value="#{encounterService.patient.residence }">
		   						<f:selectItem itemValue="Select" itemLabel="- Select -" />
		   						<f:selectItem itemValue="Port-au-Prince" itemLabel="Port-au-Prince" />
		   						<f:selectItem itemValue="Borel" itemLabel="Borel" />
								<f:selectItem itemValue="Morne de l' Hopital" itemLabel="Morne de l' Hopital" />
								<f:selectItem itemValue="Opac" itemLabel="Opac" />
		   						<f:selectItem itemValue="Jacmel" itemLabel="Jacmel" />
		   						<f:selectItem itemValue="Leogane" itemLabel="Leogane" />
								<f:selectItem itemValue="Miragoane" itemLabel="Miragoane" />
															
								</h:selectOneMenu></td>
						</tr>
		
			
						<tr>
							<td><strong>Birth Date</strong></td>
							<td><h:inputText id="datepicker" value = "#{encounterService.patient.birthDate }"></h:inputText>(MM/DD/YY)</td>
							
						</tr>
						<tr>
							<td><strong>Gender</strong></td>
							<td><h:selectOneMenu id ="gender" value="#{encounterService.patient.gender }">
		   						<f:selectItem itemValue="Select" itemLabel="- Select -" />
		   						<f:selectItem itemValue="Male" itemLabel="Male" />
		   						<f:selectItem itemValue="Female" itemLabel="Female" />
								</h:selectOneMenu></td>
						</tr>
		
						<tr>
							<td><strong>Height</strong></td>
							<td><h:inputText id="hin" value="#{encounterService.vitals.height }"></h:inputText> in</td>
						</tr>
		
						<tr>
							<td><strong>Weight</strong></td>
							<td><h:inputText id="wlbs" value="#{encounterService.vitals.weight }"></h:inputText> lbs</td>
						</tr>
					</table>  </div>
  <div id="tabs-2">
    <p>Morbi tincidunt, dui sit amet facilisis feugiat, odio metus gravida ante, ut pharetra massa metus id nunc. Duis scelerisque molestie turpis. Sed fringilla, massa eget luctus malesuada, metus eros molestie lectus, ut tempus eros massa ut dolor. Aenean aliquet fringilla sem. Suspendisse sed ligula in ligula suscipit aliquam. Praesent in eros vestibulum mi adipiscing adipiscing. Morbi facilisis. Curabitur ornare consequat nunc. Aenean vel metus. Ut posuere viverra nulla. Aliquam erat volutpat. Pellentesque convallis. Maecenas feugiat, tellus pellentesque pretium posuere, felis lorem euismod felis, eu ornare leo nisi vel felis. Mauris consectetur tortor et purus.</p>
  </div>
  <div id="tabs-3">
    <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
    <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
  </div>
</div>
		








</f:view>
</body>
</html>