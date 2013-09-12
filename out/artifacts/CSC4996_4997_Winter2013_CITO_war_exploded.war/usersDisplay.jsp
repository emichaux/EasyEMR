<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">

<head>
<link href="./css/bootstrap.css" rel="stylesheet">  
<title>Easy EMR - Admin</title>
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
				<h4>User List</h4>
				<h:dataTable value="#{userService.usersList}" var="user">
					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Username" />
							</h:column>
						</f:facet>
						<h:outputText value="#{user.username }" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="First Name" />
							</h:column>
						</f:facet>
						<h:outputText value="#{user.firstName}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Last Name" />
							</h:column>
						</f:facet>
						<h:outputText value="#{user.lastName}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:column>
								<h:outputText value="Actions" />
							</h:column>
						</f:facet>
						<h:panelGrid columns="2">
							<h:commandLink value="Select" action="#{userService.selectUser}">
								<f:setPropertyActionListener target="#{userService.newUser}"
									value="#{user}" />
							</h:commandLink>
						</h:panelGrid>
					</h:column>
				</h:dataTable>
				<a href="admin.jsp"><h5> Back to Admin Page</h5></a>
				</center>
			</div>
			</div>
		</h:form>
	</f:view>
</body>
</html>