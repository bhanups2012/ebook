<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebook User</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script type="text/javascript">	
		$(function() {

		$("#update")
				.click(
						function() {
						if (confirm("Do you want to update user detail ?")) {
							document.getElementById('userModelId').action = '${pageContext.request.contextPath}/updateUserDetail';
							document.getElementById('userModelId').submit();
							}
						});

		});
		</script>
</head>
<body>
	<h3 align="center">Ebook</h3>
	<div class="container">
		<form:form action="updateUserDetail" styleId="userModelId"
			modelAttribute="userModel">
			<h3 align="center">${userModel.msg}</h3>
			<form:hidden path="userId" />
			<table class="table table-bordered">
				<tr>
					<td><label>First Name : </label>
					<form:input path="firstName"  /></td>
					<td><label>Last Name : </label>
					<form:input path="lastName" /></td>
					<td><label>Email Address : </label>
					<form:input path="emailAddress" /></td>
					<td><form:button value="update" class="btn-primary" id="update">Update</form:button></td>
				</tr>
			</table>
			<table class="table table-bordered">
				<tr>
					<th align="center">Book Title</th>
					<th align="center">Price</th>
					<th align="center">Quantity</th>
					<th align="center">Purchase Date</th>
				</tr>
				<c:forEach items="${userModel.catalogueModelList}"	var="catalogueModel">
					<tr>
						<td>${catalogueModel.bookTitle }</td>
						<td>${catalogueModel.cost }</td>
						<td>${catalogueModel.quantity }</td>
						<td>${catalogueModel.timeOfPurchase }</td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
	</div>
</body>
</html>