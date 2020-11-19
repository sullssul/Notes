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
    <title>${note.title}</title>
</head>
<body>
<c:url value="/editNote/${note.id}" var="editNote"/>
<a href="${editNote}">Edit Note</a>
&nbsp
<c:url value="/deleteNote/${note.id}" var="deleteNote"/>
<a href="${deleteNote}">Delete Note</a>
&nbsp
<c:url value="/notes/${note.user.id}" var="notes"/>
<a href="${notes}">go to Notes</a>
<hr/>
<h1>Title:</h1>
<p>${note.title}</p>
<br/>
<h1>Text:</h1>
<p>${note.content}</p>

</body>
</html>
