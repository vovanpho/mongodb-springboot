<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.mongodbspringboot.entity.GroseryItem" %>
<%@ page import = "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

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
			height: 40hv;"
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
						<spring:url value="/grosery/{varid}" var="detail">
						   <spring:param name="varid" value="<%=groseryItem.getId()%>" />
						</spring:url>
						<a href="${detail}">Detail</a>
						<form:form method="DELETE" modelAttribute="id">
							<p class="submit">Delete <form:input type="submit" path="id" value="<%=groseryItem.getId()%>"/></p>
						</form:form>
					</td>
				</tr>
    		<%}%>
		</table>
		
    </div>
</body>
<style>

</style>
<script type="text/javascript">

</script>
</html>