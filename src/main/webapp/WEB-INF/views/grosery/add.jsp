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
    <h3>Item grosery</h3>
    <form:form method="POST" modelAttribute="grosery">
        <form:label path="id" >Id</form:label>
        <form:input id="id" path="id" type="text" required="required"></form:input>
        <form:label path="name">Name</form:label>
        <form:input id="name" path="name" type="text"></form:input>
        <form:label path="quatity">Quatity</form:label>
        <form:input id="quatity" path="quatity" type="number"></form:input>
        <form:label path="category">Category</form:label>
        <form:input id="category" path="category" type="text"></form:input>
        <input type="submit" value="submit"/>
    </form:form>
</body>
<script type="text/javascript">
	const validationForm = () =>{

	}
</script>
</html>