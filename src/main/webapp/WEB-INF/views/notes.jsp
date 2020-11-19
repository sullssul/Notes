<%--
  Created by IntelliJ IDEA.
  User: sulem
  Date: 18.11.2020
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Notes</title>
</head>

<style type="text/css">
    TABLE {
        width: 500px; /* Ширина таблицы */
        border-collapse: collapse; /* Убираем двойные линии между ячейками */
    }
    TD, TH {
        padding: 3px; /* Поля вокруг содержимого таблицы */
        border: 1px solid black; /* Параметры рамки */
    }
    TH {
        background: #b0e0e6; /* Цвет фона */
    }
</style>
<body>
<h1>All notes of ${user.name} </h1>

<c:url value="/createNote" var="CreateNote"/>
<a href="${CreateNote}">Add new Note</a>

<c:url value="/" var="users"/>
<a href="${users}">Back to users</a>

<hr/>
<table>
    <tr>
        <th>title&nbsp</th>
        <th>date of creation &nbsp</th>
        <th>date of last change &nbsp</th>
        <th colspan="3">action &nbsp&nbsp</th>
    </tr>
    <c:forEach var="note" items="${noteList}">
    <tr>
        <td>${note.title}</td>
        <td>${note.dateCreation}</td>
        <td>${note.dateLastEdit}</td>

        <td>
            <a href="/showNote/${note.id}">Show</a>
            <a href="/editNote/${note.id}">edit</a>
            <a href="/deleteNote/${note.id}">delete</a>
        </td>
    </tr>
    </c:forEach>
</body>
</html>
