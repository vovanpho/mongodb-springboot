<%@page import="java.util.ArrayList"%>
<%@page import="com.example.mongodbspringboot.entity.GroseryItem"%>
<%@page import = "java.util.List" %>
<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<h3>List all grosery</h3>
    <div>
    	<%
			List<GroseryItem> groseries = (List<GroseryItem>) request.getAttribute("groseries");
		%>
		<table 
			style="
			width: 100%; 
			height: 40hv;
			
			"
		>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Category</th>
				<th>Action</th>
			<tr>
			<%for(GroseryItem groseryItem: groseries) {%>
    			<tr>
					<td><%=groseryItem.getId() %></td>
					<td><%=groseryItem.getName() %></td>
					<td><%=groseryItem.getQuatity() %></td>
					<td><%=groseryItem.getCategory() %></td>
					<td>
						<button></button>
						<button type="button">Update</button>
						<button type="button">Delete</button>
					</td>
				</tr>
    		<%}%>
		</table>
    </div>
    <h3>Add item grosery</h3>
    <form:form method="POST" action = "add-grosery" modelAttribute="grosery">
        <form:label path="id">Id</form:label>
        <form:input path="id" type="text"></form:input>
        <form:label path="name">Name</form:label>
        <form:input path="name" type="text"></form:input>
        <form:label path="quatity">Quatity</form:label>
        <form:input path="quatity" type="number"></form:input>
        <form:label path="category">Category</form:label>
        <form:input path="category" type="text"></form:input>
        <input type="submit" value="submit"/>
    </form:form>
   
</body>
<style>

</style>
</html>