<%--
  Created by IntelliJ IDEA.
  User: sulem
  Date: 19.11.2020
  Time: 3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Note</title>
</head>
<body>
<c:url value="/createNote" var="var"/>

<form action="${var}" method="POST">
    <label for="title">title</label>
    <input type="title" name="title" id="title" value="${note.title}">

    <label for="content">content</label>
    <input type="content" name="content" id="content" value="${note.content}">
    <input type="submit" value="Create new Note">
</form>

</body>
</html>
