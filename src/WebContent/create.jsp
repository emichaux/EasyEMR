<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="en-US">

<head>
	<link href="./css/bootstrap.css" rel="stylesheet">  
	<link rel="stylesheet" href="./css/jquery-ui-1.10.2.custom.css" />
  	<script src="./js/jquery-1.9.1.js"></script>
  	<script src="./js/jquery-ui-1.10.2.custom.js"></script>
  	
  	<script src="./js/jquery.maskedinput.js" type="text/javascript"></script>
  	
<script>
  $(function() {
    $( "#main\\:datepicker" ).datepicker();
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
jQuery(function($){
   $("#main\\:datepicker").mask("99/99/9999");
   $("#main\\:hin").mask("99.9");


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
			<h:form id="main">
				<div style="text-align:center" >
					<h:commandButton id="submit" style="width:120px;height:50px" onclick="alert('Patient Record Submitted');" value="Submit Record" action="#{encounterService.saveOrUpdateEncounter }" rendered="#{ not encounterService.newEncounter }"></h:commandButton>
					
					
					<h:commandButton id="newPatient" style="width:120px;height:50px" value="Reset Form" action="#{encounterService.resetRecord }" immediate="true"/>
					
					
					<h:commandButton id="startNew" style="width:120px;height:50px" value="Start New Encounter" action="#{encounterService.startEncounter}" rendered="#{encounterService.newEncounter}"></h:commandButton>
				</div>
				<br>

<div class="container well">
<div class="row">
<div class="form span6">
					<h2>General Information</h2>
					<table>
						<tr>
							<td><h5 style="color:red">* Card ID </h5></td>
							<td><h:inputText id="visitID" style="width:50px" value="#{encounterService.encounter.cardID}" title="Please type in the cardID, this is a required field." required="true"></h:inputText></td>
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
							<td><h:selectOneMenu title="Select patients residence" id ="location" value="#{encounterService.patient.residence }">
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
							<td><h:inputText id="datepicker" value = "#{encounterService.patient.birthDate }"></h:inputText><em>(MM/DD/YYYY)</em></td>
							
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
							<td><h:inputText id="hin" title="Please input patients height in inches." value="#{encounterService.vitals.height }"></h:inputText> in</td>
						</tr>
		
						<tr>
							<td><strong>Weight</strong></td>
							<td><h:inputText id="wlbs" title="Please input patients weight in pounds." value="#{encounterService.vitals.weight }"></h:inputText> lbs</td>
						</tr>
					</table>
				</div>
				<div class="form span6">
					<h2>Vitals</h2>
					<table>
						<tr>
							<td><strong>Blood Pressure (mmHg)</strong></td>
							<td><h:inputText style = "width:60px" id="bpTop"  value="#{encounterService.vitals.systolicBP }" >
								<f:validateLongRange minimum="50" maximum="200"/>
								</h:inputText>
								/ 
								<h:inputText style = "width:60px" id="bpBottom"  value="#{encounterService.vitals.diastolicBP }">
								<f:validateLongRange minimum="10" maximum="170"/>
								</h:inputText> 
								<BR></td>
						</tr>
		
						<tr>
							<td><strong>Heart Rate (bpm)</strong></td>
							<td><h:inputText style = "width:60px" id="heartrate"  value="#{encounterService.vitals.heartRate }" /><br></td>
						</tr>
		
						<tr> 
							<td><strong>Temperature (F)</strong></td>
							<td><h:inputText style = "width:60px" id="temperature"  value="#{encounterService.vitals.temperatureF }" /><br></td>
						</tr>
		
						<tr>
							<td><strong>Respirations (Breaths per Minute)</strong></td>
							<td><h:inputText style = "width:60px" id="respirations"  value="#{encounterService.vitals.respRate }" /><br></td>
						</tr>
		

		
						<tr>
							<td><strong>Blood Sample #</strong></td>
							<td><h:inputText  style="width:60px" value = "#{encounterService.vitals.bloodSampleID }"></h:inputText></td>
						</tr>
								
					</table>
					</div>
					</div>
					<div class="row">
					<div class="form span6">
					<h2>HPI</h2>
					<table>
					<tr>
					<strong style="text-align:center">Chief Complaint</strong>
					<br>
					<h:inputTextarea style="width:300px" title="Please type the patients chief complaint/-s." id="primaryComplaint" value="#{encounterService.encounter.chiefComplaint }" />
					</tr>
						<tr>
							<td><strong>Onset</strong></td>
							<td><h:inputText style = "width:50px" title="Please input length of time and choose days,weeks,months,years." value="#{encounterService.encounter.onsetNumber }"></h:inputText>
								<h:selectOneMenu style="width:70px" value="#{encounterService.encounter.onsetUnit }">
									<f:selectItem itemValue="days" itemLabel="days"/>
									<f:selectItem itemValue="weeks" itemLabel="weeks"/>
									<f:selectItem itemValue="months" itemLabel="months"/>
									<f:selectItem itemValue="years" itemLabel="years"/>									
								</h:selectOneMenu> ago</td>
						</tr>
		
						<tr>
							<td><strong>Severity</strong></td>
							<td><h:selectOneMenu style= "width:50px" value="#{encounterService.encounter.severity }">
								<f:selectItem itemValue="0" itemLabel=" - "/>
								<f:selectItem itemValue="1" itemLabel="1"/>
								<f:selectItem itemValue="2" itemLabel="2"/>
								<f:selectItem itemValue="3" itemLabel="3"/>
								<f:selectItem itemValue="4" itemLabel="4"/>
								<f:selectItem itemValue="5" itemLabel="5"/>
								<f:selectItem itemValue="6" itemLabel="6"/>
								<f:selectItem itemValue="7" itemLabel="7"/>
								<f:selectItem itemValue="8" itemLabel="8"/>
								<f:selectItem itemValue="9" itemLabel="9"/>
								<f:selectItem itemValue="10" itemLabel="10"/>
								<f:selectItem itemValue="-1" itemLabel="NA"/>
								
							</h:selectOneMenu></td>
						</tr>
		
						<tr>
							<td><strong>Radiation</strong></td>
							<td><h:inputText value="#{encounterService.encounter.radiation }"/></td>
						</tr>
		
						<tr>
							<td><strong>Quality</strong></td>
							<td><h:inputText value="#{encounterService.encounter.quality }"/></td>
						</tr>
		
						<tr>
							<td><strong>Provokes / Palliates</strong></td>
							<td><h:inputText value="#{encounterService.encounter.provokes }"/></td>
						</tr>
		
						<tr>
							<td><strong>Time of Day</strong></td>
							<td><h:inputText value="#{encounterService.encounter.timeOfDay }"/></td>
						</tr>
		
						<tr>
							<td><strong>Other</strong></td>
							<td><h:inputText value="#{encounterService.encounter.other }"/></td>
						</tr>
						<tr>
							<td><strong>ROS</strong></td>
							<td><h:inputTextarea value="#{encounterService.encounter.other }"/></td>
						</tr>
					</table>
				</div>
<div class="form span6">
					
					<h2>Complaints / Treatment</h2>
					<table>
					<tr>
					<strong style="text-align:center">Physical Examination</strong><br>
					<h:inputTextarea style="width:300px" id="physicalExamination" value="#{encounterService.encounter.overallImpression }" /><br>
					</tr>
					<tr>
					<strong style="text-align:center">Assessment</strong><br>
					<h:inputTextarea style="width:300px" id="assessment" value="#{encounterService.encounter.assessment }" /><br>
					</tr>
							<tr>
								<td><strong>Problem List</strong></td>
								<td><strong>Prescription / Treatment</strong></td>
							</tr>
		
							<tr>
								<td><h:inputText style="width:150px" value="#{encounterService.encounter.condition1 }"></h:inputText></td>
								<td><h:inputText style="width:150px" value="#{encounterService.encounter.medicationPrescribed1 }"></h:inputText></td>
							</tr>
		
							<tr>
								<td><h:inputText style="width:150px" value="#{encounterService.encounter.condition2 }"></h:inputText></td>
								<td><h:inputText style="width:150px" value="#{encounterService.encounter.medicationPrescribed2 }"></h:inputText></td>
							</tr>
		
							<tr>
								<td><h:inputText style="width:150px" value="#{encounterService.encounter.condition3 }"></h:inputText></td>
								<td><h:inputText style="width:150px" value="#{encounterService.encounter.medicationPrescribed3 }"></h:inputText></td>
							</tr>
		
							<tr>
								<td><h:inputText style="width:150px" value="#{encounterService.encounter.condition4 }"></h:inputText></td>
								<td><h:inputText style="width:150px" value="#{encounterService.encounter.medicationPrescribed4 }"></h:inputText></td>
							</tr>
		
							<tr>
								<td><h:inputText style="width:150px" value="#{encounterService.encounter.condition5 }"></h:inputText></td>
								<td><h:inputText style="width:150px" value="#{encounterService.encounter.medicationPrescribed5 }"></h:inputText></td>
							</tr>	
						<strong style="text-align:center">Treatment Given</strong><br>
						<h:inputTextarea style="width:300px" id="treatmentGiven" value="#{encounterService.encounter.medicalProcedures }" /><br>
						<strong>Family/Social History</strong><br>
						<h:inputTextarea style="width:300px" id="socialHistory" value="#{encounterService.patient.socialHistory }" />
					</table>
					</div>
					</div>
					</div>
				</h:form>
	</f:view>
</body>








