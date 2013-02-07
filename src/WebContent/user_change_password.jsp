<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">

<head>
<link rel="stylesheet" href="main.css" type="text/css" />
<title>Easy EMR - Update My Info</title>
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

		<div id="content">

			<div class="adminPanel">

				<fieldset class="admin">
					
						<h2>Update My Password</h2>
						<h:form>
						<center>
							<table>
								<tr>
									<td><h3>New Password:</h3></td>
									<td><h:inputSecret id="password"
											value="#{userService.myPassword}"></h:inputSecret></td>
								</tr>
								<tr>
									<td></td>
									<td><h:commandButton value="Update"
											action="#{userService.userChangeOwnPassword }"></h:commandButton>&nbsp;<h:commandButton
											value="Cancel" action="#{userService.cancel }"></h:commandButton></td>
								</tr>
							</table>

							<BR>
							<BR>
							<h:commandButton value="Back" action="#{userService.cancel }"></h:commandButton>
					</center>
					</h:form>
				</fieldset>
			</div>
			<center>
				<p>
					<a href="HelpInformation.pdf">Need Help?</a>
				</p>
			</center>
		</div>
	

	</f:view>
</body>

</html>


