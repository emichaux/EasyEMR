<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">

<head>
<link href="./css/bootstrap.css" rel="stylesheet">  
<title>Easy EMR - Update My Info</title>
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
			<div style="float: right">
			<h:form>
						<p><h:commandLink tabindex="-1" action="#{loginBean.logout}">Log out</h:commandLink></p>
						<p><h:commandLink tabindex="-2" action="#{userService.switchToUpdateInfo}">Change My Password</h:commandLink></p>

				</h:form>
			</div>
			

			<div style="float: right">
			<h:form>
						<p><h:commandLink tabindex="-1" action="#{loginBean.logout}">Log out</h:commandLink></p>
						<p><h:commandLink tabindex="-2" action="#{userService.switchToUpdateInfo}">Change My Password</h:commandLink></p>

				</h:form>
			</div>
			
		</div>

<br><br><br>
<br><br><br>


		<div id="content">
			<div class="well container span5 center">

				<fieldset class="admin">
					
						<h4>Change My Password</h4>
						<h:form>
						<center>
							<table>
								<tr>
									<td><h5>New Password:</h5></td>
									<td><h:inputSecret id="password" style="width 150px"
											value="#{userService.myPassword}"></h:inputSecret></td>
								</tr>
								<tr>
									<td></td>
									<td><h:commandButton value="Update"
											action="#{userService.userChangeOwnPassword }"></h:commandButton>&nbsp;<h:commandButton
											value="Cancel" action="#{userService.cancel }"></h:commandButton></td>
								</tr>
							</table>
							<br>
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


