<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="./css/bootstrap.css" rel="stylesheet">  

<title>Easy EMR</title>
</head>

<body>

	<f:view>
	<div class="navbar navbar-fixed-top">
	  <div class="navbar-inner"> 
  		<div style="float: left">
  			<img src="./img/easyEmr_LOGO.png" height="80" width="110"> 
  		</div> 
	    <div class="container">  			
			<ul class="nav">
			</ul>
	    </div>  
	  </div>  
	</div> 
	
	<div style="float:right">

	</div>
	</div>
<br><br>
<br><br>
<br><br>
<div class="container">
		<div class="well form span6 center">
			<div class="form">
			
				<h:form>

				<center>
				<table>
				<tr>
				<b> Welcome to</b><img src="./img/easyEmr_LOGO.png" height="80" width="110"><br>Please Login Below <br> 
				</tr>
				<tr>
					<td><h:inputText style="width:150px" id="username" value="#{loginBean.systemUser.username}" /></td>
					<td><h:inputSecret style="width:150px" id="password" redisplay="false" value="#{loginBean.systemUser.password}" /></td>
				</tr>
				</table>
				</center>
				<div class="center">
					<h:commandButton id="submit" value="Login" action="#{loginBean.authenticate }" style="width:130px;height:40px"></h:commandButton><BR><BR>
					<h:outputText value="#{loginBean.loginResult}"></h:outputText>
					</div>
				</h:form>
			</div>
		</div>
		</div>
	</f:view>
</body>

</html>