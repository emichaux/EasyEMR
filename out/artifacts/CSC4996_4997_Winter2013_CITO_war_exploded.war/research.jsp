<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="main.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Export Data</title>
</head>
<body>
<!-- Created by Lev, uploaded by Marek -->
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

		<div id="content">

			<div id="form">
				<h:form>
					<h2>Reports</h2>
					<p>Export non-identifying information to CSV files</p>
					<h:commandButton action="#{researchReportsBean.generateConditionReport}" value="Encounter Report" style="width:200px;height:70px;margin-top:30px"></h:commandButton>
					<h:commandButton action="#{researchReportsBean.generateRxReport}" value="Rx Report" style="width:200px;height:70px;margin-top:30px"></h:commandButton>
				</h:form>
			</div>
			<center>
				<a href="HelpInformation.pdf">Need Help?</a>
			</center>

		</div>
	</f:view>
</body>
</html>
