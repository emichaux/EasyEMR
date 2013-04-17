<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="en-US">

<head>
<link href="./css/bootstrap.css" rel="stylesheet">  
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
				
<div class="container well">
		<div class="form center">
				<br />
				<h:form>
				<div style="span6">
					<h4>Search:</h4><br>
									First Name <h:inputText id="firstname" style="width:85px" value="#{encounterService.searchPatientFirstName }" />&nbsp;&nbsp;<h:commandButton id="searchFirst" value="Search" action="#{encounterService.searchPatientsF }"></h:commandButton>
									Last Name <h:inputText id="lastname" style="width:85px" value="#{encounterService.searchPatientLastName }" />&nbsp;&nbsp;<h:commandButton id="searchLast" value="Search" action="#{encounterService.searchPatients }"></h:commandButton><br>
									Patient ID <h:inputText id="patientID" style="width:85px" value="#{encounterService.searchPatientId }" />&nbsp;&nbsp;<h:commandButton id="search" value="Search" action="#{encounterService.searchPatient }"></h:commandButton>
									Card ID <h:inputText id="cardID" style="width:85px" value="#{encounterService.searchPatientCardID }" /><h:commandButton id="searchCard" value="Search" action="#{encounterService.searchCardID }"></h:commandButton>
									
				</div>
				</h:form>
			<div class="form">
			<h:form>
				<h:commandButton action="#{encounterService.resetRecord}" style="width:75px;height:50px" value="RESET" />
				<h:dataTable value="#{encounterService.patientList}" var="patient">
					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Patient ID" />
							</h:column>
						</f:facet>
						<h:outputText value="#{patient.patientID }" />
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
								<h:outputText value="Actions" />
							</h:column>
						</f:facet>
						<h:panelGrid columns="2">
							<h:commandLink value="Select" action="#{encounterService.selectPatient}">
								<f:setPropertyActionListener target="#{encounterService.patient}" value="#{patient}" />
							</h:commandLink>

						</h:panelGrid>
					</h:column>
				</h:dataTable>
			</h:form>
		</div>
		</div>
		</div>

	</f:view>
</body>
</html>