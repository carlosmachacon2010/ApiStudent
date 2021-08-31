<%@page import="com.liferay.training.students.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<%@ include file="/init.jsp"%>

<!-- student insertion form -->

<liferay-ui:success key="entryAdded" message="Entry added successfully" />
<liferay-ui:error key="error"
	message="the document number and type already exists!"></liferay-ui:error>
<portlet:defineObjects />
<portlet:actionURL name="createStudent" var="createStudent" />
<form method="post" action="${createStudent}">
	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputEmail4"><liferay-ui:message key="Name" /></label> <input
				type="text" class="form-control" name="<portlet:namespace/>name"
				pattern="[A-Za-z]+" placeholder="please enter text only" required>
		</div>
		<div class="form-group col-md-6">
			<label for="inputEmail4"><liferay-ui:message key="Last-Name" /></label>
			<input type="text" class="form-control"
				name="<portlet:namespace/>lastName" pattern="[A-Za-z]+"
				placeholder="please enter text only" required>
		</div>
	</div>

	<div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputEmail4"><liferay-ui:message
					key="Document-Number" /></label> <input type="text" class="form-control"
				name="<portlet:namespace/>documentNumber" pattern="[0-9]+"
				placeholder="please enter numbers only" required>
		</div>
		<div class="form-group col-md-6">
			<label for="inputPassword4"><liferay-ui:message
					key="Type-Document" /></label> <select class="form-control"
				name="<portlet:namespace/>typeDocument" required>
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
		<label for="inputAddress"><liferay-ui:message key="University" /></label>
		<input type="text" class="form-control"
			name="<portlet:namespace/>university"
			placeholder="please enter text only" required>
	</div>

	<button type="submit" class="btn btn-primary">
		<liferay-ui:message key="Create-Student" />
	</button>
</form>
<br />
<hr size="2px" color="#0B5FFF" />

<portlet:defineObjects />
<portlet:actionURL name="Search" var="Search" />
<form method="post" action="${Search}">
    <div class="form-row">
		<div class="form-group col-md-6">
			<label for="inputEmail4"><liferay-ui:message
					key="Document-Number" /></label> <input type="text" class="form-control"
				name="<portlet:namespace/>documentNumber" pattern="[0-9]+"
				placeholder="please enter numbers only" required>
		</div>
		<div class="form-group col-md-6">
			<label for="inputPassword4"><liferay-ui:message
					key="Type-Document" /></label> <select class="form-control"
				name="<portlet:namespace/>typeDocument" required>
				<option selected><liferay-ui:message key="Choose" /></option>
				<option><liferay-ui:message key="citi-card" /></option>
				<option><liferay-ui:message key="pasp" /></option>
				<option><liferay-ui:message key="IdeCrd" /></option>
				<option><liferay-ui:message key="fored" /></option>
				<option><liferay-ui:message key="special-y" /></option>
			</select>
		</div>
	</div>
    <div align="center">
        <button type="submit" class="btn btn-primary">
		<liferay-ui:message key="title-search" />
	    </button>
    </div>
	

</form>
<br />


<%
	List<Student> listaOrdenada = (List<Student>) renderRequest.getAttribute("listaOrdenada");
	String[] array = (String[]) renderRequest.getAttribute("ArrayString");
	List<Student> search=(List<Student>) request.getAttribute("search");
	
	
	if(search!=null){
%>
<!-- shows the search for the students -->
<table class="table">
	<thead class="thead-dark">
		<tr>
			
			<th scope="col"><liferay-ui:message key="Document-Number" /></th>
			<th scope="col"><liferay-ui:message key="Type-Document" /></th>
			<th scope="col"><liferay-ui:message key="Name" /></th>
			<th scope="col"><liferay-ui:message key="Last-Name" /></th>
			<th scope="col"><liferay-ui:message key="University" /></th>
		</tr>
	</thead>
	<tbody>
		<%
			for (int i = 0; i < search.size(); i++) {
		%>
		<tr>

			
			<td><%=search.get(i).getDocumentNumber()%></td>
			<td><%=search.get(i).getTypeDocument()%></td>
			<td><%=search.get(i).getName()%></td>
			<td><%=search.get(i).getLastName()%></td>
			<td><%=search.get(i).getUniversity()%></td>


		</tr>
		<%
			}
		%>
	</tbody>
</table>

<%}else{ %>
    <p>first perform the search</p>
<%} %>


<br />
<hr size="2px" color="#0B5FFF" />
<!-- I get the list of document types from the configuration interface-->
<div class="container">
<%for(int i=0;i<array.length;i++){ %>
  <div class="row">
    <div class="col-sm">
       <%=array[i]%> 
    </div>
  </div>
  <%}%>
</div>

<br />
<h1><liferay-ui:message key="order"/></h1>
<br />
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col"><liferay-ui:message key="id" /></th>
			<th scope="col"><liferay-ui:message key="Document-Number" /></th>
			<th scope="col"><liferay-ui:message key="Type-Document" /></th>
			<th scope="col"><liferay-ui:message key="Name" /></th>
			<th scope="col"><liferay-ui:message key="Last-Name" /></th>
			<th scope="col"><liferay-ui:message key="University" /></th>
		</tr>
	</thead>
	<tbody>
		<%
			for (int i = 0; i < listaOrdenada.size(); i++) {
		%>
		<tr>

			<th><%=listaOrdenada.get(i).getIdStudent()%></th>
			<td><%=listaOrdenada.get(i).getDocumentNumber()%></td>
			<td><%=listaOrdenada.get(i).getTypeDocument()%></td>
			<td><%=listaOrdenada.get(i).getName()%></td>
			<td><%=listaOrdenada.get(i).getLastName()%></td>
			<td><%=listaOrdenada.get(i).getUniversity()%></td>


		</tr>
		<%
			}
		%>
	</tbody>
</table>


