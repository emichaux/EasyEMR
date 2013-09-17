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
  
  <script>
  $(function() {
    var availableTags = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    function split( val ) {
      return val.split( /,\s*/ );
    }
    function extractLast( term ) {
      return split( term ).pop();
    }
    $( "#patientFirstName" )
    // don't navigate away from the field on tab when selecting an item
    .bind( "keydown", function( event ) {
      if ( event.keyCode === $.ui.keyCode.TAB &&
          $( this ).data( "ui-autocomplete" ).menu.active ) {
        event.preventDefault();
      }
    })
    .autocomplete({
      minLength: 0,
      source: function( request, response ) {
        // delegate back to autocomplete, but extract the last term
        response( $.ui.autocomplete.filter(
          availableTags, extractLast( request.term ) ) );
      },
      focus: function() {
        // prevent value inserted on focus
        return false;
      },
      select: function( event, ui ) {
        var terms = split( this.value );
        // remove the current input
        terms.pop();
        // add the selected item
        terms.push( ui.item.value );
        // add placeholder to get the comma-and-space at the end
        terms.push( "" );
        this.value = terms.join( ", " );
        return false;
      }
    });
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
					Patient ID <h:inputText id="patientID" value="#{encounterService.searchPatientId }" /><h:commandButton id="search" value="Search" action="#{encounterService.searchPatient }"></h:commandButton>
					<h:outputLabel value = "#{encounterService.patient.patientID }"></h:outputLabel>
                    </h:form>



 <div id="tabs" class="span8 center">
  <ul>
    <li><a href="#tabs-1"><b>General Information</b></a></li>
    <li><a href="#tabs-2"><b>Patient List</b></a></li>
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
					</table>  
					</div>
  <div id="tabs-2">
<h:form>
<h:commandButton value="Display All Patients" 
							action="#{patientService.displayAllPatients }" />
							<table>
								<tr>
									<td><h:outputLabel value="Username: "></h:outputLabel></td>
									<td><h:inputText value="#{userService.searchUsername}">
										</h:inputText></td>
								</tr>
								<tr>
									<td><h:outputLabel value="First Name: "></h:outputLabel></td>
									<td><h:inputText value="#{userService.searchFirst}"></h:inputText></td>
								</tr>
								<tr>
									<td><h:outputLabel value="Last Name: "></h:outputLabel></td>
									<td><h:inputText value="#{userService.searchLast}"></h:inputText></td>
								</tr>
																
							</table>
									<h:commandButton value="Search" action="#{userService.searchUser}"></h:commandButton>
							
			<div class="container span6 well center">
			<div class="table table-striped">
			<center>
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
				<a href="admin.jsp"><h5> Back to Admin Page</h5></a>
				</center>
			</div>
			</div>
		</h:form>  </div>
  <div id="tabs-3">
    <p>Mauris eleifend est et turpis. Duis id erat. Suspendisse potenti. Aliquam vulputate, pede vel vehicula accumsan, mi neque rutrum erat, eu congue orci lorem eget lorem. Vestibulum non ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Fusce sodales. Quisque eu urna vel enim commodo pellentesque. Praesent eu risus hendrerit ligula tempus pretium. Curabitur lorem enim, pretium nec, feugiat nec, luctus a, lacus.</p>
    <p>Duis cursus. Maecenas ligula eros, blandit nec, pharetra at, semper at, magna. Nullam ac lacus. Nulla facilisi. Praesent viverra justo vitae neque. Praesent blandit adipiscing velit. Suspendisse potenti. Donec mattis, pede vel pharetra blandit, magna ligula faucibus eros, id euismod lacus dolor eget odio. Nam scelerisque. Donec non libero sed nulla mattis commodo. Ut sagittis. Donec nisi lectus, feugiat porttitor, tempor ac, tempor vitae, pede. Aenean vehicula velit eu tellus interdum rutrum. Maecenas commodo. Pellentesque nec elit. Fusce in lacus. Vivamus a libero vitae lectus hendrerit hendrerit.</p>
  </div>
</div>
		






</f:view>
</body>
</html>