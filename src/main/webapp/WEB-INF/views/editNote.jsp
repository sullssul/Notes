<%--
  Created by IntelliJ IDEA.
  User: sulem
  Date: 19.11.2020
  Time: 4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit note</title>
</head>
<body>

<c:url value="/editNote" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${note.id}">
    <input type="hidden" name="dateCreation" value="${note.dateCreation}">


    <label for="title">title</label>
    <input type="title" name="title" id="title" value="${note.title}">

    <label for="content">content</label>
    <input type="content" name="content" id="content" value="${note.content}">

    <input type="submit" value="Edit Note">
</form>

</body>
</html>
