<%--
  Created by IntelliJ IDEA.
  User: sulem
  Date: 18.11.2020
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>

<c:url value="/createUser" var="var"/>
<form action="${var}" method="POST">
    <label for="name">name</label>
    <input type="text" name="name" id="name" value="${user.name}">
    <input type="submit" value="Create user">
</form>

</body>
</html>
