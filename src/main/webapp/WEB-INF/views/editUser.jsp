<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<c:url value="/editUser" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${user.id}">

    <label for="name">name</label>
    <input type="text" name="name" id="name" value="${user.name}">

    <input type="submit" value="Edit User">
</form>
</body>
</html>