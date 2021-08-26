<%@page import="com.liferay.training.students.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ include file="/init.jsp"%>



<liferay-ui:success key="entryAdded" message="Entry added successfully" />
<liferay-ui:error key="error" message="the document number and type already exists!" ></liferay-ui:error>
<portlet:defineObjects />
<portlet:actionURL name="createStudent" var="createStudent"/>
<form method="post" action="${createStudent}">
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputEmail4"><liferay-ui:message key="Name" /></label> <input type="text"
				class="form-control" name="<portlet:namespace/>name" pattern="[A-Za-z]+" placeholder="please enter text only" required>
		</div>
		<div class="form-group col-md-6">
			<label for="inputEmail4"><liferay-ui:message key="Last-Name" /></label> <input type="text"
				class="form-control" name="<portlet:namespace/>lastName" pattern="[A-Za-z]+" placeholder="please enter text only" required>
		</div>
	</div>

	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputEmail4"><liferay-ui:message key="Document-Number" /></label> <input type="text"
				class="form-control" name="<portlet:namespace/>documentNumber" pattern="[0-9]+" placeholder="please enter numbers only" required>
		</div>
		<div class="form-group col-md-6">
			<label for="inputPassword4"><liferay-ui:message key="Type-Document" /></label> <select
				 class="form-control" name="<portlet:namespace/>typeDocument" required>
				<option selected><liferay-ui:message key="Choose" /></option>
				<option><liferay-ui:message key="citi-card" /></option>
				<option><liferay-ui:message key="pasp" /></option>
				<option><liferay-ui:message key="IdeCrd" /></option>
				<option><liferay-ui:message key="fored" /></option>
				<option><liferay-ui:message key="special-y" /></option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="inputAddress"><liferay-ui:message key="University" /></label> <input type="text"
			class="form-control"  name="<portlet:namespace/>university" placeholder="please enter text only" required >
	</div>

	<button type="submit" class="btn btn-primary"><liferay-ui:message key="Create-Student" /></button>
</form>