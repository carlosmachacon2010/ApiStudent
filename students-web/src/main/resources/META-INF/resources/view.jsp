<%@page import="com.liferay.training.students.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ include file="/init.jsp"%>

<form>
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputEmail4">Name</label> <input type="text"
				class="form-control">
		</div>
		<div class="form-group col-md-6">
			<label for="inputEmail4">LastName</label> <input type="text"
				class="form-control">
		</div>
	</div>

	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputEmail4">Document Number</label> <input type="text"
				class="form-control">
		</div>
		<div class="form-group col-md-6">
			<label for="inputPassword4">Type Document</label> <select
				id="inputState" class="form-control">
				<option selected>Choose...</option>
				<option>citizenship card</option>
				<option>passport</option>
				<option>Identity Card</option>
				<option>special permission to stay</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="inputAddress">University</label> <input type="text"
			class="form-control" id="inputAddress">
	</div>

	<button type="submit" class="btn btn-primary">Create Student</button>
</form>