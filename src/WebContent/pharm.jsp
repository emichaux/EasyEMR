<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="en-US">


<head>
	<link rel="stylesheet" href="main.css" type="text/css" />
	<title>Easy EMR</title>
</head>

<body>
<f:view>
		<div id="navigation">
			<div style="float: left">
			&nbsp;<img src="img\logo_xl.png" height="60" width="180">&nbsp;&nbsp;
			</div>
			<div style="float: left">
				<table>
				<tbody>
					<tr>
						
						<td><td><h3 style="color:red" align="left" >Hello, <i><h:outputLabel value="#{loginBean.systemUser.firstName }"/></i></h3></td>
					</tr>
				</tbody>
				</table>
				
				
			</div>

			<div style="float: right">
			<h:form>
						<p><h:commandLink tabindex="-1" action="#{loginBean.logout}">Log out</h:commandLink></p>
						<p><h:commandLink tabindex="-2" action="#{userService.switchToUpdateInfo}">Change My Password</h:commandLink></p>

				</h:form>
			</div>
			
		</div>
		<div id= "content">
	
		<div id = "form">
		<h:form>
			<h1><font color="red">
			<h:outputText value="#{pharmacyEncounterService.encounterIDText }"></h:outputText></font></h1>
			<h3><font color="red"><h:outputText value="#{pharmacyEncounterService.recordIDInstruction }"></h:outputText>
			</font></h3>
			<h:message for="firstName" style="color:red"> </h:message>
			<h:message for="lastName" style="color:red"> </h:message>
			
			<h1>Create RX Record</h1><br>
			<center>
			<table>
			
			<tr>
				<td><h3>First Name</h3></td>
				<td><h3>Last Name</h3></td>
			</tr>
			
			<tr>
				<td><h:inputText style="width:160px" id="firstName" value="#{pharmacyEncounterService.firstName }" required="true" /></td>
				<td><h:inputText style="width:160px" id="lastName" value="#{pharmacyEncounterService.lastName }" required="true"/></td>
			</tr>
	
			<tr>
				<td><h3>Medication Given</h3></td>
				<td><h3>Same as Prescribed?</h3></td>
			</tr>
			
			<tr>
			<td><h:inputText style="width:160px" id="prescriptionGiven1" value="#{pharmacyEncounterService.medDispensed1 }" /></td>
			<td><h:selectOneMenu style="width:100px" id="equal1" value="#{pharmacyEncounterService.equalPrescribed1 }" title="select any one in this menu">
				<f:selectItem id="Yes1" itemLabel="Yes" itemValue="true" />
				<f:selectItem id="No1" itemLabel="No" itemValue="false" />
				</h:selectOneMenu></td>
			</tr>
			
			<tr>
			<td><h:inputText style="width:160px" id="prescriptionGiven2" value="#{pharmacyEncounterService.medDispensed2 }" /></td>
			<td><h:selectOneMenu style="width:100px" id="equal2" value="#{pharmacyEncounterService.equalPrescribed2 }" title="select any one in this menu">
				<f:selectItem id="Yes2" itemLabel="Yes" itemValue="true" />
				<f:selectItem id="No2" itemLabel="No" itemValue="false" />
				</h:selectOneMenu></td>
			</tr>
				
			<tr>
			<td><h:inputText style="width:160px" id="prescriptionGiven3" value="#{pharmacyEncounterService.medDispensed3 }" /></td>
			<td><h:selectOneMenu style="width:100px" id="equal3" value="#{pharmacyEncounterService.equalPrescribed3 }" title="select any one in this menu">
				<f:selectItem id="Yes3" itemLabel="Yes" itemValue="true" />
				<f:selectItem id="No3" itemLabel="No" itemValue="false" />
				</h:selectOneMenu></td>
			</tr>
			
				
			<tr>
			<td><h:inputText style="width:160px" id="prescriptionGiven4" value="#{pharmacyEncounterService.medDispensed4 }" /></td>
			<td><h:selectOneMenu style="width:100px" id="equal4" value="#{pharmacyEncounterService.equalPrescribed4 }" title="select any one in this menu">
				<f:selectItem id="Yes4" itemLabel="Yes" itemValue="true" />
				<f:selectItem id="No4" itemLabel="No" itemValue="false" />
				</h:selectOneMenu></td>
			</tr>
				
			<tr>
			<td><h:inputText style="width:160px" id="prescriptionGiven5" value="#{pharmacyEncounterService.medDispensed5 }" /></td>
			<td><h:selectOneMenu style="width:100px" id="equal5" value="#{pharmacyEncounterService.equalPrescribed5 }" title="select any one in this menu">
				<f:selectItem id="Yes5" itemLabel="Yes" itemValue="true" />
				<f:selectItem id="No5" itemLabel="No" itemValue="false" />
				</h:selectOneMenu></td>
			</tr>
				
				
			</table>
			</center>
			<BR>
			
		<h:commandButton id="submit"   value="Submit" action="#{pharmacyEncounterService.dataToDatabase }"></h:commandButton>
	</h:form>
		</div>		
	</div>

	<center>

	<a href="HelpInformation.pdf">Need Help?</a>
	</center>
	
</f:view>
</body>
