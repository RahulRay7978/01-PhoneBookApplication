<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2>Contact Info</h2>
    ${succesResult}
    ${ErrorResult}
	<form:form action="contact" method="POST" modelAttribute="contact">
	<table  border="5" >
	<form:hidden path="contactId"/> 
	<tr>
		<td>Contact Name</td>
		<td><form:input path="ContactName" /></td>
	</tr>
	
	<tr>
	<td>Contact Email</td>
	<td><form:input path="ContactEmail" /></td>
	</tr>
	
	<tr>
	<td>Contact PhoNo</td>
	<td><form:input path="phno" /></td>
	</tr>
	
	<tr>
	<td><input type="submit"  value="Submit" /></td>
	<td><input type="reset"  value="Reset" /></td>
	</tr>
	<tr>
		<td> <a href="ViewContact">View All Contact</a></td>
	</tr>
	
	</table>
	</form:form> 
</body>
</html>