<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
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
	
</script>
</head>
<body>
	<h3 align="center">Ebook</h3>
	<div class="container">
		<form:form action="buySelectedItem" styleId="userModelId"
			modelAttribute="userModel">
			<form:hidden path="userId" />
			<div style="width: 70%; margin-left: auto; margin-right: auto;">

				<display:table style="width:100%; border: 2px solid #cccccc; "
					name="${userModel.catalogueModelList}" pagesize="10"
					uid="objListFormInfo" requestURI="/loadCatalogue"
					class="table table-bordered" export="false">

					<display:column property="bookID" title="" class="hidden"
						headerClass="hidden" media="html" />

					<display:column property="bookTitle" title="Book Title" />

					<display:column property="cost" title="Cost" />

					<display:column title="Quantity" property="quantity" />

					<display:column title="Buy Select" media="html">
						<input type="checkbox" name="selectedBooks"
							value="${objListFormInfo.bookID}" />
					</display:column>

				</display:table>
				<form:button value="Buy" class="btn-primary" id="update"
					style="width: 37%;">Buy selected Books</form:button>
			</div>

		</form:form>
	</div>
</body>
</html>