<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Form List</title>
<script src="<c:url value="/resources/js/jquery-3.1.0.js" />"></script> 
<style type="text/css">
.hidden {
 display: none;
}
.container {  height: 46px;}
</style>
<script>
	$(function() {

		$(".add-btn")
				.click(
						function() {

							var formID = $(this).parent().parent().find(
									">:first-child").text();
						
						if (confirm("Do you want to Load this form ?")) {

							document.getElementById('formMapper').action = '${pageContext.request.contextPath}/formload.jsf?id=0&bhanu='+formID;
							document.getElementById('formMapper').submit();

							}
						});

		$(".data-btn")
				.click(
						function() {

							var formID = $(this).parent().parent().find(
									">:first-child").text();
							if (confirm("Do you want to Load this form ?")) {

								document.getElementById('formMapper').action  = '${pageContext.request.contextPath}/list_Load.jsf?id=0&bhanu='
										+ formID;
								document.getElementById('formMapper').submit();

							}
						});

		$(".edit-form-btn")
				.click(
						function() {

							var formID = $(this).parent().parent().find(
									">:first-child").text();

							$('#opration_ids').val('1');

							if (confirm("Do you want to Load this form ?")) {

								document.getElementById('formMapper').action  = '${pageContext.request.contextPath}/edit_user_form_pre.jsf?id=0&form_id='
										+ formID;
								document.getElementById('formMapper').submit();

							}
						});

		$(".edit-add-form-btn")
				.click(
						function() {

							var formID = $(this).parent().parent().find(
									">:first-child").text();

							$('#opration_ids').val('5');

							if (confirm("Do you want to Load this form ?")) {

								document.getElementById('formMapper').action  = '${pageContext.request.contextPath}/edit_user_form_pre.jsf?id=0&form_id='
										+ formID;
								document.getElementById('formMapper').submit();

							}
						});

		$(".view-btn")
				.click(
						function() {
							var formID = $(this).parent().parent().find(
									">:first-child").text();

							$('#form_ids').val(formID);

							if (confirm("Do you want to View this form ?")) {

								document.getElementById('formMapper').action  = '${pageContext.request.contextPath}/form_view.jsf';
								document.getElementById('formMapper').submit();

							}
						});

		$(".del-btn")
				.click(
						function() {
							var formID = $(this).parent().parent().find(
									">:first-child").text();

							if (confirm("Do you want to Delete this form ?")) {

								document.getElementById('formMapper').action  = '${pageContext.request.contextPath}/delete_form.jsf?id=0&form_id='
										+ formID;
								document.getElementById('formMapper').submit();

							}
						});

		$('.table-btn')
				.click(
						function() {

							var formID = $(this).parent().parent().find(
									">:first-child").text();

							if (confirm("Do you want to see SQL table of this form ?")) {

								document.getElementById('formMapper').action  = '${pageContext.request.contextPath}/table_view.do?id=0&form_id='
										+ formID;
								document.getElementById('formMapper').submit();

							}
						});

	});
</script>
<body>
 <%@ include file="/WEB-INF/view/userHomeHeader.jsp" %> 
	<br/>
	<div class="container-fluid"
		style="width: 70%; font-size: large; font-weight: bold; color: #cccccc; border: 5px solid #cccccc; margin-left: 200px"
		align="center">User Form</div>


	<!-- <logic:messagesPresent message="true">
		<html:messages id="msg" message="true">
			<div style="color: green; margin: 15px 0 0 15px;">
				<bean:write name="msg" />
			</div>
		</html:messages>
	</logic:messagesPresent> -->
	<div style="width: 70%; margin-left: auto; margin-right: auto;">


		<display:table style="width:100%; border: 2px solid #cccccc; "
			name="${formMapper.menuMap}" pagesize="10" uid="objListFormInfo"
			requestURI="/formlist_pre.jsf"
			class="table table-striped table-bordered table-hover table-condensed"
			export="true">


			<display:column property="formId" title="" class="hidden"
				headerClass="hidden" media="html" />

			<display:column property="formName" title="Form Name"  />

			<display:column title="Add Data" media="html"
				 style="text-align:center;">

				<input type="button" style="width :90px;" value="Add Data"
					class="btn btn-large btn-info add-btn" />
			</display:column>


			<display:column title="Data List" media="html" 
				style="text-align : center;">

				<input type="button" style="width :80px;" value="Data List"
					class="btn btn-large btn-info data-btn" />
			</display:column>


			<c:if test="${objListFormInfo.findData eq false}">
				<display:column title="Form Edit" media="html" 
					style="text-align : center;">

					<input type="button" style="width :80px; " value="Form Edit"
						class="btn btn-mini btn-info edit-form-btn" />
				</display:column>
			</c:if>


			<c:if test="${objListFormInfo.findData eq true}">
				<display:column title="Data Analysis" media="html" 
					style="text-align : center;">

					<input type="button" style="width :80px; "  value="Data Analysis"
						class="btn btn-mini btn-info edit-add-form-btn" />
				</display:column>
			</c:if>

			<display:column title="Delete Form" media="html"
				style="text-align : center;">

				<input type="button" style="width :100px; " 
					value="Delete Form" class="btn btn-mini btn-info del-btn" />
			</display:column>


		</display:table>
	</div>

	<input type="hidden" name="id" id="iid" />
	<input type="hidden" name="form_id" id="formId" />

	<form:form action="/generate" styleId="struct-form" modelAttribute="formMapper" >
		<form:hidden path="jsonStructure" styleId="json-struct" />
		<form:hidden path="form_id" styleId="form_ids" />
		<form:hidden path="opration" styleId="opration_ids" />
	</form:form>

</body>

</html>