<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="en-US">

<head>
<script type="text/javascript">
<!--
function bmi(weight, height) {

    bmindx=weight/eval(height*height);
    return bmindx;
}

function checkform(form) {

 if (form.weight.value==null||form.weight.value.length==0 || form.height.value==null||form.height.value.length==0){
      alert("\nPlease complete the form first");
      return false;
 }
 return true;

}

function computeform(form) {

 if (checkform(form)) {

 yourbmi=Math.round(bmi(form.weight.value *703, form.height.value));
 form.bmi.value=yourbmi;
 }
 return;
 
}




function calculateAge(a,b) {
	var today = new Date();
	var yyyy = today.getFullYear();
	document.getElementById(b).value = yyyy - document.getElementById(a).value;
}

function calculateYear(a,b) {
	var today = new Date();
	var yyyy = today.getFullYear();
	document.getElementById(a).value = yyyy - document.getElementById(b).value;
}
//-->
</script> 

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
                 		<h:outputLink tabindex="-3" id="link1" value="hipaaprivacy.pdf">
						    <h:outputText value="Hipaa Privacy Policy" />
						</h:outputLink>
						<h:commandLink tabindex="-1" action="#{loginBean.logout}"><h5 style="color:red">Log Out</h5></h:commandLink>
						<h:commandLink tabindex="-2" action="#{userService.switchToUpdateInfo}"><h5 style="color:gray">Change My Password</h5></h:commandLink>
				</h:form>
				</div>
			</div>			
	    </div>  				
				
			
<br><br>
<br><br>
<br><br>
			
				<div style="text-align:center" >
					<h:commandButton id="submit" style="width:120px;height:50px" value="Submit Record" action="#{encounterService.saveOrUpdateEncounter }" rendered="#{ not encounterService.newEncounter }"></h:commandButton>
					
					
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
							<td><h:inputText id="visitID" style="width:50px" value="#{encounterService.encounter.encounterID}" required="true"></h:inputText></td>
							<h:message for="visitID" style="color:red"> </h:message>							
						</tr>
						<tr>
							<td><strong>* First Name</strong></td>
							<td><h:inputText id="patientFirstName" style="width:130px" value="#{encounterService.patient.firstName }" required="true"></h:inputText></td>
							<h:message for="patientFirstName" style="color:red"> </h:message>
						</tr>
						<tr>
							<td><strong>* Last Name</strong></td>
							<td><h:inputText id="patientLastName" style="width:130px" value="#{encounterService.patient.lastName }" required="true"></h:inputText></td>
							<h:message for="patientLastName" style="color:red"> </h:message>
						</tr>
						<tr>
							<td><strong>Location</strong></td>
							<td><h:selectOneMenu style="width:125px" value="#{encounterService.patient.residence }">
							</h:selectOneMenu>

						</tr>
						<tr> <td><strong>Birthdate</strong></td></tr>
						<tr>
							
							<td><strong>Month</strong></td>
							<td>
		   						<select style="width:125px">
  									<option value="january">January</option>
  									<option value="february">February</option>
  									<option value="march">March</option>
  									<option value="april">April</option>
  									<option value="may">May</option>
  									<option value="june">June</option>
  									<option value="july">July</option>
  									<option value="august">August</option>
  									<option value="september">September</option>
  									<option value="october">October</option>
  									<option value="november">November</option>
  									<option value="december">December</option>
								</select>
								</td>
								</tr>
								<tr>
								<tr><td><strong>Day</strong></td><td><strong>Year</strong></td></tr>
								<tr>
								<td><h:inputText style = "width:30px" size="2" id="day"></h:inputText></td>
								<td><input style = "width:30px"  size="4" name="year" id="year" onblur="calculateAge('year','age')"></td>
							</tr>
							<tr>
								<td><strong>Age</strong></td>
								<td><input style = "width:30px" size="4" name="age" id="age" onblur="calculateYear('year', 'age')"></td>
								
							</tr>

						<tr>
							<td><strong>Gender</strong></td>
							<td><h:selectOneMenu style = "width:100px" id ="gender" value="#{encounterService.patient.gender }">
		   						<f:selectItem itemValue="Select" itemLabel="- Select -" />
		   						<f:selectItem itemValue="Male" itemLabel="Male" />
		   						<f:selectItem itemValue="Female" itemLabel="Female" />
								</h:selectOneMenu></td>
						</tr>
						<h:form>
						<tr>
							<td><strong>Height</strong></td>
							<td><h:inputText style = "width:30px" id="hin"  value="#{encounterService.vitals.height }"></h:inputText>in</td>
						</tr>
		
						<tr>
							<td><strong>Weight</strong></td>
							<td><h:inputText style = "width:30px" id="wlbs"  value="#{encounterService.vitals.weight }"></h:inputText>lbs</td>
						</tr>
						<tr>
						 
					<FORM NAME="BMI" method=POST>
					<TABLE  >
					<TR>
					<TD><DIV ALIGN=CENTER> Weight (lbs)</DIV></TD>
					<TD><DIV ALIGN=CENTER> Height (in)</DIV></TD>
					<TD><DIV ALIGN=CENTER> BMI</DIV></TD>
					</TR>
					<TR>
					<TD><INPUT TYPE=TEXT NAME=weight  SIZE=7 onFocus="this.form.weight.value=''"  ></TD>
					<TD><INPUT TYPE=TEXT NAME=height  SIZE=7 onFocus="this.form.height.value=''"></TD>
					<TD><INPUT TYPE=TEXT NAME=bmi     SIZE=7 ></TD>
					</TABLE>
					<INPUT TYPE="button" VALUE="Calculate" onClick="computeform(this.form)">
					
					</FORM>

						
					</table>
				</div>
				<div class="form span6">
					<h2>Vitals</h2>
					<table>
						<tr>
							<td><strong>Blood Pressure (mmHg)</strong></td>
							<td><h:inputText style = "width:60px" id="bpTop"  value="#{encounterService.vitals.systolicBP }" /> / <h:inputText style = "width:60px" id="bpBottom"  value="#{encounterService.vitals.diastolicBP }" /> <BR></td>
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
		
					</table>
					</div>
					</div>
					<div class="row">
					<div class="form span6">
					<h2>HPI</h2>
					<table>
					<tr>
					<strong style="text-align:center">Chief Complaint</strong><br>
					<h:inputTextarea style="width:300px" id="primaryComplaint" value="#{encounterService.encounter.chiefComplaint }" />
					</tr>
						<tr>
							<td><strong>Onset</strong></td>
							<td><h:inputText style = "width:50px" value="#{encounterService.encounter.onsetNumber }"></h:inputText>
								<h:selectOneMenu style="width:70px" value="#{encounterService.encounter.onsetUnit }">
									<f:selectItem itemValue="days" itemLabel="days"/>
									<f:selectItem itemValue="weeks" itemLabel="weeks"/>
									<f:selectItem itemValue="months" itemLabel="months"/>
									<f:selectItem itemValue="years" itemLabel="years"/>
									
								</h:selectOneMenu> ago</td>
						</tr>
		
						<tr>
							<td><strong>Severity</strong></td>
							<td><h:selectOneMenu style= "width:70px" value="#{encounterService.encounter.severity }">
								<f:selectItem itemValue="NA" itemLabel="NA"/>
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
							<td><strong>Provokes</strong></td>
							<td><h:inputText value="#{encounterService.encounter.provokes }"/></td>
						</tr>
						<tr>
							<td><strong>Palliates</strong></td>
							<td><h:inputText value="#{encounterService.encounter.palliates }"/></td>
						</tr>
						<tr>
							<td><strong>Time of Day</strong></td>
							<td><h:inputText value="#{encounterService.encounter.timeOfDay }"/></td>
						</tr>
		
						<tr>
							<td><strong>Other</strong></td>
							<td><h:inputText value="#{encounterService.encounter.other }"/></td>
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
								<td><h:inputText style="width:125px" value="#{encounterService.encounter.condition1 }"></h:inputText></td>
								<td><h:inputText style="width:125px" value="#{encounterService.encounter.medicationPrescribed1 }"></h:inputText></td>
							</tr>
		
							<tr>
								<td><h:inputText style="width:125px" value="#{encounterService.encounter.condition2 }"></h:inputText></td>
								<td><h:inputText style="width:125px" value="#{encounterService.encounter.medicationPrescribed2 }"></h:inputText></td>
							</tr>
		
							<tr>
								<td><h:inputText style="width:125px" value="#{encounterService.encounter.condition3 }"></h:inputText></td>
								<td><h:inputText style="width:125px" value="#{encounterService.encounter.medicationPrescribed3 }"></h:inputText></td>
							</tr>
		
							<tr>
								<td><h:inputText style="width:125px" value="#{encounterService.encounter.condition4 }"></h:inputText></td>
								<td><h:inputText style="width:125px" value="#{encounterService.encounter.medicationPrescribed4 }"></h:inputText></td>
							</tr>
		
							<tr>
								<td><h:inputText style="width:125px" value="#{encounterService.encounter.condition5 }"></h:inputText></td>
								<td><h:inputText style="width:125px" value="#{encounterService.encounter.medicationPrescribed5 }"></h:inputText></td>
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