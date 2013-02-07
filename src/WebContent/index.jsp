<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="main.css" type="text/css" />
<title>Easy EMR</title>
</head>

<body>

	<f:view>
	<div id= "navigation">
	<div style="float:left">
		&nbsp;<img src="img\logo_xl.png" height="60" width="180">
	</div>
	
	<div style="float:right">

	</div>
	</div>

		<div id="content">
			<div id="form" >
				<h1>Welcome!</h1>
				<h4>Please log in.</h4>

				<h:form>

				<center>
				<table>
				<tr>
					<td><center>Username</center></td>
					<td><center>Password</center></td>
				</tr>
				<tr>
					<td><h:inputText style="width:150px" id="username" value="#{loginBean.systemUser.username}" /></td>
					<td><h:inputSecret style="width:150px" id="password" redisplay="false" value="#{loginBean.systemUser.password}" /></td>
				</tr>
				</table>
				</center>
				
				
					<h:commandButton id="submit" value="Login" action="#{loginBean.authenticate }" style="width:130px;height:40px"></h:commandButton><BR><BR>
					<h:outputText value="#{loginBean.loginResult}"></h:outputText>
				</h:form>

			</div>

			<center>
				<p><a href="HelpInformation.pdf">Need Help?</a></p>
			</center>

		</div>
	</f:view>
</body>

</html>