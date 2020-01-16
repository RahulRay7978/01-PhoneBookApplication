<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>view contact</title>
</head>
<body bgcolor="yellow">

	<h2>
		<u><i style="color: cyan">ALL CONTACT</i></u>
	</h2>
	<script type="text/javascript">
		function deletePupup() {
			return confirm("Are y Sure,Do y want to delet it")
		}
	</script>
	<b style="color: red;"><a href="/">+Add New Contact</a></b>
	<table border="5" style="boder-color: bule;align="center">
		<tr>
			<th>Sl No.</th>
			<th>Contact Name</th>
			<th>Contact Email</th>
			<th>Phone No.</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${allList}" var="contact" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${contact.contactName}</td>
				<td>${contact.contactEmail}</td>
				<td>${contact.phno}</td>
				<td><a href="editContact?contactId=${contact.contactId}">Edit</a>
				<a href="deletContact?contactId=${contact.contactId}"
					onclick=" return deletePupup()">Delete</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>