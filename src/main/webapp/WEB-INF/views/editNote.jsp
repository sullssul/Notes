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


    <label for="title">Title:</label>
    <br/>
    <input type="title" name="title" id="title" value="${note.title}">
    <br/>
    <label for="content">Content:</label>
    <br/>
    <textarea  name="content" cols="50" id="content" rows="5">${note.content}</textarea>
    <br/>
    <input type="submit" value="Edit Note">
</form>

</body>
</html>
