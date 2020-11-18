<%--
  Created by IntelliJ IDEA.
  User: sulem
  Date: 18.11.2020
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Choose Users</title>
</head>
<body>
<h1>Users</h1>
<c:url value="/createUser" var="createUser"/>
<a href="${createUser}">Add new User</a>

<hr/>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th colspan="3">action</th>
    </tr>
    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>
                <a href="/notes/${user.id}">Show notes</a>
                <a href="/editUser/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
